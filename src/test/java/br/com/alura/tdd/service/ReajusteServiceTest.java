package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import br.com.alura.tdd.modelo.Performance;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach //Before each method it calls this method
    public void initialize(){
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @AfterEach //After each method it calls this method
    public void finish(){
        System.out.println("End");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before All");
    }

    @AfterAll
    public static void afterAll(){
        System.out.println("After All");
    }


    @Test
    public void adjustmentShouldBeThreePercentWhenPerformanceIsNotAsExpected(){
        service.bestowAdjustment(funcionario, Performance.NOT_AS_EXPECTED);
        Assertions.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void adjustmentShouldBeFifteenPercentWhenPerformanceIsGood(){
        service.bestowAdjustment(funcionario, Performance.GOOD);
        Assertions.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void adjustmentShouldBeTwentyPercentWhenPerformanceIsGreat(){
        service.bestowAdjustment(funcionario, Performance.GREAT);
        Assertions.assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
