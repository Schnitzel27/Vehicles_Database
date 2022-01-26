package ch.bzz.vehicle.vehicle.model;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person_id;

    @Column(name = "colour")
    private String colour;

    @Column(name = "seats")
    private int seats;

    @Column(name = "doors")
    private int doors;

    @Column(name = "plate")
    private String plate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Person person_id) {
        this.person_id = person_id;
    }

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

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", person_id=" + person_id +
                ", colour='" + colour + '\'' +
                ", seats=" + seats +
                ", doors=" + doors +
                ", plate='" + plate + '\'' +
                '}';
    }
}
