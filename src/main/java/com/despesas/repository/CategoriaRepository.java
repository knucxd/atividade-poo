
package com.despesas.repository;

import com.despesas.model.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{
    public List<Categoria> findByNomeContainingIgnoreCase(String nome);
}
