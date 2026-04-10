import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class TestPAS {
  PAS pas;
  PASObserver observer;

  @BeforeEach
  public void setup() {
    pas = new PAS();
    observer = new Civilian("(306)-777-7777", 10);
  }
  

  @Test
  public void Validate_RegisterObserver_True() {
    pas.registerObserver(observer);
    assertTrue(pas.pasObservers.contains(observer));
  }

  @Test
  public void Validate_RegisterObserver_False() {
    pas.registerObserver(observer);
    pas.registerObserver(observer);
    assertTrue(pas.pasObservers.size() <= 2);  
}

  @Test
  public void Validate_RemoveObserver_True() {
    pas.registerObserver(observer);
    pas.removeObserver(observer);
    assertTrue(!pas.pasObservers.contains(observer));
  }

  @Test
  public void Validate_RemoveObserver_False() {
    pas.removeObserver(observer);
    assertTrue(!pas.pasObservers.contains(observer));
  }

  // BVA and ECT
  @Test
  public void Validate_AlertLevelWarningMinNeg_True() {
    pas.setSensor(new PressureSensor(8.99f));
    assertTrue(pas.getSensor().getAlertLevel().equals("CRITICAL LOW"));
  }

  @Test
  public void Validate_AlertLevelWarningMin_True() {
    pas.setSensor(new PressureSensor(9.00f));
    assertTrue(pas.getSensor().getAlertLevel().equals("WARNING"));
  }

  @Test
  public void Validate_AlertLevelWarningMinPos_True() {
    pas.setSensor(new PressureSensor(9.01f));
    assertTrue(pas.getSensor().getAlertLevel().equals("WARNING"));
  }

  @Test
  public void Validate_AlertLevelNormalMinNeg_True() {
    pas.setSensor(new PressureSensor(9.49f));
    assertTrue(pas.getSensor().getAlertLevel().equals("WARNING"));
  }

  @Test
  public void Validate_AlertLevelNormalMin_True() {
    pas.setSensor(new PressureSensor(9.50f));
    assertTrue(pas.getSensor().getAlertLevel().equals("NORMAL"));
  }

  @Test
  public void Validate_AlertLevelNormalMinPos_True() {
    pas.setSensor(new PressureSensor(9.51f));
    assertTrue(pas.getSensor().getAlertLevel().equals("NORMAL"));
  }

  @Test
  public void Validate_AlertLevelNormalMaxNeg_True() {
    pas.setSensor(new PressureSensor(11.04f));
    assertTrue(pas.getSensor().getAlertLevel().equals("NORMAL"));
  }

  @Test
  public void Validate_AlertLevelNormalMax_True() {
    pas.setSensor(new PressureSensor(11.05f));
    assertTrue(pas.getSensor().getAlertLevel().equals("NORMAL"));
  }

  @Test
  public void Validate_AlertLevelNormalMaxPos_True() {
    pas.setSensor(new PressureSensor(11.06f));
    assertTrue(pas.getSensor().getAlertLevel().equals("WARNING"));
  }

  @Test
  public void Validate_AlertLevelWarningMaxNeg_True() {
    pas.setSensor(new PressureSensor(11.49f));
    assertTrue(pas.getSensor().getAlertLevel().equals("WARNING"));
  }

  @Test
  public void Validate_AlertLevelWarningMax_True() {
    pas.setSensor(new PressureSensor(11.50f));
    assertTrue(pas.getSensor().getAlertLevel().equals("WARNING"));
  }

  @Test
  public void Validate_AlertLevelWarningMaxPos_True() {
    pas.setSensor(new PressureSensor(11.51f));
    assertTrue(pas.getSensor().getAlertLevel().equals("CRITICAL HIGH"));
  }

  @Test
  public void Validate_AlertLevelInvalid_True() {
    pas.setSensor(new PressureSensor(Double.NaN));
    assertTrue(pas.getSensor().getAlertLevel().equals("Invalid"));
  }

  // State Transition Testing
  @Test
  public void Validate_ActiveAlertWhenCritical_True() {
    pas.setSensor(new PressureSensor(8.50f));
    assertTrue(pas.isAlertActive());
  }

  @Test
  public void Validate_ActiveAlertWhenWarning_True() {
    pas.setSensor(new PressureSensor(9.20f));
    assertTrue(pas.isAlertActive());
  }

  @Test
  public void Validate_ActiveAlertWhenNormal_False() {
    pas.setSensor(new PressureSensor(10.00f));
    assertFalse(pas.isAlertActive());
  }
}

