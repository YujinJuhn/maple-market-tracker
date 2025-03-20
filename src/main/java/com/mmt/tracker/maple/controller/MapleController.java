package com.mmt.tracker.maple.controller;

import com.mmt.tracker.maple.dto.request.CharacterEquipmentRequest;
import com.mmt.tracker.maple.dto.response.CharacterEquipmentResponse;
import com.mmt.tracker.maple.service.MapleService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.RequiredArgsConstructor;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@Tag(name = "메이플스토리 API", description = "메이플스토리 캐릭터 정보 조회 API")
@RestController
@RequestMapping("/api/maple")
@RequiredArgsConstructor
public class MapleController {

    private final MapleService mapleService;

    @Operation(
            summary = "캐릭터 장비 정보 조회",
            description = "캐릭터 이름을 입력하여 해당 캐릭터의 장비 정보를 조회합니다. 조회 기준일을 지정할 수 있습니다.")
    @GetMapping("/character/equipment")
    public ResponseEntity<CharacterEquipmentResponse> getCharacterEquipment(
            @Parameter(description = "캐릭터 이름", example = "") @RequestParam String characterName,
            @Parameter(description = "조회 기준일 (KST, YYYY-MM-DD)", example = "")
                    @RequestParam(required = false)
                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                    LocalDate date)
            throws Exception {

        CharacterEquipmentRequest request = new CharacterEquipmentRequest();
        request.setCharacterName(characterName);
        request.setDate(date);

        return ResponseEntity.ok(mapleService.getCharacterEquipment(request));
    }
}
