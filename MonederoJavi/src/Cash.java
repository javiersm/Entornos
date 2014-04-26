

import java.util.Arrays;

public class Cash {
	
	//Atributos
	
	private int amount; //valor introducido por el usuario
	private int[] valor = {5,10,20,50,100}; //valor en centimos de las monedas
	private int[] monedas; //número de monedas de cada tipo (índice) almacenadas en la máquina
	private int total; //valor almacenado en la maquina (el dinero que me queda)
	private int[] aux; //la cantidad de monedas de cada tipo (índice) que se utilizan para devolver el cambio

	
	
	//Constructores
	
	public Cash() {
		
		this.amount = 0;
		this.monedas = new int[this.valor.length]; //tamaño en función de las monedas (tipos)
		this.total = 0;
		this.aux = new int[this.valor.length]; //tamaño en función de las monedas (tipos)
		
	}
	
	public Cash( int[] monedas) { //puede no ser necesario utilizarlo, al haber implementado la clase Interfaz
		
		this.amount = 0;
		this.monedas = new int[this.valor.length];
		for (int i = 0; i < this.monedas.length; ++i ) {
			this.monedas[i] = monedas[i];
			this.total+= this.monedas[i]*this.valor[i];
		}
			
		this.aux = new int[this.valor.length]; //tamaño en función de las monedas (tipos)
		
	}
	
	//Accesadores

	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int[] getValor() {
		return valor;
	}
	public void setValor(int[] valor) {
		this.valor = valor;
	}
	public int[] getMonedas() {
		return monedas;
	}
	public void setMonedas(int[] monedas) {
		this.monedas = monedas;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int[] getAux() {
		return aux;
	}
	public void setAux(int[] aux) {
		this.aux = aux;
	}
	
	
	//Servicios y utilidades
	
	public boolean siHaySuficienteCash ( double cantidad ) { //devuelve true si la cantidad introducida por el usuario es mayor que el precio del producto
		
		return (this.amount >= cantidad) ? true : false;
	}
	
	/*
	 * Métodos siHayMonedas() y siHayCambio()
	 * 
	 * Se utilizan para controlar el posible cambio. 
	 * En caso de que sea posible devolver cambio, éste queda anotado en el vector aux.

	 */
	
	public boolean siHayMonedas( int cambio, int indice, int total ) {
		
		for(int i=this.monedas[indice]; i >= 0 && cambio <= total; --i) {
			if ( i*this.valor[indice] > cambio ) { //si el valor de las monedas es mayor que el cambio
				continue;
			}
			this.aux[indice]=i; //anotamos las monedas de este tipo que vamos a devolver
			if ( i * this.valor[indice] == cambio ) { //si es el cambio justo he terminado
				
				return true;				
			}
			if ( indice > 0) { //si todavía quedan más monedas
				
				if(this.siHayMonedas(cambio - (i*this.valor[indice]), indice-1, total-(i*this.valor[indice]))){
					return true;
				}
				
			}
			
			this.aux[indice]=0;
		}
		
		return false;
	}
	
	
	public boolean siHayCambio(int cambio) {
		this.iniAux();
		return this.siHayMonedas(cambio, this.valor.length-1, this.total);
	}
	
	
	/*
	 * Método iniAux()
	 * 
	 * Resetea el vector aux con todos sus elementos a 0, para evitar posibles residuos a la hora de 
	 * cambiar de valor de moneda en las operaciones de analizar si se puede devolver cambio.

	 */
	
	private void iniAux() {
		for(int i=0; i<this.aux.length; ++i) {
			this.aux[i]=0;
		}
	}
	
	
	/*
	 * Método displayAux()
	 * 
	 * Muestra los valores y cantidades de monedas guardados en el vector aux.

	 */
	
	public void displayAux(){
		
		for(int i=0; i < this.monedas.length; ++i ) {
			System.out.println("Monedas de " + this.valor[i] + " : " + this.aux[i]);
		}
	}
	
	
	/*
	 * Método hacerCambio()
	 * 
	 * Resta a la cantidad introducida por el usuario el precio del producto.

	 */
	
	public void hacerCambio( int cantidad ) {
		
		this.amount -= cantidad;	
	}
	
	
	
	
	public void retornarCash ( int cambio ) {
		
		if ( this.siHayCambio(cambio)) {
			
			for ( int i = 0; i < this.monedas.length; ++i ) {
				
				this.monedas[i] -= this.aux[i];
			}		
				
			System.out.println("====== SU CAMBIO ======");
			this.displayAux();	
			
			this.amount = 0;
			
		}	

	}
	

	
	
	
	public void addCash(int coin){		
		switch(coin)
		{		
			case 5: this.amount += coin; this.total += coin; this.monedas[0]++; break;
			case 10: this.amount += coin; this.total += coin; this.monedas[1]++; break;
			case 20: this.amount += coin; this.total += coin; this.monedas[2]++; break;
			case 50: this.amount += coin; this.total += coin; this.monedas[3]++; break;
			case 100: this.amount += coin; this.total += coin; this.monedas[4]++; break;		
		}
	}
	
	
	
	public void verCredito() {
		System.out.println("Crédito: " + this.amount);
	}	
	

	public void showCoins() {
		System.out.printf("\n ______Monedas en el Monedero_________________");
		System.out.printf("\n|_____________________________________________|");
		System.out.printf("\n|%45s|","");
		System.out.printf("\n|   %6s %9s %8s %15s|","MONEDAS","CANTIDAD","TOTAL","" );
		System.out.printf("\n|   [%02.02f]: %6d %5s %5.02f %15s|",0.05, this.monedas[0],"=", (this.monedas[0]*0.05),"" );
		System.out.printf("\n|   [%02.02f]: %6d %5s %5.02f %15s|",0.1,this.monedas[1],"=", (this.monedas[1]*0.1),"" );
		System.out.printf("\n|   [%02.02f]: %6d %5s %5.02f %15s|",0.2,this.monedas[2],"=", (this.monedas[2]*0.2),"" );
		System.out.printf("\n|   [%02.02f]: %6d %5s %5.02f %15s|",0.5,this.monedas[3],"=", (this.monedas[3]*0.5),"" );
		System.out.printf("\n|   [%02.02f]: %6d %5s %5.02f %15s|",1.00,this.monedas[4],"=", (this.monedas[4]*1.00),"" );
		System.out.printf("\n|_____________________________________________|" );
		System.out.printf("\n|   %16s  %8s %15s|","TOTAL",((this.monedas[0]*0.05)+(this.monedas[1]*0.1)+(this.monedas[2]*0.2)+(this.monedas[3]*0.5)+(this.monedas[4]*1.00) ),"" );
		System.out.printf("\n|_____________________________________________|");
		System.out.println();
	}
	
	
}
