/**
 * @author CobieCaburao
 *
 */
public class DefaultMessage extends MessageDecorator {
    public DefaultMessage(Message newMessage) {
        super(newMessage);
    }

    @Override
    public String getDescription() {
        return "\nWarning: ";
    } 
}
