package pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.xpath;

@DefaultUrl("https://a2-stage.gpnsmonitor.ru/login")
public class PlanSchedulePage extends PageObject {
    AdminLoginPage page;

    private final By menu_plan_schedule_sample = xpath("//span[contains(text(),'План-график')]");
    private final By provider_input = xpath("//input[@label='Поставщик']");
    private final By contract_input = xpath("//input[@label='Договор']");
    private final By annex_input = xpath("//input[@label='Приложение']");
    private final By good_input = xpath("//input[@label='Товар']");
    private final By product_input = xpath("//input[@label='Изделие']");
    private final By plan_date_input = xpath("//label[contains(text(),'По плану')]/..//input");
    private final By ppi_sample_input = xpath("//input[@label='Шаблон ППИ']");
    private final By add_stage_button = xpath("//button//div[contains(text(),'Добавить этап')]");

    public void login(String email, String pass){page.authorization(email, pass);}

}
