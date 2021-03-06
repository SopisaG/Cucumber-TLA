package steps;

import impl.UserMgtImpl;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pojos.User;;

import java.util.List;
import java.util.Map;

public class UserMgtSteps {
    UserMgtImpl impl = new UserMgtImpl();

    @DataTableType
    public User registerUser(Map<String, String> entry) {
        return new User(
                entry.get("firstname"),
                entry.get("lastname"),
                entry.get("phonenumber"),
                entry.get("email"),
                entry.get("role")
        );
    }

    @When("I open User-Mgt page")
    public void iOpenUserMgtPage() {
        impl.getPage().userMgtLink.click();
    }

    @Then("I should see Login button")
    public void i_should_see_login_button() {
        Assert.assertTrue(impl.getPage().loginBtn.isEnabled());
    }

    @Then("I should see Access DB button")
    public void i_should_see_access_db_button() {
        Assert.assertTrue(impl.getPage().accessDbBtn.isEnabled());
    }

    @When("I input {string} as {string}")
    public void iInputAs(String inputFieldName, String value) {
        impl.fillInputField(inputFieldName, value);
    }

    @When("I input following user details:")
    public void iInputFollowingUserDetails(Map<String, String> map) {
        for(String key: map.keySet()){
            impl.fillInputField(key, map.get(key));
        }
    }

    @When("I create following users")
    public void iCreateFollowingUsers(List<User> users) {
        for(User each: users){
            impl.addNewUser(each);
        }
    }

    @When("I create users from {string} sheet in {string} file")
    public void iCreateUsersFromSheetInFile(String sheetName, String fileName) {
        impl.addNewUserFromExcelFile(sheetName, fileName);
    }


    @Then("I should see all fields displayed on user table")
    public void iShouldSeeAllFieldsDisplayedOnUserTable() {
        Assert.assertEquals("success", impl.verifyEachUserFields());
    }


}
