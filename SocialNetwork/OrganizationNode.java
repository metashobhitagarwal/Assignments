package SocialNetwork;

import java.util.List;

public class OrganizationNode extends Node{
	String orgName;
	List<UserNode> likeList;
	
	@Override
	void setName(String name){
		orgName=name;
	}
	
	@Override
	void setList(UserNode userObj){
		likeList.add(userObj);
	}
	
	@Override
	List<UserNode> getList(){
		return likeList;
	}
	
	@Override
	String getName() {
		return orgName;
	}
	
	String getType(){
		return "organization";
	}
}
