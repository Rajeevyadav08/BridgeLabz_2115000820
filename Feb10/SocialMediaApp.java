package Feb10;

import java.util.*;

class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    private User head = null;

    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newUser;
        }
        System.out.println("User added: " + name);
    }

    public void addFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        if (!user1.friendIds.contains(userId2)) {
            user1.friendIds.add(userId2);
        }
        if (!user2.friendIds.contains(userId1)) {
            user2.friendIds.add(userId1);
        }
        System.out.println("Friend connection added between " + user1.name + " and " + user2.name);
    }

    public void removeFriendConnection(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        user1.friendIds.remove((Integer) userId2);
        user2.friendIds.remove((Integer) userId1);
        System.out.println("Friend connection removed between " + user1.name + " and " + user2.name);
    }

    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUserById(userId1);
        User user2 = findUserById(userId2);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }
        Set<Integer> mutualFriends = new HashSet<>(user1.friendIds);
        mutualFriends.retainAll(user2.friendIds);
        System.out.println("Mutual friends between " + user1.name + " and " + user2.name + ": " + mutualFriends);
    }

    public void displayAllFriends(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }
        System.out.println("Friends of " + user.name + ": " + user.friendIds);
    }

    public void searchUser(String name) {
        User temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("User found: ID=" + temp.userId + ", Name=" + temp.name + ", Age=" + temp.age + ", Friends=" + temp.friendIds);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("User with name " + name + " not found.");
        }
    }

    public void countFriendsForEachUser() {
        User temp = head;
        while (temp != null) {
            System.out.println("User " + temp.name + " has " + temp.friendIds.size() + " friends.");
            temp = temp.next;
        }
    }

    private User findUserById(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}

public class SocialMediaApp {
    public static void main(String[] args) {
        SocialMedia socialMedia = new SocialMedia();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nSocial Media Friend Connections Menu");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Find Mutual Friends");
            System.out.println("5. Display All Friends of a User");
            System.out.println("6. Search User by Name");
            System.out.println("7. Count Friends for Each User");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter User ID: ");
                int userId = sc.nextInt();
                sc.nextLine();  // Consume newline
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Age: ");
                int age = sc.nextInt();
                socialMedia.addUser(userId, name, age);
            } else if (choice == 2) {
                System.out.print("Enter User ID 1: ");
                int userId1 = sc.nextInt();
                System.out.print("Enter User ID 2: ");
                int userId2 = sc.nextInt();
                socialMedia.addFriendConnection(userId1, userId2);
            } else if (choice == 3) {
                System.out.print("Enter User ID 1: ");
                int userId1 = sc.nextInt();
                System.out.print("Enter User ID 2: ");
                int userId2 = sc.nextInt();
                socialMedia.removeFriendConnection(userId1, userId2);
            } else if (choice == 4) {
                System.out.print("Enter User ID 1: ");
                int userId1 = sc.nextInt();
                System.out.print("Enter User ID 2: ");
                int userId2 = sc.nextInt();
                socialMedia.findMutualFriends(userId1, userId2);
            } else if (choice == 5) {
                System.out.print("Enter User ID: ");
                int userId = sc.nextInt();
                socialMedia.displayAllFriends(userId);
            } else if (choice == 6) {
                sc.nextLine();  // Consume newline
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                socialMedia.searchUser(name);
            } else if (choice == 7) {
                socialMedia.countFriendsForEachUser();
            } else if (choice == 8) {
                System.out.println("Exiting...");
                sc.close();
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
