package kafka;

public class OwnerRecord {

    private String licensePlate;
    private String speed;
    private String owner;

    public OwnerRecord(String licensePlate, String speed, String owner) {
        this.licensePlate = licensePlate;
        this.speed = speed;
        this.owner = owner;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "OwnerRecord{" +
                "licensePlate='" + licensePlate + '\'' +
                ", speed='" + speed + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
