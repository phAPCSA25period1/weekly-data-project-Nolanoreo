public class WeeklyData {

    // Instance variables
    private double[] data; // Array to store weekly data
    private String dataType; // Type of data (e.g., "Screen Time" or "Sleep Quality")

    // Constructor
    public WeeklyData(double[] input, String dataType) {
        // Check if the input array is valid
        if (input == null || input.length != 7) {
            throw new IllegalArgumentException("Input array must contain 7 days of data.");
        }
        // Assign the input array directly (no deep copy for simplicity)
        this.data = input;
        this.dataType = dataType;
    }

    // Method to calculate the total of all values in the week
    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < data.length; i++) {
            total += data[i];
        }
        return total;
    }

    // Method to calculate the average of the weekly data
    public double getAverage() {
        return getTotal() / 7; // Divide by 7 since there are 7 days in a week
    }

    // Method to find the maximum value in the weekly data
    public double getMax() {
        double max = data[0]; // Start with the first value
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    // Method to find the minimum value in the weekly data
    public double getMin() {
        double min = data[0]; // Start with the first value
        for (int i = 1; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }
}