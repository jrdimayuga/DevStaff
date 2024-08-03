package com.devstaff.delegate;

import com.devstaff.dao.HarvestedDAO;
import com.devstaff.dao.PlantedDAO;
import com.devstaff.entity.Harvest;
import com.devstaff.entity.Planted;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class HarvestDelegate {
    public double getTotalHarvestWeight (final String farmerCode, final String season, final String farmFieldCode) {
        AtomicReference<Double> totalWeight = new AtomicReference<>((double) 0);
        final HarvestedDAO harvestedDAO = new HarvestedDAO();
        final List<Harvest> harvestList = harvestedDAO.getHarvestedData(farmerCode, season, farmFieldCode);
        if (CollectionUtils.isNotEmpty(harvestList)) {
            harvestList.stream().forEach(p -> {
                totalWeight.set(p.getTotalWeight() + totalWeight.get());
            });
        }
        return totalWeight.get();
    }
}
