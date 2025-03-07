package com.mmt.tracker.maple.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
@RequiredArgsConstructor
public class MapleApiClient {
    
    private final RestTemplate restTemplate;
    private final MapleApiConfig apiConfig;
    
    public String getCharacterOcid(String characterName) {
        String url = apiConfig.getBaseUrl() + "/id?character_name=" + characterName;
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-nxopen-api-key", apiConfig.getApiKey());
        
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        ResponseEntity<String> response = restTemplate.exchange(
            url,
            HttpMethod.GET,
            entity,
            String.class
        );
        
        return response.getBody();
    }
    
    public String getCharacterEquipment(String ocid, LocalDate date) {
        StringBuilder urlBuilder = new StringBuilder(apiConfig.getBaseUrl() + "/character/item-equipment?ocid=" + ocid);
        
        if (date != null) {
            String formattedDate = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            urlBuilder.append("&date=").append(formattedDate);
        }
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-nxopen-api-key", apiConfig.getApiKey());
        
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        ResponseEntity<String> response = restTemplate.exchange(
            urlBuilder.toString(),
            HttpMethod.GET,
            entity,
            String.class
        );
        
        return response.getBody();
    }
} 