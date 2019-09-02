package by.gsu.com;

import by.gsu.com.Interface.WiFiMetricsFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

public class WiFiMetricsFilePropertiesFactoryImpl implements WiFiMetricsFactory {

    /**
     * Variable through which the file path is passed
     */
    public String filePath;
    /**
     * Сlass call logger
     */
    private static Logger LOG = Logger.getLogger(WiFiZoneMetricsCalculator.class.getName());

    /**
     * filePath - The path to the file
     * @param filePath
     */
    public WiFiMetricsFilePropertiesFactoryImpl(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Method reading values from a file
     * @return null
     */
    public WiFiZoneMetricsCalculator getInstance() {
        FileInputStream fis = null;

        try {

            fis = new FileInputStream(filePath);

            Properties properties = new Properties();
            /**
             * Loading data from file
             */
            properties.load(fis);
            /**
             * Data transfer
             */
            Double transmitterPower = Double.valueOf(properties.getProperty("transmitterPower"));
            Double transmitAntennaGain = Double.valueOf(properties.getProperty("transmitAntennaGain"));
            Double receiveAntennaGain = Double.valueOf(properties.getProperty("receiveAntennaGain"));
            Double receiverSensitivity = Double.valueOf(properties.getProperty("receiverSensitivity"));
            Double frequency = Double.valueOf(properties.getProperty("frequency"));
            Double signalLoss1 = Double.valueOf(properties.getProperty("signalLoss1"));
            Double signalLoss2 = Double.valueOf(properties.getProperty("signalLoss2"));

            return new WiFiZoneMetricsCalculator(transmitterPower, transmitAntennaGain, receiveAntennaGain, receiverSensitivity, frequency, signalLoss1, signalLoss2);
        } catch (IOException e) {
            LOG.info("File not found");
        }
        return null;
    }
}
