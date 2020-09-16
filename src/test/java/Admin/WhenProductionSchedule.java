package Admin;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import steps.Admin.ProductionScheduleSteps;

@RunWith(SerenityRunner.class)
public class WhenProductionSchedule {
    @Steps
    ProductionScheduleSteps steps;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    @Pending
    public void createProductionSchedule(){
        steps.open_page();
        steps.login("testUserAdmin","testUserAdmin1");
        steps.choose_menu_production_schedule();
        steps.create_button_click();
        steps.choose_product("Ботинки Step II S3 р.39 Nitras/7201");
        steps.choose_start_date("1");
        steps.choose_end_date("30");
        steps.type_planned_size("12");
        steps.choose_ppi_sample("test 18.02");
        steps.choose_production_operation("Прокат труб");
        steps.choose_workshop("Т3");
        steps.save_link_button_click();
        steps.add_ppi_to_chain_operation("Производство", 1);
        steps.save_graphic_button_click();
    }
}
