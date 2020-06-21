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
    private By provider_input = xpath("//input[@label='Поставщик']");
    private By contract_input = xpath("//input[@label='Договор']");
    private By annex_input = xpath("//input[@label='Приложение']");

    private final String span_contains = "//span[contains(text(),'%s')]";
    private final String div_contains = "//div[contains(text(),'%s')]";
    private final String td_contains = "//td[contains(text(),'%s')]";

    public void login(String email, String pass){page.authorization(email, pass);}

    public void chooseMenuContracts(){
        find(menu_directories).waitUntilClickable().click();
    }

    public void chooseProvider(String provider_name){
        find(provider_input).sendKeys(provider_name);
        element(xpath(format(span_contains,provider_name))).waitUntilClickable().click();
    }

    public void chooseContract(String contract_number){
        find(contract_input).sendKeys(contract_number);
        element(xpath(format(span_contains,contract_number))).waitUntilClickable().click();
    }

    public void chooseAnnex(String annex_number){
        find(annex_input).click();
        element(xpath(format(div_contains,annex_number))).waitUntilClickable().click();
    }

    public void openGood(String good_name){
        element(xpath(format(div_contains, good_name))).waitUntilClickable().click();
    }

    public boolean correctTextInRaw(String text){
        return findAll(xpath(format(td_contains,text))).size() == 1;
    }

}
