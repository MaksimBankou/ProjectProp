package by.gsu.com;


import java.io.Serializable;

public class Values implements Serializable {

    private Double transmitterPower;
    private Double transmitAntennaGain;
    private Double receiveAntennaGain;
    private Double receiverSensitivity ;
    private Double signalLoss1;
    private Double signalLoss2;
    private Double frequency;
    private double fsl;
    public static final int A = 20;
    public static final int B = 33;
    public static final int C = 20;
    public static final int SOM = 10;

    public Values( Double transmitterPower, Double transmitAntennaGain, Double receiveAntennaGain, Double receiverSensitivity, Double signalLoss1, Double signalLoss2, Double frequency){
        this.transmitterPower = transmitterPower;
        this.transmitAntennaGain = transmitAntennaGain;
        this.receiveAntennaGain = receiveAntennaGain;
        this.receiverSensitivity = receiverSensitivity;
        this.signalLoss1 = signalLoss1;
        this.signalLoss2 = signalLoss2;
        this.frequency = frequency;
    }


    public void setTransmitterPower(Double transmitterPower) {
        this.transmitterPower = transmitterPower;
    }

    public void setTransmitAntennaGain(Double transmitAntennaGain) {
        this.transmitAntennaGain = transmitAntennaGain;
    }

    public void setReceiveAntennaGain(Double receiveAntennaGain) {
        this.receiveAntennaGain = receiveAntennaGain;
    }

    public void setReceiverSensitivity(Double receiverSensitivity) {
        this.receiverSensitivity = receiverSensitivity;
    }

    public void setSignalLoss1(Double signalLoss1) {
        this.signalLoss1 = signalLoss1;
    }

    public void setSignalLoss2(Double signalLoss2) {
        this.signalLoss2 = signalLoss2;
    }

    public void setFsl(Double fsl) {
        this.fsl = fsl;
    }

    public void setFrequency(double frequency) {
        this.frequency = frequency;
    }


    public double calculate(){
        return transmitterPower + transmitAntennaGain + receiveAntennaGain - receiverSensitivity - signalLoss1 - signalLoss2;
    }
    public double valuesFSL(){
        return calculate() - SOM;
    }
    public double length(){
        double exponent = (fsl/20 - 33/22 - Math.log10(frequency));
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

