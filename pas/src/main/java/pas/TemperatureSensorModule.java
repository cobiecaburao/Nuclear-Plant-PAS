public class TemperatureSensorModule {

    public SensorState classify(double temperature) {
        if (temperature < 265) {
            return SensorState.INVALID;
        }
        else if (temperature <= 310) {
            return SensorState.NORMAL;
        }
        else if (temperature <= 320) {
            return SensorState.WARNING;
        }
        else {
            return SensorState.CRITICAL;

        }
    }
}