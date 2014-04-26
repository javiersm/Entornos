
import java.util.Scanner;

public class Item {
	
	//Atributos
	private String nombre;
	private int precio;
	private Cash monedero;
	private ContenedorDistribuidor contenedor;
	

	public Item() {
		// TODO Auto-generated constructor stub
	}
	
	public Item(String nombre, int precio) {

		this.nombre = nombre;
		this.precio = precio;
	}
	
	//Accesadores	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Cash getMonedero() {
		return monedero;
	}

	public void setMonedero(Cash monedero) {
		this.monedero = monedero;
	}	
	
	public ContenedorDistribuidor getContenedor() {
		return contenedor;
	}

	public void setContenedor(ContenedorDistribuidor contenedor) {
		this.contenedor = contenedor;
	}
	
	
	//Servicios

	public void display() {
		System.out.println(this.nombre+"\t"+this.precio);
	}
	
	
	
	
	
	public boolean vender(int numProducto) {
		boolean rsp = false;
		Scanner teclado = new Scanner(System.in);
		
		
		int suCambio = this.monedero.getAmount() - this.precio;
		
		if(this.monedero.siHaySuficienteCash(this.precio) && this.contenedor.siItemEsDispensable(this, numProducto)) 
		{				
			
			if ( !(this.monedero.siHayCambio(this.monedero.getAmount() - this.precio))) 
			{
				char eleccion;
				do{
					
					System.out.print("EN ESTOS MOMENTOS NO HAY CAMBIO. ¿Desea continuar [s/n]? ");
					 eleccion = teclado.next().toLowerCase().charAt(0);
					 
				}while(eleccion!='s' && eleccion!='n');
								
				if(eleccion == 's') 
				{	
					this.monedero.hacerCambio(this.precio);this.contenedor.distribuir(this);
				}
				else if(eleccion == 'n'){  
					this.monedero.retornarCash(this.monedero.getAmount());
				}
						
			//si hay cambio hace esto	
			} else {				
				 this.contenedor.distribuir(this);
				 this.monedero.hacerCambio(this.precio);	
				 System.out.println("Su cambio es: " + suCambio + "cent.");
			}
			
			rsp = true;
		}
	
		return rsp;		
	}
	
	
	
	public void llenarContenedor(String nombre, int precio, Cash cash, ContenedorDistribuidor contenedor) {
		
		Item item = new Item(nombre, precio);
		item.setContenedor(contenedor);
		item.setMonedero(cash);
		contenedor.addItem(item);
		
	}

}
