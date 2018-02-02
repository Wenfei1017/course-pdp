package edu.neu.ccs.cs5010;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DetachedHouse implements House {
    Candy detachedCandy;
    List detachedList;

    /**
     *
     * @return the candy list detached house can give to children
     */
    public List getCandy(){
        //detachedCandy = new Candy();
        detachedList = new ArrayList();
        detachedList.add(new Candy("Super","Kit Kat"));
        detachedList.add(new Candy("Super","Whoopers"));
        detachedList.add(new Candy("Super","Milky Way"));
        detachedList.add(new Candy("Super","Crunch"));

        detachedList.add(new Candy("King","Toblerone"));

        detachedList.add(new Candy("Fun","Twix"));
        detachedList.add(new Candy("Fun","Snickers"));
        detachedList.add(new Candy("Fun","Mars"));

        return detachedList;
    }


    /*Node detachedHouse = new Node<String>();
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
    */


    @Override
    public void accept(Visitor visitor) throws FileNotFoundException {
        visitor.visit(this);
    }


    @Override
    public String getHouseName() {
        return "Detached House";
    }
}
