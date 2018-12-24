package parameters.path;

import main.MainFrame;
import tree.treeModel.Node;
import tree.treeModel.Parametar;
import tree.treeModel.Product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

public class PathView extends JPanel implements Observer
{
    private JLabel name;
    private JLabel label;

    private JButton browseButton;
    private JTextField browsePath;

    private Node node;


    public PathView(String label, Node node, boolean simulation, String lookAndFeel)
    {
        node.addObserver(this);
        name = new JLabel(node.getName());
        this.label = new JLabel(label);
        browseButton = new JButton(MainFrame.getInstance().getActionManager().getBrowseAction());
        browseButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int res = fileChooser.showOpenDialog(MainFrame.getInstance());

                if(res == JFileChooser.APPROVE_OPTION)
                {
                    browsePath.setText(fileChooser.getSelectedFile().getAbsolutePath());
                }
                ((Parametar)node).getParametar().setContent(browsePath.getText());
            }
        });
        browsePath = new JTextField();
        browsePath.setText(((Parametar)node).getParametar().getContent());
        browsePath.setPreferredSize(new Dimension(300, 30));
        browsePath.setMinimumSize(new Dimension(300, 30));
        browsePath.setMaximumSize(new Dimension(300, 30));
        browsePath.addKeyListener(new KeyListener()
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
                ((Parametar)node).getParametar().setContent(browsePath.getText());
            }
        });

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.add(browsePath);
        panel.add(browseButton);

        if(lookAndFeel.equals("Dark"))
        {
            this.setBackground(Color.BLACK);
            browseButton.setBackground(Color.YELLOW);
        }

        if(!simulation)
            add(name);
        add(this.label);
        add(panel);
    }

    public JLabel getLabel() {
        return label;
    }

    public JTextField getBrowsePath()
    {
        return browsePath;
    }

    public JButton getBrowseButton() {
        return browseButton;
    }

    @Override
    public void update(Observable observable, Object o)
    {
        this.node = (Node)o;
        this.name.setText(node.getName());
    }

    public Node getNode()
    {
        return node;
    }
}
