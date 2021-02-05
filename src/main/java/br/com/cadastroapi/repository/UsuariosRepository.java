package br.com.cadastroapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cadastroapi.model.UsuariosModel;


public interface UsuariosRepository extends JpaRepository<UsuariosModel, Integer>{
	
	// quantidade de registros
	@Query("SELECT COUNT(codigo) from Usuarios")
    Integer countByCodigo(@Param("codigo") String codigo);
	
	@Query("select nome,sobrenome from usuarios where email = ?")
    Optional<UsuariosModel> findByEmail(@Param("email") String email);
	
	//editar
	@Query("update nome, sobrenome,sexo,dtnac,rg,cpf,email,telefone from usuarios where codigo = ?")
	Optional<UsuariosModel> findByCodigo(Integer codigo);
	@Override
	default Optional<UsuariosModel> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
		

}
