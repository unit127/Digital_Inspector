import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.PpiSampleSteps;

@RunWith(SerenityRunner.class)
public class WhenPpiSample {
    @Steps
    PpiSampleSteps steps;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    public void createPpiSample(){
        steps.open_page();
        steps.login("testUserAdmin","testUserAdmin1");
        steps.choose_menu_ppi();
        steps.create_button_click();
        steps.type_sample_name("Autotest ppi name");
        steps.create_button_click();
        steps.choose_provider("Корвет");
        steps.choose_product("Труба дымовая");
        steps.choose_group_operation();
        steps.choose_operation();
        steps.add_operation_button_click();
        steps.choose_created_operation_group("1");
        steps.choose_created_operation("1");
        steps.choose_characteristics(
                "Наличие, ведение","Срок действия не истек",
                "Приложить фото подтвержающих документов","Отразить степень критичности");
        steps.choose_frequency_method();
        steps.type_link_document("link document");
    }
}
