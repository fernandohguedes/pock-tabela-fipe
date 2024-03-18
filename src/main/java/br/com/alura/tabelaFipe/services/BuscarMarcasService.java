package br.com.alura.tabelaFipe.services;

import br.com.alura.tabelaFipe.models.Marca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuscarMarcasService {
    private ConsumoApi consumoApi = new ConsumoApi();
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";
    @Autowired
    private ConvertDados convertDados;

    public List<Marca> buscarMarcas(String tipoVeiculo) {
        String endereco = getEndereco(tipoVeiculo);

        var json = consumoApi.obterDados(endereco);
        var marcas = convertDados.obterlista(json, Marca.class);

        // Retornar as marcas ordenando pelo código
        return marcas.stream()
                .sorted(Comparator.comparing(Marca::getCodigo))
                .collect(Collectors.toList());
    }

    private String getEndereco(String tipoVeiculo) {
        var endereco = "";
        if (tipoVeiculo.toLowerCase().contains("carr")) {
            endereco = URL_BASE + "carros/marcas";

        } else if (tipoVeiculo.toLowerCase().contains("mot")) {
            endereco = URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhoes/marcas";
        }
        return endereco;
    }
}
