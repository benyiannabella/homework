package homework3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MainPhone {
    public static void main(String[] args) {
        //register date and time
        LocalDateTime dateTimeNow = LocalDateTime.now();
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formatDateTime = dateTimeNow.format(dateTimeFormat);

        //create phone objects and assign values to parameters defined in constructor;
        Phone phone1 = new SamsungGalaxyS6("Gray", "Plastic", "123456789012345", "Samsung", "Samsung Galaxy S6");
        Phone phone2 = new SamsungGalaxyS9("Blue", "Metal", "098765432154321", "Samsung", "Samsung Galaxy S9");
        Phone phone3 = new Nokia32("Black", "Plastic", "123451234512345", "Nokia", "Nokia 3.2");
        Phone phone4 = new Nokia42("Red", "Metal", "567895678956789", "Nokia", "Nokia 4.2");

        //create contact objects, assign values to parameters defined in constructor;
        Contact contact1 = new Contact(1, "Joe", "Strange", "0762345231" );
        Contact contact2 = new Contact(2, "Jessica", "James", "0763256352");

        //create the contact array to insert the created contacts as elements;
        Contact[] newPhoneContact = new Contact[0];
        //add contacts to the array;
        newPhoneContact = phone1.addContact(contact1, newPhoneContact);
        newPhoneContact = phone1.addContact(contact2, newPhoneContact);
        //display contact list;
        phone1.viewContactList(newPhoneContact);

        //create the message objects and define the message text;
        Message messageContact1 = new Message("Java is an object-oriented programming language, " +
                "designed to have few implementation dependencies:)");
        Message message2Contact1 = new Message("Java applications are typically compiled to bytecode that can run " +
                "on any Java virtual machine (JVM) regardless of the underlying computer architecture. The syntax of " +
                "Java is similar to C and C++, but it has fewer low-level facilities than either of them. As of 2019, " +
                "Java was one of the most popular programming languages in use according to GitHub, particularly for " +
                "client-server web applications, with a reported 9 million developers. Java was originally developed by " +
                "James Gosling at Sun Microsystems.");
        //create a new list for messages;
        List<Message> messageSent = new ArrayList<Message>();
        //insert messages in the message list base on condition;
        phone1.checkIfSendMessage(messageContact1, phone1, messageSent, contact1);
        phone1.checkIfSendMessage(message2Contact1, phone1,  messageSent, contact1);
        //display all the messages successfully sent to a selected contact
        phone1.listMessage(messageSent, contact1);

        //create new call objects and set its parameters;
        Call call1 = new Call(contact1.getPhoneNumber(), formatDateTime);
        Call call2 = new Call(contact2.getPhoneNumber(), formatDateTime);
        //create a new call array for the made calls;
        Call[] newCall = new Call[0];
        //add the calls to the array;
        newCall= phone1.makeACall(call1, newCall, phone1);
        newCall= phone1.makeACall(call2, newCall, phone1);
        //display the call History of the selected phone;
        phone1.viewCallHistory(newCall);
    }
}
