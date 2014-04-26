import java.util.Scanner;


/** CLASE PRINCIPAL QUE CONTROLA LAS DEMAS CLASES
 * 
 * @author JS
 *
 */

public class Interfaz {
	
	private static Scanner teclado = new Scanner(System.in);
	private static boolean continuaCompra = true; //cn esta variable compruebo si quiere seguir comprando
	private static boolean comprar = false; 		  //para comprobar si lo quiere comprar
	public static Cash monedero = new Cash();			  //creo el monedero q llevara el calculo de las monedas
	public static ContenedorDistribuidor contenedor = new ContenedorDistribuidor(); //el conteneder de Items q tiene la maquina
	public static Item[] item = contenedor.getItems();
	
	
	private static void initMonedero(){
		//Recargo el monedero
		System.err.print("** ACTUALMENTE LA MAQUINA NO TIENE CAMBIO **");
		System.err.print("\na continuación vamos a rellenar el cajetín de las monedas\n");
		char eleccion;
		do{
			System.err.print("\n¿Desea rellenarlo Automaticamente o Manualmente?: [A/M]");
			 eleccion = teclado.next().toLowerCase().charAt(0);
		}while(eleccion!='a' && eleccion!='m');
		
		int[] monedas = {1,1,1,1,1};
		switch(eleccion)
		{
			case 'a': 
				//recargo la maquina con un array de monedas que le paso yo
				monedero.setMonedas(monedas);
				break;
			
			case 'm':
				monedas = new int[monedero.getMonedas().length];
				System.out.println();
				for ( int i=0; i < monedero.getValor().length; ++i ) {
					System.out.printf("Introduzca cantidad de monedas de %d céntimos: ", monedero.getValor()[i]);
					monedas[i] = teclado.nextInt();
				}
				monedero.setMonedas(monedas);
				break;		
		}
		monedero.showCoins(); //muestro las monedas
		//pulsaUnaTeclaParaContinuar();
	}
	
	
	private static void initContenedorItems(){
		contenedor.addItem(new Item("Coca Cola",0.8, 2));
		contenedor.addItem(new Item("Fanta", 0.90, 5));
		contenedor.addItem(new Item("Kit Kat", 1.00, 0));
		contenedor.addItem(new Item("Palmera Chocolate", 0.65, 3));
		item = contenedor.getItems();
	}
	
	
	
	public static int menuPrincipal()
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
			System.out.printf("\n|%4s: %.29s %27s|","4","Añadir Producto","");
			System.out.printf("\n|%4s: %.29s %15s|","5","Modificar Cantidad Producto","");
			System.out.printf("\n|%4s: %.29s %37s|","6","Salir","");
			System.out.printf("\n|_________________________________________________|");
			System.out.println("\nOpción: ");
			
