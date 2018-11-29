package gui.exceptionHandler;

import javax.swing.JOptionPane;

import main.MainFrame;

public class ExceptionHandler {
	
	public static void handleEvent(ExceptionType et)
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
		}
	}
	
}
