import java.util.ArrayList;
import java.util.Comparator;

abstract class Operations {
    protected ArrayList<Employee> employees = new ArrayList<>();

    public abstract void registerEmployee(String ID, String name, double grossSalary, String degree, String department, int GPA, String type);

    public abstract void removeEmployee(String ID);

    public abstract void updateGrossSalary(String ID, double newSalary);

    public abstract void updateName(String ID, String newName);

    public abstract int retrieveEmployee(String ID);

    public abstract void getTotalEmployees();

    public abstract void updateDegree(String ID, String newDegree);

    public abstract void updateDepartment(String ID, String newDepartment);

    public abstract void updateGPA(String ID, int newGPA);

    // adjust the gross salary based on type of employee
    public double adjustSalary(Employee employee) {
        double currentSalary = employee.getGrossSalary();
        String currentType = employee.getType();

        switch (currentType.toLowerCase()) {
            case "manager":
            String currentDegree = employee.getDegree();
                switch (currentDegree.toLowerCase()) {
                    case "bsc":
                        return (currentSalary * 1.1);
                    
                    case "msc":
                        return (currentSalary * 1.2);
                    
                    case "phd":
                        return (currentSalary * 1.3);
                    default:
                        return currentSalary;
                } 
            case "director":
            currentDegree = employee.getDegree();
                switch (currentDegree.toLowerCase()) {
                    case "bsc":
                        return (currentSalary * 1.1 + 5000);
                    
                    case "msc":
                        return (currentSalary * 1.2 + 5000);
                    
                    case "phd":
                        return (currentSalary * 1.3 + 5000);
                    default:
                        return currentSalary;
                }
            default:
                return currentSalary;
                
        }   

    }

    // returns string that displays the employee's details, different formats for different types
    public void getEmployeeString(Employee employee) {
        String currentID = employee.getID();
        String currentName = employee.getName();
        double currentSalary = employee.getAdjustedSalary();
        String currentType = employee.getType();

        
        switch (currentType.toLowerCase()) {
            case "manager":
            String currentDegree = employee.getDegree();
            System.out.println(currentDegree + " " + currentName + "'s gross salary is" + currentSalary + " SEK per month.");
            break;

            case "director":
            currentDegree = employee.getDegree();
            String currentDepartment = employee.getDepartment();
            System.out.println(currentDegree + " " + currentName + "'s gross salary is" + currentSalary + " SEK per month. Dept: " + currentDepartment);               
            break;

            case "intern":
            String currentGPA = employee.getGPA();
            System.out.println(currentName + "'s gross salary is" + currentSalary + " SEK per month. GPA: " + currentGPA);               
            break;

            default:                    
            System.out.println(currentName + "'s gross salary is" + currentSalary + " SEK per month.");

        } 
    }

    public double netSalary(Employee employee) {
        double currentSalary = employee.getAdjustedSalary();
        String currentType = employee.getType();

        if (currentType.equalsIgnoreCase("director") && currentSalary >= 30000 && currentSalary <= 50000) {
            return (currentSalary * 0.9);
        }

        else if (currentType.equalsIgnoreCase("director") && currentSalary > 50000) {
            return ((currentSalary - 30000) * 0.6 + 30000 * 0.8);
        }

        else {
            return (currentSalary * 0.9);
        }
                
        }
    

}

class Employee extends Operations {
    String ID;
    String name;
    double grossSalary;
    String degree;
    String department;
    int GPA;
    String type;
    double adjustedSalary;
    double netSalary;

    public String getID() {
        return ID;
    }
    public String getName() {
        return name;
    }
    public double getGrossSalary() {
        return grossSalary;
    }
    public String getDegree() {
        return degree;
    }
    public String getDepartment() {
        return department;
    }
    public int getGPA() {
        return GPA;
    }
    public String getType() {
        return type;
    }
    public double getAdjustedSalary() {
        return adjustedSalary;
    }
    public double getNetSalary() {
        return netSalary;
    }


    public void setName(String newName) {
        name = newName;
    }
    public void setGrossSalary(double newSalary) {
        grossSalary = newSalary;
    }
    public void setDegree(String newDegree) {
        degree = newDegree;
    }
    public void setDepartment(String newDepartment) {
        department = newDepartment;
    }
    public void setGPA(int newGPA) {
        GPA = newGPA;
    }
    public void setType(String newType) {
        type = newType;
    }
    public void setAdjustedSalary(double newAdjustedSalary) {
        adjustedSalary = newAdjustedSalary;
    }
    public void setNetSalary(double newNetSalary) {
        netSalary = newNetSalary;
    }
    
}

