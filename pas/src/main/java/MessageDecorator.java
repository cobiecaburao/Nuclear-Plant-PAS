/**
 * @author CobieCaburao
 *
 */
public abstract class MessageDecorator implements Message {
    protected Message message;

    public MessageDecorator(Message newMessage) {
        message = newMessage;
    }
    
    public String getDescription() {
        return message.getDescription();
    }
}
