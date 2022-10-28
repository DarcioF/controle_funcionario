package industria.service;

import industria.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrintEmployeeService {

    public Map<String, List<Employee>> getGrouped(List<Employee> employees) {
        Map<String, List<Employee>> grouped = new HashMap<>();
        List<String> occupations = employees.stream()
                .map(Employee::getFuncao)
                .collect(Collectors.toList());
        List<String> occupationsDistinct = occupations.stream().distinct().collect(Collectors.toList());
        for (String occupation : occupationsDistinct) {
            List<Employee> employeeTooccupation = new ArrayList<>();
            for (Employee employee : employees) {
                if (occupation.equals(employee.getFuncao())) {
                    employeeTooccupation.add(employee);
                }
            }
            grouped.put(occupation, employeeTooccupation);
        }
        return grouped;
    }
}
