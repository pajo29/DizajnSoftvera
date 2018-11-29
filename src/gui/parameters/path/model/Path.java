package gui.parameters.path.model;


import gui.parameters.model.ParametarConfig;
import gui.parameters.path.view.PathView;

@SuppressWarnings("serial")
public class Path extends ParametarConfig{
	
	private String content;
	
	public Path(String name)
	{
		super(name, "Izaberite lokaciju za instalaciju");
		super.gui = new PathView(this);
	}


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	

}
