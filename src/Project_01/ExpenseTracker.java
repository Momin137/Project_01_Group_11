package Project_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ExpenseTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Expense> expenses = new ArrayList<>();
        Map<String, Double> categoryTotalMap = new HashMap<>();

        while (true) {
            System.out.println("Welcome to the Expense Tracker!");
            System.out.println("1. Add Expenses");
            System.out.println("2. List Expenses");
            System.out.println("3. Analyze Expenses");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter expense description: ");
                    String description = scanner.nextLine();
                    System.out.print("Select expense category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter expense amount: ");
                    double amount = scanner.nextDouble();
                    expenses.add(new Expense(description, category, amount));
                    System.out.println("Expense added successfully!");
                    break;

                case 2:
                    System.out.println("Expense List:");
                    int expenseNumber = 1;
                    for (Expense expense : expenses) {
                        System.out.printf("%d. Description: %s | Category: %s | Amount: $%.2f%n",
                                expenseNumber++, expense.getDescription(), expense.getCategory(), expense.getAmount());
                    }
                    break;

                case 3:
                    System.out.print("Choose a category to analyze: ");
                    String analyzeCategory = scanner.next();
                    double totalCategoryExpenses = 0.0;
                    for (Expense expense : expenses) {
                        if (expense.getCategory().equalsIgnoreCase(analyzeCategory)) {
                            totalCategoryExpenses += expense.getAmount();
                        }
                    }
                    System.out.printf("Total Expenses in %s Category: $%.2f%n", analyzeCategory, totalCategoryExpenses);
                    break;

                case 4:
                    System.out.println("Thank you for using the Expense Tracker!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Please select a valid option.");
            }
        }
    }
}





