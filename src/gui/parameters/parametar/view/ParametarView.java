package gui.parameters.parametar.view;

import gui.parameters.about.AboutView;
import gui.parameters.desktopShortcut.DesktopShortcutView;
import gui.parameters.logo.LogoView;
import gui.parameters.lookAndFeel.LookAndFeelView;
import gui.parameters.path.PathView;

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
                txF.setText(content);
                txF.setMinimumSize(new Dimension(300, 35));
                txF.setPreferredSize(new Dimension(300, 35));
                txF.setMaximumSize(new Dimension(300, 35));
                add(txF);
                break;
            case "Text area":
                JTextArea tx = new JTextArea();
                tx.setText(content);
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

    public static JPanel createGUI(boolean predefined, String GUI, String content, String label)
    {
        if(predefined)
        {
            switch (GUI)
            {
                case "ABOUT":
                    return new AboutView(label);
                case "DESKTOP_SHORTCUT":
                    return new DesktopShortcutView(label);
                case "LOGO":
                    return new LogoView(label);
                case "LOOK_AND_FEEL":
                    return new LookAndFeelView(label);
                case "PATH":
                    return new PathView(label);
            }
        }
        else
            return new ParametarView(label, GUI, content);
        return null;
    }
}
