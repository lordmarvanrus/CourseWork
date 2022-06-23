import java.util.Objects;
public class EmployeeList {
    private final Employee[] employees;
    private int size;


    public EmployeeList() {
        this.employees = new Employee[5];
    }

    //базовая сложность
    public void getMinSalary() {
        System.out.println("Поиск сотрудника с минимальной зарплатой...");
        int minSalary = employees[0].getSalary();
        int minSalaryId = employees[0].getId();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                minSalaryId = employees[i].getId();
            }
        }
        printEmployee(minSalaryId);
    }

    public void getMaxSalary() {
        System.out.println("Поиск сотрудника с наибольшей зарплатой...");
        int maxSalary = 0;
        int maxSalaryId = employees[0].getId();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                maxSalaryId = employees[i].getId();
            }
        }
        printEmployee(maxSalaryId);
    }

    public double getMonthExpenses() {
        double expenses = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                expenses = expenses + employees[i].getSalary();
            }
        }
        return expenses;
    }

    public void getAverageSalary() {
        System.out.println("Средняя ЗП у сотрудников составляет: " + getMonthExpenses() / size);
    }

    // повышенная сложность
    public void increaseSalary(int percentage) {
        double increase;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                increase = (employees[i].getSalary() / 100d) * (100 + percentage);
                setSalary(employees[i].getId(), (int) increase);
            }
        }
        System.out.println("Зарплата всех сотрудников увеличена на " + percentage + "%");
    }

    public void getGroupMinSalary(int group) {
        System.out.println("Поиск сотрудника с минимальной зарплатой в " + group + " отделе...");
        int minSalary = 1_000_000;
        int minSalaryId = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getGroup() == group && employees[i].getSalary() < minSalary) {
                minSalary = employees[i].getSalary();
                minSalaryId = employees[i].getId();
            }
        }
        printEmployee(minSalaryId);
    }

    public void getGroupMaxSalary(int group) {
        System.out.println("Поиск сотрудника с наибольшей зарплатой в " + group + " отделе...");
        int maxSalary = 0;
        int maxSalaryId = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getGroup() == group && employees[i].getSalary() > maxSalary) {
                maxSalary = employees[i].getSalary();
                maxSalaryId = employees[i].getId();
            }
        }
        printEmployee(maxSalaryId);
    }

    public double getGroupMonthExpenses(int group) {
        double expenses = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getGroup() == group) {
                expenses = expenses + employees[i].getSalary();
            }
        }
        return expenses;
    }

    public void getGroupAverageSalary(int group) {
        int groupSize = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getGroup() == group) {
                groupSize++;
            }
        }
        System.out.println("Средняя ЗП у сотрудников " + group + " отдела составляет: " + getGroupMonthExpenses(group) / groupSize);
    }

    public void increaseGroupSalary(int group, int percentage) {
        double increase;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && (employees[i].getGroup() == group)) {
                increase = (employees[i].getSalary() / 100d) * (100 + percentage);
                setSalary(employees[i].getId(), (int) increase);
            }
        }
        System.out.println("Зарплата всех сотрудников в " + group + " отделе увеличена на " + percentage + "%");
    }

    public void getAllGroupEmployee(int group) {
        System.out.println("Список сотрудников " + group + " отдела:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getGroup() == group) {
                printEmployee(employees[i].getId());
            }
        }
    }

    public void getEmployeeSalaryLower(int salary) {
        System.out.println("Сотрудники, чья ЗП ниже чем " + salary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < salary) {
                printEmployee(employees[i].getId());
            }
        }
    }

    public void getEmployeeSalaryHigher(int salary) {
        System.out.println("Сотрудники, чья ЗП выше чем " + salary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > salary) {
                printEmployee(employees[i].getId());
            }
        }
    }

    // очень сложно
    public void addEmployee(String lastName, String firstName, String middleName, int group, int salary) {
        if (size >= employees.length) {
            System.out.println("Штат сотрудников полон");
        }
        Employee newEmployee = new Employee(lastName, firstName, middleName, group, salary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                System.out.println("Сотрудник успешно добавлен. Ему присвоен ID: " + employees[i].getId());
                size++;
                break;
            }
        }
    }

    public void removeEmployee(int employeeId) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && Objects.equals(employeeId, employees[i].getId())) {
                employees[i] = null;
            }
        }
        System.out.println("Сотрудник " + employeeId + " удален из базы");
        size--;
    }

    public void printAllEmployee() {
        for (int a = 1; a <= 5; a++) {
            System.out.println("Cписок сотрудников " + a + " отдела: ");
            getGroupList(a);
        }
    }

    private void printEmployee(int id) {
        if (employees[id] != null) {
            System.out.println(employees[id].toString());
        } else {
            System.out.println("Сотрудник с таким ID не найден");
        }
    }

    public void getGroupList(int group) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getGroup() == group) {
                printEmployee(i);
            }
        }
    }

    public int getCurrentSize() {
        return size;
    }

    public void setSalary(int employeeId, int salary) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (Objects.equals(employeeId, employees[i].getId())) {
                    this.employees[i].setSalary(salary);
                    System.out.println("Заработная плата сотрудника с ID " + employees[i].getId() +
                            " изменена на " + employees[i].getSalary());
                }
            }
        }
    }

    public void setGroup(int employeeId, int group) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (Objects.equals(employeeId, employees[i].getId())) {
                    this.employees[i].setGroup(group);
                    System.out.println("Сотрудник с ID " + employees[i].getId() +
                            " назначен в " + employees[i].getGroup() + " отдел");
                }
            }
        }
    }
}


