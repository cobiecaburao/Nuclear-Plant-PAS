import org.junit.jupiter.api.Test; // Marks a method as a unit test
import static org.junit.jupiter.api.Assertions.*; // Assertions to check expected results(like assertTrue)
import org.junit.jupiter.api.BeforeEach; // Runs a method before every test, used for setup mostly

public class SeismometerModuleTest {
    private SeismometerModule seismicModule; // Object we are testing

    @BeforeEach
    public void setUp() {
        seismicModule = new SeismometerModule();
    }

    @Test // Testing invalid seismic input
    public void testSeismicInvalid()
    {
        assertEquals(SensorState.INVALID, seismicModule.classify(-1.00));
    }

    @Test // Testing normal boundary
    public void testSeismicNormal()
    {
        assertEquals(SensorState.NORMAL, seismicModule.classify(0.00));
    }

    @Test // Testing warning boundary
    public void testSeismicWarning()
    {
        assertEquals(SensorState.WARNING, seismicModule.classify(1.00));
    }

    @Test // Testing critical boundary
    public void testSeismicCritical()
    {
        assertEquals(SensorState.CRITICAL, seismicModule.classify(2.00));
    }
}