package com.mmt.tracker.market.dto.request;

import com.mmt.tracker.market.domain.ItemName;
import com.mmt.tracker.market.domain.StatType;

import java.time.LocalDate;

public record PricePostRequest(
        ItemName itemName,
        StatType statType,
        Short starForce,
        Short statPercent,
        Long price,
        LocalDate date) {}
