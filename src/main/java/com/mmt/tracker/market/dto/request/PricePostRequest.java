package com.mmt.tracker.market.dto.request;

import java.time.LocalDateTime;

public record PricePostRequest(
        String itemName,
        String statType,
        short starForce,
        short statPercent,
        long price,
        LocalDateTime date
) {

}
