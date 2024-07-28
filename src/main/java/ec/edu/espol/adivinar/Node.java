/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espol.adivinar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    
    public List<Node<E>> childrenNodesList(){
        
        List<Node<E>> childrenNodes = new ArrayList<>();
        
        if(isLeaf()){
            childrenNodes.add(this);
            return childrenNodes;
        }
        if(this.left!= null){
            childrenNodes.addAll(this.left.childrenNodesList());
        }
        
        if(this.right!= null){
            childrenNodes.addAll(this.right.childrenNodesList());
        }
        
        return childrenNodes;
    }

    @Override
    public String toString() {
        return "Node{" + "data=" + data + '}';
    }
    
    public void addChildrenQuestion(String question){
       // List<Node<E>> childrenNodes = childrenNodesList();
        //for (Node<E> node : childrenNodes){
        if(this.isLeaf()){
            this.left = new Node(question);
            this.right = new Node(question);
        }
        else{
            this.left.addChildrenQuestion(question);
            this.right.addChildrenQuestion(question);
            
        }
        //}
    }
    /*
    public void addChildrenQuestion(String question){
        if(this==null){
            return;
        }
        
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(this);
        
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            
            for(int i=0; i < levelSize; i++){
                Node<E> node = queue.poll();
                node.addQuestion(question);
            }
        }
            
    }
    */
    
    public void addQuestion(String question){
        Node<String> node = new Node(question);
        this.left = (Node<E>) node;
        this.right = (Node<E>) node;
    }
}
