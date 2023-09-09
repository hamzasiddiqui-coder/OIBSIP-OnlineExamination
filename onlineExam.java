import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class onlineExam {
    private static User currentUser;
    private static Timer examTimer;
    private static int remainingTime; // in seconds

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Online Examination System!");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    currentUser = login();
                    if (currentUser != null) {
                        showMainMenu();
                    } else {
                        System.out.println("Invalid username or password. Please try again.");
                    }
                    break;
                case 2:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static User login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        
        if ("hamza".equals(username) && "united".equals(password)) {
            return new User(username);
        } else {
            return null;
        }
    }

    private static void showMainMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Update Profile");
            System.out.println("2. Start Exam");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    updateProfile();
                    break;
                case 2:
                    startExam();
                    break;
                case 3:
                    currentUser = null; // Logout
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private static void updateProfile() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Current Profile:");
        System.out.println("Username: " + currentUser.getUsername());

        System.out.print("Enter your new username: ");
        String newUsername = scanner.next();

        // Update the user's profile with the new username
        currentUser.setUsername(newUsername);

        System.out.println("Profile updated successfully.");
    }

    private static void startExam() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Starting Exam...");

        // Simulate a 5-minute exam timer
        remainingTime = 300; // 300 seconds = 5 minutes
        examTimer = new Timer();
        examTimer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (remainingTime > 0) {
                    System.out.println("Time remaining: " + remainingTime + " seconds");
                    remainingTime--;
                } else {
                    System.out.println("Time's up! Exam submitted automatically.");
                    examTimer.cancel();
                }
            }
        }, 0, 1000); 
        System.out.println("Exam completed.");
        examTimer.cancel();
    }

    private static class User {
        private String username;

        public User(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
   
}
