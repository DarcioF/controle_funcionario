package industria.presentasion;

import industria.service.PercentageEmployeeService;

import java.math.BigDecimal;
import java.util.Scanner;

public class PageUpMoneyEmployee {

    public void viewEmployeePercetage() {
        Scanner leitor = new Scanner(System.in);
        boolean option = true;
        while (option) {
            System.out.println("<------ Aumento de Sálario Funcionários ------>");
            System.out.println("(1) - Aumentar por % ");
            System.out.println("(2) - Aumentar 10%");
            System.out.println("(0) - Voltar");
            switch (leitor.nextInt()) {
                case 1:
                    printPercentage();
                    break;
                case 2:
                    printPercentageTen();
                    break;
                case 0:
                    option = false;
                    break;
                default:
                    System.out.println("<< Opção inválida! >>");
            }
        }
    }

    private void printPercentageTen() {
        System.out.println("Iniciando o Processo!\n");
        new PercentageEmployeeService().applyPercentageTen();
    }

    private void printPercentage() {

        System.out.println("--------- Digite o valor da porcentagem --------!\n");
        BigDecimal percentage = new BigDecimal(new Scanner(System.in).next());
        new PercentageEmployeeService().applyPercentage(percentage);
    }
}
