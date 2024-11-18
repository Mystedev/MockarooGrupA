import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

public class Mockaroo {

	// Variables i metodes globals del programa
	public static String rutaUbicacio;
	public static int quantitatTipusDades;
	public static int quantitatDades;
	public static String[] tipusDada;
	public static String dadesCrear[][] = new String[19][200];
	public static String files_dades[] = { "Dades/1-Noms.txt", "Dades/2-Cognoms.txt", "Dades/3-Ciutat.txt",
							"Dades/4-Adreces.txt", "Dades/5-Proffesions.txt", "Dades/6-Pais.txt",
							"Dades/7-Estudis.txt", "Dades/8-Colors.txt", "null", "Dades/10-NomDeLaCompanyia.txt"
	    };
	// Parametres utilitzats a les funcions
	public static int llargada=0;
	public static void main(String[] args) {
		try {
		    // Variables del programa
			Random random = new Random();
		    int contador = 0,anyMinim=1900,anyMaxim=2023,valorInicial=1;
		    int contadorMatriu = 0;
		    int numeroAleatori = random.nextInt(200)+1;
		    double decimals=2,minim=0,maxim=1000;
		    boolean inclouLletres, inclouNumeros, inclouMajuscules,  inclouMinuscules,  inclouSimbols;
		    String domini = "";
		    // Arxiu de entrada i lectura d'aquest
		    String fileEntrada = "Dades/Requisits.txt";
		    BufferedReader br = new BufferedReader(new FileReader(fileEntrada));
		    String firstLine = br.readLine();
		    String line;
		    // Se lee cada linea que contiene una ruta de un archivo
		    while ((line = br.readLine()) != null) {
		        // Cada línea contiene números separados por #
		        String[] indicesStr = line.split("#");
		        int[] indices = new int[indicesStr.length];
		        
		        // Convertir cada índice a un entero y validar su rango
		        for (int i = 0; i < indicesStr.length; i++) {
		            try {
		            	System.out.println(indicesStr[i]);
		            	
		                int index = Integer.parseInt(indicesStr[i]);
		                if (index >= 1 && index <= files_dades.length) { // Validación de rango
		                    indices[i] = index;
		                } else {
		                    System.out.println("Error: Índice fuera de rango en la entrada: " + index);
		                    indices[i] = -1; // Valor inválido o ignorar este índice
		                }
		            } catch (Exception e) {
		                System.out.println("Error: Índice no válido en la entrada: " + indicesStr[i]);
		            }
		        }
		        // Procesar los índices válidos
		        String[] archivosSeleccionados = processarIndexs(files_dades, indices);
		        
		        // Imprimir los archivos seleccionados
		        for (int i = 0; i < archivosSeleccionados.length; i++) {
		            if (archivosSeleccionados[i] != null) {
		                //System.out.println(archivosSeleccionados[i]);
		            }
		        }
		    }
		    // Procesamiento de la primera línea
		    String formatArxiu[] = firstLine.split("#");
		    String arxiuSortida = formatArxiu[0]; // XML/SQL
		    int registres = Integer.parseInt(formatArxiu[1]); // Quantitat de registres
		    String ruta = formatArxiu[2]; // Ruta on es guarda l'arxiu
		    // Validar el formato de la primera línea
		    if (ValidarFormatEntrada(firstLine, formatArxiu)) {
		        System.out.println("Archivo válido.");
		    } else {
		        System.out.println("Formato no válido.");
		    }
		    br.close(); // Cerrar BufferedReader
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    try {
	        // Variables del programa
	        Random random = new Random();
	        int numeroAleatori = random.nextInt(200) + 1;
	        String fileEntrada = "Dades/Requisits.txt";
	        BufferedReader br = new BufferedReader(new FileReader(fileEntrada));
	        
	        // Leer y procesar la primera línea
	        String firstLine = br.readLine();
	        if (firstLine != null) {
	            String[] formatArxiu = firstLine.split("#");
	            if (ValidarFormatEntrada(firstLine, formatArxiu)) {
	                System.out.println("Archivo válido. {"+firstLine+"}");
	                String arxiuSortida = formatArxiu[0]; // XML/SQL
	                int registres = Integer.parseInt(formatArxiu[1]); // Cantidad de registros
	                String ruta = formatArxiu[2]; // Ruta donde se guarda el archivo
	            } else {
	                System.out.println("Formato no válido.");
	                br.close();
	                return;
	            }
	        } else {
	            System.out.println("El archivo está vacío.");
	            br.close();
	            return;
	        }
	        
	        // Leer líneas restantes y procesar índices
	        String line;
	        while ((line = br.readLine()) != null) {
	            String[] indicesStr = line.split("#");
	            int[] indices = new int[indicesStr.length];
	            
	            // Convertir y validar índices
	            for (int i = 0; i < indicesStr.length; i++) {
	                int index = Integer.parseInt(indicesStr[i]);
	                if (index >= 1 && index <= 19) {
	                    indices[i] = index;
	                } else {
	                    indices[i] = -1;
	                }
	            }
	            
	            // Procesar índices válidos
	            for (int i = 0;i<indices.length;i++) {
	                if (indices[i] >= 1 && indices[i] <= 10) {
	                    // Procesar archivos de datos
	                    String archivo = files_dades[indices[i] - 1];
	                    if ("9".equals(archivo)) {
	                        url(quantitatDades, dadesCrear[indices[i] - 1], numeroAleatori);
	                    }
	                    if (archivo != null && ! "null".equals(archivo)) {
	                        System.out.println("Archivo de datos: " + archivo);
	                    }
	                } else if (indices[i] >= 11 && indices[i] <= 19) {
	                    // Procesar funciones especiales
	                    System.out.println("Función especial: " + indices[i]);
	                } else if (indices[i] == 0) {
	                    System.out.println("Índice 0 omitido.");
	                } else {
	                    System.out.println("Índice " + indices[i] + " fuera de rango.");
	                }
	            }
	        } 
	        br.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	}
	//for (int i = 0; i < emails.length; i++) {
	//System.out.println(emails[i]);
	//}
	//int numAleatori=random.nextInt(250)+1,anyMaxim=2023,anyMinim=1900,valorPerDefecteAutonumeric=1;
	//String emails []=new String [1];
	//line=email(2,emails,files_dades,numAleatori);
		
	 public static void email(int largada,String emails[],String files_dades[],int aleatori,String domini) {
	     try {
	         BufferedReader br = new BufferedReader(new FileReader(files_dades[0]));

	         BufferedReader br1 = new BufferedReader(new FileReader(files_dades[8]));
	   
	         //L'asicno la llargada a les arrays que s'utilitzaran
	         String auxiliarNom[]=new String[largada];
	         llegir(br,auxiliarNom,aleatori,largada,0);
	         if (domini.length()>0){
	        	 for(int i=0;i<emails.length;i++){
	        		 emails[i]=auxiliarNom[i]+"@"+domini;
	             }
	         } else{
	        	 String auxiliarDomini[]=new String[largada];
	        	 llegir(br,auxiliarDomini,aleatori,largada,0);
	        	 for(int i=0;i<emails.length;i++){
	        		 emails[i]=auxiliarNom[i]+"@"+auxiliarDomini[i]+".com";
	             }
	         }

	        }catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
	// Funció que llegeix l'array segons els indexs proporcionats
	public static String[] processarIndexs(String[] archivos, int[] indices) {
	    String[] resultados = new String[indices.length];
	    for (int i = 0; i < indices.length; i++) {
	        int index = indices[i];
	        
	        // Verificar si el índice está dentro del rango de archivos
	        if (index > 0 && index <= archivos.length) {
	            resultados[i] = archivos[index  - 1]; // Guardar archivo en el array
	        } 
	        // Verificar si el índice está dentro del rango de funciones (valores de ejemplo: 11-19)
	        else if (index >= 11 && index <= 19) {
	        	
	        } 
	        else {
	            resultados[i] = "Índice " + index + " fuera de rango.";
	        }
	    }
	    return resultados; // Retornar los resultados

	}/*
	private static String executarFuncions(int index) {
	    switch (index) {
	        case 11:
	            booleans();
	        case 12:
	            RandomNumber(decimals,minim,maxim);
	        case 13:
	            email(largada,emails[],files_dades[],aleatori,domini);
	        case 14:
	            ip4();
	        case 15:
	            GenerarPassword(inclouLletres,inclouNumeros,inclouMajuscules,inclouMinuscules,inclouSimbols, longitud);
	        case 16:
	            dates(largada,anyMinim,anyMaxim,aleatori,data[]);
	        case 17:
	            iban();
	        case 18:
	            ObtenerDNI();
	        case 19:
	            autonumeric(llargada,num[],valorPerDefecte);
	        default:
	            return "Función no definida para índice " + index;
	    }
	}*/

	
	


    // Funcio per llegir les funcions a dins de l'arxiu requisits
	// Funcio creada per validar el format del fitxer d'entrada
	public static boolean ValidarFormatEntrada(String arxiuGenerat,String formatArxiu[]) {
		// Comprovar la longitud de l'array i el format correctament
		boolean isCorrect = false; // Inicialment, no és correcte
		// Bucle que demana correccions fins que tot el format sigui correcte
		while (!isCorrect) {
		// Comprovar si l'array té 3 elements
			if (formatArxiu.length != 3 ) {
				System.out.println("Error -> El format de l'arxiu ha de tenir 3 elements: 'Tipus de Arxiu'#'Quantitat de registres'#'Ubicació'");
				return false;
		    }
		    // Comprovar que el tipus d'arxiu és "SQL" o "XML"
		    else if (!(formatArxiu[0].equalsIgnoreCase("XML") || formatArxiu[0].equalsIgnoreCase("SQL"))) {
		        System.out.println("Error -> El tipus d'arxiu ha de ser 'SQL' o 'XML'");
		        return false;
		    }
		    // Comprovar que el segon element és un nombre vàlid
		    else if (!esNumeroValid(formatArxiu[1])) {
		        System.out.println("Error -> La quantitat de registres ha de ser un número positiu entre 1 i 250.");
		        return false;
		    }
		    // Comprovar que la ubicació és "DOCUMENTOS"
		    else if (!formatArxiu[2].equalsIgnoreCase("DOCUMENTOS")) {
		        System.out.println("Error -> La ubicació ha de ser 'DOCUMENTOS'.");
		        return false;
		    } else {
		        // Si tot és correcte, sortir del bucle
		    	System.out.println("Formato Válido.");
		        isCorrect = true;
		     }
		}
		// Retornar la línia correcta quan tot sigui correcte
		return true;
	}
	// Funció auxiliar per comprovar si el segon element és un nombre vàlid entre 1 i 250
	public static boolean esNumeroValid(String valor) {
	    // Comprovar si és un número sencer
	    for (int i = 0; i < valor.length(); i++) {
	        if (!Character.isDigit(valor.charAt(i))) {
	            return false; // No és un número vàlid
	        }
	    }
	    // Convertir el número i comprovar que estigui dins del rang
	    int numero = Integer.parseInt(valor);
	    return numero >= 1 && numero <= 250;
	}
	// ·Leemos archivos con funciones y generamos estos a partir de otras funciones ->
	// Funcio per llegir els arxius de dades
	// ·Funcion boolean sin formatos
	public static void booleans(int contadorMatriu) {
		//inicialitzem el Random
		Random random=new Random();
		//Fem un bucle amb tantes voltes com dades a generar
		for (int i = 0; i < quantitatDades; i++) {
			//Guardem al array de booleans el valor aleatori generat amb el Random
	        dadesCrear[contadorMatriu][i] = random.nextBoolean()+"";
	    }
		contadorMatriu++;
	}
	// ·Funcion int para indicar los 'decimales=0','minims=0 i maxims=1000'
	public static void RandomNumber(double decimals,double minim,double maxim) {
		// Importem el metode random per generar numeros aleatoris
		Random random = new Random();
		// Generem el numero aleatori entre un (minim i un maxim)
        double numeroAleatorio = minim + (maxim - minim) * random.nextDouble(); 
        // Redondearem el numeor especificat a partir de la quantitat de decimals demanats
        double escala = Math.pow(10, decimals);
        numeroAleatorio = Math.round(numeroAleatorio * escala) / escala;
		// Al declarar el resultat de la funcio , haurem de especificar en ordre , la quantitat de decimals que volem, el rang minim i el rang maxim
        // Decimals -> 0 per defecte * Minim -> 0 per defecte * Maxim -> 1000 per defecte
        double num = numeroAleatorio;
	}
	// ·Funcion String para indicar el nombre del dominio='nom de comapnyia'
	public static void url(int llargada,String urls[],int aleatori) throws IOException{
        //GENERO LA URL DESDE EL NOM DE COMPANYIA 
        BufferedReader br = new BufferedReader(new FileReader(files_dades[8]));

        llegir(br,urls,aleatori,llargada,0);

        for(int i=0; i < llargada;i++){
            urls[i] = "www."+urls[i]+".com";
        }        
	}

	// ·Funcion IP4 ???
		//Per cridar-la dadesIp4(quantitatDades, Array on guardar les ip)
		public static void ip4(int contadorMatriu) {
		    Random random = new Random();
		    // Fem un bucle amb tantes voltes com dades a generar
		    for (int i = 0; i < quantitatDades; i++) {
		        // Generem i guardem els valors
		        dadesCrear[contadorMatriu][i] = random.nextInt(256) + "." + random.nextInt(256) + "." + random.nextInt(256) + "." + random.nextInt(256);
		    }
		    contadorMatriu++;
		}
	// Mètode per generar la contrasenya segons els paràmetres
    public static String GenerarPassword(boolean inclouLletres, boolean inclouNumeros, 
    								boolean inclouMajuscules, boolean inclouMinuscules, 
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

    public static void dates(int largada,int anyMinim,int anyMaxim,int aleatori,String data[]) {
		Random random = new Random();
		//dono llargada a les array i la variable
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
	    
	// ·Funcion para IBAN 
    //Per cridarla: iban( numeroAleatori, quantitatDades, Array on guardar els ibans)
    private static void iban (int numeroAleatori,int contadorMatriu) {
		try{
			//Primer contem les linies del arxiu per generar el array on guardar les dades
			//No es fa amb un tamany definit per si es modifica el tamany de l'arxiu
			BufferedReader br = new BufferedReader(new FileReader("Dades/6-Pais.txt"));			
			int tamanyArxiu = 0;
            while (br.readLine() != null) tamanyArxiu++;
            br.close();
			String liniesFitxer [] = new String [tamanyArxiu];			
			BufferedReader br2 = new BufferedReader(new FileReader("Dades/6-Pais.txt"));
			String linia;
            int i = 0;
            // Llegir cada línia i guardar-la a l'array
            while ((linia = br2.readLine()) != null) {
                liniesFitxer[i] = linia;
                i++;
            }
            br2.close();
            /*
             * Un cop tenim totes les dades del arxiu en un array, hem de 
             * calcular si des del numero aleatori fins al final del array
             * tenim suficients dades per mostrar la quantitat que demana
             * l'usuari
             */
        	int llegirLinea = numeroAleatori;
        	int contador = 0;
            if((quantitatDades+numeroAleatori)<liniesFitxer.length) {
            	//en aquest cas no cal fer res especial, ja que disposem de
            	//prous dades

            	contador = 0;
            	for(int j = 0; j < quantitatDades; j++) {
            		//cridem la funció que genera ibans tants cops com dades
            		//em de generar
            		dadesCrear[contadorMatriu][contador] = generarIban(liniesFitxer[llegirLinea]);
                	llegirLinea++;
                	contador++;
            	}
            	
            	
            	
            } else {
            	//en aquest cas no disposem de prous dades, aixi que haurem
            	//de tornar a llegir des del inici
            	
            	contador = 0;
            	//calculem quantes dades tenim disponibles i quantes ens en falten
            	int dadesDisponibles = liniesFitxer.length - numeroAleatori;
            	int dadesRestants = quantitatDades - dadesDisponibles;
            	
            	for(int k = 0; k < dadesDisponibles; k++) {
            		//Amb aquest primer for generem els ibans possibles fins que
            		//arribem al final de les dades disponibles
            		dadesCrear[contadorMatriu][contador] = generarIban(liniesFitxer[llegirLinea]);
                	llegirLinea++;
                	contador++;
            	}
            	llegirLinea = 0;
            	for(int l = 0; l < dadesRestants; l++) {
            		//amb aquest for generem ibans des de la linea 0 del
            		//array fins haver generat totes les dades restants
            		dadesCrear[contadorMatriu][contador] = generarIban(liniesFitxer[llegirLinea]);
                	llegirLinea++;
                	contador++;
            	}
            }
		} catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	//Funció que genera un iban i el retorna en format String
	private static String generarIban(String linea) {
		BigInteger digitControl;
		String[] lineaSeparada = linea.split("#");
		String codiPaisNumeros = "";
		String numeroCompte = "";
		String codiPais = lineaSeparada[2];
		String numeroIbanTemp = "";
		String iban;
		char lletra1Pais = Character.toLowerCase(codiPais.charAt(0));
		char lletra2Pais = Character.toLowerCase(codiPais.charAt(1));
		int numero1CodiPais = lletra1Pais - 'a' + 10;
		int numero2CodiPais = lletra2Pais - 'a' + 10;
		codiPaisNumeros = "" + numero1CodiPais + numero2CodiPais;
		
		/*
		 * Un cop tenim totes les variables, generem un num de compte
		 * aleatori
		 */
		Random random = new Random();
		
		for (int i = 0; i < 20; i++) numeroCompte = numeroCompte + random.nextInt(10);
		/*
		 * Amb num de compte i codi pais, calculem els digits de control. 
		 * Per poder fer el calcul dels digits de control, necessitem el 
		 * numero de compte + el codi de pais en digits + 0 + 0.
		 */
		numeroIbanTemp = numeroCompte + codiPaisNumeros + 0 + 0;
		/*
		 * Per calcular els dígits de control de l'IBAN, primer agafem el valor de 
		 * numeroIbanTemp i en fem un nombre BigInteger (ja que es un numero de 26 digits
		 * no entra en un long). Després calulem el mòdul 97 a aquest nombre. 
		 * Després, restem 98 a aquest resultat. El resultat d'aquesta resta serà el valor 
		 * dels dígits de control de l'IBAN.
		 */
		digitControl = BigInteger.valueOf(98).subtract(new BigInteger(numeroIbanTemp).mod(BigInteger.valueOf(97)));
		//Guardem el iban final generat a partir del codi pais + els digits de control i el numero de compte
		iban = codiPais + digitControl + numeroCompte;
		return iban;
	}
    
    
    // Funcio per generar la ultima lletra del DNI
    public static char GenerarLetraDNI(int dni) {
    	// Lletres valides per seleccionar l'ultim caracter del DNI
    	String characters = "TRWAGMYFPDXBNJZSQVHLCKE";
    	// La resta de la divisio de la longitud total del 'string' dels caracters ens dona la posicio de la lletra, es a dir  '23'
    	int rest = dni % characters.length();
    	return characters.charAt(rest);
    }
    // Funcion per obtenir el umero de DNI aleatori
    public static void ObtenerDNI() {
    	Random random = new Random();
    	// Necesitem que la quantitat de numeros del DNI sigui de 8
    	int numeroDNI = random.nextInt(90000000) + 10000000;
    	// Obtenim la serie de numeros aleatoris que contindran el DNI
    	char lletra = GenerarLetraDNI(numeroDNI);
    	// Obtenim exitosament un numero de DNI aleatori
    	String dni = numeroDNI + String.valueOf(lletra);
    }
	// ·Funcion int ha de indicar el 'valor d'inici=1'
    //Funcio per generar autonumeric
  	public static void autonumeric(int llargada,int num[],int valorPerDefecte) {
  		num=new int[llargada];
  		//Faig un bucle per a genera el auto numeric comensan amb el numero que el usuari indiqui
  		for (int i = 0; i <llargada; i++) {
  			num[i]=valorPerDefecte;
  			valorPerDefecte++;
  			System.out.println(num[i]);
  		}
  	}
	//*****************************
	// Debemos leer el archivo de datos y crear a partir de este los archivos SQL y XML/XSD/XSLT
    
  //Funcio per crear l'arxiu xsl
    //crearXsl(dadesCrear);
  	public static void crearXsl (String [] nomTipusDada) {
  		File desti=new File(rutaUbicacio+"\\Dades.xsl");
  		try {
  			PrintWriter impressora= new PrintWriter(desti);
  			impressora.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
  					+ "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\r\n"
  					+ "  <xsl:template match=\"/\">\r\n"
  					+ "    <html>\r\n"
  					+ "      <head>\r\n"
  					+ "        <title>Dades demanades</title>\r\n"
  					+ "        <style>\r\n"
  					+ "          table {\r\n"
  					+ "            border-collapse: collapse;\r\n"
  					+ "            width: 100%;\r\n"
  					+ "          }\r\n"
  					+ "          th, td {\r\n"
  					+ "            border: 1px solid black;\r\n"
  					+ "            padding: 8px;\r\n"
  					+ "            text-align: left;\r\n"
  					+ "          }\r\n"
  					+ "          th {\r\n"
  					+ "            background-color: #f2f2f2;\r\n"
  					+ "          }\r\n"
  					+ "          tr:nth-child(even) {\r\n"
  					+ "            background-color: #f9f9f9;\r\n"
  					+ "          }\r\n"
  					+ "        </style>\r\n"
  					+ "      </head>\r\n"
  					+ "      <body>\r\n"
  					+ "        <h2>Taula de Dades</h2>\r\n"
  					+ "        <table>\r\n"
  					+ "          <thead>\r\n"
  					+ "            <tr>");
  			for (int i = 0; i < nomTipusDada.length; i++) {
  				if(nomTipusDada[i]!= null) {
  					impressora.println("              <th>"+nomTipusDada[i]+"</th>");
  				}			
  			}
  			impressora.println("            </tr>\r\n"
  					+ "          </thead>\r\n"
  					+ "          <tbody>\r\n"
  					+ "            <xsl:for-each select=\"//linea\">\r\n"
  					+ "              <tr>");
  			
  			for (int i = 0; i < nomTipusDada.length; i++) {
  				if(nomTipusDada[i]!= null) {
  					impressora.println("              <td><xsl:value-of select=\".//"+nomTipusDada[i]+"\"></xsl:value-of></td>");
  				}
  			}
  			impressora.println("              </tr>\r\n"
  					+ "            </xsl:for-each>\r\n"
  					+ "          </tbody>\r\n"
  					+ "        </table>\r\n"
  					+ "      </body>\r\n"
  					+ "    </html>\r\n"
  					+ "  </xsl:template>\r\n"
  					+ "</xsl:stylesheet>");
  			
  			impressora.flush();
  			impressora.close();
  		
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  	}
  	
  	//Funcio per crear el xml
  	//crearXml(dadesCrear2, dadesCrear, quantitatDades);
  	public static void crearXml (
			String [][] dadesCrear,
			String [] nomTipusDada,
			int quantitatDades) {
		
		File desti=new File(rutaUbicacio+"\\Dades.xml");
		try {
			PrintWriter impressora= new PrintWriter(desti);
			impressora.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
					+ "<?xml-stylesheet type=\"text/xsl\" href=\"Dades.xsl\"?>\r\n"
					+ "<Dades xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"Dades.xsd\">");
			for (int i = 0; i < quantitatDades; i++) {
				impressora.println("    <linea>");
				for (int j = 0; j < dadesCrear.length; j++) {
					if(nomTipusDada[j]!= null) {
						impressora.println("        <"+nomTipusDada[j]+">"+dadesCrear[j][i]+"</"+nomTipusDada[j]+">");
					}
				}
				impressora.println("    </linea>");
			}
			impressora.println("</Dades>");
			
			impressora.flush();
			impressora.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
  	}
  //Funcio per crear el XSD
  	
  //Funció per crear l'arxiu xsd
  	//crearXsd(dadesCrear);
  	
  	public static void crearXsd (String nomTipusDada[]) {
  		File desti=new File(rutaUbicacio+"\\Dades.xsd");
  		try {
  			PrintWriter impressora= new PrintWriter(desti);
  			//Primer de tot imprimim les primeres linies del document, que seràn sempre les mateixes
  			impressora.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
  					+ "<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">");
  			for (int i = 0; i < nomTipusDada.length; i++) {
  				/*
  				 * A dadesGenerar tenim guardat els noms de les dades que volem generar, per tant si el
  				 * valor es null, es que aquelles dades no ens interessen. S'han de guardar amb el mateix ordre
  				 * de valors, per exemple nom sempre a la posició 0, cognoms a la 1 etc.. es el mateix ordre
  				 * que en el enunciat.
  				 */
  				if(nomTipusDada[i]!= null) {
  					/*
  					 * Els elements boolean, numero i dates son diferets de la resta pel fet de que el tipus 
  					 * no es string, doncs primer amb aquest if controlem aquestes tres dades.
  					 */
  					if (i== 10) {
  						impressora.println("    <xs:element name=\"boolean\" type=\"xs:boolean\"></xs:element>");
  					}else if(i==11) {
  						impressora.println("    <xs:element name=\"numero\" type=\"xs:integer\"></xs:element>");
  					}else if(i==15) {
  						impressora.println("    <xs:element name=\"dates\" type=\"xs:date\"></xs:element>");
  					}else {
  						impressora.println("    <xs:element name=\"" +nomTipusDada[i]+ "\" type=\"xs:string\"></xs:element>");
  					}
  				}			
  			}
  			/*
  			 * Aquest bloc tambés es identic en tots els casos, per tant l'imprimim sense
  			 * controlar variables ni res semblant
  			 */
  			impressora.println(" <xs:element name=\"linea\">\r\n"
  					+ "        <xs:complexType>\r\n"
  					+ "            <xs:sequence>");
  			/*
  			 * Amb aquest for imprimim totes les linies dels elements fent referencia als elements
  			 * declarats anteriorment
  			 */
  			for (int i = 0; i < nomTipusDada.length; i++) {
  				if(nomTipusDada[i]!= null) {
  					impressora.println("                <xs:element ref=\"" +nomTipusDada[i]+"\" maxOccurs=\"unbounded\" minOccurs=\"0\"/>");
  				}
  			}
  			/*
  			 * Aqui imprimim les ultimes linies del document, que un altre cop, 
  			 * son sempre les mateixes, per tant no es necessàri ni un bucle ni variables
  			 */
  			impressora.println("            </xs:sequence>\r\n"
  					+ "        </xs:complexType>\r\n"
  					+ "    </xs:element>\r\n"
  					+ "\r\n"
  					+ "\r\n"
  					+ "    <xs:element name=\"Dades\">\r\n"
  					+ "        <xs:complexType>\r\n"
  					+ "            <xs:sequence>\r\n"
  					+ "                <xs:element ref=\"linea\" maxOccurs=\"unbounded\"></xs:element>\r\n"
  					+ "            </xs:sequence>\r\n"
  					+ "        </xs:complexType>\r\n"
  					+ "    </xs:element>\r\n"
  					+ "</xs:schema>");
  			impressora.flush();
  			impressora.close();
  		} catch (Exception e) {
  			e.printStackTrace();
  		}
  	}
	// Debemos leer el archivo de datos y crear a partir de este los archivos SQL y XML/XSD/XSLT
	public static void creacioDeSql(String ruta,int linies,String [][] dadesCrear2 ) throws IOException {
		
		//Le doy nombre al SQL 
		String test="\\Arxiu.sql";
		//Creo el file per a escriure en ell
		File arxiuSql = new File(ruta+test);
		//Miro si el file existeix i el canvio si es nesesari
		int i=0;
		while (arxiuSql.exists()) {
			i++;
			test="";
			test="\\Arxiu("+i+").sql";
			arxiuSql =new File(ruta+test);
		}
		//Junto la ruta per despres escriure en el arciu
		ruta=ruta+test;
		//Creo el fitxer i crido la funcio per a crear la taula 
		arxiuSql.createNewFile();
		String noms[]=new String[10];
		creacioDeTaula(linies,dadesCrear2,ruta,noms);
	}
	//Funcio per a Creacio de SQL
	public static void creacioDeTaula(int linies,String [][]dadesCrear2 ,String ruta,String[]nom) throws IOException{
		//Declaro el escritor i escric lo nesesari per a crear i utilitza la base de dades
		BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));
		writer.write("CREATE DATABASE IF NOT EXISTS TaulaPerMostrarDades;\n");
		writer.write("USE TaulaPerMostrarDades;\n\n");
		//Creo la taula i variables que utilitza-re
		writer.write("CREATE TABLE DadesGenarades(");
		int j=0;
        String test="";
        //El bucle serveix per a escriure el tipo de valors que hi hauran a la taula amb el seu nom
        for (int i = 0; i < dadesCrear2.length; i++) {
        	//Comprobo si hi ha algo a escriure
			if (dadesCrear2[i][0]!=null) {
				//Condicio per a escriure ints en la primera bolta
				if (j==0&&(i==18||i==11)) {
					writer.write(nom+" INT");
					test="("+nom;
					j++;
				}else if(j==0&&i==10){//Condicio per a escriure booleans en la primera bolta
					writer.write(nom+" BOOLEAN");
					test="("+nom;
					j++;
				}else if (j==0&&(i!=18||i!=11)) {//Condicio per a escriure Strings en la primera bolta
					writer.write(nom+" VACHAR(100)");
					test="("+nom;
					j++;
				}else if (i==18||i==11) {//Condicio per a escriure ints
					writer.write(" ,"+nom+" INT");
					test=test+","+nom;
				}else if (i== 10) {//Condicio per a escriure booleans
					writer.write(","+nom+" BOOLEAN");
					test=test+","+nom;
				}else {//Condicio per a escriure Strings
					writer.write(","+nom+" VACHAR(100)");
					test=test+","+nom;
				}
			}
		}
        writer.write(");\n");
        //Li dono valor a les variables
        j=0;
        int i=0;
        //Bucle per a crear tots els inserts necessaris
        for (int k = 0; k < linies; k++) {
        	//Comprobo si hi ha algo a escriure
        	if (dadesCrear2[i][k]!=null) {
        		//Escric cada insert
        		writer.write("INSERT INTO DadesGenarades "+test+") VALUES (");
        		//
        		for ( i = 0;i  < dadesCrear2.length;i++) {
	        		if (dadesCrear2[i][k]!=null) {
	        			if (j==0&&(k==11||k==18)) {
	            			writer.write(dadesCrear2[i][k]);
	            			j++;
	    				}else if (j==0) {
	    					writer.write(" '"+dadesCrear2[i][k]+"'");
	            			j++;
	    				}else if (i==10||i==11) {
	    					writer.write(", "+dadesCrear2[i][k]);
	    				}else {
	    					writer.write(", '"+dadesCrear2[i][k]+"'");
	    				}
					}
				}
	        	writer.write(");\n");
	    		i=0;
        	}
        }
        
        writer.flush();
        writer.close();
	}
	public static String[][] lectorArxius(int linies,String[] arxiusALlegir,int aleatori) throws IOException{
		String perLlegit[][]=new String[arxiusALlegir.length][linies];
		String files_dades[]= {"Dades/1-Noms.txt","Dades/2-Cognoms.txt","Dades/3-Ciutat.txt","Dades/4-Adreces.txt","Dades/5.Proffesions.txt","Dades/6.Pais.txt","Dades/7.Estudis.txt","Dades/8.Colors.txt","Dades/10.NomDeLaCompanyia"};
		for (int i = 0; i < arxiusALlegir.length; i++) {
			BufferedReader br = new BufferedReader(new FileReader(arxiusALlegir[i]));
			llegir(br, perLlegit[i],aleatori,linies,0);
		}
		int fets=0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < perLlegit.length; j++) {
				if (arxiusALlegir[j].equals(files_dades[i])) {
					dadesCrear[i]=perLlegit[j];
					j=perLlegit.length;
					fets++;
				}else if(fets==perLlegit.length) {
					i=10;
					j=perLlegit.length;
				}
			}
		}
		
		return dadesCrear;
		/*
		
		*/
	}
	public static void llegir(BufferedReader br,String[]llegit,int aleatori,int linies,int especial) throws IOException{
		String text[]=new String[2];
		//L'asicno la llargada a les arrays que s'utilitzaran
		int j=0,posicioArray,numAleatori2=aleatori,largadaArxiu=250,largadaGenera=linies;
		numAleatori2=aleatori-1;
		largadaGenera=numAleatori2+largadaGenera;
		posicioArray=largadaGenera-largadaArxiu;
		if (posicioArray>0) {//Condicio per si mirar que tot cap a la array respecte el num aleatori
			//calculo quina posicio li correspont a la primera linia
			posicioArray=linies-posicioArray;
			//Bucle per a lleguir i guardar a la posicio corresponent
			for (int i = 0; i < largadaArxiu; i++) {
				text[1]=br.readLine();
				if (posicioArray<linies) {//Guardo a les ultimes posicions del array les primeres linies 
					text=text[1].split("#");
					llegit[posicioArray]=text[1];
					posicioArray++;
				}else {
					if (i>=numAleatori2&&j<linies) {//Guardo la resta de linies amb el ordre correcte a la posicio del num aleatori
						text=text[1].split("#");
						llegit[j]=text[1];
						j++;
					}
				}
			}
		}else {//Si que hi cap respecte el aleatori 
			//bucle per a llegir de una sense fer els calculs
			for (int i = 0; j < linies; i++) {
				text[1]=br.readLine();
				if (i>=aleatori&&j<linies) {
					text=text[1].split("#");
					llegit[j]=text[1];
					j++;
				}
			}
		}
	}
	//Funcio per a trovar i tornar el nom de la dada a generar
	public static String buscarNom(int id) {
		if (id == 0) {
	        return "Nom";
	    } else if (id == 1) {
	        return "Cognoms";
	    } else if (id == 2) {
	        return "Ciutats";
	    } else if (id == 3) {
	        return "Adreces";
	    } else if (id == 4) {
	        return "Professions";
	    } else if (id == 5) {
	        return "País";
	    } else if (id == 6) {
	        return "Estudis";
	    } else if (id == 7) {
	        return "Colors";
	    } else if (id == 8) {
	        return "URL";
	    } else if (id == 9) {
	        return "Nom_de_la_companyia";
	    } else if (id == 10) {
	        return "Boolean";
	    } else if (id == 11) {
	        return "Number";
	    } else if (id == 12) {
	        return "Emails";
	    } else if (id == 13) {
	        return "IP4";
	    } else if (id == 14) {
	        return "Password";
	    } else if (id == 15) {
	        return "Dates";
	    } else if (id == 16) {
	        return "IBAN";
	    } else if (id == 17) {
	        return "DNI";
	    } else if (id == 18) {
	        return "Autonumèric";
	    } else {
	        return ""; // Si no coincide con ningún id
	    }
	}
}