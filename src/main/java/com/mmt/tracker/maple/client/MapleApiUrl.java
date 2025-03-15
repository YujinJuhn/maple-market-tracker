package com.mmt.tracker.maple.client;

public enum MapleApiUrl {
    BASE_URL("https://open.api.nexon.com/maplestory/v1"),
    GET_CHARACTER_OCID_BY_NAME("/id?character_name=%s"),
    GET_CHARACTER_EQUIPMENT_BY_OCID("/character/item-equipment?ocid=%s"),
    ;

    private final String url;

    MapleApiUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
