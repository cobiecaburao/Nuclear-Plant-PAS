import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PressureSensorModuleTest {

    @Test
    public void testPressureCriticalLow() {
        PressureSensor sensor = new PressureSensor(8.99);
        assertEquals("CRITICAL LOW", sensor.getAlertLevel());
    }

    @Test
    public void testPressureWarningLow() {
        PressureSensor sensor1 = new PressureSensor(9.00);
        assertEquals("WARNING", sensor1.getAlertLevel());

        PressureSensor sensor2 = new PressureSensor(9.49);
        assertEquals("WARNING", sensor2.getAlertLevel());
    }

    @Test
    public void testPressureNormal() {
        PressureSensor sensor1 = new PressureSensor(9.50);
        assertEquals("NORMAL", sensor1.getAlertLevel());

        PressureSensor sensor2 = new PressureSensor(10.0);
        assertEquals("NORMAL", sensor2.getAlertLevel());

        PressureSensor sensor3 = new PressureSensor(11.05);
        assertEquals("NORMAL", sensor3.getAlertLevel());
    }

    @Test
    public void testPressureWarningHigh() {
        PressureSensor sensor1 = new PressureSensor(11.06);
        assertEquals("WARNING", sensor1.getAlertLevel());

        PressureSensor sensor2 = new PressureSensor(11.50);
        assertEquals("WARNING", sensor2.getAlertLevel());
    }

    @Test
    public void testPressureCriticalHigh() {
        PressureSensor sensor = new PressureSensor(11.51);
        assertEquals("CRITICAL HIGH", sensor.getAlertLevel());
    }
}