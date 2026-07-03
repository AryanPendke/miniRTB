package com.aryan.MiniRTB.service;

import com.aryan.MiniRTB.entity.AdRequest;
import com.aryan.MiniRTB.entity.Campaign;

public interface ImpressionService {

    void recordImpression(Campaign campaign, AdRequest adRequest);

}