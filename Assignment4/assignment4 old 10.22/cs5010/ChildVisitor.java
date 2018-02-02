package edu.neu.ccs.cs5010;

public class ChildVisitor implements Visitor {
    @Override
    public void visit(Mansion mansion) {
        System.out.println("Visiting mansions");
    }

    @Override
    public void visit(DetachedHouse detachedHouse) {
        System.out.println("Visiting detach houses");
    }

    @Override
    public void visit(Duplexe duplexe) {
        System.out.println("Visiting duplexes");
    }

    @Override
    public void visit(TownHome townHome) {
        System.out.println("Visiting town homes");
    }
}
