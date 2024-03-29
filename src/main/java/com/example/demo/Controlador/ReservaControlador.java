package com.example.demo.Controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Modelo.Reserva;
import com.example.demo.Modelo.Usuario;
import com.example.demo.Modelo.Carro;
import com.example.demo.Repositorio.RepositorioReserva;
import com.example.demo.Repositorio.RepositorioUsuario;
import com.example.demo.Repositorio.RepositorioCarro;

@RestController
@RequestMapping("/ver/e2/")

public class ReservaControlador {
	@Autowired
	private RepositorioReserva repositorio;
	@Autowired
	private RepositorioUsuario repositorioU;
	@Autowired
	private RepositorioCarro repositorioC;
	
	
	
	@GetMapping("/guardar")
	public List<Reserva> guardarReserva(){
		
		Usuario u = this.repositorioU.findById(123L).get();
		Carro c = this.repositorioC.findById(123L).get();
		Integer r= c.getCantidadPuesto() - c.getDisponibilidad();
		int d = c.getDisponibilidad();
		
		Reserva e = new Reserva("27/05/2023","bogota","10:00 AM",300000,d,r,u,c);
		this.repositorio.save(e);
		
		return this.repositorio.findAll();
	}
	
	@GetMapping("/cancelar")
	public String cancelarReserva() {
		this.repositorio.deleteById(123L);
		
		return "Reserva Cancelada";
	}
	
	@GetMapping("/consultar")
	public List<Reserva>verTodosReservas(){
		return repositorio.findAll();
	}
	
	
	}