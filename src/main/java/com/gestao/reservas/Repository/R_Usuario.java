package com.gestao.reservas.Repository;

import com.gestao.reservas.Model.M_Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Usuario extends JpaRepository<M_Usuario, Long> {
    @Query(value = "SELECT * FROM pessoa " +
            "WHERE matricula = :matricula AND senha = :senha",
            nativeQuery = true)
    M_Usuario buscarUsuarioPorMatriculaESenha(@Param("matricula") Long matricula,
                                              @Param("senha") String senha);
}
