package steps;

import net.thucydides.core.annotations.Step;
import pages.PpiSamplePage;

public class PpiSampleSteps {
    PpiSamplePage page;

    @Step
    public void open_page(){page.open();}
    @Step
    public void login(String login, String pass){page.login(login, pass);}
    @Step
    public void choose_menu_ppi(){page.chooseMenuPpiSample();}
    @Step
    public void create_button_click(){page.createButtonClick();}
    @Step
    public void type_sample_name(String name){page.typePpiSampleName(name);}
    @Step
    public void choose_provider(String prov_name){page.chooseProvider(prov_name);}
    @Step
    public void choose_product(String prod_name){page.chooseProduct(prod_name);}
    @Step
    public void choose_group_operation(){page.chooseGroupOperation();}
    @Step
    public void choose_operation(){page.chooseOperation();}
    @Step
    public void add_operation_button_click(){page.addOperationButtonClick();}
    @Step
    public void choose_created_operation_group(String position){page.chooseCreatedOperationGroup(position);}
    @Step
    public void choose_created_operation(String position){page.chooseCreatedOperation(position);}
    @Step
    public void choose_characteristics(String check_char, String criterion_acceptance, String reg_method, String inspector_action ){
        page.chooseCharacteristics(check_char, criterion_acceptance, reg_method, inspector_action);
    }
    @Step
    public void choose_frequency_method(){page.chooseFrequencyMethod();}
    @Step
    public void type_link_document(String text){page.typeLinkDocument(text);}
}
