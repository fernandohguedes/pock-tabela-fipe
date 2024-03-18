package br.com.alura.tabelaFipe.services;

import java.util.List;

public interface IConvertDados {

    <T> T obterDados(String json, Class<T> classe);

    <T> List<T> obterlista(String json, Class<T> classe);
}
