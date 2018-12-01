package gui.parameters.model;

import java.io.Serializable;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ParametarConfig implements Serializable{
	
	private String name;
	private String label;
	
	protected JPanel gui;
	
	public ParametarConfig(String name, String label)
	{
		this.name = name;
		this.label = label;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public JPanel getGui()
	{
		return gui;
	}
}