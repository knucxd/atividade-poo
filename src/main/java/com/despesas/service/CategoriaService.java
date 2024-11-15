
package com.despesas.service;

import com.despesas.model.Categoria;
import com.despesas.repository.CategoriaRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    
    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }
    public Optional findById(int id){
        return categoriaRepository.findById(id);
    }
    public List<Categoria> findByNomeContainingIgnoreCase(String nome){
        return categoriaRepository.findByNomeContainingIgnoreCase(nome);
    }
    //método que grava na table
    @Transactional
    public Categoria save(Categoria categoria){
        return categoriaRepository.save(categoria);
    }
}
