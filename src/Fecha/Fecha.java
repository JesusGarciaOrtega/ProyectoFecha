/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fecha;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Jesús Garcia
 */
public class Fecha {

//ATRIBUTOS    
    private int dia;
    private int mes;
    private int ano;
    private static int[] diasMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo",
        "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

//GET Y SET
    public static int[] getDiasMes() {
        return diasMes;
    }

    public static void setDiasMes(int[] aDiasMes) {
        diasMes = aDiasMes;
    }

    public static String[] getMeses() {
        return meses;
    }

    public static void setMeses(String[] aMeses) {
        meses = aMeses;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

//CONSTRUCTORES
    
 public Fecha() {
        Calendar c = new GregorianCalendar();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH);
        ano = c.get(Calendar.YEAR);
    }

public Fecha(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

//MÉTODOS

    public void bisiesto(int ano) {
        if (ano % 4 == 0 && ano % 100 != 0 || ano % 400 == 0) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 28;
        }
    }

    public boolean comprobarFecha(int a, int m, int d) {
        boolean resultado = false;
        if (a >= 1900 && a <= 2100) {
            bisiesto(a);
            if (d >= 1 && d <= diasMes[m - 1]) {
                resultado = true;
                dia = d;
                mes = m;
                ano = a;

            }
        }
        return resultado;
    }



    public int compararFechas(Fecha f) {
        if (this.ano > f.getAno()) {
            return 1;
        } else if (this.ano < f.getAno()) {
            return -1;
        } else if (this.mes > f.getMes()) {               //Los años son iguales
            return 1;
        } else if (this.mes < f.getMes()) {
            return -1;
        } else if (this.dia > f.getDia()) {                      //meses iguales
            return 1;
        } else if (this.dia < f.getDia()) {
            return 1;
        } //las fechas coinciden
        else {
            return 0;
        }
    }

}
