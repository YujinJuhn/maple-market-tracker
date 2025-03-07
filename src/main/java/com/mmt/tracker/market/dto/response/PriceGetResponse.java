package com.mmt.tracker.market.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PriceGetResponse {
    private List<DatePrice> datePrices;
    
    @Getter
    @Setter
    public static class DatePrice {
        private LocalDate date;
        private int price;
    }
}
