package Examen12Dic13;

import java.util.Scanner;

public class JavierSantanaMejias {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int dim=20;
		int[]numeros = new int[dim];
		int pos=0, neg=0, cer=0;
		System.out.println("Leer los números desde el teclado y guardarlos en un array: ");
		
		for(int i=0; i<numeros.length;++i){
			System.out.print("numeros["+i+"]");
			//do{
				numeros[i] = sc.nextInt();
				
			//}while(i < numeros.length);
		}
		
		for(int i= 0; i<numeros.length; i++)
		{
			
			if( numeros[i] > 0){
				++pos;
			}
			if(numeros[i] < 0){
				++neg;
			}
			if(numeros[i] == 0){
				++cer;
			}
		}
		System.out.println("Numeros positivos: " +pos );
		System.out.println("Numeros negativos: " +neg);
		System.out.println("Numeros de ceros: " +cer);
		
		
		
	}

}
