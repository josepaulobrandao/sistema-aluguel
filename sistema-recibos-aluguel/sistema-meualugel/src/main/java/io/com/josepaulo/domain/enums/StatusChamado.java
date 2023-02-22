package io.com.josepaulo.domain.enums;

public enum StatusChamado {
	ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO");

	private Integer codigo;
	private String descricao;
	
	private StatusChamado(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static StatusChamado toEnum (Integer cod) {
		if(cod == null) {
			return null;
		}
		for (StatusChamado x : StatusChamado.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Status inválido");
	}

}
