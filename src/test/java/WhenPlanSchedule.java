import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.PlanScheduleSteps;

@RunWith(SerenityRunner.class)
public class WhenPlanSchedule {
    @Steps
    PlanScheduleSteps steps;

    @Managed(driver ="chrome")
    WebDriver driver;

    @Test
    public void createPlanSchedule(){
        steps.open_page();
        steps.login("testUserAdmin","testUserAdmin1");
        steps.choose_menu_plan_schedule();
        for (int i = 0; i < 50; i++) {
            System.out.println("shag - " + i);
            steps.choose_provider("АО \"АК \"Корвет\"");
            steps.choose_contract("ДП_73273_23962_23651");
            steps.choose_annex("47");
            steps.choose_good("Задвижка КЗКГ-100х16-сМ4К2 газ КОФ");
            steps.choose_product("Изделие №5");
            steps.choose_plan_date("29");
            steps.copy_from_sample_button_click();
            steps.choose_plan_schedule_sample("shpg 2607");
            steps.copy_button_click();
            steps.should_see_correct_stage("Наличие РКД");
            //steps.should_not_see_deleted_ppi_operation();
            //steps.cancel_button_click();
            //steps.should_not_see_deleted_stage();
            steps.clean_plan_schedule_button_click();
            steps.should_see_empty_diagram();
            driver.navigate().refresh();
        }
    }
}
