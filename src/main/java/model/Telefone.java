package model;

public class Telefone {

	private Long id;
	private String numeroString;
	private String tipo;
	
	private Long usuario;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroString() {
		return numeroString;
	}

	public void setNumeroString(String numeroString) {
		this.numeroString = numeroString;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}
	
	
}
