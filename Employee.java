public class Employee {
    String ID;
    String name;
    Double grossSalary;
    Double netSalary;

    private void CalculateNetSalary() {
        netSalary = grossSalary - (grossSalary * 0.1);
    }
}

class Manager extends Employee {

}

class Director extends Employee {

}

class Intern extends Employee {

}