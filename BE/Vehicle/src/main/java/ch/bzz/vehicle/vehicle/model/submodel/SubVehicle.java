package ch.bzz.vehicle.vehicle.model.submodel;

public class SubVehicle {

    private String colour;
    private int seats;
    private int doors;
    private String plate;
    private Long ownerId;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getDoors() {
        return doors;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public String toString() {
        return "SubVehicle{" +
                "colour='" + colour + '\'' +
                ", seats=" + seats +
                ", doors=" + doors +
                ", plate='" + plate + '\'' +
                ", ownerId=" + ownerId +
                '}';
    }
}
