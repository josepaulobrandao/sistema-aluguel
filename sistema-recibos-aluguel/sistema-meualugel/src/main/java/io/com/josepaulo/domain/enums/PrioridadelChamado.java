package io.com.josepaulo.domain.enums;

public enum PrioridadelChamado {
	BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA");

	private Integer codigo;
	private String descricao;
	
	private PrioridadelChamado(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static PrioridadelChamado toEnum (Integer cod) {
		if(cod == null) {
			return null;
		}
		for (PrioridadelChamado x : PrioridadelChamado.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Prioridade inválida");
	}

}
