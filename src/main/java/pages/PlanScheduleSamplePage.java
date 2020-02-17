package pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

@DefaultUrl("https://a2-stage.gpnsmonitor.ru/")
public class PlanScheduleSamplePage extends PageObject {
    AdminLoginPage page;

    private By menu_plan_schedule_sample = By.xpath("//body//a[5]");
    private By create_button = By.xpath("//div[contains(text(),'Создать')]");
    private By plan_schedule_name_input = By.xpath("//input[@type='text']");
    private By provider_name_input = By.xpath("//input[@label='Выберите поставщика']");
    private By product_name_input = By.xpath("//input[@label='Выберите материал']");
    private By ppi_sample_name_input = By.xpath("//input[@label='Выберите шаблон ППИ']");
    private By add_step_button = By.xpath("//div[contains(text(),'Добавить этап')]");
    private By new_step_name_input = By.xpath("//input[@label='Поиск']");
    private By save_button = By.xpath("//div[@class='modal']//button[2]//div[1]");
    private By save_close_button = By.xpath("//button[3]//div[1]");
    private By previous_step_list = By.xpath("//div[@class='add-step__list-item flex hoverable clickable p2 mb1']");
    private By group_operation_input = By.xpath("//input[@label='Поиск']");
    private By add_ppi_operations_button = By.xpath("//div[contains(text(),'Добавить операцию')]");
    private By choose_all_operations = By.xpath("//a[contains(text(),'Выбрать все')]");
    private By close_button = By.xpath("//div[contains(text(),'Закрыть')]");

    private String provider_name = "//span[contains(text(),'%s')]";
    private String product_name = "//span[contains(text(),'%s')]";
    private String ppi_sample_name = "//div[contains(text(),'%s')]";
    private String new_step_name = "//div[contains(text(),'%s')]";
    private String group_operation = "//div[contains(text(),'%s')]";

    public void login(String email, String pass){page.authorization(email, pass);}

    public void chooseMenuPlanScheduleSample(){
        find(menu_plan_schedule_sample).waitUntilClickable().click();
    }
    public void createButtonClick(){
        find(create_button).waitUntilClickable().click();
    }

    public void typePlanScheduleSampleName(String name){
        find(plan_schedule_name_input).sendKeys(name);
    }

    public void chooseProvider(String name){
        find(provider_name_input).sendKeys(name);
        element(xpath(format(provider_name,name))).click();
    }

    public void chooseProduct(String prod_name){
        find(product_name_input).sendKeys(prod_name);
        element(xpath(format(product_name,prod_name))).click();
    }

    public void choosePpiSample(String sample_name){
        find(ppi_sample_name_input).sendKeys(sample_name);
        element(xpath(format(ppi_sample_name,sample_name))).click();
    }

    public void addStepButtonClick(){find(add_step_button).waitUntilClickable().click();}

    public void chooseNewStep(String step_name){
        find(new_step_name_input).sendKeys(step_name);
        element(xpath(format(new_step_name,step_name))).click();
    }

    public void typeDuration(String days){
        findAll(By.xpath("//input[@type='text']")).get(3).sendKeys(days);
    }

    public void choosePreviousStep(int prev_step_position){
        findAll(previous_step_list).get(prev_step_position).click();
    }

    public void addPpiToStep(String group_operation_name){
        findAll(By.xpath("//div[@class='flex spaced-x']//a[contains(text(),'ППИ')]")).get(0).click();
        find(group_operation_input).sendKeys(group_operation_name);
        element(xpath(format(group_operation,group_operation_name))).click();
        //findAll(By.xpath("//div[@class='add-operation__list-item flex clickable p2']")).get(0).click();
        find(choose_all_operations).click();
        find(add_ppi_operations_button).click();
        find(close_button).click();
    }

}
