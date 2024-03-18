package br.com.alura.tabelaFipe.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
public class TipoVeiculo {

    private Integer codigo;
    private String tipoVeiculo;

    public static final List<TipoVeiculo> tiposVeiculo(){
        var carros = new TipoVeiculo(1, "carros");
        var motos = new TipoVeiculo(2, "motos");
        var caminhoes = new TipoVeiculo(3, "caminhoes");
        return Arrays.asList(carros, motos, caminhoes);
    }
}
