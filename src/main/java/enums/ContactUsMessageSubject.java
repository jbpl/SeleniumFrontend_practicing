package enums;

public enum ContactUsMessageSubject {
    CUSTOMER_SERVICE("Customer service"), WEBMASTER("Webmaster");

    private String value;

    ContactUsMessageSubject(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
