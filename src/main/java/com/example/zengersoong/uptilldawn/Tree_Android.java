package com.example.zengersoong.uptilldawn;

/**
 * Created by Zenger Soong on 29/11/2017.
 */

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by yang on 2017-11-25.
 */


class Node{
    double time;
    double value;
    String location;
    String transport;
    boolean isEnd;
    Node left;
    Node mid;
    Node right;

    public Node(String location, String transport,double value, double time){
        this.transport = transport;
        this.location = location;
        this.time = time;
        this.value = value;
        this.isEnd = false;
        this.left = null;
        this.mid = null;
        this.right = null;
    }

}
public class Tree_Android {
    private Node root;

    public Node getRoot(){
        return root;
    }

    public Tree_Android(){
        this.root = null;
    }

    public void FormTree(ArrayList<Node> treelist,int index){
        Node current;
        if(index==0){
            root=treelist.get(index);
            current = root;
        }
        else{
            current=treelist.get(index);
        }
        if(index*3+3>treelist.size()-1){ // CANNOT put == since there is the final insert when index*3+3 == size-1, thus must put > to go through the last round!!!
            return;
        }
        current.left=treelist.get(index*3+1);
        current.mid=treelist.get(index*3+2);
        current.right=treelist.get(index*3+3);
        FormTree(treelist,index+1);
    }

    public void preOrder(Node root){
        if(root!=null) {
            preOrder(root.left);
            preOrder(root.mid);
            preOrder(root.right);

        }
    }

    public HashMap<String[],double[]> getPaths(Node node){
        int length=1000;
        double path[] = new double[length];
        double pathvalue[] = new double[length];
        String pathlocation[] = new String[length];
        String pathtransport[] = new String[length];
        HashMap<String[],double[]> mylist = new HashMap<>();

        printPathsRecur(node, mylist,pathlocation,pathtransport,path,pathvalue,0);
        return mylist;
    }

    public void printPathsRecur(Node node,HashMap<String[],double[]> mylist, String pathlocation[] ,String pathtransport[],double path[], double pathvalue[], int pathlen){
        pathlocation[pathlen] = node.location;
        pathtransport[pathlen] = node.transport;
        path[pathlen] = node.time;
        pathvalue[pathlen] = node.value;
        pathlen++;

        if(node.left == null && node.mid == null && node.right == null){
            printArray(mylist,pathlocation,pathtransport,path,pathvalue,pathlen);
        }
        else{
            printPathsRecur(node.left, mylist,pathlocation,pathtransport,path,pathvalue,pathlen);
            printPathsRecur(node.mid,mylist,pathlocation,pathtransport,path,pathvalue,pathlen);
            printPathsRecur(node.right, mylist,pathlocation,pathtransport,path,pathvalue,pathlen);
        }
    }

    public void printArray(HashMap<String[],double[]> mylist, String pathlocation[],String pathtransport[],double ints[], double values[], int len){
        int i;
        double sumoftime =0;
        double sumofvalue=0;
        String location="";
        String transport ="";
        for ( i =0; i<len;i++){
            sumoftime+=ints[i];
            sumofvalue+=values[i];
            location +=pathlocation[i]+"->";
            transport +=pathtransport[i]+"->";
        }
        double[] l = new double[2];
        l[0]=sumoftime;
        l[1] = sumofvalue;
        String[] s = new String[2];
        s[0] = location;
        s[1] = transport;
        mylist.put(s,l);
    }


}
