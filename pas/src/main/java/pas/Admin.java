package pas;

public class Admin {
    private String name;

    public Admin(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void enableOverride(PAS pas) {
        pas.setOverrideEnabled(true);
    }

    public void disableOverride(PAS pas) {
        pas.setOverrideEnabled(false);
    }

    public void triggerManualAlert(PAS pas) {
        pas.setAlertActive(true);
        pas.setAlertLevel("EMERGENCY");
    }

    public void cancelAlert(PAS pas) {
        pas.setAlertActive(false);
        pas.setAlertLevel("NONE");
    }
}