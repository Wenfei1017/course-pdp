package edu.neu.ccs.cs5010;

import sun.tools.tree.Node;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mansion implements House {

    Candy mansionCandy;
    List<Candy> mansionList;
    Set<String> candynameset = Stream.of("Twix","Snikers","Mars","Kit Kat","Whoopers",
            "Milky Way","Toblerorn","Crunch","Baby Ruth","Almond Joy").collect(Collectors.toSet());
    Set<String> candysizeset = Stream.of("Super","King","Regular","Fun").collect(Collectors.toSet());

    /**
     *
     * @return the candy list mansion house can give
     */
    public List getCandy(){
        mansionList = new ArrayList();
        //mansionCandy = new Candy("Super size","Twix");
        mansionList.add(new Candy("Super size","Twix"));
        mansionList.add(new Candy("Super size","Snickers"));
        mansionList.add(new Candy("Super size","Mars"));

        mansionList.add(new Candy("King size","Kit Kat"));
        mansionList.add(new Candy("King size","Whoopers"));
        mansionList.add(new Candy("King size","Crunch"));

        mansionList.add(new Candy("Fun size","Toblerone"));
        mansionList.add(new Candy("Fun size","Baby Ruth"));
        mansionList.add(new Candy("Fun size","Almond Joy"));

        return mansionList;
    }

    @Override
    //get the house name "mansion"
    public String getHouseName() {
        return "Mansion";
    }



 /*    Node mansion = new Node<String>();
    {
        Node superSize = new Node();
        Node kingSize = new Node();
        Node funSize = new Node();

        mansion.children.add(superSize);
        mansion.children.add(kingSize);
        mansion.children.add(funSize);

        superSize.children.add("Twix");
        superSize.children.add("Snickers");
        superSize.children.add("Mars");

        kingSize.children.add("Kit Kat");
        kingSize.children.add("Whoopers");
        kingSize.children.add("Crunch");

        funSize.children.add("Toblerone");
        funSize.children.add("Baby Ruth");
        funSize.children.add("Almond Joy");
    }
    */

    //Candy mansionCandy = new Candy();




    @Override
    public void accept(Visitor visitor) throws FileNotFoundException {
            visitor.visit(this);
    }

    //Set<String> normalsizeSet = Stream.of("Super size","King size","Fun size").collect(Collectors.toSet());

    /*public class mansionTree<E> {
        private Node mansion;

        public mansionTree(){
            mansion = new Node();
        }



        Set<String> msizeSet = Stream.of("Super size","King size","Fun size").collect(Collectors.toSet());  */
   }