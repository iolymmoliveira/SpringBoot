package br.com.ioly.naturassp.services;

import java.util.ArrayList;

import br.com.ioly.naturassp.model.Categoria;

public interface ICategoriaService {
	
	//Método que recebe uma categoria só com o nome preenchido e será inserido no BD
	public Categoria inserirNovaCategoria(Categoria categoria);
	
	//Método que irá alterar uma categoria existente e retorná-la se o update der certo ou retorna null caso contrário
	public Categoria alterarCategoria(Categoria categoria);
	
	//Método que irá recuperar todas as categorias sem filtro
	public ArrayList<Categoria> recuperarTodasCategorias();
	
	//Método que irá recuperar as categorias filtradas por palavra chave
	public ArrayList<Categoria> recuperarPorPalavraChave(String palavraChave);
	
}
