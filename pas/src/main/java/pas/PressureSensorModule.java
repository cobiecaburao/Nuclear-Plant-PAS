public class PressureSensorModule {

    public SensorState classify(double pressure) {
        if (pressure < 9.0 || pressure > 11.50) {
            return SensorState.CRITICAL;
        }
        else if ((pressure >= 9.0 && pressure < 9.50) || (pressure > 11.05 && pressure <= 11.50)) {
            return SensorState.WARNING;
        }
        else if (pressure >= 9.50 && pressure <= 11.05) {
            return SensorState.NORMAL;
        }
        else {
            return SensorState.INVALID;
        }
    }
}