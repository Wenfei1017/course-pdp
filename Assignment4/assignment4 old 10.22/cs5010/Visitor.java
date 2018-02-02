package edu.neu.ccs.cs5010;

public interface Visitor {
    public void visit(Mansion mansion);
    public void visit(DetachedHouse detachedHouse);
    public void visit(Duplexe duplexe);
    public void visit(TownHome townHome);
}
