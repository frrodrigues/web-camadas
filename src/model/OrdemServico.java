package model;
import java.io.Serializable;

import model.Cliente;
import model.Servico;

public class OrdemServico implements Serializable{
	private static final long serialVersionUID = 1L;
	private int seq;
	private String data_ini;
	private int sla;
	private String data_fim;
	private String status;
	private Cliente cli;
	private Tecnico cod_tec;
	private Servico num_serv;
		
	public OrdemServico(int seq, String data_ini,int sla, String data_fim, String status,  Cliente _cli,  Tecnico _cod_tec,
			Servico _num_serv) {
		super();
		this.seq = seq;
		this.data_ini = data_ini;
		this.data_fim = data_fim;
		this.status = status;
		this.cli= _cli;
		this.cod_tec= _cod_tec;
		this.num_serv = _num_serv;
		
		
}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getData_ini() {
		return data_ini;
	}

	public void setData_ini(String data_ini) {
		this.data_ini = data_ini;
	}

	public int getSla() {
		return sla;
	}

	public void setSla(int sla) {
		this.sla = sla;
	}

	public String getData_fim() {
		return data_fim;
	}

	public void setData_fim(String data_fim) {
		this.data_fim = data_fim;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cliente getCli() {
		return cli;
	}

	public void setCli(Cliente cli) {
		this.cli = cli;
	}

	public Tecnico getCod_tec() {
		return cod_tec;
	}

	public void setCod_tec(Tecnico cod_tec) {
		this.cod_tec = cod_tec;
	}

	public Servico getNum_serv() {
		return num_serv;
	}

	public void setNum_serv(Servico num_serv) {
		this.num_serv = num_serv;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + seq;
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
		OrdemServico other = (OrdemServico) obj;
		if (seq != other.seq)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrdemServico [seq=" + seq + ", data_ini=" + data_ini + ", sla=" + sla + ", data_fim=" + data_fim
				+ ", status=" + status + ", cli=" + cli + ", cod_tec=" + cod_tec + ", num_serv=" + num_serv + "]";
	}

	
	
} 
