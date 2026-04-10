import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AdminTest {

    private Admin admin;
    private PAS pas;

    @BeforeEach
    public void setUp() {
        admin = new Admin("John");
        pas = new PAS();
    }

    @Test
    public void constructor_setsAdminName() {
        assertEquals("John", admin.getName());
    }

    @Test
    public void pas_overrideIsFalseByDefault() {
        assertFalse(pas.isOverrideEnabled());
    }

    @Test
    public void enableOverride_setsOverrideToTrue() {
        admin.enableOverride(pas);
        assertTrue(pas.isOverrideEnabled());
    }

    @Test
    public void disableOverride_setsOverrideToFalse() {
        admin.enableOverride(pas);
        admin.disableOverride(pas);
        assertFalse(pas.isOverrideEnabled());
    }

    @Test
    public void triggerManualAlert_activatesEmergencyAlert() {
        admin.triggerManualAlert(pas);
        assertTrue(pas.isAlertActive());
        assertEquals("EMERGENCY", pas.getAlertLevel());
    }

    @Test
    public void cancelAlert_deactivatesAlert() {
        admin.triggerManualAlert(pas);
        admin.cancelAlert(pas);
        assertFalse(pas.isAlertActive());
        assertEquals("NONE", pas.getAlertLevel());
    }
}