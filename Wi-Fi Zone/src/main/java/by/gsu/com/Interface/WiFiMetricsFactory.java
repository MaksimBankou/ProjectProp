package by.gsu.com.Interface;

import by.gsu.com.WiFiZoneMetricsCalculator;

import java.util.Optional;

/**
 * This interface creates a method to reads the file
 */
public interface WiFiMetricsFactory {
    /**
     * This method to reads the file
     * @return instance WiFiZoneMetricsCalculator
     */
    Optional <WiFiZoneMetricsCalculator> getInstance();
}
