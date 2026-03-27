/**
 * @author CobieCaburao
 *
 */
public class TemperatureSensor extends Sensor {
    public TemperatureSensor (float temperature) {
        if (temperature < 265) {
            super.setAlertLevel("LOW");
        } else if (temperature >= 265 && temperature <= 310) {
            super.setAlertLevel("NORMAL");
            
        } else if (temperature > 310 && temperature <= 320) {
            super.setAlertLevel("WARNING");
            super.setAlertCategories("temperature");
        } else {
            super.setAlertLevel("CRITICAL");
            super.setAlertCategories("temperature");
        }
    }
}
