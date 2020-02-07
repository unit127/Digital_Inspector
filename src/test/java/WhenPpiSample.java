import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
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
    @Pending
    public void createPpiSample(){
        steps.open_page();
        steps.login("testUserAdmin","testUserAdmin1");
        steps.choose_menu_ppi();
        steps.create_button_click();
        steps.type_sample_name("Autotest ppi name4");
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
        steps.choose_menu_ppi();
       }

    @Test
    public void ppiSampleCheck(){
        steps.open_page();
        steps.login("testUserAdmin","testUserAdmin1");
        steps.choose_menu_ppi();
        steps.click_right_arrow_button();
        steps.choose_created_ppi_sample("Autotest ppi name4");
        steps.should_see_provider_product();
        steps.choose_created_operation_group("1");
        steps.choose_created_operation("1");
        steps.should_see_correct_parameters_frequency_method("Наличие, ведение");
        steps.should_see_correct_parameters_frequency_method("Срок действия не истек");
        steps.should_see_correct_parameters_frequency_method("Приложить фото подтвержающих документов");
        steps.should_see_correct_parameters_frequency_method("Отразить степень критичности");
        steps.should_see_correct_parameters_frequency_method("R (проведение проверки документации) / A (только первую партию, затем выборочно)");
        steps.should_see_correct_parameters_frequency_method("S (при выполнении операции используются услуги субподрядчика) / B (выборочно)");
        steps.should_see_correct_parameters_frequency_method("V (проведение проверки или проверка выполнения технологического процесса) / C (100% проверка каждой единицы)");
    }
}
