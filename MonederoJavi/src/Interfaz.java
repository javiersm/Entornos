

import java.util.Scanner;

public class Interfaz {
	
	private Cash cash;
	private Item item;
	private ContenedorDistribuidor contenedor;
	private Scanner teclado;
	
	
	public Interfaz() {
		
		this.cash = new Cash();
		this.item = new Item();
		this.contenedor = new ContenedorDistribuidor();
		this.teclado = new Scanner(System.in);
		
	}
	
	
	
	public Cash getCash() {
		return cash;
	}

	public void setCash(Cash cash) {
		this.cash = cash;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public ContenedorDistribuidor getContenedor() {
		return contenedor;
	}

	public void setContenedor(ContenedorDistribuidor contenedor) {
		this.contenedor = contenedor;
	}

	public Scanner getTeclado() {
		return teclado;
	}

	public void setTeclado(Scanner teclado) {
		this.teclado = teclado;
	}
	
	

	private void initMonedero(){
		//Recargo el monedero
		System.out.print("** ACTUALMENTE LA MAQUINA NO TIENE CAMBIO **");
		System.out.print("\na continuación vamos a rellenar el cajetín de las monedas\n");
		char eleccion;
		do{
			System.out.print("\n¿Desea rellenarlo Automaticamente o Manualmente?: [A/M]");
			 eleccion = teclado.next().toLowerCase().charAt(0);
		}while(eleccion!='a' && eleccion!='m');
		
		int[] monedas = {1,1,1,1,1};
		switch(eleccion)
		{
			case 'a': 
				//recargo la maquina con un array de monedas que le paso yo
				cash.setMonedas(monedas);
				break;
			
			case 'm':
				monedas = new int[cash.getMonedas().length];
				System.out.println();
				for ( int i=0; i < cash.getValor().length; ++i ) {
					System.out.printf("Introduzca cantidad de monedas de %d céntimos: ", cash.getValor()[i]);
					monedas[i] = teclado.nextInt();
				}
				cash.setMonedas(monedas);
				break;		
		}
		cash.showCoins(); //muestro las monedas
		//pulsaUnaTeclaParaContinuar();
	}
	
	
	private void initContenedorItems(){
		this.item.llenarContenedor("Coca Cola", 80, this.cash, this.contenedor);
		this.item.llenarContenedor("Fanta", 90, this.cash, this.contenedor);
		this.item.llenarContenedor("Kit Kat", 100, this.cash, this.contenedor);
		this.item.llenarContenedor("Palmera", 65, this.cash, this.contenedor);
	}
	
	public int menuPrincipal()
	{
		boolean continuar=false;
		int opcion;
		do{
			System.out.printf("\n\n");
			System.out.printf("\n ______ Elige un número de Opción ________________");
			System.out.printf("\n|_________________________________________________|");
			System.out.printf("\n|%49s|","");
			System.out.printf("\n|%4s: %.29s %26s|","1","Comprar Producto","" );
			System.out.printf("\n|%4s: %.29s %29s|","2","Ver Productos","" );
			System.out.printf("\n|%4s: %.29s %21s|","3","Ver Monedas en Hopper","");
			System.out.printf("\n|%4s: %.29s %37s|","4","Salir","");
			System.out.printf("\n|_________________________________________________|");
			System.out.println("\nOpción: ");
			
			opcion = this.teclado.nextInt();
			if(opcion>0 && opcion<=4){
				continuar=true;
				System.out.println("Has Elegido la opción: "+ opcion);
			}
			else
				System.out.println("Opcion Elegida es incorrecta. Elige una opcíon correcta");
		}while(!continuar);
		return opcion;
	}
	

	
	
	public void buy()
	{	
		char eleccion;
		int numProducto = 0;
		if(!this.contenedor.estaVacio())
		{
			
			System.out.println("Elige el producto que quieres comprar: ");
			this.contenedor.listarProductos();
			do{
			
				do{
					System.out.printf("\n\n¿Qué producto quiere comprar?");
					 eleccion = teclado.next().toLowerCase().charAt(0);
				}while(!Character.isDigit(eleccion));
			
			}while(this.contenedor.getIndice()>=eleccion);
			
			numProducto = Character.getNumericValue(eleccion);
			//System.out.println("NUM PRODUCTO"+numProducto);
			
			//numProducto=2;
			System.out.printf("\nA elegido %s, su precio es de %d cents.", 
					this.contenedor.obtenerNombreItemDispensable(numProducto),	
					this.contenedor.obtenerPrecioItemDispensable(numProducto));

			
			//EL USUARIO INTRODUCE LAS MONEDAS
			boolean inputInvalido=false;
			int input =0;
			do 
			{	
				inputInvalido = false;
				if (this.cash.getAmount() < this.contenedor.obtenerPrecioItemDispensable()) 
				{	
					System.out.print("\nInserte moneda (5-10-20-50-100 cent): ");
					input = this.teclado.nextInt();
					
					switch (input) {						
						case 5:  case 10:  case 20:  case 50:  case 100:
							this.cash.addCash(input);
							this.cash.verCredito();
							break;
						default: 
							System.out.println("Has introducido un importe incorrecto.");
							inputInvalido = true;
					}	
				}					
			} while ((this.cash.getAmount() < this.contenedor.obtenerPrecioItemDispensable()) || inputInvalido);
			
			
			//HAGO LA ENTREGA DEL PRODUCTO
			do 
			{	
				do{
					System.out.printf("\n\nVa a comprar %s por %d cents. ¿Quiere continuar?: [s/n]", 
							this.contenedor.obtenerNombreItemDispensable(numProducto),	
							this.contenedor.obtenerPrecioItemDispensable(numProducto));
					 eleccion = teclado.next().toLowerCase().charAt(0);
				}while(eleccion!='s' && eleccion!='n');
				
				if(eleccion == 's') //compra el producto
				{	
					this.contenedor.getItems()[numProducto].vender(numProducto);
					//this.cash.verCredito();
					System.out.println("GRACIAS POR SU COMPRA");
				}
				else if(eleccion == 'n'){  //no compra el producto
					
					if(this.cash.getAmount() > 0 && this.cash.siHayCambio(this.cash.getAmount()))								
						this.cash.retornarCash(this.cash.getAmount());
					else System.out.println("MAQUINA SIN CAMBIO.");
					
					System.out.println("Devolviendo el Cambio. Gracias por su visita");
				}
			} while (inputInvalido);
			
			
			
			//System.out.println("INDICE"+ this.contenedor.getIndice());
		}else{
			System.out.println("LA MAQUINA NO TIENE PRODUCTOS");	
		}
		
	}
	
	public void pulsaUnaTeclaParaContinuar()
	{
		System.out.println("Introduce un caracter para continuar");
		String tmp = this.teclado.next();
	}

	
	

	public static void main(String[] args) {
		
		Interfaz interfaz = new Interfaz();
		interfaz.initMonedero();
		interfaz.initContenedorItems();
		//interfaz.comprar();	
		
		
		boolean continuaCompra = true;
		while(!interfaz.contenedor.estaVacio() && continuaCompra)
		{
				int totalIntroducido=0;
				int numProducto=0;
				String tmp="";//variable auxiliar para el switch
				switch(interfaz.menuPrincipal())
				{
					
					case 1:  //COMPRAR PRODUCTO
						interfaz.buy();
						break;
					
					case 2: //ver los productos en la maquina
						System.out.println("Listar Productos");
						interfaz.contenedor.listarProductos();
						System.out.println("\nIntroduce un caracter para continuar");
						tmp = interfaz.teclado.next();
						break;
						
					case 3: //ver monedas en el hopper (terminado)
						interfaz.cash.showCoins();						
						interfaz.pulsaUnaTeclaParaContinuar();
						break;
					
						
					case 4: //Salir (terminado)
						System.out.println("Hasta Pronto!");
						System.exit(0);
						break;
					
					default: break;
				}
			
		}
		System.out.println("GRACIAS POR TU COMPRA. ESPERAMOS VOLVER A VERLE PRONTO! ");
		

	}

}


