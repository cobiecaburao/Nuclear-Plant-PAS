/**
 * @author CobieCaburao
 *
 */
public class RadiationSensor extends Sensor {
    public RadiationSensor (float radiation) {
        if (radiation < 0) {
            super.setAlertLevel("INVALID");
        }
        else if (radiation < 1.0) {
            super.setAlertLevel("NORMAL");
        }
        else if (radiation < 100) {
            super.setAlertLevel("WARNING");
            super.setAlertCategories("radiation");
        }
        else {
            super.setAlertLevel("CRITICAL");
            super.setAlertCategories("radiation");
        }
    }


}