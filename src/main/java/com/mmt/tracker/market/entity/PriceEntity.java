package com.mmt.tracker.market.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(
        name = "prices",
        uniqueConstraints =
                @UniqueConstraint(
                        columnNames = {
                            "item_name",
                            "stat_type",
                            "starforce",
                            "stat_percent",
                            "date"
                        }),
        indexes = @Index(name = "idx_item_percent", columnList = "item_name, stat_percent"))
@Getter
@Setter
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "item_name", nullable = false)
    private String itemName;

    @Column(name = "stat_type", nullable = false)
    private String statType;

    @Column(name = "starforce", nullable = false)
    private int starforce;

    @Column(name = "stat_percent", nullable = false)
    private int statPercent;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "date", nullable = false)
    private LocalDate date;
}
