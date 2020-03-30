package steps;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import pages.InspectorProductionSchedulePage;

import java.io.IOException;

public class InspectorProductionScheduleSteps {
    InspectorProductionSchedulePage page;

    @Step
    public void open_page(){page.open();}

    @Step
    public void login(String email, String pass){ page.inspectorLogin(email, pass);}
    @Step
    public void choose_section(String sectionName){ page.chooseSection(sectionName);}
    @Step
    public void choose_workshop(String workshop_name){page.chooseWorkshop(workshop_name);}
    @Step
    public void choose_operation(int oper_id){page.chooseOperation(oper_id);}
    @Step
    public void choose_order(String order_name){page.chooseOrder(order_name);}
    @Step
    public void choose_material(String material_name){page.chooseMaterial(material_name);}
    @Step
    public void choose_action(String action_name){page.chooseAction(action_name);}
    @Step
    public void fill_search(String package_number){page.fillSearch(package_number);}
    @Step
    public void create_new_package_click(){page.createNewPackageClick();}
    @Step
    public void fill_package_fields(String package_number, String part_number, String melting_number, String total_weight, String quantity, String total_length, int save_id){
        page.fillPackageFields(package_number, part_number, melting_number, total_weight, quantity, total_length, save_id);
    }
    @Step
    public void should_see_correct_data(String package_number, String button_number){
        Assertions.assertThat(page.shouldSeeCorrectData(package_number, button_number)).isTrue();
    }
    @Step
    public void should_see_correct_certificate(String cert_number){
        Assertions.assertThat(page.shouldSeeCorrectCertificate(cert_number)).isTrue();
    }
    @Step
    public void edit_certificate(String cert_number, String package_number) throws IOException {page.editСertificate(cert_number, package_number);}

    @Step
    public void choose_admin_menu(String menu_number){page.chooseAdminMenu(menu_number);}
    @Step
    public void input_certificate(){page.inputCertificate();}
}