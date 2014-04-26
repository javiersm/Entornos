
public class LeerConsolaINTERESANTE {

	private final static int EOF = -1;
	
	public static String read(){
		String linea = "";
		int car=0;
		
		try {
			while((car = System.in.read()) != LeerConsolaINTERESANTE.EOF )
			{ if(car == 10 || car == 13)//es el codigo que representa el final de la lina en windows
				{
					break;
				}	
				linea += (char) car;
			}
			//VACIAR EL BUFFER DE ENTRADA DEL TECLADO (SIGNIFICA QUE VACIA LO QUE RECOGE EL S.O.)
			System.in.skip(System.in.available());
		} catch (Exception e) {
			System.out.println(e);
		}
		return linea;
	}
	
	/*
	 * Calcular la fecha del día despues
	 * leer dd mm aa
	 * Transformar la fecha dd, mm, aa EN=> da, aa:
	 * Sumamos todos los dias de los meses anteriores al de la fecha (mm)
	 * sumamos los dias del mes
	 * Ya tengo los dias del año
	 */
	
	
	private final static int[][]calendario = {
		{0,31,28,31,30,31,30,31,31,30,31,30,31},
		{0,31,29,31,30,31,30,31,31,30,31,30,31}};
	
	public static void main(String[] args) {
		
		/*String mensaje = "";
		System.out.println("Escribe una linea");
		mensaje = LeerConsolaINTERESANTE.read();
		System.out.println("Linea:" + mensaje);*/
		
		int dd = 0;
		int mm = 0;
		int aa = 0;
		int da = 0;
		int bi = 0;
		String entrada = "";
		
		//leer la fecha
		System.out.println("Escribe el dia dd:");
		entrada = LeerConsolaINTERESANTE.read();
		dd = Integer.parseInt(entrada);
		
		System.out.println("Escribe el mes mm:");
		entrada = LeerConsolaINTERESANTE.read();
		mm = Integer.parseInt(entrada);
		
		System.out.println("Escribe el año aa:");
		entrada = LeerConsolaINTERESANTE.read();
		aa = Integer.parseInt(entrada);
		
		//Calcular si el año es bisiesto
		if (aa%4 == 0 && aa%100 != 0 || aa%400 == 0)
		{
			bi = 1; //año bisiesto
		}
		//Calcular el dia del año
		for (int m = 1; m < mm; ++m){
			da += LeerConsolaINTERESANTE.calendario[bi][m];
		}
		da += dd;
		System.out.println("Dia del año:" + da);
		
		
		
		
		
	}

}
