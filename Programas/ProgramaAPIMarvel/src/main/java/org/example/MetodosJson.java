package org.example;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class MetodosJson {

    public static Object leerArrayObjetoJSON(Path rutaFichero){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(rutaFichero.toFile(), new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
