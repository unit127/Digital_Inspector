package pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;
import static java.lang.String.format;


@DefaultUrl("https://a2-stage.gpnsmonitor.ru/login")
public class DirectoryPage extends PageObject {
    AdminLoginPage page;
    WebDriver driver;

    private By menu_directories = xpath("//span[contains(text(),'Справочники')]");
    private By select_directories_type = xpath("//div[@class='v-select__selections']");
    private By code_input = xpath("//label[contains(text(),'Код')]/..//input");
    private By name_input = xpath("//label[contains(text(),'Название')]/..//input");
    private By add_button = xpath("//button//i[contains(text(),'add')]");

    private String td_contains = "//td[contains(text(),'%s')]";
    private String delete_directory = "//td[contains(text(),'%s')]/..//button[2]";

    public void login(String email, String pass){page.authorization(email, pass);}

    public void chooseMenuDirectories(){
        find(menu_directories).waitUntilClickable().click();
    }

    public void chooseTypeDirectories(){
        find(select_directories_type).waitUntilClickable().click();
        find(xpath("//div[contains(text(),'Методы проверки')]")).waitUntilClickable().click();
    }

    public void typeCode(String code){
        findAll(code_input).get(0).sendKeys(code);
    }

    public void typeName(String name){
        findAll(name_input).get(0).sendKeys(name);
    }

    public void addButtonClick(){
        find(add_button).click();
    }

    public boolean correctRecordCreated(String text){
        return findAll(xpath(format(td_contains,text))).size() == 1;
    }

    public void deleteDirectory(String directory_name){
        find(xpath(format(delete_directory,directory_name))).waitUntilClickable().click();
        find(xpath("//div[contains(text(),'Да')]")).waitUntilClickable().click();
    }
}
