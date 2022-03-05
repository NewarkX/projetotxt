package com.mjvschool.atracao.app;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import com.mjvschool.atracao.model.cadastro.Endereco;
import com.mjvschool.atracao.model.cadastro.Pais;
import com.mjvschool.atracao.model.cadastro.Pessoa;
import com.mjvschool.atracao.model.cadastro.Servico;
import com.mjvschool.atracao.model.contrato.Contrato;
import com.mjvschool.atracao.output.GeradorArquivo;
import com.mjvschool.atracao.repository.ContratoRepository;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class AguaLuzAtracaoApp {
	private static ContratoRepository contratoRepositorio = new ContratoRepository();
	public static void main(String[] args) {
		faseAtracao();
		faseGeracaoArquivo();
	}
	private static void faseGeracaoArquivo() {
		List<Contrato> contratos =  contratoRepositorio.listarTodos();
		GeradorArquivo gerador = new GeradorArquivo();
		gerador.gerarArquivoCsv(contratos);
		gerador.gerarArquivoTxt(contratos);
		
	}
	private static void faseAtracao() {
		
		
		Contrato contrato1 = new Contrato();
		contrato1.setNumeroProtocolo(1984365);
		contrato1.setServico(Servico.AGUA);
	
		
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setCpf("11094986089");
		pessoa1.setNome("Raimundo Nonato Loureiro Castelo Branco");
		pessoa1.setRg("98908");
		pessoa1.setPais(Pais.ESTADOS_UNIDOS);
		
		pessoa1.setCelular("11976349678");
		
		Endereco endereco1 = new Endereco();
		endereco1.setBairro("São Sebastião");
		endereco1.setCep("07.210.715");
		endereco1.setCidade("São Raimundo Nonato");
		endereco1.setUF("SP");
		endereco1.setLogradouro("Rua Sebastião Firmino");
		endereco1.setComplemento("AP 210 BL CENTAURO");
		endereco1.setNumero("123");
		pessoa1.setEndereco(endereco1);
		contrato1.setCadastro(pessoa1);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime teste = LocalDateTime.of(2022, 05, 07, 15, 21);

        contrato1.setData(formatter.format(teste));
        contrato1.setHora(formatter2.format(teste));
		
		contratoRepositorio.gravar(contrato1);
	}
}
