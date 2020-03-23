import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.InspectorPlanScheduleSteps;

@RunWith(SerenityRunner.class)
public class WhenInspectorPlanSchedule {
    @Steps
    InspectorPlanScheduleSteps steps;

    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    @Pending
    public void InspectorCheck(){
        steps.open_page();
        steps.login("testUserInspector","testUserInspector1");
        steps.fill_search_field("121");
        steps.open_founded_plan_schedule();
        int stagesCount = steps.get_stages_size();
        for (int i = 0; i < stagesCount; i++){
            /*if(i!=0){
                steps.type_general_comment("General super comment");
                steps.back_button_click();
                steps.fill_search_field("4243");
                steps.open_founded_plan_schedule();
            }*/
            steps.choose_stage(i);
            int operationsCount = steps.get_operations_size();
            for(int j = 0; j<operationsCount; j++){
                if(j!=0){
                    // steps.fill_search(factory_number);
                    // steps.open_card();
                    // steps.choose_stage(i);
                }

                steps.choose_operation(j);
                int characteristicsCount = steps.get_characteristics_size();
                for (int k = 0; k<characteristicsCount; k++){
                    steps.choose_characteristic(k);
                    steps.document_criteria_button_click();
                    steps.understand_button_click();
                    steps.type_comment("good comment 16.03");
                    steps.add_photo(k);
                    //steps.rotate_photo(k);
                    steps.add_photo(k+1);
                    steps.passed_button_click();
                    //steps.success_button_click();
                    //steps.inconsistencies_button_click();
                }
                steps.complete_control_button_click();
                if (j==operationsCount-1){
                    steps.slider_move(100);
                    steps.type_general_comment("General comment");
                    steps.back_button_click();
                }
            }
        }
    }
}
