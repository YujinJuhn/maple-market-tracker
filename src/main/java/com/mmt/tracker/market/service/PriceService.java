package com.mmt.tracker.market.service;

import com.mmt.tracker.market.dto.request.PricePostRequest;
import com.mmt.tracker.market.dto.response.PriceGetResponse;
import com.mmt.tracker.market.dto.response.PricePostResponse;
import com.mmt.tracker.market.entity.PriceEntity;
import com.mmt.tracker.market.repository.PriceRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PriceService {
    private final PriceRepository priceRepository;

    public PriceService(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    public PriceGetResponse getPrices(
            String itemName, String statType, short starforce, short statPercent) {
        List<PriceEntity> prices =
                priceRepository.findPrices(itemName, statType, starforce, statPercent);
        return convertToPriceGetResponse(prices);
    }

    private PriceGetResponse convertToPriceGetResponse(List<PriceEntity> prices) {
        PriceGetResponse response = new PriceGetResponse();
        response.setDatePrices(
                prices.stream()
                        .map(
                                price ->
                                        new PriceGetResponse.DatePrice(
                                                price.getDate(), price.getPrice()))
                        .collect(Collectors.toList()));
        return response;
    }

    @Transactional
    public PricePostResponse postPrice(PricePostRequest request) {
        PriceEntity price = new PriceEntity();
        price.setItemName(request.getItemName());
        price.setStatType(request.getStatType());
        price.setStarforce(request.getStarforce());
        price.setStatPercent(request.getStatPercent());
        price.setPrice(request.getPrice());
        price.setDate(
                request.getDate() != null
                        ? request.getDate()
                        : java.sql.Date.valueOf(LocalDate.now()));
        priceRepository.save(price);
        PricePostResponse response = new PricePostResponse();
        response.setMessage("시세 등록 완료");
        return response;
    }
}
