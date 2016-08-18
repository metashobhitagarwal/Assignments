package SocialNetwork;

import java.util.List;
import java.util.Scanner;

public class RecordDisplay {
	public void initialDisplay(){
		System.out.println("Social List : ");
		System.out.println("1.User List \n2.Organization");
		
	}
	public void userRecord(List<UserNode> userList){
		
		System.out.println("User List");
		System.out.println("-----------------");
		int counter=1;
		for(UserNode uNode:userList){
			System.out.println(counter+"."+uNode.getName());counter++;
		}
		System.out.println("");
	}
	
	public void orgRecord(List<OrganizationNode> orgList){
		int counter=1;
		
		System.out.println("Organization List");
		System.out.println("-----------------");
		for(OrganizationNode orgNode: orgList){
			System.out.println(counter+"."+orgNode.getName());counter++;
		}
		System.out.println("");
	}
	
	public void displayProfile(Node node){
			System.out.println("Welcome "+node.getName()+" to your profile");
			if(node.getType().equalsIgnoreCase("user")){
				System.out.println("1.Friend List");
				System.out.println("2.Add Friend");
				System.out.println("3.Check Connection");
				System.out.println("4.Check for mutual friend");
			}
			else{
				
			}
			
		}
	
	public int getChoice(){
		Scanner scan=new Scanner(System.in);
		int choice= 0;
		System.out.print("Enter your choice : ");
		try{
			choice= Integer.parseInt(scan.next());
			
		}
		catch(Exception e){
			System.out.println("Enter correct choice");
			getChoice();
		}
		//scan.close();
		return choice;
	}
}
