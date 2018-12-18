package application;

import users.model.UserDatabase;
import users.view.LoginFrame;

public class Main //TODO NA MODUL SE KACI PROIZVOD KOJI SE INSTALIRA, + DODATI PATH GDE CE SE INSTALIRATI PROIZVOD
{
	/*
	 * Author Pavle Prica
	 */
	public static void main(String[] args)
	{
		UserDatabase.getInstance().loadUsers();
		LoginFrame.getInstance();
	}
}
