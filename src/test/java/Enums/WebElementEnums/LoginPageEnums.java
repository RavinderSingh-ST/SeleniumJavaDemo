package Enums.WebElementEnums;

public enum LoginPageEnums {
    EmailInputBoxClass("email"),
    PasswordInputBoxClass("password");

    public final String value;

    LoginPageEnums(String name) {
        this.value = name;
    }
}