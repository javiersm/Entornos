package febrero;

/* Define las caracteristicas de un dispositivo que cuenta de uno en uno
 * hacia arriba y hacia abajo
 * Partiendo siempre de un valor inicial
 * Los objetos de esta clase deben poder incrementar su valor, decrementar su valor
 * E inicializarse al valor indicado
 */

// Que conoco como objeto dispositivo contador?


public class DispositivoContador {

	private int valor;
	private int valorInicial;
	
	public DispositivoContador(){
	this.valor=0;
	this.valorInicial=0;
	}
		
	
	public DispositivoContador(int valor, int valorInicial){
		this.valor = valor;
		this.valorInicial = valorInicial;
	}
	
	

	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}


	public int getValorInicial() {
		return valorInicial;
	}


	public void setValorInicial(int valorInicial) {
		this.valorInicial = valorInicial;
	}

	
	public void incrementar(){
		this.valor++;
	}

	public void decrementar(){
		this.valor--;
	}

	public void resetear(){
		this.valor = this.valorInicial;
	}
	
	public String toString(){
		return ""+this.valor;
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		DispositivoContador contador = new DispositivoContador();
		contador.incrementar();
		contador.incrementar();
		System.out.println("Valor del contador" + contador);
	}

}