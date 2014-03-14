package Examen6Dic13;

import java.util.Scanner;

public class examenPrueba1 {

	public static void main(String[] args) {
		int numAlum = 0, i=0, j=0;
		double suma=0, media=0, Suma=0;
		Scanner teclado = new Scanner(System.in);
		
		do{
			System.out.print("Numeros de alumnos de la clase: ");
			numAlum = teclado.nextInt();  //CORREGIDO
		}while(numAlum<=0);
		double[]notas = new double[numAlum];
		//
		for(i=0; i<notas.length;++i){
			System.out.print("\nAlumno" + (i+1) + "Nota final:" );
			notas[i] = teclado.nextDouble(); //CAMBIADO
		}
		// CALCULAR LA MEDIA
		for(i=0; i<notas.length-1 ; ++i){	//CORREGIDO
				suma = suma + notas[i];
		}
		media= suma/(notas.length-1); // CORREGIDO
		System.out.print("\nNota media del curso: "+media);
		//
		System.out.print("\nListado de las notas superiores a la media:\n ");
		if(notas[i]>media){
			System.out.println("\tAlumno numero: "+ (i+1) + "Nota final: " + notas[i] ); //CORREGIDO
			
		}
		//
		System.out.println("Nota maxima de los alumnos:");
		double maxima=0;
		for(i=0; i<notas.length;++i){  //CORREGIDO
			if(notas[i] > maxima)
				maxima = notas[i];			//CORREGIDO
		}
		System.out.print("\t" + maxima);
		
	}

}
