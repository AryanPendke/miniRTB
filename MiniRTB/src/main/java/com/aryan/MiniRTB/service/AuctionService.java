package com.aryan.MiniRTB.service;

import com.aryan.MiniRTB.entity.AdRequest;
import com.aryan.MiniRTB.entity.Campaign;

public interface AuctionService{
    Campaign findWinningCampaign(AdRequest adRequest);
}
