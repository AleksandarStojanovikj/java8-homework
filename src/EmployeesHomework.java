import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeesHomework {
    public static void main(String[] args) {
        List<Employee> employeeList = GenerateEmployees.generateEmployees(30);

        System.out.println("1. Find a number of employees that live in Bitola and have salary > 800e.");
        System.out.println(
                employeeList.stream()
                        .filter(employee -> employee.getCity().equals("Bitola") && employee.getSalary() > 800)
                        .count()
        );

        System.out.println("\n2. Calculate the sum of the salaries of all employees who live in Skopje.");
        System.out.println(
                employeeList.stream()
                        .filter(employee -> employee.getCity().equals("Skopje"))
                        .mapToInt(Employee::getSalary)
                        .sum()
        );

        System.out.println("\n3. Show the employees sorted by salaries in ascending order.");
        employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("\n4. Find the employee who lives in Skopje and has the larger salary. (bonus question)");
        System.out.println(employeeList.stream()
                .filter(employee -> employee.getCity().equals("Skopje"))
                .max(Comparator.comparingInt(Employee::getSalary)).get()
        );

    }
}
