package Lesson45;

public class Customer {
    public Integer id;
    public String cname;
    public String city;
    public int rating;
    public Sales sales;

    public Customer(Integer id, String cname, String city, int rating, Sales sales) {
        this.id = id;
        this.cname = cname;
        this.city = city;
        this.rating = rating;
        this.sales = sales;
    }

    public int getId() {
        return id;
    }

    public String getCname() {
        return cname;
    }

    public String getCity() {
        return city;
    }

    public int getRating() {
        return rating;
    }

    public Sales getSales() {
        return sales;
    }

}
