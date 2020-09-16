package steps.Admin;

import net.thucydides.core.annotations.Step;
import pages.Admin.ContractsPage;

public class ContractsSteps {
    ContractsPage page;

    @Step
    public void open_page(){page.open();}
    @Step
    public void login(String login, String password){
        page.login(login, password);
    }
    @Step
    public void choose_menu_contracts(){page.chooseMenuContracts();}
    @Step
    public void choose_provider(String provider_name){page.chooseProvider(provider_name);}
    @Step
    public void choose_contract(String contract_name){page.chooseContract(contract_name);}
    @Step
    public void choose_annex(String annex_number){page.chooseAnnex(annex_number);}
    @Step
    public void open_good(String good_name){page.openGood(good_name);}
    @Step
    public void should_see_correct_text_in_raw(String text){page.correctTextInRaw(text);}
}
