package br.com.caelum.livraria.teste;

import java.util.Random;

public class TesteRandom {

	public static void main(String[] args) {

		Random gerador = new Random();

		int resultado = gerador.nextInt(11);
		System.out.println(resultado);

		int resultado2 = gerador.nextInt(11);
		System.out.println(resultado2);
		
		Random geradorBoolean = new Random();
		boolean valor = geradorBoolean.nextBoolean();
		System.out.println(valor);

		boolean valor2 = geradorBoolean.nextBoolean();
		System.out.println(valor2);
		
		geradorBoolean = new Random(10);//seed inicial é 10
		
		System.out.println("__________________________________________");
		boolean valor3 = geradorBoolean.nextBoolean(); //sempre true
		System.out.println(valor3);

		boolean valor4 = geradorBoolean.nextBoolean(); //sempre false
		System.out.println(valor4);
		
		System.out.println("__________________________________________");
		long millis = System.currentTimeMillis();
		geradorBoolean = new Random(millis);

		boolean valor5 = geradorBoolean.nextBoolean();
		System.out.println(valor5);

		boolean valor6 = geradorBoolean.nextBoolean();
		System.out.println(valor6);
	}

}
