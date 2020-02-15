package homework3;

import java.util.List;

public interface Phone {
    //  the below methods have been override under sublass SamsungGalaxyS6 to fulfill the requirements;
    //  subclass SGS9 and Nokia classes have been created because the homework requested two brands and two models each, no extra functions developed;

    // add contact to the contact list;
    Contact[] addContact(Contact contactToAdd, Contact[] phoneContact);
    //display contact list for the selected phone;
    void viewContactList(Contact[] newContactList);
    //display all the messages successfully sent to a selected contact;
    void listMessage(List <Message> messageSent, Contact contact);
    //check and override phone battery life at after every message sent and call made
    void setCurrentBatteryLife(boolean message);
    //check if message can be sent, if exceeds 500 char -  block;
    void checkIfSendMessage(Message messageToSend, Phone phone, List<Message> messageSent, Contact contact);
    //call a selected contact;
    Call[] makeACall(Call callToMake, Call[] callMade, Phone phone);
    //display the call History of the selected phone;
    void viewCallHistory(Call[] callMade);
}
