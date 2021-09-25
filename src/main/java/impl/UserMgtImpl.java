package impl;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.UserMgtPage;
import utils.SeleniumUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMgtImpl {
    private UserMgtPage page;

    public UserMgtPage getPage() {
        if(page == null){
            page = new UserMgtPage();
        }
        return page;

    }

    Map<String, String> userFieldInputs = new HashMap<>();

    public void getNewUser(String inputFieldName, String value){

        switch (inputFieldName.toLowerCase()){
            case "firstname": getPage().firstnameKey.sendKeys("Jane");
                break;
            case "lastname": getPage().lastnameKey.sendKeys("Doe");
                break;
            case "phonenumber": getPage().phoneKey.sendKeys("1234567890");
                break;
            case "email": getPage().emailKey.sendKeys("jane.doe@tla.com");
                break;
            case "role":
                SeleniumUtils.selectByVisibleText(getPage().selectRole, value);
                break;

            default:
                System.out.println("field user was not found");
        }

    }

    public String verifyEachUserFields() {
        String result = "success";
        //List<WebElement> allRows = getPage().tableRows;

        List<WebElement> allCells = getPage().tableRows.get(0).findElements(By.xpath(".//td"));

        for(String eachField : userFieldInputs.keySet()) {
            boolean missing = true;

            for(int i = 0; i < allCells.size(); i++) {
                if(allCells.get(i).getText().equals(eachField)) {
                    missing = false;
                }
            }
            if(missing) {
                result = "fail";
            }
        }

        return result;
    }
}
