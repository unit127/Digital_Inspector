package pages.Admin;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import pages.Admin.AdminLoginPage;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

@DefaultUrl("https://a2-stage.gpnsmonitor.ru/login")
public class PpiSamplePage extends PageObject {
    AdminLoginPage page;

    private final By menu_ppi_sample = xpath("//span[contains(text(),'Шаблоны ППИ')]");
    private final By create_button = xpath("//div[contains(text(),'Создать')]");
    private final By ppi_name_input = xpath("//input[@type='text']");
    private final By provider_field = xpath("//div[contains(text(),'Введите поставщика')]/..//div[@class='kit-select__value']");
    private final By provider_input = xpath("//div[contains(text(),'Введите поставщика')]/..//input[@placeholder='Поиск']");
    private final By product_field = xpath("//div[contains(text(),'Выберите изделия')]/..//div[@class='kit-select__value']");
    private final By product_input = xpath("//div[contains(text(),'Выберите изделия')]/..//input[@placeholder='Поиск']");

    private final By group_operation_field = xpath("//div[contains(text(),'Группа технологических операций')]/..//div[@class='kit-select__value']");
    private final By group_operation_input = xpath("//div[contains(text(),'Группа технологических операций')]/..//input[@placeholder='Поиск']");
    private final By operation_field = xpath("//div[contains(text(),'Технологическая операция')]/..//div[@class='kit-select__value']");
    private final By operation_input = xpath("//div[contains(text(),'Технологическая операция')]/..//input[@placeholder='Поиск']");
    private final By add_operation_button = By.xpath("//div[contains(text(),'Добавить операцию')]");

    private final By checking_characteristics_field = xpath("//div[contains(text(),'Проверяемые характеристики')]/..//div[@class='kit-select__value']");
    private final By checking_characteristics_input = xpath("//div[contains(text(),'Проверяемые характеристики')]/..//input[@placeholder='Поиск']");
    private final By criteria_acceptance_field = xpath("//div[contains(text(),'Критерии приемки')]/..//div[@class='kit-select__value']");
    private final By criteria_acceptance_input = xpath("//div[contains(text(),'Критерии приемки')]/..//input[@placeholder='Поиск']");
    private final By registration_method_field = xpath("//div[contains(text(),'Метод регистрации результатов')]/..//div[@class='kit-select__value']");
    private final By registration_method_input = xpath("//div[contains(text(),'Метод регистрации результатов')]/..//input[@placeholder='Поиск']");
    private final By inspector_action_field = xpath("//div[contains(text(),'Действия инспектора при несоответствии')]/..//div[@class='kit-select__value']");
    private final By inspector_action_input = xpath("//div[contains(text(),'Действия инспектора при несоответствии')]/..//input[@placeholder='Поиск']");
    private final By link_document_text = xpath("//textarea[@name='ref-docs']");

    private final By back_to_list_button = xpath("//button[contains(text(),'arrow_back_ios')]");

    private final By search_input = xpath("//input[@placeholder='Поиск шаблона или поставщика']");

    private final String provider_name = "//span[contains(text(),'%s')]";
    private final String product_name = "//span[contains(text(),'%s')]";
    private final String created_operation_group = "//div[@class='v-expansion-panel operation']";
    private final String created_operation = "//button[@class='v-expansion-panel-header sub-operation__head']";
    private final String choose_characteristic = "//div[contains(text(),'%s')]";
    private final String ppi_sample_name = "//td[contains(text(),'%s')]";
    private final String div_text_contains = "//div[contains(text(),'%s')]";
    private final String div_contains = "//div[contains(text(),'%s')]";
    private final String delete_button = "//span[contains(text(),'Autotest ppi name 2408')]/../..//button[@title=\"Удалить\"]";
    private final String kit_select = "//div[@class='kit-select-list']//div[contains(text(),'%s')]";
    private final String mark_contains = "//mark[contains(text(),'%s')]";

    private List<WebElementFacade> listGroupOperations = new ArrayList<WebElementFacade>();
    private List<WebElementFacade> listOperations = new ArrayList<WebElementFacade>();

    public void login(String email, String pass){page.authorization(email, pass);}

    public void chooseMenuPpiSample(){
        find(menu_ppi_sample).waitUntilClickable().click();
        //waitABit(500);
    }

    public void createButtonClick(){
        find(create_button).waitUntilClickable().click();
    }

    public void typePpiSampleName(String name){
        find(ppi_name_input).sendKeys(name);
    }

