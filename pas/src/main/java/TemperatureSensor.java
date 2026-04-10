/**
 * @author CobieCaburao
 *
 */
public class TemperatureSensor extends Sensor {
    public TemperatureSensor(float temperature) {
        addCategoryIfMissing("temperature");
        updateReading(temperature);
    }

    public void updateReading(float temperature) {
        if (temperature < 265) {
            setAlertLevel("LOW");
        } else if (temperature >= 265 && temperature <= 310) {
            setAlertLevel("NORMAL");
        } else if (temperature > 310 && temperature <= 320) {
            setAlertLevel("WARNING");
        } else {
            setAlertLevel("CRITICAL");
        }
    }
}
