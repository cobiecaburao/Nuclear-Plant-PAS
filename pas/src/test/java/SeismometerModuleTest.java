import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SeismometerModuleTest {

    @Test
    public void testEarthquakeNormal() {
        EarthquakeSensor sensor = new EarthquakeSensor(0);
        assertEquals("NORMAL", sensor.getAlertLevel());
    }

    @Test
    public void testEarthquakeWarning() {
        EarthquakeSensor sensor = new EarthquakeSensor(1);
        assertEquals("WARNING", sensor.getAlertLevel());
    }

    @Test
    public void testEarthquakeCritical() {
        EarthquakeSensor sensor = new EarthquakeSensor(7);
        assertEquals("CRITICAL", sensor.getAlertLevel());
    }
}