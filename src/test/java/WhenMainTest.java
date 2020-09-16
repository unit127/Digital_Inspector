import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.Admin.PlanScheduleSampleSteps;
import steps.Admin.PpiSampleSteps;

@RunWith(SerenityRunner.class)
public class WhenMainTest {
    @Steps
    PpiSampleSteps ppiSteps;
    @Steps
    PlanScheduleSampleSteps pssSteps;
    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    @Pending
    public void mainTest(){
        ppiSteps.open_page();
        ppiSteps.login("testUserAdmin","testUserAdmin1");
        ppiSteps.choose_menu_ppi();
        ppiSteps.create_button_click();
        ppiSteps.type_sample_name("ppi name 08073");
        ppiSteps.create_button_click();
        ppiSteps.choose_provider("Корвет");
        ppiSteps.choose_product("Труба дымовая");
        ppiSteps.choose_group_operation("[B7] Производство");
        ppiSteps.choose_operation("Контроль испытательного оборудования");
        ppiSteps.add_operation_button_click();
        ppiSteps.choose_created_operation_group("",0);
        ppiSteps.choose_created_operation("1");
        ppiSteps.choose_characteristics(
                "Наличие, ведение","Срок действия не истек",
                "Приложить фото подтвержающих документов","Отразить степень критичности");
        ppiSteps.choose_frequency_method();
        ppiSteps.type_link_document("link document");
        pssSteps.choose_plan_schedule_sample_menu();
        pssSteps.create_button_click();
        pssSteps.type_plan_schedule_sample_name("Autotest PG sample3");
        pssSteps.create_button_click();
        pssSteps.choose_provider("Корвет");
        pssSteps.choose_material("Труба дымовая");
        pssSteps.choose_ppi_sample("ppi name 08073");
        pssSteps.add_stage_button_click();
        pssSteps.choose_new_stage("Изготовление ЖБИ");
        pssSteps.type_duration("3");
        pssSteps.save_close_button_click();
        pssSteps.add_ppi_to_step("Производство", 1);
        pssSteps.choose_plan_schedule_sample_menu();
        pssSteps.choose_created_plan_schedule_sample("Autotest PG sample3");
        pssSteps.should_see_correct_provider_material();
        pssSteps.should_see_correct_ppi_sample("ppi name 08073");
        pssSteps.should_see_correct_stage_exist("Изготовление ЖБИ");
        pssSteps.should_see_ppi_operation_deleted();
        pssSteps.should_see_stage_deleted();
        pssSteps.should_see_empty_diagram();
        pssSteps.choose_plan_schedule_sample_menu();
        //pssSteps.delete_plan_schedule_sample("Autotest PG sample");
    }

    @Test
    @Pending
    public void test(){
        ppiSteps.open_page();
        ppiSteps.login("testUserAdmin","testUserAdmin1");
        pssSteps.choose_plan_schedule_sample_menu();
        pssSteps.choose_created_plan_schedule_sample("Autotest PG sample2");
        pssSteps.add_ppi_to_step("Производство", 1);
        pssSteps.choose_plan_schedule_sample_menu();
    }
}
