import java.io.FileReader;
import java.util.Random;
import java.io.File;
import java.io.BufferedReader;
import java.util.Scanner;

public class Mockaroo {

	
	public static void main(String[] args) {
		
		try {
			int llargada = 10;
			boolean dadesBoolean [] = new boolean [llargada];
			dadesBoolean(llargada, dadesBoolean);
			for(int i = 0; i < llargada; i++) {
				System.out.println(dadesBoolean[i]);

			Scanner reader = new Scanner(System.in);
			String files_dades[]= {"Dades/1-Noms.txt","Dades/2-Cognoms.txt","Dades/3-Ciutat.txt","Dades/4-Adreces.txt","Dades/5.Proffesions.txt",
					"Dades/6.Pais.txt","Dades/7.Estudis.txt","Dades/8.Colors.txt","Dades/10.NomDeLaCompanyia"};
			FileReader fr = new FileReader(files_dades[0]);
			BufferedReader br = new BufferedReader(fr);
			String line;
			
			/*while(br.ready()) {
				line = br.readLine();
				System.out.println(line);
			}*/
			// System.out.println(RandomNumber(1,0,1000));

			}

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	// ·Leemos archivos con funciones y generamos estos a partir de otras funciones ->
	// ·Funcion boolean sin formatos
	public static void dadesBoolean(int quantitatDades, boolean dadesBoolean[]) {
		//inicialitzem el Random
		Random random=new Random();
		//Fem un bucle amb tantes voltes com dades a generar
		for (int i = 0; i < quantitatDades; i++) {
			//Guardem al array de booleans el valor aleatori generat amb el Random
	        dadesBoolean[i] = random.nextBoolean();
	    }
	}
	
	// ·Funcion int para indicar los 'decimales=0','minims=0 i maxims=1000'
	public static double RandomNumber(double decimals,double minim,double maxim) {
		// Importem el metode random per generar numeros aleatoris
		Random random = new Random();
		// Generem el numero aleatori entre un (minim i un maxim)
        double numeroAleatorio = minim + (maxim - minim) * random.nextDouble(); 
        // Redondearem el numeor especificat a partir de la quantitat de decimals demanats
        double escala = Math.pow(10, decimals);
        numeroAleatorio = Math.round(numeroAleatorio * escala) / escala;
		// Al declarar el resultat de la funcio , haurem de especificar en ordre , la quantitat de decimals que volem, el rang minim i el rang maxim
        // Decimals -> 0 per defecte * Minim -> 0 per defecte * Maxim -> 1000 per defecte
		return numeroAleatorio;
	}
	// ·Funcion String para indicar el nombre del dominio='nom de comapnyia'
	// ·Funcion IP4 ???
	// ·Funcion String ha de indicar 'letras,numeros,mayusculas,minusculas,simbolos y longitud'
	
	// ·Funcion String ha de indicar el 'any minim=1900 i maxim=2023'
	// ·Funcion para IBAN o DNI (Hay como buscar como se generan)
	// ·Funcion int ha de indicar el 'valor d'inici=1'
	//*****************************
	// Debemos leer el archivo de datos y crear a partir de este los archivos SQL y XML/XSD/XSLT
}
