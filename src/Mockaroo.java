import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;

public class Mockaroo {
	
	public static String rutaUbicacio = "";
	public static void main(String[] args) {
		
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
	// ·Leemos archivos con funciones y generamos estos a partir de otras funciones ->
	// Funcio per llegir els arxius de dades
	
	
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
	public static void url(int llargada,String urls[],String[] files_dades,int aleatori) {
		try {
			//GENERO LA URL DESDE EL NOM DE COMPANYIA 
			BufferedReader br = new BufferedReader(new FileReader(files_dades[8]));
			String text[]=new String[2];
			//L'asicno la llargada a les arrays que s'utilitzaran
			int j=0,posicioArray,numAleatori2=aleatori,largadaArxiu=250,largadaGenera=llargada;
			numAleatori2=aleatori-1;
			largadaGenera=numAleatori2+largadaGenera;
			posicioArray=largadaGenera-largadaArxiu;
			if (posicioArray>0) {
				//calculo quina posicio li correspont a la primera linia
				posicioArray=llargada-posicioArray;
				for (int i = 0; i < largadaArxiu; i++) {
					text[1]=br.readLine();
					if (posicioArray<llargada) {
						text=text[1].split("#");
						urls[posicioArray]="www."+text[1]+".com";
						posicioArray++;
					}else {
						if (i>=numAleatori2&&j<llargada) {
						text=text[1].split("#");
						urls[j]="www."+text[1]+".com";
						System.out.println(urls[j]);
						j++;
						}
					}
				}
			}else {
				for (int i = 0; j < llargada; i++) {
					text[1]=br.readLine();
					if (i>=aleatori&&j<llargada) {
						text=text[1].split("#");
						urls[j]="www."+text[1]+".com";
						System.out.println(urls[j]);
						j++;
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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
  	
	// ·Leemos archivos con funciones y generamos estos a partir de otras funciones ->
	// ·Funcion boolean sin formatos
	// ·Funcion int para indicar los 'decimales=0','minims=0 i maxims=1000'
	// ·Funcion String para indicar el nombre del dominio='nom de comapnyia'
	// ·Funcion IP4 ???
	// ·Funcion String ha de indicar 'letras,numeros,mayusculas,minusculas,simbolos y longitud'
	// ·Funcion String ha de indicar el 'any minim=1900 i maxim=2023'
	// ·Funcion para IBAN o DNI (Hay como buscar como se generan)
	// ·Funcion int ha de indicar el 'valor d'inici=1'
	//*****************************
	// Debemos leer el archivo de datos y crear a partir de este los archivos SQL y XML/XSD/XSLT
	public static void creaciDeSql(String ruta,int linies,String [][] dadesCrear2 ) throws IOException {
		
		System.out.println(ruta);
		String test="\\Arxiu.sql";
		File arxiuSql = new File(ruta+test);
		
		int i=0;
		
		while (arxiuSql.exists()) {
			i++;
			test="";
			test="\\Arxiu("+i+").sql";
			arxiuSql =new File(ruta+test);
		}
		ruta=ruta+test;
		arxiuSql.createNewFile();
		creacioDeTaula(linies,dadesCrear2,ruta);
	}
	//Creacio de SQL
	public static void creacioDeTaula(int linies,String [][]dadesCrear2 ,String ruta) throws IOException{
		BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));
		writer.write("CREATE DATABASE IF NOT EXISTS TaulaPerMostrarDades;\n");
		writer.write("USE TaulaPerMostrarDades;\n\n");
		writer.write("CREATE TABLE DadesGenarades(");
		int j=0;
        String test="";
        for (int i = 0; i < dadesCrear2.length; i++) {
			if (dadesCrear2[i][0]!=null) {
				if (j==0&&(i==18||i==11)) {
					writer.write(dadesCrear2[i][0]+" INT");
					test="("+dadesCrear2[i][0];
					j++;
					
				}else if(j==0&&i==10){
					writer.write(dadesCrear2[i][0]+" BOOLEAN");
					test="("+dadesCrear2[i][0];
					j++;
				}else if (j==0&&(i!=18||i!=11)) {
					writer.write(dadesCrear2[i][0]+" VACHAR(100)");
					test="("+dadesCrear2[i][0];
					j++;
				}else if (i==18||i==11) {
					writer.write(" ,"+dadesCrear2[i][0]+" INT");
					test=test+","+dadesCrear2[i][0];
				}else if (i== 10) {
					writer.write(","+dadesCrear2[i][0]+" BOOLEAN");
					test=test+","+dadesCrear2[i][0];
				}else {
					writer.write(","+dadesCrear2[i][0]+" VACHAR(100)");
					test=test+","+dadesCrear2[i][0];
				}
			}
		}
       
        writer.write(");\n\n");
        j=0;
        int i=0;
        for (int k = 0; k < linies; k++) {
        	if (dadesCrear2[i][k]!=null) {
        		writer.write("INSERT INTO DadesGenarades "+test+") VALUES (");
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

}