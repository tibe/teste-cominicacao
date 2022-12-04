package br.com.testecominicacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TesteCominicacaoApplication {

	@LoadBalanced
	public static void main(String[] args) {
		SpringApplication.run(TesteCominicacaoApplication.class, args);
	}

}
