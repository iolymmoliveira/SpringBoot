package br.com.ioly.naturassp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ioly.naturassp.model.Categoria;
import br.com.ioly.naturassp.services.ICategoriaService;

@RestController
public class CategoriaController {

	@Autowired
	private ICategoriaService service;
	
	@GetMapping("/categoria")
	public ResponseEntity<ArrayList<Categoria>> listarTodas() {
		return ResponseEntity.ok().body(service.recuperarTodasCategorias());
	}
	
	@GetMapping("/categoria/search")
	public ResponseEntity<ArrayList<Categoria>> recuperarPorPalavraChave(@RequestParam(name="key") String palavraChave) {
		if(palavraChave != null)
			return ResponseEntity.ok().body(service.recuperarPorPalavraChave(palavraChave));
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping("/categoria")
	public ResponseEntity<Categoria> adicionarNova(@RequestBody Categoria categoria) {
		Categoria resultado = service.inserirNovaCategoria(categoria);
		if(resultado != null)
			return ResponseEntity.status(201).body(resultado);
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/categoria")
	public ResponseEntity<Categoria> alterarDados(@RequestBody Categoria categoria) {
		Categoria resultado = service.alterarCategoria(categoria);
		if(resultado != null)
			return ResponseEntity.status(200).body(resultado);
		return ResponseEntity.badRequest().build();
	}
}
