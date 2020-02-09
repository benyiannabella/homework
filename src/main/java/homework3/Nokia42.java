package homework3;

import java.util.List;

public class Nokia42 extends Nokia implements Phone {
    private String color;
    private String material;
    private String imei;

    public Nokia42(String color, String material, String imei, String manufacturer, String model) {
        super();
        this.color = color;
        this.material = material;
        this.imei = imei;
    }

    @Override
    public Contact[] addContact(Contact contactToAdd, Contact[] phoneContact) {
        return new Contact[0];
    }

    @Override
    public void viewContactList(Contact[] newContactList) {

    }

    @Override
    public void listMessage(List<Message> messageSent, Contact contact) {

    }

    @Override
    public void setCurrentBatteryLife(boolean message) {

    }

    @Override
    public void checkIfSendMessage(Message messageToSend, Phone phone, List<Message> messageSent, Contact contact) {

    }

    @Override
    public Call[] makeACall(Call callToMake, Call[] callMade, Phone phone) {
        return new Call[0];
    }

    @Override
    public void viewCallHistory(Call[] callMade) {

    }
}
