package actions;

import main.MainFrame;
import messageHandler.MessageHandler;
import messageHandler.MessageType;
import users.model.User;
import users.model.UserDatabase;
import users.view.LoginFrame;

import java.awt.event.ActionEvent;

public class Login extends AbstractGEDAction {

	public Login() {

		putValue(SHORT_DESCRIPTION, "Loguje se u aplikaciju");
		putValue(NAME, "Login");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {

		User user = UserDatabase.getInstance().findUserByUserAndPass(LoginFrame.getInstance().getTfUser().getText(), LoginFrame.getInstance().getTfPassword().getText());

		if(user != null) {
			MainFrame.getInstance(user);
			LoginFrame.getInstance().dispose();
		}
		else
			MessageHandler.handleEvent(MessageType.WRONG_CREDIDENTALS);
	}

}
