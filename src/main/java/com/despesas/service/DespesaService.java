
package com.despesas.service;

import com.despesas.model.Despesa;
import com.despesas.repository.DespesasRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class DespesaService {

    private final DespesasRepository despesasRepository;
    
    public DespesaService(DespesasRepository despesasRepository) {
        this.despesasRepository = despesasRepository;
    }
   
    //
    @Transactional
    public Despesa save(Despesa despesa){
        return despesasRepository.save(despesa);
    }
    //retorna todos os registros
    public List<Despesa> findAll(){
        return despesasRepository.findAll();
    }
    //retorna uma despesa pelo id
    public Optional findbyId(int id){
        return despesasRepository.findById(id);
    }
    
}
