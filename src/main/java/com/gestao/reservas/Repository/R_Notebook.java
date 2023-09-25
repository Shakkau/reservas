package com.gestao.reservas.Repository;

import com.gestao.reservas.Model.M_Notebook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Notebook extends JpaRepository<M_Notebook, Long> {
}
