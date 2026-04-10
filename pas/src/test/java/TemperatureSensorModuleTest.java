import org.junit.jupiter.api.Test; // Marks a method as a unit test
import static org.junit.jupiter.api.Assertions.*; // Assertions to check expected results(like assertTrue)

public class TemperatureSensorModuleTest {

    @Test
    public void testTemperatureInvalid()
    {
        TemperatureSensor sensor1 = new TemperatureSensor(19);
        assertEquals("LOW", sensor1.getAlertLevel());

        TemperatureSensor sensor2 = new TemperatureSensor(264);
        assertEquals("LOW", sensor2.getAlertLevel());
    }

    @Test
    public void testTemperatureLowerBoundary()
    {
        TemperatureSensor sensor = new TemperatureSensor(265);
        assertEquals("NORMAL", sensor.getAlertLevel());
    }

    @Test
    public void testTemperatureMidRange()
    {
        TemperatureSensor sensor = new TemperatureSensor(288);
        assertEquals("NORMAL", sensor.getAlertLevel());
    }

    @Test 
    public void testTemperatureUpperBoundary()
    {
        TemperatureSensor sensor = new TemperatureSensor(310);
        assertEquals("NORMAL", sensor.getAlertLevel());
    }

    @Test 
    public void testTemperatureAboveUpperBoundary()
    {
        TemperatureSensor sensor1 = new TemperatureSensor(311);
        assertEquals("WARNING", sensor1.getAlertLevel());

        TemperatureSensor sensor2 = new TemperatureSensor(320);
        assertEquals("WARNING", sensor2.getAlertLevel());

        TemperatureSensor sensor3 = new TemperatureSensor(321);
        assertEquals("CRITICAL", sensor3.getAlertLevel());
    }
}