package com.mmt.tracker.market.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PriceGetRequest {
    private short statPercent;
    private String itemName;
    private String statType;
    private short starforce;
}
