package Admin;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.Admin.ContractsSteps;

@RunWith(SerenityRunner.class)
public class WhenContracts {
    @Steps
    ContractsSteps steps;
    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    @Pending
    public void checkContracts(){
        steps.open_page();
        steps.login("testUserAdmin", "testUserAdmin1");
        steps.choose_menu_contracts();
        steps.choose_provider("Корвет");
        steps.choose_contract("ДП_57650_23962_29414");
        steps.choose_annex("34");
        steps.open_good("Дроссель");
        steps.should_see_correct_text_in_raw("1244");
        steps.should_see_correct_text_in_raw("06.06");
        steps.should_see_correct_text_in_raw("15.04");
    }
}
