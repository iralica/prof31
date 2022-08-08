package lesson2.homework;

public class Author {
    private String firstName, lastName;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return String.format("Author - %s %s", firstName, lastName);
    }

    public static void main(String[] args) {
        Author a = new Author("Marsal", "Nur");
    }
}
