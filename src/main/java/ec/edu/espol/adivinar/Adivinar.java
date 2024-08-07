/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espol.adivinar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Gecko
 */
public class Adivinar {

    public static void main(String[] args) {
        
        Node<String> node1 = cargarArchivoPreguntas();
        cargarArchivoRespuestas(node1);
                 
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
            System.out.println("Nodo: " + root.childrenNodesList());
            return false;
        }
            return res;   
            
    }
   
    
    public static <E> Node<String> cargarArchivoPreguntas(){
             
        Path path = Paths.get("preguntas.txt");
        
        try{
            List<String> questions = Files.readAllLines(path);
            Node<String> root = new Node(questions.get(0));
            for(int i=1; i < questions.size(); i++){
                String question = questions.get(i);
                root.addChildrenQuestion(question);
            }
            
            return root;
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
        return null;
        
    }
    
    
    public static void cargarArchivoRespuestas(Node<String> root){
        Path path = Paths.get("respuestas.txt");
        
        try{
            List<String> questions = Files.readAllLines(path);
            for(String question : questions){
                root.addChildrenAnswer(question);
            }
            
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
}

