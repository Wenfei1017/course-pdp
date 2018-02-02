package edu.neu.ccs.cs5010;

public class Duplexe extends CandyTree implements House {
    public Duplexe(Object rootData) {
        super(rootData);
    }


    Node duplexe = new Node<String>();
    {
        Node superSize = new Node();
        Node kingSize = new Node();
        Node funSize = new Node();

        duplexe.children.add(superSize);
        duplexe.children.add(kingSize);
        duplexe.children.add(funSize);

        superSize.children.add("Toblerone");
        superSize.children.add("Baby Ruth");
        superSize.children.add("Almond Joy");

        kingSize.children.add("Twix");
        kingSize.children.add("Snickers");
        kingSize.children.add("Mars");

        funSize.children.add("Kit Kat");
        funSize.children.add("Whoopers");
        funSize.children.add("Milky Way,");
        funSize.children.add("Crunch");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
