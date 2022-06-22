import java.util.Objects;
public class Main {
    public static void main (String[] args) {
        EmployeeList employee = new EmployeeList();
        employee.addEmployee("Иванов", "Иван", "Иванович", 1, 25_000);
        employee.addEmployee("Сергеев", "Сергей", "Сергеевич", 1, 27_000);
        employee.addEmployee("Петров", "Петр", "Петрович", 1, 33_000);
        employee.addEmployee("Максимов", "Максим", "Максимович", 1, 43000);
        System.out.println("employee.getCurrentSize() = " + employee.getCurrentSize());
        employee.printAllEmployee();
        employee.removeEmployee(2);
        employee.printAllEmployee();
        employee.setSalary(3, 120_000);
        //employee.setGroup(3, 2);
        employee.getMinSalary();
        employee.getMaxSalary();
        employee.getMonthExpenses();
        //employee.removeEmployee(1);
        //employee.getEmployee(1);
        employee.getGroupList(1);
        //employee.printAllEmployee();
        employee.increaseSalary(30);
        employee.printAllEmployee();
        employee.getGroupMinSalary(1);
        employee.getGroupMaxSalary(1);
        employee.getGroupMonthExpenses(1);
        employee.getGroupAverageSalary(1);
        employee.getAllGroupEmployee(1);
        employee.getEmployeeSalaryLower(100_000);
        employee.getEmployeeSalaryHigher(100_000);




    }
}
