package pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

@DefaultUrl("https://a2-stage.gpnsmonitor.ru/login")
public class PpiSamplePage extends PageObject {
    AdminLoginPage page;

    private By menu_ppi_sample = xpath("//span[contains(text(),'Шаблоны ППИ')]");
    private By create_button = xpath("//div[contains(text(),'Создать')]");
    private By ppi_name_input = xpath("//input[@type='text']");
    private By provider_name_input = xpath("//input[@label='Введите поставщика']");
    private By product_name_input = xpath("//input[@label='Выберите изделия']");

    private By group_operation_input = xpath("//input[@label='Группа технологических операций']");
    private By group_operation = xpath("//div[contains(text(),'Производство')]");
    private By operation_input = xpath("//input[@label='Технологическая операция']");
    private By operation = xpath("//div[contains(text(),'Контроль испытательного оборудования')]");
    private By add_operation_button = By.xpath("//div[contains(text(),'Добавить операцию')]");

    private By checking_characteristics_input = xpath("//input[@label='Проверяемые характеристики']");
    private By criteria_acceptance_input = xpath("//input[@label='Критерии приемки']");
    private By registration_method_input = xpath("//input[@label='Метод регистрации результатов']");
    private By inspector_action_input = xpath("//input[@label='Действия инспектора при несоответствии']");
    private By link_document_text = xpath("//textarea[@name='ref-docs']");

    private By back_to_list_button = xpath("//button[contains(text(),'arrow_back_ios')]");

    private String provider_name = "//span[contains(text(),'%s')]";
    private String product_name = "//span[contains(text(),'%s')]";
    private String created_operation_group = "//div[@class='operations-list expansion-panel v-item-group theme--light v-expansion-panels v-expansion-panels--focusable']//div[%s]//button[1]";
    private String created_operation = "//div[@class='v-expansion-panel sub-operation'][%s]";
    private String choose_characteristic = "//div[contains(text(),'%s')]";
    private String ppi_sample_name = "//td[contains(text(),'%s')]";
    private String div_text_contains = "//div[contains(text(),'%s')]";
    private String delete_button = "//td[contains(text(),'%s')]/..//button[@title=\"Удалить\"]";

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
        find(provider_name_input).sendKeys(name);
        element(xpath(format(provider_name,name))).click();
    }

    public void chooseProduct(String prod_name){
        find(product_name_input).sendKeys(prod_name);
        element(xpath(format(product_name,prod_name))).click();
    }

    public void chooseGroupOperation(){
        find(group_operation_input).click();
        find(group_operation).click();
    }
    public void chooseOperation(){
        find(operation_input).click();
        find(operation).click();
    }
    public void addOperationButtonClick(){
        find(add_operation_button).waitUntilClickable().click();
    }

    public void chooseCreatedOperationGroup(String group_pos){
        element(xpath(format(created_operation_group,group_pos))).click();
    }

    public void chooseCreatedOperation(String oper_pos){
        element(xpath(format(created_operation,oper_pos))).click();
    }

    public void chooseCharacteristics(String check_char, String criterion_acceptance, String reg_method, String inspector_action){
        moveTo(checking_characteristics_input).waitUntilClickable();
        find(checking_characteristics_input).click();//sendKeys(check_char);
        element(xpath(format(choose_characteristic,check_char))).click();
        waitABit(500);
        find(criteria_acceptance_input).click();//sendKeys(criterion_acceptance);
        element(xpath(format(choose_characteristic,criterion_acceptance))).click();
        waitABit(500);
        find(registration_method_input).click();//sendKeys(reg_method);
        element(xpath(format(choose_characteristic,reg_method))).click();
        waitABit(500);
        find(inspector_action_input).click();//sendKeys(inspector_action);
        element(xpath(format(choose_characteristic,inspector_action))).click();
        waitABit(500);
    }

    public void chooseFrequencyMethod(){
        findAll(By.xpath("//input[@label='Метод проверки']")).get(0).click();
        find(By.xpath("//div[contains(text(),'R (проведение проверки документации)')]")).click();

        findAll(By.xpath("//input[@label='Метод проверки']")).get(1).click();
        find(By.xpath("//div[contains(text(),'S (при выполнении операции используются услуги субподрядчика)')]")).click();

        findAll(By.xpath("//input[@label='Метод проверки']")).get(2).click();
        find(By.xpath("//div[contains(text(),'V (проведение проверки или проверка выполнения технологического процесса)')]")).click();

        findAll(By.xpath("//input[@label='Частота проверки']")).get(0).click();
        find(By.xpath("//div[contains(text(),'A (только первую партию, затем выборочно)')]")).click();

        findAll(By.xpath("//input[@label='Частота проверки']")).get(1).click();
        find(By.xpath("//div[contains(text(),'B (выборочно)')]")).click();

        findAll(By.xpath("//input[@label='Частота проверки']")).get(2).click();
        find(By.xpath("//div[contains(text(),'C (100% проверка каждой единицы)')]")).click();


        findAll(By.xpath("//button[contains(text(),'Добавить')]")).get(0).click();
        findAll(By.xpath("//button[contains(text(),'Добавить')]")).get(1).click();
        findAll(By.xpath("//button[contains(text(),'Добавить')]")).get(2).click();
        waitABit(1000);
    }

    public void typeLinkDocument(String text){
        moveTo(link_document_text).waitUntilClickable();
        find(link_document_text).sendKeys(text);
        moveTo(By.xpath("//button[contains(text(),'Сохранить документ')]"));
        find(By.xpath("//button[contains(text(),'Сохранить документ')]")).click();
    }

    public void backToListButtonClick(){
        find(back_to_list_button).waitUntilClickable().click();
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


}
