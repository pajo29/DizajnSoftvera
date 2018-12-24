package parameters.author;

import tree.treeModel.Node;
import tree.treeModel.Parametar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

public class AuthorView extends JPanel implements Observer
{
    private JLabel name;
    private JLabel label;
    private JTextArea aboutAuthor;

    private Node node;

    public AuthorView(String label, Node node, boolean simulation, String lookAndFeel)
    {
        this.node = node;
        node.addObserver(this);
        name = new JLabel(node.getName());
        this.label = new JLabel(label);
        aboutAuthor = new JTextArea(((Parametar)node).getParametar().getContent());
        aboutAuthor.addKeyListener(new KeyListener()
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
                ((Parametar)node).getParametar().setContent(aboutAuthor.getText());
            }
        });
        aboutAuthor.setMinimumSize(new Dimension(500, 300));
        aboutAuthor.setPreferredSize(new Dimension(500, 300));
        aboutAuthor.setMaximumSize(new Dimension(500, 300));

        if(lookAndFeel.equals("Dark"))
        {
            this.setBackground(Color.black);
            aboutAuthor.setBackground(Color.GRAY);
        }


        if(simulation)
        {
            aboutAuthor.setEnabled(false);
            aboutAuthor.setDisabledTextColor(Color.BLACK);
        }
        else
            add(name);



        add(this.label);
        add(aboutAuthor);
    }

    @Override
    public void update(Observable observable, Object o)
    {
        this.node = (Node)o;
        this.name.setText(node.getName());
    }
}
