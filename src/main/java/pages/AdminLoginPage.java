package pages;


import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import static java.lang.String.format;

@DefaultUrl("https://a2-test.gpnsmonitor.ru/")
public class AdminLoginPage extends PageObject {
    private By emailInput = By.xpath("//input[@type='email']");
    private By passwordInput = By.xpath("//input[@type='password']");
    private By enterButton = By.xpath("//div[@class='gpns-button__content flex center align-center justify-center typo-body2 truncate']");
    private By errorMessage = By.xpath("//div[@class='color--warning gpns-caption']");

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
