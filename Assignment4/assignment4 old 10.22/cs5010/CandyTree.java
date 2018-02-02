package edu.neu.ccs.cs5010;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.sun.tools.doclets.internal.toolkit.util.DocPath.parent;


public abstract class CandyTree<T> {




    private Node<T> root;

    public CandyTree(T rootData) {
        root = new Node<T>();
        root.data = rootData;
        root.children = new ArrayList<Node<T>>();
    }

    public void inputchild(Node child, Node parent){

    }

    public static class Node<T> {
        private T data;
        private Node<T> parent;
        protected List<Node<T>> children;
    }


    /*Node neignborhood = new Node<String>();
    {
        neignborhood.children.add(new Mansion());
        neignborhood.children.add(new DetachedHouse());
        neignborhood.children.add(new Duplexe());
        neignborhood.children.add(new TownHome());

        for(Node housenode :neignborhood.children){

        }
    }
    */

}
