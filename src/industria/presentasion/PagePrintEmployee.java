package industria.presentasion;

import industria.endpoint.DataEmployee;
import industria.model.Employee;
import industria.model.Person;
import industria.service.PrintEmployeeService;
import industria.util.Utilidades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class PagePrintEmployee {
    public void viewEmployeePrint() {
        Scanner leitor = new Scanner(System.in);
        boolean option = true;
        while (option) {
            System.out.println("<------ Imprimir Funcionários ------>");
            System.out.println("(1) - Todos os Funcionários ");
            System.out.println("(2) - Funcionários que fazem aniversário no mês 10 e 12");
            System.out.println("(3) - Funcionários ordem alfabética ");
            System.out.println("(4) - Total dos salários dos funcionários ");
            System.out.println("(5) - Funcionário com a maior idade ");
            System.out.println("(6) - Quantos salários mínimos ganha cada funcionário");
            System.out.println("(7) - Agrupados por função");
            System.out.println("(0) - Voltar");
            switch (leitor.nextInt()) {
                case 1:
                    printAllEmployee();
                    break;
                case 2:
                    printFindAniversario();
                    break;
                case 3:
                    printFindOrder();
                    break;
                case 4:
                    printSumEmployee();
                    break;
                case 5:
                    printYearEmployee();
                    break;
                case 6:
                    printMinMoneyEmployee();
                    break;
                case 7:
                    printGroupedEmployee();
                    break;
                case 0:
                    option = false;
                    break;
                default:
                    System.out.println("<< Opção inválida! >>");
            }
        }
    }

    private void printGroupedEmployee() {
        if (DataEmployee.employeesList != null && !DataEmployee.employeesList.isEmpty()) {
            Formatter fmt = new Formatter();
            Map<String, List<Employee>> occupationMap = new PrintEmployeeService()
                    .getGrouped(DataEmployee.employeesList);
            for (String occupation : occupationMap.keySet()) {
                fmt.format("\n<----- %5s ----->\n", occupation);
                fmt.format("%17s %20s %15s \n", "Nome", "Data Nascimento", "Salário");
                for (Employee employee : occupationMap.get(occupation)) {
                    fmt.format("%17s %20s %15s \n",
                            employee.getNome(),
                            Utilidades.setFormatterDate(employee.getData_nascimento()),
                            Utilidades.setFormatterNumber(employee.getSalario())
                    );
                }
            }
            System.out.println(fmt);
        } else {
            System.out.println("<<Nenhum funcioário encontrado!>>");
        }

    }

    private void printMinMoneyEmployee() {
        if (DataEmployee.employeesList != null && !DataEmployee.employeesList.isEmpty()) {
            System.out.println("\n<<Salários mínimo por Funcionário>>");
            Formatter fmt = new Formatter();
            fmt.format("%17s %20s %20s \n", "Nome", "Salário", "Qtd. Salário mínimo");
            for (Employee employee : DataEmployee.employeesList) {
                BigDecimal minimo = employee.getSalario().divide(DataEmployee.wageMoney, RoundingMode.HALF_DOWN);
                fmt.format("%17s %20s %20s \n",
                        employee.getNome(),
                        Utilidades.setFormatterNumber(employee.getSalario()),
                        Utilidades.setFormatterNumber(minimo));
            }
            System.out.println(fmt);
        } else {
            System.out.println("<<Nenhum funcioário encontrado!>>");
        }

    }

    private void printYearEmployee() {
        if (DataEmployee.employeesList != null && !DataEmployee.employeesList.isEmpty()) {
            Employee findYear =
                    DataEmployee.employeesList.stream().min(Comparator.comparing(Person::getData_nascimento))
                            .orElse(null);
            if (findYear != null) {
                Integer yearOld = LocalDate.now().getYear() - findYear.getData_nascimento().getYear();
                System.out.println("\n<<Funcionário com a maior idade>>");
                System.out.println("----------------------------------");
                System.out.println(findYear.getNome() + " com " + yearOld + " anos de idade");
                System.out.println("----------------------------------\n");
            }
        } else {
            System.out.println("<<Nenhum funcioário encontrado!>>");
        }

    }

    private void printSumEmployee() {
        if (DataEmployee.employeesList != null && !DataEmployee.employeesList.isEmpty()) {
            Formatter fmt = new Formatter();
            fmt.format("%17s %20s \n", "Nome", "Salário");
            for (int i = 0; i < DataEmployee.employeesList.size(); i++) {
                fmt.format("%17s %20s\n",
                        DataEmployee.employeesList.get(i).getNome(),
                        Utilidades.setFormatterNumber(DataEmployee.employeesList.get(i).getSalario()));
            }
            System.out.println(fmt);
            Double totalSalario = DataEmployee.employeesList.stream()
                    .mapToDouble(i -> i.getSalario().doubleValue()).sum();
            System.out.println("\t\t-----------------------------");
            System.out.println("\t\tTotal de Salários: " + Utilidades.setFormatterNumber(totalSalario));
            System.out.println("\t\t-----------------------------\n");
        } else {
            System.out.println("<<Nenhum funcioário encontrado!>>");
        }
    }

    private void printFindOrder() {
        if (DataEmployee.employeesList != null && !DataEmployee.employeesList.isEmpty()) {
            Formatter fmt = new Formatter();
            List<Employee> findOrder =
                    DataEmployee.employeesList.stream()
                            .sorted(Comparator.comparing(Person::getNome))
                            .collect(Collectors.toList());
            fmt.format("%17s %20s %15s %15s\n", "Nome", "Data Nascimento", "Salário", "Função");
            for (int i = 0; i < findOrder.size(); i++) {
                fmt.format("%17s %20s %15s %15s\n",
                        findOrder.get(i).getNome(),
                        Utilidades.setFormatterDate(findOrder.get(i).getData_nascimento()),
                        Utilidades.setFormatterNumber(findOrder.get(i).getSalario()),
                        findOrder.get(i).getFuncao());
            }
            System.out.println(fmt);
        } else {
            System.out.println("<<Nenhum funcioário encontrado!>>");
        }

    }

    private void printFindAniversario() {
        if (DataEmployee.employeesList != null && !DataEmployee.employeesList.isEmpty()) {
            Formatter fmt = new Formatter();
            List<Employee> findOnlybirthday =
                    DataEmployee.employeesList.stream().filter(e -> {
                                int month = e.getData_nascimento().getMonth().getValue();
                                return month == 10 || month == 12;
                            })
                            .collect(Collectors.toList());
            fmt.format("%17s %20s %15s %15s\n", "Nome", "Data Nascimento", "Salário", "Função");
            for (int i = 0; i < findOnlybirthday.size(); i++) {
                fmt.format("%17s %20s %15s %15s\n",
                        findOnlybirthday.get(i).getNome(),
                        Utilidades.setFormatterDate(findOnlybirthday.get(i).getData_nascimento()),
                        Utilidades.setFormatterNumber(findOnlybirthday.get(i).getSalario()),
                        findOnlybirthday.get(i).getFuncao());
            }
            System.out.println(fmt);
        } else {
            System.out.println("<<Nenhum funcioário encontrado!>>");
        }

    }

    private void printAllEmployee() {
        if(DataEmployee.employeesList != null && !DataEmployee.employeesList.isEmpty()){
            Formatter fmt = new Formatter();
            fmt.format("%17s %20s %15s %15s\n", "Nome", "Data Nascimento", "Salário", "Função");
            for (int i = 0; i < DataEmployee.employeesList.size(); i++) {
                fmt.format("%17s %20s %15s %15s\n",
                        DataEmployee.employeesList.get(i).getNome(),
                        Utilidades.setFormatterDate(DataEmployee.employeesList.get(i).getData_nascimento()),
                        Utilidades.setFormatterNumber(DataEmployee.employeesList.get(i).getSalario()),
                        DataEmployee.employeesList.get(i).getFuncao());
            }
            System.out.println(fmt);
        }else{
            System.out.println("<<Nenhum funcioário encontrado!>>");
        }
    }

}
