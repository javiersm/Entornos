package octubre;
//calcular la media de dos numeros dado

public class Class {

	public static void main(String[] args){
		
		int numero1 = 0;
		int numero2 = 0;
		int media = 0;
		numero1 = (int)Math.random() * 10;
		numero2 = (int)Math.random() * 10;
	
		media = (numero1 + numero2) / 2;
		
		System.out.println("numero1: " + numero1 +" numero2: " +  numero2 + " media: " +  media);
		
	}
}
