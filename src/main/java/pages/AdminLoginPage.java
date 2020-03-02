package pages;


import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

@DefaultUrl("https://a2-stage.gpnsmonitor.ru/login")
public class AdminLoginPage extends PageObject {
    private By emailInput = xpath("//input[@type='email']");
    private By passwordInput = xpath("//input[@type='password']");
    private By enterButton = xpath("//button");
    private By errorMessage = xpath("//div[@class='color--warning gpns-caption']");

    public void typeEmail(String email){
        find(emailInput).sendKeys(email);
    }

    public void typePassword(String password){
        find(passwordInput).sendKeys(password);
    }

    public void clickEnterButton(){
        find(enterButton).waitUntilClickable().click();
    }

    public void authorization(String email, String password){
        typeEmail(email);
        typePassword(password);
        clickEnterButton();
    }

    public boolean wrongDataErrorVisiable(){
        return findAll(errorMessage).size()>0 && findAll(errorMessage).get(0).isDisplayed();
    }
}
