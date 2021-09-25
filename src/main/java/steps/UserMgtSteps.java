package steps;

import impl.UserMgtImpl;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverUtils;

public class UserMgtSteps {
    UserMgtImpl impl = new UserMgtImpl();

    @When("I open User-Mgt page")
    public void i_open_user_mgt_page() {
        impl.getPage().userMgtLink.click();
    }
    @Then("Title of the page should be Register New User")
    public void title_of_the_page_should_be_register_new_user() {
        Assert.assertEquals("Register New User", WebDriverUtils.getDriver().getTitle());
    }
    @Then("I should see Login button")
    public void i_should_see_login_button() {
        Assert.assertTrue(impl.getPage().loginBtn.isEnabled());
    }
    @Then("I should see Access DB button")
    public void i_should_see_access_db_button() {
        Assert.assertTrue(impl.getPage().accessDbBtn.isEnabled());
    }

    @When("I open Access DB page")
    public void iOpenAccessDBPage() {
        impl.getPage().accessDbBtn.click();

    }

    @Then("Title of the page should be User DB")
    public void titleOfThePageShouldBeUserDB() {
//        WebDriverWait wait = new WebDriverWait(WebDriverUtils.getDriver(), 20);
//        wait.until(ExpectedConditions.titleContains("User DB"));
        impl.sleep(2000);
        Assert.assertEquals("User DB", WebDriverUtils.getDriver().getTitle());
    }

    @When("I open Login page")
    public void iOpenLoginPage() {
        impl.getPage().loginBtn.click();
    }

    @Then("Title of the page should be Login Page")
    public void titleOfThePageShouldBeLoginPage() {
        //Assert.assertEquals("Login Page", WebDriverUtils.getDriver().getTitle());
        Assert.assertTrue(WebDriverUtils.getDriver().getTitle().toLowerCase().contains("login page"));
    }

    @Then("I should see TLA image")
    public void iShouldSeeTLAImage() {
    }
}
