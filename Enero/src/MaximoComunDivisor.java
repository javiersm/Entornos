
import java.util.*;


/*
*  CREAR UNA FUNCION Q CALCULE EL MAYOR DIVISOR DE 2 NUMEROS DADOS
*/
public class MaximoComunDivisor {


	
	
	public static int mcd(int aa, int bb) {
		int a = aa;
		int b = bb;
		int divisor = 0;
		//buscamos el menor de los dos numeros
		if(a < b){
			divisor = a;
		}else{
			divisor = b;
		}
		
		//buscamos el mayor divisor
		while(a%divisor!=0 || b%divisor!=0){
			--divisor; //buscamos el siguiente divisor
		}
		return divisor;
	}
	
	public static int minimoComunMultiplo(int aa, int bb){
		int multiplo = 0;
		if(aa > bb){
			multiplo = aa;
		}else{
			multiplo = bb;
		}
		while(multiplo%aa!=0 || multiplo%bb !=0){
			++multiplo;
		}
		return multiplo;
	}
	

	public static void main(String[] args) {
		//leer 2 numeros enteros positivos mayores q 0 desde el teclado
		// y calcular su maximo comun divisor
		Scanner teclado = new Scanner(System.in);
		
		int a=0;
		int b=0;
		
		do{
			System.out.println("Escribe un numero entero positivo");
			a = teclado.nextInt();
		}while(a <= 0);
		do{
			System.out.println("Escribe un numero entero positivo");
			b = teclado.nextInt();
		}while(b<=0);
		
		System.out.println("El mcd de a:"+ a + " y b: "+ b + " es " + MaximoComunDivisor.mcd(a, b));
		System.out.println("El minimo comun multiplo de a:"+ a + " y b: "+ b + " es " + MaximoComunDivisor.minimoComunMultiplo(a, b));
		
		teclado.close();
	}

}
