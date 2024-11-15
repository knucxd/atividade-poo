
package com.despesas.controller;

import com.despesas.model.Despesa;
import com.despesas.service.DespesaService;
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
@RequestMapping("/despesa")
public class DespesaController {
    private final DespesaService despesaService;

    public DespesaController(DespesaService despesaService) {
        this.despesaService = despesaService;
    }
    //
    @PostMapping
    public ResponseEntity<Object> saveDespesa(@RequestBody Despesa despesa){
        return ResponseEntity.status(HttpStatus.CREATED).body(despesaService.save(despesa));
    }
    //retorna todas as despesas
    @GetMapping
    public ResponseEntity<List<Despesa>> getAllDespesas(){
        return ResponseEntity.status(HttpStatus.OK).body(despesaService.findAll());
    }
    //retorna 1 despesa pelo id
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneDespesa(@PathVariable(value = "id") int id){
        Optional<Despesa> retorno = despesaService.findbyId(id);
        if(!retorno.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não localizada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(retorno.get());
    }
 
}
