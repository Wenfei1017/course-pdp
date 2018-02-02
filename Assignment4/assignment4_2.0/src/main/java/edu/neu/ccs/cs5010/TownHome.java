package edu.neu.ccs.cs5010;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TownHome  implements House {
    Candy townhomeCandy;
    List townhomeList;

    /**
     *
     * @return the candy list twon house can give to children
     */
    public List getCandy(){
        //townhomeCandy = new Candy();
        townhomeList = new ArrayList();
        townhomeList.add(townhomeCandy.createCandy("Regular","Twix"));
        townhomeList.add(townhomeCandy.createCandy("Regular","Snickers"));
        townhomeList.add(townhomeCandy.createCandy("Regular","Mars"));
        townhomeList.add(townhomeCandy.createCandy("Regular","Kit Kat"));
        townhomeList.add(townhomeCandy.createCandy("Regular","Whoopers"));
        townhomeList.add(townhomeCandy.createCandy("Regular","Toblerone"));
        townhomeList.add(townhomeCandy.createCandy("Regular","Baby Ruth"));
        townhomeList.add(townhomeCandy.createCandy("Regular","Almond Joy"));

        return townhomeList;

    }

    @Override
    public String getHouseName() {
        return "Town Home";
    }


    /*Node townHome = new Node<String>();

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
    */

    @Override
    public void accept(Visitor visitor) throws FileNotFoundException {
        visitor.visit(this);
    }
}
