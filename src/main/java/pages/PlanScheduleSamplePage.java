package pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

@DefaultUrl("https://a2-stage.gpnsmonitor.ru/login")
public class PlanScheduleSamplePage extends PageObject {
    AdminLoginPage page;

    private By menu_plan_schedule_sample = By.xpath("//body//a[5]");
    private By create_button = By.xpath("//div[contains(text(),'Создать')]");
    private By plan_schedule_name_input = By.xpath("//input[@type='text']");
    private By provider_name_input = By.xpath("//input[@label='Выберите поставщика']");
    private By material_name_input = By.xpath("//input[@label='Выберите материал']");
    private By ppi_sample_name_input = By.xpath("//input[@label='Выберите шаблон ППИ']");
    private By add_stage_button = By.xpath("//div[contains(text(),'Добавить этап')]");
    private By new_stage_name_input = By.xpath("//input[@label='Поиск']");
    private By save_button = By.xpath("//div[@class='modal']//button[2]//div[1]");
    private By save_close_button = By.xpath("//button[3]//div[1]");
    private By previous_stage_list = By.xpath("//div[@class='add-step__list-item flex hoverable clickable p2 mb1']");
    private By group_operation_input = By.xpath("//input[@label='Поиск']");
    private By add_ppi_operations_button = By.xpath("//div[contains(text(),'Добавить операцию')]");
    private By choose_all_operations = By.xpath("//a[contains(text(),'Выбрать все')]");
    private By close_button = By.xpath("//div[contains(text(),'Закрыть')]");
    private By delete_stage_button = By.xpath("//span[contains(text(),'Удалить этап')]");
    private By clean_plan_schedule_button = By.xpath("//div[contains(text(),'Очистить план-график')]");
    private By delete_ppi_operation = By.xpath("//div[@class='add-operation__summary-remove']");

    private String provider_name = "//span[contains(text(),'%s')]";
    private String choose_material_name = "//span[contains(text(),'%s')]";
    private String ppi_sample_name = "//div[contains(text(),'%s')]";
    private String new_stage_name = "//span[contains(text(),'%s')]";
    private String group_operation = "//span[contains(text(),'%s')]";
    private String choose_plan_schedule_sample = "//div[contains(text(),'%s')]";
    private String stage_exist = "//div[@class='gantt-chart__task-list']//div[contains(text(),'%s')]";
    private String ppi_operation_exist = "//div[contains(text(),'%s')]";
    private String delete_plan_schedule = ".//div[contains(text(),'%s')]/..//button[2]";

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
        waitABit(500);
        find(provider_name_input).sendKeys(name);
        element(xpath(format(provider_name,name))).click();
    }

    public void chooseMaterial(String material_name){
        find(material_name_input).sendKeys(material_name);
        element(xpath(format(choose_material_name,material_name))).click();
    }

    public void choosePpiSample(String sample_name){
        find(ppi_sample_name_input).click();//sendKeys(sample_name);
        element(xpath(format(ppi_sample_name,sample_name))).click();
    }

    public void addStageButtonClick(){
        waitABit(500);
        find(add_stage_button).waitUntilClickable().click();
    }

    public void chooseNewStage(String stage_name){
        find(new_stage_name_input).sendKeys(stage_name);
        element(xpath(format(new_stage_name,stage_name))).click();
    }

    public void typeDuration(String days){
        findAll(By.xpath("//div[@class='v-text-field__slot']//input")).get(2).sendKeys(days);
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

    public void addPpiToStage(String group_operation_name, int stage_position){
        findAll(By.xpath("//div[@class='flex spaced-x']//a[contains(text(),'ППИ')]")).get(stage_position-1).click();
        find(group_operation_input).sendKeys(group_operation_name);
        element(xpath(format(group_operation,group_operation_name))).click();
        //findAll(By.xpath("//div[@class='add-operation__list-item flex clickable p2']")).get(0).click();
        find(choose_all_operations).click();
        find(add_ppi_operations_button).click();
        waitABit(500);
        find(close_button).waitUntilClickable().click();
    }

    public void deleteStage(int stage_position){
        findAll(By.xpath("//a[contains(text(),'Редактировать')]")).get(stage_position-1).click();
        find(delete_stage_button).click();
    }

    public void cleanPlanScheduleButtonClick(){
        find(clean_plan_schedule_button).waitUntilClickable().click();
    }

    public void choosePlanScheduleSample(String plan_sample_name){
        element(xpath(format(choose_plan_schedule_sample,plan_sample_name))).click();
        waitABit(500);
    }

    public void deletePlanScheduleSample(String pg_sample_name){
        element(xpath(format(delete_plan_schedule,pg_sample_name))).click();
    }

    public boolean correctProviderMaterialExistVisible(){
        return findAll(By.xpath("//div[@class='v-text-field__slot']")).size() ==2
                && findAll(By.xpath("//div[@class='v-text-field__slot']")).get(0).isVisible()
                && findAll(By.xpath("//div[@class='v-text-field__slot']")).get(1).isVisible();
    }

    public boolean correctPpiSampleSelectedVisible(String sample_name){
        System.out.println("test ppi sample name - " + find(ppi_sample_name_input).getValue());
        /*int k = 0;
        while(find(ppi_sample_name_input).getValue().equals("") || k <3){
            chooseMenuPlanScheduleSample();
            choosePlanScheduleSample("Autotest PG sample");
            k++;
        }*/

        return find(ppi_sample_name_input).getValue().equals(sample_name);
    }

    public boolean correctStageExist(String stage_name){
        return findAll(xpath(format(stage_exist, stage_name))).size() == 1;
    }

    public boolean checkDiagramEmpty(){
        return findAll(By.xpath("//div[@class='gantt-chart__task-list']//div[@class='flex flex-column']")).size() == 0;
    }

    public boolean checkStageDeleted(){
        String stage_delete = findAll("//div[@class='gantt-chart__task-list']//div[1]//div[2]//div[1]").get(0).getText();
        System.out.println("test - " + stage_delete);
        findAll(By.xpath("//a[contains(text(),'Редактировать')]")).get(0).click();
        find(delete_stage_button).click();
        return findAll(stage_exist,stage_delete).size()==0;
    }

    public boolean checkPpiOperationDeleted(){
        findAll(By.xpath("//div[@class='flex spaced-x']//a[contains(text(),'ППИ')]")).get(0).click();
        String ppi_operation_delete = findAll("//div[@class='add-operation__summary-item']//div[1]").get(0).getText();
        findAll(delete_ppi_operation).get(0).waitUntilClickable().click();
        find(close_button).click();
        return findAll(ppi_operation_exist, ppi_operation_delete).size() == 0;
    }



}
