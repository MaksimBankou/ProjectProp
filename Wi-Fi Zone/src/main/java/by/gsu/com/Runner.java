package by.gsu.com;

import by.gsu.com.Interface.WiFiMetricsBuilder;
import by.gsu.com.Interface.WiFiMetricsFactory;

public class Runner {
    public static void main(String[] args) {
        WiFiMetricsFactory wiFiMetricsFactory = new WiFiMetricsFilePropertiesFactoryImpl("src/main/resources/values.properties");
        WiFiMetricsBuilder wiFiMetricsBuilder = new WiFiMetricsFilePropertiesWiFiMetricsBuilderImpl(wiFiMetricsFactory.getInstance());
        wiFiMetricsBuilder.build();

    }

}
