package com.mmt.tracker.market.dto.request;

import com.mmt.tracker.market.domain.ItemName;
import com.mmt.tracker.market.domain.StatType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceGetRequest {
    private Short statPercent;
    private ItemName itemName;
    private StatType statType;
    private Short starForce;
}
