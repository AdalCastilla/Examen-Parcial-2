package Examen2;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Bienvenido al juego de adivina quien");
	System.out.println("Para empezar ingresa tu nombre");
	String nombrejugador = sc.next();
	int totalW=0, totalG=0;	
	
	File file = new File("C:\\Users\\adalc\\Downloads\\eclipse\\Parcial1\\src\\JugadoresAdivinaquien",nombrejugador+".text");
	
	if (file.exists()) {
		BufferedReader BR = new BufferedReader(new FileReader(file));
		totalG=Integer.parseInt(BR.readLine());
		totalW=Integer.parseInt(BR.readLine());
		BR.close();
		System.out.println("Hey" + nombrejugador + "Listo para volver a jugar?");
		System.out.println("Felicidades, has ganado"+ totalW+ "juegos y has jugado"+ totalG+ "juegos");
	}else {
		file.createNewFile();
		System.out.println("Hola"+ nombrejugador+ "Bienvenido al juego de adivina quien");
	}
		
Persona1[] personas = new Persona1[10];
Random random = new Random();
String[] nombres= {"Jesus","Roberto","Ignacio","Tilin","Adal","Pou","Gekko","WinniePoh","Sullivan","Boo"};
int contAlto=0;
int contGorra=0;
int contAtractiva=0;
int contPareja=0;
int personasEliminadas=0;

for(int i=0;i<personas.length;i++) {
	String nombre= nombres[i];
	boolean esAlto = random.nextBoolean();
	boolean usaGorra = random.nextBoolean();
	boolean esAtractiva = random.nextBoolean();
	boolean tienePareja = random.nextBoolean();
	
	if(esAlto==usaGorra && usaGorra==esAtractiva && esAtractiva==tienePareja) {
		esAlto = random.nextBoolean();
		usaGorra = random.nextBoolean();
		esAtractiva = random.nextBoolean();
		tienePareja = random.nextBoolean();
	}
	
	if(esAlto==true) {
		contAlto++;
	}
	if(usaGorra==true) {
		contGorra++;
	}
	if(esAtractiva==true) {
		contAtractiva++;
	}
	if(tienePareja==true) {
		contPareja++;
	}
	personas[i]= new Persona1(nombre,esAlto,usaGorra,esAtractiva,tienePareja);
}

totalG++;
for(Persona1 per : personas) {
	System.out.println(per.getNombre()+" "+"Es Alto:"+ per.esAlto() +" , "+"Es Atractiva: "+ per.esAtractiva() +" , "+"Usa Gorra: "+ per.usaGorra() +" , "+"Tiene pareja: "+ per.tienePareja());
}
	System.out.println("Contador Altura:"+contAlto+" "+"Contador es Guapo:"+contAtractiva+" "+"Contador Gorra:"+contGorra+" "+"contador Pareja:"+contPareja);
	
	int sujeto = (int)(Math.random()*10);
	System.out.println("\nEmpecemos el juego de Adivina Quien");
	
	for(int i=0;i<3;i++) {
		System.out.println("Pregunta "+(i+1));
	System.out.println("\nEstas son las preguntas");
    System.out.println("1 es Alto?");
    System.out.println("2 es Atractiva?");
    System.out.println("3 usa Gorra?");
    System.out.println("4 tiene pareja?");
   int res=sc.nextInt();
   
   if(personas[sujeto]!=null) {
	   switch(res) {
	   case 1:
		   if(!personas[sujeto].esAlto()) {
			   System.out.println("La persona no es Alta");
		   }else {
			   System.out.println("La persona es Alta");
		   }
		   break;
	   case 2:
		   if(!personas[sujeto].usaGorra()) {
			 System.out.println("La persona no usa Gorra");  
		   }else {
			   System.out.println("La persona usa Gorra");
		   }
		   break;
	   case 3:
		   if(!personas[sujeto].esAtractiva()) {
				 System.out.println("La persona no es Atractiva");  
			   }else {
				   System.out.println("La persona es Atractiva");
			   }
		   break;
	   case 4:
		   if(!personas[sujeto].tienePareja()) {
				 System.out.println("La persona no tiene Pareja");  
			   }else {
				   System.out.println("La persona tiene Pareja");
			   }
		   break;
	   }
     }
   
   for (int j = 0; j < personas.length; j++) {
       if (personas[j] != null) { 
         switch (res) {
           case 1:
             if (!personas[j].esAlto()) {
               if(personas[j] != personas[sujeto]){
                 personas[j] = null;
               }
               ++personasEliminadas;
             } 
             break;
           case 2:
             if (!personas[j].usaGorra()) {
               if(personas[j] != personas[sujeto]){
                 personas[j] = null;
               }
               ++personasEliminadas;
             }
             break;
           case 3:
             if (!personas[j].esAtractiva()) {
               if(personas[j] != personas[sujeto]){
                 personas[j] = null;
               }
               ++personasEliminadas;
             } 
             break;
           case 4:
             if (!personas[j].tienePareja()) {
               if(personas[j] != personas[sujeto]){
                 personas[j] = null;
               }
               ++personasEliminadas;
             }
             break;
           default:
             System.out.println("No disponible");
             break;
         }
       }
     }
	
   if(personas[sujeto] == null){
     --personasEliminadas;
   }
    
   for (int j = 0; j < personas.length; j++) {
	     if (personas[j] != null) {
	       if(personasEliminadas < 9){
	         System.out.println(j + personas[j].getNombre());
	       } else {
	         System.out.println("Una persona queda");
	         System.out.println(j + personas[j].getNombre());
	         break;
	       }
	   }
	 }
   
	}
   int res2 = sc.nextInt();
   if(res2==sujeto) {
	   System.out.println("Felicitaciones adivinaste");
	   totalW++;
   }else {
	   System.out.println("Lo sentimos no has adivinado");
	   System.out.println(personas[sujeto].getNombre());
   }
   
   FileWriter FW = new FileWriter(file);
   FW.write("partidas jugadas\n");
   FW.write(totalG);
   FW.write("partidas Ganadas\n");
   FW.write(totalW);
   FW.close();
   System.out.println("Tus datos han sido guardadas");
   
   sc.close();
   
   
   }
   
}

	