package by.gsu.com;

import java.io.*;
import java.util.Properties;

public class Runner {

    public static final String FILE_PATH = "G:\\Программирование\\Проекты\\Wi-Fi Zone\\src\\main\\java\\by\\gsu\\com\\values.properties";

    public static void main(String[] args) throws IOException {
        
        FileInputStream fis = new FileInputStream(FILE_PATH);
        Properties properties = new Properties();

        properties.load(fis);

        Double transmitterPower = Double.valueOf(properties.getProperty("transmitterPower"));
        Double transmitAntennaGain = Double.valueOf(properties.getProperty("transmitAntennaGain"));
        Double receiveAntennaGain = Double.valueOf(properties.getProperty("receiveAntennaGain"));
        Double receiverSensitivity = Double.valueOf(properties.getProperty("receiverSensitivity"));
        Double frequency = Double.valueOf(properties.getProperty("frequency"));
        Double signalLoss1 = Double.valueOf(properties.getProperty("signalLoss1"));
        Double signalLoss2 = Double.valueOf(properties.getProperty("signalLoss2"));

        WiFiZoneMetricsCalculator metricsCalculator = new WiFiZoneMetricsCalculator(transmitterPower, transmitAntennaGain, receiveAntennaGain, receiverSensitivity , frequency, signalLoss1, signalLoss2);

        System.out.println(metricsCalculator.calculate());
        System.out.println(metricsCalculator.valuesFSL());
        System.out.println(metricsCalculator.length());
    }

}
