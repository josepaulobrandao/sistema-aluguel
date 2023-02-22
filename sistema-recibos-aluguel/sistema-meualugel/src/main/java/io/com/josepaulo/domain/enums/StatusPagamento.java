package io.com.josepaulo.domain.enums;

public enum StatusPagamento {
	PENDENTE(0, "BAIXA"), ATRASADO(1, "MEDIA"), PAGO(2, "ALTA");

	private Integer codigo;
	private String descricao;
	
	private StatusPagamento(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static StatusPagamento toEnum (Integer cod) {
		if(cod == null) {
			return null;
		}
		for (StatusPagamento x : StatusPagamento.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Status do pagamento inválido");
	}

}
