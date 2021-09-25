package steps;

import impl.DatabaseImpl;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.SeleniumUtils;
import utils.WebDriverUtils;

public class DatabaseSteps {
    DatabaseImpl impl = new DatabaseImpl();

    @And("I click on {string} button")
    public void iClickOnButton(String buttonName) {
        switch (buttonName.toLowerCase()){
            case "access db": impl.getUserMgtPage().accessDbBtn.click();
                break;
            case "login": impl.getUserMgtPage().loginBtn.click();
                break;
            case "submit" : impl.getUserMgtPage().submitBtn.click();
                break;
            default:
                System.out.println("button was not found");
        }
        SeleniumUtils.switchToNextWindow();
    }
}
