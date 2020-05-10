package homework3;

public class Call {
    private String contactPhoneNumber;
    Contact contact;
    String formatDateTime;

    //call cunstructor;
    public Call(String contactPhoneNumber, String formatDateTime) {
        this.contactPhoneNumber = contactPhoneNumber;
        this.formatDateTime = formatDateTime;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

}