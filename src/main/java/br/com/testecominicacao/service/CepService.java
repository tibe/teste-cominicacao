package br.com.testecominicacao.service;

import br.com.testecominicacao.consumer.CepConsumer;
import br.com.testecominicacao.model.Cep;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.http.HttpClient;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CepService {

    @Autowired
    private CepConsumer consumer;

    public Object getCep(String cep){
        try {
            Optional<Cep> cep2;

            Response response = consumer.getCep(cep);

            if(response.status() == HttpStatus.OK.value()){
                cep2 = getResponseBody(response, Cep.class);

                return cep2;
            }
        } catch (Exception e){


            e.printStackTrace();
             return null;
        }
        return null;
    }



    public static <T> Optional<T> getResponseBody(Response response, Class<T> klass) {
        try {
            String bodyJson = new BufferedReader(new InputStreamReader(response.body().asInputStream()))
                    .lines().parallel().collect(Collectors.joining("\n"));
            return Optional.ofNullable(new ObjectMapper().readValue(bodyJson, klass));
        } catch (IOException e) {
            log.error("Error when read feign response.", e);
            return Optional.empty();
        }
    }
}
