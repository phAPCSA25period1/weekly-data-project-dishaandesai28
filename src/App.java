import java.util.Scanner;

/**
 * Instructions:
 * - Complete the WeeklyData.java class first.
 * - Use this App class to collect user input and test your WeeklyData methods.
 * - Follow all TODOs carefully.
 * - Do NOT hard-code values — use loops and method calls.
 */
public class App {

    public static void main(String[] args) {

        // -------------------------------------------------------------
        // TODO 1: Create a Scanner for user input
        // -------------------------------------------------------------

        Scanner input = new Scanner(System.in);

        // -------------------------------------------------------------
        // TODO 2: Give information about your program
        //         Ask the user about their goals (if applicable)
        // -------------------------------------------------------------

        System.out.println("");
        System.out.println("===========================================");
        System.out.println("Welcome to the Weekly Data Analysis Program!");
        System.out.println("This program will help you reduce your screen time.");
        System.out.print("Do you have any specific goals for this week? (yes/no): ");
        String goal = input.nextLine();
        if (goal.equalsIgnoreCase("yes")) {
            System.out.print("Please share your goal: ");
            String userGoal = input.nextLine();
            System.out.println("Great! Your goal is: " + userGoal);
        } else {
            System.out.println("No worries! Let's focus on tracking your screen time.");
        }

        // -------------------------------------------------------------
        // TODO 3: Create an array to hold 7 days of data
        //         Use an appropriate data type (int or double)
        //         Name the array weekData
        // -------------------------------------------------------------

        double[] weekData = new double[7];

        // -------------------------------------------------------------
        // TODO 4: Use a for loop to collect data for each day of the week
        //         Prompt example:
        //         "Enter <data type> for day X: "
        //
        //         Include input validation:
        //         - Use a while loop to prevent negative values
        //         - Re-prompt if the value is invalid
        // -------------------------------------------------------------

        for (int i = 0; i < weekData.length; i++) {
            System.out.print("Enter screen time in hours for day (number/decimal only) " + (i + 1) + ": ");
            double dailyData = input.nextDouble();
            while (dailyData < 0) {
                System.out.print("Invalid input. Please enter a non-negative value for day " + (i + 1) + ": ");
                dailyData = input.nextDouble();
            }
            weekData[i] = dailyData;
        }

        // -------------------------------------------------------------
        // TODO 5: Create a WeeklyData object
        //         Pass the weekData array into the constructor
        // -------------------------------------------------------------

        WeeklyData weeklyData = new WeeklyData(weekData);

        // -------------------------------------------------------------
        // TODO 6: Display the results of the analysis
        //         Call methods from WeeklyData to display:
        //         - Total
        //         - Average
        //         - Minimum
        //         - Maximum
        //
        //         Use clear labels and formatted output if needed
        // -------------------------------------------------------------

        System.out.printf("Total screen time for the week: %.2f hours%n", weeklyData.getTotal());
        System.out.printf("Average daily screen time: %.2f hours%n", weeklyData.getAverage());
        System.out.printf("Minimum screen time in a day: %.2f hours%n", weeklyData.getMin());
        System.out.printf("Maximum screen time in a day: %.2f hours%n", weeklyData.getMax());

        // -------------------------------------------------------------
        // TODO 7: Display the full week of data
        //         Use the toString() method from WeeklyData
        // -------------------------------------------------------------
        System.out.println("Here is your screen time data for the week:");
        System.out.println(weeklyData.toString());

        // -------------------------------------------------------------
        // TODO 8: Give the user insights about their week
        //         --> "You need to drink more water next week!"
        //         --> "You were very hydrated this week!"
        //         --> etc.
        // -------------------------------------------------------------

        if (weeklyData.getAverage() > 5) {
            System.out.println("You spent quite a bit of time on screens this week. Consider reducing your screen time next week!");
        } else {
            System.out.println("Great job keeping your screen time low this week!");
        }

        input.close();
    }
}
