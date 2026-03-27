package pas;

public class PAS {
    private boolean overrideEnabled;
    private boolean alertActive;
    private String alertLevel;

    public PAS() {
        this.overrideEnabled = false;
        this.alertActive = false;
        this.alertLevel = "NONE";
    }

    public boolean isOverrideEnabled() {
        return overrideEnabled;
    }

    public void setOverrideEnabled(boolean overrideEnabled) {
        this.overrideEnabled = overrideEnabled;
    }

    public boolean isAlertActive() {
        return alertActive;
    }

    public void setAlertActive(boolean alertActive) {
        this.alertActive = alertActive;
    }

    public String getAlertLevel() {
        return alertLevel;
    }

    public void setAlertLevel(String alertLevel) {
        this.alertLevel = alertLevel;
    }
}