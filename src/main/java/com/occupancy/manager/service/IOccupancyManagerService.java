package com.occupancy.manager.service;

import com.occupancy.manager.dto.OccupancyUsageRequest;
import com.occupancy.manager.dto.OccupancyUsageResponse;

/**
 * 
 * @author Ramachandra
 *
 */
public interface IOccupancyManagerService {

	OccupancyUsageResponse calcuateOccupancy(OccupancyUsageRequest occupancyUsageRequest);
}
