

public class ContenedorDistribuidor {
	//Atributos
	private Item[]items;
	private int indice;
	
	//Constructores
	public ContenedorDistribuidor() {
		items=new Item[10];
		indice=0;
	}

	//Accesadores
	public Item[] getItems() {
		return items;
	}

	public int getIndice() {
		return indice;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}
	
	//Servicios
	public boolean estaVacio(){
		boolean rsp=false;
		if(indice==0){
			rsp=true;
		}
		return rsp;
	}
	
	public void addItem(Item item){
		items[indice]=item;
		indice++;
	}
	/*
	public boolean siItemEsDispensable(Item item){
		if(!this.estaVacio() && item.equals(this.items[0])){
			return true;
		}
		return false;
	}*/
	public boolean siItemEsDispensable(Item item){
		if(!this.estaVacio() && item.getCantidad()>0){
			return true;
		}
		return false;
	}
	
	public String obtenerNombreItemDispensable(){
		if (!this.estaVacio()){
			return this.items[0].getNombre();
		}
		return "Empty";
	}
	
	public double obtenerPrecioItemDispensable(){
		if (!this.estaVacio()){
			return this.items[0].getPrecio();
		}
		return 0.0;
	}
	
	public void despacharItem(){
		//Activar el circuito de Dispensacion del Item
		System.out.println(this.obtenerNombreItemDispensable() + " ha sido distribuido");
	}
	
	public void distribuir(Item item){
		this.despacharItem();
		for(int i=0;i<this.items.length-1;++i){
			this.items[i]=this.items[i+1];  //Hacemos caer los botes una posicion
		}
		this.indice--;
	}
	
	
	/** METODOS HECHOS POR MI
	 * 
	 * @param productNum
	 * @return
	 */
	
	public String obtenerNombreItemDispensable(int numProducto){
		if (!this.estaVacio()){
			return this.items[numProducto].getNombre();
		}
		return "Empty";
	}
	
	public double obtenerPrecioItemDispensable(int numProducto){
		if (!this.estaVacio()){
			return this.items[numProducto].getPrecio();
		}
		return 0.0;
	}
	
	
	public boolean isDispensable(int productNum){
		if(!this.estaVacio() && (indice>=productNum) ){   //SI el array no esta vacio y el producto elegido existe
			if(items[productNum].getCantidad()>0) //Y SI la cantidad es mayor a 0 responde ke se puede vender
				return true;
		}
		return false;
	}

	public void menuComprar() {
		System.out.printf("\n\n");
		System.out.printf("\n __________¿Qué producto quieres?_________________");
		System.out.printf("\n|_________________________________________________|");
		System.out.printf("\n|%49s|","");
		System.out.printf("\n| %6s %13s %8s %14s %3s|","NUMERO","NOMBRE","PRECIO","EXISTENCIAS","" );
		for(int i=0;i<indice;i++)
			System.out.printf("\n|%4s: %18s [%02.02f] %7d %9s|",i, items[i].getNombre(),items[i].getPrecio(),items[i].getCantidad(),"");
		System.out.printf("\n|_________________________________________________|");
		System.out.println("\nOpcion:");
	}
	
	public void menuListaProductos() {
		System.out.printf("\n\n");
		System.out.printf("\n __________ Lista de Productos ___________________");
		System.out.printf("\n|_________________________________________________|");
		System.out.printf("\n|%49s|","");
		System.out.printf("\n| %6s %13s %8s %14s %3s|","NUMERO","NOMBRE","PRECIO","EXISTENCIAS","" );
		for(int i=0;i<indice;i++)
			System.out.printf("\n|%4s: %18s [%02.02f] %7d %9s|",i, items[i].getNombre(),items[i].getPrecio(),items[i].getCantidad(),"");
		System.out.printf("\n|_________________________________________________|");
	}
	

	public static void main(String[] args) {
		

	}

}
