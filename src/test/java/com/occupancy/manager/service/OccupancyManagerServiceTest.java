package com.occupancy.manager.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.occupancy.manager.factory.OccupancyUsageRequestFactory;

/**
 * 
 * @author Ramachandra
 *
 */
class OccupancyManagerServiceTest {

	@InjectMocks
	OccupancyManagerService occupancyManagerService;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testCalcuateOccupancyFor3Premium3EconomyRooms() {
		final var occupancyUsageResponse = occupancyManagerService
				.calcuateOccupancy(OccupancyUsageRequestFactory.createThreePremiumAndThreeEconomyRooms());
		assertEquals("3 (EUR 738)", occupancyUsageResponse.getPremiumUsage(),
				"Expected the premium usage values to match");
		assertEquals("3 (EUR 167)", occupancyUsageResponse.getEconomyUsage(),
				"Expected the economy usage values to match");
	}
	
	@Test
	void testCalcuateOccupancyFor7Premium1EconomyRoom() {
		final var occupancyUsageResponse = occupancyManagerService
				.calcuateOccupancy(OccupancyUsageRequestFactory.createSevenPremiumAndOneEconomyRoom());
		assertEquals("7 (EUR 1153)", occupancyUsageResponse.getPremiumUsage(),
				"Expected the premium usage values to match");
		assertEquals("1 (EUR 45)", occupancyUsageResponse.getEconomyUsage(),
				"Expected the economy usage values to match");
	}
	
	@Test
	void testCalcuateOccupancyFor2Premium7EconomyRooms() {
		final var occupancyUsageResponse = occupancyManagerService
				.calcuateOccupancy(OccupancyUsageRequestFactory.createTwoPremiumAndSevenEconomyRooms());
		assertEquals("2 (EUR 583)", occupancyUsageResponse.getPremiumUsage(),
				"Expected the premium usage values to match");
		assertEquals("4 (EUR 189)", occupancyUsageResponse.getEconomyUsage(),
				"Expected the economy usage values to match");
	}
	
	@Test
	void testCalcuateOccupancyFor7Premium5EconomyRooms() {
		final var occupancyUsageResponse = occupancyManagerService
				.calcuateOccupancy(OccupancyUsageRequestFactory.createSevenPremiumAndFiveEconomyRooms());
		assertEquals("6 (EUR 1054)", occupancyUsageResponse.getPremiumUsage(),
				"Expected the premium usage values to match");
		assertEquals("4 (EUR 189)", occupancyUsageResponse.getEconomyUsage(),
				"Expected the economy usage values to match");
	}
}