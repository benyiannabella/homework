package homework3;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private int contactOrderNumber;

    //Contact costructor;
    public Contact(int contactOrderNumber, String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.contactOrderNumber = contactOrderNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getContactOrderNumber() {
        return contactOrderNumber;
    }
}
