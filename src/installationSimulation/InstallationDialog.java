package installationSimulation;

import javax.swing.*;
import java.awt.*;

public class InstallationDialog extends JDialog
{

    private JButton btnCancel;
    private JButton btnNext;
    private JButton btnBack;

    private JPanel parametarPanel;
    private JPanel buttonPanel;


    public InstallationDialog(JPanel panel)
    {
        btnCancel = new JButton("Cancel");
        btnNext = new JButton("Next");
        btnBack = new JButton("Back");


        JPanel downPanel = new JPanel();

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(btnCancel);
        buttonPanel.add(new JLabel("   "));
        buttonPanel.add(new JLabel("   "));
        buttonPanel.add(btnBack);
        buttonPanel.add(new JLabel("   "));
        buttonPanel.add(new JLabel("   "));
        buttonPanel.add(btnNext);

        parametarPanel = panel;

        downPanel.add(buttonPanel, BorderLayout.CENTER);
        this.add(panel, BorderLayout.CENTER);
        this.add(downPanel, BorderLayout.SOUTH);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}