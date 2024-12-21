package chapter_9;

public class task_8 {
    public static void main(String[] args) {


        FullTimeEmployee full = new FullTimeEmployee("Sardor", 1, 5000);
        PartTimeEmployee part = new PartTimeEmployee("Begzod", 2, 20, 80); // $20/hour, 80 hours worked
        Intern intern = new Intern("QudratAka", 3, 1000);
        System.out.println("Full-Time");
        System.out.println(full.getEmployeeInfo());
        System.out.println("Salary = " + full.calculateSalary());
        System.out.println("-------------");
        System.out.println("Part-Time ");
        System.out.println(part.getEmployeeInfo());
        System.out.println("Salary = " + part.calculateSalary());
        System.out.println("-------------");
        System.out.println("Intern:");
        System.out.println(intern.getEmployeeInfo());
        System.out.println("Salary = " + intern.calculateSalary());
    }
}


// Abstract class Employee
abstract class Employee {
    private String name;
    private int employeeId;

    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }


    public abstract double calculateSalary();


    public String getEmployeeInfo() {
        return "Name: " + name + ", Employee ID: " + employeeId;
    }
}


class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int employeeId, double monthlySalary) {
        super(name, employeeId);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary; // Full-time employee's salary is just the monthly salary
    }
}


class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, int employeeId, double hourlyRate, int hoursWorked) {
        super(name, employeeId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked; // Part-time employee's salary is hourly rate * hours worked
    }
}


class Intern extends Employee {
    private double stipend;

    public Intern(String name, int employeeId, double stipend) {
        super(name, employeeId);
        this.stipend = stipend;
    }

    @Override
    public double calculateSalary() {
        return stipend; // Intern's salary is the stipend
    }
}

