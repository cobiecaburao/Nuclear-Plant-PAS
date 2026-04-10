import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SeismometerModuleTest {

    @Test
    public void testEarthquakeNormal() {
        EarthquakeSensor sensor = new EarthquakeSensor(0f);
        assertEquals("NORMAL", sensor.getAlertLevel());
    }

    @Test
    public void testEarthquakeWarninMin() {
        EarthquakeSensor sensor = new EarthquakeSensor(0.1f);
        assertEquals("WARNING", sensor.getAlertLevel());
    }

    @Test
    public void testEarthquakeWarningMax() {
        EarthquakeSensor sensor = new EarthquakeSensor(5.9f);
        assertEquals("WARNING", sensor.getAlertLevel());
    }

    @Test
    public void testEarthquakeCritical() {
        EarthquakeSensor sensor = new EarthquakeSensor(7f);
        assertEquals("CRITICAL", sensor.getAlertLevel());
    }
}