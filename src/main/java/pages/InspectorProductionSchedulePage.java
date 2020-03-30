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

@DefaultUrl("https://i-test.gpnsmonitor.ru/")
public class InspectorProductionSchedulePage extends PageObject {
    private By menu_button = xpath("//i[contains(text(),'menu')]");
    private By operations = xpath("//div[@class='gpns-card rounded with-shadow background--white gpns-card--in-card clickable']");
    private By create_new_package = xpath("//a[@class='typo-link clickable']");
    private By search_input = xpath("//input[@placeholder='Укажите номер пакета']");
    private By save_button = xpath("//button[contains(text(),'Сохранить')]");

    String div_contains = "//div[contains(text(),'%s')]";
    String span_contains = "//span[contains(text(),'%s')]";
    String button_contains = "//button[contains(text(),'%s')]";
    String admin_menu = "//div//a['%s']";

    String sertificate_path = "C:\\Users\\bests\\Desktop\\testphoto\\Working.xlsx";
    XSSFWorkbook sertificate = new XSSFWorkbook(new FileInputStream(sertificate_path));

    private List<WebElementFacade> listOperations = new ArrayList<WebElementFacade>();

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

    public void chooseOperation(int oper_id){
        findAll(operations).get(oper_id-1).click();
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
        find(xpath(format(span_contains,action_name))).click();
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

    public void chooseAdminMenu(String menu_number){
        waitABit(500);
        //find(xpath(format(admin_menu,menu_number))).click();
        find(xpath("//i[contains(text(),'class')]")).click();
        //System.out.println("test - " + find(xpath(format(admin_menu,menu_number))).getText());
        //find(xpath("//a[@class='gpns-drawer__nav-link typo-subtitle1 align-center pt2 pr1 pb2 pl5 router-link-exact-active gpns-drawer__nav-link--active']"));
        waitABit(500);
    }

    public void inputCertificate (){
        String excelPath = "C:\\Users\\bests\\Desktop\\testphoto\\Working2.xlsx";
        find(xpath("//input[@type='file']")).sendKeys(excelPath);
        waitABit(5000);
    }


}