package by.gsu.com;

/**
 * This class considers the length of the Wi-Fi coverage area
 */
public class WiFiZoneMetricsCalculator {

    public static final int DENOMINATOR = 20;
    public static final int DIVIDEND = 33;
    public static final int DENOMINATOR_1 = 22;
    public static final int SOM = 10;
    private Double transmitterPower;
    private Double transmitAntennaGain;
    private Double receiveAntennaGain;
    private Double receiverSensitivity;
    private Double signalLoss1;
    private Double signalLoss2;
    private Double frequency;

    public WiFiZoneMetricsCalculator(Double transmitterPower, Double transmitAntennaGain, Double receiveAntennaGain, Double receiverSensitivity, Double signalLoss1, Double signalLoss2, Double frequency) {
        this.transmitterPower = transmitterPower;
        this.transmitAntennaGain = transmitAntennaGain;
        this.receiveAntennaGain = receiveAntennaGain;
        this.receiverSensitivity = receiverSensitivity;
        this.signalLoss1 = signalLoss1;
        this.signalLoss2 = signalLoss2;
        this.frequency = frequency;
    }

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
     *
     * @return the result of total system gain
     */

    public double calculate() {
        return transmitterPower + transmitAntennaGain + receiveAntennaGain - receiverSensitivity - signalLoss1 - signalLoss2;
    }

    /**
     * Free space loss calculation method (FSL)
     *
     * @return result of free space loss
     */
    public double valuesFSL() {
        return calculate() - SOM;
    }

    /**
     * Method of calculating the range of Wi-Fi signal
     *
     * @return the result of the range of the Wi-Fi signal
     */
    public double length() {
        double exponent = (valuesFSL() / DENOMINATOR - DIVIDEND / DENOMINATOR_1 - Math.log10(frequency));
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