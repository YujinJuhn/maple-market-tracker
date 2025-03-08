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

import java.sql.Date;

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

    @Column(name = "item_name", nullable = false, length = 40, columnDefinition = "CHAR(40)")
    private String itemName;

    @Column(name = "stat_type", nullable = false, length = 10, columnDefinition = "CHAR(10)")
    private String statType;

    @Column(name = "starforce", nullable = false, columnDefinition = "SMALLINT")
    private Short starforce;

    @Column(name = "stat_percent", nullable = false, columnDefinition = "SMALLINT")
    private Short statPercent;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "date", nullable = false, columnDefinition = "DATE")
    private Date date;
}
