
public class ContenedorDistribuidor {
	
	//Atributos
	
	private Item[] items;
	private int indice;
	//Constructor

	public ContenedorDistribuidor() {
		
		this.items = new Item[10];
		this.indice = 0;
	}
	
	//Accesadores	

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	//Servicios
	
	public boolean estaVacio() {
		
		boolean rsp = false;
		if(this.indice == 0) {
			rsp = true;
		}
		return rsp;
	}
	
	public void addItem( Item item ) {
		
		this.items[this.indice++] = item; //primero asigna y después incrementa índice.
	}
	
	public boolean siItemEsDispensable( Item item) {
		if(!this.estaVacio() && item.equals(this.items[0]))
			return true;
		else
			return false;
	}
	//modificado
	public boolean siItemEsDispensable( Item item, int numProducto) {
		if(!this.estaVacio() && item.equals(this.items[numProducto]))
			return true;
		else
			return false;
	}
	
	public String obtenerNombreItemDispensable() { //obtiene el nombre del item que ocupa la posición 0.
		if(!this.estaVacio())
			return this.items[0].getNombre();
		else
			return "Empty";		
	}
	//modificado
	public String obtenerNombreItemDispensable(int numProducto) { //obtiene el nombre del item que ocupa la posición 0.	
		if(!this.estaVacio())
			return this.items[numProducto].getNombre();
		else
			return "Empty";		
	}
	
	public int obtenerPrecioItemDispensable() {	
		if(!this.estaVacio())
			return this.items[0].getPrecio();
		else
			return 0;	
	}
	//modificado
	public int obtenerPrecioItemDispensable(int numProducto) {	
		if(!this.estaVacio())
			return this.items[numProducto].getPrecio();
		else
			return 0;	
	}
	
	public void despacharItem() {
	//activar el circuito de dispensación del item
		System.out.println(this.obtenerNombreItemDispensable() + " ha sido dispensado");
	}
	
	public void distribuir( Item item ) {
		this.despacharItem();
		for(int i=0; i < this.items.length-1; ++i) {
			this.items[i] = this.items[i+1];
		}
		this.indice--;
	}
	

	
	public void listarProductos() {
		
		System.out.printf("\n\n");
		System.out.printf("\n __________ Lista de Productos ___________________");
		System.out.printf("\n|_________________________________________________|");
		System.out.printf("\n|%49s|","");
		System.out.printf("\n| %6s %14s %18s %4s %2s|","NUMERO","NOMBRE","PRECIO","","" );
		for(int i=0;i<this.items.length;i++)
		{
			if(items[i]!=null)
			System.out.printf("\n|%4s: %18s %10s [%3d] %7s|",i , this.items[i].getNombre(), "",this.items[i].getPrecio(),"");
		}	
		System.out.printf("\n|_________________________________________________|");
	}

}
