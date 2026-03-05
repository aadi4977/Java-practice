class Friend {
    int friendID;
    Friend next;

    Friend(int id) {
        friendID = id;
        next = null;
    }
}

class User {
    int userID;
    String name;
    int age;
    Friend friendList;
    User next;

    User(int userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        friendList = null;
        next = null;
    }
}

class SocialMedia {

    User head = null;

    // Add user
    void addUser(int id, String name, int age) {

        User newUser = new User(id, name, age);

        if (head == null) {
            head = newUser;
            return;
        }

        User temp = head;

        while (temp.next != null)
            temp = temp.next;

        temp.next = newUser;
    }

    // Find user
    User findUser(int id) {

        User temp = head;

        while (temp != null) {
            if (temp.userID == id)
                return temp;

            temp = temp.next;
        }

        return null;
    }

    // Add friend connection
    void addFriend(int id1, int id2) {

        User u1 = findUser(id1);
        User u2 = findUser(id2);

        if (u1 == null || u2 == null) {
            System.out.println("User not found");
            return;
        }

        Friend f1 = new Friend(id2);
        f1.next = u1.friendList;
        u1.friendList = f1;

        Friend f2 = new Friend(id1);
        f2.next = u2.friendList;
        u2.friendList = f2;

        System.out.println("Friend connection added");
    }

    // Remove friend connection
    void removeFriend(int id1, int id2) {

        User u = findUser(id1);

        if (u == null)
            return;

        Friend temp = u.friendList;
        Friend prev = null;

        while (temp != null && temp.friendID != id2) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null)
            return;

        if (prev == null)
            u.friendList = temp.next;
        else
            prev.next = temp.next;

        System.out.println("Friend removed");
    }

    // Display friends of a user
    void displayFriends(int id) {

        User u = findUser(id);

        if (u == null) {
            System.out.println("User not found");
            return;
        }

        Friend temp = u.friendList;

        System.out.println("Friends of " + u.name);

        while (temp != null) {
            System.out.println("Friend ID: " + temp.friendID);
            temp = temp.next;
        }
    }

    // Search user by ID
    void searchByID(int id) {

        User temp = head;

        while (temp != null) {

            if (temp.userID == id) {
                System.out.println(temp.userID + " " + temp.name + " " + temp.age);
                return;
            }

            temp = temp.next;
        }

        System.out.println("User not found");
    }

    // Search user by name
    void searchByName(String name) {

        User temp = head;

        while (temp != null) {

            if (temp.name.equals(name)) {
                System.out.println(temp.userID + " " + temp.name + " " + temp.age);
                return;
            }

            temp = temp.next;
        }

        System.out.println("User not found");
    }

    // Count number of friends
    void countFriends(int id) {

        User u = findUser(id);

        if (u == null)
            return;

        int count = 0;
        Friend temp = u.friendList;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total friends: " + count);
    }

    // Find mutual friends
    void mutualFriends(int id1, int id2) {

        User u1 = findUser(id1);
        User u2 = findUser(id2);

        if (u1 == null || u2 == null)
            return;

        Friend f1 = u1.friendList;

        System.out.println("Mutual Friends:");

        while (f1 != null) {

            Friend f2 = u2.friendList;

            while (f2 != null) {

                if (f1.friendID == f2.friendID)
                    System.out.println("Friend ID: " + f1.friendID);

                f2 = f2.next;
            }

            f1 = f1.next;
        }
    }
}

public class SocialMediaSystem {

    public static void main(String[] args) {

        SocialMedia sm = new SocialMedia();

        sm.addUser(1, "Aadi", 20);
        sm.addUser(2, "Rahul", 21);
        sm.addUser(3, "Priya", 19);

        sm.addFriend(1, 2);
        sm.addFriend(1, 3);

        sm.displayFriends(1);

        sm.countFriends(1);

        sm.searchByName("Rahul");

        sm.mutualFriends(2, 3);
    }
}
