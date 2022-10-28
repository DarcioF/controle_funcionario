/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package industria.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author DarcioDev
 */
public class Employee extends Person {

    private BigDecimal salario;
    private String funcao;

    public Employee(String nome, LocalDate data_nascimento, BigDecimal salario, String funcao) {
        this.salario = salario;
        this.funcao = funcao;
        this.setNome(nome);
        this.setData_nascimento(data_nascimento);
    }

    public Employee() {
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

}
