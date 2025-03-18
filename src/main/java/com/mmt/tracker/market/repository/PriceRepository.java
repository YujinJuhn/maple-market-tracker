package com.mmt.tracker.market.repository;

import com.mmt.tracker.market.domain.Price;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findPricesByItemNameAndStatTypeAndStarForceAndStatPercent(
            String itemName, String statType, Short starForce, Short statPercent);
}
