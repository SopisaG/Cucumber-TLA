package impl;

import pages.UserMgtPage;

public class UserMgtImpl {
    UserMgtPage page;

    public UserMgtPage getPage() {
        if(page == null) {
            page = new UserMgtPage();
        }
        return page;
    }
    public void sleep(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
