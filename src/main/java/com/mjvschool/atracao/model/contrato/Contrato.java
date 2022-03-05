package com.mjvschool.atracao.model.contrato;


import java.time.LocalDate;
import java.time.LocalDateTime;

import com.mjvschool.atracao.model.cadastro.Pessoa;
import com.mjvschool.atracao.model.cadastro.Servico;

//java beans
public class Contrato {
	private long numeroProtocolo;
	private Pessoa cadastro;
	private String data;
	private String hora;
	private Servico servico;
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	
	public long getNumeroProtocolo() {
		return numeroProtocolo;
	}
	public void setNumeroProtocolo(long numeroProtocolo) {
		this.numeroProtocolo = numeroProtocolo;
	}
	public Pessoa getCadastro() {
		return cadastro;
	}
	public void setCadastro(Pessoa cadastro) {
		this.cadastro = cadastro;
	}
	
    /**
     * @return String return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return String return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

	@Override
    public String toString() {
        return "Contrato [numeroProtocolo=" + numeroProtocolo + ", data=" + data + " hora="+hora+"]";
    }
}
