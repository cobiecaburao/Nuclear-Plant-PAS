import org.junit.jupiter.api.Test; // Marks a method as a unit test
import static org.junit.jupiter.api.Assertions.*; // Assertions to check expected results(like assertTrue)
import org.junit.jupiter.api.BeforeEach; // Runs a method before every test, used for setup mostly

public class PressureSensorModuleTest {
    private PressureSensorModule pressureModule; // Object we are testing

    @BeforeEach
    public void setUp() {
        pressureModule = new PressureSensorModule();
    }

    @Test
    public void testPressureCriticalLow()
    {
        assertEquals(SensorState.CRITICAL, pressureModule.classify(8.99));
    }

    @Test
    public void testPressureWarningLow()
    {
        assertEquals(SensorState.WARNING, pressureModule.classify(9.00));
        assertEquals(SensorState.WARNING, pressureModule.classify(9.49));
    }

    @Test
    public void testPressureNormal()
    {
        assertEquals(SensorState.NORMAL, pressureModule.classify(9.50));
        assertEquals(SensorState.NORMAL, pressureModule.classify(10.0));
        assertEquals(SensorState.NORMAL, pressureModule.classify(11.05));
    }

    @Test
    public void testPressureWarningHigh()
    {
        assertEquals(SensorState.WARNING, pressureModule.classify(11.06));
        assertEquals(SensorState.WARNING, pressureModule.classify(11.50));
    }

    @Test
    public void testPressureCriticalHigh()
    {
        assertEquals(SensorState.CRITICAL, pressureModule.classify(11.51));
    }
}