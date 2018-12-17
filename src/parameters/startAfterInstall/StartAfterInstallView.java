package parameters.startAfterInstall;

import javax.swing.*;

public class StartAfterInstallView extends JPanel
{
    private JLabel label;
    private JCheckBox checkBox;

    public StartAfterInstallView(String label)
    {
        this.label = new JLabel(label);
        checkBox = new JCheckBox("Pokretanje nakon instalacije");

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        add(this.label);
        add(checkBox);
    }
}
