package Enums.WebElementEnums;

public enum NavbarHeaderLinkEnums {
    RegisterHeaderLinkClass("ico-register"),
    LoginHeaderLinkClass("ico-login"),
    LogoutHeaderLinkClass("ico-logout"),
    CartLinkClass("ico-cart");

    public final String value;

    NavbarHeaderLinkEnums(String name) {
        this.value = name;
    }
}