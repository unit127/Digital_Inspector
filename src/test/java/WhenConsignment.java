import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.ConsignmentSteps;

@RunWith(SerenityRunner.class)
public class WhenConsignment {
    @Steps
    ConsignmentSteps steps;
    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    @Pending
    public void addConsignment(){
        steps.open_page();
        steps.login("testUserAdmin", "testUserAdmin1");
        steps.choose_menu_consignment();
        steps.create_button_click();
        steps.choose_expected_date_shipment("21");
        steps.choose_expected_date_arrival("27");
        steps.choose_provider("Корвет");
        steps.choose_delivery_type("Автомобильная");
        steps.next_button_click();
        steps.choose_contract("ДП_64025_23962_33416", 0);
        steps.choose_annex("6", 0);
        steps.choose_product("Дроссель ДР-100х21.04", 0);
        steps.type_quantity_weight("1","10", 0);
        steps.should_see_calculated_weight(0);
        steps.add_cargo_button_click();
        steps.choose_contract("ДП_64025_23962_33416",1);
        steps.choose_annex("6", 1);
        steps.choose_product("Дроссель ДР-100х21.04", 1);
        steps.type_quantity_weight("2","20",1);
        steps.should_see_calculated_weight(1);
        steps.should_see_product_quantity();
        steps.next_button_click();
        steps.sf_number_type("102030");
        steps.cargo_position_number_type("3");
        steps.choose_document_date("27");
        steps.trn_number_type("405060");
        steps.quantity_cargo_type("2",0);
        steps.ts_number_type("T792KE");
        steps.done_button_click();
    }
}
