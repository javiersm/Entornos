
public class NumerosPrimos {

	
	/* Muestra los numeros primos que hay del 1 al 100
	 * Mientras no haya terminado con el rango de números hacer
	 *     - Si el numero es primo entonces
	 *     		* escribir numero
	 *   	finsi
	 * finMientras
	 */
	
	public static boolean primo(int numero){
		boolean respuesta = true;
		int divisor = numero -1;
		
		if(numero == 1){
			respuesta = true;
		}else{
			while(divisor > 0 && numero%divisor != 0){
				--divisor;
			}
		}
		
		if(divisor == 1 || numero ==1){
			respuesta = true;
		}else{
			respuesta = false;
		}
		return respuesta;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("**** NUMEROS PRIMOS DEL 1 AL 100 ****");
		for(int numero=1; numero<= 100; ++numero){
			if(NumerosPrimos.primo(numero) == true){
				System.out.print(numero + "\t");
			}
		}
		
		System.out.println("\n\n**** IMPRIMIR LOS 100 PRIMEROS NUMEROS PRIMOS ****");
		int numPrimoCount = 0;
		int num = 1;
		do{
			if(NumerosPrimos.primo(num)){
				System.out.print(num + "\t");
				if(numPrimoCount%10 == 0){
					System.out.print("\n");
				}					
				num++;
				numPrimoCount++;
			}else{
				num++;
			}
			
		}while(numPrimoCount <=100);
		

	}

}
