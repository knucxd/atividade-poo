
package com.despesas.controller;

import com.despesas.model.Categoria;
import com.despesas.service.CategoriaService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;
    
    public CategoriaController(CategoriaService categoriaService){
        this.categoriaService = categoriaService;
    }
    //retornar todas as categorias
    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategoria(){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.findAll());
    }
    
}
