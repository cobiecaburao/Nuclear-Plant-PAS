/**
 * @author CobieCaburao
 *
 */
public class Civilian implements PASObserver {
    
    String phoneNumber;
    int distance;

    public Civilian (String phoneNumber, int distance) {
        this.phoneNumber = phoneNumber;
        this.distance = distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getDistance() {
        return distance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void updateMessage(Message message) {
        if (getDistance() <= 10) {
            display(message);
        }
    }

    public void display(Message message) {
        System.out.println("Texting " + phoneNumber + message.getDescription());
    }
}
