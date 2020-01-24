package br.com.fiap.cervejaria.Controller;

import java.math.BigDecimal;

public class PrecoCervejaDTO {

    public Integer id;

    public BigDecimal preco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
