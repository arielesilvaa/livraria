package com.example.livraria.service;

import com.example.livraria.model.Autor;
import com.example.livraria.repository.AutorRepository;
import com.example.livraria.service.exception.EntityNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository repository;

    public Autor create(Autor obj){
        return repository.save(obj);
    }
    public void delete(Long id){
        repository.deleteById(id);
    }

    public Autor getId(Long id){
        Optional<Autor> obj = repository.findById(id);
        if (obj.isEmpty()){
            throw new EntityNotFound("Autor do id: " + id + " Não encontrado ");
        }
        return obj.get();
    }
    public List<Autor> getAll(){
        return repository.findAll();
    }
    public Autor update(Autor obj){
        Optional<Autor> newObj = repository.findById(obj.getId());
        if (newObj.isEmpty()){
            throw new EntityNotFound("Autor do id: " + obj.getId() + " Não encontrado ");
        }
        update(newObj, obj);
        return repository.save(newObj.get());
    }
    private void update(Optional<Autor> newObj, Autor obj) {
        newObj.get().setNome(obj.getNome());
    }
}