    public void chooseProvider(String name){
        //find(provider_field).waitUntilVisible();
        waitABit(5000);
        find(provider_field).waitUntilClickable().click();
        waitABit(500);
        find(provider_input).sendKeys(name);
        waitABit(1000);
        element(xpath(format(div_contains,name))).waitUntilClickable().click();
    }

    public void chooseProduct(String prod_name){
        waitABit(1000);
        find(product_field).waitUntilClickable().click();
        find(product_input).waitUntilVisible().sendKeys(prod_name);
        waitABit(1000);
        element(xpath(format(div_contains,prod_name))).waitUntilClickable().click();
    }

    public void chooseGroupOperation(String group_operation_name){
        find(group_operation_field).waitUntilClickable().click();
        waitABit(500);
        find(group_operation_input).waitUntilVisible().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        waitABit(1000);
        find(group_operation_input).sendKeys(group_operation_name);
        waitABit(1000);
        findAll(xpath(format(mark_contains,group_operation_name))).get(0).waitUntilVisible().click();
        //element(xpath(format(kit_select,group_operation_name))).waitUntilClickable().click();
        waitABit(500);
    }
    public void chooseOperation(String operation_name){
        find(operation_field).waitUntilClickable().click();
        waitABit(500);
        find(operation_input).waitUntilVisible().sendKeys(Keys.chord(Keys.CONTROL, "a"));
        waitABit(1000);
        find(operation_input).sendKeys(operation_name);
        waitABit(1000);
        findAll(xpath(format(mark_contains,operation_name))).get(0).waitUntilVisible().click();
        //element(xpath(format(kit_select,operation_name))).waitUntilClickable().click();
        waitABit(500);
    }
    public void addOperationButtonClick(){
        find(add_operation_button).waitUntilClickable().click();
    }

    public void chooseCreatedOperationGroup(String group_operation_name,int group_pos){
        //findAll(created_operation_group).get(group_pos).waitUntilClickable().click();
        element(xpath(format(div_contains, group_operation_name))).waitUntilClickable().click();
    }

    public void chooseCreatedOperation(String operation_position){
        //element(xpath(format(created_operation,operation_position))).click();
        element(xpath(format(div_contains, operation_position))).waitUntilClickable().click();
    }

    public void chooseCharacteristics(String check_char, String criterion_acceptance, String reg_method, String inspector_action){
        //moveTo(checking_characteristics_field).waitUntilClickable();
        findAll(checking_characteristics_field).get(findAll(checking_characteristics_field).size()-1).click();
        waitABit(1000);
        findAll(checking_characteristics_input).get(findAll(checking_characteristics_input).size()-1).sendKeys(check_char);
        waitABit(1000);
        findAll(xpath(format(div_contains,check_char))).get(findAll(xpath(format(div_contains,check_char))).size()-1).click();
        waitABit(1000);
        findAll(criteria_acceptance_field).get(findAll(criteria_acceptance_field).size()-1).waitUntilClickable().click();
        waitABit(1000);
        findAll(criteria_acceptance_input).get(findAll(criteria_acceptance_input).size()-1).sendKeys(criterion_acceptance);
        waitABit(1000);
        findAll(xpath(format(div_contains,criterion_acceptance))).get(findAll(xpath(format(div_contains,criterion_acceptance))).size()-1).click();
        waitABit(1000);
        findAll(registration_method_field).get(findAll(registration_method_field).size()-1).waitUntilClickable().click();
        waitABit(1000);
        findAll(registration_method_input).get(findAll(registration_method_input).size()-1).sendKeys(reg_method);
        waitABit(1000);
        findAll(xpath(format(div_contains,reg_method))).get(findAll(xpath(format(div_contains,reg_method))).size()-1).click();
        waitABit(1000);
        findAll(inspector_action_field).get(findAll(inspector_action_field).size()-1).waitUntilClickable().click();
        waitABit(1000);
        findAll(inspector_action_input).get(findAll(inspector_action_input).size()-1).sendKeys(inspector_action);
        waitABit(1000);
        findAll(xpath(format(div_contains,inspector_action))).get(findAll(xpath(format(div_contains,inspector_action))).size()-1).click();
        waitABit(1000);
    }

