package pages.Admin;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.Admin.AdminLoginPage;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

@DefaultUrl("https://a2-stage.gpnsmonitor.ru/login")
public class OrganizationListPage extends PageObject {
    AdminLoginPage page;

    private final By menu_organization_list = xpath("//span[contains(text(),'Список организаций')]");
    private final By organization_type_select = xpath("//div[@class='v-select__selections']");
    private final By save_button = xpath("//button//div[contains(text(),'Сохранить')]");
    private final By add_button = xpath("//button//div[contains(text(),'Добавить')]");
    private final By add_provider_button = xpath("//button//div[contains(text(),'Добавить поставщика')]");
    private final By provider_name_input = xpath("//input[@label='Введите поставщика']");
    private final By search_field = xpath("//input[@placeholder='Поиск']");

    private final String div_contains = "//div[contains(text(),'%s')]";
    private final String span_contains = "//span[contains(text(),'%s')]";
    private final String td_contains = "//td[contains(text(),'%s')]";
    private final String edit_organization_button = "//td//div[contains(text(),'%s')]/../../../td//button";
    private final String edit_user_button = "//td[contains(text(),'%s')]/..//button";
    private final String organization_data_input = "//label[contains(text(),'%s')]/..//input";
    private final String user_data_input = "//label[contains(text(),'%s')]/..//input";

    public void login(String email, String pass){page.authorization(email, pass);}

    public void chooseMenuOrganizationList(){
        find(menu_organization_list).waitUntilClickable().click();
    }

    public void chooseOrganizationType(String type_name){
        find(organization_type_select).waitUntilClickable().click();
        element(xpath(format(div_contains,type_name))).waitUntilClickable().click();
    }

    public void chooseOrganization(String organization_name){
        element(xpath(format(div_contains,organization_name))).waitUntilClickable().click();
    }

    public void editOrganizationButtonClick(String organization_name){
        element(xpath(format(edit_organization_button,organization_name))).waitUntilClickable().click();
    }

    public void typeOrganizationData(String ogrn, String inn, String kpp, String email, String phone_number, String sap_code){
        element(xpath(format(organization_data_input, "ОГРН"))).sendKeys(Keys.LEFT_CONTROL+"a");
        element(xpath(format(organization_data_input, "ОГРН"))).sendKeys(ogrn);
        element(xpath(format(organization_data_input, "ИНН"))).sendKeys(Keys.LEFT_CONTROL+"a");
        element(xpath(format(organization_data_input, "ИНН"))).sendKeys(inn);
        element(xpath(format(organization_data_input, "КПП"))).sendKeys(Keys.LEFT_CONTROL+"a");
        element(xpath(format(organization_data_input, "КПП"))).sendKeys(kpp);
        element(xpath(format(organization_data_input, "E-mail"))).sendKeys(Keys.LEFT_CONTROL+"a");
        element(xpath(format(organization_data_input, "E-mail"))).sendKeys(email);
        element(xpath(format(organization_data_input, "Телефон"))).sendKeys(Keys.LEFT_CONTROL+"a");
        element(xpath(format(organization_data_input, "Телефон"))).sendKeys(phone_number);
        element(xpath(format(organization_data_input, "Код SAP"))).sendKeys(Keys.LEFT_CONTROL+"a");
        element(xpath(format(organization_data_input, "Код SAP"))).sendKeys(sap_code);
    }

    public void saveButtonClick(){
        find(save_button).waitUntilClickable().click();
    }

    public void addButtonClick(){
        find(add_button).waitUntilClickable().click();
    }

    public void typeUserData(String surname, String name, String patronymic, String email, String password, String phone_number){
        element(xpath(format(user_data_input, "Фамилия"))).sendKeys(Keys.LEFT_CONTROL+"a");
        element(xpath(format(user_data_input, "Фамилия"))).sendKeys(surname);
        element(xpath(format(user_data_input, "Имя"))).sendKeys(Keys.LEFT_CONTROL+"a");
        element(xpath(format(user_data_input, "Имя"))).sendKeys(name);
        element(xpath(format(user_data_input, "Отчество"))).sendKeys(Keys.LEFT_CONTROL+"a");
        element(xpath(format(user_data_input, "Отчество"))).sendKeys(patronymic);
        element(xpath(format(user_data_input, "E-mail / Логин"))).sendKeys(Keys.LEFT_CONTROL+"a");
        element(xpath(format(user_data_input, "E-mail / Логин"))).sendKeys(email);
        element(xpath(format(user_data_input, "Пароль"))).sendKeys(Keys.LEFT_CONTROL+"a");
        element(xpath(format(user_data_input, "Пароль"))).sendKeys(password);
        element(xpath(format(user_data_input, "Телефон"))).sendKeys(Keys.LEFT_CONTROL+"a");
        element(xpath(format(user_data_input, "Телефон"))).sendKeys(phone_number);

    }

    public void editUserDataButtonClick(String user_name){
        element(xpath(format(edit_user_button,user_name))).waitUntilClickable().click();
    }

    public void addProviderButtonClick(){
        find(add_provider_button).waitUntilClickable().click();
    }

    public void addProviderToInspector(String provider_name){
        find(provider_name_input).sendKeys(provider_name); //"ао \"ак \"корвет\""
        element(xpath(format(span_contains,provider_name))).waitUntilClickable().click();
        findAll(save_button).get(1).waitUntilClickable().click();
    }

    public void fillSearchField(String search_request){
        find(search_field).sendKeys(search_request);
    }

    public boolean correctOrganizationRecordInList(String text){return findAll(xpath(format(div_contains,text))).size() == 1;}

    public boolean correctUserRecordInList(String text){return findAll(xpath(format(td_contains,text))).size() == 1;}


}
