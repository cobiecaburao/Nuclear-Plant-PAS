public class RadiationSensorModule {

    public SensorState classify(double radiation) {
        if (radiation < 0) {
            return SensorState.INVALID;
        }
        else if ((radiation < 1.0)) {
            return SensorState.NORMAL;
        }
        else if (radiation < 100.0) {
            return SensorState.WARNING;
        }
        else {
            return SensorState.CRITICAL;
        }
    }
}