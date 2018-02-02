package edu.neu.ccs.cs5010;

public class DetachedHouse extends CandyTree implements House {


    public DetachedHouse(Object rootData) {
        super(rootData);
    }


    Node detachedHouse = new Node<String>();
    {
        Node superSize = new Node();
        Node kingSize = new Node();
        Node funSize = new Node();

        detachedHouse.children.add(superSize);
        detachedHouse.children.add(kingSize);
        detachedHouse.children.add(funSize);

        superSize.children.add("Kit Kat");
        superSize.children.add("Whoopers");
        superSize.children.add("Milky Way");
        superSize.children.add("Crunch");

        kingSize.children.add("Toblerone");

        funSize.children.add("Twix");
        funSize.children.add("Snickers");
        funSize.children.add("Mars");
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
