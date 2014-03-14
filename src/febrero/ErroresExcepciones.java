package febrero;

import java.io.IOException;

public class ErroresExcepciones {

	
	public static int numero(String s) throws NumberFormatException{
		int n=0;
		try{
			n = Integer.parseInt(s);
		}catch(NumberFormatException nfe){
			n = 0;
			throw nfe;
		}
		return n+1;
	}
	
	
	public static char leer() throws IOException{
		int c = 0;
		System.out.println("Escribe un caracter ");
		c = System.in.read();
		return (char) c;
	}
	
	
	
	public static void main(String[] args) throws IOException {
	/*
		String s = "2";	
		try{
			System.out.println( ErroresExcepciones.numero(s) );
			System.out.println(ErroresExcepciones.leer());
		}catch(NumberFormatException e){
			System.out.println("Cadena no valida. "+ e.getMessage());
		}catch(IOException io){
			System.out.println("Input no valido. " + io.getMessage());
		}
	*/
		String str1 = "12";
		String str2 = "0";
		String resp;
		
		int numerador, denominador, cociente;
		try{
			numerador = Integer.parseInt(str1);
			denominador = Integer.parseInt(str2);
			cociente = numerador / denominador;
			resp = String.valueOf(cociente);
		}catch(NumberFormatException e){ //excepciones q no son numeros
			resp = "valores numericos NO validos. "; 
		}catch(ArithmeticException e){
			resp = "Division por cero";
		}
		System.out.println(resp);
	
	}
	
	
	
	

}
