public class SeismometerModule {

    public SensorState classify(int seismicLevel) {

        if (seismicLevel < 0) {
            return SensorState.INVALID;
        }
        else if (seismicLevel == 0)
        {
            return SensorState.NORMAL;
        }
        else if (seismicLevel == 1)
        {
            return SensorState.WARNING;
        }
        else
        {
            return SensorState.CRITICAL;
        }
    }
}