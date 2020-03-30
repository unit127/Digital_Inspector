import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.InspectorPlanScheduleSteps;
import steps.InspectorProductionScheduleSteps;

import java.io.IOException;

@RunWith(SerenityRunner.class)
public class WhenInspectorProductionSchedule {
    @Steps
    InspectorProductionScheduleSteps steps;

    @Managed(driver ="chrome")
    WebDriver driver;

    @Test
    @Pending
    public void addNewPackage(){
        steps.open_page();
        steps.login("testUserInspector", "testUserInspector1");
        steps.choose_section("Производственный график");
        steps.choose_workshop("4");
        steps.choose_operation(1);
        steps.choose_order("№ 4500845537");
        steps.choose_material("Труба");
        steps.choose_action("Ввод данных по пакетам");
        steps.create_new_package_click();
        steps.fill_package_fields("888880", "88", "88","88","88","88", 0);
        steps.should_see_correct_data("88","88");
    }

    @Test
    @Pending
    public void PpiCheck(){
        steps.open_page();
        steps.login("testUserInspector", "testUserInspector1");
        steps.choose_section("Производственный график");
        steps.choose_workshop("4");
        steps.choose_operation(1);
        steps.choose_order("№ 4500845537");
        steps.choose_material("Подшлемник");
        steps.choose_action("Выполнить контроль ППИ");
        
    }

    @Test
    @Pending
    public void test() throws IOException, InterruptedException {
        //steps.edit_сertificate("888800","88888");
        steps.open_page();
        steps.login("testinsp@test.ru","1780");
        steps.choose_section("Производственный график");
        steps.choose_workshop("4");
        steps.choose_operation(5);
        steps.choose_order("№ 4500845537");
        steps.choose_material("Труба");
        steps.should_see_correct_certificate("120005");
        driver.get("https://a2-test.gpnsmonitor.ru/");
        steps.login("testUserAdmin","testUserAdmin1");
        steps.choose_admin_menu("2");
        steps.input_certificate();

    }

}