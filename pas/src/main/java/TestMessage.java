/**
 * @author CobieCaburao
 *
 */
public class TestMessage extends MessageDecorator {
    
    public TestMessage(Message newMessage) {
        super(newMessage);
    }

    public String getDescription() {
        return "\n****THIS IS A TEST MESSAGE****\n******NO ACTION REQUIRED******" + message.getDescription();
    }
}
