package com.devstaff.delegate;

import com.devstaff.dao.PlantedDAO;
import com.devstaff.entity.Planted;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class PlantedDelegate {

    public double getPlantedArea (final String farmerCode, final String season, final String farmFieldCode) {
        AtomicReference<Double> totalPlantedArea = new AtomicReference<>((double) 0);
        final PlantedDAO plantedDAO = new PlantedDAO();
        final List<Planted> plantedList = plantedDAO.getPlantedData(farmerCode, season, farmFieldCode);
        if (CollectionUtils.isNotEmpty(plantedList)) {
            plantedList.stream().forEach(p -> {
                totalPlantedArea.set(p.getTotalAreaPlanted() + totalPlantedArea.get());
            });
        }
        return totalPlantedArea.get();
    }

    public List<String> getCropsPlanted (final String farmerCode, final String season, final String farmFieldCode) {
        List<String> plantedCrops = new ArrayList<>();
        final PlantedDAO plantedDAO = new PlantedDAO();
        final List<Planted> plantedList = plantedDAO.getPlantedData(farmerCode, season, farmFieldCode);
        if (CollectionUtils.isNotEmpty(plantedList)) {
            plantedList.stream().forEach(p -> {
                plantedCrops.add(p.getCrops() != null ? p.getCrops().getName() : "");
            });
        }

        return plantedCrops;
    }

    public double getTotalPlantedWeight (final String farmerCode, final String season, final String farmFieldCode) {
        AtomicReference<Double> totalWeight = new AtomicReference<>((double) 0);
        final PlantedDAO plantedDAO = new PlantedDAO();
        final List<Planted> plantedList = plantedDAO.getPlantedData(farmerCode, season, farmFieldCode);
        if (CollectionUtils.isNotEmpty(plantedList)) {
            plantedList.stream().forEach(p -> {
                totalWeight.set(p.getTotalExpectedWeight() + totalWeight.get());
            });
        }
        return totalWeight.get();
    }
}
