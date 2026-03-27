/**
 * @author CobieCaburao
 *
 */
import java.util.ArrayList;

public abstract class Sensor {
    private String alertLevel;
    private ArrayList<String> alertCategories = new ArrayList<>();

    public void setAlertLevel(String alertLevel) {
        this.alertLevel = alertLevel;
    }

    public void setAlertCategories(String alertCategory) {
        this.alertCategories.add(alertCategory);
    }

    public String getAlertLevel() {
        return this.alertLevel;
    }

    public ArrayList<String> getAlertCategories() {
        return alertCategories;
    }
}
