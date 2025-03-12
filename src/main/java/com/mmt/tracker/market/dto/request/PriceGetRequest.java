package com.mmt.tracker.market.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceGetRequest {
    private Short statPercent;
    private String itemName;
    private String statType;
    private Short starForce;
}
