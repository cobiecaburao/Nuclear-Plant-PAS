/**
 * @author CobieCaburao
 *
 */
import java.util.ArrayList;

public class PAS implements PASSubject{
    ArrayList<PASObserver> pasObservers;
    Message message;
    Sensor sensor;
    
    private boolean alertActive;
    
    public PAS() {
        pasObservers = new ArrayList<PASObserver>();
    }

    public void registerObserver(PASObserver observer) {
        for (PASObserver obs : pasObservers) {
            if (obs.getPhoneNumber().equals(observer.getPhoneNumber())) {
                return;
            }
        }
        pasObservers.add(observer);
    }

    public void removeObserver(PASObserver observer) {
        pasObservers.remove(observer);
    }

    public void notifyObservers() {
        for( PASObserver observer: pasObservers) {
            observer.updateMessage(message);
        }
    }

    public void updateMessage(Message message) {
        if (sensor.getAlertCategories().contains("earthquake")) {
            this.message = new EarthquakeWarning(message, sensor.getAlertLevel());
        } else if (sensor.getAlertCategories().contains("pressure")) {
            this.message = new PressureWarning(message, sensor.getAlertLevel());
        } else if (sensor.getAlertCategories().contains("radiation")) {
            this.message = new RadiationWarning(message, sensor.getAlertLevel());
        } else if (sensor.getAlertCategories().contains("temperature")) {
            this.message = new TemperatureWarning(message, sensor.getAlertLevel());
        } else {
            return;
        }
        
        if (!alertActive) {
            this.message = new TestMessage(this.message);
        }
        notifyObservers();
    }
}

    // private boolean overrideEnabled;
    // private String alertLevel;

    // public PAS() {
    //     this.overrideEnabled = false;
    //     this.alertActive = false;
    //     this.alertLevel = "NONE";
    // }

    // public boolean isOverrideEnabled() {
    //     return overrideEnabled;
    // }

    // public void setOverrideEnabled(boolean overrideEnabled) {
    //     this.overrideEnabled = overrideEnabled;
    // }

    // public boolean isAlertActive() {
    //     return alertActive;
    // }

    // public void setAlertActive(boolean alertActive) {
    //     this.alertActive = alertActive;
    // }

    // public String getAlertLevel() {
    //     return alertLevel;
    // }

    // public void setAlertLevel(String alertLevel) {
    //     this.alertLevel = alertLevel;
    // }