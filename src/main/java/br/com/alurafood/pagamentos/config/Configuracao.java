package br.com.alurafood.pagamentos.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Configuracao {


    //corrigindo erro de Bean do ModelMapper
    @Bean
    public ModelMapper obterModelMapper(){
        return new ModelMapper();
    }

}
