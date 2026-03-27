/**
 * @author CobieCaburao
 *
 */
public class EarthquakeWarning extends MessageDecorator {
    
    private String alertLevel;

    public EarthquakeWarning(Message newMessage, String alertLevel) {
        super(newMessage);
        this.alertLevel = alertLevel;
    }

    @Override
    public String getDescription() {
        return message.getDescription() + "\nWarning: Earthquake detected\nStatus: " + this.alertLevel;
    }
}
