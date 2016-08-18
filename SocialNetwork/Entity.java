package SocialNetwork;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Entity {
	BufferedReader in = null;
	BufferedWriter out = null;
	List<UserNode> uList;
	List<OrganizationNode> oList;
	
	public void getSourceDetail() throws IOException{
		String line;
		uList=new ArrayList<UserNode>();
		oList=new ArrayList<OrganizationNode>();
	try {
		in = new BufferedReader(new FileReader(".//src//SocialNetwork//source.txt"));
		out = new BufferedWriter(new FileWriter(".//src//SocialNetwork//report.txt", true));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	while((line = in.readLine()) != null)
	{	
		String str[]=line.split(",");
		if(str[1].trim().equalsIgnoreCase("user")){
			UserNode ob=new UserNode();
			ob.setName(str[0]);
			uList.add(ob);
		}
		else if(str[1].trim().equalsIgnoreCase("organization")){
			OrganizationNode ob=new OrganizationNode();
			ob.setName(str[0]);
			oList.add(ob);
		}
	}
}
	
	public List<UserNode> getUserList(){
		return uList;
	}
	
	public List<OrganizationNode> getOrgList(){
		return oList;
	}
}
