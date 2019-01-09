<<<<<<< HEAD
package parameters.name;

import tree.treeModel.Node;
import tree.treeModel.Parametar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

public class NameView extends JPanel implements Observer
{
    private JLabel name;
    private JLabel label;
    private JTextField txName;

    private Node node;

    public NameView(String label, Node node, boolean simulation, String lookAndFeel)
    {
        this.node = node;
        node.addObserver(this);
        name = new JLabel(node.getName());
        this.label = new JLabel(label);
        txName = new JTextField(((Parametar)node).getParametar().getContent());
        txName.setMinimumSize(new Dimension(100, 35));
        txName.setPreferredSize(new Dimension(100, 35));
        txName.setMaximumSize(new Dimension(100, 35));
        txName.addKeyListener(new KeyListener()
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
                ((Parametar)node).getParametar().setContent(txName.getText());
            }
        });

        if(lookAndFeel.equals("Dark"))
        {
            this.setBackground(Color.BLACK);
            txName.setBackground(Color.GRAY);
        }

        if(simulation)
        {
            txName.setEnabled(false);
            txName.setDisabledTextColor(Color.BLACK);
        }
        else
            add(name);
        add(this.label);
        add(txName);
    }

    @Override
    public void update(Observable observable, Object o)
    {
        this.node = (Node)o;
        this.name.setText(node.getName());
    }
}
=======
package parameters.name;

import tree.treeModel.Node;
import tree.treeModel.Parametar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

public class NameView extends JPanel implements Observer
{
    private JLabel name;
    private JLabel label;
    private JTextField txName;

    private Node node;

    public NameView(String label, Node node, boolean simulation, String lookAndFeel)
    {
        this.node = node;
        node.addObserver(this);
        name = new JLabel(node.getName());
        this.label = new JLabel(label);
        txName = new JTextField(((Parametar)node).getParametar().getContent());
        txName.setMinimumSize(new Dimension(100, 35));
        txName.setPreferredSize(new Dimension(100, 35));
        txName.setMaximumSize(new Dimension(100, 35));
        txName.addKeyListener(new KeyListener()
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
                ((Parametar)node).getParametar().setContent(txName.getText());
            }
        });

        if(lookAndFeel.equals("Dark"))
        {
            this.setBackground(Color.BLACK);
            txName.setBackground(Color.GRAY);
        }

        if(simulation)
        {
            txName.setEnabled(false);
            txName.setDisabledTextColor(Color.BLACK);
        }
        else
            add(name);
        add(this.label);
        add(txName);
    }

    @Override
    public void update(Observable observable, Object o)
    {
        this.node = (Node)o;
        this.name.setText(node.getName());
    }
}
>>>>>>> 4ffd20ae8b5902ea28b0c604686b86a6f030c2fa
