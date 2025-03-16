package com.mmt.tracker.market.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "CHAR(40)")
    @NonNull
    private ItemName itemName;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "CHAR(10)")
    @NonNull
    private StatType statType;

    @Column(columnDefinition = "SMALLINT")
    @NonNull
    private Short starForce;

    @Column(columnDefinition = "SMALLINT")
    @NonNull
    private Short statPercent;

    @NonNull private Long amount;

    @NonNull private LocalDate date;

    public Price(
            ItemName itemName,
            StatType statType,
            Short starForce,
            Short statPercent,
            Long amount,
            LocalDate date) {
        this.itemName = itemName;
        this.statType = statType;
        this.starForce = starForce;
        this.statPercent = statPercent;
        this.amount = amount;
        this.date = date;
    }
}
