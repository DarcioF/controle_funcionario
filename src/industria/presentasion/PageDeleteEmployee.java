package industria.presentasion;

import industria.service.RemoveEmployeeService;

import java.util.Scanner;

public class PageDeleteEmployee {

    public void viewEmployeeRemove() {
        Scanner leitor = new Scanner(System.in);
        boolean option = true;
        while (option) {
            System.out.println("<------ Remover Funcionários ------>");
            System.out.println("(1) - Remover Funcionário");
            System.out.println("(2) - Remover todos os Funcionários");
            System.out.println("(0) - Voltar");
            switch (leitor.nextInt()) {
                case 1:
                    removeOnly();
                    break;
                case 2:
                    removeAll();
                    break;
                case 0:
                    option = false;
                    break;
                default:
                    System.out.println("<< Opção inválida! >>");
            }
        }
    }

    private void removeAll() {
        if (new RemoveEmployeeService().RemoverAllEmployee()) {
            System.out.println("<< Funcionários removidos com sucesso! >>");
        } else {
            System.out.println("<< Não foi possivel remover Funcionários! >>");
        }
    }

    private void removeOnly() {
        System.out.println("<------ Informe o nome do Funciónario para remover ------>");
        System.out.println("Nome: ");
        String nameFind = new Scanner(System.in).next();
        if (new RemoveEmployeeService().RemoverOnlyEmployee(nameFind)) {
            System.out.println("<< Funcionário removido com sucesso! >>");
        } else {
            System.out.println("<< Não foi possivel remover Funcionário! >>");
        }
    }

}
