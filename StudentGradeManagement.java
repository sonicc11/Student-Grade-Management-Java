import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Double> marks = new ArrayList<>();

        System.out.println("===== STUDENT GRADE MANAGEMENT SYSTEM =====");

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // Take student names and marks
        for (int i = 0; i < n; i++) {

            System.out.println("\nStudent " + (i + 1));

            System.out.print("Enter student name: ");
            String name = sc.next();

            System.out.print("Enter marks (0-100): ");
            double mark = sc.nextDouble();

            // Validate marks
            while (mark < 0 || mark > 100) {
                System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                System.out.print("Enter marks again: ");
                mark = sc.nextDouble();
            }

            names.add(name);
            marks.add(mark);
        }

        // Calculate total
        double total = 0;

        for (double mark : marks) {
            total += mark;
        }

        // Calculate average
        double average = total / marks.size();

        // Find highest and lowest marks
        double highest = marks.get(0);
        double lowest = marks.get(0);

        for (double mark : marks) {

            if (mark > highest) {
                highest = mark;
            }

            if (mark < lowest) {
                lowest = mark;
            }
        }

        // Display formatted summary report
        System.out.println("\n========== STUDENT REPORT ==========");
        System.out.printf("%-20s %-10s%n", "Student Name", "Marks");
        System.out.println("------------------------------------");

        for (int i = 0; i < names.size(); i++) {
            System.out.printf("%-20s %-10.2f%n",
                    names.get(i), marks.get(i));
        }

        System.out.println("------------------------------------");
        System.out.printf("Average Marks : %.2f%n", average);
        System.out.printf("Highest Marks : %.2f%n", highest);
        System.out.printf("Lowest Marks  : %.2f%n", lowest);
        System.out.println("====================================");

        sc.close();
    }
}
