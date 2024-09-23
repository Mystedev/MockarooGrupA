import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class Mockaroo {

	public static void main(String[] args) {
		
		try {
			String files_dades[]= {"Dades/1-Noms.txt","Dades/2-Cognoms.txt","Dades/3-Ciutat.txt","Dades/4-Pais.txt"};
			FileReader fr = new FileReader(files_dades[0]);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while(br.ready()) {
				line = br.readLine();
				System.out.println(line);
			}
		}catch(Exception e) {
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
}
