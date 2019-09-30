package by.gsu.com;

import by.gsu.com.Interface.WiFiMetricsFactory;
import com.sun.glass.ui.Window;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class reads values and writes to variables
 */
public class WiFiMetricsFilePropertiesFactoryImpl implements WiFiMetricsFactory {

    private static final Logger LOG = Logger.getLogger(WiFiMetricsFilePropertiesFactoryImpl.class.getName());
    private String filePath;

    public WiFiMetricsFilePropertiesFactoryImpl(String filePath) {
        this.filePath = filePath;
    }

    public Optional<WiFiZoneMetricsCalculator> getInstance() {

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {

            Properties properties = new Properties();

            properties.load(fileInputStream);

            Double transmitterPower = getKey(properties, "transmitterPower");
            Double transmitAntennaGain = getKey(properties, "transmitAntennaGain");
            Double receiveAntennaGain = getKey(properties, "receiveAntennaGain");
            Double receiverSensitivity = getKey(properties, "receiverSensitivity");
            Double frequency = getKey(properties, "frequency");
            Double signalLoss1 = getKey(properties, "signalLoss1");
            Double signalLoss2 = getKey(properties, "signalLoss2");

            return Optional.of(new WiFiZoneMetricsCalculator(transmitterPower, transmitAntennaGain, receiveAntennaGain, receiverSensitivity, frequency, signalLoss1, signalLoss2));
        } catch (IOException e) {
            LOG.log(Level.SEVERE,"File not found. Check that the file name is correct", e);
        } finally {
            LOG.info("Reading of values is performed");
        }
        return Optional.empty();
    }

    private Double getKey(Properties properties, String key) {
        return Double.valueOf(properties.getProperty(key));
    }
}