    public void chooseFrequencyMethod(){
        List<WebElementFacade> listMethod = findAll(By.xpath("//div[contains(text(),'Метод проверки')]/..//div[@class='kit-select__value']"));
        List<WebElementFacade> listFrequency = findAll(By.xpath("//div[contains(text(),'Частота проверки')]/..//div[@class='kit-select__value']"));


        listMethod.get(listMethod.size()-3).click();
        findAll(By.xpath("//div[contains(text(),'R (проведение проверки документации)')]"))
                .get(findAll(By.xpath("//div[contains(text(),'R (проведение проверки документации)')]")).size()-3)
                .waitUntilClickable().click();

        listMethod.get(listMethod.size()-2).click();
        findAll(By.xpath("//div[contains(text(),'S (при выполнении операции используются услуги субподрядчика)')]"))
                .get(findAll(By.xpath("//div[contains(text(),'S (при выполнении операции используются услуги субподрядчика)')]")).size() -2)
                .waitUntilClickable().click();

        listMethod.get(listMethod.size()-1).click();
        findAll(By.xpath("//div[contains(text(),'V (проведение проверки или проверка выполнения технологического процесса)')]"))
                .get(findAll(By.xpath("//div[contains(text(),'V (проведение проверки или проверка выполнения технологического процесса)')]")).size()-1)
                .waitUntilClickable().click();

        listFrequency.get(listFrequency.size()-3).click();
        findAll(By.xpath("//div[contains(text(),'A (только первую партию, затем выборочно)')]"))
                .get(findAll(By.xpath("//div[contains(text(),'A (только первую партию, затем выборочно)')]")).size()-3)
                .waitUntilClickable().click();

        listFrequency.get(listFrequency.size()-2).click();
        findAll(By.xpath("//div[contains(text(),'B (выборочно)')]"))
                .get(findAll(By.xpath("//div[contains(text(),'B (выборочно)')]")).size()-2)
                .waitUntilClickable().click();

        listFrequency.get(listFrequency.size()-1).click();
        findAll(By.xpath("//div[contains(text(),'C (100% проверка каждой единицы)')]"))
                .get(findAll(By.xpath("//div[contains(text(),'C (100% проверка каждой единицы)')]")).size()-1)
                .waitUntilClickable().click();


        findAll(By.xpath("//button[contains(text(),'Добавить')]")).get(listFrequency.size()-3).click();
        findAll(By.xpath("//button[contains(text(),'Добавить')]")).get(listFrequency.size()-2).click();
        findAll(By.xpath("//button[contains(text(),'Добавить')]")).get(listFrequency.size()-1).click();
        waitABit(1000);
    }

    public void typeLinkDocument(String text){
        //moveTo(link_document_text).waitUntilClickable();
        findAll(link_document_text).get(findAll(link_document_text).size()-1).sendKeys(text);
        //moveTo(By.xpath("//button[contains(text(),'Сохранить документ')]"));
        findAll(By.xpath("//button[contains(text(),'Сохранить документ')]"))
                .get(findAll(By.xpath("//button[contains(text(),'Сохранить документ')]")).size()-1)
                .click();
    }

    public void backToListButtonClick(){
        find(back_to_list_button).waitUntilClickable().click();
    }

    public void findPpiSample(String ppi_sample_name){
        find(search_input).waitUntilVisible().sendKeys(ppi_sample_name);
        waitABit(1000);
    }
    public void deletePpiSample(String sample_name){
        moveTo(xpath(format(delete_button,sample_name))).waitUntilClickable().click();
        //find(xpath(format(delete_button,sample_name))).waitUntilClickable().click();
    }

    public void chooseCreatedPpiSample(String name){
        element(xpath(format(ppi_sample_name,name))).click();
    }

    public void rightArrowButtonClick(){
        find(By.xpath("//i[contains(text(),'keyboard_arrow_right')]")).click();
    }

    public boolean correctProviderProductExistVisible(){
        return findAll(By.xpath("//div[@class='v-text-field__slot']")).size() ==2
                && findAll(By.xpath("//div[@class='v-text-field__slot']")).get(0).isVisible()
                && findAll(By.xpath("//div[@class='v-text-field__slot']")).get(1).isVisible();
    }

    public boolean correctParametersFrequencyMethod(String parameter_name){
        return findAll(xpath(format(div_text_contains,parameter_name))).size()==1
                && findAll(xpath(format(div_text_contains,parameter_name))).get(0).isVisible();
    }

    public boolean correctLinkDocumentText(String text){
        return find(link_document_text).getValue().equals(text);
    }

    public int getCreatedGroupOperationSize(){
        listGroupOperations = findAll(created_operation_group);
        return listGroupOperations.size();
    }

    public int getCreatedOperationSize(){
        listOperations = findAll(created_operation);
        return listOperations.size();
    }

}
