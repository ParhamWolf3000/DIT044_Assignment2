import java.util.ArrayList;

abstract class Operations {
    protected ArrayList<Employee> employees = new ArrayList<>();

    public abstract void registerEmployee(Employee employee);

    public abstract void removeEmployee(String ID);

    public abstract void updateSalary(String ID, double newSalary);

    public abstract void updateName(String ID, String newName);

    public abstract Employee retrieveEmployee(String ID);

    public abstract void getTotalEmployees();

    public void displayAllEmployees() {
        System.out.println("All registered employees:");

        for (Employee employee : employees) {
            String currentID = employee.getID();
            String currentName = employee.getName();
            double currentSalary = employee.getGrossSalary();
            String currentType = employee.getType();
            String currentDegree = currentEmployee.getDegree();
            String currentDepartment = currentEmployee.getDepartment();
            String currentGPA = currentEmployee.getGPA();

            
            switch (currentType) {
                case "manager":
                System.out.println(currentDegree + " " + currentName + "'s gross salary is" + currentSalary + " SEK per month.");
                break;

                case "director":
                System.out.println(currentDegree + " " + currentName + "'s gross salary is" + currentSalary + " SEK per month. Dept: " + currentDepartment);               
                break;

                case "intern":
                System.out.println(currentName + "'s gross salary is" + currentSalary + " SEK per month. GPA: " + currentGPA);               
                break;

                default:                    
                System.out.println(currentName + "'s gross salary is" + currentSalary + " SEK per month.");

            } 

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

    public Employee(String ID, String name, double grossSalary, String degree, String department, int GPA, String type) {
        this.ID = ID;
        this.name = name;
        this.grossSalary = grossSalary;
        this.degree = degree;
        this.department = department;
        this.GPA = GPA;
        this.type = type;
        employees.add(this);
    }

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
    public int getType() {
        return type;
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

    
    
}

class Company extends Operations {

    public void registerEmployee(String ID, String name, double grossSalary) {
        new Employee(ID, name, grossSalary, null, null, null, null);
    }

    public Employee retrieveEmployee(String ID) {
        for (int i; i < employees.size(); i++) {
            Employee currentEmployee = employees.get(i);
            String currentID = currentEmployee.getID();

            if(currentID.equals(ID)) {
                return i;
            }
        }

        System.out.println("Employee " + ID + " was not registered yet.");
        return -1;
    }

    public void removeEmployee(String ID) {
        int employeeIndex = retrieveEmployee(ID);

        if (employeeIndex == -1) {
            System.out.println("\n");
        }

        else {
            employees.remove(employeeIndex);
        }
        
    }

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

    public void updateSalary(String ID, String newSalary) {
        int employeeIndex = retrieveEmployee(ID);

        if (employeeIndex == -1) {
            System.out.println("\n");
        }

        else {
            Employee updatedEmployee = employees.get(employeeIndex);
            updatedEmployee.setName(newSalary);
            employees.set(employeeIndex, updatedEmployee);
        }
        
    }

}

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
    }
}
