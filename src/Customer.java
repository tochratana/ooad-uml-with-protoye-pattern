public class Customer implements CustomerPrototype {

    protected String customerId;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phone;
    protected String gender;
    protected int age;

    protected String address;
    protected String city;
    protected String country;
    protected String postalCode;

    protected String customerType;
    protected double creditLimit;
    protected boolean active;

    protected String createdDate;
    protected String updatedDate;

    protected String username;
    protected String password;

    protected String preferredLanguage;
    protected String preferredCurrency;

    public Customer(
            String customerId, String firstName, String lastName,
            String email, String phone, String gender, int age,
            String address, String city, String country, String postalCode,
            String customerType, double creditLimit, boolean active,
            String createdDate, String updatedDate,
            String username, String password,
            String preferredLanguage, String preferredCurrency
    ) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.customerType = customerType;
        this.creditLimit = creditLimit;
        this.active = active;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.username = username;
        this.password = password;
        this.preferredLanguage = preferredLanguage;
        this.preferredCurrency = preferredCurrency;
    }

    // Copy constructor (important for subclass cloning)
    protected Customer(Customer prototype) {
        this(
                prototype.customerId,
                prototype.firstName,
                prototype.lastName,
                prototype.email,
                prototype.phone,
                prototype.gender,
                prototype.age,
                prototype.address,
                prototype.city,
                prototype.country,
                prototype.postalCode,
                prototype.customerType,
                prototype.creditLimit,
                prototype.active,
                prototype.createdDate,
                prototype.updatedDate,
                prototype.username,
                prototype.password,
                prototype.preferredLanguage,
                prototype.preferredCurrency
        );
    }

    @Override
    public CustomerPrototype clone() {
        return new Customer(this);
    }
}
