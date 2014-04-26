package MonederoSupremo;

import java.util.Arrays;

/**
 * FECHA LIMITE ANTES DE LAS VACACIONES
 * 
 * Crear una matriz con los tipos de moneda (posición 0 las de 5 cts., posición 1 las de 10 cts.,
 * ... ... posición 4 las de 1 euro).
 * 
 * ESPECIFICACIONES
 * 
 * La clase MonederoSupremo controla 5 tipos de monedas:
 * 
 * 5, 10, 20, 50, 100 cts.
 * 
 * Los servicios son:
 * - añadir moneda
 * - si hay suficiente dinero
 * - si puedo devolver el cambio (porque lo haya)
 * - hacer el cambio (restar el dinero de lo que él mete)
 * - retornar dinero (cuando pides que te devuelvan el dinero)
 */


public class MonederoSupremo_No_Terminado {

	private double cantidad; //cantidad introducida x el usuario
	private double[] valor = {0.05, 0.10, 0.20, 0.50, 1.00}; //En este array apunto el valor de cada moneda
	private static int[] monedas; //En este array voy a ir llevando la cuenta de las monedas que hay en la maquina
	private static int[] aux; //copia/clon de monedas para que cada vez que hago una cuenta hago una copia de monedas[] (para NO operar con monedas[])
	
	
	//Constructores
	public MonederoSupremo_No_Terminado(){
		this.cantidad=0.0;
		this.monedas= new int[this.valor.length];
		this.aux = new int[this.valor.length];
	}
	
	public MonederoSupremo_No_Terminado(int[]monedas)
	{
		this.cantidad=0.0;
		this.monedas = new int[this.valor.length];
		this.aux = new int[this.valor.length];
		
		for(int i=0; i<this.monedas.length; i++)
		{
			this.monedas[i] = monedas[i];
		}
		
	}
	
	
	//Accesadores
	public double getCantidad() {
		
		
		
		return cantidad;
	}



	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}



	public double[] getValor() {
		return valor;
	}



	public void setValor(double[] valor) {
		this.valor = valor;
	}
	

	public int[] getMonedas() {
		return monedas;
	}



	public void setMonedas(int[] monedas) {
		this.monedas = monedas;
	}


	

	
	//SERVICIOS
	public void addCoin(int valor){
		
		switch(valor)
		{
		case 5: 	this.cantidad+=0.05;	this.monedas[0]++;	break;
		case 10:	this.cantidad+=0.10;	this.monedas[1]++;	break;
		case 20:	this.cantidad+=0.20;	this.monedas[2]++;	break;		
		case 50:	this.cantidad+=0.50;	this.monedas[3]++;	break;		
		case 100:	this.cantidad+=0.100;	this.monedas[4]++;	break;		
		}
		
	}
	
	//UTILIDADES
	public static double round(double valor, int decimales){
		long divisor = 1;
		long x=0;
		for(int i=0; i<decimales; ++i){
			divisor *= 10;
		}
		x = Math.round(valor*divisor);
		valor = (double) x/divisor;
		
		return valor;
	}
	
	
	public boolean siHayCambio(double cambio){
		boolean rsp = false;
		aux = Arrays.copyOf(monedas, monedas.length); //Copiamos todos los datos de monedas en aux

		//Buscamos si hay un cambio con las monedas
		for(int i=this.valor.length-1; i>=0; --i){
			while(aux[i]>0 &&  cambio>0  && this.valor[i]<=cambio) //aux[i] => (hay monedas de 1€)   && cambio(hay suficiente cambio) && cambio(hay suficiente cambio para devolver)
			{
				cambio -= this.valor[i];
				cambio = MonederoSupremo_No_Terminado.round(cambio, 2);
				aux[i]--;
			}
		}
		if(cambio == 0){
			rsp = true; //si hay cambio entonces la respuesta es true
		}
		
		return rsp;
	}
	/*
	public String toString(){
		System.out.printf("\n%5s","---------- Monedas Maquina ------------");
		System.out.printf("\n%5s | %5s | %5s | %5s | %5s","0.05","0.10","0.20","0.50","1.00");
		System.out.printf("\n%5d | %5d | %5d | %5d | %5d",monedas[0],monedas[1],monedas[2],monedas[3],monedas[4]);
		
		System.out.printf("\n%5s","---------- Monedas aux ----------------");
		System.out.printf("\n%5s | %5s | %5s | %5s | %5s","0.05","0.10","0.20","0.50","1.00");
		System.out.printf("\n%5d | %5d | %5d | %5d | %5d",aux[0],aux[1],aux[2],aux[3],aux[4]);
		return null;
	}*/
	
	public String toString(){
		System.out.printf("\n%5s","---------- MAQUINA DE VENDING ------------");
		System.out.printf("\n%5s | %5s | %5s | %5s | %5s","0.05","0.10","0.20","0.50","1.00");
		System.out.printf("\n%5d | %5d | %5d | %5d | %5d",monedas[0],monedas[1],monedas[2],monedas[3],monedas[4]);
		
		System.out.printf("\n%5s","---------- Monedas aux ----------------");
		System.out.printf("\n%5s | %5s | %5s | %5s | %5s","0.05","0.10","0.20","0.50","1.00");
		System.out.printf("\n%5d | %5d | %5d | %5d | %5d",aux[0],aux[1],aux[2],aux[3],aux[4]);
		return null;
	}
	
	
	
	
	
	public void displayAux(){
		for(int i=0; i<this.monedas.length; i++)
		{
			System.out.println("Monedas de "+ this.valor[i]+" : "+ this.aux[i]);
		}
	}

	public static void main(String[] args) {
		
		System.out.println(MonederoSupremo_No_Terminado.round(23.123456, 2));
		
		int[]monedas = {1,0,1,2,1}; //Cargo el hopper.
		MonederoSupremo_No_Terminado monedero = new MonederoSupremo_No_Terminado(monedas);
		
		System.out.println(monedero.siHayCambio(100));
		monedero.displayAux();
		
		monedero.toString();
		
	}

}
