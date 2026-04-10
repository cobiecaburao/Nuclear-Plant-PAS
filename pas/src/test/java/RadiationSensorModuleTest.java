import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RadiationSensorModuleTest {

    @Test
    public void testRadiationInvalid() {
        RadiationSensor sensor1 = new RadiationSensor(-1.0f);
        assertEquals("INVALID", sensor1.getAlertLevel());

        RadiationSensor sensor2 = new RadiationSensor(-100.0f);
        assertEquals("INVALID", sensor2.getAlertLevel());
    }

    @Test
    public void testRadiationNormal() {
        RadiationSensor sensor = new RadiationSensor(0.99f);
        assertEquals("NORMAL", sensor.getAlertLevel());
    }

    @Test
    public void testRadiationWarningLow() {
        RadiationSensor sensor = new RadiationSensor(1.0f);
        assertEquals("WARNING", sensor.getAlertLevel());
    }

    @Test
    public void testRadiationWarningMid() {
        RadiationSensor sensor1 = new RadiationSensor(49.9f);
        assertEquals("WARNING", sensor1.getAlertLevel());

        RadiationSensor sensor2 = new RadiationSensor(50.0f);
        assertEquals("WARNING", sensor2.getAlertLevel());
    }

    @Test
    public void testRadiationWarningHigh() {
        RadiationSensor sensor = new RadiationSensor(99.9f);
        assertEquals("WARNING", sensor.getAlertLevel());
    }

    @Test
    public void testRadiationCriticalLow() {
        RadiationSensor sensor = new RadiationSensor(100.0f);
        assertEquals("CRITICAL", sensor.getAlertLevel());
    }

    @Test
    public void testRadiationCriticalHigh() {
        RadiationSensor sensor = new RadiationSensor(1000.0f);
        assertEquals("CRITICAL", sensor.getAlertLevel());
    }
}