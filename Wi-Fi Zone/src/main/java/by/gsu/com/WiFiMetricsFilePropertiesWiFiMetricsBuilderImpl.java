package by.gsu.com;
/*
This class creating file and recording values
 */
import by.gsu.com.Interface.WiFiMetricsBuilder;
import java.io.*;
import java.util.logging.Logger;

public class WiFiMetricsFilePropertiesWiFiMetricsBuilderImpl implements WiFiMetricsBuilder {

    private static Logger LOG = Logger.getLogger(WiFiZoneMetricsCalculator.class.getName());
    private static File FILE_PATH = new File("src/main/resources/valuesResults.properties");
    /**
     * Variable of the class WiFiZoneMetricsCalculator for calling methods
     */
    WiFiZoneMetricsCalculator wiFiZoneMetricsCalculator;

    /**
     * wiFiZoneMetricsCalculator - variable of the class WiFiZoneMetricsCalculator
     * @param wiFiZoneMetricsCalculator
     */
    public WiFiMetricsFilePropertiesWiFiMetricsBuilderImpl(WiFiZoneMetricsCalculator wiFiZoneMetricsCalculator) {
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

        try {
            /**
             * File creation
             */
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH,true));
            /**
             * Write to file
             */
            bw.write("Total system gain(Y) = " + wiFiZoneMetricsCalculator.calculate() + "\n" +
                    "Free space loss(FSL) = " + wiFiZoneMetricsCalculator.valuesFSL() + "\n" +
                    "The range of the Wi-Fi signal = " + wiFiZoneMetricsCalculator.length() + "\n");
            bw.flush();
        } catch (IOException e) {
            LOG.info("File could not be created path specified incorrectly");
        } finally {
            LOG.info("Completed");
        }
        return null;
    }
}
