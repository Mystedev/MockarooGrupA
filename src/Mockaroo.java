import java.io.FileReader;
import java.util.Random;
import java.io.BufferedReader;
import java.util.Scanner;

public class Mockaroo {
	public static void main(String[] args) {
		
		try {
			LlegirDades();
			// System.out.println(RandomNumber(1,0,1000)); --Funcion para mostrar numeros decimales
			// MostrarPassword(); --Funcion para mostrar contraseña compuesta por caracteres,simbolos y letras
			// String numeroDNI = ObtenerDNI(); --Funcion para obtener DNI aleatorio 
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	// ·Leemos archivos con funciones y generamos estos a partir de otras funciones ->
	// Funcio per llegir els arxius de dades
	public static void LlegirDades() {
		try {
			Scanner reader = new Scanner(System.in);
			// Array d'arxius de dades per accedir i llegir-los
			String files_dades[]= {"Dades/1-Noms.txt","Dades/2-Cognoms.txt","Dades/3-Ciutat.txt","Dades/4-Adreces.txt","Dades/5.Proffesions.txt",
					"Dades/6.Pais.txt","Dades/7.Estudis.txt","Dades/8.Colors.txt","Dades/10.NomDeLaCompanyia"};
			// Arxiu d'entrada per determinar on guardar els arxius 
			String fileEntrada = "Dades/Requisits.txt";
			// Llegirem l'arxiu amb les especificacions que pot demanar l'usuari
			BufferedReader br = new BufferedReader(new FileReader(fileEntrada));
			// Llegim la primera linea 
			String line = br.readLine();
			// La primera linea queda separada pel '#' obtenint a la primera posicio el tipus d'arxiu i a la segona posicio la ubicacio
			String firstLine[] = line.split("#");
			// Separem les dades obtingudes
			String tipusArxiu = firstLine[0];
			String quantitatRegistres = firstLine[1];
			String ubicacioArxiu = firstLine[2];
			// Farem servir la seguent sintaxi per guiar al usuari de manera que sapigui com,on i quants registres vol generar
			// *Tipus d'arxiu que es vol generar ->> SQL o XML
			// *Quantitat de registres que es vol generar ->> 0-250 (Tenint en compte que el total de dades per arxiu es de 250)
			// *Ubicació on es vol guardar l'arxiu generat
			System.out.println("La següent linea servirá per saber com voldras generar l'arxiu de sortida.");
			System.out.println("Fes servir la següent sintaxi per generar l'arxiu de sortida ->> SQL#200#Escriptori");
			System.out.print("Introdueix com vols generar l'arxiu:");
			String arxiuGenerat = reader.nextLine();
			String formatArxiu[] = arxiuGenerat.split("#");
			while(formatArxiu.length!=3) {
				System.out.print("Error|Introdueix un format vàlid:");
				arxiuGenerat = reader.nextLine();
			}
			
		}catch(Exception e) {e.printStackTrace();}
	}
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
	// Mètode per generar la contrasenya segons els paràmetres
    public static String GenerarPassword(boolean inclouLletres, boolean inclouNumeros, boolean inclouMajuscules, boolean inclouMinuscules, 
                                         boolean inclouSimbols, int longitud) {
        // Definim els conjunts de caràcters possibles
        String lletres = "abcdefghijklmnopqrstuvwxyz";
        String majuscules = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeros = "0123456789";
        String simbols = "!@#$%^&*()_-+=<>?/{}~|";
        // Cadena que contindrà tots els caràcters permesos segons les opcions
        String conjuntCaracters = "";
        // Afegeix els caràcters segons els paràmetres afegits
        if (inclouLletres && inclouMinuscules) {conjuntCaracters += lletres;}
        if (inclouLletres && inclouMajuscules) {conjuntCaracters += majuscules;}
        if (inclouNumeros) {conjuntCaracters += numeros;}
        if (inclouSimbols) {conjuntCaracters += simbols;}
        // Generació de la contrasenya
        Random random = new Random();
        String password = "";
        for (int i = 0; i < longitud; i++) {
            int index = random.nextInt(conjuntCaracters.length());
            password += conjuntCaracters.charAt(index);  // Mezcla de caracters
        }
        return password;
    }
    public static void MostrarPassword() {
    	// Paràmetres de exemple
        boolean inclouLletres = true;
        boolean inclouNumeros = true;
        boolean inclouMajuscules = true;
        boolean inclouMinuscules = true;
        boolean inclouSymbols = true;
        int longitud = 12;  // Longitud de la contrasenya
        
        String password = GenerarPassword(inclouLletres, inclouNumeros, inclouMajuscules, 
                                          inclouMinuscules, inclouSymbols, longitud);
        // Mostrar la contrasenya generada
        System.out.println("Contrasenya generada exitosament: " + password);
    }
	// ·Funcion String ha de indicar el 'any minim=1900 i maxim=2023'
	// ·Funcion para IBAN o DNI (Hay como buscar como se generan)---------------------------------------
    // Funcio per generar la ultima lletra del DNI
    public static char GenerarLetraDNI(int dni) {
    	// Lletres valides per seleccionar l'ultim caracter del DNI
    	String characters = "TRWAGMYFPDXBNJZSQVHLCKE";
    	// La resta de la divisio de la longitud total del 'string' dels caracters ens dona la posicio de la lletra, es a dir  '23'
    	int rest = dni % characters.length();
    	return characters.charAt(rest);
    }
    // Funcion per obtenir el umero de DNI aleatori
    public static String ObtenerDNI() {
    	Random random = new Random();
    	// Necesitem que la quantitat de numeros del DNI sigui de 8
    	int numeroDNI = random.nextInt(90000000) + 10000000;
    	// Obtenim la serie de numeros aleatoris que contindran el DNI
    	char lletra = GenerarLetraDNI(numeroDNI);
    	// Obtenim exitosament un numero de DNI aleatori
    	return numeroDNI + String.valueOf(lletra);
    }
	// ·Funcion int ha de indicar el 'valor d'inici=1'
	//*****************************
	// Debemos leer el archivo de datos y crear a partir de este los archivos SQL y XML/XSD/XSLT
}
