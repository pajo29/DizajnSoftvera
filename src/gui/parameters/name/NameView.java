package gui.parameters.name;

import javax.swing.*;
import java.awt.*;

public class NameView extends JPanel
{

    private JLabel label;
    private JTextField txName;

    public NameView(String label)
    {
        this.label = new JLabel(label);
        txName = new JTextField();
        txName.setMinimumSize(new Dimension(100, 35));
        txName.setPreferredSize(new Dimension(100, 35));
        txName.setMaximumSize(new Dimension(100, 35));

        add(this.label);
        add(txName);
    }
}
