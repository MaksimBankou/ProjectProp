package by.gsu.com;

import by.gsu.com.Interface.WiFiMetricsBuilder;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class creating file and recording values
 */
public class WiFiMetricsFilePropertiesBuilderImpl implements WiFiMetricsBuilder {

    private static final String FILE_PATH = "src/main/resources/valuesResults.properties";
    private static final Logger LOG = Logger.getLogger(WiFiMetricsFilePropertiesBuilderImpl.class.getName());

    final WiFiZoneMetricsCalculator wiFiZoneMetricsCalculator;

    public WiFiMetricsFilePropertiesBuilderImpl(WiFiZoneMetricsCalculator wiFiZoneMetricsCalculator) {
        this.wiFiZoneMetricsCalculator = wiFiZoneMetricsCalculator;
    }

    public void build(){
        if (wiFiZoneMetricsCalculator != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
                bw.write("Total system gain(Y) = " + wiFiZoneMetricsCalculator.calculate() + "\n" +
                        "Free space loss(FSL) = " + wiFiZoneMetricsCalculator.valuesFSL() + "\n" +
                        "The range of the Wi-Fi signal = " + wiFiZoneMetricsCalculator.length() + "\n");
                bw.flush();
            } catch (IOException e) {
                LOG.log(Level.SEVERE,"File could not be created path specified incorrectly", e);
            } finally {
                LOG.info("Completed");
            }
        }else {
            LOG.warning("In some case calculator is null");
        }
    }
}
