
public class Depurador {

	/*
	   - Depurador (Es el boton que esta al lado de run que sale un bicho)
	   - Con la tecla "F5" vamos dando pasos
	   - Dando doble click izq en la zona azul de este recuadro podemos poner breaks
	*/
	public static void main(String[] args) {
		
		int a = 5;
		System.out.println("El valor de a es: " + a);
		for (int i=0; i<3; ++i){
			++a;
			System.out.println("El valor de a es: " + a + "\t");
		}
		System.out.println("\nFinal del programa");
	}

}
