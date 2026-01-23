import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // -------------------------------------------------------------
        // Step 1: Create a Scanner for user input
        // -------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);

        // -------------------------------------------------------------
        // Step 2: Give information about your program
        // -------------------------------------------------------------
        System.out.println("Welcome to the Screen Time and Sleep Quality Tracker!");
        System.out.println("This app helps you track your daily screen time and sleep quality.");
        System.out.println("Let's get started!");

        // -------------------------------------------------------------
        // Step 3: Create an array to hold 7 days of data
        // -------------------------------------------------------------
        double[] screenTime = new double[7];
        double[] sleepQuality = new double[7];

        // -------------------------------------------------------------
        // Step 4: Collect data for screen time
        // -------------------------------------------------------------
        System.out.println("\nEnter your daily screen time (in hours, 0-24):");
        for (int i = 0; i < 7; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            screenTime[i] = getValidInput(scanner, 0, 24); // Validate input for screen time
        }

        // -------------------------------------------------------------
        // Step 4: Collect data for sleep quality
        // -------------------------------------------------------------
        System.out.println("\nEnter your daily sleep quality (scale of 1-10):");
        for (int i = 0; i < 7; i++) {
            System.out.print("Day " + (i + 1) + ": ");
            sleepQuality[i] = getValidInput(scanner, 1, 10); // Validate input for sleep quality
        }

        // -------------------------------------------------------------
        // Step 5: Create WeeklyData objects
        // -------------------------------------------------------------
        WeeklyData screenTimeData = new WeeklyData(screenTime, "Screen Time");
        WeeklyData sleepQualityData = new WeeklyData(sleepQuality, "Sleep Quality");

        // -------------------------------------------------------------
        // Step 6: Display results for screen time
        // -------------------------------------------------------------
        System.out.println("\nScreen Time Analysis:");
        System.out.println("Total: " + screenTimeData.getTotal() + " hours");
        System.out.println("Average: " + screenTimeData.getAverage() + " hours/day");
        System.out.println("Max: " + screenTimeData.getMax() + " hours");
        System.out.println("Min: " + screenTimeData.getMin() + " hours");

        // -------------------------------------------------------------
        // Step 7: Display results for sleep quality
        // -------------------------------------------------------------
        System.out.println("\nSleep Quality Analysis:");
        System.out.println("Total: " + sleepQualityData.getTotal());
        System.out.println("Average: " + sleepQualityData.getAverage() + "/day");
        System.out.println("Max: " + sleepQualityData.getMax());
        System.out.println("Min: " + sleepQualityData.getMin());

        // -------------------------------------------------------------
        // Step 8: Mood Analysis
        // -------------------------------------------------------------
        System.out.println("\nMood Analysis:");
        if (screenTimeData.getAverage() > 7.0) {
            System.out.println("High screen time may negatively affect your mood.");
        } else {
            System.out.println("Screen time is within a healthy range.");
        }
        if (sleepQualityData.getAverage() < 6.0) {
            System.out.println("Low sleep quality may negatively affect your mood.");
        } else {
            System.out.println("Sleep quality is within a healthy range.");
        }

        // Close the scanner
        scanner.close();
    }

    // Helper method to validate input within a range
    private static double getValidInput(Scanner scanner, double min, double max) {
        double value;
        while (true) {
            value = scanner.nextDouble();
            if (value >= min && value <= max) {
                break;
            }
            System.out.print("Invalid input. Please enter a value between " + min + " and " + max + ": ");
        }
        return value;
    }
}