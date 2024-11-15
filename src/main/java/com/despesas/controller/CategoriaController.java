
package com.despesas.controller;

import com.despesas.model.Categoria;
import com.despesas.service.CategoriaService;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    //retornar pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneCategoria(
    @PathVariable(value = "id")int id){
        Optional<Categoria> retorno =
                categoriaService.findById(id);
        if (retorno.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Categoria não localizada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(retorno.get());
    }
    //inserir novo registro
    @PostMapping
    public ResponseEntity<Object> saveCategoria(@RequestBody Categoria categoria){
        return
        ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoria));
    }
}
