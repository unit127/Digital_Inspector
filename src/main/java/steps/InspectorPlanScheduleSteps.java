package steps;

import net.thucydides.core.annotations.Step;
import pages.InspectorPlanSchedulePage;

public class InspectorPlanScheduleSteps {
    InspectorPlanSchedulePage page;

    @Step
    public void open_page(){page.open();}
    @Step
    public void login(String login, String pass){page.login(login, pass);}
    @Step
    public void fill_search_field(String search_request){page.fillSearchPlanSchedule(search_request);}
    @Step
    public void open_founded_plan_schedule(){page.openFoundedPlanSchedule();}
    @Step
    public void choose_stage(int stage_id){page.chooseStage(stage_id);}
    @Step
    public void choose_operation(int operation_id){page.chooseOperation(operation_id);}
    @Step
    public void choose_characteristic(int characteristic_id){page.chooseCharacteristic(characteristic_id);}
    @Step
    public void type_comment(String comment){page.typeComment(comment);}
    @Step
    public void document_criteria_button_click(){page.documentsCriteriaButtonClick();}
    @Step
    public void understand_button_click(){page.understandButtonClick();}
    @Step
    public void add_photo(int photo_id){page.addPhoto(photo_id);}
    @Step
    public void rotate_photo(int turn_count){page.rotatePhoto(turn_count);}
    @Step
    public void passed_button_click(){page.passedButtonClick();}
    @Step
    public void has_defect_button_click(){page.hasDefectButtonClick();}
    @Step
    public void take_decision_later_button_click(){page.takeDecisionLaterButton();}
    @Step
    public void complete_control_button_click(){page.completeControlButtonClick();}
    @Step
    public void type_general_comment(String comment){page.typeGeneralComment(comment);}
    @Step
    public void add_factory_number(String factory_number){page.addFactoryNumber(factory_number);}
    @Step
    public void slider_move(int move){page.sliderMove(move);}
    @Step
    public void back_button_click(){page.backButtonClick();}


    public int get_stages_size(){return page.getStagesSize();}
    public int get_operations_size(){return page.getOperationsSize();}
    public int get_characteristics_size(){return page.getCharacteristicsSize();}
}
