# Customer Prototype Pattern Implementation

A comprehensive Java implementation demonstrating the **Prototype Design Pattern** through a customer management system.

## Table of Contents
- [What is Prototype Pattern?](#what-is-prototype-pattern)
- [Why Use Prototype Pattern?](#why-use-prototype-pattern)
- [When to Use It?](#when-to-use-it)
- [Pattern Structure](#pattern-structure)
- [Implementation Details](#implementation-details)
- [Code Examples](#code-examples)
- [How to Run](#how-to-run)
- [Real-World Use Cases](#real-world-use-cases)

## What is Prototype Pattern?

The **Prototype Pattern** is a **creational design pattern** that lets you create new objects by copying existing objects (prototypes) instead of creating them from scratch. Think of it as a cloning mechanism for objects.

### Key Concept
Instead of writing:
```java
Customer newCustomer = new Customer(param1, param2, param3, ...); // 20+ parameters!
```

You write:
```java
Customer newCustomer = (Customer) existingCustomer.clone(); // Much simpler!
```

## 💡 Why Use Prototype Pattern?

### Problems It Solves:

1. **Complex Object Creation**: When objects have many fields and creating them is expensive or complicated
2. **Avoiding Subclass Explosion**: Instead of creating many subclasses for different configurations, clone and modify
3. **Runtime Object Creation**: When you don't know what exact type of object you need until runtime
4. **Performance**: Cloning can be faster than creating new objects from scratch

### Benefits:

✅ **Reduces complexity** - No need to specify all parameters every time  
✅ **Better performance** - Cloning is often faster than construction  
✅ **Flexibility** - Create objects dynamically at runtime  
✅ **Hides complexity** - Client doesn't need to know about concrete classes  
✅ **Reduces initialization code** - Copy existing configured objects

## When to Use It?

Use Prototype Pattern when:

- Your objects have many fields and constructors are becoming unwieldy
- Object creation is expensive (database queries, API calls, complex calculations)
- You need to create objects that are similar to existing ones
- You want to avoid tight coupling between client code and concrete classes
- You need to create objects at runtime based on dynamic configuration

**Real Example**: In this project, creating a `Customer` object requires 20 parameters! Instead of repeating this everywhere, we create a prototype once and clone it whenever we need similar customers.

## Pattern Structure
![img.png](image/2026-01-18%2000.46.08.jpg)

### Components:

1. **Prototype Interface** (`CustomerPrototype`): Declares the cloning method
2. **Concrete Prototype** (`Customer`): Implements cloning for base customer
3. **Subclass Prototype** (`VipCustomer`): Extends Customer with VIP features
4. **Client** (`CustomerApp`): Uses prototypes to create new objects

##  Implementation Details

### 1. Prototype Interface
```java
public interface CustomerPrototype {
    CustomerPrototype clone();
}
```
Defines the contract that all prototypes must implement.

### 2. Concrete Prototype (Customer)
```java
public class Customer implements CustomerPrototype {
    // 20+ fields for customer data
    
    // Regular constructor
    public Customer(String customerId, String firstName, ...) {
        // Initialize all fields
    }
    
    // Copy constructor - KEY for cloning!
    protected Customer(Customer prototype) {
        this(
            prototype.customerId,
            prototype.firstName,
            // ... copy all fields
        );
    }
    
    @Override
    public CustomerPrototype clone() {
        return new Customer(this); // Use copy constructor
    }
}
```

**Key Points:**
- Has both regular constructor and copy constructor
- Copy constructor creates exact copy of existing object
- `clone()` method uses copy constructor internally

### 3. Subclass Prototype (VipCustomer)
```java
public class VipCustomer extends Customer {
    private String vipLevel;
    private double discountRate;
    
    // Regular constructor
    public VipCustomer(..., String vipLevel, double discountRate) {
        super(...); // Call parent constructor
        this.vipLevel = vipLevel;
        this.discountRate = discountRate;
    }
    
    // Copy constructor - copies parent + own fields
    protected VipCustomer(VipCustomer prototype) {
        super(prototype); // Copy parent fields
        this.vipLevel = prototype.vipLevel;
        this.discountRate = prototype.discountRate;
    }
    
    @Override
    public CustomerPrototype clone() {
        return new VipCustomer(this);
    }
}
```

**Key Points:**
- Inherits from Customer
- Copy constructor calls parent copy constructor
- Adds VIP-specific fields

## Code Examples

### Creating Prototypes (One-time setup)
```java
// Create a normal customer prototype
Customer normalPrototype = new Customer(
    "C001", "Ratana", "Toch",
    "ratana@mail.com", "0123456", "Male", 22,
    "Phnom Penh", "Phnom Penh", "Cambodia", "12000",
    "Regular", 1000, true,
    "2026-01-01", "2026-01-01",
    "ratana", "123",
    "EN", "USD"
);

// Create a VIP customer prototype
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
```

### Using Prototypes (Cloning)
```java
// Clone normal customers - just change what you need!
Customer customer1 = (Customer) normalPrototype.clone();
Customer customer2 = (Customer) normalPrototype.clone();
Customer customer3 = (Customer) normalPrototype.clone();

// Clone VIP customers
VipCustomer vip1 = (VipCustomer) vipPrototype.clone();
VipCustomer vip2 = (VipCustomer) vipPrototype.clone();

// Now you can modify the clones as needed
// customer1.setEmail("newemail@mail.com");
// vip1.setVipLevel("Platinum");
```

### Without Prototype Pattern (The Hard Way)
```java
// You'd have to do this EVERY TIME!
Customer c1 = new Customer(
    "C002", "John", "Doe",
    "john@mail.com", "111111", "Male", 30,
    "Phnom Penh", "Phnom Penh", "Cambodia", "12000",
    "Regular", 1000, true,
    "2026-01-01", "2026-01-01",
    "john", "pass123",
    "EN", "USD"
);

Customer c2 = new Customer(
    "C003", "Jane", "Smith",
    "jane@mail.com", "222222", "Female", 28,
    "Phnom Penh", "Phnom Penh", "Cambodia", "12000",
    "Regular", 1000, true,
    "2026-01-01", "2026-01-01",
    "jane", "pass456",
    "EN", "USD"
);
// Repeating 20 parameters every time!
```

### With Prototype Pattern (The Easy Way)
```java
// Clone once, modify what's different
Customer c1 = (Customer) normalPrototype.clone();
// c1.setCustomerId("C002");
// c1.setFirstName("John");

Customer c2 = (Customer) normalPrototype.clone();
// c2.setCustomerId("C003");
// c2.setFirstName("Jane");
// Much cleaner!
```

##  How to Run

### Option 1: Command Line
```bash
# Clone the repository
git clone https://github.com/your-username/customer-prototype-pattern.git
cd customer-prototype-pattern

# Compile
javac -d bin src/main/java/com/prototype/pattern/**/*.java

# Run
java -cp bin com.prototype.pattern.client.CustomerApp
```

### Option 2: IDE (IntelliJ IDEA / Eclipse)
1. Import project as Java project
2. Run `CustomerApp.java`

### Expected Output
```
=== Prototype Pattern Demo ===

Creating clones...

Original Normal Customer: Customer[ID=C001, Name=Ratana Toch, Type=Regular, Email=ratana@mail.com]
Cloned Customer 1: Customer[ID=C001, Name=Ratana Toch, Type=Regular, Email=ratana@mail.com]

Original VIP Customer: VipCustomer[ID=VIP001, Name=Sokha Chan, Level=Gold, Discount=15%]
Cloned VIP Customer 1: VipCustomer[ID=VIP001, Name=Sokha Chan, Level=Gold, Discount=15%]
Cloned VIP Customer 2: VipCustomer[ID=VIP001, Name=Sokha Chan, Level=Gold, Discount=15%]
```

## Real-World Use Cases

### 1. **GUI Components**
```java
// Create a button template
Button blueButton = new Button("Click me", Color.BLUE, 200, 50);

// Clone it multiple times for your UI
Button btn1 = blueButton.clone();
Button btn2 = blueButton.clone();
Button btn3 = blueButton.clone();
```

### 2. **Game Development**
```java
// Enemy template
Enemy goblin = new Enemy("Goblin", 100, 10, 5);

// Spawn multiple enemies
Enemy goblin1 = goblin.clone();
Enemy goblin2 = goblin.clone();
Enemy goblin3 = goblin.clone();
```

### 3. **Document Processing**
```java
// Invoice template with company info
Invoice template = new Invoice(companyName, address, taxRate, ...);

// Create invoices for different customers
Invoice invoice1 = template.clone();
invoice1.setCustomer(customer1);

Invoice invoice2 = template.clone();
invoice2.setCustomer(customer2);
```

### 4. **Database Records**
```java
// Default user settings
UserSettings defaultSettings = new UserSettings(
    theme="dark", 
    language="en", 
    notifications=true,
    ...
);

// Clone for new users
UserSettings user1Settings = defaultSettings.clone();
UserSettings user2Settings = defaultSettings.clone();
```

### 5. **E-commerce**
```java
// Product template
Product tshirtTemplate = new Product(
    category="Clothing",
    brand="Nike",
    material="Cotton",
    care="Machine washable"
);

// Clone for different sizes/colors
Product redTshirt = tshirtTemplate.clone();
redTshirt.setColor("Red");
redTshirt.setSize("M");

Product blueTshirt = tshirtTemplate.clone();
blueTshirt.setColor("Blue");
blueTshirt.setSize("L");
```

## 📁 Project Structure

```
customer-prototype-pattern/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── prototype/
│                   └── pattern/
│                       ├── interfaces/
│                       │   └── CustomerPrototype.java
│                       ├── models/
│                       │   ├── Customer.java
│                       │   └── VipCustomer.java
│                       └── client/
│                           └── CustomerApp.java
├── .gitignore
└── README.md
```

## 🎓 Key Takeaways

1. **Prototype Pattern** = Creating objects by cloning existing ones
2. **Use it when** object creation is complex or expensive
3. **Copy Constructor** is the key to proper cloning
4. **Inheritance** works perfectly with this pattern
5. **Saves time** and makes code cleaner and more maintainable

##  Contributing

Feel free to fork this repository and submit pull requests for improvements!

## License

This project is for educational purposes.

##  Author

Created as a demonstration of the Prototype Design Pattern in Java.

---

**Happy Coding! **

If you found this helpful, please ⭐ star this repository!