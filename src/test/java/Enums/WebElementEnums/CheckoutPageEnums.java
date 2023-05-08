package Enums.WebElementEnums;

public enum CheckoutPageEnums {
    NewAddressContinueBtnClass("new-address-next-step-button"),
    ShippingMethodContinueBtnClass("shipping-method-next-step-button"),
    PaymentMethodContinueBtnClass("payment-method-next-step-button"),
    PaymentInfoContinueBtnClass("payment-info-next-step-button"),
    ConfirmOrderContinueBtnClass("confirm-order-next-step-button"),
    OrderCompleteContinueBtnClass("order-completed-continue-button"),
    CityInputBoxName("BillingNewAddress.City"),
    Address1InputBoxName("BillingNewAddress.Address1"),
    Address2InputBoxName("BillingNewAddress.Address2"),
    ZipCodeInputBoxName("BillingNewAddress.ZipPostalCode"),
    PhoneNumberInputBoxName("BillingNewAddress.PhoneNumber"),
    NextDayAirShippingMethodRadioBtnText("Next Day Air ($0.00)"),
    CreditCartPaymentRadioBtnText("Credit Card"),
    CreditCardTypeDropdownName("CreditCardType"),
    CardExpireMonthDropdownName("ExpireMonth"),
    CardExpireYearDropdownName("ExpireYear"),
    CardHolderNameInputBoxName("CardholderName"),
    CardNumberInputBoxName("CardNumber"),
    CardCodeInputBoxName("CardCode");

    public final String value;

    CheckoutPageEnums(String name) {
        this.value = name;
    }
}