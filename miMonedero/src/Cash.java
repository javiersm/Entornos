

public class Cash {

	//Atributos
	private int amount; //valor introducido por el usuario
	private int[]valor={5,10,20,50,100}; //valor en centimos de las monedas
	private int[]monedas; //numero de monedas almacenadas en la maquina
	private int total; //Total del dinero almacenado en la maquina
	private int[]aux; //Monedas que se utilizan en el cambio
	
	//Constructor
	public Cash(){
		amount=0;
		monedas=new int[valor.length];
		total=0;
		aux=new int[valor.length];
	}
	
	//Accesadores
	public int getAmount() {
		return amount;
	}
	public int[] getValor() {
		return valor;
	}
	public int[] getMonedas() {
		return monedas;
	}
	public int getTotal() {
		return total;
	}
	public int[] getAux() {
		return aux;
	}
	public void setAux(int[] aux) {
		this.aux = aux;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public void setValor(int[] valor) {
		this.valor = valor;
	}
	public void setMonedas(int[] monedas) {
		this.monedas = monedas;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	
	//Metodo recursivo: indice hace que empiece primero por las monedas mas grandes
	//total es todo el dinero que tiene la maquina despues de rechazar las monedas grandes en funcion del cambio
	public boolean siHayMonedas(int cambio, int indice, int total ){
		for(int i=this.monedas[indice];i>=0 && cambio <=total; --i){
			if(i*this.valor[indice]>cambio){//si el valor de las monedas es mayor que el cambio no vale 
				continue;					//y lo mandamos al for para probar con otra moneda mas pequeña
			}
			this.aux[indice]=i; // anotamos las monedas de este tipo que vamos a devolver
			if(i*this.valor[indice]==cambio){ //Si es el cambio justo hemos terminado
				return true;
			}
			if(indice>0){ //Si todavia quedan mas monedas
				// Aqui llamamos al mismo metodo: RECURSIVIDAD
				if(this.siHayMonedas(cambio-(i*this.valor[indice]), 
						indice-1, total-(this.monedas[indice]*this.valor[indice]))){
					return true;
				}
			}
			this.aux[indice]=0;
		}
		return false;
	}
	
	public boolean siHayCambio(int cambio){
		iniciarAux();
		return siHayMonedas(cambio, valor.length-1, total);
	}
	
	//Reinicia aux a 0 para operar de nuevo
	private void iniciarAux(){
		for(int i=0;i<aux.length;++i){
			aux[i]=0;
		}
	}
	
	//Metodo para mostrar las monedas devueltas
	private void displayAux(){
		for(int i=0;i<aux.length;++i){
			if(this.aux[i]>0){
				System.out.println("Monedas de " + valor[i] + ": " + aux[i]);
			}
		}
	}
	/* pa borrar luego que lo he hecho mal
	public int getAuxTotal()
	{
		int cantidad = 0;
		for(int i=0; i<aux.length;i++)
			cantidad += (aux[i] * valor[i]);
		//System.out.println("AuxTotal: " + cantidad+" cents.");
		return cantidad;
	}*/
	
	
	public void addCash(int coin){
		switch(coin){
		case 5: amount+=coin; total+=coin; monedas[0]++; break;
		case 10: amount+=coin; total+=coin; monedas[1]++; break;
		case 20: amount+=coin; total+=coin; monedas[2]++; break;
		case 50: amount+=coin; total+=coin; monedas[3]++; break;
		case 100: amount+=coin; total+=coin; monedas[4]++; break;
		}
	}
	
	//Metodo que retorna el dinero que ha introducido el usuario
	public void returnCash(){
		iniciarAux(); 
		if(siHayMonedas(amount, valor.length-1, total)){
			for(int i=0;i<aux.length;++i){
				monedas[i]-=aux[i]; //quitamos las monedas que vamos a devolver
			}
			total-=amount; //actualizo el total de monedas que he devuelto
			amount=0; //cantidad de dinero que me queda para compras
		}
		displayAux(); //metodo que muestra las monedas que va a devolver
	}
	
	public boolean siHaySuficienteDinero(int precio){
		if(this.amount>=precio){
			return true;
		}
		return false;
	}
	public boolean siHaySuficienteCash ( double cantidad ) {
		System.out.println("SI HAY SUFICIENTE CASH");
		System.out.println("CASH.AMOUNT: " + this.amount );
		return (this.amount >= cantidad) ? true : false;
	}
	
	public void hacerCambio(int precio){ //precio es el valor del producto
		amount-=precio;
	}
	
	public void showCoins() {
		System.out.printf("\n ______Monedas en el Monedero_________________");
		System.out.printf("\n|_____________________________________________|");
		System.out.printf("\n|%45s|","");
		System.out.printf("\n|   %6s %9s %8s %15s|","MONEDAS","CANTIDAD","TOTAL","" );
		System.out.printf("\n|   [%02.02f]: %6d %5s %5.02f %15s|",0.05,monedas[0],"=", (monedas[0]*0.05),"" );
		System.out.printf("\n|   [%02.02f]: %6d %5s %5.02f %15s|",0.1,monedas[1],"=", (monedas[1]*0.1),"" );
		System.out.printf("\n|   [%02.02f]: %6d %5s %5.02f %15s|",0.2,monedas[2],"=", (monedas[2]*0.2),"" );
		System.out.printf("\n|   [%02.02f]: %6d %5s %5.02f %15s|",0.5,monedas[3],"=", (monedas[3]*0.5),"" );
		System.out.printf("\n|   [%02.02f]: %6d %5s %5.02f %15s|",1.00,monedas[4],"=", (monedas[4]*1.00),"" );
		System.out.printf("\n|_____________________________________________|" );
		System.out.printf("\n|   %16s  %8s %15s|","TOTAL",((monedas[0]*0.05)+(monedas[1]*0.1)+(monedas[2]*0.2)+(monedas[3]*0.5)+(monedas[4]*1.00) ),"" );
		System.out.printf("\n|_____________________________________________|");
		System.out.println();
	}
	
	public void creditoUsuario()
	{
		System.out.println("Credito: "+ amount);
	}

	public static void main(String[] args) {
		/*
		Cash cash=new Cash();
		cash.addCash(10);
		cash.addCash(10);
		cash.addCash(20);
		cash.addCash(50);
		
		//primer usuario
		System.out.println("Primer usuario: ");
		if(cash.siHaySuficienteDinero(80) && cash.siHayCambio(10)){
			cash.hacerCambio(80);
		}
		cash.returnCash();
		System.out.println();
		//segundo usuario
		System.out.println("Segundo usuario: ");
		cash.addCash(100);
		if(cash.siHaySuficienteDinero(80) && cash.siHayCambio(20)){
			cash.hacerCambio(80);
		}
		cash.returnCash();
		System.out.println();
		//tercer usuario
		System.out.println("Tercer usuario: ");
		cash.addCash(100);
		if(cash.siHaySuficienteDinero(50) && cash.siHayCambio(50)){
			cash.hacerCambio(50);
		}
		cash.returnCash();
		
		System.out.println();
		System.out.println("Monedas que quedan en la maquina: ");
		cash.displayAux();
		*/
	}

}
