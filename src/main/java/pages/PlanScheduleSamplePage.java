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
    private By material_name_input = By.xpath("//input[@label='Выберите материал']");
    private By ppi_sample_name_input = By.xpath("//input[@label='Выберите шаблон ППИ']");
    private By add_step_button = By.xpath("//div[contains(text(),'Добавить этап')]");
    private By new_stage_name_input = By.xpath("//input[@label='Поиск']");
    private By save_button = By.xpath("//div[@class='modal']//button[2]//div[1]");
    private By save_close_button = By.xpath("//button[3]//div[1]");
    private By previous_stage_list = By.xpath("//div[@class='add-step__list-item flex hoverable clickable p2 mb1']");
    private By group_operation_input = By.xpath("//input[@label='Поиск']");
    private By add_ppi_operations_button = By.xpath("//div[contains(text(),'Добавить операцию')]");
    private By choose_all_operations = By.xpath("//a[contains(text(),'Выбрать все')]");
    private By close_button = By.xpath("//div[contains(text(),'Закрыть')]");

    private String provider_name = "//span[contains(text(),'%s')]";
    private String material_name = "//span[contains(text(),'%s')]";
    private String ppi_sample_name = "//div[contains(text(),'%s')]";
    private String new_stage_name = "//div[contains(text(),'%s')]";
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

    public void chooseMaterial(String material_name){
        find(material_name_input).sendKeys(material_name);
        element(xpath(format(material_name,material_name))).click();
    }

    public void choosePpiSample(String sample_name){
        find(ppi_sample_name_input).sendKeys(sample_name);
        element(xpath(format(ppi_sample_name,sample_name))).click();
    }

    public void addStepButtonClick(){find(add_step_button).waitUntilClickable().click();}

    public void chooseNewStage(String stage_name){
        find(new_stage_name_input).sendKeys(stage_name);
        element(xpath(format(new_stage_name,stage_name))).click();
    }

    public void typeDuration(String days){
        findAll(By.xpath("//input[@type='text']")).get(3).sendKeys(days);
    }

    public void choosePreviousStage(int prev_stage_position){
        findAll(previous_stage_list).get(prev_stage_position).click();
    }

    public void saveButtonClick(){
        find(save_button).waitUntilClickable().click();
    }

    public void saveAndCloseButtonClick(){
        find(save_close_button).waitUntilClickable().click();
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
