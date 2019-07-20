package by.gsu.com;

import java.io.*;
import java.util.Properties;


public class Runner {

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("G:\\Программирование\\Проекты\\Wi-Fi Zone\\src\\main\\java\\by\\gsu\\com\\values.properties");
        Properties properties = new Properties();

        properties.load(fis);

        Double transmitterPower = Double.valueOf(properties.getProperty("transmitterPower"));
        Double transmitAntennaGain = Double.valueOf(properties.getProperty("transmitAntennaGain"));
        Double receiveAntennaGain = Double.valueOf(properties.getProperty("receiveAntennaGain"));
        Double receiverSensitivity = Double.valueOf(properties.getProperty("receiverSensitivity"));
        Double frequency = Double.valueOf(properties.getProperty("frequency"));
        Double signalLoss1 = Double.valueOf(properties.getProperty("signalLoss1"));
        Double signalLoss2 = Double.valueOf(properties.getProperty("signalLoss2"));

        Values values = new Values(transmitterPower, transmitAntennaGain, receiveAntennaGain, receiverSensitivity , frequency, signalLoss1, signalLoss2);

        System.out.println(values.calculate());
        System.out.println(values.valuesFSL());
        System.out.println(values.length());


        /*CsvToBean csv = new CsvToBean();
        CSVReader reader = new CSVReader(new FileReader("G:\\Программирование\\Проекты\\Wi-Fi Zone\\src\\main\\java\\by\\gsu\\com\\values.csv"));
        List list = csv.parse(generatColumMapping(), reader);
            Values values = (Values) list.iterator().next();
            System.out.println(values);
            System.out.println("Y = " + values.calculate());
            System.out.println("FSL = " + values.valuesFSL());
            System.out.println("D = " + values.length());

    }
    @SuppressWarnings({"rawtypes", "unchecked"})
    private static MappingStrategy generatColumMapping()
    {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Values.class);
        String[] columns = new String[] {"transmitterPower", "transmitAntennaGain", "receiveAntennaGain",
                "receiverSensitivity","frequency", "signalLoss1", "signalLoss2"};
        strategy.setColumnMapping(columns);
        return strategy;
*/
    }

}
