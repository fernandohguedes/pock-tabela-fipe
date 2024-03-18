package br.com.alura.tabelaFipe.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ConvertDados implements IConvertDados {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public <T> List<T> obterlista(String json, Class<T> classe) {
        CollectionType lista = mapper.getTypeFactory().constructCollectionType(List.class, classe);
        try {
            return mapper.readValue(json, lista);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
