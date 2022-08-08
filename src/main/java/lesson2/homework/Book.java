package lesson2.homework;

public class Book {
    private String title;
    private Author author;
    private double price;


    public Book(String title, Author author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    @Override
    public String toString(){
        return String.format("Book - title %s, %s, price=%5.2f", title, author, price);
    }

    public static void main(String[] args) {
        Author a = new Author("Marsal", "Nur");
        Book book = new Book("Maria", a, 20.0);
        System.out.println(book);
    }
}
