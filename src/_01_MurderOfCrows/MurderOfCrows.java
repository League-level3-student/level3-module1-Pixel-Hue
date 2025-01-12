package _01_MurderOfCrows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class MurderOfCrows {

    ArrayList<Crow> theMurder = new ArrayList<Crow>();
ArrayList<String> CrowContents = new ArrayList<String>();
Object[] CrowStomachIterator;
    public static void main(String[] args) {
        MurderOfCrows murderOfCrows = new MurderOfCrows();
        murderOfCrows.initializeCrows();
        murderOfCrows.findTheDiamond();
    }

    private void findTheDiamond() {
    	System.out.println("Finding...");
        // 1. One of the Crows has eaten the diamond. You need to search
        //    through the stomach of each Crow, then print the name of the
        //    guilty Crow.

        // 2. How many innocent crows had to die before the diamond was found?
    	
for (int i = 0; i < theMurder.size(); i++) {
 //convert arraylist to array then go through until diamond is found
CrowStomachIterator = theMurder.get(i).getStomachContents().toArray();
     for (int j = 0; j < CrowStomachIterator.length; j++) {
    	  if (CrowStomachIterator[j].toString() == "diamond") {
    			System.out.println(theMurder.get(i).getName() + " stole the diamond!");
    			System.out.println(i + " crows died before finding the diamond!");
    		}
	}
  //theMurder.get(i).getStomachContents().toString()
}
    }

    private void initializeCrows() {
        theMurder.add(new Crow("Rok"));
        theMurder.add(new Crow("Merle"));
        theMurder.add(new Crow("Poe"));
        theMurder.add(new Crow("Grenwyn"));
        theMurder.add(new Crow("Crawford"));
        hideTheDiamond();
    }

    private void hideTheDiamond() {
        int randomness = new Random().nextInt(theMurder.size());
        theMurder.get(randomness).getStomachContents().add("diamond");
    }
}

class Crow {
    private String name;
    private ArrayList<String> stomachContents = new ArrayList<String>();

    public Crow(String name) {
        this.name = name;
        fillCrowsStomach();
    }

    private void fillCrowsStomach() {
        for (int i = 0; i < 10; i++)
            this.stomachContents.add(getRandomCrowFood());
    }

    private String getRandomCrowFood() {
        int randomness = new Random().nextInt(4);
        if (randomness == 0) return "carrion";
        else if (randomness == 1)return "snail";
        else if (randomness == 2)return "acorn";
        else if (randomness == 3)return "spider";
        else return "grub";
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getStomachContents() {
        return stomachContents;
    }
}
