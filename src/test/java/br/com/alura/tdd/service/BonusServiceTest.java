package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusShouldBeZeroIfSalaryIsHigherThanOneThousand() {
        BonusService service = new BonusService();
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Diogo",
                        LocalDate.now(),
                        new BigDecimal("25000"))));
//       try {service.calcularBonus(new Funcionario("Diogo",
//                        LocalDate.now(),
//                        new BigDecimal("25000")));
//           fail("It did not appear the exception");
//       } catch (Exception e){
//            assertEquals("Worker with a salary higher than R$ 10.000,00 cannot get a bonus", e.getMessage());
//       }
    }

    @Test
    void bonusShouldBeTenPercentOfSalary() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(
                new Funcionario("Pedro",
                        LocalDate.now(),
                        new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusShouldBeOneThousand() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(
                new Funcionario("Paul",
                        LocalDate.now(),
                        new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}