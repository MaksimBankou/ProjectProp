package by.gsu.com;

public class WiFiZoneMetricsCalculator {
    /**
     * Variables and constants
     */
    private Double transmitterPower;
    private Double transmitAntennaGain;
    private Double receiveAntennaGain;
    private Double receiverSensitivity ;
    private Double signalLoss1;
    private Double signalLoss2;
    private Double frequency;
    public static final int DENOMINATOR = 20;
    public static final int DIVIDEND = 33;
    public static final int DENOMINATOR_1 = 22;
    public static final int SOM = 10;
    /**
     * Constructor
     * @param transmitterPower - transmitter power
     * @param transmitAntennaGain - the gain of the transmitting antenna
     * @param receiveAntennaGain - the gain of the receiving antenna
     * @param receiverSensitivity - receiver sensitivity at this speed
     * @param signalLoss1 - signal loss in the coaxial cable and connectors, transmission path
     * @param signalLoss2 - signal loss in coaxial cable and receiving path connectors
     * @param frequency - central frequency of the channel on which the communication system operates
     */
    public WiFiZoneMetricsCalculator( Double transmitterPower, Double transmitAntennaGain, Double receiveAntennaGain, Double receiverSensitivity, Double signalLoss1, Double signalLoss2, Double frequency){
        this.transmitterPower = transmitterPower;
        this.transmitAntennaGain = transmitAntennaGain;
        this.receiveAntennaGain = receiveAntennaGain;
        this.receiverSensitivity = receiverSensitivity;
        this.signalLoss1 = signalLoss1;
        this.signalLoss2 = signalLoss2;
        this.frequency = frequency;
    }

    /**
     * The resulting values
     * @return
     */
    public Double getTransmitterPower() {
        return transmitterPower;
    }

    public Double getTransmitAntennaGain() {
        return transmitAntennaGain;
    }

    public Double getReceiveAntennaGain() {
        return receiveAntennaGain;
    }

    public Double getReceiverSensitivity() {
        return receiverSensitivity;
    }

    public Double getSignalLoss1() {
        return signalLoss1;
    }

    public Double getSignalLoss2() {
        return signalLoss2;
    }

    public Double getFrequency() {
        return frequency;
    }

    /**
     * The method considers the total system gain (Y)
     * @return
     */

    public double calculate(){
        return transmitterPower + transmitAntennaGain + receiveAntennaGain - receiverSensitivity - signalLoss1 - signalLoss2;
    }

    /**
     * Free space loss calculation method (FSL)
     * @return
     */
    public double valuesFSL(){
        return calculate() - SOM;
    }

    /**
     * Method of calculating the range of Wi-Fi signal
     * @return
     */
    public double length(){
        double exponent = (valuesFSL()/DENOMINATOR - DIVIDEND/DENOMINATOR_1 - Math.log10(frequency));
        return Math.pow(SOM, exponent);
    }

    @Override
    public String toString() {
        return "Values " +
                "transmitterPower = " + transmitterPower +
                ", transmitAntennaGain = " + transmitAntennaGain +
                ", receiveAntennaGain = " + receiveAntennaGain +
                ", receiverSensitivity = " + receiverSensitivity +
                ", signalLoss1 = " + signalLoss1 +
                ", signalLoss2 = " + signalLoss2 +
                ", frequency = " + frequency;
    }
}

