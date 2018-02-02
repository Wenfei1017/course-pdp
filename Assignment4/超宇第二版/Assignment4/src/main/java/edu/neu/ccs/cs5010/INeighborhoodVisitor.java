package edu.neu.ccs.cs5010;

import java.util.ArrayList;

/**
 * Created by wenfei on 10/22/17.
 */
public interface INeighborhoodVisitor {

    void visit(Neighborhood neighborhood);

    void visit(Mansion mansion);
    void visit(Detached detached);
    void visit(Duplex duplex);
    void visit(Townhome townhome);

}
