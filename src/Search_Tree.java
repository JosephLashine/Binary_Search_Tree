import java.util.*;
import java.util.Scanner;


public class Search_Tree
{
	public Node root;//Root 
	public int value; //Each value
	public Node left; //Left value
	public Node right;//Right value
	
	public class Node<E>
	{
		public int value;
		public Node left;
		public Node right;
		
		public Node(int value)
		{
			this.value = value;
		}

		
	
	}
		private void inserting(Node nextRoot, Node node){ // Insert the value into the specific node

		    if ( nextRoot.value > node.value){ // if the value is greater than the previous value

		      if ( nextRoot.left == null ){ // If left is empty
		        nextRoot.left = node; // left root equal value
		        return;
		      }
		      else{
		        inserting(nextRoot.left, node); // Insert value on left most node
		      }
		    }
		    else{
		      if (nextRoot.right == null){ // right is empty
		        nextRoot.right = node; // right equal node on left
		        return;
		      }
		      else{
		        inserting(nextRoot.right, node); // Insert right node
		      }
		    }
		
		  
	}
	
		public void Insert(int value)
		{
			Node node = new Node<>(value);
			
			if(root == null) //If the root is empty
			{
				root = node; // Root equals first  value
				return;
			}
			inserting(root,node); //insert value accordingly
		}
		private void inTran(Node currRoot){ // In order transversal
			  if ( currRoot == null ){ //Current root is empty
			    return; //return nothing
			  }
			  inTran(currRoot.left);// Start from the left
			  System.out.print(currRoot.value+", "); //print
			  inTran(currRoot.right);//print right
			}
		 public void inorderTransversal() {
			    inTran(root);// start with root
			    System.out.println(""); // print whole binary search in order
			  }
	
				
		 
		 public boolean delete(int delete){
				Node parent = root; 
				Node current = root;
				boolean leftChild = false; //set leftchild as false
				while(current.value!=delete){ // while the current value is not the one being deleted
					parent = current;
					if(current.value>delete){ //If the value is greater than the the one being deleted 
						leftChild = true;
						current = current.left;
					}else{
						leftChild = false; // It is in the right child
						current = current.right;
					}
					if(current ==null){ // Not in the binary search
						return false;
					}
				}
				if(current.left==null && current.right==null){ //If left and right are null
					if(current==root){ // Located at the root
						root = null;
					}
					if(leftChild ==true){ // if it euals left child
						parent.left = null;
					}else{
						parent.right = null;
					}
				}
				
				else if(current.right==null){ // if right child is null
					if(current==root){
						root = current.left;
					}else if(leftChild){
						parent.left = current.left;
					}else{
						parent.right = current.left;
					}
				}
				else if(current.left==null){ // if left is empty
					if(current==root){
						root = current.right;
					}else if(leftChild){
						parent.left = current.right;
					}else{
						parent.right = current.right;
					}
				}else if(current.left!=null && current.right!=null){ // search through the tree
					
					
					Node nextValue	 = getNext(current);
					if(current==root){
						root = nextValue; //set root to the next value
					}else if(leftChild){
						parent.left = nextValue;
					}else{
						parent.right = nextValue;
					}			
					nextValue.left = current.left;
				}		
				return true;		
			}
		 public Node getNext(Node deleleNode){
				Node nextValue =null; // if next parent equals null
				Node nextParent =null; // if next parent equlas null
				Node current = deleleNode.right; // delete the right node
				while(current!=null){ // if current value is not null
					nextParent= nextValue; //next parent equals next value
					nextValue = current; //next value equals current
					current = current.left; // current equals left
				}
				
				if(nextValue!=deleleNode.right){ // next value equals the delete node
					nextParent.left = nextValue.right; //left parent equals next right value
					nextValue.right = deleleNode.right; // next right value  = delete right node
				}
				return nextValue;
			}
		 public boolean Search(int id){
				Node current = root; // start from root
				while(current!=null){ // current value not empt
					if(current.value==id){ // If current value equals root
						return true;
					}else if(current.value>id){ //If value searched for is greater than left current 
						current = current.left; // If current equals left node
					}else{
						current = current.right; //If current equals right node
					}
				}
				return false; // Not found
			}
		  
	}
	



	  	  

	




