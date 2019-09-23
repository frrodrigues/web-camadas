package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Tecnico implements Serializable  {
	private static final long serialVersionUID = 1L;
	private int cod;
	private String nome;
	private String cargo;
	private String tel;
		
	public Tecnico(int cod, String nome, String cargo, String tel) {
		super();
		this.cod = cod;
		this.nome = nome;
		this.cargo = cargo;
		this.tel = tel;
		
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cod;
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
		Tecnico other = (Tecnico) obj;
		if (cod != other.cod)
			return false;
		return true;
		
	}

	@Override
	public String toString() {
		return "Tecnico [cod=" + cod + ", nome=" + nome + ", cargo=" + cargo + ", tel=" + tel + "]";
	}
	
	
}
