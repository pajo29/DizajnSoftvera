package parameters.author;

import javax.swing.*;
import java.awt.*;

public class AuthorView extends JPanel
{
    private JLabel label;
    private JTextArea aboutAuthor;

    public AuthorView(String label)
    {
        this.label = new JLabel(label);
        aboutAuthor = new JTextArea();
        aboutAuthor.setMinimumSize(new Dimension(500, 300));
        aboutAuthor.setPreferredSize(new Dimension(500, 300));
        aboutAuthor.setMaximumSize(new Dimension(500, 300));

        add(this.label);
        add(aboutAuthor);
    }

}
