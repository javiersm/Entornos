
public class Item {

	//Atributos
	private String nombre;
	private double precio;
	private Cash monedero;
	private ContenedorDistribuidor contenedor;
	private static int cantidad;  //cantidad
	
	//Constructores
	public Item() {
		
	}
	public Item(String nombre, double precio, int cantidad) {
		this.nombre=nombre;
		this.precio=precio;
		this.cantidad=cantidad;
	}
	
	//Accesadores
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public Cash getMonedero() {
		return monedero;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setMonedero(Cash monedero) {
		this.monedero = monedero;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	//Servicios
	public void display(){
		System.out.println(this.nombre + "\t" + this.precio);
	}
	
	public boolean vender(){
		System.out.println("item.vender");
		boolean rsp = false;
		System.out.println("THIS.PRECIO:" + ((int)(this.precio*100)));
		
		if(Interfaz.monedero.siHaySuficienteCash(this.precio) && Interfaz.contenedor.siItemEsDispensable(this))
		{
			System.out.println("suficiente money");
			Interfaz.monedero.hacerCambio((int)this.precio*100);
			
			if(this.cantidad>0){
				System.out.println("resto 1 a la cantidad");
				//this.cantidad--;
				Interfaz.contenedor.distribuir(this);
			}
			else{
				System.out.println("borro el item");
				Interfaz.contenedor.distribuir(this);
			}
			
			rsp=true;
		}
		return rsp;
	}
	
	public void llenarContenedor(String nombre, double precio, Cash cash, ContenedorDistribuidor contenedor){
		Item item = new Item (nombre, precio, cantidad);
		item.setMonedero(cash);
		contenedor.addItem(item);
	}
	
	public static void main(String[] args) {
		/*
		Cash cash = new Cash();
		//cash.setCantidad(1.6);
		cash.setTotal(160);
		ContenedorDistribuidor contenedor = new ContenedorDistribuidor();
		
		Item bote = new Item();
		bote.llenarContenedor("CocaCola", 0.80, cash, contenedor);
		bote.llenarContenedor("PepsiCola", 0.80, cash, contenedor);
		
		while(!contenedor.estaVacio() && contenedor.getItems()[0].vender()){
		}
		*/
		
	}



}
