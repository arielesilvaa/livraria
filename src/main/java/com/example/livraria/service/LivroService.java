package com.example.livraria.service;

import com.example.livraria.model.Livro;
import com.example.livraria.repository.LivroRepository;
import com.example.livraria.service.exception.EntityNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class LivroService {

    private LivroRepository repository;

    public Livro create(Livro obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Livro getId(Long id){
        Optional<Livro> obj = repository.findById(id);
        if (obj.isEmpty()){
            throw new EntityNotFound("Livro do id: " + id + " Não encontrado ");
        }
        return obj.get();
    }

    public List<Livro> getAll(){
        return repository.findAll();
    }

    public Livro update(Livro obj){
        Optional<Livro> newObj = repository.findById(obj.getId());

        if (newObj.isEmpty()){
            throw new EntityNotFound("Livro do id: " + obj.getId() + " Não encontrado ");
        }
        updateData(newObj.get(), obj);
        return repository.save(newObj.get());
    }
    private void updateData(Livro newObj, Livro obj) {

        newObj.setNome(obj.getNome());
    }
}
