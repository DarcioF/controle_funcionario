package industria.service;

import industria.data.EmployeePattern;
import industria.endpoint.DataEmployee;
import industria.model.Employee;

import java.util.ArrayList;

public class InsertEmployeeService {

    public void insertAllEmployee() {
        if (DataEmployee.employeesList == null) {
            DataEmployee.employeesList = new ArrayList<>();
        }
        DataEmployee.employeesList.addAll(new EmployeePattern().getAllEmployee());
    }

    public void insertOnlyEmployee(Employee employee) {
        if (employee != null) {
            DataEmployee.employeesList.add(employee);
        }
    }
}
