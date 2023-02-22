package io.com.josepaulo.resources.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String fildName;
	private String messagem;
	
	public FieldMessage() {
		super();
	}
	public FieldMessage(String fildName, String messagem) {
		super();
		this.fildName = fildName;
		this.messagem = messagem;
	}
	public String getFildName() {
		return fildName;
	}
	public void setFildName(String fildName) {
		this.fildName = fildName;
	}
	public String getMessagem() {
		return messagem;
	}
	public void setMessagem(String messagem) {
		this.messagem = messagem;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
