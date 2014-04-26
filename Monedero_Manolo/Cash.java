package maquina;
//FALTA:
//--->si hay suficiente dinero
//hacer cambio, quitar el dinero del producto al usuario(quitar monedas)
//el return del dinero(esta en aux)-->le doy un valor y el busca las monedas y las devuelve
public class Cash {
	//Atributos
	private int amount;//valor introducido por el usuario
	private int[]valor ={5,10,20,50,100};//valor en centimos de las monedas
	private int[]monedas;//Numero de monedas almacenadas en la máquina
	private int total;//valor almacenado en la máquina, total que tiene almacenado incluso lo que meta el usuario
	private int[]aux;//monedas que se utilizan en el cambio

	public Cash() {
		this.amount=0;
		this.monedas = new int [this.valor.length];//tamaño en función de las monedas
		this.total=0;
		this.aux = new int [this.valor.length];//tamaño en funcion de las monedas
	}
	//Accesadores
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int[] getValor() {
		return valor;
	}
	public void setValor(int[] valor) {
		this.valor = valor;
	}
	public int[] getMonedas() {
		return monedas;
	}
	public void setMonedas(int[] monedas) {
		this.monedas = monedas;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int[] getAux() {
		return aux;
	}
	public void setAux(int[] aux) {
		this.aux = aux;
	}
	//Servicios
	public  boolean siHayMonedas(int cambio, int indice, int total){
		for(int i=this.monedas[indice]; i>=0 && cambio <= total; i--){
			if(i*this.valor[indice] > cambio){//si el valor de las monedas es mayor que el cambio no me sirve 
											  // y entonces le digo que continue
				continue;
			}
			this.aux[indice]=i;//anotamos las monedasd de este tipo que vamos a devolver
			if (i*this.valor[indice]==cambio){//si es el cambio justo he terminado
				return true;	
			}
			if (indice > 0){//si todavía quedan más monedas
				if(this.siHayMonedas(cambio-(i*this.valor[indice]), indice-1,
						total-(this.monedas[indice]*this.valor[indice]))){
					return true;
				}
			}
			this.aux[indice]=0;
		}
		return false;
	}
	
	public boolean siHayCambio(int cambio){
		this.iniAux();
		return this.siHayMonedas(cambio, this.valor.length-1, this.total);
	}
	private void iniAux(){
		for(int i=0; i<this.aux.length;++i){
			this.aux[i]=0;
		}
	}
	public void addCash(int coin){
		switch(coin){
		case 5:   this.amount+= coin; this.total+=coin; this.monedas[0]++;break;
		case 10:  this.amount+= coin; this.total+=coin; this.monedas[1]++;break;
		case 20:  this.amount+= coin; this.total+=coin; this.monedas[2]++;break;
		case 50:  this.amount+= coin; this.total+=coin; this.monedas[3]++;break;
		case 100: this.amount+= coin; this.total+=coin; this.monedas[4]++;break;
		}
	}
	public boolean siHaySuficienteDinero(int precio){
		if(this.amount >= precio){
			return true;
		}
		return false;
	}
	//Método para mostar las monedas devueltas
	private void displayAux(){
		for (int i=0; i < this.aux.length;i++){
			if (this.aux[i] > 0){
				System.out.println("Monedas de " + this.valor[i] + " : " + this.aux[i]);
			}
		}
	}
	//Método hacer cambio
	
	//Método retornar el dinero que el usuario tiene en la máquina
	
	public static void main(String[] args) {
		Cash cash = new Cash();
		int[] monedas = {0,0,4,1,1};
		
		cash.setMonedas(monedas);
		cash.setTotal(230);
		System.out.println(cash.getTotal());
		
		System.out.println(cash.siHayCambio(100));
		cash.displayAux();
		
		System.out.println(cash.getTotal());
		
		
	}

}
