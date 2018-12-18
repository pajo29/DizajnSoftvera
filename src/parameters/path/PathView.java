package parameters.path;

import main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PathView extends JPanel
{
    private JLabel label;

    private JButton browseButton;
    private JTextField browsePath;


    public PathView(String label)
    {
        this.label = new JLabel(label);
        browseButton = new JButton(MainFrame.getInstance().getActionManager().getBrowseAction());
        browseButton.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent actionEvent)
            {
                MainFrame.getInstance().getActionManager().getBrowseAction().browseForPath();
            }
        });
        browsePath = new JTextField();
        browsePath.setPreferredSize(new Dimension(250, 50));
        browsePath.setMinimumSize(new Dimension(250, 50));
        browsePath.setMaximumSize(new Dimension(250, 50));

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        panel.add(browsePath);
        panel.add(browseButton);

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
}
