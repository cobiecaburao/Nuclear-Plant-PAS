/**
 * @author CobieCaburao
 *
 */
public class EarthquakeSensor extends Sensor {
    public EarthquakeSensor(float magnitude) {
        addCategoryIfMissing("earthquake");
        updateReading(magnitude);
    }

    public void updateReading(float magnitude) {
        if (magnitude == 0) {
            super.setAlertLevel("NORMAL");
        } else if (magnitude > 0 && magnitude < 6) {
            super.setAlertLevel("WARNING");
        } else if (magnitude > 6) {
            super.setAlertLevel("CRITICAL");
        } else {
            super.setAlertLevel("INVALID");
        }
    }
}