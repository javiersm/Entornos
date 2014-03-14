package enero;
import java.util.Scanner;

import com.sun.xml.internal.ws.api.pipe.NextAction;


public class FactorialNumero {
	//Factorial de un numero dado
	//!n = n*(n-1)*(n-2)*.....2*1
	//Utilizar dos metodos uno iterativo  otro recursivo
	

	//Metodo Iterativo
	public static int factorialIterativo(int n){
		int resultado = 1;
		for(int i= n; i>0; i--){
			resultado *= i; 
		}
		return resultado;
	}
	
	
	//Metodo Recursivo
	//!n = n * !(n-1)
	public static int factorialRecursivo(int n){
		if(n == 1){
			return n;
		}
		else{
			return(n * FactorialNumero.factorialIterativo(n-1));
		}
			
		
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n=0;
		System.out.println("Escriibe un numero entero y positivo ");
		n = sc.nextInt();
		
		System.out.println("El factorial de" + n + "es: " + FactorialNumero.factorialRecursivo(n));
		
		
		sc.close();
	}

}
