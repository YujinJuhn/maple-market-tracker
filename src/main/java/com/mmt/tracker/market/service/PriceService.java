package com.mmt.tracker.market.service;

import com.mmt.tracker.market.domain.Price;
import com.mmt.tracker.market.dto.request.PricePostRequest;
import com.mmt.tracker.market.dto.response.DatePriceResponse;
import com.mmt.tracker.market.dto.response.DatePriceResponses;
import com.mmt.tracker.market.dto.response.PricePostResponse;
import com.mmt.tracker.market.repository.PriceRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public DatePriceResponses getPrices(
            String itemName, String statType, short starforce, short statPercent
    ) {
        List<Price> prices = priceRepository.findPricesByItemNameAndStatTypeAndStarForceAndStatPercent(
                itemName,
                statType,
                starforce,
                statPercent
        );
        return convertPriceToResponse(prices);
    }

    private DatePriceResponses convertPriceToResponse(List<Price> prices) {
        return new DatePriceResponses(prices.stream()
                .map(price -> new DatePriceResponse(price.getDate(), price.getAmount()))
                .toList());
    }

    @Transactional
    public PricePostResponse postPrice(PricePostRequest request) {
        Price price = new Price(
                request.itemName(),
                request.statType(),
                request.starForce(),
                request.statPercent(),
                request.price(),
                request.date() != null ? request.date() : LocalDateTime.now()
        );
        priceRepository.save(price);
        PricePostResponse response = new PricePostResponse();
        response.setMessage("시세 등록 완료");
        return response;
    }
}
