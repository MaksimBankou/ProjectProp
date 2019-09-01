package by.gsu.com;

import java.io.*;
import java.util.Properties;
import java.util.logging.Logger;

public class Runner {

    public static final String FILE_PATH = "G:\\Программирование\\Проекты\\Новая папка\\ProjectProp\\Wi-Fi Zone\\src\\main\\resources\\values.properties";
    private static Logger LOG = Logger.getLogger(WiFiZoneMetricsCalculator.class.getName());

    public static void main(String[] args) {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(FILE_PATH);

            Properties properties = new Properties();

            properties.load(fis);

            Double transmitterPower = Double.valueOf(properties.getProperty("transmitterPower"));
            Double transmitAntennaGain = Double.valueOf(properties.getProperty("transmitAntennaGain"));
            Double receiveAntennaGain = Double.valueOf(properties.getProperty("receiveAntennaGain"));
            Double receiverSensitivity = Double.valueOf(properties.getProperty("receiverSensitivity"));
            Double frequency = Double.valueOf(properties.getProperty("frequency"));
            Double signalLoss1 = Double.valueOf(properties.getProperty("signalLoss1"));
            Double signalLoss2 = Double.valueOf(properties.getProperty("signalLoss2"));

            WiFiZoneMetricsCalculator metricsCalculator = new WiFiZoneMetricsCalculator(transmitterPower, transmitAntennaGain, receiveAntennaGain, receiverSensitivity, frequency, signalLoss1, signalLoss2);

            LOG.info("Value of calculate: " + metricsCalculator.calculate());
            LOG.info("Value of free space loss: " + metricsCalculator.valuesFSL());
            LOG.info("Value of the range of the Wi-Fi signal: " + metricsCalculator.length());
        } catch (FileNotFoundException e) {
            LOG.info("File not found");
        } catch (IOException e) {
            LOG.info("Download failed");
        }
    }

}
