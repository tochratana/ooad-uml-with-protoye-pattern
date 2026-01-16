public class VipCustomer extends Customer{
    private String vipLevel;
    private double discountRate;

    public VipCustomer(
            String customerId, String firstName, String lastName,
            String email, String phone, String gender, int age,
            String address, String city, String country, String postalCode,
            double creditLimit, boolean active,
            String createdDate, String updatedDate,
            String username, String password,
            String preferredLanguage, String preferredCurrency,
            String vipLevel, double discountRate
    ) {
        super(
                customerId, firstName, lastName, email, phone, gender, age,
                address, city, country, postalCode,
                "VIP", creditLimit, active,
                createdDate, updatedDate,
                username, password,
                preferredLanguage, preferredCurrency
        );
        this.vipLevel = vipLevel;
        this.discountRate = discountRate;
    }

    // Copy constructor (Teacher-style)
    protected VipCustomer(VipCustomer prototype) {
        super(prototype);
        this.vipLevel = prototype.vipLevel;
        this.discountRate = prototype.discountRate;
    }

    @Override
    public CustomerPrototype clone() {
        return new VipCustomer(this);
    }
}
