package pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

@DefaultUrl("https://a2-test.gpnsmonitor.ru/")
public class PpiSamplePage extends PageObject {
    AdminLoginPage page;

    private By menu_ppi_sample = By.xpath("//body//a[4]");
    private By create_button = By.xpath("//div[contains(text(),'Создать')]");
    private By ppi_name_input = By.xpath("//input[@type='text']");
    private By provider_name_input = By.xpath("//input[@label='Введите поставщика']");
    private By product_name_input = By.xpath("//input[@label='Выберите изделия']");

    private By group_operation_input = By.xpath("//input[@label='Группа технологических операций']");
    private By group_operation = By.xpath("//div[contains(text(),'Производство')]");
    private By operation_input = By.xpath("//input[@label='Технологическая операция']");
    private By operation = By.xpath("//div[contains(text(),'Контроль испытательного оборудования')]");
    private By add_operation_button = By.xpath("//div[contains(text(),'Добавить операцию')]");

    private By checking_characteristics_input = By.xpath("//input[@label='Проверяемые характеристики']");
    private By criteria_acceptance_input = By.xpath("//input[@label='Критерии приемки']");
    private By registration_method_input = By.xpath("//input[@label='Метод регистрации результатов']");
    private By inspector_action_input = By.xpath("//input[@label='Действия инспектора при несоответствии']");
    private By link_document_text = By.xpath("//textarea[@name='ref-docs']");

    private String provider_name = "//span[contains(text(),'%s')]";
    private String product_name = "//span[contains(text(),'%s')]";
    private String created_operation_group = "//div[@class='operations-list expansion-panel v-item-group theme--light v-expansion-panels v-expansion-panels--focusable']//div[%s]//button[1]";
    private String created_operation = "//div[@class='v-expansion-panel sub-operation'][%s]";
    private String choose_characteristic = "//span[contains(text(),'%s')]";

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
        find(checking_characteristics_input).sendKeys(check_char);
        element(xpath(format(choose_characteristic,check_char))).click();
        waitABit(500);
        find(criteria_acceptance_input).sendKeys(criterion_acceptance);
        element(xpath(format(choose_characteristic,criterion_acceptance))).click();
        waitABit(500);
        find(registration_method_input).sendKeys(reg_method);
        element(xpath(format(choose_characteristic,reg_method))).click();
        waitABit(500);
        find(inspector_action_input).sendKeys(inspector_action);
        element(xpath(format(choose_characteristic,inspector_action))).click();
        waitABit(500);
    }

    public void chooseFrequencyMethod(){
        findAll(By.xpath("//input[@label='Метод проверки']")).get(0).click();
        find(By.xpath("//div[contains(text(),'R (проведение проверки документации)')]")).click();

        findAll(By.xpath("//input[@label='Метод проверки']")).get(1).click();
        find(By.xpath("//div[contains(text(),'R (проведение проверки документации)')]")).click();

        findAll(By.xpath("//input[@label='Метод проверки']")).get(2).click();
        find(By.xpath("//div[contains(text(),'R (проведение проверки документации)')]")).click();

        findAll(By.xpath("//input[@label='Частота проверки']")).get(0).click();
        find(By.xpath("//div[contains(text(),'B (выборочно)')]")).click();

        findAll(By.xpath("//input[@label='Частота проверки']")).get(1).click();
        find(By.xpath("//div[contains(text(),'B (выборочно)')]")).click();

        findAll(By.xpath("//input[@label='Частота проверки']")).get(2).click();
        find(By.xpath("//div[contains(text(),'B (выборочно)')]")).click();


        findAll(By.xpath("//button[contains(text(),'Добавить')]")).get(0).click();
        findAll(By.xpath("//button[contains(text(),'Добавить')]")).get(1).click();
        findAll(By.xpath("//button[contains(text(),'Добавить')]")).get(2).click();
        waitABit(1000);
    }

    public void typeLinkDocument(String text){
        find(link_document_text).sendKeys(text);
        find(By.xpath("//button[contains(text(),'Сохранить документ')]"));
    }


}
