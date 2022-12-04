package br.com.testecominicacao.consumer;

import br.com.testecominicacao.model.Cep;
import feign.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(url = "https://viacep.com.br/ws/", name = "cep")
public interface CepConsumer {
    @GetMapping( value = "{cep}/json/")
    Response getCep(@PathVariable String cep);
}
