package octubre;

public class Vectores {

	public static void main(String[] args) {
		// Dado un numero entre 1 y 12 escribir el nombre del mes
		
		
		String[] meses = {"nul", "enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
		int[] dias= {0,31,28,31,30,31,30,31,31,30,31,30,31};
		int mes = 0;
		String nombre = "";
		nombre = "abr";
		
		//Generamos el 
		mes = (int) (1 + (Math.random() * 12)); //random number entre 1 y 12
		System.out.println(mes);
		//Buscar el nombre en el vector meses
		for(int i=1; i < meses.length; ++i){
			if(nombre.equalsIgnoreCase(meses[i]) == true){
				System.out.println("Los dias del mes " + nombre + " son : " + dias[i]);
				break;
			}
		
		}

	}

}
