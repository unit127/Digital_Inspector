package pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

@DefaultUrl("https://a2-stage.gpnsmonitor.ru/login")
public class ProductionSchedulePage extends PageObject {
    AdminLoginPage page;

    private By menu_production_schedule = xpath("//body//a[1]");
    private By create_button = xpath("//div[contains(text(),'Создать')]");
    private By product_name_input = xpath("//input[@label='Название товара']");
    private By planned_size_input = xpath("//label[contains(text(),'Плановый объем (т)')]/..//input");
    private By ppi_sample_name_input = xpath("//input[@label='Шаблон ППИ']");
    private By production_operation = xpath("//label[contains(text(),'Производственные операции')]/..//input");
    private By workshop = xpath("//label[contains(text(),'Цех')]/..//input");
    private By save_link_button = xpath("//button[contains(text(),'Сохранить звено')]");
    private By ppi_button = xpath("//button[contains(text(),'ППИ')]");
    private By choose_all_button = xpath("//button[contains(text(),'Выбрать все')]");
    private By add_operation_button = xpath("//div[contains(text(),'Добавить операцию')]");
    private By save_button = xpath("//div[contains(text(),'Сохранить')]");
    private By save_graphic_button = xpath("//div[contains(text(),'Сохранить график')]");
    private By clear_plan_button = xpath("//div[contains(text(),'Сбросить план')]");


    private String choose_date = "//button//div[contains(text(),'%s')]";
    private String ppi_sample_name = "//div[contains(text(),'%s')]";
    private String div_contains = "//div[contains(text(),'%s')]";

    public void login(String email, String pass){page.authorization(email, pass);}

    public void chooseMenuProductionSchedule(){
        find(menu_production_schedule).waitUntilClickable().click();
    }

    public void createButtonClick(){find(create_button).waitUntilClickable().click();}

    public void chooseProduct(String product_name){
        find(product_name_input).click();
        find(By.xpath("//div[contains(text(),'.36 Nitras')]")).waitUntilClickable().click();
    }

    public void chooseStartDate(String date){
        find(By.xpath("//label[contains(text(),'Начало')]/..//input")).click();
        findAll(xpath(format(choose_date,date))).get(0).waitUntilClickable().click();
    }

    public void chooseEndDate(String date){
        find(By.xpath("//label[contains(text(),'Окончание')]/..//input")).click();
        int date_size = findAll(xpath(format(choose_date,date))).size();
        findAll(xpath(format(choose_date,date))).get(date_size-1).waitUntilClickable().click();
    }

    public void typePlannedSize(String size){
        find(planned_size_input).sendKeys(size);
    }

    public void choosePpiSample(String sample_name){
        find(ppi_sample_name_input).click();//sendKeys(sample_name);
        element(xpath(format(ppi_sample_name,sample_name))).click();
    }

    public void chooseProductionOperation(String operation_name){
        find(production_operation).click();
        element(xpath(format(div_contains, operation_name))).click();
    }

    public void chooseWorkshop(String workshop_name){
        find(workshop).click();
        element(xpath(format(div_contains, workshop_name))).click();
    }

    public void saveLinkButtonClick(){find(save_link_button).waitUntilClickable().click();}

    public void addPpiToChainOperations(String group_operation_name, int chain_position){
        findAll(ppi_button).get(chain_position-1).click();
        element(xpath(format(div_contains,group_operation_name))).click();
        find(choose_all_button).click();
        find(add_operation_button).waitUntilClickable().click();
        waitABit(500);
        findAll(save_button).get(1).click();
    }

    public void saveGraphicButtonClick(){find(save_graphic_button).waitUntilClickable().click();}

    public void clearPlanButtonClick(){find(clear_plan_button).waitUntilClickable().click();}

}
