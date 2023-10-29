package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.CommonMethods;

public class logintTest extends CommonMethods {
    /*
    tescase 1:
    login into the applicaiton
    verify the message Welcome Admin
     */
    @Test
    public void loginTest(){
        sendText(login.usernameBox,"Admin");
        sendText(login.passwordBox,"Hum@nhrm123");
        click(login.loginBtn);
//        verify the message
        String actualMessage = dash.welcomeMessage.getText();
//        verification
        Assert.assertEquals(actualMessage,"Welcome Admin");
    }

//    test 4 scenarios with invalid credentials

//    1.declare the data in 2D array
    @DataProvider(name="credentials")
    public Object [][] data(){

        Object[][] loginData={
                {"Admin","abc","Invalid credential"},
                {"Admin","xyz","Invalid credentials"},
                {"Admin","","Password cannot be empty"},
                {"","hum","Username cannot be empty"}
        };
        return  loginData;
    }

    @Test(dataProvider="credentials")
    public void invalidCredentials(String userName , String password , String errorMsg) {
        sendText(login.usernameBox,userName);
        sendText(login.passwordBox,password);
        click(login.loginBtn);
//        verify the error message
        String ActualError = login.errorMessage.getText();

//        assertion
        Assert.assertEquals(ActualError,errorMsg);

    }
    }
