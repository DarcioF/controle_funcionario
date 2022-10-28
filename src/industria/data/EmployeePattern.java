package industria.data;

import industria.model.Employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class EmployeePattern {

    public List<Employee> getAllEmployee() {
        return Arrays.asList(
                new Employee("Maria".toUpperCase(), LocalDate.parse("2000-10-18"), BigDecimal.valueOf(2009.44), "Operador"),
                new Employee("João".toUpperCase(), LocalDate.parse("1990-05-12"), BigDecimal.valueOf(2284.38), "Operador"),
                new Employee("Caio".toUpperCase(), LocalDate.parse("1961-05-02"), BigDecimal.valueOf(9836.14), "Coordenador"),
                new Employee("Miguel".toUpperCase(), LocalDate.parse("1988-10-14"), BigDecimal.valueOf(19119.88), "Diretor"),
                new Employee("Alice".toUpperCase(), LocalDate.parse("1995-01-05"), BigDecimal.valueOf(2234.68), "Recepcionista"),
                new Employee("Heitor".toUpperCase(), LocalDate.parse("1999-11-10"), BigDecimal.valueOf(1582.72), "Operador"),
                new Employee("Arthur".toUpperCase(), LocalDate.parse("1999-03-31"), BigDecimal.valueOf(4071.84), "Contador"),
                new Employee("Laura".toUpperCase(), LocalDate.parse("1994-07-08"), BigDecimal.valueOf(3017.45), "Gerente"),
                new Employee("Heloísa".toUpperCase(), LocalDate.parse("2003-05-24"), BigDecimal.valueOf(1606.85), "Eletricista"),
                new Employee("Helena".toUpperCase(), LocalDate.parse("1996-09-02"), BigDecimal.valueOf(2799.93), "Gerente")
        );
    }
}
