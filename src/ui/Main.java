package ui;

import java.util.Scanner;
import model.MathApp;

public class Main{

	//Attribute

	private MathApp app;

	//Gobal variable

	public Scanner lector;

	public Main(){

		lector = new Scanner(System.in);
		createApp();
	}

	public static void main(String[] args){

		Main objMain = new Main();
		int option = 0;

		do{
			option = objMain.menu();
		}while(option != 0);
	}

	public int menu(){

		int option;

		System.out.println("******************************************");
		System.out.println("*                  MENU                  *");
		System.out.println("******************************************");
		System.out.println("* Que desea hacer?:                      *");
		System.out.println("* (1) Ingresar un conjunto               *");
		System.out.println("* (2) Eliminar un conjunto               *");
		System.out.println("* (3) Ingresar un elemento a un conjunto *");
		System.out.println("* (4) Eliminar un elemento a un conjunto *");
		System.out.println("* (5) Hacer una operacion entre conjuntos*");
		System.out.println("* (6) Mostrar un conjunto                *");
		System.out.println("* (7) Mostrar todos los conjuntos        *");
		System.out.println("* (0) Salir                              *");
		System.out.println("******************************************");
		option = lector.nextInt();lector.nextLine();

		switch(option){
			case 0:
			System.out.println("***********************************************************************");
			System.out.println("*                Gracias por utilizar nuestro software                *");
			System.out.println("***********************************************************************");
			break;
			case 1:
			addSet();
			break;
			case 2:
			deleteSet();
			break;
			case 3:
			addElementToSet();
			break;
			case 4:
			deleteElementToSet();
			break;
			case 5:
			doOperation();
			break;
			case 6:
			showASet();
			break;
			case 7:
			showAllSets();
			break;
			default:
			System.out.println("**********************************************************************");
			System.out.println("*                  Opcion invalida, digite de nuevo                  *");
			System.out.println("**********************************************************************");
			break;
		}
		return option;
	}

	public void createApp(){

		app = new MathApp();
	}

	public void addSet(){

		String message = "";
		String name = "";
		boolean findSet = false;

		do{
			System.out.println("Ingrese el nombre del conjunto");
			name = lector.nextLine();

			findSet = app.searchSetToVerific(name);

			if(findSet){
				System.out.println("Ya se encuentra creado un conjunto con ese nombre, ingrese otro");
			}
		}while(findSet);

		app.addSet(name);

		message = app.addSetMessage(name);

		System.out.println(message);
	}

	public void deleteSet(){

		String message = "";
		String name = "";
		boolean findSet = false;

		do{
			System.out.println("Ingrese el nombre del conjunto que quiere eliminar");
			name = lector.nextLine();

			findSet = app.searchSetToVerific(name);

			if(!findSet){
				System.out.println("No se encuentra un conjunto con ese nombre, ingrese otro");
			}
		}while(!findSet);

		app.removeSet(name);

		message = app.removeSetMessage(name);

		System.out.println(message);
	}

	public void addElementToSet(){

		String message = "";
		String name = "";
		boolean findSet = false;

		do{
			System.out.println("Ingrese el nombre del conjunto al que quiere agregar un entero");
			name = lector.nextLine();

			findSet = app.searchSetToVerific(name);

			if(!findSet){
				System.out.println("No se encuentra un conjunto con ese nombre, ingrese otro");
			}
		}while(!findSet);

		System.out.println("Ingrese el entero que agrega al conjunto (Si el numero esta repetido no se agregara)");
		int integer = lector.nextInt();

		app.addElementToSet(name,integer);

		message = app.addElementToSetMessage(name,integer);

		System.out.println(message);
	}

	public void deleteElementToSet(){

		String message = "";
		String name = "";
		boolean findSet = false;

		do{
			System.out.println("Ingrese el nombre del conjunto al que quiere eliminar un elemento");
			name = lector.nextLine();

			findSet = app.searchSetToVerific(name);

			if(!findSet){
				System.out.println("No se encuentra un conjunto con ese nombre, ingrese otro");
			}
		}while(!findSet);

		System.out.println("Ingrese el entero que elimina del conjunto");
		int integer = lector.nextInt();

		app.removeElementFromSet(name,integer);

		message = app.removeElementToSetMessage(name,integer);

		System.out.println(message);
	}

