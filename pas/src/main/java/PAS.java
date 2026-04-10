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
        if (observer == null) return;
        
        // Using stream for duplicate check
        boolean exists = pasObservers.stream().anyMatch(obs -> obs.getPhoneNumber().equals(observer.getPhoneNumber()));
                
        if (!exists) {
            pasObservers.add(observer);
        }
    }

    public void removeObserver(PASObserver observer) {
        pasObservers.remove(observer);
    }

    public void notifyObservers() {
        for (PASObserver observer : pasObservers) {
            observer.updateMessage(message);
        }
    }

    public void updateMessage(Message newMessage) {
        if (sensor == null || sensor.getAlertCategories() == null || newMessage == null) {
            return; 
        }

        String level = sensor.getAlertLevel();
        if (level != null) {
            this.alertActive = level.equals("WARNING") || level.contains("CRITICAL");
        }

        Message decoratedMessage = newMessage;

        if (sensor.getAlertCategories().contains("earthquake")) {

            decoratedMessage = new EarthquakeWarning(decoratedMessage, sensor.getAlertLevel());

        }
        
        if (sensor.getAlertCategories().contains("pressure")) {

            decoratedMessage = new PressureWarning(decoratedMessage, sensor.getAlertLevel());

        }
        
        if (sensor.getAlertCategories().contains("radiation")) {

        decoratedMessage = new RadiationWarning(decoratedMessage, sensor.getAlertLevel());

        }
        
        if (sensor.getAlertCategories().contains("temperature")) {

            decoratedMessage = new TemperatureWarning(decoratedMessage, sensor.getAlertLevel());

        }

        if (!alertActive) {
            decoratedMessage = new TestMessage(decoratedMessage);
        }

        this.message = decoratedMessage;
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

    public Message getMessage() {
        return this.message;
    }
}