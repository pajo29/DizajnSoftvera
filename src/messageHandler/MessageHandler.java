package messageHandler;

import javax.swing.JOptionPane;

import tree.treeModel.Node;
import main.MainFrame;
import gui.MainSplitPane;
import users.view.LoginFrame;

public class MessageHandler {
	
	@SuppressWarnings("incomplete-switch")
	public static int handleEvent(MessageType et)
	{
		switch(et)
		{
		case FILE_NOT_FOUND:
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Fajl nije pronadjen", "Neispravan postupak", JOptionPane.ERROR_MESSAGE);
			break;
		case NO_COMPONENT_SELECTED:
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste izabrali komponentu", "Neispravan postupak", JOptionPane.INFORMATION_MESSAGE);
			break;
		case PARAMETAR_SELECTED:
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Ne mozete dodati novo dete na parametar", "Neispravan postupak", JOptionPane.INFORMATION_MESSAGE);
			break;
		case SERIALISATION_FAIL:
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Cuvanje neuspesno!", "Greska", JOptionPane.ERROR_MESSAGE);
			break;
		case DESERIALISATION_FAIL:
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Ucitavanje neuspesno!\nProverite odabir!", "Greska", JOptionPane.ERROR_MESSAGE);
			break;
		case WRONG_COMPONENT_SELECTED_PARAMETAR:
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Za izmenu se mogu samo parametri otvarati!", "Greska", JOptionPane.ERROR_MESSAGE);
			break;
		case WRONG_COMPONENT_SELECTED_PRODUCT:
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Za exportovanje se moze samo proizvod izabrati!", "Greska", JOptionPane.ERROR_MESSAGE);
			break;
		case PROGRAM_START:
			int rez = JOptionPane.showConfirmDialog(LoginFrame.getInstance(), "Da li zelite da nastavite gde ste stali?", "?", JOptionPane.YES_NO_OPTION);
			return rez;
		case NODE_REMOVAL:
			Node cmp = (Node)MainSplitPane.getInstance().getTree().getLastSelectedPathComponent();
			int res2 = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni?\nBice obrisano\n"
					+ cmp.getChildCount() + " deteta i " + cmp.getLeafCount(0, cmp.getChildCount())+" lista", "Paznja", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			return res2;
		case CLOSING:
			int res3 = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li zelite da sacuvate promene?", "Cuvanje", JOptionPane.YES_NO_CANCEL_OPTION);
			return res3;
			case CLIPBOARD_EMPTY:
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Paste neuspesan!\nClipboard je prazan.", "Greska", JOptionPane.ERROR_MESSAGE);
				break;
			case WRONG_TYPE_IN_CLIPBOARD:
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Ne moze se izvrsiti paste!\nPogresan tip podatka pokusavate da nalepite!", "Greska", JOptionPane.ERROR_MESSAGE);
				break;
			case WRONG_TYPE_TO_COPY:
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Ne mozete kopirati tu komponentu!\nMozete kopirati samo parametar!", "Greska", JOptionPane.ERROR_MESSAGE);
				break;
			case USERS_NOT_FOUND:
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Datoteka sa korisnicima nije pronadjena.\nNapravljena nova", "Greska", JOptionPane.ERROR_MESSAGE);
				break;
			case WRONG_CREDIDENTALS:
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Pogresni kredidentali", "Greska", JOptionPane.ERROR_MESSAGE);
				break;
			case COMPLETE_REGISTRATION:
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Uspesno registrovan korisnik!", "Uspeh!", JOptionPane.INFORMATION_MESSAGE);
				break;
			case INCOMPLETE_REGISTRATION:
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Neuspesno registrovanje!", "Greska", JOptionPane.ERROR_MESSAGE);
				break;
			case USER_ALREADY_EXISTS:
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Korisnik vec postoji!", "Greska", JOptionPane.ERROR_MESSAGE);
				break;
		}

		return 0;
	}
	
}
