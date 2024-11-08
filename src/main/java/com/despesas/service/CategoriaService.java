
package com.despesas.service;

import com.despesas.model.Categoria;
import com.despesas.repository.CategoriaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

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
}
