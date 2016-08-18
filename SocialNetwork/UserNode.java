package SocialNetwork;

import java.util.List;

public class UserNode extends Node{
	String userName;
	List<UserNode> frndList;
	
	@Override
	void setName(String name){
		userName=name;
	}
	
	@Override
	void setList(UserNode userObj){
		frndList.add(userObj);
	}
	
	@Override
	List<UserNode> getList(){
		return frndList;
	}
	
	@Override
	String getName() {
		return userName;
	}
	
	String getType(){
		return "user";
	}

}
