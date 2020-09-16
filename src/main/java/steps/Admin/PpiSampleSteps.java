package steps.Admin;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import pages.Admin.PpiSamplePage;

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
    public void choose_group_operation(String group_operation_name){page.chooseGroupOperation(group_operation_name);}
    @Step
    public void choose_operation(String operation_name){page.chooseOperation(operation_name);}
    @Step
    public void add_operation_button_click(){page.addOperationButtonClick();}
    @Step
    public void choose_created_operation_group(String group_operation_name,int position){page.chooseCreatedOperationGroup(group_operation_name,position);}
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
    @Step
    public void choose_created_ppi_sample(String ppi_sample_name){page.chooseCreatedPpiSample(ppi_sample_name);}
    @Step
    public void back_to_list_button(){page.backToListButtonClick();}
    @Step
    public void delete_sample(String sample_name){page.deletePpiSample(sample_name);}
    @Step
    public void find_ppi_sample(String sample_name){page.findPpiSample(sample_name);}
    @Step
    public void should_see_provider_product(){
        Assertions.assertThat(page.correctProviderProductExistVisible()).isTrue();}
    @Step
    public void should_see_correct_parameters_frequency_method(String parameter_name){
        Assertions.assertThat(page.correctParametersFrequencyMethod(parameter_name)).isTrue();}
    @Step
    public void click_right_arrow_button(){page.rightArrowButtonClick();}
    @Step
    public void should_see_correct_link_document_text(String text){Assertions.assertThat(page.correctLinkDocumentText(text));}

    public int get_created_operation_size(){return page.getCreatedOperationSize();}
    public int get_created_group_operation_size(){return page.getCreatedGroupOperationSize();}

}
