package Lesson45;

public class Customer {
    public int cnum;
    public String cname;
    public String city;
    public int rating;
    public int snum;

    public Customer(int cnum, String cname, String city, int rating, int snum) {
        this.cnum = cnum;
        this.cname = cname;
        this.city = city;
        this.rating = rating;
        this.snum = snum;
    }

    public int getCnum() {
        return cnum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
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

    public int getSnum() {
        return snum;
    }

    public void setSnum(int snum) {
        this.snum = snum;
    }
}
