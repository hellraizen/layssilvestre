package com.layssilvestre.util;


import java.text.SimpleDateFormat;
import java.util.Date;



public class TrataDataBr {
	
	public static String trataData(Date data){
		Date dia= data ;
		SimpleDateFormat sdFormate = new SimpleDateFormat("dd-MM-yyyy");
		String diaFormatado = sdFormate.format(dia);
		return diaFormatado;
		
	}
	
	public static String tranformarDataMes(Date data){
	   
		Date dia= data ;
		SimpleDateFormat sdFormate = new SimpleDateFormat("MMMMMM");
		String diaFormatado = sdFormate.format(dia);
		return diaFormatado;
	}

}
