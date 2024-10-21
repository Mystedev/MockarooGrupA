import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;

public class Mockaroo {
	public static Scanner reader = new Scanner(System.in);
	public static Random random = new Random();
	public static int contador = 0;
	public static String dniGenerat[]=new String[1000];
	public static String rutaUbicacio = "";
	public static int quantitatLlargada;
	
	public static void main(String[] args) {
		try {
		    // Array amb arxius de dades
		    String files_dades[] = {
		        "Dades/1-Noms.txt", "Dades/2-Cognoms.txt", "Dades/3-Ciutat.txt",
		        "Dades/4-Adreces.txt", "Dades/5-Proffesions.txt", "Dades/6-Pais.txt",
		        "Dades/7-Estudis.txt", "Dades/8-Colors.txt", "null", "Dades/10-NomDeLaCompanyia.txt"
		    };
		    // Arxiu d'entrada
		    String fileEntrada = "Dades/Requisits.txt";
		    BufferedReader br = new BufferedReader(new FileReader(fileEntrada));
		    String firstLine = br.readLine();
		    String line;
		    while ((line = br.readLine()) != null) {
		        // Cada linea conte numeros separats per espais
		        String[] indicesStr = line.split(" ");
		        int[] indices = new int[indicesStr.length];
		        // Convertir cada index a un enter i validar-lo
		        for (int i = 0; i < indicesStr.length; i++) {
		            try {
		                indices[i] = Integer.parseInt(indicesStr[i]);
		            } catch (Exception e) {
		                System.out.println("Error: Índice no válido en la entrada: " + indicesStr[i]);
		            }
		        }
		        // Llegir els arxius 
		        String[] archivosSeleccionados = processarIndexs(files_dades, indices);
		        
		        // Imprimir els arxius seleccionats
		        for (int i = 0; i < archivosSeleccionados.length; i++) {
		            if (archivosSeleccionados[i] != null) {
		                System.out.println(archivosSeleccionados[i]);
		            }
		        }
		    }
		    // Processament de la primera linea 
		    String formatArxiu[] = firstLine.split("#");
		    // Primera linea validada
		    String formatValid = ValidarFormatEntrada(firstLine, formatArxiu);
		    System.out.println(formatValid);
		    rutaUbicacio = formatArxiu[2];
		    br.close();
		    reader.close();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	// Funció que llegeix l'array segons els indexs proporcionats
	public static String[] processarIndexs(String[] archivos, int[] indices) {
	    String[] resultados = new String[indices.length];
	    
	    for (int i = 0; i < indices.length; i++) {
	        int index = indices[i];
	        
	        // Verificar si el index està dins del rang per als arxius
	        if (index >= 1 && index <= archivos.length) {
	            resultados[i] = archivos[index - 1]; // Desar arxiu a l'array
	        } 
	        // Verificar si el index està dins del rang per a les funcions
	        /*else if (index >= 11 && index <= 19) {
	            resultados[i] = executarFuncio(index); // Executar funció segons l'index
	        } */
	        else {
	            resultados[i] = "Índice " + index + " fuera de rango.";
	        }
	    }
	    return resultados; // Retornar els resultats
	}
	
    // Funcio per llegir les funcions a dins de l'arxiu requisits
	// Funcio creada per validar el format del fitxer d'entrada
	public static String ValidarFormatEntrada(String arxiuGenerat,String formatArxiu[]) {
		// Comprovar la longitud de l'array i el format correctament
		boolean isCorrect = false; // Inicialment, no és correcte
		// Bucle que demana correccions fins que tot el format sigui correcte
		while (!isCorrect) {
		// Comprovar si l'array té 3 elements
			if (formatArxiu.length != 3 ) {
				System.out.println("Error -> El format de l'arxiu ha de tenir 3 elements: 'Tipus de Arxiu'#'Quantitat de registres'#'Ubicació'");
				return null;
		    }
		    // Comprovar que el tipus d'arxiu és "SQL" o "XML"
		    else if (!(formatArxiu[0].equalsIgnoreCase("XML") || formatArxiu[0].equalsIgnoreCase("SQL"))) {
		        System.out.println("Error -> El tipus d'arxiu ha de ser 'SQL' o 'XML'");
		        return null;
		    }
		    // Comprovar que el segon element és un nombre vàlid
		    else if (!esNumeroValid(formatArxiu[1])) {
		        System.out.println("Error -> La quantitat de registres ha de ser un número positiu entre 1 i 250.");
		        return null;
		    }
		    // Comprovar que la ubicació és "DOCUMENTOS"
		    else if (!formatArxiu[2].equalsIgnoreCase("DOCUMENTOS")) {
		        System.out.println("Error -> La ubicació ha de ser 'DOCUMENTOS'.");
		        return null;
		    } else {
		        // Si tot és correcte, sortir del bucle
		    	System.out.println("Formato Válido.");
		        isCorrect = true;
		     }
		}
		// Retornar la línia correcta quan tot sigui correcte
		return arxiuGenerat;
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
	// Funcio per genear dates
	public static String dates(int largada,int anyMinim,int anyMaxim,int aleatori) {
		Random random = new Random();
		String data[]=new String [largada];
		int test;
		if(anyMaxim<anyMinim) {
			test=anyMaxim;
			anyMaxim=anyMinim;
			anyMinim=test;
		}
		for (int i = 0; i < data.length; i++) {
			int any=random.nextInt(anyMaxim-anyMinim)+anyMinim,mes=random.nextInt(12)+1,dia;
			dia=diesMes(mes,any);
			if (dia==-1) {
				System.out.println("ERROR");
			}else {
				dia=random.nextInt(dia)+1;
				data[i]= dia+"/"+mes+"/"+any;
				System.out.println(data[i]);
			}
		}
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
		    // Febrero (28 en años comunes, 29 en años bisiestos)
		    // Implementar lógica para determinar si es año bisiesto
		    if ((any % 4 == 0 && any % 100 != 0) || (any % 100 == 0 && any % 400 == 0))
		    {
		      return 29;
		    } else {
		      return 28;
		    }
		  }else {
			  return -1;
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
        // Redondearem el numero especificat a partir de la quantitat de decimals demanats
        double escala = Math.pow(10, decimals);
        numeroAleatorio = Math.round(numeroAleatorio * escala) / escala;
		// Al declarar el resultat de la funcio , haurem de especificar en ordre , la quantitat de decimals que volem, el rang minim i el rang maxim
        // Decimals -> 0 per defecte * Minim -> 0 per defecte * Maxim -> 1000 per defecte
		return numeroAleatorio;
	}
	// ·Funcion String para indicar el nombre del dominio='nom de comapnyia'
		public static String email(int largada,String emails[],int aleatori) {
			Random random = new Random();
			Scanner teclat=new Scanner (System.in);
		try {
			BufferedReader br = new BufferedReader(new FileReader("Dades/1-Noms.txt"));
			BufferedReader br2 = new BufferedReader(new FileReader("Dades/1-Noms.txt"));
			BufferedReader br1 = new BufferedReader(new FileReader("Dades/10-NomDeLaCompanyia.txt"));
			BufferedReader br3 = new BufferedReader(new FileReader("Dades/10-NomDeLaCompanyia.txt"));
			String nomCompanyia[]=new String[2];
			String nom[]=new String[2];
			emails=new String [largada];
			int j=0;
			for (int i=0 ; j <largada&&i<250; i++) {
				nom[1]= br.readLine();
				nom=nom[1].split("#");
				if (i>=aleatori&&j<largada) {
					emails[j] =nom[1]+"@";
					j++;
				}
			}
			for (int i=0 ; i <=aleatori&&j<largada ; i++) {
				nom[1]= br2.readLine();
				nom=nom[1].split("#");
				emails[j] = nom[1]+"@";
				j++;
			}
			j=0;
			for (int i=0 ; j <largada&&i<250; i++) {
				nomCompanyia[1]=br1.readLine();
				nomCompanyia=nomCompanyia[1].split("#");
				if (i>=aleatori&&j<largada) {
					emails[j] = emails[j]+nomCompanyia[1]+".com";
					System.out.println(emails[j]);
					j++;
				}
			}
			
			for (int i=0 ; i <=aleatori&&j<largada ; i++) {
				nomCompanyia[1]=br3.readLine();
				nomCompanyia=nomCompanyia[1].split("#");
				emails[j] = emails[j]+nomCompanyia[1]+".com";
				System.out.println(emails[j]);
				j++;
			}
			//+nomCompanyia[1]+".com"
			return "a";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// ·Funcion IP4 ???
		//Per cridar-la dadesIp4(quantitatDades, Array on guardar les ip)
		public static void dadesIp4(int quantitatDades, String[] dadesIp4) {
		    Random random = new Random();
		    // Fem un bucle amb tantes voltes com dades a generar
		    for (int i = 0; i < quantitatDades; i++) {
		        // Generem i guardem els valors
		        dadesIp4[i] = random.nextInt(256) + "." + random.nextInt(256) + "." + random.nextInt(256) + "." + random.nextInt(256);
		    }
		}
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
    	Scanner reader = new Scanner(System.in);
    	// Paràmetres de exemple
        boolean inclouLletres = true;
        boolean inclouNumeros = true;
        boolean inclouMajuscules = true;
        boolean inclouMinuscules = true;
        boolean inclouSymbols = true;
        System.out.println("Introdueix la longitud de la contrasenya :");
        int longitud = reader.nextInt();  // Longitud de la contrasenya
        
        String password = GenerarPassword(inclouLletres, inclouNumeros, inclouMajuscules, 
                                          inclouMinuscules, inclouSymbols, longitud);
        // Mostrar la contrasenya generada
        System.out.println("Contrasenya generada exitosament: " + password);
    }
	// ·Funcion String ha de indicar el 'any minim=1900 i maxim=2023'
	// ·Funcion para IBAN 
    //Per cridarla: iban( numeroAleatori, quantitatDades, Array on guardar els ibans)
    private static void iban (int numeroAleatori, int quantitatDades, String [] iban) {
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
            		iban[contador] = generarIban(liniesFitxer[llegirLinea]);
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
            		iban[contador] = generarIban(liniesFitxer[llegirLinea]);
                	llegirLinea++;
                	contador++;
            	}
            	llegirLinea = 0;
            	for(int l = 0; l < dadesRestants; l++) {
            		//amb aquest for generem ibans des de la linea 0 del
            		//array fins haver generat totes les dades restants
            		iban[contador] = generarIban(liniesFitxer[llegirLinea]);
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
    	String CHARACTERS = "TRWAGMYFPDXBNJZSQVHLCKE";
    	// La resta de la divisio de la longitud total del 'string' dels caracters ens dona la posicio de la lletra, es a dir  '23'
    	int rest = dni % CHARACTERS.length();
    	return CHARACTERS.charAt(rest);
    }
    // Funcio per saber si ja existeix el DNI
    public static boolean existeixDni(String dni) {
    	for(int i=0;i< contador;i++) {
    		if(dniGenerat[i].equals(dni)) {
    			return true;// El dni ja existeix
    		}
    	}
    	return false;// El dni no existeix
    }
    // Funcion per obtenir el umero de DNI aleatori
    public static String ObtenerDNI() {
    	random = new Random();
    	String dniResult = "";
    	
    	while(existeixDni(dniResult)) {
    		// Generem un numero maxim de 8 digits
    		int numeroDni = random.nextInt(90000000)+10000000;
    		// Obtenim la lletra corresponent al numero
    		char lletra = GenerarLetraDNI(numeroDni);
    		// Combinem numero i lletra
    		dniResult = numeroDni + String.valueOf(lletra);
    	}
    	if (existeixDni(dniResult)) {
            System.out.println("DNI repetido: " + dniResult);
        }
    	if(contador < 1000) {
    		dniGenerat[contador] = dniResult;
    		contador++;
    	}else {
    		System.out.println("S'ha alcanzat el numero maxim de possibles DNIs");
    	}
    	return dniResult;
    }
	// ·Funcion int ha de indicar el 'valor d'inici=1'
    public static void autonumeric(int llargada,int num[],int valorPerDefecte) {
		num=new int[llargada];
		for (int i = 0; i <llargada; i++) {
			num[i]=valorPerDefecte;
			valorPerDefecte++;
			System.out.println(num[i]);
		}
	}
	//*****************************
	// Debemos leer el archivo de datos y crear a partir de este los archivos SQL y XML/XSD/XSLT

    
    //Funcions creació XML, XSD i XSL
    
  //Funcio per crear l'arxiu xsl
    //crearXsl(dadesCrear);
  	public static void crearXsl (String [] dadesCrear) {
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
  			for (int i = 0; i < dadesCrear.length; i++) {
  				if(dadesCrear[i]!= null) {
  					impressora.println("              <th>"+dadesCrear[i]+"</th>");
  				}			
  			}
  			impressora.println("            </tr>\r\n"
  					+ "          </thead>\r\n"
  					+ "          <tbody>\r\n"
  					+ "            <xsl:for-each select=\"//linea\">\r\n"
  					+ "              <tr>");
  			
  			for (int i = 0; i < dadesCrear.length; i++) {
  				if(dadesCrear[i]!= null) {
  					impressora.println("              <td><xsl:value-of select=\".//"+dadesCrear[i]+"\"></xsl:value-of></td>");
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
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  	}
  	
  	//Funcio per crear el xml
  	//crearXml(dadesCrear2, dadesCrear, quantitatDades);
  	public static void crearXml (
			String [][] dadesCrear2,
			String [] dadesCrear,
			int quantitatDades) {
		
		File desti=new File(rutaUbicacio+"\\Dades.xml");
		try {
			PrintWriter impressora= new PrintWriter(desti);
			impressora.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
					+ "<?xml-stylesheet type=\"text/xsl\" href=\"Dades.xsl\"?>\r\n"
					+ "<Dades xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"Dades.xsd\">");
			for (int i = 0; i < quantitatDades; i++) {
				impressora.println("    <linea>");
				for (int j = 0; j < dadesCrear2.length; j++) {
					if(dadesCrear[j]!= null) {
						impressora.println("        <"+dadesCrear[j]+">"+dadesCrear2[j][i]+"</"+dadesCrear[j]+">");
					}
				}
				impressora.println("    </linea>");
			}
			impressora.println("</Dades>");
			
			impressora.flush();
			impressora.close();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
  	
  //Funcio per crear el XSD
  	
  //Funció per crear l'arxiu xsd
  	//crearXsd(dadesCrear);
  	public static void crearXsd (String dadesCrear[]) {
  		File desti=new File(rutaUbicacio+"\\Dades.xsd");
  		try {
  			PrintWriter impressora= new PrintWriter(desti);
  			//Primer de tot imprimim les primeres linies del document, que seràn sempre les mateixes
  			impressora.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
  					+ "<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">");
  			for (int i = 0; i < dadesCrear.length; i++) {
  				/*
  				 * A dadesGenerar tenim guardat els noms de les dades que volem generar, per tant si el
  				 * valor es null, es que aquelles dades no ens interessen. S'han de guardar amb el mateix ordre
  				 * de valors, per exemple nom sempre a la posició 0, cognoms a la 1 etc.. es el mateix ordre
  				 * que en el enunciat.
  				 */
  				if(dadesCrear[i]!= null) {
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
  						impressora.println("    <xs:element name=\"" +dadesCrear[i]+ "\" type=\"xs:string\"></xs:element>");
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
  			for (int i = 0; i < dadesCrear.length; i++) {
  				if(dadesCrear[i]!= null) {
  					impressora.println("                <xs:element ref=\"" +dadesCrear[i]+"\" maxOccurs=\"unbounded\" minOccurs=\"0\"/>");
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
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  	}
}