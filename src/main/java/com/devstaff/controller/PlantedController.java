package com.devstaff.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.devstaff.delegate.PlantedDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PlantedController {
    @Autowired
    private PlantedDelegate plantedDelegate;

    /**
     * Retrieve total planted area in acres by a farmer in a given season and farm field.
     *
     * @param farmerCode  Farmer Code
     * @param season  Season when crop was planted
     * @param farmFieldCode  Farm Code where crop is planted
     */
    @GetMapping("/planted/area/{farmerCode}/{season}/{farmFieldCode}")
    public double getPlantedArea(@PathVariable(value = "farmerCode") String farmerCode,
                                 @PathVariable(value = "season") String season,
                                 @PathVariable(value = "farmFieldCode") String farmFieldCode) {
        return plantedDelegate.getPlantedArea(farmerCode, season, farmFieldCode);
    }

    /**
     * Retrieve list of crops planted by a farmer in a given season and farm field.
     *
     * @param farmerCode  Farmer Code
     * @param season  Season when crop was planted
     * @param farmFieldCode  Farm Code where crop is planted
     */
    @GetMapping("/planted/crops/{farmerCode}/{season}/{farmFieldCode}")
    public List<String> getPlantedCrops(@PathVariable(value = "farmerCode") String farmerCode,
                                 @PathVariable(value = "season") String season,
                                 @PathVariable(value = "farmFieldCode") String farmFieldCode) {
        return plantedDelegate.getCropsPlanted(farmerCode, season, farmFieldCode);
    }

    /**
     * Retrieve total weight in tons planted by a farmer in a given season and farm field.
     *
     * @param farmerCode  Farmer Code
     * @param season  Season when crop was planted
     * @param farmFieldCode  Farm Code where crop is planted
     */
    @GetMapping("/planted/totalWeight/{farmerCode}/{season}/{farmFieldCode}")
    public double getPlantedWeight(@PathVariable(value = "farmerCode") String farmerCode,
                                        @PathVariable(value = "season") String season,
                                        @PathVariable(value = "farmFieldCode") String farmFieldCode) {
        return plantedDelegate.getTotalPlantedWeight(farmerCode, season, farmFieldCode);
    }
}
