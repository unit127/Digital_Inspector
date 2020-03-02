package pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl("https://i-stage.gpnsmonitor.ru/")
public class InspectorPlanSchedulePage extends PageObject {
    AdminLoginPage page;

    private By search_input = By.xpath("//input[@placeholder='Поиск']");

    public void login(String email, String pass){page.authorization(email, pass);}

    public void searchPlanSchedule(String search_request){
        find(search_input).sendKeys(search_request);
        waitABit(500);
    }

    public void chooses

}
