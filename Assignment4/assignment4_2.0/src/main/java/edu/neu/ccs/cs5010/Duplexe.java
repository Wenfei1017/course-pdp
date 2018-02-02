package edu.neu.ccs.cs5010;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Duplexe implements House {
   Candy duplexeCandy;
   List duplexeList;

    /**
     *
     * @return the candy list duplexe house can give to children
     */
   public List getCandy(){
       //duplexeCandy = new Candy();
       duplexeList = new ArrayList();
       duplexeList.add(duplexeCandy.createCandy("Super","Toblerone"));
       duplexeList.add(duplexeCandy.createCandy("Super","Baby Ruth"));
       duplexeList.add(duplexeCandy.createCandy("Super","Almond Joy"));

       duplexeList.add(duplexeCandy.createCandy("King","Twix"));
       duplexeList.add(duplexeCandy.createCandy("King","Snickers"));
       duplexeList.add(duplexeCandy.createCandy("King","Mars"));

       duplexeList.add(duplexeCandy.createCandy("Fun","Kit Kat"));
       duplexeList.add(duplexeCandy.createCandy("Fun","Whoopers"));
       duplexeList.add(duplexeCandy.createCandy("Fun","Milky Way"));
       duplexeList.add(duplexeCandy.createCandy("Fun","Crunch"));

       return duplexeList;
   }

    @Override
    public String getHouseName() {
        return "Duplexe";
    }


    /*Node duplexe = new Node<String>();
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
    */

    @Override
    public void accept(Visitor visitor) throws FileNotFoundException {
        visitor.visit(this);
    }
}
