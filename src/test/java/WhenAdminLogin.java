import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.AdminLoginSteps;

@RunWith(SerenityRunner.class)
public class WhenAdminLogin {
    @Steps
    AdminLoginSteps steps;

    @Managed(driver = "chrome")
    WebDriver driver;
    @Test
    public void authorization(){
        steps.open_login_page();
        steps.type_email("testUserAdmin");
        steps.type_password("testUserAdmin1");
        steps.click_enter_button();
    }
    @Test
    public void errorMessage(){
        steps.open_login_page();
        steps.authorization("testUserAdmin1","testUserAdmin1");
        steps.should_see_error_message();
    }
}
