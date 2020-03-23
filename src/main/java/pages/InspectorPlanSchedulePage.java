package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;

@DefaultUrl("https://i-stage.gpnsmonitor.ru/")
public class InspectorPlanSchedulePage extends PageObject {
    AdminLoginPage page;
    WebDriver driver;

    private By search_input = xpath("//input[@placeholder='Поиск']");
    private By founded_plan_schedule = xpath("//div[@class='gpns-card__content flex flex-column flex-auto']");
    private By stages = xpath("//div[@class='gpns-card clickable']");
    private By operations = xpath("//div[@class='gpns-card rounded with-shadow background--white gpns-card--in-card clickable']");
    private By characteristics = xpath("//div[@class='flex flex-auto']");
    private By comment_textarea = xpath("//textarea[@placeholder='Написать комментарий']");
    private By documents_criteria_button = xpath("//a[contains(text(),'Документы и критерии приемки')]");
    private By understand_button = xpath("//button[contains(text(),'Понятно')]");
    private By use_this_photo_button = xpath("//button[contains(text(),'Использовать это фото')]");
    private By photo_input = xpath("//input[@type='file']");
    private By edit_photo_button = xpath("//i[contains(text(),'edit')]");
    private By rotate_right_button = xpath("//i[contains(text(),'rotate_right')]");
    private By ready_link = xpath("//div[contains(text(),'Готово')]");
    private By delete_photo_link = xpath("//div[contains(text(),'Удалить')]");
    private By passed_button = xpath("//button[@id='set-validation-check-status-passed']");
    private By passed_button2 = cssSelector("#set-validation-check-status-passed");
    private By has_defect_button = xpath("//button[@id='set-validation-check-status-has-defects']");
    private By take_decision_later_button = xpath("//button[contains(text(),'Принять решение позже')]");
    private By complete_control = xpath("//button[contains(text(),'Завершить контроль')]");
    private By general_comment = xpath("//button[contains(text(),'Добавить общий комментарий')]");
    private By save_button = xpath("//button[contains(text(),'Сохранить')]");
    private By factory_number_link = xpath("//div[contains(text(),'№')]");
    private By factory_number_input = xpath("//div[@class='md-field md-theme-default md-has-value']//input");
    private By progress_slider = xpath("//div[@class='vue-slider-dot']"); //("//div[@class='vue-slider-rail']");
    private By back_button = xpath("//i[contains(text(),'arrow_back')]");


    private List<WebElementFacade> listStages = new ArrayList<WebElementFacade>();
    private List<WebElementFacade> listOperations = new ArrayList<WebElementFacade>();
    private List<WebElementFacade> listCharacteristics = new ArrayList<WebElementFacade>();

    public void login(String email, String pass){page.authorization(email, pass);}

    public void fillSearchPlanSchedule(String search_request){
        waitABit(1500);
        find(search_input).sendKeys(search_request);
        waitABit(1500);
    }

    public void openFoundedPlanSchedule(){
        find(founded_plan_schedule).waitUntilClickable().click();
    }

    public int getStagesSize() {
        listStages = findAll(stages);
        return listStages.size();
    }

    public void chooseStage(int stage_id){
        findAll(stages).get(stage_id).click();
        //waitABit(500);
    }

    public int getOperationsSize() {
        listOperations = findAll(operations);
        return listOperations.size();
    }

    public void chooseOperation(int operation_id){
        findAll(operations).get(operation_id).click();
       // waitABit(500);
    }

    public int getCharacteristicsSize(){
        listCharacteristics=findAll(characteristics);
        return listCharacteristics.size();
    }

    public void chooseCharacteristic(int characteristic_id){
        findAll(characteristics).get(characteristic_id).click();
        //waitABit(500);
    }

    public void typeComment(String comment){
        find(comment_textarea).sendKeys(Keys.chord(Keys.CONTROL,"a"));
        find(comment_textarea).sendKeys(comment);
    }

    public void documentsCriteriaButtonClick(){
        find(documents_criteria_button).waitUntilClickable().click();
    }

    public void understandButtonClick(){
        find(understand_button).waitUntilClickable().click();
    }

    public void addPhoto(int id){
        String photoPath = "C:\\Users\\bests\\Desktop\\testphoto\\photo"+id+".jpg";
        System.out.println(photoPath);
        find(photo_input).waitUntilEnabled();
        find(photo_input).sendKeys(photoPath);
        //waitABit(3000);
        //find(By.xpath("//span[contains(text(),'Ok')]")).click();
        find(use_this_photo_button).click();
        waitABit(500);
    }

    public void rotatePhoto(int turn_count){
        waitABit(500);
        find(edit_photo_button).click();
        waitABit(300);
        int i = 0;
        while ( i != turn_count){
            find(rotate_right_button).click();
            i++;
        }
        find(ready_link).click();
        waitABit(5000);
    }

    public void passedButtonClick(){
       // System.out.println("Button name - " + find(passed_button).getTextContent());
      /*  WebElement slider = find(passed_button);
        Actions moveSlider = new Actions(getDriver());
        Action action = moveSlider.moveToElement(slider).moveToElement(find(By.xpath("//button[@id='set-validation-check-status-passed']"))).click().build();
        action.perform();*/
       // waitABit(5000);
      /*  JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.getElementById('set-validation-check-status-passed').style.display='block';");*/
    /*    JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement element = find(passed_button);
        js.executeScript("arguments[0].click();", element);*/
        waitABit(500);
        find(passed_button).click();
        waitABit(3000);

    }

    public void hasDefectButtonClick(){
        find(has_defect_button).waitUntilClickable().click();
    }

    public void takeDecisionLaterButton(){
        find(take_decision_later_button).waitUntilClickable().click();
    }

    public void completeControlButtonClick(){
        find(complete_control).waitUntilClickable().click();
    }

    public void typeGeneralComment(String text){
        find(general_comment).click();
        find(comment_textarea).sendKeys(Keys.chord(Keys.CONTROL,"a"));
        find(comment_textarea).sendKeys(text);
        waitABit(500);
        find(save_button).click();
        waitABit(500);
    }

    public void addFactoryNumber(String fact_numb){
        findAll(factory_number_link).get(0).click();
        waitABit(300);
        find(factory_number_input).sendKeys(Keys.chord(Keys.CONTROL, "a"));
        waitABit(300);
        find(factory_number_input).sendKeys(fact_numb);
        find(save_button).click();
        waitABit(500);
    }

    public void sliderMove(int move){
        find(progress_slider).waitUntilClickable();
        WebElement slider = find(progress_slider);
        Actions moveSlider = new Actions(getDriver());
        Action action = moveSlider.dragAndDropBy(slider, move, 0).build();
        action.perform();
        find(xpath("//button[contains(text(),'Да')]")).click();
    }

    public void backButtonClick(){
        find(back_button).waitUntilClickable().click();
    }

}
