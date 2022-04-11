package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.modelo.Performance;

import java.math.BigDecimal;

public class ReajusteService {
    public void bestowAdjustment(Funcionario funcionario, Performance performance) {
        BigDecimal percent = performance.adjustPercent();
        BigDecimal adjustment = funcionario.getSalario().multiply(percent);
        funcionario.adjustSalary(adjustment);
    }
}
