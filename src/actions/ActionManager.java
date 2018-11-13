package actions;

import java.io.File;

import javax.swing.JOptionPane;

public class ActionManager
{
	private static ActionManager instance = null;
	
	private New newAction;
	private Open openAction;
	private Edit editAction;
	private Remove removeAction;
	private Save saveAction;
	private SaveAs saveAsAction;
	private Exit exitAction;
	private ExportToPDF exportToPDFAction;
	private ExportToMsExcell exportToMsExcellAction;
	private ExportToWord exportToWordAction;
	private About aboutAction;
	private Help helpAction;
	
	private File defaultFile = null;
	private File currentDir = new File(System.getProperty("user.home")+"/eclipse-workspace/RN75-2018(InstaFram)");
	private boolean changes = true;
	
	private ActionManager()
	{
		initialise();
	}
	
	private void initialise()
	{
		newAction = new New();
		openAction = new Open();
		editAction = new Edit();
		removeAction = new Remove();
		saveAction = new Save();
		saveAsAction = new SaveAs();
		exitAction = new Exit();
		exportToPDFAction = new ExportToPDF();
		exportToMsExcellAction = new ExportToMsExcell();
		exportToWordAction = new ExportToWord();
		aboutAction = new About();
		helpAction = new Help();
	}
	
	public static ActionManager getInstace()
	{
		if(instance == null)
			instance = new ActionManager();
		return instance;
	}
	
	public void noComponentSelected()
	{
			JOptionPane.showMessageDialog(null, "Niste izabrali komponentu", "Neispravan postupak", JOptionPane.INFORMATION_MESSAGE);
	}

	public File getCurrentDir()
	{
		return currentDir;
	}

	public void setCurrentDir(File currentDir)
	{
		this.currentDir = currentDir;
	}

	public Open getOpenAction()
	{
		return openAction;
	}

	public void setOpenAction(Open openAction)
	{
		this.openAction = openAction;
	}

	public Edit getEditAction()
	{
		return editAction;
	}

	public void setEditAction(Edit closeAction)
	{
		this.editAction = closeAction;
	}

	public Remove getRemoveAction()
	{
		return removeAction;
	}

	public void setRemoveAction(Remove switchAction)
	{
		this.removeAction = switchAction;
	}

	public Save getSaveAction()
	{
		return saveAction;
	}

	public void setSaveAction(Save saveAction)
	{
		this.saveAction = saveAction;
	}

	public SaveAs getSaveAsAction()
	{
		return saveAsAction;
	}

	public void setSaveAsAction(SaveAs saveAsAction)
	{
		this.saveAsAction = saveAsAction;
	}

	public Exit getExitAction()
	{
		return exitAction;
	}

	public void setExitAction(Exit exitAction)
	{
		this.exitAction = exitAction;
	}

	public ExportToPDF getExportToPDFAction()
	{
		return exportToPDFAction;
	}

	public void setExportToPDFAction(ExportToPDF exportToPDFAction)
	{
		this.exportToPDFAction = exportToPDFAction;
	}

	public ExportToMsExcell getExportToMsExcellAction()
	{
		return exportToMsExcellAction;
	}

	public void setExportToMsExcellAction(ExportToMsExcell exportToMsExcellAction)
	{
		this.exportToMsExcellAction = exportToMsExcellAction;
	}

	public ExportToWord getExportToWordAction()
	{
		return exportToWordAction;
	}

	public void setExportToWordAction(ExportToWord exportToWordAction)
	{
		this.exportToWordAction = exportToWordAction;
	}

	public New getNewAction()
	{
		return newAction;
	}

	public void setNewAction(New newAction)
	{
		this.newAction = newAction;
	}

	public File getDefaultFile()
	{
		return defaultFile;
	}
	
	public void setDefaultFile(File defaultFile)
	{
		this.defaultFile = defaultFile;
	}

	public boolean isChanges()
	{
		return changes;
	}

	public void setChanges(boolean changes)
	{
		this.changes = changes;
	}

	public About getAboutAction()
	{
		return aboutAction;
	}

	public Help getHelpAction()
	{
		return helpAction;
	}
}
