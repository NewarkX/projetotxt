package com.mjvschool.atracao.output;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


import com.mjvschool.atracao.model.contrato.Contrato;
import com.mjvschool.atracao.util.TextoUtil;



public class GeradorArquivo {
	public void gerarArquivoCsv(List<Contrato> contratos) {
		StringBuilder conteudo =new StringBuilder();
		for(Contrato ct: contratos) {
			conteudo.append(ct.getCadastro().getNome().concat(";").concat(ct.getCadastro().getCpf()));
			conteudo.append("\n");
		}
		
		System.out.println(conteudo.toString());
		
		File output = new File("C:\\estudo\\mjv-java-school\\agua-luz-output");
		if(!output.exists())
			output.mkdirs();
		
		Path path = Paths.get("C:\\estudo\\mjv-java-school\\agua-luz-output\\agua-luz-contratos.csv");

		try {
			Files.write(path, conteudo.toString().getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void gerarArquivoTxt(List<Contrato> contratos) {
		StringBuilder conteudo = new StringBuilder();
		
		for(Contrato ct: contratos) {
			conteudo.append(ct.getCadastro().getCpf().replaceAll("\\p{Punct}", ""));
			conteudo.append(TextoUtil.ajustar(ct.getCadastro().getNome(), 30).toUpperCase() );	
			conteudo.append(ct.getCadastro().getCelular().replaceAll("\\p{Punct}", ""));
			conteudo.append(TextoUtil.ajustar(ct.getCadastro().getEndereco().getLogradouro().toUpperCase(),20));
			conteudo.append(String.format("%06d",Integer.parseInt(ct.getCadastro().getEndereco().getNumero())));
			conteudo.append(TextoUtil.ajustar(ct.getCadastro().getEndereco().getComplemento(), 10));	
			conteudo.append(ct.getCadastro().getEndereco().getBairro().toUpperCase());
			conteudo.append(ct.getCadastro().getEndereco().getCidade().toUpperCase());
			conteudo.append(ct.getCadastro().getEndereco().getUF().toUpperCase());
			conteudo.append(ct.getCadastro().getEndereco().getCep().replaceAll("\\p{Punct}", ""));
			conteudo.append(String.valueOf(ct.getNumeroProtocolo()));
			conteudo.append(ct.getData().replaceAll("\\p{Punct}", ""));
			conteudo.append(ct.getHora().replaceAll("\\p{Punct}", ""));
			conteudo.append(String.format("%06f", ct.getServico().getValor()).replaceAll("\\p{Punct}", ""));
			conteudo.append(ct.getServico().getNome());
			
		}
		
		System.out.println(conteudo.toString());
		
		File output = new File("C:\\estudo\\mjv-java-school\\agua-luz-output");
		if(!output.exists())
			output.mkdirs();
		
		Path path = Paths.get("C:\\Users\\User\\Desktop\\agua-luz-atracao\\agua-luz-contratos.txt");

		try {
			Files.write(path, conteudo.toString().getBytes(StandardCharsets.UTF_8));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