class Regular extends Employee {
    public Regular(String ID, String name, double grossSalary, String type, double adjustedSalary, double netSalary) {
        this.ID = ID;
        this.name = name;
        this.grossSalary = grossSalary;
        this.type = type;
        this.adjustedSalary = adjustedSalary;
        this.netSalary = netSalary;
    }
}

class Manager extends Employee {
    public Manager(String ID, String name, double grossSalary, String degree, String type, double adjustedSalary, double netSalary) {
        this.ID = ID;
        this.name = name;
        this.grossSalary = grossSalary;
        this.degree = degree;
        this.type = type;
        this.adjustedSalary = adjustedSalary;
        this.netSalary = netSalary;
    }

}

class Director extends Employee {
    public Director(String ID, String name, double grossSalary, String degree, string department, String type, double adjustedSalary, double netSalary) {
        this.ID = ID;
        this.name = name;
        this.grossSalary = grossSalary;
        this.degree = degree;
        this.department = department;
        this.type = type;
        this.adjustedSalary = adjustedSalary;
        this.netSalary = netSalary;
    }

}

class Intern extends Employee {
    public Intern(String ID, String name, double grossSalary, int GPA, String type, double adjustedSalary, double netSalary) {
            this.ID = ID;
            this.name = name;
            this.grossSalary = grossSalary;
            this.GPA = GPA;
            this.type = type;
            this.adjustedSalary = adjustedSalary;
            this.netSalary = netSalary;
        }
    
}

class EmployeeFactory {
    public static Employee createEmployee(String ID, String name, double grossSalary, String degree, String department, int GPA, String type, double adjustedSalary, double netSalary) {
        switch (type.toLowerCase()) {
            case "manager":
                return new Manager(ID, name, grossSalary, degree, type, adjustedSalary, netSalary);
            case "director":
                return new Director(ID, name, grossSalary, degree, department, type, adjustedSalary, netSalary);
            case "intern":
                return new Intern(ID, name, grossSalary, GPA, type, adjustedSalary, netSalary);
            case "regular":
                return new Regular(ID, name, grossSalary, type, adjustedSalary, netSalary);
            default:
                throw new IllegalArgumentException("Invalid employee type: " + type);
        }
    }
}


public class Company extends Operations{

    protected ArrayList<String> IDs = new ArrayList<String>();

    @Override
    public void registerEmployee(String ID, String name, double grossSalary, String degree, String department, int GPA, String type) {

        if (IDs.contains(ID)) {
            System.out.println("Cannot register. ID " + ID + " is already taken.");
        }
        else {       
            Employee employee = EmployeeFactory.createEmployee(ID, name, grossSalary, degree, department, GPA, type, 0, 0);

            double adjustedSalary = adjustSalary(employee);
            employee.setAdjustedSalary(adjustedSalary);

            double netSalary = netSalary(employee);
            employee.setNetSalary(netSalary);

            employees.add(employee);
            System.out.println("Employee " + ID + " was registered successfully.");

        }
    }

    @Override
    public int retrieveEmployee(String ID) {
        for (int i = 0; i < employees.size(); i++) {
            Employee currentEmployee = employees.get(i);
            String currentID = currentEmployee.getID();

            if(currentID.equals(ID)) {
                return i;
            }
        }

        System.out.println("Employee " + ID + " was not registered yet.");
        return -1;
    }

    @Override
    public void removeEmployee(String ID) {
        int employeeIndex = retrieveEmployee(ID);

        if (employeeIndex == -1) {
            System.out.println("\n");
        }

        else {
            employees.remove(employeeIndex);
        }
        
    }

    @Override
    public void updateName(String ID, String newName) {
        int employeeIndex = retrieveEmployee(ID);

        if (employeeIndex == -1) {
            System.out.println("\n");
        }

        else {
            Employee updatedEmployee = employees.get(employeeIndex);
            updatedEmployee.setName(newName);
            employees.set(employeeIndex, updatedEmployee);
        }
        
    }

    @Override
    public void updateGrossSalary(String ID, double newSalary) {
        int employeeIndex = retrieveEmployee(ID);

        if (employeeIndex == -1) {
            System.out.println("\n");
        }

        else {
            Employee updatedEmployee = employees.get(employeeIndex);
            double updatedAdjustedSalary = adjustSalary(updatedEmployee);
            updatedEmployee.setGrossSalary(newSalary);
            updatedEmployee.setAdjustedSalary(updatedAdjustedSalary);
            employees.set(employeeIndex, updatedEmployee);
        }
        
    }

