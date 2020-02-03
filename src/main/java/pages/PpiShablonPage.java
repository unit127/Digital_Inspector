package pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

@DefaultUrl()
public class PpiShablonPage extends PageObject {
    AdminLoginPage page;

    private By menu_ppi_shablon = By.xpath("//body//a[4]");
    private By create_button = By.xpath("//div[contains(text(),'Создать')]");
    private By ppi_name_input = By.xpath("//input[@type='text']");
    private By provider_name_input = By.xpath("//input[@label='Введите поставщика']");
    private By product_name_input = By.xpath("//input[@label='Выберите изделия']");

    private By group_operation_input = By.xpath("//input[@label='Группа технологических операций']");
    private By group_operation = By.xpath("//div[contains(text(),'Производство')]");
    private By operation_input = By.xpath("//input[@label='Технологическая операция']");
    private By operation = By.xpath("//div[contains(text(),'Контроль испытательного оборудования')]");
    private By add_operation_button = By.xpath("//div[contains(text(),'Добавить операцию')]");

    private String provider_name = "//span[contains(text(),'%s')]";
    private String product_name = "//span[contains(text(),'%s')]";


    public void login(String email, String pass){page.authorization(email, pass);}

    public void chooseMenuPpiShablon(){
        find(menu_ppi_shablon).waitUntilClickable().click();
        //waitABit(500);
    }

    public void createButtonClick(){
        find(create_button).waitUntilClickable().click();
    }

    public void typePpiShablonName(String name){
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

}
