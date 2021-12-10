package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverUtils;

import java.util.List;

public class UserMgtPage {
    public UserMgtPage() {

    PageFactory.initElements(WebDriverUtils.getDriver(), this);

   }

    @FindBy(linkText = "User-Mgt")
    public WebElement userMgtLink;

    @FindBy(xpath = "//button/a[text()='Access DB']")
    public WebElement accessDbBtn;

    @FindBy(xpath = "//button/a[text()='Login']")
    public WebElement loginBtn;

    @FindBy(id = "Firstname")
    public WebElement firstnameKey;

    @FindBy(id = "Lastname")
    public WebElement lastnameKey;

    @FindBy(id = "Phonenumber")
    public WebElement phoneKey;

    @FindBy(id = "Email")
    public WebElement emailKey;

    @FindBy(id = "Select-role")
    public WebElement selectRole;

    @FindBy(id = "submit-btn")
    public WebElement submitBtn;

    @FindBy(xpath = "//table[@id='list-table']/tbody/tr")
    public WebElement userTableRows;

}
