import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.DirectorySteps;

@RunWith(SerenityRunner.class)
public class WhenDirectories {
    @Steps
    DirectorySteps steps;
    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    @Pending
    public void addDirectory(){
        steps.open_page();
        steps.login("testUserAdmin","testUserAdmin1");
        steps.choose_menu_directories();
        steps.choose_type_directories();
        steps.type_code("123");
        steps.type_name("name");
        steps.add_button_click();
        steps.should_see_correct_record("123");
        steps.should_see_correct_record("name");
        steps.delete_directory("name");
        steps.should_not_see_record("name");
    }
}
