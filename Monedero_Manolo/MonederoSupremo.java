package Maquina;

/** La clase monedero supremo controla 5 tipos de monedas: 5, 10, 20, 50, 100 cts.
 * 
 * 	Los Servicios son:
 * 				- AÑADIR MONEDA
 * 				- SI HAY SUFICIENTE DINERO
 * 				- SI PUEDO DEVOLVER EL CAMBIO
 * 				- HACER EL CAMBIO
 * 				- RETORNAR EL CAMBIO
 */


public class MonederoSupremo {

	private double cantidad; //cantidad introducida x el usuario
	private double[] valor = {0.05, 0.10, 0.20, 0.50, 1.00};
	
	private int[] monedas;
	
	//Constructores
	public MonederoSupremo(){
		this.cantidad=0.0;
		this.monedas= new int[this.valor.length];
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
	
	//SERVICIOS
	public void addCoin(int valor){
		
	}
	
	

	public static void main(String[] args) {
		
		System.out.println(MonederoSupremo.round(23.123456, 2));

	}

}
