package model;	
import java.util.*;

public class IntegerSet{

	//Attribute

	private String name;
	private int cardinality;
	private ArrayList<Integer> elements;

	//Constructor

	public IntegerSet(String name){

		this.name = name;
		cardinality = 0;
		elements = new ArrayList<>();
	}

	public String getName(){
		return name;
	}

	public int getCardinality(){
		return cardinality;
	}

	public void setCardinality(int cardinality){
		this.cardinality = cardinality;
	}

	public ArrayList<Integer> getElements(){
		return elements;
	}

	public boolean findElement(Integer element){

		boolean verific = false;

		for(int i = 0; i<elements.size() && !verific; i++){

			if(elements.get(i) == element){
				verific = true;
			}
		}
		return verific;
	}

	public int findPositionElement(Integer element){

		boolean verific = false;
		int position = 0;

		for(int i = 0; i<elements.size() && !verific; i++){

			if(elements.get(i) == element){
				verific = true;
				position = i;
			}
		}
		return position;
	}

	public void addElement(Integer element){

		boolean verific = false;

		for(int i = 0; i<elements.size() && !verific; i++){
			if(elements.get(i) == element){
				verific = true;
			}
		}
		if(!verific){
			elements.add(element);
			cardinality++;
		}
	}

	public void removeElement(Integer element){

		boolean verific = false;

		for(int i = 0; i<elements.size() && !verific; i++){
			if(elements.get(i) == element){
				verific = true;
				elements.remove(i);
				cardinality--;
			}
		}
	}

	public IntegerSet union(IntegerSet set, String newName){

		IntegerSet objSet = new IntegerSet(newName);
		boolean verific;

		for (int i = 0;i<elements.size(); i++) {

			objSet.elements.add(elements.get(i));
			objSet.setCardinality(elements.size());
		}
		for(int k = 0;k<set.elements.size(); k++){

			verific = objSet.findElement(set.elements.get(k));

			if(!verific){
				objSet.elements.add(set.elements.get(k));
				objSet.setCardinality(objSet.elements.size());
			}
		}
		return objSet;
	}

	public IntegerSet difference(IntegerSet set, String newName){
		
		IntegerSet objSet = new IntegerSet(newName);
		boolean verific = true;
		int option = 0;


		for (int i = 0;i<elements.size(); i++) {

			objSet.elements.add(elements.get(i));
			objSet.setCardinality(elements.size());
		}

		for(int k = 0;k<set.getCardinality(); k++){

			verific = objSet.findElement(set.elements.get(k));
			if(verific){
				option = objSet.findPositionElement(set.elements.get(k));
				objSet.elements.remove(option);
				objSet.setCardinality(objSet.elements.size());
			}
		}
		
		

		return objSet;
	}

	public IntegerSet intersection(IntegerSet set, String newName){

		IntegerSet objSet = new IntegerSet(newName);
		boolean verific = true;
		int option = 0;
		Integer position = 0;
		int variable = 0;
		int cont = 0;
		int x = 0;


		for (int i = 0;i<elements.size(); i++) {

			objSet.elements.add(elements.get(i));
			objSet.setCardinality(elements.size());
		}

		for(int p = 0;p<objSet.elements.size(); p++){

			position = objSet.elements.get(p);

			cont = set.getCardinality();

			for(int k = 0;k<cont; k++){			

				if(position != set.elements.get(k)){

					variable += 1;
				}
				else{
					variable -= 1;
				}
			}

			if(variable == set.elements.size()){

				objSet.elements.remove(p);
				objSet.setCardinality(objSet.elements.size());
			}
		}

	
		return objSet;
	}

	public IntegerSet symmetricDifference(IntegerSet set, String newName){

		IntegerSet objSet = new IntegerSet(newName);
		boolean verific;

		for (int i = 0;i<elements.size(); i++) {

			objSet.elements.add(elements.get(i));
			objSet.setCardinality(elements.size());
		}
		for(int k = 0;k<set.elements.size(); k++){

			verific = objSet.findElement(set.elements.get(k));

			if(verific){
				objSet.elements.add(set.elements.get(k));
				objSet.setCardinality(objSet.elements.size());
			}
		}
		return objSet;
	}

	public String toString(){

		boolean verific = elements.isEmpty();
		String message = "************************************************************\n"+
						 "**  Conjunto: "+getName()+" = ";
		if(!verific){
			for(int i = 0; i<elements.size(); i++){
				
				message += "["+elements.get(i)+"]";
			}
		}
		else if(verific){
			message += "El conjunto no tiene elementos";
		}

		message += "\n************************************************************\n";

		return message;
	}
}