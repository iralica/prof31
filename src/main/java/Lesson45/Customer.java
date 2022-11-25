package Lesson45;

public class Customer {
    public Integer id;
    public String cname;
    public String city;
    public int rating;
    public int sales;

    public Customer(Integer id, String cname, String city, int rating, int sales) {
        this.id = id;
        this.cname = cname;
        this.city = city;
        this.rating = rating;
        this.sales = sales;
    }

    public int getId() {
        return id;
    }

    public void setId(int cnum) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }
}
