//package actions;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.KeyEvent;
//
//import javax.swing.KeyStroke;
//
//import exceptionHandler.*;
//import registration.RegistrationFrame;
//import user.model.User;
//import user.model.UserDatabase;
//
//public class Registration extends AbstractGEDAction {
//
//	public Registration() {
//
//		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke((char) KeyEvent.VK_ENTER));
//		putValue(NAME, "Registracija");
//		putValue(SHORT_DESCRIPTION, "Registrujte se");
//
//	}
//
//	@Override
//	public void actionPerformed(ActionEvent e) {
//
//		RegistrationFrame view = RegistrationFrame.getInstance();
//		UserDatabase model = UserDatabase.getInstance();
//
//		if(!(view.getTfName().getText().isEmpty() || view.getTfUsername().getText().isEmpty() ||
//				view.getTfPassword().getText().isEmpty() || view.getTfAdress().getText().isEmpty() ||
//				view.getTfPhoneNumber().getText().isEmpty() || !(((String)view.getCmbRole().getSelectedItem()).equals("Admin")
//				|| ((String)view.getCmbRole().getSelectedItem()).equals("Supervizor")
//				|| ((String)view.getCmbRole().getSelectedItem()).equals("Serviser"))))
//		{
//			if(model.getMasterPIN().equals(view.getTfPIN().getText()))
//			{
//
//					String role = ((String)view.getCmbRole().getSelectedItem()).toLowerCase();
//
//
//					User usr = new User(setID(model.getUsers().size()), view.getTfName().getText(),
//							view.getTfUsername().getText(),
//							view.getTfPassword().getText(),
//							view.getTfAdress().getText(),
//							view.getTfPhoneNumber().getText(),
//							role);
//
//					if(!model.checkIfUserExists(usr))
//					{
//						model.addUser(usr);
//						view.getTfName().setText("");
//						view.getTfUsername().setText("");
//						view.getTfPassword().setText("");
//						view.getTfAdress().setText("");
//						view.getTfPhoneNumber().setText("");
//						view.getTfPIN().setText("");
//					}
//					else
//					{
//						System.out.println("Ovde 3");
//						ExceptionHandler.handle(ExceptionType.USER_ALREADY_EXISTS);
//						return;
//					}
//
//			}
//			else
//			{
//				System.out.println("Ovde 2");
//				ExceptionHandler.handle(ExceptionType.INCOMPLETE_REGISTRATION);
//				return;
//			}
//		}
//		else
//		{
//			System.out.println("Ovde 1");
//			ExceptionHandler.handle(ExceptionType.INCOMPLETE_REGISTRATION);
//			return;
//		}
//		ExceptionHandler.handle(ExceptionType.SUCCESFUL_REGISTRATION);
//
//		view.dispose();
//	}
//
//	private int setID(int size)
//	{
//		for(User user: UserDatabase.getInstance().getUsers())
//		{
//			if(user.getID() == size)
//				size = setID(size + 1);
//		}
//		return size;
//	}
//
//	}
//
//
