package actions;

import java.io.File;

import actions.newAction.New;
import actions.parametersActions.Browse;


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
	private About aboutAction;
	private Help helpAction;
	private ExportProduct exportAction;
	private ImportProduct importAction;

	private Cut cutAction;
	private Copy copyAction;
	private Paste pasteAction;
	private Undo undoAction;
	private Redo redoAction;

	/*
	 * Parameters Actions
	 */
	private Browse browseAction;
	
	
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
		aboutAction = new About();
		helpAction = new Help();
		exportAction = new ExportProduct();
		importAction = new ImportProduct();

		cutAction = new Cut();
		copyAction = new Copy();
		pasteAction = new Paste();
		undoAction = new Undo();
		redoAction = new Redo();

		browseAction = new Browse();
	}
	
	public static ActionManager getInstace()
	{
		if(instance == null)
			instance = new ActionManager();
		return instance;
	}

	public File getCurrentDir()
	{
		return currentDir;
	}

	public void setCurrentDir(File currentDir)
	{
		this.currentDir = currentDir;
	}

	public ImportProduct getImportAction() {
		return importAction;
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

	public ExportProduct getExportAction() {
		return exportAction;
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

	public Browse getBrowseAction() {
		return browseAction;
	}

	public Cut getCutAction()
	{
		return cutAction;
	}

	public Copy getCopyAction()
	{
		return copyAction;
	}

	public Paste getPasteAction()
	{
		return pasteAction;
	}

	public Undo getUndoAction()
	{
		return undoAction;
	}

	public Redo getRedoAction()
	{
		return redoAction;
	}
}
