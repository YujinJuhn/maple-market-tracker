package com.mmt.tracker.maple.client;

import com.mmt.tracker.advice.BadRequestException;
import com.mmt.tracker.config.MapleApiClientConfiguration;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class MapleApiClient {

    private static final String API_BASE_URL = "https://open.api.nexon.com/maplestory/v1";
    private static final String CHARACTER_ITEM_EQUIPMENT_OCID = "/character/item-equipment?ocid=";

    @Value("${maple.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final MapleApiClientConfiguration apiConfig;

    public String getCharacterOcid(String characterName) {
        String url = API_BASE_URL + "/id?character_name=" + characterName;

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-nxopen-api-key", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        if(response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        throw new BadRequestException("존재하지 않는 사용자");
    }

    public String getCharacterEquipment(String ocid, LocalDate date) {
        StringBuilder urlBuilder =
                new StringBuilder(
                        API_BASE_URL + CHARACTER_ITEM_EQUIPMENT_OCID + ocid);

        if (date != null) {
            String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            urlBuilder.append("&date=").append(formattedDate);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-nxopen-api-key", apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response =
                restTemplate.exchange(urlBuilder.toString(), HttpMethod.GET, entity, String.class);

        return response.getBody();
    }
}
