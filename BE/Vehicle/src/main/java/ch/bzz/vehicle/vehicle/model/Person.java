package ch.bzz.vehicle.vehicle.model;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "prename")
    private String prename;

    @Column(name = "hair_colour")
    private String hair_colour;

    @Column(name = "size")
    private double size;

    @Column(name = "address")
    private String address;

    @Column(name = "house_number")
    private int house_number;

    @Column(name = "plz")
    private int plz;

    @Column(name = "place")
    private String place;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPrename() {
        return prename;
    }

    public void setPrename(String prename) {
        this.prename = prename;
    }

    public String getHair_colour() {
        return hair_colour;
    }

    public void setHair_colour(String hair_colour) {
        this.hair_colour = hair_colour;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getHouse_number() {
        return house_number;
    }

    public void setHouse_number(int house_number) {
        this.house_number = house_number;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", prename='" + prename + '\'' +
                ", hair_colour='" + hair_colour + '\'' +
                ", size=" + size +
                ", address='" + address + '\'' +
                ", house_number=" + house_number +
                ", plz=" + plz +
                ", place='" + place + '\'' +
                '}';
    }
}
