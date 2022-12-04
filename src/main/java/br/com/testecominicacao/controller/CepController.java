package br.com.testecominicacao.controller;

import br.com.testecominicacao.model.Cep;
import br.com.testecominicacao.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "cep")
public class CepController {


    @Autowired
    private CepService service;

    @GetMapping("/{cep}")
    public ResponseEntity getCep(@PathVariable String cep){
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.getCep(cep));
    }
}
