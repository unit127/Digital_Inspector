package pages.Admin;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import pages.Admin.AdminLoginPage;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

@DefaultUrl("https://a2-stage.gpnsmonitor.ru/login")
public class PlanSchedulePage extends PageObject {
    AdminLoginPage page;

    private final By menu_plan_schedule_sample = xpath("//span[contains(text(),'План-график')]");
    private final By provider_field = xpath("//div[contains(text(),'Поставщик')]/..//div[@class='kit-select__value']");
    private final By provider_input = xpath("//div[contains(text(),'Поставщик')]/..//input[@placeholder='Поиск']");
    private final By contract_field = xpath("//div[contains(text(),'Договор')]/..//div[@class='kit-select__value']");
    private final By contract_input = xpath("//div[contains(text(),'Договор')]/..//input[@placeholder='Поиск']");
    private final By annex_field = xpath("//div[contains(text(),'Приложение')]/..//div[@class='kit-select__value']");
    private final By annex_input = xpath("//div[contains(text(),'Приложение')]/..//input[@placeholder='Поиск']");
    private final By good_field = xpath("//div[contains(text(),'Товар')]/..//div[@class='kit-select__value']");
    private final By good_input = xpath("//div[contains(text(),'Товар')]/..//input[@placeholder='Поиск']");
    private final By product_field = xpath("//div[contains(text(),'Изделие')]/..//div[@class='kit-select__value']");
    private final By product_input = xpath("//div[contains(text(),'Изделие')]/..//input[@placeholder='Поиск']");
    private final By plan_date_input = xpath("//label[contains(text(),'По плану')]/..//input");
    private final By ppi_sample_input = xpath("//input[@label='Шаблон ППИ']");
    private final By add_stage_button = xpath("//button//div[contains(text(),'Добавить этап')]");
    private final By copy_from_sample_button = xpath("//button//div[contains(text(),'Копировать из шаблона')]");
    private final By clean_plan_schedule_button = xpath("//button//div[contains(text(),'Очистить план-график')]");
    private final By plan_schedule_sample_field = xpath("//div[contains(text(),'Имя')]/..//div[@class='kit-select__value']");
    private final By plan_schedule_sample_input = xpath("//div[contains(text(),'Имя')]/..//input[@placeholder='Поиск']");
    private final By copy_button = xpath("//div[contains(text(),'Копировать из шаблона')]/..//button//div[contains(text(),'Копировать')]");
    private final By delete_stage_button = xpath("//button//span[contains(text(),'Удалить')]");
    private final By delete_ppi_operation_button = xpath("//div[@class='flex border-bottom border--base-light']//button");
    private final By cancel_button = xpath("//button//div[contains(text(),'Отмена')]");



    private final String choose_date = "//button//div[contains(text(),'%s')]";
    private final String span_contains = "//span[contains(text(),'%s')]";
    private final String div_contains = "//div[contains(text(),'%s')]";
    private final String stage_exist = "//div[@class='gantt-chart__task-list']//div[contains(text(),'%s')]";
    private final String search_list = "//div[@class='v-list-item__content']//span[contains(text(),'%s')]";

    public void login(String email, String pass){page.authorization(email, pass);}

    public void chooseMenuPlanSchedule(){
        find(menu_plan_schedule_sample).waitUntilClickable().click();
    }

    public void chooseProvider(String provider_name){
        waitABit(3000);
        find(provider_field).waitUntilClickable().click();
        waitABit(500);
        find(provider_input).sendKeys(provider_name);
        waitABit(1000);
        element(xpath(format(div_contains,provider_name))).waitUntilClickable().click();
        waitABit(1000);
        System.out.println("choose provider");
    }

    public void chooseContract(String contract_number){
        waitABit(3000);
        find(contract_field).waitUntilClickable().click();
        waitABit(500);
        find(contract_input).sendKeys(contract_number);
        waitABit(1000);
        element(xpath(format(div_contains,contract_number))).waitUntilClickable().click();
    }

    public void chooseAnnex(String annex_number){
        waitABit(1000);
        find(annex_field).waitUntilClickable().click();
        find(annex_input).waitUntilVisible().sendKeys(annex_number);
        element(xpath(format(div_contains,annex_number))).waitUntilClickable().click();
    }

    public void chooseGood(String good_name){
        waitABit(1000);
        find(good_field).waitUntilClickable().click();
        find(good_input).waitUntilVisible().sendKeys(good_name);
        waitABit(1000);
        element(xpath(format(div_contains,good_name))).waitUntilClickable().click();
    }

    public void chooseProduct(String product_number){
        waitABit(1000);
        find(product_field).waitUntilClickable().click();
       // find(product_input).waitUntilVisible().click();
        waitABit(1000);
        element(xpath(format(div_contains,product_number))).waitUntilClickable().click();
    }

    public void choosePlanDate(String plan_date){
        find(plan_date_input).click();
        waitABit(1000);
        element(xpath(format(choose_date,plan_date))).waitUntilClickable().click();
        waitABit(3000);
    }

    public void copyFromSampleButtonClick(){
        find(copy_from_sample_button).waitUntilClickable().click();
        find(copy_button).waitUntilVisible();
    }

    public void cleanPlanScheduleButtonClick(){
        find(clean_plan_schedule_button).waitUntilClickable().click();
        waitABit(1000);
    }

    public void choosePlanScheduleSample(String sample_name){
        waitABit(500);
        find(plan_schedule_sample_input).sendKeys(sample_name);
        waitABit(500);
        element(xpath(format(span_contains,sample_name))).waitUntilClickable().click();
    }

    public void copyButtonClick(){
        find(copy_button).waitUntilClickable().click();
        find(copy_button).waitUntilNotVisible();
    }

    public void addStageButtonClick(){
        find(add_stage_button).waitUntilClickable().click();
    }

    public void cancelButtonClick(){
        find(cancel_button).waitUntilClickable().click();
    }

    public boolean correctStagesAdded(String stage_name){
        return findAll(xpath(format(stage_exist,stage_name))).size() == 1;
    }

    public boolean correctPpiSampleSelectedVisible(String sample_name){
        System.out.println("test ppi sample name - " + find(ppi_sample_input).getValue());
        return find(ppi_sample_input).getValue().equals(sample_name);
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
        findAll(By.xpath("//div[@class='flex spaced-x']//span[contains(text(),'ППИ')]")).get(0).click();
        String ppi_operation_delete = findAll("//div[@class='flex border-bottom border--base-light']//div[1]").get(0).getText();
        findAll(delete_ppi_operation_button).get(0).waitUntilClickable().click();
        return findAll(div_contains, ppi_operation_delete).size() == 0;
    }


}
