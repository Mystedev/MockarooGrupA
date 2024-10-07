import java.io.FileReader;
import java.util.Random;

import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;

import java.io.BufferedReader;
import java.util.Scanner;

public class Mockaroo {
	public static void main(String[] args) {
		Random random = new Random();
		try {
			String files_dades[]= {"Dades/1-Noms.txt","Dades/2-Cognoms.txt","Dades/3-Ciutat.txt","Dades/4-Adreces.txt","Dades/5.Proffesions.txt",
					"Dades/6.Pais.txt","Dades/7.Estudis.txt","Dades/8.Colors.txt","Dades/10.NomDeLaCompanyia"};
			/*FileReader fr = new FileReader(files_dades[0]);
			BufferedReader br = new BufferedReader(fr);
			*/
			String line="11";
			String emails []=new String [1];
			//while(br.ready()) {
				//line = br.readLine();
			//	System.out.println(line);
			//}
			int numAleatori=random.nextInt(250),anyMaxim=2023,anyMinim=1900,valorPerDefecteAutonumeric=1;
			line=email(200,emails,files_dades,numAleatori);
			line=dates(2,anyMinim,anyMaxim,numAleatori);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String email(int largada,String emails[],String files_dades[],int aleatori) {
		Random random = new Random();
		Scanner teclat=new Scanner (System.in);
	try {
		//Declaro els lectors
		BufferedReader br = new BufferedReader(new FileReader(files_dades[0]));
		BufferedReader br1 = new BufferedReader(new FileReader(files_dades[8]));
		//L'asicno la llargada a les arrays que s'utilitzaran
		String nomCompanyia[]=new String[2];
		String nom[]=new String[2];
		emails=new String [largada];
		//Declaro variables per a utilitzarles com a index, i per a calcular si s'he de torna a llegui el archiu  
		int j=0,posicioArray,numAleatori2=aleatori,largadaArxiu=250,largadaGenera=largada;
		//Aqui li resto un al aleatori per que encaixi amb la posicio de la array
		numAleatori2=aleatori-1;
		//Ara faig els calculs per a comprova si ha cabare llegin linies nules si
		largadaGenera=numAleatori2+largadaGenera;
		posicioArray=largadaGenera-largadaArxiu;
		//si el numero es mes geran que cero acabaria lleguin linies nules per a no llegirnes he fet el calcul corresponent
		if (posicioArray>0) {
			//calculo quina posicio li correspont a la primera linia
			posicioArray=largada-posicioArray;
			//bucle per a llegui i asicnar aleatoriament
			for (int i=0 ; i <250 ; i++) {
				//La condicio es per asicnar a les primeres lineias comenzan per el final 
				if(posicioArray<largada) {
					//legeixo linia
					nom[1]= br.readLine();
					nom=nom[1].split("#");
					emails[posicioArray] = nom[1]+"@";
					nomCompanyia[1]=br1.readLine();
					nomCompanyia=nomCompanyia[1].split("#");
					//guardo el email
					emails[posicioArray] = emails[posicioArray]+nomCompanyia[1]+".com";
					posicioArray++;
				}else {
					//llegeixo linies
					nom[1]= br.readLine();
					nom=nom[1].split("#");
					nomCompanyia[1]=br1.readLine();
					nomCompanyia=nomCompanyia[1].split("#");
					//Hem salto les linies fins trova la linia amb el numero aleatori
					if (i>=numAleatori2&&j<largada) {
						emails[j] =nom[1]+"@";
						emails[j] = emails[j]+nomCompanyia[1]+".com";
						j++;
					}
				}
			}
			
		}else {
			//Legeixo i guardo
			for (int i=0 ; j<largada ; i++) {
				nom[1]= br.readLine();
				nom=nom[1].split("#");
				nomCompanyia[1]=br1.readLine();
				nomCompanyia=nomCompanyia[1].split("#");
				if (i>=aleatori&&j<largada) {
					emails[j] =nom[1]+"@";
					emails[j] = emails[j]+nomCompanyia[1]+".com";
					j++;
				}
			}
		}
		//for (int i = 0; i < emails.length; i++) {
			//System.out.println(emails[i]);
		//}
		//int numAleatori=random.nextInt(250)+1,anyMaxim=2023,anyMinim=1900,valorPerDefecteAutonumeric=1;
		//String emails []=new String [1];
		//line=email(2,emails,files_dades,numAleatori);
	}catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}
	public static String dates(int largada,int anyMinim,int anyMaxim,int aleatori) {
		Random random = new Random();
		//dono llargada a les array i la variable
		String data[]=new String [largada];
		int test;
		//Utilitzo l'array per a ordenar ficar el maxim com a maxim
		if(anyMaxim<anyMinim) {
			test=anyMaxim;
			anyMaxim=anyMinim;
			anyMinim=test;
		}
		//bucle per a generar els anys
		for (int i = 0; i < data.length; i++) {
			int any=random.nextInt(anyMaxim-anyMinim)+anyMinim,mes=random.nextInt(12)+1,dia;
			//Crido a la funcio pera sabe cuans dies te el mes 
			dia=diesMes(mes,any);
			if (dia==-1) {
				System.out.println("ERROR");
			}else {
				//Genero el dia i el guardo a la array
				dia=random.nextInt(dia)+1;
				data[i]= dia+"/"+mes+"/"+any;
				System.out.println(data[i]);
			}
		}
		//Lineis del main per a fer proves amb la crida de la funcio
		//int numAleatori=random.nextInt(250)+1,anyMaxim=2023,anyMinim=1900,valorPerDefecteAutonumeric=1;
		//line=dates(2,anyMinim,anyMaxim,numAleatori);
		return "a";
	}
	public static int diesMes( int mes ,int any) {
		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			// Meses de 31 días
			return 31;
		} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			// Meses de 30 días
			return 30;
		} else if (mes == 2) {
			// Febre (28 en anys comuns, 29 en anys de traspas)
			// Implementar lógica para determinar si es año bisiesto
			if ((any % 4 == 0 && any % 100 != 0) || (any % 100 == 0 && any % 400 == 0)){
				return 29;
			} else {
				return 28;
			}
		}else {
			return -1;
		} 
	}
	public static void autonumeric(int llargada,int num[],int valorPerDefecte) {
		num=new int[llargada];
		//Faig un bucle per a genera el auto numeric comensan amb el numero que el usuari indiqui
		for (int i = 0; i <llargada; i++) {
			num[i]=valorPerDefecte;
			valorPerDefecte++;
			System.out.println(num[i]);
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
        if (inclouLletres && inclouMinuscules) conjuntCaracters += lletres;
        if (inclouLletres && inclouMajuscules) conjuntCaracters += majuscules;
        if (inclouNumeros) conjuntCaracters += numeros;
        if (inclouSimbols) conjuntCaracters += simbols;
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
