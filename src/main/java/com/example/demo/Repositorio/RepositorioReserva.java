package com.example.demo.Repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Modelo.Reserva;

@Repository
public interface RepositorioReserva extends JpaRepository<Reserva,Long>{
	
	

}