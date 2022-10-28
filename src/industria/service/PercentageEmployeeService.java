package industria.service;

import industria.endpoint.DataEmployee;
import industria.model.Employee;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PercentageEmployeeService {

    public void applyPercentage(BigDecimal percentage) {
        if (DataEmployee.employeesList != null) {
            for (Employee employee : DataEmployee.employeesList) {
                BigDecimal valueApply = employee.getSalario().multiply(percentage);
                BigDecimal divideApply = valueApply.divide(BigDecimal.valueOf(100), RoundingMode.HALF_DOWN);
                employee.setSalario(employee.getSalario().add(divideApply));
            }
            System.out.println("Porcentagem " + percentage + "% aplicado com sucesso!");
        } else {
            System.out.println("Lista de funcionário vazio!");
        }
    }

    public void applyPercentageTen() {
        if (DataEmployee.employeesList != null) {
            for (Employee employee : DataEmployee.employeesList) {
                BigDecimal valueApply = employee.getSalario().multiply(BigDecimal.TEN);
                BigDecimal divideApply = valueApply.divide(BigDecimal.valueOf(100), RoundingMode.HALF_DOWN);
                employee.setSalario(employee.getSalario().add(divideApply));
            }
            System.out.println("Porcentagem 10% aplicado com sucesso!");
        } else {
            System.out.println("Lista de funcionário vazio!");
        }
    }
}
