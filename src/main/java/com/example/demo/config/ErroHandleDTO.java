package com.example.demo.config;

public class ErroHandleDTO {

	private String campo;
	private String erro;
	
	public ErroHandleDTO(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
}
