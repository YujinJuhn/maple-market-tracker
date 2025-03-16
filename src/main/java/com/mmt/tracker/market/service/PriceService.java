package com.mmt.tracker.market.service;

import com.mmt.tracker.market.domain.ItemName;
import com.mmt.tracker.market.domain.Price;
import com.mmt.tracker.market.domain.StatType;
import com.mmt.tracker.market.dto.request.PricePostRequest;
import com.mmt.tracker.market.dto.response.DatePriceResponse;
import com.mmt.tracker.market.dto.response.DatePriceResponses;
import com.mmt.tracker.market.dto.response.PricePostResponse;
import com.mmt.tracker.market.repository.PriceRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class PriceService {

    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Transactional(readOnly = true)
    public DatePriceResponses getPrices(
            ItemName itemName, StatType statType, Short starForce, Short statPercent) {
        List<Price> prices =
                priceRepository.findPricesByItemNameAndStatTypeAndStarForceAndStatPercent(
                        itemName, statType, starForce, statPercent);
        return convertPriceToResponse(prices);
    }

    private DatePriceResponses convertPriceToResponse(List<Price> prices) {
        return new DatePriceResponses(
                prices.stream()
                        .map(price -> new DatePriceResponse(price.getDate(), price.getAmount()))
                        .toList());
    }

    @Transactional
    public PricePostResponse postPrice(PricePostRequest request) {
        Price price =
                new Price(
                        request.itemName(),
                        request.statType(),
                        request.starForce(),
                        request.statPercent(),
                        request.price(),
                        request.date() != null ? request.date() : LocalDate.now());
        priceRepository.save(price);
        PricePostResponse response = new PricePostResponse();
        response.setMessage("시세 등록 완료");
        return response;
    }
}
