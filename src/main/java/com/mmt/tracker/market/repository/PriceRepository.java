package com.mmt.tracker.market.repository;

import com.mmt.tracker.market.domain.Price;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price, Long> {

    List<Price> findPricesByItemNameAndStatTypeAndStarForceAndStatPercent(
            String itemName,
            String statType,
            Short starForce,
            Short statPercent
    );
}
