import org.junit.jupiter.api.Test; // Marks a method as a unit test
import static org.junit.jupiter.api.Assertions.*; // Assertions to check expected results(like assertTrue)
import org.junit.jupiter.api.BeforeEach; // Runs a method before every test, used for setup mostly

public class RadiationSensorModuleTest {
    private RadiationSensorModule radiationModule; // Object we are testing

    @BeforeEach
    public void setUp() {
        radiationModule = new RadiationSensorModule();
    }

    @Test
    public void testRadiationInvalid()
    {
        assertEquals(SensorState.INVALID, radiationModule.classify(-1.00));
        assertEquals(SensorState.INVALID, radiationModule.classify(-100.0));
    }

    @Test
    public void testRadiationNormal()
    {
        assertEquals(SensorState.NORMAL, radiationModule.classify(0.99));
    }

    @Test // Test warning boundary
    public void testRadiationWarningLow()
    {
        assertEquals(SensorState.WARNING, radiationModule.classify(1.00));
    }

    @Test // Tests warning range
    public void testRadiationWarningMid()
    {
        assertEquals(SensorState.WARNING, radiationModule.classify(49.9));
        assertEquals(SensorState.WARNING, radiationModule.classify(50.0));
    }

    @Test
    public void testRadiationWarningHigh()
    {
        assertEquals(SensorState.WARNING, radiationModule.classify(99.9));
    }

    @Test
    public void testRadiationCriticalLow()
    {
        assertEquals(SensorState.CRITICAL, radiationModule.classify(100.0));
    }

    @Test
    public void testRadiationCriticalHigh()
    {
        assertEquals(SensorState.CRITICAL, radiationModule.classify(1000.0));
    }
}