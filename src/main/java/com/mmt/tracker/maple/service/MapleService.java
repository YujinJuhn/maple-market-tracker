package com.mmt.tracker.maple.service;

import com.mmt.tracker.maple.client.MapleApiClient;
import com.mmt.tracker.maple.dto.request.CharacterEquipmentRequest;
import com.mmt.tracker.maple.dto.response.CharacterOcidResponse;
import com.mmt.tracker.maple.dto.response.CharacterEquipmentResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MapleService {
    
    private final MapleApiClient mapleApiClient;
    private final ObjectMapper objectMapper;
    
    public CharacterEquipmentResponse getCharacterEquipment(CharacterEquipmentRequest request) throws Exception {
        // 캐릭터 이름으로 OCID 조회
        String ocidResponse = mapleApiClient.getCharacterOcid(request.getCharacterName());
        CharacterOcidResponse ocidData = objectMapper.readValue(ocidResponse, CharacterOcidResponse.class);
        
        // OCID로 장비 정보 조회
        String equipmentResponse = mapleApiClient.getCharacterEquipment(ocidData.getOcid(), request.getDate());
        return objectMapper.readValue(equipmentResponse, CharacterEquipmentResponse.class);
    }
} 