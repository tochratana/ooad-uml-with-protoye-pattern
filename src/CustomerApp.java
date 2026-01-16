public class CustomerApp {

    public static void main(String[] args) {

        // Base prototype
        Customer normalCustomer = new Customer(
                "C001", "Ratana", "Toch",
                "ratana@mail.com", "0123456", "Male", 22,
                "Phnom Penh", "Phnom Penh", "Cambodia", "12000",
                "Regular", 1000, true,
                "2026-01-01", "2026-01-01",
                "ratana", "123",
                "EN", "USD"
        );

        // VIP prototype
        VipCustomer vipPrototype = new VipCustomer(
                "VIP001", "Sokha", "Chan",
                "vip@mail.com", "0987654", "Female", 25,
                "Phnom Penh", "Phnom Penh", "Cambodia", "12000",
                5000, true,
                "2026-01-01", "2026-01-01",
                "vipuser", "vip123",
                "EN", "USD",
                "Gold", 0.15
        );

        Customer c1 = (Customer) normalCustomer.clone();
        VipCustomer v1 = (VipCustomer) vipPrototype.clone();
        VipCustomer v2 = (VipCustomer) vipPrototype.clone();
    }
}
