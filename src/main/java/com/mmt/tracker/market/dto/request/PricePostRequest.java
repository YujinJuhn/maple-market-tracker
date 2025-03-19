package com.mmt.tracker.market.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class PricePostRequest {
    private String itemName;
    private String statType;
    private short starforce;
    private short statPercent;
    private long price;
    private Date date;
}
