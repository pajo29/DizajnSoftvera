package gui.statusBar;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class StatusBarView extends JPanel
{
	
	private JTextField txDate;
	private JTextField txUser;
	private JTextField txAction;
	private JTextField txStatus;
	
	public StatusBarView()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		txDate = new JTextField("Datum i vreme: "+sdf.format(new Date()));
		txDate.setEditable(false);
		
		txUser = new JTextField("Korisnik: <   >");
		txUser.setEditable(false);
		
		txAction = new JTextField("Akcija: <   >");
		txAction.setEditable(false);
		
		txStatus = new JTextField("Status <Ready>");
		txStatus.setEditable(false);
		
		add(txDate);
		add(txUser);
		add(txAction);
		add(txStatus);
	}

}
