/**
 * @author CobieCaburao
 *
 */
public class PressureSensor extends Sensor {
    public PressureSensor (float pressure) {
        if (pressure < 9.0) {
            super.setAlertLevel("CRITICAL LOW");
            super.setAlertCategories("pressure");
        }
        else if (pressure >= 9.50 && pressure <= 11.05) {
            super.setAlertLevel("NORMAL");
        }
        else if ((pressure >= 9.0 && pressure < 9.50) || (pressure > 11.05 && pressure <= 11.50)) {
            super.setAlertLevel("WARNING");
            super.setAlertCategories("pressure");
        }
        else if (pressure > 11.50) {
            super.setAlertLevel("CRITICAL HIGH");
            super.setAlertCategories("pressure");
        }
        else {
            super.setAlertLevel("INVALID");
        }
    }


}
