/**
 * @author CobieCaburao
 *
 */
import java.util.ArrayList;

public abstract class Sensor {
    private String alertLevel = "NONE";
    private ArrayList<String> alertCategories = new ArrayList<>();

    public void setAlertLevel(String alertLevel) {
        this.alertLevel = alertLevel;
    }

    public void addCategoryIfMissing(String category) {
        if (!this.alertCategories.contains(category)) {
            this.alertCategories.add(category);
        }
    }

    public String getAlertLevel() {
        return this.alertLevel;
    }

    public ArrayList<String> getAlertCategories() {
        return alertCategories;
    }
}