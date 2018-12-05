package gui.parameters.parametar.view;

import javax.swing.*;
import java.awt.*;

public class ParametarView extends JPanel
{

    private JLabel label;


    public ParametarView(String label, String GUI, String content)
    {
        this.label = new JLabel(label);
        add(this.label);
        switch (GUI)
        {
            case "Text field":
                JTextField txF = new JTextField();
                txF.setMinimumSize(new Dimension(300, 35));
                txF.setPreferredSize(new Dimension(300, 35));
                txF.setMaximumSize(new Dimension(300, 35));
                add(txF);
                break;
            case "Text area":
                JTextArea tx = new JTextArea();
                tx.setMinimumSize(new Dimension(500, 300));
                tx.setPreferredSize(new Dimension(500, 300));
                tx.setMaximumSize(new Dimension(500, 300));
                add(tx);
                break;
            case "Combo box":
                String[] string = content.split(";");
                JComboBox<String> comboBox = new JComboBox<>(string);
                add(comboBox);
                break;
            case "Check box":
                add(new Checkbox(content));
                break;
        }
    }
}
