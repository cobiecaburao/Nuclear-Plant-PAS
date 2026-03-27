import org.junit.jupiter.api.Test; // Marks a method as a unit test
import static org.junit.jupiter.api.Assertions.*; // Assertions to check expected results(like assertTrue)
import org.junit.jupiter.api.BeforeEach; // Runs a method before every test, used for setup mostly

public class TemperatureSensorModuleTest {
    private TemperatureSensorModule temperatureModule; // Object we are testing

    @BeforeEach
    public void setUp() {
        temperatureModule = new TemperatureSensorModule();
    }

    @Test
    public void testTemperatureInvalid()
    {
        assertEquals(SensorState.INVALID, temperatureModule.classify(19.0));
        assertEquals(SensorState.INVALID, temperatureModule.classify(264.0));
    }

    @Test
    public void testTemperatureLowerBoundary()
    {
        assertEquals(SensorState.NORMAL, temperatureModule.classify(265.0));
    }

    @Test
    public void testTemperatureMidRange()
    {
        assertEquals(SensorState.NORMAL, temperatureModule.classify(288.0));
        
    }

    @Test 
    public void testTemperatureUpperBoundary()
    {
        assertEquals(SensorState.NORMAL, temperatureModule.classify(310.0));
    }

    @Test 
    public void testTemperatureAboveUpperBoundary()
    {
        assertEquals(SensorState.WARNING, temperatureModule.classify(311.0));
        assertEquals(SensorState.WARNING, temperatureModule.classify(320.0));
        assertEquals(SensorState.CRITICAL, temperatureModule.classify(321.0));
    }
}