			opcion = teclado.nextInt();
			if(opcion>0 && opcion<6){
				continuar=true;
				System.out.println("Has Elegido la opción: "+ opcion);
			}
			else
				System.out.println("Opcion Elegida es incorrecta. Elige una opcíon correcta");
		}while(!continuar);
		return opcion;
	}
	
	
	public static void pulsaUnaTeclaParaContinuar()
	{
		Scanner teclado1 = new Scanner(System.in);
		System.out.println("Introduce un caracter para continuar");
		String tmp = teclado1.next();
	}
	
	
	
	public static void main(String[] args) {
			
		initMonedero();
		initContenedorItems();
		
		continuaCompra = true;
		while(!contenedor.estaVacio() && continuaCompra)
		{
				int totalIntroducido=0;
				int numProducto=0;
				String tmp="";//variable auxiliar para el switch
				switch(menuPrincipal())
				{
					
					case 1:  //COMPRAR PRODUCTO
						contenedor.menuComprar();
						numProducto = teclado.nextInt();
						if(contenedor.isDispensable(numProducto))
						{
							
							//monedero.showCoins();
							System.out.printf("Va a comprar  %s  a: %.2f €", contenedor.obtenerNombreItemDispensable(numProducto), contenedor.obtenerPrecioItemDispensable(numProducto));
							char eleccion;
							do{
								System.out.print("\n¿Desea adquirir el producto indicado [s/n]?");
								 eleccion = teclado.next().toLowerCase().charAt(0);
							}while(eleccion!='s' && eleccion!='n');
							
							if(eleccion == 's'){	//compra el producto
								comprar = true;
							}else if(eleccion == 'n'){  //no compra el producto
								continuaCompra = false; //hemos teminado de comprar;
								comprar = false;
								System.out.println("Fin compra.");
								break;
							}
							
							//gestiono lo que tiene que introducir el usuario
							boolean monedaInvalida = false;
							if (comprar) 
							{	
								System.out.println("Entrando en menu introducir monedas");
								do 
								{									
									monedaInvalida = false;
									//System.out.println("amount" + monedero.getAmount());
									//System.out.println("precioitem"+(contenedor.obtenerPrecioItemDispensable(numProducto)*100));
									if (monedero.getAmount() < (contenedor.obtenerPrecioItemDispensable(numProducto)*100)) 
									{										
										System.out.print("Inserte moneda (5 - 10 - 20 - 50 - 100): ");
										int monedasIntroducidas = teclado.nextInt();	
										switch (monedasIntroducidas) {						
											case 5:  case 10:  case 20:  case 50:  case 100:
												monedero.addCash(monedasIntroducidas);
												monedero.creditoUsuario();
												break;
											default: 
												System.out.println("Moneda no válida.");
												monedaInvalida = true;
										}										
									}	
									
								}while (monedero.getAmount() < (contenedor.obtenerPrecioItemDispensable(numProducto)*100) || monedaInvalida);
									
							} 
								
							//SI QUIERE LA COMPRA.  CALCULO EL CAMBIO 
							if(monedero.getAmount() >= (contenedor.obtenerPrecioItemDispensable(numProducto)*100) )
							{/*
								//char eleccion;
								do{
									System.out.print("\nCantidad Introducida Correcta ¿Seguro de adquirir el producto? [s/n]");
									 eleccion = teclado.next().toLowerCase().charAt(0);
								}while(eleccion!='s' && eleccion!='n');
								
								if(eleccion == 's'){	//compra el producto
									System.out.println("Calculando el cambio");
								}else if(eleccion == 'n'){  //no compra el producto
									System.out.println("Cancelando la compra. Exit Menu.");
									break;
								}
								*/
								boolean respuestaIncorrecta = false;
								do {
									 respuestaIncorrecta= false;
									System.out.printf("Pulse 1 para comprar su %s, 2 para recuperar su dinero: ", contenedor.obtenerNombreItemDispensable(numProducto));
									
									switch (teclado.nextInt()) {
										
										case 1:	System.out.println("numproducto:" + numProducto); 
												Item[] items = contenedor.getItems();
												//System.out.println("prueba" + items[numProducto].getNombre() + items[numProducto].getPrecio()); 
												items[numProducto].vender(); 
												monedero.creditoUsuario(); 
												break;
										case 2: 									
												if(monedero.getAmount() > 0 && monedero.siHayCambio(monedero.getAmount()))								
														monedero.returnCash();
												else System.out.println("MAQUINA SIN CAMBIO");
												break;							
										default: System.out.println("Debe pulsar 1 ó 2. Inténtelo de nuevo."); respuestaIncorrecta = true;
									}
									
								} while (respuestaIncorrecta);
								
								
							}else{
								System.out.println("Error. Has introducido menos de la cantidad que vale el producto");
								
							}
							
							//cash.showCoins();
						}
						else System.out.println("ERROR. EL PRODUCTO" + numProducto + "NO ESTÁ DISPONIBLE o SE ENCUENTRA AGOTADO");
						System.out.println("GRACIAS POR SU COMPRA.");
							break;
					
					case 2: //ver los productos en la maquina
						System.out.println("Ver Productos");
						contenedor.menuListaProductos();
						System.out.println("\nIntroduce un caracter para continuar");
						tmp = teclado.next();
						break;
						
					case 3: //ver monedas en el hopper (terminado)
						monedero.showCoins();						
						pulsaUnaTeclaParaContinuar();
						break;
						
					case 4: //agregar un producto
						System.out.println("\nIntroduce el nombre del producto que quieres añadir: ");
						tmp="";
						tmp = teclado.next();
						System.out.println("Introduce la cantidad: ");
						int n = teclado.nextInt();
						if(n>=0){
							
						}else{
							System.out.println("ERROR. cantidad debe ser mayor o igual que 0");
							break;
						}
						System.out.println("Introduce el precio: ");
						double precio = teclado.nextDouble();
						//dispensador.addItem(new Item(tmp, precio, n));
						break;
						//new Item(nombre, precio, cantidad)
						
						/*
					case 5: //Cambiar la cantidad de un producto (terminado)
						System.out.println("\n\n");
						contenedor.menuListaProductos();						
						System.out.println("\n\n¿Que producto quieres cambiar? (numProducto)");
						numProducto = teclado.nextInt();
						if(dispensador.existe(numProducto)){
							
						}else{
							System.out.println("ERROR. ese producto no existe!");
							break;
						}
						System.out.println("\nIntroduce la cantidad de producto");
						int cantidad = teclado.nextInt();
						if(cantidad>=0){
							
						}else{
							System.out.println("ERROR. cantidad introducida debe ser mayor que 0");
							break;
						}
						contenedor.setCantidadProducto(numProducto, cantidad);
						System.out.println("Cambio Realizado!");
						dispensador.showItems();
						break;
						*/
					case 6: //Salir (terminado)
						System.out.println("Hasta Pronto!");
						teclado.close();
						System.exit(0);
						break;
					
					default: break;
				}
			
		}
		System.out.println("GRACIAS POR TU COMPRA. ESPERAMOS VOLVER A VERLE PRONTO! ");
		

	}

}
