/**
 * @author CobieCaburao
 *
 */
public class TemperatureWarning extends MessageDecorator {
    
    private String alertLevel;

    public TemperatureWarning(Message newMessage, String alertLevel) {
        super(newMessage);
        this.alertLevel = alertLevel;
    }

    @Override
    public String getDescription() {
        return message.getDescription() + "\nWarning: Temperature detected at dangerous levels\nStatus: " + this.alertLevel;
    }
}