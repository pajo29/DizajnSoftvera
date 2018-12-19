package parameters.parametar.view;

import parameters.author.AuthorView;
import parameters.name.NameView;
import parameters.path.PathView;
import parameters.startAfterInstall.StartAfterInstallView;
import parameters.termsOfUse.TermsOfUseView;
import parameters.desktopShortcut.DesktopShortcutView;
import parameters.logo.LogoView;
import parameters.lookAndFeel.LookAndFeelView;
import tree.treeModel.Node;

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

    public static JPanel createGUI(boolean predefined, String GUI, String content, String label, Node node)
    {
        if(predefined)
        {
            switch (GUI)
            {
                case "TERMS_OF_USE":
                    return new TermsOfUseView(label, node);
                case "DESKTOP_SHORTCUT":
//                    return new DesktopShortcutView(label, node);
                case "LOGO":
                    return new LogoView(label, node);
                case "LOOK_AND_FEEL":
                    return new LookAndFeelView(label, node);
                case "NAME":
                    return new NameView(label, node);
                case "AUTHOR":
//                    return new AuthorView(label, node);
                case "START_AFTER_INSTALL":
                    return new StartAfterInstallView(label, node);
                case "PATH":
                    return new PathView(label, node);
            }
        }
        else
            return new ParametarView(label, GUI, content);
        return null;
    }
}
