package br.com.cadastroapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.cadastroapi.model.UsuariosModel;

public interface UsuariosRepository extends JpaRepository<UsuariosModel, Integer>{
	// Classes com os Metodos do sistema

}
