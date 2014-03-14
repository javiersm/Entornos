package enero;
/** @author JS
 * El problema de las ocho reinas es un pasatiempo en el que se colocan ocho reinas sin que se amenacen. 
 * Fue propuesto por el ajedrecista alemán Max Bezzel en 1848[cita requerida]. 
 * En el juego del ajedrez la reina amenaza a aquellas piezas que se encuentren en su misma fila, columna o diagonal. 
 * El juego de las 8 reinas consiste en colocar sobre un tablero de ajedrez ocho reinas sin que estas se amenacen entre ellas. 
 * Para resolver este problema emplearemos un esquema vuelta atrás (o Backtracking).
 */


public class OchoReinas {
	/* ***** Algoritmo ********
	 * ensayar(reina)
	 * begin
	 * buscar la primera posicion de la reina en la fila
	 * 	Mientras no sea el fin y haya una columna para poner la reina hacer
	 * 	  si la posicion elegida es valida entonces 
	 * 		   - Anotar la posicion
	 * 		 si he colocado la ultima reina entonces
	 * 			- Anotar q he terminado o q es el fin
	 * 			- imprimir el resultado
	 * 		 sino es la ultima reina
	 * 			- ensayar(la siguiente reina)
	 * 			- si no es el final entonces
	 * 					- Eliminar la anotacion de esta reina.
	 * 		finsi
	 * 	  finsi
	 * 		buscar la siguiente posicion de la reina
	 * 	finMientras
	 * end
	 */

	private static int[] reinas = new int[8]; //El valor q guardará cada posicion del array, ES la columna en la que ha acabado cada una de las reinas 
											  // cada posicion del vector[i]=valor  --> 'i' indica la reina y el 'valor' es la columna donde ha terminado la reina 	
	private static boolean[]columnas = {false, false, false, false, false, false, false, false}; //para saber las columnas q estan ocupadas
	
	private static boolean[] diagonalDer =
		{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}; //Aqui se guardan las diagonales derechas
	private static boolean[] diagonalIzq =
		{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false}; //Aqui se guardan las diagonales Izquierda
	
	private static boolean fin = false; //variable para saber si he encontrado una solucion
	
	
	/*** METODOS AUXILIARES */
	public static boolean valida(int fil, int col){ //metodo q valida la posicion
		boolean res = false; //respuesta
		//calculamos el valor de la columna a derecha
		int d = col - fil + OchoReinas.reinas.length -1;  //necesitamos saber el indice de la diagonal a derecha
		int i = col + fil;   //indice de la diagonal a izquierda
		
		//si la columna esta libre y la diagonal esta libre
		if(OchoReinas.columnas[col]==false  &&  OchoReinas.diagonalDer[d]==false && OchoReinas.diagonalIzq[i]==false)
		{
			res = true; 
		}
		return res;
		
	}
	
	public static void anotar(int fil, int col){
		
		int d = col - fil + OchoReinas.reinas.length -1;  //necesitamos saber el indice de la diagonal a derecha
		int i = col + fil;   //indice de la diagonal a izquierda
		
		OchoReinas.columnas[col]=true; //columna ocupada
		OchoReinas.diagonalDer[d]=true;
		OchoReinas.diagonalIzq[i]=true;
		OchoReinas.reinas[fil] = col;
	}

	public static void desanotar(int fil, int col){
		
		int d = col - fil + OchoReinas.reinas.length -1;  //necesitamos saber el indice de la diagonal a derecha
		int i = col + fil;   //indice de la diagonal a izquierda
		OchoReinas.columnas[col]=false; //columna ocupada
		OchoReinas.diagonalDer[d]=false;
		OchoReinas.diagonalIzq[i]=false;
	}
	
	public static void ponerReina(int reina){ //le pasamos el numero de la reina
		int col=0; //empezamos a buscar por la primera columna
		while(OchoReinas.fin==false && (col < OchoReinas.reinas.length)) //mientras no haya colocados todas, y las columnas no hayan llegado al final hacer
		{
			if(OchoReinas.valida(reina, col)==true){
				OchoReinas.anotar(reina, col);
				if(reina == OchoReinas.reinas.length -1){
					OchoReinas.fin = true; //hemos terminado de colocar todas las reinas
					for(int i=0; i<OchoReinas.reinas.length; ++i){
						System.out.println("Reina: " + (i+1)+ " Columna: "+ OchoReinas.reinas[i]+1);
					}
				}
			}else{ //sino es la ultima reina pasamos a la siguiente reina
				OchoReinas.ponerReina(reina+1);
				if(OchoReinas.fin==false){
					OchoReinas.desanotar(reina, col);
				}
			}
		}
		
		
		
	}

	
	
	
	
	public static void main(String[] args) {
		

	}

}
