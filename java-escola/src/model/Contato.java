package model;

/**
 * classe para armazenar contato
 * @author Renato Duarte Sampaio
 *
 * 23 de fev. de 2021
 */
public class Contato {

	// Declarando atributos.
	
	private String celular;
	private String email;

	
	//get e seters.
	
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
