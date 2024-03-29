package Lesson26.xml;

import java.util.List;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "CATALOG")
public class Catalog {
    private String name;
    private String size;
    private List<Plant> plants;

    public String getName() {
        return name;
    }

    @XmlAttribute(name = "name")  // �������� �������� � xml
    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    @XmlAttribute(name = "size")  // �������� �������� � xml
    public void setSize(String size) {
        this.size = size;
    }

    public List<Plant> getPlants() {
        return plants;
    }

    @XmlElement(name = "PLANT")
    public void setPlants(List<Plant> plants) {
        this.plants = plants;
    }

    @Override
    public String toString() {
        return "C{" +
                "n='" + name + '\'' +
                ", s='" + size + '\'' +
                ", p=" + plants +
                '}';
    }
}
