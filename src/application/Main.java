package application;

import users.model.UserDatabase;
import users.view.Login;

public class Main {

	/*
	 * Author Pavle Prica
	 */
	public static void main(String[] args) {
		UserDatabase.getInstance().loadUsers();
		Login.getInstance();
	}

}
