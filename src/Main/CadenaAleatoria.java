package Main;

import java.util.concurrent.ThreadLocalRandom;

public class CadenaAleatoria 
{
	// selecciona un numero aleatorio entre un rango y lo arroja como retorno
	public static int aleatorioEnRango(int minimo, int maximo)
	{
		return ThreadLocalRandom.current().nextInt(minimo, maximo +1);
	}
	
	// Retorna una letra aleatoria de la cadena inicial
	public static char caracterAleatorio()
	{
		String compilacionLetras = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"; // Cadena donde se tomarán los caracteres

		int indiceAleatorio = aleatorioEnRango(0, compilacionLetras.length() -1); // Toma el numero arrojado por la función 
		char caracterAleatorio = compilacionLetras.charAt(indiceAleatorio);	// Toma el indice y lo busca en la cadena de caracteres original para arrojar el caracter que indica
		
		return caracterAleatorio;
	}
	
	public static void main(String[] args) 
	{
		char[] cadenaAleatoria = new char[250]; //Primera cadena de caracteres aleatorios (Cada que se ejecuta arroja cadenas diferentes)
		int salto = 1; // Variable de control de salto (Cada 25 caracteres agregados se agrega un salto de linea para favorecer la visualización en terminal
		int sumaMayusculas = 0; 
		int sumaMinusculas = 0;
		char comparador; // Variable de comparación de caracteres

		System.out.println("CADENA ALEATORIA: 10 filas con 25 caracteres\n");
		
		//Ciclo de llenado de arreglo
		for(int i = 0; i < cadenaAleatoria.length; i++ )
		{
			cadenaAleatoria[i] = caracterAleatorio(); // Deposita el caracter aleatorio en el arreglo
 			
			// Ciclo de identificación de caracteres solicitados: 
			//Imprime los caracteres a contar de otro color para que sean faciles de identificar en terminal
			if(cadenaAleatoria[i] == 'a' || cadenaAleatoria[i] == 'A' )
			{
				System.err.print("[" + cadenaAleatoria[i] + "]"); //Imprime en rojo si los caracteres son "a" o "A"
			}
			else
			{
				System.out.print("[" + cadenaAleatoria[i] + "]"); //El resto de caracteres los imprime de forma normal
			}
			
			salto += 1;
			
			// Condicional que agrega un salto cada 25 caracteres asignados
			if(salto > 25)
			{
				System.out.println("");
				salto = 1;
			}
		}
		
		// Ciclo de conteo de caracteres solicitados
		for(int i = 0; i < cadenaAleatoria.length; i++)
		{
			if (cadenaAleatoria[i] == 'A')
			{
				sumaMayusculas += 1; // Realiza la suma si el caracter solicitado es "A"
			}
			else if(cadenaAleatoria[i] == 'a')
			{
				sumaMinusculas += 1; // Realiza la suma si el caracter solicitado es "a"
			}
		}
		
		System.out.println("\nSUMA DE CARACTERES: ");
		System.out.println("TOTAL DE LETRAS A: " + sumaMayusculas); //Suma de mayusculas
		System.out.println("TOTAL DE LETRAS a: " + sumaMinusculas); //Suma de minusculas
		
		System.out.println("\nCADENA INVERSA: 98 caracteres \n");
		
		char[] cadenaInversa = new char[98]; //Arreglo para cadena inversa (Tomada de la cadena aleatoria ya asignada)
		int j = 97; // Variable indice para tomar el valor de la cadena aleatoria de forma inversa
		salto = 1; //Variable de control de salto
		
		
		// Ciclo de asignación de caracteres a la cadena inversa
		for(int i = 0; i < 98; i++)
		{
			cadenaInversa[i] = cadenaAleatoria[j]; // Asigna el valor de la cadena aleatoria a la cadena inversa

			if(cadenaInversa[i] == 'a' || cadenaInversa[i] == 'A' )
			{
				System.err.print("[" + cadenaInversa[i] + "]"); //Imprime en rojo si los caracteres son "a" o "A"
			}
			else
			{
				System.out.print("[" + cadenaInversa[i] + "]"); //El resto de caracteres los imprime de forma normal
			}
			
			salto += 1;
			
			// Condicional que agrega un salto cada 25 caracteres asignados
			if(salto > 25)
			{
				System.out.println("");
				salto = 1;
			}
			j -= 1;
		}
	}

}
