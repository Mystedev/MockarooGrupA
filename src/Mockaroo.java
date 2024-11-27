import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Random;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

public class Mockaroo {
	// Variables i metodes globals del programa
	public static String rutaUbicacio;
	public static int quantitatTipusDades;
	public static int[] idDades;
	public static int quantitatDades;
	public static String[][] tipusDada;
	public static String dadesCrear[][];
	public static String files_dades[] = { "Dades/1-Noms.txt", "Dades/2-Cognoms.txt", "Dades/3-Ciutat.txt",
			"Dades/4-Adreces.txt", "Dades/5-Proffesions.txt", "Dades/6-Pais.txt", "Dades/7-Estudis.txt",
			"Dades/8-Colors.txt", "null", "Dades/10-NomDeLaCompanyia.txt" };
	// Parametres utilitzats a les funcions
	public static void main(String[] args) {
		try {
			String lineContador;
			String fileEntrada = "Dades/Requisits.txt";
			int columnes=0,contadorRepetits=0;
			BufferedReader br1=new BufferedReader(new FileReader(fileEntrada));
			// Leer y procesar la primera línea
			String firstLine = br1.readLine();
			String[] formatArxiu={};
			boolean errors=false;
			if (firstLine != null) {
				formatArxiu = firstLine.split("#");
				if (validarFormatEntrada(firstLine, formatArxiu)) {
					System.out.println("Archivo válido. {" + firstLine + "}");
				} else {
					System.out.println("Formato no válido.");
					errors=true;
				}
			} else {
				System.out.println("El archivo está vacío.");

				errors=true;
			}
			while((lineContador = br1.readLine()) != null) {
				if(lineContador.equals("")) {
					System.out.println("No poden haver espais en blanc");
					errors=true;
				}else {
					String[] lineas = lineContador.split("#");
					for (int i = 0; i < lineas.length; i++) {
						if (lineas[i].equals("")) {
							System.out.println("El format no es correcte a de haver id#nom ");
							errors=true;
						}
					}
					char[] indice = lineas[0].toCharArray();
					if(indice.length>2) {
						System.out.println("Tamaño de indice no valido");
						errors=true;
					}
					if(indice.length==2) {
						
						if(!Character.isDigit(indice[0]) || !Character.isDigit(indice[1])) {
							System.out.println("Indice no valido, tienen que ser digitos");
							errors=true;
						}else {
							int indiceCompleto = Integer.parseInt(lineas[0]);
							if(indiceCompleto>19 || indiceCompleto<1) {
								System.out.println(lineContador);
								System.out.println("indice no valido, debe estar entre 1 y 19");
								errors=true;
							}
							switch(indiceCompleto){
								case 10:
									if(lineas.length!=2) {
										System.out.println(lineContador);
										System.out.println("Entrada incorrecta, debe contener id#nombre");
										errors=true;
									}
									contadorRepetits++;
									break;
								case 11:
									if(lineas.length!=2) {
										System.out.println(lineContador);
										System.out.println("Entrada incorrecta, debe contener id#nombre");
										errors=true;
									}
									break;
								case 12:
									if(lineas.length<2 || lineas.length>5) {
										System.out.println(lineContador);
										System.out.println("Entrada incorrecta, debe contener id#nombre como minimo \nComo pocional puede ser \nid#nombre#decimales \nid#nombre#decimales#minimo \nid#nombre#decimales#minimo#maximo");
										errors=true;
									}
									if(lineas.length==3) {
										char[] decimals = lineas[2].toCharArray();
										for(int i = 0; i<decimals.length; i++) {
											if(!Character.isDigit(decimals[i])) {
												System.out.println(lineContador);
												System.out.println("Parametro no valido, la opcion decimales tiene que ser digitos");
												errors=true;
											}
										}
									}
									if(lineas.length==4) {
										char[] decimals = lineas[3].toCharArray();
										for(int i = 0; i<decimals.length; i++) {
											if(!Character.isDigit(decimals[i])) {
												System.out.println(lineContador);
												System.out.println("Parametro no valido, la opcion minimo tiene que ser digitos");
												errors=true;
											}
										}
										char[] decimals2 = lineas[2].toCharArray();
										for(int i = 0; i<decimals2.length; i++) {
											if(!Character.isDigit(decimals2[i])) {
												System.out.println(lineContador);
												System.out.println("Parametro no valido, la opcion decimales tiene que ser digitos");
												errors=true;
											}
										}
									}
									if(lineas.length==5) {
										char[] decimals2 = lineas[2].toCharArray();
										for(int i = 0; i<decimals2.length; i++) {
											if(!Character.isDigit(decimals2[i])) {
												System.out.println(lineContador);
												System.out.println("Parametro no valido, la opcion decimales tiene que ser digitos");
												errors=true;
											}
										}
										char[] decimals3 = lineas[3].toCharArray();
										for(int i = 0; i<decimals3.length; i++) {
											if(!Character.isDigit(decimals3[i])) {
												System.out.println(lineContador);
												System.out.println("Parametro no valido, la opcion minimo tiene que ser digitos");
												errors=true;
											}
										}
										char[] decimals = lineas[4].toCharArray();
										for(int i = 0; i<decimals.length; i++) {
											if(!Character.isDigit(decimals[i])) {
												System.out.println(lineContador);
												System.out.println("Parametro no valido, la opcion maximo tiene que ser digitos");
												errors=true;
											}
										}
									}
									break;
								case 13:
									if(lineas.length<2 || lineas.length>4) {
										System.out.println(lineContador);
										System.out.println("Entrada incorrecta, debe contener id#nombre como minimo \nLos parametros opcionales son \nid#nombre#dominio \nid#nombre#extensionDominio \nid#nombre#dominio#extensionDominio");
										errors=true;
									}
									break;
								case 14:
									if(lineas.length!=2) {
										System.out.println(lineContador);
										System.out.println("Entrada incorrecta, debe contener id#nombre");
										errors=true;
									}
									break;
								case 15:
									if(lineas.length!=8) {
										System.out.println(lineContador);
										System.out.println("Entrada incorrecta, debe contener id#nombre#letras#numeros#mayusculas#minusculas#simbolos#longitud");					
										errors=true;
									}else {
										for(int i = 2; i<lineas.length-1;i++) {
											char[] opcions = lineas[i].toCharArray();
											
											if(lineas[i].length()!=1) {
												System.out.println(lineContador);
												System.out.println("Entrada incorrecta, las opciones deben ser un digito ( zero o uno )");
												errors=true;
											}
											if(!Character.isDigit(opcions[0])) {
												System.out.println(lineContador);
												System.out.println("Entrada incorrecta, las opciones deben ser un digito ( zero o uno )");
												errors=true;
											}else if(Integer.parseInt(String.valueOf(opcions[0]))!=0 && Integer.parseInt(String.valueOf(opcions[0]))!=1) {
												System.out.println(lineContador);
												System.out.println("Entrada incorrecta, las opciones deben ser un digito ( zero o uno )");
												errors=true;
											}
										}
									} 
									if(Integer.parseInt(lineas[7])<8 || Integer.parseInt(lineas[7])>32) {
										System.out.println(lineContador);
										System.out.println("Entrada incorrecta, la longitud de la contraseña debe ser entre 8 y 32");
										errors=true;
									}
									break;
								case 16:
									if(lineas.length<2 || lineas.length>4) {
										System.out.println(lineContador);
										System.out.println("Entrada incorrecta, debe contener id#nombre como minimo \nLos parametros opcionales son \nid#nombre#añoMinimo \nid#nombre#añoMinimo#añoMaximo");
										errors=true;
									}else if(lineas.length==3) {
										char[] anyMinim = lineas[2].toCharArray();
										for(int i = 0; i < anyMinim.length; i++) {
											if(!Character.isDigit(anyMinim[i])) {
												System.out.println(lineContador);
												System.out.println("Parametro no valido, el año minimo deben ser digitos");
												i=1000;
												errors=true;
											}
										}
									} else if(lineas.length==4) {
										char[] anyMinim = lineas[2].toCharArray();
										for(int i = 0; i < anyMinim.length; i++) {
											if(!Character.isDigit(anyMinim[i])) {
												System.out.println(lineContador);
												System.out.println("Parametro no valido, el año minimo deben ser digitos");
												i=1000;
												errors=true;
											}
										}
										char[] anyMinim2 = lineas[3].toCharArray();
										for(int i = 0; i < anyMinim2.length; i++) {
											if(!Character.isDigit(anyMinim2[i])) {
												System.out.println(lineContador);
												System.out.println("Parametro no valido, el año maximo deben ser digitos");
												i=1000;
												errors = true;
											}		
										}
									}
									break;
								case 17:
									if(lineas.length!=2) {
										System.out.println(lineContador);
										System.out.println("Entrada incorrecta, debe contener id#nombre");
										errors=true;
									}
									break;
								case 18:
									if(lineas.length!=2) {
										System.out.println(lineContador);
										System.out.println("Entrada incorrecta, debe contener id#nombre");
										errors=true;
									}
									break;
								case 19:
									if(lineas.length<2 || lineas.length>3) {
										System.out.println(lineContador);
										System.out.println("Entrada incorrecta, debe contener id#nombre \n los parametros opcionales son \n id#nombre#valorInicio");
										errors=true;
									}else if(lineas.length==3) {
										char[] valorInicio = lineas[2].toCharArray();
										for(int i = 0; i < valorInicio.length; i++) {
											if(!Character.isDigit(valorInicio[i])) {
												System.out.println(lineContador);
												System.out.println("Parametro no valido, el valor de inicio debe ser digitos");
												i=1000;
												errors=true;
											}		
										}
									}
							break;
							}
						}
						
					}
					if(indice.length==1) {
						if(!Character.isDigit(indice[0])) {
							System.out.println("Indice no valido, tienen que ser digitos");
							errors=true;
						}
						if(lineas.length !=2){
							System.out.println(lineContador);
							System.out.println("Entrada incorrecta, debe contener id#nombre");
							errors=true;
						}		
					}
				contadorRepetits++;
				columnes++;
				}
			}
			if (columnes==0) {
				System.out.println("No hi han id#nom el document esta buit");
				errors=true;
			}

			if(!errors) {
				tipusDada=new String[columnes][2];
				// Variables del programa
				Random random = new Random();
				int numeroAleatori[] =new int[contadorRepetits];
				for (int i = 0; i < numeroAleatori.length; i++) {
					numeroAleatori[i]= random.nextInt(200) + 1;
				}
				
				BufferedReader br = new BufferedReader(new FileReader(fileEntrada));
				// Variables generales del main
				int contadorMatriu=0;
				
				int registres,count9=0,count1=0,count2=0,count3=0,count4=0,count5=0,count6=0,count7=0,count8=0,count10=0,count13=0;
				// Leer y procesar la primera línea
				firstLine = br.readLine();
				String arxiuSortida = formatArxiu[0]; // XML/SQL
				registres = Integer.parseInt(formatArxiu[1]); // Cantidad de registros
				rutaUbicacio = formatArxiu[2]; // Ruta donde se guarda el archivo
				dadesCrear=new String[columnes][registres];
				quantitatDades=registres;
				// Leer líneas restantes y procesar índices
				String line;
				while ((line=br.readLine())!=null) {
					if(line.equals("")) {
						return;
					}else {
						int decimal=0;
						int minim=0,maxim=1000;
						boolean inclouLletres=false,inclouNumeros=false,inclouMajuscules=false,inclouMinuscules=false,inclouSimbols=false; 
						int longitud = 0;
						int anyMinim=1900,anyMaxim = 2023;
						int valorPerDefecte = 1;
						String domini="",extencioDomini="";
						String[] indicesStr = line.split("#");
						tipusDada[contadorMatriu][0]=""+indicesStr[0];
						tipusDada[contadorMatriu][1]=indicesStr[1];
						// Convertir y validar índices
							int index = Integer.parseInt(indicesStr[0]);
							if (index >= 1 && index <= 19) {
								if (index==12) {
									if (indicesStr.length==3) {
										decimal=Integer.parseInt(indicesStr[2]);
									}else if(indicesStr.length==4){
										decimal=Integer.parseInt(indicesStr[2]);
										minim=Integer.parseInt(indicesStr[3]);
									}else if(indicesStr.length==5){
										decimal=Integer.parseInt(indicesStr[2]);
										minim=Integer.parseInt(indicesStr[3]);
										maxim=Integer.parseInt(indicesStr[4]);
									}
								}else if(index==13) {
									if (indicesStr.length==3) {
										domini=indicesStr[2];
									}if (indicesStr.length==4) {
										domini=indicesStr[2];
										extencioDomini=indicesStr[3];
									}
								}else if (index==15) {
									if (indicesStr[2].equals("0")) {
										inclouLletres=false;
									}else{
										inclouLletres=true;
									}if(indicesStr[3].equals("0")) {
										inclouNumeros=false;
									}else {
										inclouNumeros=true;
									}if(indicesStr[4].equals("0")) {
										inclouMajuscules=false;
									}else {
										inclouMajuscules=true;
									}if(indicesStr[5].equals("0")) {
										inclouMinuscules=false;
									}else {
										inclouMinuscules=true;
									}if(indicesStr[6].equals("0")) {
										inclouSimbols=false;
									}else {
										inclouSimbols=true;
									}
									longitud=Integer.parseInt(indicesStr[7]);
								}else if (index==16) {
									if (indicesStr.length==3) {
										anyMinim=Integer.parseInt(indicesStr[2]);
									}else if(indicesStr.length==4){
										anyMinim=Integer.parseInt(indicesStr[2]);
										anyMaxim=Integer.parseInt(indicesStr[3]);
									}
								}else if (index==19) {
									if (indicesStr.length==3) {
										valorPerDefecte=Integer.parseInt(indicesStr[2]);
									}
								}
						}
	
					// Procesar índices válidos
						if (index >= 1 && index <= 10) {
							// Procesar archivos de datos
							String archivo = files_dades[index - 1];
							if ("null".equals(archivo)) {
								url( dadesCrear[contadorMatriu], numeroAleatori[count9]);
								count9++;
							}
							if (archivo != null && !"null".equals(archivo)) {
								if(index==1) {
									lectorArxius(index,contadorMatriu, numeroAleatori[count1]);
									count1++;
								}else if (index==2) {
									lectorArxius(index,contadorMatriu, numeroAleatori[count2]);
									count2++;
								}else if (index==3) {
									lectorArxius(index,contadorMatriu, numeroAleatori[count3]);
									count3++;
								}
								else if (index==4) {
									lectorArxius(index,contadorMatriu, numeroAleatori[count4]);
									count4++;
								}else if (index==5) {
									lectorArxius(index,contadorMatriu, numeroAleatori[count5]);
									count5++;
								}else if (index==6) {
									lectorArxius(index,contadorMatriu, numeroAleatori[count6]);
									count6++;
								}else if (index==7) {
									lectorArxius(index,contadorMatriu, numeroAleatori[count7]);
									count7++;
								}else if (index==8) {
									lectorArxius(index,contadorMatriu, numeroAleatori[count8]);
									count8++;
								}
								else if (index==10) {
									lectorArxius(index,contadorMatriu, numeroAleatori[count10]);
									count10++;
								}
								System.out.println("Archivo de datos: " + archivo);
							}
						} else if (index >= 11 && index <= 19) {
							if(index==11)booleans(contadorMatriu);
							else if(index==12) {
								for (int i =0;i<quantitatDades;i++){
									dadesCrear[contadorMatriu][i]=randomNumber(decimal,minim,maxim);
								}
							}
							else if(index==13) {
								email(quantitatDades,dadesCrear[contadorMatriu],files_dades,numeroAleatori[count13],domini,extencioDomini,count13);
								count13++;
							}
							else if(index==14)ip4(contadorMatriu);
							else if(index==15) {generarPassword(inclouLletres,inclouNumeros,inclouMajuscules,
									inclouMinuscules,inclouSimbols,longitud);
								for (int i =0;i<quantitatDades;i++){
									dadesCrear[contadorMatriu][i]=generarPassword(inclouLletres,inclouNumeros,inclouMajuscules,
											inclouMinuscules,inclouSimbols,longitud);
								}
							}
							else if(index==16)dates(quantitatDades,anyMinim,anyMaxim,numeroAleatori[0],dadesCrear[contadorMatriu]);
							else if(index==17)iban(numeroAleatori[0],contadorMatriu);
							else if(index==18) {
								
								for (int i =0;i<quantitatDades;i++){
									dadesCrear[contadorMatriu][i]=obtenerDNI();
								}
							}
							else if(index==19)autonumeric(dadesCrear[contadorMatriu], valorPerDefecte);
						} else if (index == 0) {
							System.out.println("Índice 0 omitido.");
						} else {
							System.out.println("Índice " + index + " fuera de rango.");
						}
						contadorMatriu++;
						
					}
				}
				if (formatArxiu[0].equalsIgnoreCase("SQL"))
					creacioDeSql(formatArxiu[2], quantitatDades);
				else {
					crearXml(dadesCrear,tipusDada,quantitatDades);
					crearXsd();
					crearXsl();
				}
				br.close();
			}
		}
		catch(Exception e) {e.printStackTrace();}
		
	}
	// Funcio per a crear emails
	public static void email(int largada, String emails[], String files_dades[], int aleatori, String domini,String extencioDomini,int num) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(files_dades[0]));

			BufferedReader br1 = new BufferedReader(new FileReader(files_dades[9]));
			
			// L'asicno la llargada a les arrays que s'utilitzaran
			String auxiliarNom[] = new String[quantitatDades];
			llegir(br, auxiliarNom, aleatori, 0);
			if (num==0) {
				if ((domini != null && domini.length() > 0)&&(extencioDomini != null && extencioDomini.length() > 0)) {
					for (int i = 0; i < emails.length; i++) {
						emails[i] = auxiliarNom[i] + "@" + domini+extencioDomini;
					}
				}else if (domini != null && domini.length() > 0) {
					for (int i = 0; i < emails.length; i++) {
						emails[i] = auxiliarNom[i] + "@" + domini+".com";
					}
				} else {
					String auxiliarDomini[] = new String[largada];
					llegir(br1, auxiliarDomini, aleatori, 0);
					for (int i = 0; i < emails.length; i++) {
						emails[i] = auxiliarNom[i] + "@" + auxiliarDomini[i] + ".com";
					}
				}	
			}else {
				if ((domini != null && domini.length() > 0)&&(extencioDomini != null && extencioDomini.length() > 0)) {
					for (int i = 0; i < emails.length; i++) {
						emails[i] = auxiliarNom[i]+num + "@" + domini+extencioDomini;
					}
				}else if (domini != null && domini.length() > 0) {
					for (int i = 0; i < emails.length; i++) {
						emails[i] = auxiliarNom[i]+num + "@" + domini+".com";
					}
				} else {
					String auxiliarDomini[] = new String[largada];
					llegir(br1, auxiliarDomini, aleatori, 0);
					for (int i = 0; i < emails.length; i++) {
						emails[i] = auxiliarNom[i]+num + "@" + auxiliarDomini[i] + ".com";
					}
				}
			}
			

		} catch (Exception e) {
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

	}

	// Funcio creada per validar el format del fitxer d'entrada
	public static boolean validarFormatEntrada(String arxiuGenerat, String formatArxiu[]) {
		// Comprovar la longitud de l'array i el format correctament
		boolean isCorrect = false; // Inicialment, no és correcte
		// Bucle que demana correccions fins que tot el format sigui correcte

		// Comprovar si l'array té 3 elements
		if (formatArxiu.length != 3) {
			System.out.println(
					"Error -> El format de l'arxiu ha de tenir 3 elements: 'Tipus de Arxiu'#'Quantitat de registres'#'Ubicació'");
			return false;
		}
		// Comprovar que el tipus d'arxiu és "SQL" o "XML"
		if (!(formatArxiu[0].equalsIgnoreCase("XML") || formatArxiu[0].equalsIgnoreCase("SQL"))) {
			System.out.println("Error -> El tipus d'arxiu ha de ser 'SQL' o 'XML'");
			return false;
		}
		// Comprovar que el segon element és un nombre vàlid
		if (!esNumeroValid(formatArxiu[1])) {
			System.out.println("Error -> La quantitat de registres ha de ser un número positiu entre 1 i 200.");
			return false;
		}
		// Comprovo que el arxiu existeixi i sigui un directori
		File f = new File(formatArxiu[2]);
		if ((!f.exists()) || (!f.isDirectory())) {
			System.out.println("Error -> La ubicació no existe o es un arxiu.");
			return false;
		}
		// Si tot és correcte, sortir del bucle
		System.out.println("Formato Válido.");
		return true;
	}

	// Funció auxiliar per comprovar si el segon element és un nombre vàlid entre 1
	// i 250
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

	// ·Leemos archivos con funciones y generamos estos a partir de otras funciones
	// ->
	// Funcio per llegir els arxius de dades
	// ·Funcion boolean sin formatos
	public static void booleans(int contadorMatriu) {
		// inicialitzem el Random
		Random random = new Random();
		// Fem un bucle amb tantes voltes com dades a generar
		for (int i = 0; i < quantitatDades; i++) {
			// Guardem al array de booleans el valor aleatori generat amb el Random
			dadesCrear[contadorMatriu][i] = random.nextBoolean() + "";
		}
		contadorMatriu++;
	}

	// ·Funcion int para indicar los 'decimales=0','minims=0 i maxims=1000'
	public static String randomNumber(double decimals, double minim, double maxim) {
		// Importem el metode random per generar numeros aleatoris
		Random random = new Random();
		// Generem el numero aleatori entre un (minim i un maxim)
		double numeroAleatorio = minim + (maxim - minim) * random.nextDouble();
		// Redondearem el numeor especificat a partir de la quantitat de decimals
		// demanats
		double escala = Math.pow(10, decimals);
		return ""+numeroAleatorio;
		// Al declarar el resultat de la funcio , haurem de especificar en ordre , la
		// quantitat de decimals que volem, el rang minim i el rang maxim
		// Decimals -> 0 per defecte * Minim -> 0 per defecte * Maxim -> 1000 per
		// defecte
		
	}

	// ·Funcion String para indicar el nombre del dominio='nom de comapnyia'
	public static void url(String urls[], int aleatori) throws IOException {
		// GENERO LA URL DESDE EL NOM DE COMPANYIA utilitzan llegir
		BufferedReader br = new BufferedReader(new FileReader(files_dades[9]));
		llegir(br, urls, aleatori, 0);

		for (int i = 0; i < quantitatDades; i++) {
			urls[i]=urls[i].toLowerCase();
			urls[i] = "www." + urls[i] + ".com";
		}
	}

	// ·Funcion IP4 ???
	// Per cridar-la dadesIp4(quantitatDades, Array on guardar les ip)
	public static void ip4(int contadorMatriu) {
		Random random = new Random();
		// Fem un bucle amb tantes voltes com dades a generar
		for (int i = 0; i < quantitatDades; i++) {
			// Generem i guardem els valors
			dadesCrear[contadorMatriu][i] = random.nextInt(256) + "." + random.nextInt(256) + "." + random.nextInt(256)
					+ "." + random.nextInt(256);
		}
		contadorMatriu++;
	}

	// Mètode per generar la contrasenya segons els paràmetres
	public static String generarPassword(boolean inclouLletres, boolean inclouNumeros, boolean inclouMajuscules,
			boolean inclouMinuscules, boolean inclouSimbols, int longitud) {
		// Definim els conjunts de caràcters possibles
		String lletres = "abcdefghijklmnopqrstuvwxyz";
		String majuscules = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String numeros = "0123456789";
		String simbols = "!@#$%^*_-+=?/~|";
		// Cadena que contindrà tots els caràcters permesos segons les opcions
		String conjuntCaracters = "";
		// Afegeix els caràcters segons els paràmetres afegits
		if (inclouLletres && inclouMinuscules)
			conjuntCaracters += lletres;
		if (inclouLletres && inclouMajuscules)
			conjuntCaracters += majuscules;
		if (inclouNumeros)
			conjuntCaracters += numeros;
		if (inclouSimbols)
			conjuntCaracters += simbols;
		// Generació de la contrasenya
		Random random = new Random();
		String password = "";
		for (int i = 0; i < longitud; i++) {
			int index = random.nextInt(conjuntCaracters.length());
			password += conjuntCaracters.charAt(index); // Mezcla de caracters
		}
		return password;
	}

	public static void mostrarPassword() {
		// Paràmetres de exemple
		boolean inclouLletres = true;
		boolean inclouNumeros = true;
		boolean inclouMajuscules = true;
		boolean inclouMinuscules = true;
		boolean inclouSymbols = true;
		int longitud = 12; // Longitud de la contrasenya
		String password = generarPassword(inclouLletres, inclouNumeros, inclouMajuscules, inclouMinuscules,
				inclouSymbols, longitud);
		// Mostrar la contrasenya generada
		System.out.println("Contrasenya generada exitosament: " + password);
	}
	// ·Funcion String ha de indicar el 'any minim=1900 i maxim=2023'

	public static void dates(int largada, int anyMinim, int anyMaxim, int aleatori, String data[]) {
		Random random = new Random();
		// dono llargada a les array i la variable
		int test;
		// Utilitzo l'array per a ordenar ficar el maxim com a maxim
		if (anyMaxim < anyMinim) {
			test = anyMaxim;
			anyMaxim = anyMinim;
			anyMinim = test;
		}
		// bucle per a generar els anys
		for (int i = 0; i < data.length; i++) {
			int any = random.nextInt(anyMaxim - anyMinim) + anyMinim, mes = random.nextInt(12) + 1, dia;
			// Crido a la funcio pera sabe cuans dies te el mes
			dia = diesMes(mes, any);
			if (dia == -1) {
				System.out.println("ERROR");
			} else {
				// Genero el dia i el guardo a la array
				dia = random.nextInt(dia) + 1;
				data[i] = dia + "/" + mes + "/" + any;
			}
		}
		
	}

	// funcio per a saber cuants dies te el mes que es genere aleatoriament
	public static int diesMes(int mes, int any) {
		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
			// Meses de 31 días
			return 31;
		} else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
			// Meses de 30 días
			return 30;
		} else if (mes == 2) {
			// Febre (28 en anys comuns, 29 en anys de traspas)
			// Implementar lógica para determinar si es año bisiesto
			if ((any % 4 == 0 && any % 100 != 0) || (any % 100 == 0 && any % 400 == 0)) {
				return 29;
			} else {
				return 28;
			}
		} else {
			return -1;
		}
	}
	// ·Funcion para IBAN
	// Per cridarla: iban( numeroAleatori, quantitatDades, Array on guardar els
	// ibans)
	private static void iban(int numeroAleatori, int contadorMatriu) {
		try {
			// Primer contem les linies del arxiu per generar el array on guardar les dades
			// No es fa amb un tamany definit per si es modifica el tamany de l'arxiu
			BufferedReader br = new BufferedReader(new FileReader("Dades/6-Pais.txt"));
			int tamanyArxiu = 0;
			while (br.readLine() != null)
				tamanyArxiu++;
			br.close();
			String liniesFitxer[] = new String[tamanyArxiu];
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
			 * Un cop tenim totes les dades del arxiu en un array, hem de calcular si des
			 * del numero aleatori fins al final del array tenim suficients dades per
			 * mostrar la quantitat que demana l'usuari
			 */
			int llegirLinea = numeroAleatori;
			int contador = 0;
			if ((quantitatDades + numeroAleatori) < liniesFitxer.length) {
				// en aquest cas no cal fer res especial, ja que disposem de
				// prous dades

				contador = 0;
				for (int j = 0; j < quantitatDades; j++) {
					// cridem la funció que genera ibans tants cops com dades
					// em de generar
					dadesCrear[contadorMatriu][contador] = generarIban(liniesFitxer[llegirLinea]);
					llegirLinea++;
					contador++;
				}

			} else {
				// en aquest cas no disposem de prous dades, aixi que haurem
				// de tornar a llegir des del inici

				contador = 0;
				// calculem quantes dades tenim disponibles i quantes ens en falten
				int dadesDisponibles = liniesFitxer.length - numeroAleatori;
				int dadesRestants = quantitatDades - dadesDisponibles;

				for (int k = 0; k < dadesDisponibles; k++) {
					// Amb aquest primer for generem els ibans possibles fins que
					// arribem al final de les dades disponibles
					dadesCrear[contadorMatriu][contador] = generarIban(liniesFitxer[llegirLinea]);
					llegirLinea++;
					contador++;
				}
				llegirLinea = 0;
				for (int l = 0; l < dadesRestants; l++) {
					// amb aquest for generem ibans des de la linea 0 del
					// array fins haver generat totes les dades restants
					dadesCrear[contadorMatriu][contador] = generarIban(liniesFitxer[llegirLinea]);
					llegirLinea++;
					contador++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Funció que genera un iban i el retorna en format String
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
		 * Un cop tenim totes les variables, generem un num de compte aleatori
		 */
		Random random = new Random();

		for (int i = 0; i < 20; i++)
			numeroCompte = numeroCompte + random.nextInt(10);
		/*
		 * Amb num de compte i codi pais, calculem els digits de control. Per poder fer
		 * el calcul dels digits de control, necessitem el numero de compte + el codi de
		 * pais en digits + 0 + 0.
		 */
		numeroIbanTemp = numeroCompte + codiPaisNumeros + 0 + 0;
		/*
		 * Per calcular els dígits de control de l'IBAN, primer agafem el valor de
		 * numeroIbanTemp i en fem un nombre BigInteger (ja que es un numero de 26
		 * digits no entra en un long). Després calulem el mòdul 97 a aquest nombre.
		 * Després, restem 98 a aquest resultat. El resultat d'aquesta resta serà el
		 * valor dels dígits de control de l'IBAN.
		 */
		digitControl = BigInteger.valueOf(98).subtract(new BigInteger(numeroIbanTemp).mod(BigInteger.valueOf(97)));
		// Guardem el iban final generat a partir del codi pais + els digits de control
		// i el numero de compte
		iban = codiPais + digitControl + numeroCompte;
		return iban;
	}

	// Funcio per generar la ultima lletra del DNI
	public static char generarLetraDNI(int dni) {
		// Lletres valides per seleccionar l'ultim caracter del DNI
		String characters = "TRWAGMYFPDXBNJZSQVHLCKE";
		// La resta de la divisio de la longitud total del 'string' dels caracters ens
		// dona la posicio de la lletra, es a dir '23'
		int rest = dni % characters.length();
		return characters.charAt(rest);
	}

	// Funcion per obtenir el umero de DNI aleatori
	public static String obtenerDNI() {
		Random random = new Random();
		// Necesitem que la quantitat de numeros del DNI sigui de 8
		int numeroDNI = random.nextInt(90000000) + 10000000;
		// Obtenim la serie de numeros aleatoris que contindran el DNI
		char lletra = generarLetraDNI(numeroDNI);
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
	// Funcio per generar autonumeric

	public static void autonumeric(String num[], int valorPerDefecte) {

		// Faig un bucle per a genera el auto numeric comensan amb el numero que el
		// usuari indiqui
		for (int i = 0; i < quantitatDades; i++) {
			num[i] = ""+valorPerDefecte;
			valorPerDefecte++;
		}
	}
	// *****************************
	// Debemos leer el archivo de datos y crear a partir de este los archivos SQL y
	// XML/XSD/XSLT

	// Funcio per crear l'arxiu xsl
	// crearXsl(dadesCrear);
	public static void crearXsl() {
		File desti = new File(rutaUbicacio + "\\Dades.xsl");
		try {
			PrintWriter impressora = new PrintWriter(desti);
			impressora.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
					+ "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\" version=\"1.0\">\r\n"
					+ "  <xsl:template match=\"/\">\r\n" + "    <html>\r\n" + "      <head>\r\n"
					+ "        <title>Dades demanades</title>\r\n" + "<style>\r\n"
							+ "          body {\r\n"
							+ "            font-family: Arial, sans-serif;\r\n"
							+ "            margin: 20px;\r\n"
							+ "            background-color: #f4f4f9;\r\n"
							+ "          }\r\n"
							+ "          h2 {\r\n"
							+ "            text-align: center;\r\n"
							+ "            color: #333;\r\n"
							+ "          }\r\n"
							+ "          table {\r\n"
							+ "            margin: 0 auto;\r\n"
							+ "            border-collapse: collapse;\r\n"
							+ "            width: 80%;\r\n"
							+ "            background-color: #ffffff;\r\n"
							+ "            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\r\n"
							+ "            border-radius: 8px;\r\n"
							+ "            overflow: hidden;\r\n"
							+ "          }\r\n"
							+ "          th, td {\r\n"
							+ "            padding: 12px 20px;\r\n"
							+ "            text-align: left;\r\n"
							+ "          }\r\n"
							+ "          th {\r\n"
							+ "            background-color: #8e678e;\r\n"
							+ "            color: #ffffff;\r\n"
							+ "            font-weight: bold;\r\n"
							+ "          }\r\n"
							+ "          tr:nth-child(even) {\r\n"
							+ "            background-color: #f2f2f2;\r\n"
							+ "          }\r\n"
							+ "          tr:hover {\r\n"
							+ "            background-color: #e6f7ff;\r\n"
							+ "            transition: background-color 0.3s ease;\r\n"
							+ "          }\r\n"
							+ "          td {\r\n"
							+ "            color: #333;\r\n"
							+ "          }\r\n"
							+ "          caption {\r\n"
							+ "            margin: 10px 0;\r\n"
							+ "            font-size: 18px;\r\n"
							+ "            color: #555;\r\n"
							+ "          }\r\n"
							+ "        </style>" + "      </head>\r\n" + "      <body>\r\n"
					+ "        <h2>Mackaroo</h2>\r\n" + "        <table>\r\n" + "          <thead>\r\n"
					+ "            <tr>");
			for (int i = 0; i < tipusDada.length; i++) {
				if (tipusDada[i][0] != null) {
					impressora.println("              <th>" + tipusDada[i][1] + "</th>");
				}
			}
			impressora.println("            </tr>\r\n" + "          </thead>\r\n" + "          <tbody>\r\n"
					+ "            <xsl:for-each select=\"//linea\">\r\n" + "              <tr>");

			for (int i = 0; i < tipusDada.length; i++) {
				if (tipusDada[i][0] != null) {
					impressora.println(
							"              <td><xsl:value-of select=\".//" + tipusDada[i][1] + "\"></xsl:value-of></td>");
				}
			}
			impressora.println("              </tr>\r\n" + "            </xsl:for-each>\r\n" + "          </tbody>\r\n"
					+ "        </table>\r\n" + "      </body>\r\n" + "    </html>\r\n" + "  </xsl:template>\r\n"
					+ "</xsl:stylesheet>");

			impressora.flush();
			impressora.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Funcio per crear el xml
	// crearXml(dadesCrear2, dadesCrear, quantitatDades);
	public static void crearXml(String[][] dadesCrear, String[][] tipusDada, int quantitatDades) {
	    try (PrintWriter impressora = new PrintWriter(new File(rutaUbicacio + "\\Dades.xml"))) {
	        impressora.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
	        impressora.println("<?xml-stylesheet type=\"text/xsl\" href=\"Dades.xsl\"?>");
	        impressora.println("<Dades xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:noNamespaceSchemaLocation=\"Dades.xsd\">");
	        for (int i = 0; i < quantitatDades; i++) { 
	            impressora.println("    <linea>");
	            int columnaEdad = 1; 
	            for (int j = 0; j < tipusDada.length; j++) { 
	                if (tipusDada[j][0] != null && dadesCrear[j][i] != null) { 
	                    impressora.println("        <" + tipusDada[j][1] + ">" + dadesCrear[j][i] + "</" + tipusDada[j][1] + ">");

	                    if (j == columnaEdad) {
	                        columnaEdad++;
	                    }
	                }
	            }
	            impressora.println("    </linea>");
	        }
		

	        impressora.println("</Dades>");
	    
		} catch (Exception e) {
			e.printStackTrace();
		}
			
  	}
	//Funcio per crear el XSD
	//Funció per crear l'arxiu xsd
  	//crearXsd(dadesCrear);
	// Debemos leer el archivo de datos y crear a partir de este los archivos SQL y XML/XSD/XSLT
	public static void creacioDeSql(String ruta,int linies,String [][] dadesCrear2 ) throws IOException {
		//Le doy nombre al SQL 
		String test="\\Arxiu.sql";
		//Creo el file per a escriure en ell
		File arxiuSql = new File(ruta+test);
		//Miro si el file existeix i el canvio si es nesesari
		int i=0;

	}
	// Funcio per crear el XSD

	// Funció per crear l'arxiu xsd
	// crearXsd(dadesCrear);

	public static void crearXsd() {
		File desti = new File(rutaUbicacio + "\\Dades.xsd");
		try {
			PrintWriter impressora = new PrintWriter(desti);
			// Primer de tot imprimim les primeres linies del document, que seràn sempre les
			// mateixes
			impressora.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
					+ "<xs:schema xmlns:xs=\"http://www.w3.org/2001/XMLSchema\">");
			for (int i = 0; i < tipusDada.length; i++) {
				/*
				 * A dadesGenerar tenim guardat els noms de les dades que volem generar, per
				 * tant si el valor es null, es que aquelles dades no ens interessen. S'han de
				 * guardar amb el mateix ordre de valors, per exemple nom sempre a la posició 0,
				 * cognoms a la 1 etc.. es el mateix ordre que en el enunciat.
				 */
				if (tipusDada[i][0] != null) {
					/*
					 * Els elements boolean, numero i dates son diferets de la resta pel fet de que
					 * el tipus no es string, doncs primer amb aquest if controlem aquestes tres
					 * dades.
					 */
					if (i == 10) {
						impressora.println("    <xs:element name=\"boolean\" type=\"xs:boolean\"></xs:element>");
					} else if (i == 11) {
						impressora.println("    <xs:element name=\"numero\" type=\"xs:integer\"></xs:element>");
					} else if (i == 15) {
						impressora.println("    <xs:element name=\"dates\" type=\"xs:date\"></xs:element>");
					} else {
						impressora.println(
								"    <xs:element name=\"" + tipusDada[i][1] + "\" type=\"xs:string\"></xs:element>");
					}
				}
			}
			/*
			 * Aquest bloc tambés es identic en tots els casos, per tant l'imprimim sense
			 * controlar variables ni res semblant
			 */
			impressora.println(
					" <xs:element name=\"linea\">\r\n" + "        <xs:complexType>\r\n" + "            <xs:sequence>");
			/*
			 * Amb aquest for imprimim totes les linies dels elements fent referencia als
			 * elements declarats anteriorment
			 */
			for (int i = 0; i < tipusDada.length; i++) {
				if (tipusDada[i][0] != null) {
					impressora.println("                <xs:element ref=\"" + tipusDada[i][1]
							+ "\" maxOccurs=\"unbounded\" minOccurs=\"0\"/>");
				}
			}
			/*
			 * Aqui imprimim les ultimes linies del document, que un altre cop, son sempre
			 * les mateixes, per tant no es necessàri ni un bucle ni variables
			 */
			impressora.println("            </xs:sequence>\r\n" + "        </xs:complexType>\r\n"
					+ "    </xs:element>\r\n" + "\r\n" + "\r\n" + "    <xs:element name=\"Dades\">\r\n"
					+ "        <xs:complexType>\r\n" + "            <xs:sequence>\r\n"
					+ "                <xs:element ref=\"linea\" maxOccurs=\"unbounded\"></xs:element>\r\n"
					+ "            </xs:sequence>\r\n" + "        </xs:complexType>\r\n" + "    </xs:element>\r\n"
					+ "</xs:schema>");
			impressora.flush();
			impressora.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Debemos leer el archivo de datos y crear a partir de este los archivos SQL y
	// XML/XSD/XSLT
	public static void creacioDeSql(String ruta, int linies) throws IOException {

		// Le doy nombre al SQL
		String test = "\\Arxiu.sql";
		// Creo el file per a escriure en ell
		File arxiuSql = new File(ruta + test);
		// Miro si el file existeix i el canvio si es nesesari
		int i = 0;
		while (arxiuSql.exists()) {
			i++;
			test = "";
			test = "\\Arxiu(" + i + ").sql";
			arxiuSql = new File(ruta + test);
		}
		// Junto la ruta per despres escriure en el arciu
		ruta = ruta + test;
		// Creo el fitxer i crido la funcio per a crear la taula
		arxiuSql.createNewFile();
		String noms[] = new String[10];
		creacioDeTaula(linies, ruta);
	}

	// Funcio per a Creacio de SQL
	public static void creacioDeTaula(int linies, String ruta) throws IOException {
		// Declaro el escritor i escric lo nesesari per a crear i utilitza la base de
		// dades
		BufferedWriter writer = new BufferedWriter(new FileWriter(ruta));
		writer.write("DROP DATABASE TaulaPerMostrarDades;\n");
		writer.write("CREATE DATABASE IF NOT EXISTS TaulaPerMostrarDades;\n");
		writer.write("USE TaulaPerMostrarDades;\n\n");
		// Creo la taula i variables que utilitza-re
		writer.write("CREATE TABLE DadesGenarades(");
		int j = 0;
		String test = "";
		// El bucle serveix per a escriure el tipo de valors que hi hauran a la taula
		// amb el seu nom
		for (int i = 0; i < tipusDada.length; i++) {
			// Comprobo si hi ha algo a escriure
			if (tipusDada[i][0] != null) {
				// Condicio per a escriure ints en la primera bolta
				//If tipus[i][0].equals("19")||("11")||("12")
				if (j == 0 && (tipusDada[i][0].equals("19"))) {
					writer.write(tipusDada[i][1] + " INT");
					test = "(" + tipusDada[i][1];
					j++;
				}else if (j==0&&(tipusDada[i][0].equals("12"))){
					writer.write(tipusDada[i][1] + " DOUBLE");
					test = "(" + tipusDada[i][1];
					j++;
				}else if (j == 0 && tipusDada[i][0].equals("11")) {// Condicio per a escriure booleans en la primera bolta
					writer.write(tipusDada[i][1] + " BOOLEAN");
					test = "(" + tipusDada[i][1];
					j++;
				} else if (j == 0 && (!tipusDada[i][0].equals("19") || !tipusDada[i][0].equals("12"))) {// Condicio per a escriure Strings en la primera bolta
					writer.write(tipusDada[i][1] + " VARCHAR(100)");
					test = "(" + tipusDada[i][1];
					j++;
				} else if (tipusDada[i][0].equals("19")) {// Condicio per a escriure ints
					writer.write(" ," + tipusDada[i][1] + " INT");
					test = test + "," + tipusDada[i][1];
				}else if (tipusDada[i][0].equals("12")) {
					writer.write(" ," +tipusDada[i][1] + " DOUBLE");
					test = test+"," + tipusDada[i][1];
				}else if (tipusDada[i][0].equals("11")) {// Condicio per a escriure booleans
					writer.write("," + tipusDada[i][1] + " BOOLEAN");
					test = test + "," + tipusDada[i][1];
				} else {// Condicio per a escriure Strings
					writer.write("," + tipusDada[i][1] + " VARCHAR(100)");
					test = test + "," + tipusDada[i][1];
				}
			}
		}
		writer.write(");\n");
		// Li dono valor a les variables
		j = 0;
		int i = 0;
		// Bucle per a crear tots els inserts necessaris
		for (int k = 0; k < linies; k++) {
			// Comprobo si hi ha algo a escriure
			if (dadesCrear[i][k] != null) {
				// Escric cada insert
				writer.write("INSERT INTO DadesGenarades " + test + ") VALUES (");
				j=0;
				for (i = 0; i < dadesCrear.length; i++) {
					if (dadesCrear[i][k] != null) {
						if (j == 0 && (tipusDada[i][0].equals("11") || tipusDada[i][0].equals("18")||tipusDada[i][0].equals("12"))) {
							writer.write(dadesCrear[i][k]);
							j++;
						} else if (j == 0) {
							writer.write(" '" + dadesCrear[i][k] + "'");
							j++;
						} else if (tipusDada[i][0].equals("11") || tipusDada[i][0].equals("12")||tipusDada[i][0].equals("19")) {
							writer.write(", " + dadesCrear[i][k]);
						} else {
							writer.write(", '" + dadesCrear[i][k] + "'");
						}
					}
				}
				writer.write(");\n");
				i = 0;
			}
		}
		
		writer.write("SELECT * FROM DadesGenarades;\r\n");	
		
		writer.flush();
		writer.close();
	}

	// Funcio per a triar quins arxius s'han de gennerar
	public static void lectorArxius(int indice,int columna, int aleatori) throws IOException {
		//String perLlegit[][] = new String[arxiusALlegir.length][linies];
		BufferedReader br = new BufferedReader(new FileReader(files_dades[indice-1]));
		llegir(br, dadesCrear[columna], aleatori, 0);
	}

	public static void llegir(BufferedReader br, String[] llegit, int aleatori, int especial)
			throws IOException {
		String text[] = new String[2];
		// L'asicno la llargada a les arrays que s'utilitzaran
		int j = 0, posicioArray, numAleatori2 = aleatori, largadaArxiu = 250, largadaGenera = quantitatDades;
		largadaGenera = numAleatori2 + largadaGenera;
		posicioArray = largadaGenera - largadaArxiu;
		if (posicioArray > 0) {// Condicio per si mirar que tot cap a la array respecte el num aleatori
			// calculo quina posicio li correspont a la primera linia
			posicioArray = quantitatDades - posicioArray;
			// Bucle per a lleguir i guardar a la posicio corresponent
			for (int i = 0; i < largadaArxiu; i++) {
				text[1] = br.readLine();
				if (posicioArray < quantitatDades) {// Guardo a les ultimes posicions del array les primeres linies
					text = text[1].split("#");
					llegit[posicioArray] = text[1];
					posicioArray++;
				} else {
					if (i >= numAleatori2 && j < quantitatDades) {// Guardo la resta de linies amb el ordre correcte a la
															// posicio del num aleatori
						text = text[1].split("#");
						llegit[j] = text[1];
						j++;
					}
				}
			}
		} else {// Si que hi cap respecte el aleatori
				// bucle per a llegir de una sense fer els calculs
			for (int i = 0; j < quantitatDades; i++) {
				text[1] = br.readLine();
				if (i >= aleatori && j < quantitatDades) {
					text = text[1].split("#");
					llegit[j] = text[1];
					j++;
				}
			}
		}
	}
}