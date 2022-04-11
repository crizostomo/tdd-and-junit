package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Performance {
    NOT_AS_EXPECTED {
        @Override
        public BigDecimal adjustPercent(){
            return new BigDecimal("0.03");
        }
    },
    GOOD {
        @Override
        public BigDecimal adjustPercent() {
            return new BigDecimal("0.15");
        }
    },
    GREAT {
        @Override
        public BigDecimal adjustPercent() {
            return new BigDecimal("0.2");
        }
    };

    public abstract BigDecimal adjustPercent();
}
