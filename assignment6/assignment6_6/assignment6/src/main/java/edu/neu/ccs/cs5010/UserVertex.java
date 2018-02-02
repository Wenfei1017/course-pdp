package edu.neu.ccs.cs5010;

/**
 * define the vertex in this graph
 */
public class UserVertex {
    /**
     * The User.
     */
    public Users user; //the info saved in each vertex is users

    /**
     * The First edge.
     */
    public Edges firstEdge;

    /**
     * Instantiates a new User vertex.
     */
    public UserVertex() {
        this.user = null;
        this.firstEdge = null;
    }

    /**
     * Instantiates a new User vertex.
     *
     * @param user  the user
     * @param edges the edges
     */
    public UserVertex(Users user, Edges edges) {
        this.user = user;
        this.firstEdge = edges;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(Users user) {
        this.user = user;
    }

    /**
     * Set first edge.
     *
     * @param firstEdge the first edge
     */
    public void setFirstEdge(Edges firstEdge){
        this.firstEdge = firstEdge;
    }

    /**
     * Gets user id.
     *
     * @return the user id
     */
    public int getUserID() {
        return user.getUsersID();
    }

    /**
     * Get first edge edges.
     *
     * @return the edges
     */
    public Edges getFirstEdge(){
        return firstEdge;
    }

}
