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
    pas.setSensor(new PressureSensor(8.99));
    assertTrue(pas.getSensor().getAlertLevel().equals("CRITICAL LOW"));
  }

  @Test
  public void Validate_AlertLevelWarningMin_True() {
    pas.setSensor(new PressureSensor(9.00));
    assertTrue(pas.getSensor().getAlertLevel().equals("WARNING"));
  }

  @Test
  public void Validate_AlertLevelWarningMinPos_True() {
    pas.setSensor(new PressureSensor(9.01));
    assertTrue(pas.getSensor().getAlertLevel().equals("WARNING"));
  }

  @Test
  public void Validate_AlertLevelNormalMinNeg_True() {
    pas.setSensor(new PressureSensor(9.49));
    assertTrue(pas.getSensor().getAlertLevel().equals("WARNING"));
  }

  @Test
  public void Validate_AlertLevelNormalMin_True() {
    pas.setSensor(new PressureSensor(9.50));
    assertTrue(pas.getSensor().getAlertLevel().equals("NORMAL"));
  }

  @Test
  public void Validate_AlertLevelNormalMinPos_True() {
    pas.setSensor(new PressureSensor(9.51));
    assertTrue(pas.getSensor().getAlertLevel().equals("NORMAL"));
  }

  @Test
  public void Validate_AlertLevelNormalMaxNeg_True() {
    pas.setSensor(new PressureSensor(11.04));
    assertTrue(pas.getSensor().getAlertLevel().equals("NORMAL"));
  }

  @Test
  public void Validate_AlertLevelNormalMax_True() {
    pas.setSensor(new PressureSensor(11.05));
    assertEquals("NORMAL", pas.getSensor().getAlertLevel());
  }

  @Test
  public void Validate_AlertLevelNormalMaxPos_True() {
    pas.setSensor(new PressureSensor(11.06));
    assertTrue(pas.getSensor().getAlertLevel().equals("WARNING"));
  }

  @Test
  public void Validate_AlertLevelWarningMaxNeg_True() {
    pas.setSensor(new PressureSensor(11.49));
    assertTrue(pas.getSensor().getAlertLevel().equals("WARNING"));
  }

  @Test
  public void Validate_AlertLevelWarningMax_True() {
    pas.setSensor(new PressureSensor(11.50));
    assertTrue(pas.getSensor().getAlertLevel().equals("WARNING"));
  }

  @Test
  public void Validate_AlertLevelWarningMaxPos_True() {
    pas.setSensor(new PressureSensor(11.51));
    assertTrue(pas.getSensor().getAlertLevel().equals("CRITICAL HIGH"));
  }

  @Test
  public void Validate_AlertLevelInvalid_True() {
    pas.setSensor(new PressureSensor(Double.NaN));
    assertTrue(pas.getSensor().getAlertLevel().equals("INVALID"));
  }

  // State Transition Testing
  @Test
  public void Validate_ActiveAlertWhenCritical_True() {
    pas.setSensor(new PressureSensor(8.50));
    pas.updateMessage(new DefaultMessage(pas.getMessage()));
    assertTrue(pas.isAlertActive());
  }

  @Test
  public void Validate_ActiveAlertWhenWarning_True() {
    pas.setSensor(new PressureSensor(9.20));
    pas.updateMessage(new DefaultMessage(pas.getMessage()));
    assertTrue(pas.isAlertActive());
  }

  @Test
  public void Validate_ActiveAlertWhenNormal_False() {
    pas.setSensor(new PressureSensor(10.00));
    pas.updateMessage(new DefaultMessage(pas.getMessage()));
    assertFalse(pas.isAlertActive());
  }

  // Use Case Testing
  // When sensor values are normal, the TestMessage decorator is applied
  @Test
  void testNormalReadingAppliesTestDecorator() {
    TemperatureSensor sensor = new TemperatureSensor(280.0f); // NORMAL
    pas.setSensor(sensor);

    pas.updateMessage(new DefaultMessage(pas.getMessage()));
    
    String content = pas.getMessage().getDescription();
    
    assertTrue(content.contains("TEST"), "Normal readings should be wrapped in TestMessage");
    assertFalse(pas.isAlertActive(), "Alert should not be active for NORMAL readings");
  }

    /**
     * USE CASE: Critical Earthquake Emergency
     * Verifies that a high magnitude trips the alert and applies the Earthquake decorator.
     */
    @Test
    void testCriticalEarthquakeAlert() {
      EarthquakeSensor sensor = new EarthquakeSensor(7.2f); // CRITICAL
      pas.setSensor(sensor);
      
      pas.updateMessage(new DefaultMessage(pas.getMessage()));
      
      String content = pas.getMessage().getDescription();
      
      assertTrue(pas.isAlertActive());
      assertTrue(content.contains("Earthquake"), "Should have Earthquake decoration");
      assertTrue(content.contains("CRITICAL"), "Should show CRITICAL severity");
      assertFalse(content.contains("TEST"), "Emergency alerts should NOT have TEST label");
    }

    /**
     * USE CASE: State Transition (Active to Idle)
     * Verifies system state resets correctly when a sensor returns to normal.
     */
    @Test
    void testStateTransitionBackToNormal() {
      // 1. Trip the alarm
      pas.setSensor(new RadiationSensor(150.0f)); // CRITICAL
      pas.updateMessage(new DefaultMessage(pas.getMessage()));
      
      assertTrue(pas.isAlertActive());

      // 2. Clear the alarm
      pas.setSensor(new RadiationSensor(0.2f)); // NORMAL
      pas.updateMessage(new DefaultMessage(pas.getMessage()));
      
      String content = pas.getMessage().getDescription();
      
      // 3. Verify transition
      assertFalse(pas.isAlertActive(), "System should return to idle state");
      assertTrue(content.contains("TEST"), "Subsequent message should be a TestMessage");
    }

    /**
     * USE CASE: Robustness - Invalid Input
     * Verifies that NaN or out-of-bounds doubles fall into the 'INVALID' level.
     */
    @Test
    void testInvalidPressureInput() {
        PressureSensor sensor = new PressureSensor(Double.NaN);
        pas.setSensor(sensor);
        
        pas.updateMessage(new DefaultMessage(pas.getMessage()));
        
        String content = pas.getMessage().getDescription();
        
        assertEquals("INVALID", sensor.getAlertLevel());
        assertFalse(pas.isAlertActive(), "Invalid data should not trigger an active emergency alert");
        assertTrue(content.contains("TEST"));
    }
}

