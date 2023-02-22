package io.com.josepaulo.domain.enums;
public enum PerfilUsuario {

	ADMIN(0, "ROLE_ADMIN"), LOCATARIO(1, "ROLE_LOCATARIO"), TECNICO(2, "ROLE_TECNICO");

	private Integer codigo;
	private String descricao;
	
	private PerfilUsuario(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public static PerfilUsuario toEnum (Integer cod) {
		if(cod == null) {
			return null;
		}
		for (PerfilUsuario x : PerfilUsuario.values()) {
			if (cod.equals(x.getCodigo())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Perfil inválido");
	}

}
