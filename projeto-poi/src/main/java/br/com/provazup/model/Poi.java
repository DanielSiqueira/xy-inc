package br.com.provazup.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="tb_poi")
public class Poi implements Serializable {
	private static final long serialVersionUID = 201612262034l;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Nome é obrigatório")
	@Size(max = 100, message = "O nome não pode conter mais de 100 caracteres")
	@Column(name = "nome", nullable = false)
	private String nome;

	@NotNull(message = "Coordenada X é obrigatória")
	@Min(value=0, message="O valor deve ser inteiro não negativo.")
	@Column(name = "coordenada_X", nullable = false)
	private Long coordenadaX;

	@NotNull(message = "Coordenada Y é obrigatória")
	@Min(value=0, message="O valor deve ser inteiro não negativo.")
	@Column(name = "coordenada_Y", nullable = false)
	private Long coordenadaY;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getCoordenadaX() {
		return coordenadaX;
	}

	public void setCoordenadaX(Long coordenadaX) {
		this.coordenadaX = coordenadaX;
	}

	public Long getCoordenadaY() {
		return coordenadaY;
	}

	public void setCoordenadaY(Long coordenadaY) {
		this.coordenadaY = coordenadaY;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordenadaX == null) ? 0 : coordenadaX.hashCode());
		result = prime * result + ((coordenadaY == null) ? 0 : coordenadaY.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poi other = (Poi) obj;
		if (coordenadaX == null) {
			if (other.coordenadaX != null)
				return false;
		} else if (!coordenadaX.equals(other.coordenadaX))
			return false;
		if (coordenadaY == null) {
			if (other.coordenadaY != null)
				return false;
		} else if (!coordenadaY.equals(other.coordenadaY))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
