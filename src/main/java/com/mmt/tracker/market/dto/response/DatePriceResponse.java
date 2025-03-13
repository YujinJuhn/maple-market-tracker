package com.mmt.tracker.market.dto.response;

import java.time.LocalDateTime;

public record DatePriceResponse(
        LocalDateTime date,
        Long amount
) {

}
