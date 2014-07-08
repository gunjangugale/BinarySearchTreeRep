/*
 * Gunjan Gugale
 * COSC 600
 * Problem solving assignment code for Binary Search tree
 */


import java.util.*;

public class BinarySearchTree 
{
	static Node root;
	static Scanner username = new Scanner(System.in);
	static int num = 0;

	public void addNode(int key) 
	{
		Node newNode = new Node(key);		

		if (root == null) 
		{
			root = newNode;
		} 
		else 
		{			
			Node currentNode = root;			
			Node parent;

			while (true) 
			{
				parent = currentNode;
				if (key < currentNode.key) 
				{
					currentNode = currentNode.leftChild;
					if (currentNode == null) 
					{
						parent.leftChild = newNode;
						return; 
					}
				} 
				else 
				{ 
					currentNode = currentNode.rightChild;
					if (currentNode == null) 
					{
						parent.rightChild = newNode;
						return; 
					}
				}
			}
		}
	}

	 public static void printNodes (Node n, int key1, int key2)
	 {		
	    if (n != null)
	    {
	    	if (n.key > key1)
	    	{
	    		printNodes(n.leftChild, key1, key2); 
	    	}
	    	if ((n.key >= key1) && (n.key <= key2))
	    	{
	    		System.out.println(n.key); 
	    	}
	    	if (n.key < key2)
	    	{
	    		printNodes(n.rightChild, key1, key2); 
	    	}	    	   		    	
	    }	    	   
	 }
	 		
	 public static void main(String[] args) 
	 {

		BinarySearchTree theTree = new BinarySearchTree();

		System.out.println("How many elements do you wish to add to the tree?");
		int size = username.nextInt();
		System.out.println("Enter node values to be inserted to the tree :");
		
		for (int i=0; i<size; i++)
		{			
			int newelem = username.nextInt();
			theTree.addNode(newelem);
		}
		
		System.out.println("Enter key K1");
		int key1 = username.nextInt();
		
		System.out.println("Enter key K2 such that K1 <= K2");
		int key2 = username.nextInt();
		
		System.out.println("\nThe elements between key1 nd key2 are : ");
		long timestart = System.nanoTime();
		printNodes (root, key1, key2);		
		long timeend = System.nanoTime();
        System.out.println("Run time = " + (timeend - timestart) + " ns");        		        
	 }
}

class Node 
{
	int key;	

	Node leftChild;
	Node rightChild;

	Node(int key) 
	{
		this.key = key;		
	}
}

