package com.mmt.tracker.market.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
//@Table(
//        name = "prices",
//        uniqueConstraints =
//                @UniqueConstraint(
//                        columnNames = {
//                            "item_name",
//                            "stat_type",
//                            "starForce",
//                            "stat_percent",
//                            "date"
//                        }),
//        indexes = @Index(name = "idx_item_percent", columnList = "item_name, stat_percent"))
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "CHAR(40)")
    @NonNull
    private String itemName;

    @Column(columnDefinition = "CHAR(10)")
    @NonNull
    private String statType;

    @Column(columnDefinition = "SMALLINT")
    @NonNull
    private Short starForce;

    @Column(columnDefinition = "SMALLINT")
    @NonNull
    private Short statPercent;

    @NonNull
    private Long amount;

    @Column(name = "date")
    @NonNull
    private LocalDateTime date;

    public Price(String itemName, String statType, short starforce, short statPercent, long amount, LocalDateTime date) {
        this.itemName = itemName;
        this.statType = statType;
        this.starForce = starforce;
        this.statPercent = statPercent;
        this.amount = amount;
        this.date = date;
    }
}
