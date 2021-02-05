package br.com.cadastroapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.cadastroapi.model.UsuariosModel;
import br.com.cadastroapi.repository.UsuariosRepository;

@RestController
public class UsuariosController {
	
	@Autowired
	private UsuariosRepository repository;
	
	@GetMapping(path = "/api/usuarios")
	public List<UsuariosModel> listaUsuarios(){
		return repository.findAll();
	}
	
	// Consulta por código se encontrar retorna dados
	// se nao ele retorna "nao encontrado".
	@GetMapping(path = "/api/usuarios/{codigo}")
	public ResponseEntity consultar(@PathVariable("codigo") Integer codigo) {
		return repository.findById(codigo)
				.map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());		
	}

	// Salva os Registros código
	// os dadoss sao enviados na requisicao no @requestbody
	@PostMapping(path = "/api/usuarios/salvar")
	public UsuariosModel adicionar(@RequestBody UsuariosModel usuarios) {
		return repository.save(usuarios);
	}
	
	
	// deleta puxando os dados pelo código id
	@DeleteMapping(path = "/api/usuarios/deletar")
	public void deletar(@RequestBody UsuariosModel usuarios) {
		repository.delete(usuarios);		
	}
	
	// faz a edição do mesmo pelo código, basta passar os parametros da edição
	@PutMapping(path = "/api/usuarios/editar")
	public UsuariosModel editar(@RequestBody UsuariosModel usuarios) {
		return repository.save(usuarios);
	}

}
