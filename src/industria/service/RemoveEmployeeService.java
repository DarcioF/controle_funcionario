package industria.service;

import industria.endpoint.DataEmployee;
import industria.model.Employee;

import java.util.ArrayList;

public class RemoveEmployeeService {
    public boolean RemoverAllEmployee() {
        if (DataEmployee.employeesList == null || DataEmployee.employeesList.isEmpty()) {
            System.out.println("Nenhum funcionários encontrados!");
            return false;
        }
        DataEmployee.employeesList = new ArrayList<>();
        return true;
    }

    public boolean RemoverOnlyEmployee(String name) {
        if (name == null || DataEmployee.employeesList == null) {
            return false;
        }
        Employee employeeFind = DataEmployee.employeesList.stream()
                .filter(e -> e.getNome().equals(name)).findFirst().orElse(null);
        if (employeeFind != null) {
            DataEmployee.employeesList.remove(employeeFind);
            return true;
        } else {
            System.out.println("Funciónario não encontrado!");
            return false;
        }

    }
}
