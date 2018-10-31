package actions;

public class ActionManager
{
	private static ActionManager instance = null;
	
	private New newAction;
	private Open openAction;
	private Close closeAction;
	private Switch switchAction;
	private Save saveAction;
	private SaveAs saveAsAction;
	private Exit exitAction;
	private ExportToPDF exportToPDFAction;
	private ExportToMsExcell exportToMsExcellAction;
	private ExportToWord exportToWordAction;
	
	private ActionManager()
	{
		initialise();
	}
	
	private void initialise()
	{
		newAction = new New();
		openAction = new Open();
		closeAction = new Close();
		switchAction = new Switch();
		saveAction = new Save();
		saveAsAction = new SaveAs();
		exitAction = new Exit();
		exportToPDFAction = new ExportToPDF();
		exportToMsExcellAction = new ExportToMsExcell();
		exportToWordAction = new ExportToWord();
	}
	
	public static ActionManager getInstace()
	{
		if(instance == null)
			instance = new ActionManager();
		return instance;
	}

	public Open getOpenAction()
	{
		return openAction;
	}

	public void setOpenAction(Open openAction)
	{
		this.openAction = openAction;
	}

	public Close getCloseAction()
	{
		return closeAction;
	}

	public void setCloseAction(Close closeAction)
	{
		this.closeAction = closeAction;
	}

	public Switch getSwitchAction()
	{
		return switchAction;
	}

	public void setSwitchAction(Switch switchAction)
	{
		this.switchAction = switchAction;
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
	
	
}
