package com.demo.api_banco.repository;

import com.demo.api_banco.model.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMovimientoRepository extends JpaRepository<Movimiento, Long> {
}
