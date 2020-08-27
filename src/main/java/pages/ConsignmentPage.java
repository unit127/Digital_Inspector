package pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;
import static java.lang.String.format;

@DefaultUrl("https://a2-stage.gpnsmonitor.ru/login")
public class ConsignmentPage extends PageObject {
    AdminLoginPage page;

    private final By menu_consignment = xpath("//span[contains(text(),'Грузовые партии')]");
    private final By create_button = xpath("//button//div[contains(text(),'Создать')]");
    private final By provider_input = xpath("//input[@label='Поставщик']");
    private final By delivery_type_input = xpath("//input[@label='Тип доставки']");
    private final By next_button = xpath("//button//div[contains(text(),'Далее')]");
    private final By contract_input = xpath("//input[@label='Договор']");
    private final By annex_input = xpath("//input[@label='Приложение']");
    private final By product_input = xpath("//input[@label='Товар']");
    private final By add_cargo_button = xpath("//button//div[contains(text(),'Добавить груз')]");
    private final By sf_input = xpath("//label[contains(text(),'Внешний номер счета фактуры')]/..//input");
    private final By cargo_position_input = xpath("//label[contains(text(),'Номер позиции груза по с/ф')]/..//input");
    private final By trn_input = xpath("//label[contains(text(),'Номер транспортной накладной')]/..//input");
    private final By quantity_cargo_input = xpath("//label[contains(text(),'Кол-во шт')]/..//input");
    private final By weight_cargo_input = xpath("//label[contains(text(),'Вес (кг)')]/..//input");
    private final By add_trn_button = xpath("//button//div[contains(text(),'Добавить ТРН')]");
    private final By add_places_by_cargo_button = xpath("//button//div[contains(text(),'Добавить места по грузу')]");
    private final By ts_number_input = xpath("//label[contains(text(),'Номер ТС/Трекера')]/..//input");
    private final By done_button = xpath("//button//div[contains(text(),'Готово')]");

    private final String choose_date = "//button//div[contains(text(),'%s')]";
    private final String span_contains = "//span[contains(text(),'%s')]";
    private final String div_contains = "//div[contains(text(),'%s')]";
    private final String choose_annex = "//div[@class='v-menu__content theme--light menuable__content__active v-autocomplete__content']//div[contains(text(),'%s')]";

    public void login(String email, String pass){page.authorization(email, pass);}

    public void chooseMenuConsignment(){
        find(menu_consignment).waitUntilClickable().click();
    }

    public void createButtonClick(){
        find(create_button).waitUntilClickable().click();
    }

    public void chooseExpectedDateShipment(String date){
        find(xpath("//label[contains(text(),'Ожидаемая дата отгрузки')]/..//input")).click();
        waitABit(500);
        element(xpath(format(choose_date,date))).waitUntilClickable().click();
    }

    public void chooseExpectedDateArrival(String date){
        find(xpath("//label[contains(text(),'Ожидаемая дата прибытия')]/..//input")).click();
        waitABit(500);
        findAll(xpath(format(choose_date,date))).get(1).waitUntilClickable().click();
    }

    public void chooseProvider(String provider_name){
        find(provider_input).sendKeys(provider_name);
        element(xpath(format(span_contains,provider_name))).waitUntilClickable().click();
    }

    public void chooseDeliveryType(String delivery_type){
        find(delivery_type_input).click();
        element(xpath(format(div_contains,delivery_type))).waitUntilClickable().click();
    }

    public void nextButtonClick(){
        find(next_button).waitUntilClickable().click();
    }

    public void chooseContract(String contract_number, int cargo_number){
        findAll(contract_input).get(cargo_number).sendKeys(contract_number);
        element(xpath(format(span_contains,contract_number))).waitUntilClickable().click();
    }

    public void chooseAnnex(String annex_number, int cargo_number){
        findAll(annex_input).get(cargo_number).click();
        element(xpath(format(choose_annex,annex_number))).waitUntilClickable().click();
    }

    public void chooseProduct(String product_name, int cargo_number){
        findAll(product_input).get(cargo_number).click();
        waitABit(500);
        findAll(xpath(format(div_contains,product_name))).get(cargo_number).waitUntilClickable().click();
    }

    public void typeQuantityWeight(String quantity, String weight, int cargo_number){
        findAll(xpath("//label[contains(text(),'Кол-во')]/..//input")).get(cargo_number).sendKeys(quantity);
       // findAll(xpath("//label[contains(text(),'Вес (кг)')]/..//input")).get(cargo_number).sendKeys(weight);
    }

    public void addCargoButtonClick(){
        find(add_cargo_button).waitUntilClickable().click();
    }

    public void sfNumberType(String sf_number){
        find(sf_input).sendKeys(sf_number);
    }

    public void cargoPositionNumberType(String cargo_position){
        find(cargo_position_input).sendKeys(cargo_position);
    }

    public void chooseDocumentDate(String date){
        find(xpath("//label[contains(text(),'Дата')]/..//input")).click();
        findAll(xpath(format(choose_date,date))).get(2).waitUntilClickable().click();
    }

    public void trnNumberType(String trn_number){
        find(trn_input).sendKeys(trn_number);
    }

    public void quantityCargoType(String quantity, int field_number){
        findAll(quantity_cargo_input).get(0).sendKeys(quantity);
        findAll(quantity_cargo_input).get(1).sendKeys(quantity);
    }

    public void addTrnButtonClick(){
        find(add_trn_button).waitUntilClickable().click();
    }

    public void addPlacesByCargoButtonClick(){
        find(add_places_by_cargo_button).waitUntilClickable().click();
    }

    public void tsNumberType(String ts_number){
        for(int i = 0; i < findAll(ts_number_input).size(); i++){
            findAll(ts_number_input).get(i).sendKeys(ts_number);
        }
    }

    public void doneButtonClick(){
        find(done_button).waitUntilClickable().click();
    }

    public boolean checkCalculatedWeight(int cargo_number){return findAll(weight_cargo_input).get(cargo_number).getValue().equals('0');}

    public boolean checkQuantityProducts(){return findAll(xpath("//div[@class='flex justify-start mb-3']")).size()>0;}
}
