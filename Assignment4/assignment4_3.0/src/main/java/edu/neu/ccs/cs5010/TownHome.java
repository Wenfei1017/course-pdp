package edu.neu.ccs.cs5010;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/*public class TownHome  implements House {
    Candy townhomeCandy;
    List townhomeList;

    /**
     *
     * @return the candy list twon house can give to children
     */
    public List getCandy(){
        //townhomeCandy = new Candy();
        townhomeList = new ArrayList();
        townhomeList.add(new Candy("Regular","Twix"));
        townhomeList.add(new Candy("Regular","Snickers"));
        townhomeList.add(new Candy("Regular","Mars"));
        townhomeList.add(new Candy("Regular","Kit Kat"));
        townhomeList.add(new Candy("Regular","Whoopers"));
        townhomeList.add(new Candy("Regular","Toblerone"));
        townhomeList.add(new Candy("Regular","Baby Ruth"));
        townhomeList.add(new Candy("Regular","Almond Joy"));

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
*/