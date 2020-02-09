package homework3;

import java.util.List;

public interface Phone {
    // all the homework requirements have been developed only under sublass SamsungGalaxyS6;
    // where the below methods have been overriden to fulfill the requirements;

    // add contact to the contact list;
    public Contact[] addContact(Contact contactToAdd, Contact[] phoneContact);
    //display contact list for the selected phone;
    public void viewContactList(Contact[] newContactList);
    //display all the messages successfully sent to a selected contact;
    public void listMessage(List <Message> messageSent, Contact contact);
    //check and override phone battery life at after every message sent and call made
    public void setCurrentBatteryLife(boolean message);
    //check if message can be sent, if exceeds 500 char -  block;
    public void checkIfSendMessage(Message messageToSend, Phone phone, List<Message> messageSent, Contact contact);
    //call a selected contact;
    public Call[] makeACall(Call callToMake, Call[] callMade, Phone phone);
    //display the call History of the selected phone;
    public void viewCallHistory(Call[] callMade);
}
