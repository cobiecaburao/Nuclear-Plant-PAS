/**
 * @author CobieCaburao
 *
 */
public class RadiationWarning extends MessageDecorator {
    
    private String alertLevel;

    public RadiationWarning(Message newMessage, String alertLevel) {
        super(newMessage);
        this.alertLevel = alertLevel;
    }

    @Override
    public String getDescription() {
        return message.getDescription() + "Radiation detected at dangerous levels\nStatus: " + this.alertLevel;
    }
}
