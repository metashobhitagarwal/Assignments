package SocialNetwork;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;

public class SocialNetworkMain {
	static RecordDisplay rdisplay;
	static Entity  entity;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int choice=0;
		entity=new Entity();
		entity.getSourceDetail();
		rdisplay=new RecordDisplay();
		rdisplay.initialDisplay();
		do{
			choice= rdisplay.getChoice();
		}while(choice != 1 && choice != 2);
		
		if(choice==1){
			rdisplay.userRecord(entity.getUserList());
			choice=choiceValidation(entity.getUserList().size());
			System.out.println("ch"+choice);
			rdisplay.displayProfile(entity.getUserList().get(choice-1));
		}else{
			rdisplay.orgRecord(entity.getOrgList());
			choice=choiceValidation(entity.getOrgList().size());
			rdisplay.displayProfile(entity.getOrgList().get(choice-1));
		}
		
		
		
	}
	
	public static int choiceValidation(int size){
		int choice=0;
		do{
			choice= rdisplay.getChoice();
		}while(choice < 1 || choice > size);
		return choice;
	}

	
}
