package application;

import main.MainFrame;
import users.model.UserDatabase;

public class Main {

	/*
	 * Author Pavle Prica
	 */
	public static void main(String[] args) {
		UserDatabase.getInstance().loadUsers();
		MainFrame.getInstance();
	}

}
