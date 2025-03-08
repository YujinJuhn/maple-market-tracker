package com.mmt.tracker.market.repository;

import com.mmt.tracker.market.entity.PriceEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

    @Query(
            "SELECT p FROM Price p "
                    + "WHERE p.itemName = :itemName "
                    + "AND p.statType = :statType "
                    + "AND p.starforce = :starforce "
                    + "AND p.statPercent = :statPercent "
                    + "ORDER BY p.date DESC")
    List<PriceEntity> findPrices(
            @Param("itemName") String itemName,
            @Param("statType") String statType,
            @Param("starforce") int starforce,
            @Param("statPercent") int statPercent);
}
