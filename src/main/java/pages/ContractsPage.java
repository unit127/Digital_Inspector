package pages;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;
import static java.lang.String.format;

@DefaultUrl("https://a2-stage.gpnsmonitor.ru/login")
public class ContractsPage extends PageObject {
    AdminLoginPage page;

    private By menu_directories = xpath("//span[contains(text(),'Контракты')]");

    public void login(String email, String pass){page.authorization(email, pass);}

    public void chooseMenuContracts(){
        find(menu_directories).waitUntilClickable().click();
    }

    public void
}
