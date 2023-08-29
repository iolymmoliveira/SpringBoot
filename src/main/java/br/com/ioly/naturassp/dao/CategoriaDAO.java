package br.com.ioly.naturassp.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.ioly.naturassp.model.Categoria;

public interface CategoriaDAO extends CrudRepository<Categoria, Integer> {
	
	//Queries Customizadas
	// 1) Categoria por palavra chave
	public ArrayList<Categoria> findByNomeContaining(String palavraChave);
}
