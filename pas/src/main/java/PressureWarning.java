/**
 * @author CobieCaburao
 *
 */
public class PressureWarning extends MessageDecorator {
    
    private String alertLevel;

    public PressureWarning(Message newMessage, String alertLevel) {
        super(newMessage);
        this.alertLevel = alertLevel;
    }

    @Override
    public String getDescription() {
        return message.getDescription() + "\nWarning: Pressure detected at dangerous levels\nStatus: " + this.alertLevel;
    }
}