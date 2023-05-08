package Enums.WebElementEnums;

public enum ProductDescriptionPageEnums {
    ProcessorDropdownLabelText(" Processor "),
    RamDropdownLabelText(" RAM "),
    Hdd400Text("400 GB [+$100.00]"),
    VistaHomeText("Vista Premium [+$60.00]"),
    TotalCommanderText("Total Commander [+$5.00]");

    public final String value;

    ProductDescriptionPageEnums(String name) {
        this.value = name;
    }
}