import java.util.Objects;
public class Employee {
    private String firstName;
    private String middleName;
    private String lastName;
    private int group;
    private int salary;
    private int id;
    private static int employeeId = 1;

    public Employee(String lastName, String firstName, String middleName, int group, int salary) {
        this.id = employeeId++;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.group = group;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public int getGroup() {
        return group;
    }

    public int getSalary() {
        return salary;
    }

    public String getEmployeeName() {
        return lastName + " " + firstName + " " + middleName;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Имя сотрудника: " + lastName + " " + firstName + " " + middleName + ", персональный ID: " + id +
                ", " + "Заработная плата: " + salary;
    }
}

