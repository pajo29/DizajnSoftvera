package parameters.startAfterInstall;

import tree.treeModel.Node;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class StartAfterInstallView extends JPanel implements Observer
{
    private JLabel name;
    private JLabel label;
    private JCheckBox checkBox;

    private Node node;

    public StartAfterInstallView(String label, Node node, boolean simulation, String lookAndFeel)
    {
        this.node = node;
        node.addObserver(this);
        name = new JLabel(node.getName());
        this.label = new JLabel(label);
        checkBox = new JCheckBox("Pokretanje nakon instalacije");

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        if(lookAndFeel.equals("Dark"))
        {
            this.setBackground(Color.BLACK);
            checkBox.setBackground(Color.BLACK);
        }

        if(!simulation)
            add(name);
        add(this.label);
        add(checkBox);
    }

    public JCheckBox getCheckBox()
    {
        return checkBox;
    }

    @Override
    public void update(Observable observable, Object o)
    {
        this.node = (Node)o;
        this.name.setText(node.getName());
    }
}
