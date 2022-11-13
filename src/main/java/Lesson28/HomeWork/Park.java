package Lesson28.HomeWork;



import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import Lesson24.HomeWork.Car1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "Park")
public class Park {
    private String address;
    private List<Car1> cars = new ArrayList<>();

    public String getAddress() {
        return address;
    }

    @XmlAttribute(name = "Address")
    public void setAddress(String address) {
        this.address = address;
    }

    @XmlElement(name = "Car")
    public List<Car1> getCars() {
        return cars;
    }

    public void setCars(List<Car1> cars) {
        this.cars = cars;
    }
}
    /*Park park = new Park();

        park.setAddress("Main street, 54");

        park.setCars(
                new ArrayList<>(
                Arrays.asList(
                new

    Car1("Peugeot","407",21_000),
                                new

    Car1("Nissan","Patrol",16_500)
                        )
                                )
                                );

}*/