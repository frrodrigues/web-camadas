package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrdemServico implements Serializable{
	private static final long serialVersionUID = 1L;
	private int seq;
	private String data_ini;
	private int sla;
	private String data_fim;
	private String status;
	private int id_cli;
	private int cod_tec;
	private int num_serv;
		
	public OrdemServico(int seq, String data_ini,int sla, String data_fim, String status, int id_cli,  int cod_tec,
			int num_serv) {
		super();
		this.seq = seq;
		this.data_ini = data_ini;
		this.data_fim = data_fim;
		this.status = status;
		this.id_cli= id_cli;
		this.cod_tec= cod_tec;
		this.num_serv = num_serv;
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

	public int getId_cli() {
		return id_cli;
	}

	public void setId_cli(int id_cli) {
		this.id_cli = id_cli;
	}

	public int getCod_tec() {
		return cod_tec;
	}

	public void setCod_tec(int cod_tec) {
		this.cod_tec = cod_tec;
	}

	public int getNum_serv() {
		return num_serv;
	}

	public void setNum_serv(int num_serv) {
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
				+ ", status=" + status + ", id_cli=" + id_cli + ", cod_tec=" + cod_tec + ", num_serv=" + num_serv + "]";
	}

	
	
	}
