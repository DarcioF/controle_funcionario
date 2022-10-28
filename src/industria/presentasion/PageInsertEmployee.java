package industria.presentasion;

import industria.model.Employee;
import industria.service.InsertEmployeeService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PageInsertEmployee {
    public void viewEmployeeInsert() {
        Scanner leitor = new Scanner(System.in);
        boolean option = true;
        while (option) {
            System.out.println("<------ Inserir Funcionários ------>");
            System.out.println("(1) - Inserir Funcionário");
            System.out.println("(2) - Inserir Funcionários Padrões");
            System.out.println("(0) - Voltar");
            switch (leitor.nextInt()) {
                case 1:
                    getInserteOnly();
                    break;
                case 2:
                    getInserteAll();
                    break;
                case 0:
                    option = false;
                    break;
                default:
                    System.out.println("<< Opção inválida! >>");
            }
        }
    }

    private void getInserteAll() {
        new InsertEmployeeService().insertAllEmployee();
        System.out.println("<< Funcionários padrões adiconado com sucesso! >>");
    }

    private void getInserteOnly() {
        System.out.println("<------ Informe os Dados a seguir ------>");
        Employee employee = new Employee();
        System.out.println("Nome: ");
        employee.setNome(new Scanner(System.in).next());
        System.out.println("Data Nascimento (dd/mm/aaaa): ");
        employee.setData_nascimento(LocalDate.parse(new Scanner(System.in).next(),
                DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Salário: ");
        employee.setSalario(new BigDecimal(new Scanner(System.in).next()));
        System.out.println("Função: ");
        employee.setFuncao(new Scanner(System.in).next());
        new InsertEmployeeService().insertOnlyEmployee(employee);
        System.out.println("<< Funcionário " + employee.getNome() + " cadastrado com sucesso! >>");
    }
}
