package guru.qa.pages.MCHD;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AuthPage {

    SelenideElement
            loginInput =   $("#IDToken1"),
            passInput =    $("#IDToken2"),
            loginButton =  $("[name='Login.Submit']");


    public AuthPage openPage (){
    open("https://mchd-test.esphere.ru");
    return this;

    }

    public AuthPage inputLogin(String login){
        loginInput.setValue(login);
        return this;

    }

    public AuthPage inputPass (String pass){
        passInput.setValue(pass);
        return this;

    }

    public AuthPage login(){
        loginButton.click();
        return this;

    }



}






