package pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.xpath;
import static java.lang.String.format;

@DefaultUrl("https://i-stage.gpnsmonitor.ru/")
public class InspectorProductionSchedulePage extends PageObject {
    private By menu_button = xpath("//i[contains(text(),'menu')]");
    private By operations = xpath("//div[@class='gpns-card rounded with-shadow background--white gpns-card--in-card clickable']");
    private By create_new_package = xpath("//a[@class='typo-link clickable']");
    private By search_input = xpath("//input[@placeholder='Укажите номер пакета']");
    private By save_button = xpath("//button[contains(text(),'Сохранить')]");
    private By characteristics = xpath("//div[@class='flex flex-auto']");
    private By comment_textarea = xpath("//textarea[@placeholder='Написать комментарий']");
    private By documents_criteria_button = xpath("//a[contains(text(),'Документы и критерии приемки')]");
    private By understand_button = xpath("//button[contains(text(),'Понятно')]");
    private By use_this_photo_button = xpath("//button[contains(text(),'Использовать это фото')]");
    private By photo_input = xpath("//input[@type='file']");
    private By edit_photo_button = xpath("//i[contains(text(),'edit')]");
    private By rotate_right_button = xpath("//i[contains(text(),'rotate_right')]");
    private By ready_link = xpath("//div[contains(text(),'Готово')]");
    private By passed_button = xpath("//button[@id='set-validation-check-status-passed']");
    private By has_defect_button = xpath("//button[@id='set-validation-check-status-has-defects']");
    private By take_decision_later_button = xpath("//button[contains(text(),'Принять решение позже')]");
    private By complete_control = xpath("//button[contains(text(),'Завершить контроль')]");


    String div_contains = "//div[contains(text(),'%s')]";
    String span_contains = "//span[contains(text(),'%s')]";
    String button_contains = "//button[contains(text(),'%s')]";
    String admin_menu = "//div//a['%s']";

    String sertificate_path = "C:\\Users\\bests\\Desktop\\testphoto\\Worknig.xlsx";
    XSSFWorkbook sertificate = new XSSFWorkbook(new FileInputStream(sertificate_path));

    private List<WebElementFacade> listOperations = new ArrayList<WebElementFacade>();
    private List<WebElementFacade> listCharacteristics = new ArrayList<WebElementFacade>();

    public InspectorProductionSchedulePage() throws IOException {
    }

    public void inspectorLogin(String email, String pass){
        findAll(xpath("//input")).get(0).sendKeys(Keys.chord(Keys.CONTROL,"a"));
        findAll(xpath("//input")).get(0).sendKeys(email);
        findAll(xpath("//input")).get(1).sendKeys(Keys.chord(Keys.CONTROL,"a"));
        findAll(xpath("//input")).get(1).sendKeys(pass);
        waitABit(500);
        //find(xpath("//button[contains(text(),'Войти')]")).click();
        find(xpath("//button")).click();
        waitABit(10000);
    }

    public void chooseSection (String section_name){
        find(menu_button).click();
        find(xpath(format(div_contains,section_name))).click();
        waitABit(500);
    }

    public void chooseWorkshop(String workshop_name){
        find(xpath(format(div_contains, workshop_name))).click();
        waitABit(500);
    }

    public int getOperationsSize() {
        listOperations = findAll(operations);
        return listOperations.size();
    }

    public void chooseOperation(String operation_name){
        element(xpath(format(div_contains, operation_name))).click();
        waitABit(500);
    }

    public void chooseOrder(String order_name){
        find(xpath(format(div_contains,order_name))).click();
        waitABit(500);
    }

    public void chooseMaterial(String material_name){
        find(xpath(format(div_contains,material_name))).click();
        waitABit(500);
    }

    public void chooseAction(String action_name){
        find(xpath(format(div_contains,action_name))).click();
        waitABit(3000);
    }

    public void createNewPackageClick(){
        find(create_new_package).click();
        waitABit(500);
    }

    public void fillSearch(String package_number){
        find(search_input).sendKeys(package_number);
        find(search_input).sendKeys(Keys.ENTER);
    }

    public void fillPackageFields (String package_number, String part_number, String melting_number, String total_weight, String quantity, String total_length, int save_id){
        waitABit(500);
        findAll(xpath("//input")).get(1).sendKeys(package_number);
        findAll(xpath("//input")).get(2).sendKeys(part_number);
        findAll(xpath("//input")).get(3).sendKeys(melting_number);
        findAll(xpath("//input")).get(4).sendKeys(total_weight);
        findAll(xpath("//input")).get(5).sendKeys(quantity);
        findAll(xpath("//input")).get(6).sendKeys(total_length);
        findAll(save_button).get(save_id).click();
    }

    public boolean shouldSeeCorrectData (String package_number, String button_number){
        return (findAll(xpath(format(button_contains, button_number))).size()==3 && findAll(xpath(format(span_contains, package_number))).size()==3);
    }

    public void editСertificate (String сert_number, String package_number) throws IOException {
        XSSFSheet sertFirstSheet = sertificate.getSheetAt(0);
        XSSFSheet sertSecondSheet = sertificate.getSheetAt(1);
        sertFirstSheet.getRow(1).getCell(38).setCellValue(сert_number);
        System.out.println("1 stroka - " + sertFirstSheet.getRow(1).getCell(38).toString());


        for(int i = 0; i < 5; i++){
            sertSecondSheet.getRow(22+i).getCell(2).setCellValue(package_number+i);
        }
        FileOutputStream outFile =new FileOutputStream(new File("C:\\Users\\bests\\Desktop\\testphoto\\Working2.xlsx"));
        sertificate.write(outFile);
        outFile.close();

        for(int i = 0; i < 5; i++){
            System.out.println("2 stroka - " + sertSecondSheet.getRow(22+i).getCell(2).toString());
        }

        sertificate.close();
    }

    public boolean shouldSeeCorrectCertificate (String cert_number){
        return (findAll(xpath(format(div_contains, cert_number))).size() == 1);
    }

    public void chooseAdminMenu(String menu_text){
        waitABit(500);
        find(xpath(format(span_contains,menu_text))).click();
        waitABit(500);
    }

    public void inputCertificate (){
        String excelPath = "C:\\Users\\bests\\Desktop\\testphoto\\Working2.xlsx";
        find(xpath("//input[@type='file']")).sendKeys(excelPath);
        waitABit(5000);
    }

    public int getGroupOperationsSize() {
        listOperations = findAll(operations);
        return listOperations.size();
    }

    public void chooseOperationFromGroup(int operation_id){
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
        for(int i =1; i< 4; i++) {
            String photoPath = "C:\\Users\\bests\\Desktop\\testphoto\\bigphoto" + i + ".jpg";
            System.out.println(photoPath);
            find(photo_input).waitUntilEnabled();
            waitABit(500);
            find(photo_input).sendKeys(photoPath);
            waitABit(1000);
            //find(By.xpath("//span[contains(text(),'Ok')]")).click();
            find(use_this_photo_button).click();
            waitABit(2000);
        }
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
        waitABit(500);
        find(passed_button).click();
        waitABit(7000);
        //waitFor(element(complete_control));
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

    public void buttonTextClick(String button_text){element(xpath(format(button_contains,button_text))).waitUntilClickable().click();}

    public int check_tpk_window(){
        return findAll(xpath("//div[contains(text(),'Внимание')]")).size();
    }

}