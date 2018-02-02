package edu.neu.ccs.cs5010;

import java.util.ArrayList;
import java.util.List;

/**
 * define the vertex in this graph
 */
public class UserVertex {
    public Users user; //the info saved in each vertex is users
    //private boolean isVisited;
    public Edges firstEdge;

    public UserVertex() {
        this.user = null;
        this.firstEdge = null;
    }
    public UserVertex(Users user, Edges edges) {
        this.user = user;
        this.firstEdge = edges;
    }
    public void setUser(Users user) {
        this.user = user;
    }

    public void setFirstEdge(Edges firstEdge){
        this.firstEdge = firstEdge;
    }

    public Users getUser() {
        return user;
    }

    public Edges getFirstEdge(){
        return firstEdge;
    }


}
