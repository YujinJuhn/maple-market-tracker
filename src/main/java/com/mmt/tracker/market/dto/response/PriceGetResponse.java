package com.mmt.tracker.market.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PriceGetResponse {
    private List<DatePrice> datePrices;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class DatePrice {
        private Date date;
        private long price;
    }
}
