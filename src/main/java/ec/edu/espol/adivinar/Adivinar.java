/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.adivinar;

import java.util.Scanner;

/**
 *
 * @author Gecko
 */
public class Adivinar {

    public static void main(String[] args) {
        Node<String> node1 = new Node("Es mamifero");
        Node<String> nodeOso = new Node("Oso");
        Node<String> nodeVenado = new Node("Venado");
        Node<String> nodeLechuza = new Node("Lechuza");
        Node<String> nodePaloma = new Node("Paloma");
        
        
        node1.left = new Node("Es carnivoro?");
        node1.right = new Node("Es carnivoro?");
        node1.left.left = new Node("Se para en cuatro patas?");
        node1.left.right = new Node("Se para en cuatro patas?");
        node1.right.left = new Node("Se para en cuatro patas?");
        node1.right.right = new Node("Se para en cuatro patas?");
        node1.left.left.left = nodeOso;
        node1.left.right.left = nodeVenado;
        node1.right.left.right = nodeLechuza;
        node1.right.right.right = nodePaloma;

        System.out.println("Piense un animal.");
        Scanner sc = new Scanner(System.in);
        System.out.print("Numero de preguntas: ");
        
        int n;
        do{
            n = sc.nextInt();
        } while(n<0);
        
        preguntar(node1, n);
        
        
    }
        
    public static boolean preguntar(Node root, int n){
        Scanner sc = new Scanner(System.in);
        boolean res;
        
        if(root==null){
            System.out.println("No existe ningun animal que coincida con las"
                    + "respuestas provistas ");
           return true;
        }
        
        else if(root.isLeaf()){
            System.out.println("La respuesta es: " + root.data);
            return true;
        }

        else if(n>0){
            // The node is a question so print it
            System.out.println(root.data);
            // Already spend a question
            n-=1;
            // Retrieve the answer
            System.out.print("Escriba la respuesta: ");
            String respuesta = sc.nextLine().toLowerCase();
            
            boolean afirmativo = respuesta.equals("si");

            if(afirmativo){
                res = preguntar(root.left, n);
            } 
            else{ res =  preguntar(root.right, n);}
        }
        
        else{
            System.out.println("No suficientes preguntas."); 
            System.out.println("Nodo: " + root.childrenNodesData());
            return false;
        }
            return res;   
            
    }
        
}

