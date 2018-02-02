package edu.neu.ccs.cs5010;

public class TownHome extends CandyTree implements House {
    public TownHome(Object rootData) {
        super(rootData);
    }

    Node townHome = new Node<String>();

    {
        Node regularSize = new Node();
        townHome.children.add(regularSize);

        regularSize.children.add("Twix");
        regularSize.children.add("Snickers");
        regularSize.children.add("Mars");
        regularSize.children.add("Kit Kat");
        regularSize.children.add("Whoopers");
        regularSize.children.add("Toblerone");
        regularSize.children.add("Baby Ruth");
        regularSize.children.add("Almond Joy");

    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
