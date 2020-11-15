package model;
import java.util.*;

						
public class MathApp{

	//Attribute

	private int amount;

	//Relations

	private ArrayList<IntegerSet> sets;

	//Constructor

	public MathApp(){

		sets = new ArrayList<>();
		amount = 0;
	}

	public IntegerSet searchSet(String name){

		boolean verific = false;
		IntegerSet objSet = null;

		for(int i = 0; i<sets.size() && !verific; i++){
			if(sets.get(i) != null && sets.get(i).getName().equals(name)){
				verific = true;
				objSet = sets.get(i);
			}
		}
		return objSet;
	}

	public boolean searchSetToVerific(String name){

		boolean verific = false;

		for(int i = 0; i<sets.size() && !verific; i++){
			if(sets.get(i) != null && sets.get(i).getName().equals(name)){
				verific = true;
			}
		}
		return verific;
	}

	public void addSet(String name){

		IntegerSet objSet = new IntegerSet(name);

		sets.add(objSet);

		amount++;
	}

	public String addSetMessage(String name){

		IntegerSet objSet = searchSet(name);
		String message = "";

		if(objSet == null){
			message = "No se pudo agregar el conjunto";
		}
		else if(objSet != null){
			message = "Se agrego correctamente el conjunto";
		}
		return message;
	}

	public void removeSet(String name){

		boolean verific = false;

		for(int i = 0; i<sets.size() && !verific; i++){
			if(sets.get(i) != null && sets.get(i).getName().equals(name)){
				verific = true;
				sets.remove(i);
				amount--;
			}
		}
	}

	public String removeSetMessage(String name){

		IntegerSet objSet = searchSet(name);
		String message = "";

		if(objSet == null){
			message = "Se elimino correctamente el conjunto";
		}
		else if(objSet != null){
			message = "No se pudo eliminar el conjunto";
		}
		return message;
	}

	public void addElementToSet(String setName, Integer element){

		IntegerSet objSet = searchSet(setName);

		objSet.addElement(element);
	}

	public String addElementToSetMessage(String setName, Integer element){

		IntegerSet objSet = searchSet(setName);
		boolean verific = false;
		String message = "";

		verific = objSet.findElement(element);

		if(verific){
			message = "Se agrego correctamente el elemento";
		}
		else if(!verific){
			message = "No se agrego el elemento";
		}
		return message;
	}

	public void removeElementFromSet(String setName, int element){

		IntegerSet objSet = searchSet(setName);

		objSet.removeElement(element);
	}

	public String removeElementToSetMessage(String setName, int element){

		IntegerSet objSet = searchSet(setName);
		boolean verific = false;
		String message = "";

		verific = objSet.findElement(element);

		if(verific){
			message = "No se elimino el elemento";
		}
		else if(!verific){
			message = "Se elimino correctamente el elemento";
		}
		return message;
	}

	public void union(String name1, String name2, String newName){

		IntegerSet objSet1 = searchSet(name1);
		IntegerSet objSet2 = searchSet(name2);

		IntegerSet objNew = objSet1.union(objSet2,newName);

		sets.add(objNew);

		amount++;
	}

	public String showUnion(String newName){

		IntegerSet objNew = searchSet(newName);
		String message = "";

		if(objNew == null){
			message = "No se pudo crear la union de los objetos";
		}		
		else if(objNew != null){
			message = "Union realizada con exito\n"+objNew.toString();
		}
		return message;
	}

	public void difference(String name1, String name2, String newName){

		IntegerSet objSet1 = searchSet(name1);
		IntegerSet objSet2 = searchSet(name2);

		IntegerSet objNew = objSet1.difference(objSet2,newName);

		sets.add(objNew);

		amount++;
	}

	public String showDifference(String newName){

		IntegerSet objNew = searchSet(newName);
		String message = "";

		if(objNew == null){
			message = "No se pudo crear la diferencia de los objetos";
		}		
		else if(objNew != null){
			message = "\nDiferencia realizada con exito\n"+objNew.toString();
		}
		return message;
	}

	public void intersection(String name1, String name2, String newName){

		IntegerSet objSet1 = searchSet(name1);
		IntegerSet objSet2 = searchSet(name2);

		IntegerSet objNew = objSet1.intersection(objSet2,newName);

		sets.add(objNew);

		amount++;
	}

	public String showIntersection(String newName){

		IntegerSet objNew = searchSet(newName);
		String message = "";

		if(objNew == null){
			message = "No se pudo crear la interseccion de los objetos";
		}		
		else if(objNew != null){
			message = "\nInterseccion realizada con exito\n"+objNew.toString();
		}
		return message;
	}

	public void symmetricDifference(String name1, String name2, String newName){

		IntegerSet objSet1 = searchSet(name1);
		IntegerSet objSet2 = searchSet(name2);

		IntegerSet objNew = objSet1.symmetricDifference(objSet2,newName);

		sets.add(objNew);

		amount++;
	}

	public String showSymmetricDifference(String newName){

		IntegerSet objNew = searchSet(newName);
		String message = "";

		if(objNew == null){
			message = "No se pudo crear la diferencia simetrica de los objetos";
		}		
		else if(objNew != null){
			message = "\nDiferencia simetrica realizada con exito\n"+objNew.toString();
		}
		return message;
	}

	public String showInfoSet(String name){

		String message = "";

		IntegerSet objNew = searchSet(name);

		message = objNew.toString();

		return message;
	}

	public String showInfoSets(){

		String message = "";

		for(int i = 0; i<sets.size(); i++){
			message+= sets.get(i).toString();
		}

		return message;
	}
}