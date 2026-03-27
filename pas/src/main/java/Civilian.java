/**
 * @author CobieCaburao
 *
 */
public class Civilian implements PASObserver {
    
    int phoneNumber;
    float distance;

    public Civilian (int phoneNumber, float distance) {
        this.phoneNumber = phoneNumber;
        this.distance = distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public float getDistance() {
        return distance;
    }

    public int getPhoneNumber() {
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
