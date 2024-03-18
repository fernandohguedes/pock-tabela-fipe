package br.com.alura.tabelaFipe.controllers;

import br.com.alura.tabelaFipe.models.TipoVeiculo;
import br.com.alura.tabelaFipe.services.BuscarMarcasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tabela-fipe")
public class TabelaFipeController {

    @Autowired
    private BuscarMarcasService buscarMarcasService;

    @GetMapping("/tipos")
    public ResponseEntity buscarTipos() {
        var tipos = TipoVeiculo.tiposVeiculo();
        return ResponseEntity.ok(tipos);
    }

    @GetMapping("/{tipoVeiculo}/marcas")
    public ResponseEntity buscarMarcas(@PathVariable String tipoVeiculo) {
        var marcas = buscarMarcasService.buscarMarcas(tipoVeiculo);
        return ResponseEntity.ok(marcas);
    }

}
