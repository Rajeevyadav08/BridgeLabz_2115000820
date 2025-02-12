package Feb10;

import java.util.Scanner;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class InventoryManagementSystem {
    private Item head = null;

    public void addAtBeginning(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    public void addAtEnd(String itemName, int itemId, int quantity, double price) {
        Item newItem = new Item(itemName, itemId, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    public void addAtPosition(String itemName, int itemId, int quantity, double price, int position) {
        if (position <= 1) {
            addAtBeginning(itemName, itemId, quantity, price);
            return;
        }
        Item newItem = new Item(itemName, itemId, quantity, price);
        Item temp = head;
        int count = 1;
        while (count < position - 1 && temp.next != null) {
            temp = temp.next;
            count++;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    public void removeById(int itemId) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        if (head.itemId == itemId) {
            head = head.next;
            System.out.println("Item with ID " + itemId + " removed.");
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.itemId != itemId) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item with ID " + itemId + " not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item with ID " + itemId + " removed.");
        }
    }

    public void updateQuantityById(int itemId, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                temp.quantity = newQuantity;
                System.out.println("Quantity updated for Item ID " + itemId);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    public void searchById(int itemId) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == itemId) {
                System.out.println("Item Found: " + temp.itemName + " (ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price + ")");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item with ID " + itemId + " not found.");
    }

    public void searchByName(String itemName) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(itemName)) {
                System.out.println("Item Found: " + temp.itemName + " (ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price + ")");
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Item with name " + itemName + " not found.");
        }
    }

    public void calculateTotalValue() {
        double totalValue = 0;
        Item temp = head;
        while (temp != null) {
            totalValue += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: $" + totalValue);
    }

    public void sortByName(boolean ascending) {
        if (head == null || head.next == null) return;
        head = mergeSort(head, "name", ascending);
    }

    public void sortByPrice(boolean ascending) {
        if (head == null || head.next == null) return;
        head = mergeSort(head, "price", ascending);
    }

    private Item mergeSort(Item head, String criteria, boolean ascending) {
        if (head == null || head.next == null) return head;
        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, criteria, ascending);
        Item right = mergeSort(nextOfMiddle, criteria, ascending);

        return merge(left, right, criteria, ascending);
    }

    private Item merge(Item left, Item right, String criteria, boolean ascending) {
        if (left == null) return right;
        if (right == null) return left;

        boolean condition;
        if (criteria.equals("name")) {
            condition = ascending ? left.itemName.compareTo(right.itemName) <= 0 : left.itemName.compareTo(right.itemName) > 0;
        } else {
            condition = ascending ? left.price <= right.price : left.price > right.price;
        }

        if (condition) {
            left.next = merge(left.next, right, criteria, ascending);
            return left;
        } else {
            right.next = merge(left, right.next, criteria, ascending);
            return right;
        }
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            System.out.println(temp.itemName + " (ID: " + temp.itemId + ", Quantity: " + temp.quantity + ", Price: " + temp.price + ")");
            temp = temp.next;
        }
    }
}

public class InventoryManagementApp {
    public static void main(String[] args) {
        InventoryManagementSystem inventory = new InventoryManagementSystem();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management System Menu");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Specific Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity by ID");
            System.out.println("6. Search Item by ID");
            System.out.println("7. Search Item by Name");
            System.out.println("8. Calculate Total Value of Inventory");
            System.out.println("9. Sort Inventory by Name");
            System.out.println("10. Sort Inventory by Price");
            System.out.println("11. Display Inventory");
            System.out.println("12. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                System.out.print("Enter Item Name: ");
                String itemName = sc.nextLine();
                System.out.print("Enter Item ID: ");
                int itemId = sc.nextInt();
                System.out.print("Enter Quantity: ");
                int quantity = sc.nextInt();
                System.out.print("Enter Price: ");
                double price = sc.nextDouble();
                inventory.addAtBeginning(itemName, itemId, quantity, price);
            } else if (choice == 2) {
                System.out.print("Enter Item Name: ");
                String itemName = sc.nextLine();
                System.out.print("Enter Item ID: ");
                int itemId = sc.nextInt();
                System.out.print("Enter Quantity: ");
                int quantity = sc.nextInt();
                System.out.print("Enter Price: ");
                double price = sc.nextDouble();
                inventory.addAtEnd(itemName, itemId, quantity, price);
            } else if (choice == 3) {
                System.out.print("Enter Item Name: ");
                String itemName = sc.nextLine();
                System.out.print("Enter Item ID: ");
                int itemId = sc.nextInt();
                System.out.print("Enter Quantity: ");
                int quantity = sc.nextInt();
                System.out.print("Enter Price: ");
                double price = sc.nextDouble();
                System.out.print("Enter Position: ");
                int position = sc.nextInt();
                inventory.addAtPosition(itemName, itemId, quantity, price, position);
            } else if (choice == 4) {
                System.out.print("Enter Item ID to Remove: ");
                int itemId = sc.nextInt();
                inventory.removeById(itemId);
            } else if (choice == 5) {
                System.out.print("Enter Item ID to Update Quantity: ");
                int itemId = sc.nextInt();
                System.out.print("Enter New Quantity: ");
                int newQuantity = sc.nextInt();
                inventory.updateQuantityById(itemId, newQuantity);
            } else if (choice == 6) {
                System.out.print("Enter Item ID to Search: ");
                int itemId = sc.nextInt();
                inventory.searchById(itemId);
            } else if (choice == 7) {
                System.out.print("Enter Item Name to Search: ");
                String itemName = sc.nextLine();
                inventory.searchByName(itemName);
            } else if (choice == 8) {
                inventory.calculateTotalValue();
            } else if (choice == 9) {
                System.out.print("Sort by Name (1 for Ascending, 0 for Descending): ");
                boolean ascending = sc.nextInt() == 1;
                inventory.sortByName(ascending);
            } else if (choice == 10) {
                System.out.print("Sort by Price (1 for Ascending, 0 for Descending): ");
                boolean ascending = sc.nextInt() == 1;
                inventory.sortByPrice(ascending);
            } else if (choice == 11) {
                inventory.displayInventory();
            } else if (choice == 12) {
                System.out.println("Exiting...");
                sc.close();
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

