package steps;

import net.thucydides.core.annotations.Step;
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
    public void add_step_button_click(){page.addStepButtonClick();}
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

}
