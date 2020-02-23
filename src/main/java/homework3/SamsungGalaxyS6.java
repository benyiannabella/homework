package homework3;

import java.util.Arrays;
import java.util.List;

public class SamsungGalaxyS6 extends Samsung implements Phone {
    private String color;
    private String material;
    private String imei;
    private int phoneBatteryLife = super.getBatteryLife();
    private int currentBatteryLife;

    //SG6 class constructor;
    public SamsungGalaxyS6(String color, String material, String imei, String manufacturer, String model) {
        super();
        this.color = color;
        this.material = material;
        this.imei = imei;
    }

    public void setPhoneBatteryLife(int phoneBatteryLife) {
        this.phoneBatteryLife = phoneBatteryLife;
    }

    @Override
    public Contact[] addContact(Contact contactToAdd, Contact[] phoneContact) {
        Contact[] newContactList = Arrays.copyOf(phoneContact, phoneContact.length + 1);
        newContactList[phoneContact.length] = contactToAdd;
        return newContactList;
    }

    @Override
    public void viewContactList(Contact[] contactList) {
        System.out.println("Display Contact List:");
        for (Contact getContactList : contactList) {
            System.out.println(getContactList.getContactOrderNumber() + ". " + getContactList.getFirstName() + " "
                    + getContactList.getLastName() + " - " + getContactList.getPhoneNumber());
        }
    }

    @Override
    public void listMessage(List<Message> messageSent, Contact contact) {
        for (Message sent : messageSent) {
            System.out.println("Show all the messages sent to " + contact.getPhoneNumber() + ":");
            System.out.println("Message text: " + sent.getMessageText());
            System.out.println();
        }
    }

    @Override
    public void setCurrentBatteryLife(boolean message) {
        if (message) {
            if(phoneBatteryLife >=1) {
                currentBatteryLife = phoneBatteryLife - 1;
                setPhoneBatteryLife(currentBatteryLife);
                System.out.println("After sending the message your phone Battery Life decreased to " + currentBatteryLife + " hours.");
                System.out.println();
            } else {
                System.out.println("You do not have enough battery power to send the message!!!");
                System.out.println("The phone will die shortly. Connect it to a power supply to charge!");
            }
        } else {
            if(phoneBatteryLife >=2) {
                currentBatteryLife = phoneBatteryLife - 2;
                setPhoneBatteryLife(currentBatteryLife);
                System.out.println("After making the call your phone Battery Life decreased to " + currentBatteryLife + " hours.");
                System.out.println();
            } else {
                System.out.println("You do not have enough battery power to make a call!!!");
                System.out.println("The phone will die shortly. Connect it to a power supply to charge!");
            }
        }
    }

    public void checkIfSendMessage(Message messageToSend, Phone phone, List<Message> messageSent, Contact contact) {
        if (messageToSend.getMessageText().length() <= 500) {
            messageSent.add(messageToSend);
            System.out.println();
            System.out.println("Send message to contact " + contact.getFirstName() + " " + contact.getLastName() + "...");
            System.out.println("Message sent: '" + messageToSend.getMessageText() + "'");
            boolean message = true;
            phone.setCurrentBatteryLife(message);
        } else {
            System.out.println("Message '" + messageToSend.getMessageText() + "'");
            System.out.println("Cannot be sent to contact " + contact.getFirstName() + " " + contact.getLastName() + ". Message exceeds 500 characters!");
            System.out.println("No change on battery life. Battery life " + currentBatteryLife + " hours.");
            System.out.println();
        }
    }

    @Override
    public Call[] makeACall(Call callToMake, Call[] callMade, Phone phone) {
        Call[] newCall = Arrays.copyOf(callMade, callMade.length + 1);
        newCall[callMade.length] = callToMake;
        System.out.println("Calling number " + callToMake.getContactPhoneNumber() + " ...");
        boolean message = false;
        phone.setCurrentBatteryLife(message);
        return newCall;
    }

    @Override
    public void viewCallHistory(Call[] newCall) {
        System.out.println();
        System.out.println("View call history...");
        for (Call callHistory : newCall) {
            System.out.println("Call made to phone number " + callHistory.getContactPhoneNumber() + " on " + callHistory.formatDateTime);

        }
    }
}
