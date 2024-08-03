package com.devstaff.controller;

import com.devstaff.delegate.HarvestDelegate;
import com.devstaff.delegate.PlantedDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class HarvestedController {
    @Autowired
    private HarvestDelegate harvestDelegate;

    /**
     * Retrieve total harvest in tons by a farmer in a given season and farm field.
     *
     * @param farmerCode  Farmer Code
     * @param season  Season when crop was planted
     * @param farmFieldCode  Farm Code where crop is planted
     */
    @GetMapping("/harvested/totalWeight/{farmerCode}/{season}/{farmFieldCode}")
    public double getTotalHarvestWeight(@PathVariable(value = "farmerCode") String farmerCode,
                                        @PathVariable(value = "season") String season,
                                        @PathVariable(value = "farmFieldCode") String farmFieldCode) {
        return harvestDelegate.getTotalHarvestWeight(farmerCode, season, farmFieldCode);
    }
}
