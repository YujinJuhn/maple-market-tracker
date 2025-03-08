package com.mmt.tracker.maple.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CharacterEquipmentResponse {
    private String date;
    private String character_gender;
    private String character_class;
    private Integer preset_no;
    private List<Equipment> item_equipment;

    @Getter
    @Setter
    public static class Equipment {
        private String item_equipment_part;
        private String item_equipment_slot;
        private String item_name;
        private String item_icon;
        private String item_description;
        private String item_shape_name;
        private String item_shape_icon;
        private String item_gender;
        private ItemOption item_total_option;
        private ItemOption item_base_option;
        private String potential_option_grade;
        private String additional_potential_option_grade;
        private String potential_option_flag;
        private String potential_option_1;
        private String potential_option_2;
        private String potential_option_3;
        private String additional_potential_option_flag;
        private String additional_potential_option_1;
        private String additional_potential_option_2;
        private String additional_potential_option_3;
        private Integer equipment_level_increase;
        private ItemOption item_exceptional_option;
        private ItemOption item_add_option;
        private Integer growth_exp;
        private Integer growth_level;
        private String scroll_upgrade;
        private String cuttable_count;
        private String golden_hammer_flag;
        private String scroll_resilience_count;
        private String scroll_upgradeable_count;
        private String soul_name;
        private String soul_option;
        private ItemOption item_etc_option;
        private String starforce;
        private String starforce_scroll_flag;
        private ItemOption item_starforce_option;
        private Integer special_ring_level;
        private String date_expire;
    }

    @Getter
    @Setter
    public static class ItemOption {
        private String str;
        private String dex;

        @JsonProperty("int")
        private String int_;

        private String luk;
        private String max_hp;
        private String max_mp;
        private String attack_power;
        private String magic_power;
        private String armor;
        private String speed;
        private String jump;
        private String boss_damage;
        private String ignore_monster_armor;
        private String all_stat;
        private String damage;
        private Integer equipment_level_decrease;
        private String max_hp_rate;
        private String max_mp_rate;
        private Integer base_equipment_level;
        private Integer exceptional_upgrade;
    }
}
