package com.example.livraria.service.exception;

public class EntityNotFound extends RuntimeException {

    public EntityNotFound(String msg) {
        super(msg); //Chama o construtor da classe pai RuntimeException com a mensagem de erro
    }
}
