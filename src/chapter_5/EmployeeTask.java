package chapter_5;

public class EmployeeTask {
    public static void main(String[] args) {

    }
}
abstract class Employee{
    String name;
    int employeeId;

    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    abstract double calculateSalary();
    abstract void getEmployeeInfo();
}

class FullTimeEmployee extends Employee{
    double monthSalary;

    public FullTimeEmployee(String name, int employeeId, double monthSalary) {
        super(name, employeeId);
        this.monthSalary = monthSalary;
    }

    @Override
    double calculateSalary() {
        return monthSalary;
    }

    @Override
    void getEmployeeInfo() {
        System.out.println(super.name + super.employeeId);
    }
}

class PartTimeEmployee extends Employee{
    double hourlyRate;
    int hoursWorked;

    public PartTimeEmployee(String name, int employeeId, double hourlyRate, int hoursWorked) {
        super(name, employeeId);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    void getEmployeeInfo() {

    }
}
class Intern extends Employee {
    double stipend;

    public Intern(String name, int employeeId, double stipend) {
        super(name, employeeId);
        this.stipend = stipend;
    }

    @Override
    double calculateSalary() {
        return stipend;
    }

    @Override
    void getEmployeeInfo() {

    }
}