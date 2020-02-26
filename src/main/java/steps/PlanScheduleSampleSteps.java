package steps;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import pages.PlanScheduleSamplePage;

public class PlanScheduleSampleSteps {
    PlanScheduleSamplePage page;

    @Step
    public void open_page(){page.open();}
    @Step
    public void login(String login, String pass){page.login(login, pass);}
    @Step
    public void choose_plan_schedule_sample_menu(){page.chooseMenuPlanScheduleSample();}
    @Step
    public void create_button_click(){page.createButtonClick();}
    @Step
    public void type_plan_schedule_sample_name(String name){page.typePlanScheduleSampleName(name);}
    @Step
    public void choose_provider(String provider_name){page.chooseProvider(provider_name);}
    @Step
    public void choose_material(String material_name){page.chooseMaterial(material_name);}
    @Step
    public void choose_ppi_sample(String ppi_sample_name){page.choosePpiSample(ppi_sample_name);}
    @Step
    public void add_stage_button_click(){page.addStageButtonClick();}
    @Step
    public void choose_new_stage(String stage_name){page.chooseNewStage(stage_name);}
    @Step
    public void choose_previous_stage(int prev_stage_position){page.choosePreviousStage(prev_stage_position);}
    @Step
    public void type_duration(String duration){page.typeDuration(duration);}
    @Step
    public void save_button_click(){page.saveButtonClick();}
    @Step
    public void save_close_button_click(){page.saveAndCloseButtonClick();}
    @Step
    public void add_ppi_to_step(String group_operation_name, int step_position){page.addPpiToStage(group_operation_name,step_position);}
    @Step
    public void delete_stage(int stage_position){page.deleteStage(stage_position);}
    @Step
    public void clean_plan_schedule_button_click(){page.cleanPlanScheduleButtonClick();}
    @Step
    public void choose_created_plan_schedule_sample(String sample_name){page.choosePlanScheduleSample(sample_name);}
    @Step
    public void delete_plan_schedule_sample(String pg_sample_name){
        page.deletePlanScheduleSample(pg_sample_name);
    }
    @Step
    public void should_see_correct_provider_material(){
        Assertions.assertThat(page.correctProviderMaterialExistVisible()).isTrue();
    }
    @Step
    public void should_see_correct_ppi_sample(String ppi_sample_name){
        Assertions.assertThat(page.correctPpiSampleSelectedVisible(ppi_sample_name)).isTrue();
    }
    @Step
    public void should_see_correct_stage_exist(String stage_name){
        Assertions.assertThat(page.correctStageExist(stage_name)).isTrue();
    }
    @Step
    public void should_see_empty_diagram(){
        Assertions.assertThat(page.checkDiagramEmpty()).isTrue();
    }
    @Step
    public void should_see_stage_deleted(){
        Assertions.assertThat(page.checkStageDeleted()).isTrue();
    }
    @Step
    public void should_see_ppi_operation_deleted(){
        Assertions.assertThat(page.checkPpiOperationDeleted()).isTrue();
    }

}
