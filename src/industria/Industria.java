/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package industria;

import industria.presentasion.PageDeleteEmployee;
import industria.presentasion.PageInsertEmployee;
import industria.presentasion.PagePrintEmployee;
import industria.presentasion.PageUpMoneyEmployee;

import java.util.Scanner;

/**
 * @author DarcioDev
 */
public class Industria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        boolean option = true;
        while (option) {
            System.out.println("<---------- Controle de Funcionário --------->");
            System.out.println("(1) - Cadastrar");
            System.out.println("(2) - Remover");
            System.out.println("(3) - Ajustar Aumento");
            System.out.println("(4) - Imprimir");
            System.out.println("(0) - Sair");
            switch (leitor.nextInt()) {
                case 1:
                    new PageInsertEmployee().viewEmployeeInsert();
                    break;
                case 2:
                    new PageDeleteEmployee().viewEmployeeRemove();
                    break;
                case 3:
                    new PageUpMoneyEmployee().viewEmployeePercetage();
                    break;
                case 4:
                    new PagePrintEmployee().viewEmployeePrint();
                    break;
                case 0:
                    option = false;
                    break;
                default:
                    System.out.println("<< Opção inválida! >>");
            }
        }
    }

}
