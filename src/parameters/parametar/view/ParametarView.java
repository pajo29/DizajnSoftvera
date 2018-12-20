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
import tree.treeModel.Parametar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

public class ParametarView extends JPanel implements Observer
{

    private JLabel name;
    private JLabel label;

    private Node node;


    public ParametarView(String label, String GUI, String content, Node node)
    {
        this.node = node;
        node.addObserver(this);
        name = new JLabel(node.getName());
        this.label = new JLabel(label);
        add(name);
        add(this.label);
        switch (GUI)
        {
            case "Text field":
                JTextField txF = new JTextField();
                txF.addKeyListener(new KeyListener()
                {
                    @Override
                    public void keyTyped(KeyEvent keyEvent)
                    {

                    }

                    @Override
                    public void keyPressed(KeyEvent keyEvent)
                    {

                    }

                    @Override
                    public void keyReleased(KeyEvent keyEvent)
                    {
                        ((Parametar)node).getParametar().setContent(txF.getText());
                    }
                });
                txF.setText(content);
                txF.setMinimumSize(new Dimension(300, 35));
                txF.setPreferredSize(new Dimension(300, 35));
                txF.setMaximumSize(new Dimension(300, 35));
                add(txF);
                break;
            case "Text area":
                JTextArea tx = new JTextArea();
                tx.addKeyListener(new KeyListener()
                {
                    @Override
                    public void keyTyped(KeyEvent keyEvent)
                    {

                    }

                    @Override
                    public void keyPressed(KeyEvent keyEvent)
                    {

                    }

                    @Override
                    public void keyReleased(KeyEvent keyEvent)
                    {
                        ((Parametar)node).getParametar().setContent(tx.getText());
                    }
                });
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
                    return new DesktopShortcutView(label, node);
                case "LOGO":
                    return new LogoView(label, node);
                case "LOOK_AND_FEEL":
                    return new LookAndFeelView(label, node);
                case "NAME":
                    return new NameView(label, node);
                case "AUTHOR":
                    return new AuthorView(label, node);
                case "START_AFTER_INSTALL":
                    return new StartAfterInstallView(label, node);
                case "PATH":
                    return new PathView(label, node);
            }
        }
        else
            return new ParametarView(label, GUI, content, node);
        return null;
    }

    @Override
    public void update(Observable observable, Object o)
    {
        this.node = (Node)o;
        this.name.setText(node.getName());
    }
}
