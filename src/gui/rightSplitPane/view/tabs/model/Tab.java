package gui.rightSplitPane.view.tabs.model;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import gui.rightSplitPane.controller.ClosingActionListener;

@SuppressWarnings("serial")
public class Tab extends JPanel
{
	
	private JTextArea txArea;
	private JScrollPane scrollPane;
	private JButton removeButton;
	private gui.tree.model.Component cmp;
	
	public Tab(gui.tree.model.Component cmp)
	{
		this.cmp = cmp;
		txArea = new JTextArea(cmp.getContent());
		txArea.addKeyListener(new gui.rightSplitPane.view.tabs.controller.KeyListener(cmp, txArea));
		scrollPane = new JScrollPane(txArea);
		scrollPane.setPreferredSize(new Dimension(400, 400));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		removeButton = new JButton("Zatvori tab");
		removeButton.setIcon(new ImageIcon("src/actions/images/closeTab.png"));
		removeButton.addActionListener(new ClosingActionListener(this));
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		add(removeButton);
		add(scrollPane);
		
	}

	public JTextArea getTxArea()
	{
		return txArea;
	}

	public void setTxArea(JTextArea txArea)
	{
		this.txArea = txArea;
	}

	public gui.tree.model.Component getCmp()
	{
		return cmp;
	}

	public void setCmp(gui.tree.model.Component cmp)
	{
		this.cmp = cmp;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj instanceof Tab)
		{
			Tab cmp = (Tab)obj;
			if(cmp.getCmp().equals(this.cmp))
			{
				return true;
			}
			else
				return false;
		}
		return false;
	}
}
