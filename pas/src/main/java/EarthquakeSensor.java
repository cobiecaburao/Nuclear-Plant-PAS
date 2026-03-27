/**
 * @author CobieCaburao
 *
 */
public class EarthquakeSensor extends Sensor {
    public EarthquakeSensor (float magnitude) {
        if (magnitude == 0) {
            super.setAlertLevel("NORMAL");
        } else if (magnitude > 0 && magnitude < 6) {
            super.setAlertLevel("WARNING");
            super.setAlertCategories("earthquake");
        } else if (magnitude > 6) {
            super.setAlertLevel("CRITICAL");
            super.setAlertCategories("earthquake");
        } else {
            super.setAlertLevel("INVALID");
        }
    }


}