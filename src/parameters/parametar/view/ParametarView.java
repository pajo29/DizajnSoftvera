<<<<<<< HEAD
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


    public ParametarView(String label, String GUI, String content, Node node, boolean simulation, String lookAndFeel)
    {
        if(lookAndFeel.equals("Dark"))
            this.setBackground(Color.BLACK);
        this.node = node;
        node.addObserver(this);
        name = new JLabel(node.getName());
        this.label = new JLabel(label);
        if(!simulation)
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
                if(simulation)
                {
                    txF.setEnabled(false);
                    txF.setDisabledTextColor(Color.BLACK);
                }
                if(lookAndFeel.equals("Dark"))
                {
                   txF.setBackground(Color.GRAY);
                }
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
                if(simulation)
                {
                    tx.setEnabled(false);
                    tx.setDisabledTextColor(Color.BLACK);
                }
                if(lookAndFeel.equals("Dark"))
                {
                    tx.setBackground(Color.GRAY);
                }
                add(tx);
                break;
            case "Combo box":
                String[] string = content.split(";");
                JComboBox<String> comboBox = new JComboBox<>(string);
                add(comboBox);
                break;
            case "Check box":
                JCheckBox checkBox = new JCheckBox(content);
                add(checkBox);
                if(lookAndFeel.equals("Dark"))
                {
                    checkBox.setBackground(Color.BLACK);
                }
                break;
        }
    }

    public static JPanel createGUI(boolean predefined, String GUI, String content, String label, Node node, boolean simulation, String lookAndFeel)
    {
        if(predefined)
        {
            switch (GUI)
            {
                case "TERMS_OF_USE":
                    return new TermsOfUseView(label, node, simulation, lookAndFeel);
                case "DESKTOP_SHORTCUT":
                    return new DesktopShortcutView(label, node, simulation, lookAndFeel);
                case "LOGO":
                    return new LogoView(label, node);
                case "LOOK_AND_FEEL":
                    return new LookAndFeelView(label, node);
                case "NAME":
                    return new NameView(label, node, simulation, lookAndFeel);
                case "AUTHOR":
                    return new AuthorView(label, node, simulation, lookAndFeel);
                case "START_AFTER_INSTALL":
                    return new StartAfterInstallView(label, node, simulation, lookAndFeel);
                case "PATH":
                    return new PathView(label, node, simulation, lookAndFeel);
            }
        }
        else
            return new ParametarView(label, GUI, content, node, simulation, lookAndFeel);
        return null;
    }

    @Override
    public void update(Observable observable, Object o)
    {
        this.node = (Node)o;
        this.name.setText(node.getName());
    }
}
=======
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


    public ParametarView(String label, String GUI, String content, Node node, boolean simulation, String lookAndFeel)
    {
        if(lookAndFeel.equals("Dark"))
            this.setBackground(Color.BLACK);
        this.node = node;
        node.addObserver(this);
        name = new JLabel(node.getName());
        this.label = new JLabel(label);
        if(!simulation)
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
                if(simulation)
                {
                    txF.setEnabled(false);
                    txF.setDisabledTextColor(Color.BLACK);
                }
                if(lookAndFeel.equals("Dark"))
                {
                   txF.setBackground(Color.GRAY);
                }
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
                if(simulation)
                {
                    tx.setEnabled(false);
                    tx.setDisabledTextColor(Color.BLACK);
                }
                if(lookAndFeel.equals("Dark"))
                {
                    tx.setBackground(Color.GRAY);
                }
                add(tx);
                break;
            case "Combo box":
                String[] string = content.split(";");
                JComboBox<String> comboBox = new JComboBox<>(string);
                add(comboBox);
                break;
            case "Check box":
                JCheckBox checkBox = new JCheckBox(content);
                add(checkBox);
                if(lookAndFeel.equals("Dark"))
                {
                    checkBox.setBackground(Color.BLACK);
                }
                break;
        }
    }

    public static JPanel createGUI(boolean predefined, String GUI, String content, String label, Node node, boolean simulation, String lookAndFeel)
    {
        if(predefined)
        {
            switch (GUI)
            {
                case "TERMS_OF_USE":
                    return new TermsOfUseView(label, node, simulation, lookAndFeel);
                case "DESKTOP_SHORTCUT":
                    return new DesktopShortcutView(label, node, simulation, lookAndFeel);
                case "LOGO":
                    return new LogoView(label, node);
                case "LOOK_AND_FEEL":
                    return new LookAndFeelView(label, node);
                case "NAME":
                    return new NameView(label, node, simulation, lookAndFeel);
                case "AUTHOR":
                    return new AuthorView(label, node, simulation, lookAndFeel);
                case "START_AFTER_INSTALL":
                    return new StartAfterInstallView(label, node, simulation, lookAndFeel);
                case "PATH":
                    return new PathView(label, node, simulation, lookAndFeel);
            }
        }
        else
            return new ParametarView(label, GUI, content, node, simulation, lookAndFeel);
        return null;
    }

    @Override
    public void update(Observable observable, Object o)
    {
        this.node = (Node)o;
        this.name.setText(node.getName());
    }
}
>>>>>>> 4ffd20ae8b5902ea28b0c604686b86a6f030c2fa
