package com.mmt.tracker.market.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.mmt.tracker.advice.BadRequestException;

public enum ItemName {
    // 눈장식
    샤이니_레드_워리어_마이스터_심볼("샤이니 레드 워리어 마이스터 심볼"),
    샤이니_레드_마법사_마이스터_심볼("샤이니 레드 마법사 마이스터 심볼"),
    샤이니_레드_아쳐_마이스터_심볼("샤이니 레드 아쳐 마이스터 심볼"),
    샤이니_레드_스킬러_마이스터_심볼("샤이니 레드 스킬러 마이스터 심볼"),
    샤이니_레드_블레이드_마이스터_심볼("샤이니 레드 블레이드 마이스터 심볼"),
    트와일라이트_마크("트와일라이트 마크"),
    루즈_컨트롤_머신_마크("루즈 컨트롤 머신 마크"),

    // 얼굴장식
    블랙빈_마크("블랙빈 마크"),
    파풀라투스_마크("파풀라투스 마크"),
    마력이_깃든_안대("마력이 깃든 안대"),

    // 펜던트
    데이브레이크_펜던트("데이브레이크 펜던트"),
    도미네이터_펜던트("도미네이터 펜던트"),
    고통의_근원("고통의 근원"),

    // 벨트
    골든_클로버_벨트("골든 클로버 벨트"),
    타일런트_히아데스_벨트("타일런트 히아데스 벨트"),
    타일런트_헤르메스_벨트("타일런트 헤르메스 벨트"),
    타일런트_케이론_벨트("타일런트 케이론 벨트"),
    타일런트_리카온_벨트("타일런트 리카온 벨트"),
    타일런트_알테어_벨트("타일런트 알테어 벨트"),
    분노한_자쿰의_벨트("분노한 자쿰의 벨트"),
    몽환의_벨트("몽환의 벨트"),

    // 반지
    스칼렛_링("스칼렛 링"),
    마이스터_링("마이스터 링"),
    가디언_엔젤_링("가디언 엔젤 링"),
    여명의_가디언_엔젤_링("여명의 가디언 엔젤 링"),
    거대한_공포("거대한 공포"),

    // 귀걸이
    데아_시두스_이어링("데아 시두스 이어링"),
    지옥의_불꽃("지옥의 불꽃"),
    스칼렛_이어링("스칼렛 이어링"),
    샤먼_이어링("샤먼 이어링"),
    마이스터_이어링("마이스터 이어링"),
    오션_글로우_이어링("오션 글로우 이어링"),
    에스텔라_이어링("에스텔라 이어링"),
    커맨더_포스_이어링("커맨더 포스 이어링"),
    ;

    private final String value;

    ItemName(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static ItemName fromString(String text) {
        if (text == null) {
            throw new BadRequestException("Item name cannot be null");
        }

        String normalizedText = text.trim();

        for (ItemName item : ItemName.values()) {
            if (item.value.equals(normalizedText)) {
                return item;
            }
        }

        String enumStyleText = normalizedText.replace(" ", "_").toUpperCase();
        try {
            return ItemName.valueOf(enumStyleText);
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Unknown item name: " + text);
        }
    }
}
