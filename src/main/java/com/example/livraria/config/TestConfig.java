package com.example.livraria.config;


import com.example.livraria.model.Autor;
import com.example.livraria.model.Livro;
import com.example.livraria.repository.AutorRepository;
import com.example.livraria.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig  implements CommandLineRunner {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;
    @Override
    public void run(String... args) throws Exception {
        Autor a1 = new Autor(null, "Autor Teste 1");
        Autor a2 = new Autor(null, "Autor Teste 2");
        autorRepository.saveAll(Arrays.asList(a1, a2));

        Livro l1 = new Livro(null, "Livro Teste 1", a1);
        Livro l2 = new Livro(null, "Livro Teste 2", a2);
        livroRepository.saveAll(Arrays.asList(l1, l2));
    }

}
