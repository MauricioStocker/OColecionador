package oColecionador.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormataData {
	public static Date parseStringToDate(String data) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = sdf.parse(data);
		} catch (ParseException e) {
			System.out.println("Ocorreu um erro ao converter a data");
		}
		return date;
	}

	public static Date parseStringToDateTime(String data) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			date = sdf.parse(data);
		} catch (ParseException e) {
			System.out.println("Ocorreu um erro ao converter a data");
		}
		return date;
	}

	public static Date parseStringToTime(String data) {
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		try {
			date = sdf.parse(data);
		} catch (ParseException e) {
			System.out.println("Ocorreu um erro ao converter a data");
		}
		return date;
	}

	public static String getDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			if (date != null)
				return sdf.format(date);
		} catch (Exception e) {
			System.out.println("Erro ao converter a string no obejto date");
		}
		return "";
	}

	public static String getDateTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		try {
			if (date != null)
				return sdf.format(date);
		} catch (Exception e) {
			System.out.println("Erro ao converter a string no obejto date");
		}
		return "";
	}

	public static String getTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		try {
			if (date != null)
				return sdf.format(date);
		} catch (Exception e) {
			System.out.println("Erro ao converter a string no obejto date");
		}
		return "";
	}
}
