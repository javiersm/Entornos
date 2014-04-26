

public class NumerosRandom {

	public static void main(String[] args) {
		//
		int a = 0, b = 0;
		
		a = (int) (Math.random()*100 + 1);
		b = (int) (Math.random() * 100 + 1);
		
		System.out.println("A: " + a);
		System.out.println("B: " + b);
	}

}
