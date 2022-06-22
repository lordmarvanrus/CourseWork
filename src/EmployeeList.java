import java.util.Objects;
public class EmployeeList {
    private final Employee[] employees;
    private int size;
    private static int employeeId = 0;

    public EmployeeList() {
        this.employees = new Employee[20];
    }
    //базовая сложность
    public void getMinSalary () {
        System.out.println("Поиск сотрудника с минимальной зарплатой...");
        int minSalary = employees[0].getSalary();
        int minSalaryId = employees[0].getId();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() < minSalary) {
                    minSalary = employees[i].getSalary();
                    minSalaryId = employees[i].getId();
                }
            }
        }
        getEmployee(minSalaryId);
    }
    public void getMaxSalary () {
        System.out.println("Поиск сотрудника с наибольшей зарплатой...");
        int maxSalary = 0;
        int maxSalaryId = employees[0].getId();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() > maxSalary) {
                    maxSalary = employees[i].getSalary();
                    maxSalaryId = employees[i].getId();
                }
            }
        }
        getEmployee(maxSalaryId);
    }
    public void getMonthExpenses() {
        int expenses = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                expenses = expenses + employees[i].getSalary();
            }
        }
        System.out.println("Ежемесячные затраты на ЗП сотрудникам составляет: " + expenses);
    }
    public void getAverageSalary() {
        int averageSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                averageSalary = averageSalary + employees[i].getSalary();
            }
        }
        System.out.println("Средняя ЗП у сотрудников составляет: " + averageSalary/size);
    }
    // повышенная сложность
    public void increaseSalary (int percentage) {
        int increase;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                increase = (employees[i].getSalary()/100) * (100 + percentage);
                setSalary(employees[i].getId(), increase);
            }
        }
        System.out.println("Зарплата всех сотрудников увеличена на " + percentage + "%");
    }
    public void getGroupMinSalary (int group) {
        System.out.println("Поиск сотрудника с минимальной зарплатой в " + group + " отделе...");
        int minSalary = 1_000_000;
        int minSalaryId = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getGroup() == group) {
                    if (employees[i].getSalary() < minSalary) {
                        minSalary = employees[i].getSalary();
                        minSalaryId = employees[i].getId();
                    }
                }
            }
        }
        getEmployee(minSalaryId);
    }
    public void getGroupMaxSalary (int group) {
        System.out.println("Поиск сотрудника с наибольшей зарплатой в " + group + " отделе...");
        int maxSalary = 0;
        int maxSalaryId = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getGroup() == group) {
                    if (employees[i].getSalary() > maxSalary) {
                        maxSalary = employees[i].getSalary();
                        maxSalaryId = employees[i].getId();
                    }
                }
            }
        }
        getEmployee(maxSalaryId);
    }
    public void getGroupMonthExpenses(int group) {
        int expenses = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getGroup() == group) {
                    expenses = expenses + employees[i].getSalary();
                }
            }
        }
        System.out.println("Ежемесячные затраты на ЗП сотрудникам в " + group + " отделе составляет: " + expenses);
    }
    public void getGroupAverageSalary(int group) {
        int averageSalary = 0;
        int groupSize = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getGroup() == group) {
                    averageSalary = averageSalary + employees[i].getSalary();
                    groupSize++;
                }
            }
        }
        System.out.println("Средняя ЗП у сотрудников " + group + " отдела составляет: " + averageSalary/groupSize);
    }
    public void increaseGroupSalary (int group, int percentage) {
        int increase;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getGroup() == group) {
                    increase = (employees[i].getSalary() / 100) * (100 + percentage);
                    setSalary(employees[i].getId(), increase);
                }
            }
        }
        System.out.println("Зарплата всех сотрудников в " + group + " отделе увеличена на " + percentage + "%");
    }
    public void getAllGroupEmployee (int group) {
        System.out.println("Список сотрудников " + group + " отдела:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getGroup() == group) {
                    getEmployee(employees[i].getId());
                }
            }
        }
    }
    public void getEmployeeSalaryLower(int salary) {
        System.out.println("Сотрудники, чья ЗП ниже чем " + salary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() < salary) {
                    getEmployee(employees[i].getId());
                }
            }
        }
    }
    public void getEmployeeSalaryHigher(int salary) {
        System.out.println("Сотрудники, чья ЗП выше чем " + salary);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getSalary() > salary) {
                    getEmployee(employees[i].getId());
                }
            }
        }
    }

    // очень сложно
    public void addEmployee(String lastName, String firstName, String middleName, int group, int salary) {
        if (size >= employees.length) {
            System.out.println("Штат сотрудников полон");
        }
        Employee newEmployee = new Employee(lastName, firstName, middleName, group, salary, employeeId++);
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
                employees[employeeId] = null;
                System.out.println("Сотрудник " + employeeId + " удален из базы");
                size--;
            }
    public void printAllEmployee() {
        for (int a = 1; a <= 5; a++) {
        System.out.println("Cписок сотрудников "  + a +  " отдела: ");
            getGroupList(a);
            }
        }
    public void getEmployee(int employeeId) {
        if (employees[employeeId] != null) {
            System.out.println(employees[employeeId].toString());
        } else {
            System.out.println("Сотрудник с таким ID не найден");
        }
    }
    public void getGroupList(int group) {
        int id;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                if (employees[i].getGroup() == group) {
                    id = employees[i].getId();
                    getEmployee(id);
                }
            }
        }
    }
    public int getCurrentSize() {
        return size;
    }
    public void setSalary(int employeeId, int salary) {
            if (Objects.equals(employeeId, employees[employeeId].getId())) {
                this.employees[employeeId].setSalary(salary);
                System.out.println("Заработная плата сотрудника с ID " + employees[employeeId].getId() +
                        " изменена на " + employees[employeeId].getSalary());
            }
        }
    public void setGroup(int employeeId, int group) {
            if (Objects.equals(employeeId, employees[employeeId].getId())) {
                this.employees[employeeId].setGroup(group);
                System.out.println("Сотрудник с ID " + employees[employeeId].getId() +
                        " назначен в " + employees[employeeId].getGroup() + " отдел" );
            }
        }
    }


