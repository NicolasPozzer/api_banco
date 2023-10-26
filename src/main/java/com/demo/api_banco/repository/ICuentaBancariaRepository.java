package com.demo.api_banco.repository;

import com.demo.api_banco.model.CuentaBancaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICuentaBancariaRepository extends JpaRepository<CuentaBancaria, Long> {
}
