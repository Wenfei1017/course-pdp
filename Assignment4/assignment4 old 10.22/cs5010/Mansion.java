package edu.neu.ccs.cs5010;

import sun.tools.tree.Node;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mansion extends CandyTree implements House {
    public Mansion(Object rootData) {
        super(rootData);
    }



     Node mansion = new Node<String>();
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

    //Candy mansionCandy = new Candy();




    @Override
    public void accept(Visitor visitor) {
            visitor.visit(this);
    }

    Set<String> normalsizeSet = Stream.of("Super size","King size","Fun size").collect(Collectors.toSet());

    /*public class mansionTree<E> {
        private Node mansion;

        public mansionTree(){
            mansion = new Node();
        }



        Set<String> msizeSet = Stream.of("Super size","King size","Fun size").collect(Collectors.toSet());  */
   }