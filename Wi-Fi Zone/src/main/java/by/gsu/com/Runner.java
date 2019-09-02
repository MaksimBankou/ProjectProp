package by.gsu.com;

import by.gsu.com.Interface.WiFiMetricsBuilder;
import by.gsu.com.Interface.WiFiMetricsFactory;

import java.io.*;
import java.util.Properties;
import java.util.logging.Logger;

public class Runner {
    public static void main(String[] args) {
        WiFiMetricsFactory wiFiMetricsFactory = new WiFiMetricsFilePropertiesFactoryImpl("src/main/java/resources/values.properties");
        WiFiMetricsBuilder wiFiMetricsBuilder = new WiFiMetricsFileWiFiMetricsBuilderImpl(wiFiMetricsFactory.getInstance());
        wiFiMetricsBuilder.build();
    }

}
