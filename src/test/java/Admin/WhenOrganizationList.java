package Admin;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Pending;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.Admin.OrganizationListSteps;

@RunWith(SerenityRunner.class)
public class WhenOrganizationList {
    @Steps
    OrganizationListSteps steps;
    @Managed(driver = "chrome")
    WebDriver driver;

    @Test
    @Pending
    public void editOrganization(){
        steps.open_page();
        steps.login("testUserAdmin", "testUserAdmin1");
        steps.choose_menu_organization_list();
        steps.choose_organization_type("Инспекционная компания");
        steps.edit_organization_button_click("Инспекционная компания (тест)");
        steps.type_organization_data("456","789", "123","testorg@mail.ru","89383215453","14228");
        steps.save_button_click();
        steps.choose_organization_type("Инспекционная компания");
        steps.should_see_correct_text_in_organization_record("SAP 14228");
        steps.should_see_correct_text_in_organization_record("КПП 123");
        steps.should_see_correct_text_in_organization_record("ИНН 789");
        steps.should_see_correct_text_in_organization_record("ОГРН 456");
    }

    @Test
    @Pending
    public void editUser(){
        String surname = "Семенов";
        String name = "Андрей";
        String patronymic = "Викторович";
        steps.open_page();
        steps.login("testUserAdmin", "testUserAdmin1");
        steps.choose_menu_organization_list();
        steps.choose_organization_type("Инспекционная компания");
        steps.choose_organization("Инспекционная компания (тест)");
        steps.edit_user_button_click(patronymic);
        steps.type_user_data(surname,name,patronymic, "testuser@test.ru", "123456", "102030");
        steps.save_button_click();
        steps.should_see_correct_text_in_user_record(surname+" "+name);

    }
}