	public void doOperation(){

		int integer;
		String name1, name2, newName, newName2, message;
		boolean findSet = false;

		do{
			System.out.println("***************************");
			System.out.println("*Que desea hacer?         *");
			System.out.println("***************************");
			System.out.println("* (1)Union                *");
			System.out.println("* (2)Interseccion         *");
			System.out.println("* (3)Diferencia           *");
			System.out.println("* (4)Diferencia simetrica *");
			System.out.println("***************************");

			integer = lector.nextInt();lector.nextLine();

			if(integer != 1 && integer != 2 && integer != 3 && integer != 4){
				System.out.println("Opcion invalida, digitela de nuevo");
			}
		}while(integer != 1 && integer != 2 && integer != 3 && integer != 4);

		if(integer == 1){

			do{
				System.out.println("Ingrese el nombre del primer conjunto");
				name1 = lector.nextLine();

				findSet = app.searchSetToVerific(name1);

				if(!findSet){
					System.out.println("No se encuentra un conjunto con ese nombre, ingrese otro");
				}
			}while(!findSet);

			do{
				System.out.println("Ingrese el nombre del segundo conjunto");
				name2 = lector.nextLine();

				findSet = app.searchSetToVerific(name2);

				if(!findSet){
					System.out.println("No se encuentra un conjunto con ese nombre, ingrese otro");
				}
			}while(!findSet);

			do{
				System.out.println("Ingrese el nombre del conjunto del resultado de la union");
				newName = lector.nextLine();

				findSet = app.searchSetToVerific(newName);

				if(findSet){
					System.out.println("Ya se encuentra creado un conjunto con ese nombre, ingrese otro");
				}
			}while(findSet);

			app.union(name1,name2,newName);

			message = app.showUnion(newName);
			System.out.println(message);
		}
		else if(integer == 2){
			do{
				System.out.println("Ingrese el nombre del primer conjunto");
				name1 = lector.nextLine();

				findSet = app.searchSetToVerific(name1);

				if(!findSet){
					System.out.println("No se encuentra un conjunto con ese nombre, ingrese otro");
				}
			}while(!findSet);

			do{
				System.out.println("Ingrese el nombre del segundo conjunto");
				name2 = lector.nextLine();

				findSet = app.searchSetToVerific(name2);

				if(!findSet){
					System.out.println("No se encuentra un conjunto con ese nombre, ingrese otro");
				}
			}while(!findSet);

			do{
				System.out.println("Ingrese el nombre del conjunto del resultado de la Interseccion");
				newName = lector.nextLine();

				findSet = app.searchSetToVerific(newName);

				if(findSet){
					System.out.println("Ya se encuentra registrado un conjunto con ese nombre, ingrese otro");
				}
			}while(findSet);

			app.intersection(name1,name2,newName);

			message = app.showIntersection(newName);
			System.out.println(message);
		}
		else if(integer == 3){

			do{
				System.out.println("Ingrese el nombre del primer conjunto");
				name1 = lector.nextLine();

				findSet = app.searchSetToVerific(name1);

				if(!findSet){
					System.out.println("No se encuentra un conjunto con ese nombre, ingrese otro");
				}
			}while(!findSet);

			do{
				System.out.println("Ingrese el nombre del segundo conjunto");
				name2 = lector.nextLine();

				findSet = app.searchSetToVerific(name2);

				if(!findSet){
					System.out.println("No se encuentra un conjunto con ese nombre, ingrese otro");
				}
			}while(!findSet);

			do{
				System.out.println("Ingrese el nombre del conjunto del resultado de la diferencia (A/B)");
				newName = lector.nextLine();

				findSet = app.searchSetToVerific(newName);

				if(findSet){
					System.out.println("Ya se encuentra registrado un conjunto con ese nombre, ingrese otro");
				}
			}while(findSet);

			do{
				System.out.println("Ingrese el nombre del conjunto del resultado de la diferencia (B/A)");
				newName2 = lector.nextLine();

				findSet = app.searchSetToVerific(newName2);

				if(findSet){
					System.out.println("Ya se encuentra registrado un conjunto con ese nombre, ingrese otro");
				}
			}while(findSet);

			app.difference(name1,name2,newName);
			app.difference(name2,name1,newName2);

			message = app.showDifference(newName);
			System.out.println(message);

			message = app.showDifference(newName2);
			System.out.println(message);
		}
		else if(integer == 4){
			do{
				System.out.println("Ingrese el nombre del primer conjunto");
				name1 = lector.nextLine();

				findSet = app.searchSetToVerific(name1);

				if(!findSet){
					System.out.println("No se encuentra un conjunto con ese nombre, ingrese otro");
				}
			}while(!findSet);

			do{
				System.out.println("Ingrese el nombre del segundo conjunto");
				name2 = lector.nextLine();

				findSet = app.searchSetToVerific(name2);

				if(!findSet){
					System.out.println("No se encuentra un conjunto con ese nombre, ingrese otro");
				}
			}while(!findSet);

			do{
				System.out.println("Ingrese el nombre del conjunto del resultado de la Interseccion");
				newName = lector.nextLine();

				findSet = app.searchSetToVerific(newName);

				if(findSet){
					System.out.println("Ya se encuentra registrado un conjunto con ese nombre, ingrese otro");
				}
			}while(findSet);

			app.symmetricDifference(name1,name2,newName);

			message = app.showSymmetricDifference(newName);
			System.out.println(message);
		}
	}

	public void showASet(){

		String message = "";

		System.out.println("Ingrese el nombre de conjunto que desea encontrar");

		String name = lector.nextLine();
		message = app.showInfoSet(name);

		System.out.println(message);
	}

	public void showAllSets(){

		String message = "";

		message = app.showInfoSets();

		System.out.println(message);
	}
}