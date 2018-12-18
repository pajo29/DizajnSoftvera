package application;

import users.model.UserDatabase;
import users.view.LoginFrame;

public class Main {

	/*
	 * Author Pavle Prica
	 */
	public static void main(String[] args)
	{
		UserDatabase.getInstance().loadUsers();
		LoginFrame.getInstance();
	}

}
