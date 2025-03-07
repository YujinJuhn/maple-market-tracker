package com.mmt.tracker.maple.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Schema(description = "캐릭터 장비 정보 조회 요청")
public class CharacterEquipmentRequest {
    
    @Schema(description = "캐릭터 이름", example = "캐릭터이름")
    private String characterName;
    
    @Schema(description = "조회 기준일 (KST, YYYY-MM-DD)", example = "2024-03-07")
    private LocalDate date;
} 