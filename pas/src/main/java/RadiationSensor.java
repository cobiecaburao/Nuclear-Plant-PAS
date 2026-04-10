/**
 * @author CobieCaburao
 *
 */
public class RadiationSensor extends Sensor {
    public RadiationSensor(float radiation) {
        addCategoryIfMissing("radiation");
        updateReading(radiation);
    }

    public void updateReading(float radiation) {
        if (radiation < 0) {
            setAlertLevel("INVALID");
        } else if (radiation < 1.0) {
            setAlertLevel("NORMAL");
        } else if (radiation < 100) {
            setAlertLevel("WARNING");
        } else {
            setAlertLevel("CRITICAL");
        }
    }
}