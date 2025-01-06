import java.util.Scanner;

// Payable Interface
interface Payable {
    double calculateSalary();
    String getPaySlip();
}

// Abstract Employee Class implementing Payable
abstract class Employee1 implements Payable {
    private String name;
    private int employeeId;
    private double baseSalary;

    public Employee1(String name, int employeeId, double baseSalary) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
    }

    // Encapsulation with Getters
    public String getName() {
        return name;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    // Abstract method for subclasses to implement
    public abstract double calculateSalary();

    // Common method for PaySlip format
    public abstract String getPaySlip();
}

// Manager Class extending Employee
class Manager2 extends Employee1 {
    private int teamSize;

    public Manager2(String name, int employeeId, double baseSalary, int teamSize) {
        super(name, employeeId, baseSalary);
        this.teamSize = teamSize;
    }

    @Override
    public double calculateSalary() {
        double bonus = teamSize * 200;  // Example: Bonus is $200 per team member
        return getBaseSalary() + bonus;
    }

    @Override
    public String getPaySlip() {
        return String.format("Manager Pay Slip\nName: %s\nEmployee ID: %d\nBase Salary: $%.2f\nBonus: $%d\nTotal Salary: $%.2f",
                getName(), getEmployeeId(), getBaseSalary(), teamSize * 200, calculateSalary());
    }
}

// Developer Class extending Employee
class Developer1 extends Employee1 {
    private int numberOfProjects;

    public Developer1(String name, int employeeId, double baseSalary, int numberOfProjects) {
        super(name, employeeId, baseSalary);
        this.numberOfProjects = numberOfProjects;
    }

    @Override
    public double calculateSalary() {
        double projectBonus = numberOfProjects * 500;  // Example: Bonus is $500 per project
        return getBaseSalary() + projectBonus;
    }

    @Override
    public String getPaySlip() {
        return String.format("Developer Pay Slip\nName: %s\nEmployee ID: %d\nBase Salary: $%.2f\nBonus for %d Projects: $%d\nTotal Salary: $%.2f",
                getName(), getEmployeeId(), getBaseSalary(), numberOfProjects, numberOfProjects * 500, calculateSalary());
    }
}

// Main Class
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Loop for getting valid employee type
        String employeeType = "";
        while (true) {
            System.out.println("Enter Employee Type (Manager/Developer): ");
            employeeType = scanner.nextLine().trim();

            if (employeeType.equalsIgnoreCase("Manager") || employeeType.equalsIgnoreCase("Developer")) {
                break;  // Exit the loop if valid input
            } else {
                System.out.println("Invalid input. Please enter either 'Manager' or 'Developer'.");
            }
        }

        // Employee common details
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        int employeeId = 0;
        while (true) {
            try {
                System.out.print("Enter Employee ID: ");
                employeeId = Integer.parseInt(scanner.nextLine());  // Validate input as an integer
                break;  // Exit loop if valid input
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID. Please enter a valid numeric Employee ID.");
            }
        }

        double baseSalary = 0.0;
        while (true) {
            try {
                System.out.print("Enter Base Salary: ");
                baseSalary = Double.parseDouble(scanner.nextLine());  // Validate input as a decimal number
                break;  // Exit loop if valid input
            } catch (NumberFormatException e) {
                System.out.println("Invalid salary. Please enter a valid numeric value for the salary.");
            }
        }

        Employee1 employee = null;

        // Employee-specific details and object creation
        if (employeeType.equalsIgnoreCase("Manager")) {
            int teamSize = 0;
            while (true) {
                try {
                    System.out.print("Enter Team Size: ");
                    teamSize = Integer.parseInt(scanner.nextLine());  // Validate input as an integer
                    break;  // Exit loop if valid input
                } catch (NumberFormatException e) {
                    System.out.println("Invalid team size. Please enter a valid numeric value.");
                }
            }
            employee = new Manager2(name, employeeId, baseSalary, teamSize);
        } else if (employeeType.equalsIgnoreCase("Developer")) {
            int numberOfProjects = 0;
            while (true) {
                try {
                    System.out.print("Enter Number of Projects: ");
                    numberOfProjects = Integer.parseInt(scanner.nextLine());  // Validate input as an integer
                    break;  // Exit loop if valid input
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number of projects. Please enter a valid numeric value.");
                }
            }
            employee = new Developer1(name, employeeId, baseSalary, numberOfProjects);
        }

        // Display the PaySlip
        System.out.println("\n" + employee.getPaySlip());

        scanner.close();
    }
}
