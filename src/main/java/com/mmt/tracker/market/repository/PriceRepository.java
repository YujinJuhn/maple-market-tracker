package com.mmt.tracker.market.repository;

import com.mmt.tracker.market.domain.ItemName;
import com.mmt.tracker.market.domain.Price;
import com.mmt.tracker.market.domain.StatType;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findPricesByItemNameAndStatTypeAndStarForceAndStatPercent(
            ItemName itemName, StatType statType, Short starForce, Short statPercent);
}
