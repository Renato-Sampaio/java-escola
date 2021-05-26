package model;

import java.util.ArrayList;

/**
 * Classe para armazenar atributos e metodos ( PROFESSOR ) 
 * @author Renato Duarte Sampaio
 *
 * @since 23 de fev. de 2021
 */
public class Professor extends Funcionario{
	
	//declarando os atributos do professor

	private ArrayList<Materia> listaMaterias;
	

	public ArrayList<Materia> getListaMateria() {
		return listaMaterias;
	}
	public void setListaMateria(ArrayList<Materia> listaMateria) {
		this.listaMaterias = listaMateria;
	}
	
	

}
