/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.adivinar;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Gecko
 */
public class Node<E> {   
    E data;
    Node<E> left;
    Node<E> right;
    

    public Node(E data){
        this.data = data;
        left = right = null;
    }
    
    public boolean isLeaf(){
        return left==null && right==null;
    }
    
    public List<Node<E>> childrenNodesData(){
        
        List<Node<E>> childrenNodes = new ArrayList<>();
        
        if(isLeaf()){
            childrenNodes.add(this);
            return childrenNodes;
        }
        if(this.left!= null){
            childrenNodes.addAll(this.left.childrenNodesData());
        }
        
        if(this.right!= null){
            childrenNodes.addAll(this.right.childrenNodesData());
        }
        
        return childrenNodes;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + '}';
    }
     
}
