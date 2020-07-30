package steps;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import pages.PlanSchedulePage;

public class PlanScheduleSteps {
    PlanSchedulePage page;

    @Step
    public void open_page(){page.open();}
    @Step
    public void login(String login, String pass){page.login(login, pass);}
    @Step
    public void choose_menu_plan_schedule(){page.chooseMenuPlanSchedule();}
    @Step
    public void choose_provider(String provider_name){page.chooseProvider(provider_name);}
    @Step
    public void choose_contract(String contract_number){page.chooseContract(contract_number);}
    @Step
    public void choose_annex(String annex_number){page.chooseAnnex(annex_number);}
    @Step
    public void choose_good(String good_name){page.chooseGood(good_name);}
    @Step
    public void choose_product(String product_number){page.chooseProduct(product_number);}
    @Step
    public void choose_plan_date(String plan_date){page.choosePlanDate(plan_date);}
    @Step
    public void copy_from_sample_button_click(){page.copyFromSampleButtonClick();}
    @Step
    public void clean_plan_schedule_button_click(){page.cleanPlanScheduleButtonClick();}
    @Step
    public void choose_plan_schedule_sample(String sample_name){page.choosePlanScheduleSample(sample_name);}
    @Step
    public void copy_button_click(){page.copyButtonClick();}
    @Step
    public void add_stage_button_click(){page.addStageButtonClick();}
    @Step
    public void cancel_button_click(){page.cancelButtonClick();}
    @Step
    public void should_see_correct_stage(String stage_name){
        Assertions.assertThat(page.correctStagesAdded(stage_name)).isTrue();}
    @Step
    public void should_see_correct_ppi_sample(String ppi_sample_name){
        Assertions.assertThat(page.correctPpiSampleSelectedVisible(ppi_sample_name)).isTrue();
    }
    @Step
    public void should_see_empty_diagram(){Assertions.assertThat(page.checkDiagramEmpty()).isTrue();}
    @Step
    public void should_not_see_deleted_stage(){Assertions.assertThat(page.checkStageDeleted()).isTrue();}
    @Step
    public void should_not_see_deleted_ppi_operation(){Assertions.assertThat(page.checkPpiOperationDeleted()).isTrue();}

}
