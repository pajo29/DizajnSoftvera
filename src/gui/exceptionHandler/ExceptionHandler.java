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
		}
	}
	
}
