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
        detachedList.add(detachedCandy.createCandy("Super","Kit Kat"));
        detachedList.add(detachedCandy.createCandy("Super","Whoopers"));
        detachedList.add(detachedCandy.createCandy("Super","Milky Way"));
        detachedList.add(detachedCandy.createCandy("Super","Crunch"));

        detachedList.add(detachedCandy.createCandy("King","Toblerone"));

        detachedList.add(detachedCandy.createCandy("Fun","Twix"));
        detachedList.add(detachedCandy.createCandy("Fun","Snickers"));
        detachedList.add(detachedCandy.createCandy("Fun","Mars"));

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
