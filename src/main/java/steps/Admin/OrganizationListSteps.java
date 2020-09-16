package steps.Admin;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import pages.Admin.OrganizationListPage;

public class OrganizationListSteps {
    OrganizationListPage page;

    @Step
    public void open_page(){page.open();}
    @Step
    public void login(String login, String password){page.login(login, password);}
    @Step
    public void choose_menu_organization_list(){page.chooseMenuOrganizationList();}
    @Step
    public void choose_organization_type(String type_name){page.chooseOrganizationType(type_name);}
    @Step
    public void choose_organization(String organization_name){page.chooseOrganization(organization_name);}
    @Step
    public void edit_organization_button_click(String organization_name){page.editOrganizationButtonClick(organization_name);}
    @Step
    public void type_organization_data(String ogrn, String inn, String kpp, String email, String phone_number, String sap_code){
        page.typeOrganizationData(ogrn, inn, kpp, email, phone_number, sap_code);
    }
    @Step
    public void save_button_click(){page.saveButtonClick();}
    @Step
    public void add_button_click(){page.addButtonClick();}
    @Step
    public void edit_user_button_click(String user_name){page.editUserDataButtonClick(user_name);}
    @Step
    public void type_user_data(String surname, String name, String patronymic, String email, String password, String phone_number){
        page.typeUserData(surname, name, patronymic, email, password, phone_number);
    }
    @Step
    public void add_provider_button_click(){page.addProviderButtonClick();}
    @Step
    public void add_provider_to_inspector(String provider_name){page.addProviderToInspector(provider_name);}
    @Step
    public void fill_search_field(String search_request){page.fillSearchField(search_request);}
    @Step
    public void should_see_correct_text_in_organization_record(String text){
        Assertions.assertThat(page.correctOrganizationRecordInList(text)).isTrue();}
    @Step
    public void should_see_correct_text_in_user_record(String text){
        Assertions.assertThat(page.correctUserRecordInList(text)).isTrue();}
}
