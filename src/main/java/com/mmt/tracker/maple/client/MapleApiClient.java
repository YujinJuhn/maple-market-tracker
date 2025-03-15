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

    private static final String NXOPEN_API_KEY_HEADER = "x-nxopen-api-key";

    @Value("${maple.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final MapleApiClientConfiguration apiConfig;

    public String getCharacterOcid(String characterName) {
        String url =
                MapleApiUrl.BASE_URL.getUrl()
                        + MapleApiUrl.GET_CHARACTER_OCID_BY_NAME.getUrl().formatted(characterName);

        HttpEntity<String> entity = buildHttpEntity();

        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        throw new BadRequestException("존재하지 않는 사용자");
    }

    public String getCharacterEquipment(String ocid, LocalDate date) {
        StringBuilder urlBuilder = new StringBuilder(MapleApiUrl.BASE_URL.getUrl());
        urlBuilder.append(MapleApiUrl.GET_CHARACTER_EQUIPMENT_BY_OCID.getUrl().formatted(ocid));

        if (date != null) {
            String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            urlBuilder.append("&date=").append(formattedDate);
        }

        HttpEntity<String> entity = buildHttpEntity();
        String url = urlBuilder.toString();
        ResponseEntity<String> response =
                restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }

        throw new BadRequestException("존재하지 않는 사용자");
    }

    private HttpEntity<String> buildHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(NXOPEN_API_KEY_HEADER, apiKey);
        return new HttpEntity<>(headers);
    }
}
