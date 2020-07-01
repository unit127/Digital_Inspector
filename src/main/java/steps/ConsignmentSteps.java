package steps;

import net.thucydides.core.annotations.Step;
import pages.ConsignmentPage;

public class ConsignmentSteps {
    ConsignmentPage page;

    @Step
    public void open_page(){page.open();}
    @Step
    public void login(String login, String password){
        page.login(login, password);
    }
    @Step
    public void choose_menu_consignment(){page.chooseMenuConsignment();}
    @Step
    public void create_button_click(){page.createButtonClick();}
    @Step
    public void choose_expected_date_shipment(String date){page.chooseExpectedDateShipment(date);}
    @Step
    public void choose_expected_date_arrival(String date){page.chooseExpectedDateArrival(date);}
    @Step
    public void choose_provider(String provider_name){page.chooseProvider(provider_name);}
    @Step
    public void choose_delivery_type(String delivery_type){page.chooseDeliveryType(delivery_type);}
    @Step
    public void next_button_click(){page.nextButtonClick();}
    @Step
    public void choose_contract(String contract_number, int cargo_number){page.chooseContract(contract_number,cargo_number);}
    @Step
    public void choose_annex(String annex_number, int cargo_number){page.chooseAnnex(annex_number,cargo_number);}
    @Step
    public void choose_product(String product_number, int cargo_number){page.chooseProduct(product_number,cargo_number);}
    @Step
    public void type_quantity_weight(String quantity, String weight, int cargo_number){page.typeQuantityWeight(quantity, weight,cargo_number);}
    @Step
    public void add_cargo_button_click(){page.addCargoButtonClick();}
    @Step
    public void sf_number_type(String sf_number){page.sfNumberType(sf_number);}
    @Step
    public void cargo_position_number_type(String cargo_position){page.cargoPositionNumberType(cargo_position);}
    @Step
    public void choose_document_date(String date){page.chooseDocumentDate(date);}
    @Step
    public void trn_number_type(String trn_number){page.trnNumberType(trn_number);}
    @Step
    public void quantity_cargo_type(String quantity, int field_number){page.quantityCargoType(quantity, field_number);}
    @Step
    public void add_trn_button_click(){page.addTrnButtonClick();}
    @Step
    public void add_places_by_cargo_button_click(){page.addPlacesByCargoButtonClick();}
    @Step
    public void ts_number_type(String ts_number){page.tsNumberType(ts_number);}
    @Step
    public void done_button_click(){page.doneButtonClick();}
}
