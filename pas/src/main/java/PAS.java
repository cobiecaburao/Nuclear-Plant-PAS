import java.util.ArrayList;

public class PAS implements PASSubject {
    ArrayList<PASObserver> pasObservers;
    private Message message;
    private Sensor sensor;
    
    private boolean alertActive;
    private boolean overrideEnabled;
    private String alertLevel;
    
    public PAS() {
        pasObservers = new ArrayList<PASObserver>();
        this.overrideEnabled = false;
        this.alertActive = false;
        this.alertLevel = "NONE";
    }

    public void registerObserver(PASObserver observer) {
        for (PASObserver obs : pasObservers) {
            if (obs.getPhoneNumber() == observer.getPhoneNumber()) {
                return;
            }
        }
        pasObservers.add(observer);
    }

    public void removeObserver(PASObserver observer) {
        pasObservers.remove(observer);
    }

    public void notifyObservers() {
        for (PASObserver observer : pasObservers) {
            observer.updateMessage(message);
        }
    }

    public void updateMessage(Message message) {
        // Check if sensor exists and has alert categories
        if (sensor != null && sensor.getAlertCategories() != null) {
            if (sensor.getAlertCategories().contains("earthquake")) {
                this.message = message;
            } else if (sensor.getAlertCategories().contains("pressure")) {
                this.message = message;
            } else if (sensor.getAlertCategories().contains("radiation")) {
                this.message = message;
            } else if (sensor.getAlertCategories().contains("temperature")) {
                this.message = message;
            } else {
                this.message = message;
            }
        } else {
            this.message = message;
        }
        
        if (!alertActive && this.message != null) {
            // If you have TestMessage class, uncomment the next line
            // this.message = new TestMessage(this.message);
        }
        notifyObservers();
    }
    
    // Getters and Setters for Admin class
    public void setOverrideEnabled(boolean overrideEnabled) {
        this.overrideEnabled = overrideEnabled;
    }
    
    public void setAlertActive(boolean alertActive) {
        this.alertActive = alertActive;
    }
    
    public void setAlertLevel(String alertLevel) {
        this.alertLevel = alertLevel;
    }
    
    public boolean isOverrideEnabled() {
        return overrideEnabled;
    }
    
    public boolean isAlertActive() {
        return alertActive;
    }
    
    public String getAlertLevel() {
        return alertLevel;
    }
    
    public Sensor getSensor() {
        return sensor;
    }
    
    public void setSensor(Sensor sensor) {
        this.sensor = sensor;
    }
}