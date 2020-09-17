package pages.Admin;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import pages.Admin.AdminLoginPage;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

@DefaultUrl("https://a2-stage.gpnsmonitor.ru/login")
public class PlanScheduleSamplePage extends PageObject {
    AdminLoginPage page;

    private By menu_plan_schedule_sample = xpath("//span[contains(text(),'Шаблоны план-графика')]");
    private By create_button = xpath("//div[contains(text(),'Создать')]");
    private By plan_schedule_name_input = xpath("//input[@type='text']");

    private final By provider_field = xpath("//div[contains(text(),'Поставщик')]/..//div[@class='kit-select__value']");
    private final By provider_input = xpath("//div[contains(text(),'Поставщик')]/..//input[@placeholder='Поиск']");
    private final By product_field = xpath("//div[contains(text(),'Выберите материал')]/..//div[@class='kit-select__value']");
    private final By product_input = xpath("//div[contains(text(),'Выберите материал')]/..//input[@placeholder='Поиск']");
    private final By ppi_sample_name_field = xpath("//div[contains(text(),'Выберите шаблон ППИ')]/..//div[@class='kit-select__value']");
    private final By ppi_sample_name_input = xpath("//div[contains(text(),'Выберите шаблон ППИ')]/..//input[@placeholder='Поиск']");

    private By add_stage_button = xpath("//div[contains(text(),'Добавить этап')]");
    private By new_stage_name_input = xpath("//input[@label='Поиск']");
    private By save_button = xpath("//div[@class='modal']//button[2]//div[1]");
    private By save_close_button = xpath("//button[3]//div[1]");
    private By previous_stage_list = xpath("//div[@class='add-step__list-item flex hoverable clickable p2 mb1']");
    private By group_operation_input = xpath("//input[@label='Поиск']");
    private By add_ppi_operations_button = xpath("//div[contains(text(),'Добавить операцию')]");
    private By choose_all_operations = xpath("//a[contains(text(),'Выбрать все')]");
    private By close_button = xpath("//div[contains(text(),'Закрыть')]");
    private By delete_stage_button = xpath("//span[contains(text(),'Удалить этап')]");
    private By clean_plan_schedule_button = xpath("//div[contains(text(),'Очистить план-график')]");
    private By delete_ppi_operation = xpath("//div[@class='add-operation__summary-remove']");
    private By search_input = xpath("//input[@placeholder='Поиск шаблона или поставщика']");

    private String provider_name = "//span[contains(text(),'%s')]";
    private String choose_material_name = "//span[contains(text(),'%s')]";
    private String ppi_sample_name = "//span[contains(text(),'%s')]";
    private String new_stage_name = "//span[contains(text(),'%s')]";
    private String group_operation = "//span[contains(text(),'%s')]";
    private String choose_plan_schedule_sample = "//span[contains(text(),'%s')]";
    private String stage_exist = "//div[@class='gantt-chart__task-list']//div[contains(text(),'%s')]";
    private String ppi_operation_exist = "//div[contains(text(),'%s')]";
    private String delete_plan_schedule = ".//div[contains(text(),'%s')]/..//button[2]";
    private final String div_contains = "//div[contains(text(),'%s')]";
    private final String mark_contains = "//mark[contains(text(),'%s')]";

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

    public void choosePpiSample(String sample_name){
        waitABit(1000);
        find(ppi_sample_name_field).waitUntilClickable().click();
        find(ppi_sample_name_input).waitUntilVisible().sendKeys(sample_name);
        waitABit(3000);
        element(xpath(format(mark_contains,sample_name))).waitUntilVisible().click();
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
        find(By.xpath("//label[contains(text(),'Дней')]/..//input")).sendKeys(days);
    }

    public void choosePreviousStage(int prev_stage_position){
        findAll(previous_stage_list).get(prev_stage_position).waitUntilClickable().click();
    }

    public void saveButtonClick(){
        find(save_button).waitUntilClickable().click();
    }

    public void saveAndCloseButtonClick(){
        find(save_close_button).waitUntilClickable().click();
    }

    public void addPpiToStage(String group_operation_name, int stage_position){
        findAll(By.xpath("//div[@class='gantt-chart__task-list']//div[contains(text(),'ППИ')]")).get(stage_position-1).waitUntilClickable().click();
        find(group_operation_input).sendKeys(group_operation_name);
        element(xpath(format(group_operation,group_operation_name))).waitUntilClickable().click();
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
        find(search_input).sendKeys(plan_sample_name);
        waitABit(500);
        element(xpath(format(choose_plan_schedule_sample,plan_sample_name))).waitUntilClickable().click();
        waitABit(5000);
        element(xpath(format("//h4[contains(text(),'%s')]",plan_sample_name))).waitUntilVisible();
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
        //System.out.println("test ppi sample name - " + find(xpath("//div[contains(text(),'Выберите шаблон ППИ')]/..//div[@class='kit-select__value']//span")).getText());
        /*int k = 0;
        while(find(ppi_sample_name_input).getValue().equals("") || k <3){
            chooseMenuPlanScheduleSample();
            choosePlanScheduleSample("Autotest PG sample");
            k++;
        }*/

        return findAll(xpath(format(ppi_sample_name,sample_name))).size()==1;
    }

    public boolean correctStageExist(String stage_name){
        return findAll(xpath(format(stage_exist, stage_name))).size() == 1;
    }

    public boolean checkDiagramEmpty(){
        return findAll(By.xpath("//div[@class='gantt-chart__task-list']//div[@class='flex flex-column']")).size() == 0;
    }

    public boolean checkStageDeleted(){
        String stage_delete = findAll("//div[@class='gantt-chart__task-list']/div[2]/div[1]/div[2]/div[1]").get(0).getText();
        System.out.println("test - " + stage_delete);
        findAll(By.xpath("//div[contains(text(),'Редактировать')]")).get(0).click();
        System.out.println("1");
        waitABit(1000);
        find(delete_stage_button).waitUntilVisible().click();
        System.out.println("Stage size - " + findAll(stage_exist,stage_delete).size());
        System.out.println("2");
        return findAll(stage_exist,stage_delete).size()==0;
    }

    public boolean checkPpiOperationDeleted(){
        findAll(By.xpath("//div[@class='flex flex-column']//div[contains(text(),'ППИ')]")).get(0).click();
        String ppi_operation_delete = findAll("//div[@class='add-operation__summary-item']//div[1]").get(0).getText();
        findAll(delete_ppi_operation).get(0).waitUntilClickable().click();
        System.out.println("Operation size - " + findAll(ppi_operation_exist, ppi_operation_delete).size());
        return findAll(ppi_operation_exist, ppi_operation_delete).size() == 0;
    }

    public void closeButtonClick(){
        find(close_button).waitUntilClickable().click();
    }

}
