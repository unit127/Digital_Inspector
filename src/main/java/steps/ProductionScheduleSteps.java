package steps;

import net.thucydides.core.annotations.Step;
import pages.ProductionSchedulePage;

public class ProductionScheduleSteps {
    ProductionSchedulePage page;

    @Step
    public void open_page(){page.open();}

    @Step
    public void login(String login, String pass){page.login(login, pass);}

    @Step
    public void choose_menu_production_schedule(){page.chooseMenuProductionSchedule();}
    @Step
    public void create_button_click(){page.createButtonClick();}
    @Step
    public void choose_product(String product_name){page.chooseProduct(product_name);}
    @Step
    public void choose_start_date(String start_date){page.chooseStartDate(start_date);}
    @Step
    public void choose_end_date(String end_date){page.chooseEndDate(end_date);}
    @Step
    public void type_planned_size(String planned_size){page.typePlannedSize(planned_size);}
    @Step
    public void choose_ppi_sample(String ppi_sample_name){page.choosePpiSample(ppi_sample_name);}
    @Step
    public void choose_production_operation(String operation_name){page.chooseProductionOperation(operation_name);}
    @Step
    public void choose_workshop(String workshop_name){page.chooseWorkshop(workshop_name);}
    @Step
    public void save_link_button_click(){page.saveLinkButtonClick();}
    @Step
    public void add_ppi_to_chain_operation(String group_operation_name, int chain_position){page.addPpiToChainOperations(group_operation_name, chain_position);}
    @Step
    public void save_graphic_button_click(){page.saveGraphicButtonClick();}
    @Step
    public void clear_plan_button_click(){page.clearPlanButtonClick();}
}
