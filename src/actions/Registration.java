package actions;

import messageHandler.MessageHandler;
import messageHandler.MessageType;
import users.model.User;
import users.model.UserDatabase;
import users.view.RegistrationFrame;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.KeyStroke;


public class Registration extends AbstractGEDAction {

	public Registration() {

		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke((char) KeyEvent.VK_ENTER));
		putValue(NAME, "Registracija");
		putValue(SHORT_DESCRIPTION, "Registrujte se");

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		RegistrationFrame view = RegistrationFrame.getInstance();
		UserDatabase model = UserDatabase.getInstance();

		if(!(view.getTfName().getText().isEmpty() || view.getTfUsername().getText().isEmpty() ||
				view.getTfPassword().getText().isEmpty() || !(((String)view.getCmbRole().getSelectedItem()).equals("Admin")
				|| ((String)view.getCmbRole().getSelectedItem()).equals("Operativni korisnik"))))
		{

					String role = ((String)view.getCmbRole().getSelectedItem()).toLowerCase();


					User usr = new User(setID(model.getUsers().size()), view.getTfName().getText(),
							view.getTfUsername().getText(),
							view.getTfPassword().getText(),
							role);

					if(!model.checkIfUserExists(usr))
					{
						model.addUser(usr);
						view.getTfName().setText("");
						view.getTfUsername().setText("");
						view.getTfPassword().setText("");
					}
					else
					{
						MessageHandler.handleEvent(MessageType.USER_ALREADY_EXISTS);
						return;
					}

		}
		else
		{
			System.out.println("Ovde 1");
			MessageHandler.handleEvent(MessageType.INCOMPLETE_REGISTRATION);
			return;
		}
		MessageHandler.handleEvent(MessageType.COMPLETE_REGISTRATION);
        UserDatabase.getInstance().loadUsers();
		view.dispose();
	}

	private int setID(int size)
	{
		for(User user: UserDatabase.getInstance().getUsers())
		{
			if(user.getID() == size)
				size = setID(size + 1);
		}
		return size;
	}

	}


