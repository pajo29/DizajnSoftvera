package gui.messageHandler;

import javax.swing.JOptionPane;

import gui.tree.treeModel.Node;
import main.MainFrame;
import main.MainSplitPane;

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
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Ucitavanje neuspesno!", "Greska", JOptionPane.ERROR_MESSAGE);
			break;
		case WRONG_COMPONENT_SELECTED:
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Za izmenu se mogu samo parametri otvarati!", "Greska", JOptionPane.ERROR_MESSAGE);
			break;
		case PROGRAM_START:
			int rez = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li zelite da otvorite neku kompaniju?", "?", JOptionPane.YES_NO_OPTION);
			return rez;
		case NODE_REMOVAL:
			Node cmp = (Node)MainSplitPane.getInstance().getTree().getLastSelectedPathComponent();
			int res2 = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni?\nBice obrisano\n"
					+ cmp.getChildCount() + " deteta i " + cmp.getLeafCount(0, cmp.getChildCount())+" lista", "Paznja", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			return res2;
		case CLOSING:
			int res3 = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li zelite da sacuvate promene?", "Cuvanje", JOptionPane.YES_NO_CANCEL_OPTION);
			return res3;
		}
		return 0;
	}
	
}
