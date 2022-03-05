package com.mjvschool.atracao.util;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class TextoUtil {
	public static String preencher(String textoOriginal, int tamanhoMaximo) {
		String formato = "%-" + tamanhoMaximo + "s";
		String novaString = String.format(formato, textoOriginal);
		return novaString;
	}
	public static String cortar(String textoOriginal, int tamanhoMaximo) {
		String  novaString = textoOriginal.substring(0, Math.min(tamanhoMaximo, textoOriginal.length()));
		return novaString;
	}
	public static String ajustar(String textoOriginal, int tamanhoMaximo) {
		String novaString = preencher(textoOriginal, tamanhoMaximo);
		novaString = cortar(novaString, tamanhoMaximo);
		return novaString;
	}

	public static String formatarData(LocalDateTime dataHora){
        Date data = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = dateFormat.format(data);
		return dataFormatada;
    }

	public static String formatarHora(LocalDateTime dataHora){
		Date hora = new Date();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        String dataFormatada = dateFormat.format(hora);
		return dataFormatada;
	}
}
