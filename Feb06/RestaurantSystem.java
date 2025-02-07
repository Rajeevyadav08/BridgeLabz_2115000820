package Feb06;

// Superclass: Person
class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Interface: Worker
interface Worker {
    void performDuties();
}

// Subclass: Chef (inherits from Person and implements Worker)
class Chef extends Person implements Worker {
    String specialty;

    Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is preparing " + specialty + " dishes.");
    }
}

// Subclass: Waiter (inherits from Person and implements Worker)
class Waiter extends Person implements Worker {
    int tableCount;

    Waiter(String name, int id, int tableCount) {
        super(name, id);
        this.tableCount = tableCount;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving " + tableCount + " tables.");
    }
}

// Main Class
public class RestaurantSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon Ramsay", 101, "Italian");
        Waiter waiter = new Waiter("John Doe", 202, 5);

        Person[] staff = {chef, waiter};

        for (Person person : staff) {
            System.out.println("-------- Staff Details --------");
            person.displayDetails();
            if (person instanceof Worker) {
                ((Worker) person).performDuties();
            }
            System.out.println();
        }
    }
}
