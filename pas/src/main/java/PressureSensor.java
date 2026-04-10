/**
 * @author CobieCaburao
 *
 */
public class PressureSensor extends Sensor {
    public PressureSensor(double pressure) {
        addCategoryIfMissing("pressure");
        updateReading(pressure);
    }

    public void updateReading(double pressure) {
        if (pressure < 9.0) {
            setAlertLevel("CRITICAL LOW");
        } else if (pressure >= 9.50 && pressure <= 11.05) {
            setAlertLevel("NORMAL");
        } else if ((pressure >= 9.0 && pressure < 9.50) || (pressure > 11.05 && pressure <= 11.50)) {
            setAlertLevel("WARNING");
        } else if (pressure > 11.50) {
            setAlertLevel("CRITICAL HIGH");
        } else {
            setAlertLevel("INVALID");
        }
    }
}
