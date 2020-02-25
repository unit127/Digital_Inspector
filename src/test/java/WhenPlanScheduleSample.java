import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.PlanScheduleSampleSteps;

@RunWith(SerenityRunner.class)
public class WhenPlanScheduleSample {
    @Steps
    PlanScheduleSampleSteps steps;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    public void createPlanScheduleSample(){
        steps.open_page();
        steps.login("testUserAdmin","testUserAdmin1");
        steps.choose_plan_schedule_sample_menu();
        steps.create_button_click();
        steps.type_plan_schedule_sample_name("Autotest PG sample");
        steps.create_button_click();
        steps.choose_provider("Корвет");
        steps.choose_material("Труба дымовая");
        steps.choose_ppi_sample("test 18.02");
        steps.add_stage_button_click();
        steps.choose_new_stage("Изготовление ЖБИ");
        steps.type_duration("3");
        steps.save_close_button_click();
        steps.add_ppi_to_step("Производство", 1);
        steps.choose_plan_schedule_sample_menu();
        steps.should_see_correct_provider_material();
        steps.should_see_correct_ppi_sample("test 18.02");
        steps.should_see_correct_stage_exist("Изготовление ЖБИ");
        steps.sho

    }
}