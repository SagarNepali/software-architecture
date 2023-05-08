package kafka;

public class Runner {

    public String licensePlate;
    public Double speed;

    public Runner(String licensePlate, Double mph) {
        this.licensePlate = licensePlate;
        this.speed = mph;
    }

    public Runner() {
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }
}
