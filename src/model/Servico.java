package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Servico implements Serializable  {
	private static final long serialVersionUID = 1L;
	private int num;
	private int valor;
	private String descricao;
	private String tipo;

		
	public Servico(int num, int valor, String descricao, String tipo) {
		super();
		this.num = num;
		this.valor = valor;
		this.descricao = descricao;
		this.tipo = tipo;	

}

	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Servico [num=" + num + ", valor=" + valor + ", descricao=" + descricao + ", tipo=" + tipo + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
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
		Servico other = (Servico) obj;
		if (num != other.num)
			return false;
		return true;
	}
	}
