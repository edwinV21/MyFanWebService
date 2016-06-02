package myfan.controllers;

import myfan.models.Artista;
import myfan.models.Fanatico;
import myfan.models.User;

public class UsersFactory {
	
	public User createUser(String type){
		User tmpUser=null;
		if(type.equals("artista")){
			tmpUser= new Artista();
		}
		else if(type.equals("fanatico")){
			tmpUser= new Fanatico();
		}
		
		return tmpUser;
	}
	
}
