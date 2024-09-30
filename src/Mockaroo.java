import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.BufferedReader;

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
			line=email(2,emails,files_dades,numAleatori);
			line=dates(2,anyMinim,anyMaxim,numAleatori);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String email(int largada,String emails[],String files_dades[],int aleatori) {
			Random random = new Random();
			Scanner teclat=new Scanner (System.in);
		try {
			
			FileReader fr = new FileReader("C:\\Users\\Jaume\\Documents\\Projecte_1\\Mockaroo\\Dades\\1-Noms.txt");
			FileReader fr2 = new FileReader("C:\\Users\\Jaume\\Documents\\Projecte_1\\Mockaroo\\Dades\\1-Noms.txt");
			FileReader fr1 = new FileReader("C:\\Users\\Jaume\\Documents\\Projecte_1\\Mockaroo\\Dades\\10-NomDeLaCompanyia.txt");
			FileReader fr3 = new FileReader("C:\\Users\\Jaume\\Documents\\Projecte_1\\Mockaroo\\Dades\\10-NomDeLaCompanyia.txt");
			BufferedReader br = new BufferedReader(fr);
			BufferedReader br2 = new BufferedReader(fr2);
			BufferedReader br1 = new BufferedReader(fr1);
			BufferedReader br3 = new BufferedReader(fr3);
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
			for (int i=0 ; j <largada; i++) {
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
	public static void autonumeric(int llargada,int num[],int valorPerDefecte) {
		num=new int[llargada];
		for (int i = 0; i <llargada; i++) {
			num[i]=valorPerDefecte;
			valorPerDefecte++;
			System.out.println(num[i]);
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
