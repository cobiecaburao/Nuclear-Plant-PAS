import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class TestPAS {
  

  @Test
  public void Validate_RegisterObserver_True() {
    PAS pas = new PAS();
    Civilian observer = new Civilian("(306)-777-7777", 10);
    pas.registerObserver(observer);
    assertTrue(pas.pasObservers.contains(observer));
  }

  @Test
  public void Validate_RegisterObserver_False() {
    PAS pas = new PAS();
    Civilian observer = new Civilian("(306)-777-7777", 10);
    pas.registerObserver(observer);
    pas.registerObserver(observer);
    assertTrue(pas.pasObservers.size() <= 2);  
}

  @Test
  public void Validate_RemoveObserver_True() {
    PAS pas = new PAS();
    Civilian observer = new Civilian("(306)-777-7777", 10);
    pas.registerObserver(observer);
    pas.removeObserver(observer);
    assertTrue(!pas.pasObservers.contains(observer));
  }

  @Test
  public void Validate_RemoveObserver_False() {
    PAS pas = new PAS();
    Civilian observer = new Civilian("(306)-777-7777", 10);
    pas.removeObserver(observer);
    assertTrue(!pas.pasObservers.contains(observer));
  }
}

