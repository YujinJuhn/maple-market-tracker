package com.mmt.tracker.market.dto.request;

import com.mmt.tracker.market.domain.ItemName;
import com.mmt.tracker.market.domain.StatType;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record PricePostRequest(
        @NotNull ItemName itemName,
        @NotNull StatType statType,
        @NotNull @Min(0) @Max(30) Short starForce,
        @NotNull @Min(0) @Max(100) Short statPercent,
        Long price,
        LocalDate date) {}
