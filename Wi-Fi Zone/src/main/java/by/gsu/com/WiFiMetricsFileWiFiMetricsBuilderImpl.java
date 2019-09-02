package by.gsu.com;

import by.gsu.com.Interface.WiFiMetricsBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class WiFiMetricsFileWiFiMetricsBuilderImpl implements WiFiMetricsBuilder {

    private static Logger LOG = Logger.getLogger(WiFiZoneMetricsCalculator.class.getName());
    /**
     * Variable of the class WiFiZoneMetricsCalculator for calling methods
     */
    WiFiZoneMetricsCalculator wiFiZoneMetricsCalculator;

    /**
     * wiFiZoneMetricsCalculator - variable of the class WiFiZoneMetricsCalculator
     * @param wiFiZoneMetricsCalculator
     */
    public WiFiMetricsFileWiFiMetricsBuilderImpl(WiFiZoneMetricsCalculator wiFiZoneMetricsCalculator) {
        this.wiFiZoneMetricsCalculator = wiFiZoneMetricsCalculator;
    }

    /**
     * Class for creating a file and recording results
     * @return null
     */
    public WiFiZoneMetricsCalculator build(){
        /**
         * The path to the file
         */
        File file = new File("src/main/resources/valuesResults.properties");
        try {
            /**
             * File creation
             */
            BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
            /**
             * Write to file
             */
            bw.write("Total system gain(Y) = " + wiFiZoneMetricsCalculator.calculate() + "\n" +
                    "Free space loss(FSL) = " + wiFiZoneMetricsCalculator.valuesFSL() + "\n" +
                    "The range of the Wi-Fi signal = " + wiFiZoneMetricsCalculator.length() + "\n");
            bw.flush();
            return wiFiZoneMetricsCalculator;
        } catch (IOException e) {
            LOG.info("Wrong path");
        }
        return null;
    }
}
