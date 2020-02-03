package steps;

import net.thucydides.core.annotations.Step;

import org.assertj.core.api.Assertions;
import pages.AdminLoginPage;

public class AdminLoginSteps {
    AdminLoginPage page;

    @Step
    public void open_login_page(){page.open();}
    @Step
    public void type_email(String email){page.typeEmail(email);}
    @Step
    public void type_password(String password){page.typePassword(password);}
    @Step
    public void click_enter_button(){ page.clickEnterButton(); }
    @Step
    public void authorization(String email, String password){ page.authorization(email, password); }
    @Step
    public void should_see_error_message(){ Assertions.assertThat(page.wrongDataErrorVisiable()).isTrue();}
}