    @Override
    public void updateDegree(String ID, String newDegree) {
        int employeeIndex = retrieveEmployee(ID);

        if (employeeIndex == -1) {
            System.out.println("\n");
        }

        else {
            Employee updatedEmployee = employees.get(employeeIndex);
            String employeeType = updatedEmployee.getType();

            if (employeeType.equalsIgnoreCase("manager") || employeeType.equalsIgnoreCase("director")) {
                updatedEmployee.setDegree(newDegree);
                double updatedAdjustedSalary = adjustSalary(updatedEmployee);
                updatedEmployee.setAdjustedSalary(updatedAdjustedSalary);
                employees.set(employeeIndex, updatedEmployee);
                
            }

            else {
                System.out.println("Error: Employee ID must belong to either a manager or a director.");
            }
            
        }
    }

    @Override
    public void updateDepartment(String ID, String newDepartment) {
        int employeeIndex = retrieveEmployee(ID);

        if (employeeIndex == -1) {
            System.out.println("\n");
        }

        else {
            Employee updatedEmployee = employees.get(employeeIndex);
            String employeeType = updatedEmployee.getType();

            if (employeeType.equalsIgnoreCase("director")) {
                updatedEmployee.setDepartment(newDepartment);
                double updatedAdjustedSalary = adjustSalary(updatedEmployee);
                updatedEmployee.setAdjustedSalary(updatedAdjustedSalary);
                employees.set(employeeIndex, updatedEmployee);
                
            }

            else {
                System.out.println("Error: Employee ID must belong to a director.");
            }
            
        }
    }

    @Override
    public void updateGPA(String ID, int newGPA) {
        int employeeIndex = retrieveEmployee(ID);

        if (employeeIndex == -1) {
            System.out.println("\n");
        }

        else {
            Employee updatedEmployee = employees.get(employeeIndex);
            String employeeType = updatedEmployee.getType();

            if (employeeType.equalsIgnoreCase("intern")) {
                updatedEmployee.setGPA(newGPA);
                double updatedAdjustedSalary = adjustSalary(updatedEmployee);
                updatedEmployee.setAdjustedSalary(updatedAdjustedSalary);
                employees.set(employeeIndex, updatedEmployee);
                
            }

            else {
                System.out.println("Error: Employee ID must belong to an intern.");
            }
            
        }
    }

    public void displayAllEmployees() {
        System.out.println("All registered employees:");

        for (Employee employee : employees) {
            getEmployeeString(employee);

        }
    }

    public void sortGrossSalaries() {
        System.out.println("Employees sorted by gross salary (ascending order):");
        employees.sort(Comparator.comparing(Employee::getAdjustedSalary));

        for (Employee employee:employees) {
            getEmployeeString(employee);
        }
    }

    public void sortDegrees() {
        System.out.println("Academic background of employees:");

        int numberBSc = 0;
        int numberMSc = 0;
        int numberPhD = 0;

        for (Employee employee:employees) {
            String currentDegree = employee.getDegree();

            switch (currentDegree){
                case "BSc":
                numberBSc++;
                break;

                case "MSc":
                numberMSc++;
                break;

                case "PhD":
                numberPhD++;
                break;

                default:
                break;

            }

        }

        System.out.println("BSc: => " + numberBSc);
        System.out.println("MSc: => " + numberMSc);
        System.out.println("PhD: => " + numberPhD);
       
    }

    public void getTotalExpenses() {
        double grossTotal = 0;
        double netTotal = 0;

        for (Employee employee:employees) {
            double currentGross = employee.getAdjustedSalary();
            double currentNet = employee.getNetSalary();

            grossTotal = grossTotal + currentGross;
            netTotal = netTotal + currentNet;
        }

        System.out.println("Total amount of gross salaries paid: " + grossTotal);
        System.out.println("Total amount of net salaries paid: " + netTotal);
    }

    public static void main(String[] args) {
        Company company = new Company();

        company.registerEmployee("E001", "Alice", 5000, "BSc", null, 0, "manager");
        company.registerEmployee("E002", "Bob", 4000, null, null, 3, "intern");
        company.registerEmployee("E003", "Charlie", 7000, "PhD", "HR", 0, "director");

        company.displayAllEmployees();
        company.sortGrossSalaries();
        company.sortDegrees();
        company.getTotalExpenses();
    }
}
