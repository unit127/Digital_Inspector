package steps.Admin;

import net.thucydides.core.annotations.Step;
import org.assertj.core.api.Assertions;
import pages.Admin.DirectoryPage;

public class DirectorySteps {
    DirectoryPage page;

    @Step
    public void open_page(){page.open();}
    @Step
    public void login(String login, String password){
        page.login(login, password);
    }
    @Step
    public void choose_menu_directories(){page.chooseMenuDirectories();}
    @Step
    public void choose_type_directories(){page.chooseTypeDirectories();}
    @Step
    public void type_code(String code){page.typeCode(code);}
    @Step
    public void type_name(String name){page.typeName(name);}
    @Step
    public void add_button_click(){page.addButtonClick();}
    @Step
    public void delete_directory(String directory_name){page.deleteDirectory(directory_name);}
    @Step
    public void should_see_correct_record(String text){
        Assertions.assertThat(page.correctRecordCreated(text)).isTrue();}
    @Step
    public void should_not_see_record(String text){
        Assertions.assertThat(page.correctRecordCreated(text)).isFalse();}
}
