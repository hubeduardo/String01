package br.com.fiap.cervejaria;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

public class CreateCervejaDTO {

    private Integer Id;
    private String marca;
    private Double teorAlcoolico;
    private Tipo tipo;
    @Min(1)
    private BigDecimal preco;
    @Past
    private ZonedDateTime dataLancamento;

    public CreateCervejaDTO() {
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getTeorAlcoolico() {
        return teorAlcoolico;
    }

    public void setTeorAlcoolico(Double teorAlcoolico) {
        this.teorAlcoolico = teorAlcoolico;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public ZonedDateTime getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(ZonedDateTime dataLancamento) {
        this.dataLancamento = dataLancamento;
    }
}
