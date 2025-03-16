package com.mmt.tracker.market.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.mmt.tracker.advice.BadRequestException;

public enum StatType {
    STR("STR"),
    DEX("DEX"),
    INT("INT"),
    LUK("LUK"),
    ALL("올스탯"),
    HP("HP"),
    ;

    private final String value;

    StatType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static StatType fromString(String text) {
        if (text == null) {
            throw new BadRequestException("Stat type cannot be null");
        }

        for (StatType type : StatType.values()) {
            if (type.value.equalsIgnoreCase(text)) {
                return type;
            }
        }
        throw new BadRequestException("Unknown stat type: " + text);
    }
}
