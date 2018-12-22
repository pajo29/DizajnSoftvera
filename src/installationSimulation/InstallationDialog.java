package installationSimulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstallationDialog extends JDialog
{

    private JButton btnCancel;
    private JButton btnNext;
    private JButton btnBack;

    private JPanel parametarPanel;
    private JPanel buttonPanel;

    private Simulation sim;

    public InstallationDialog(JPanel panel, String lookAndFeel, String logoUrl, Simulation sim)
    {
        this.sim = sim;
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(e ->
        {
            this.dispose();
        });
        if(sim.window == sim.getProductParametars().size()-1)
            btnNext = new JButton("Finish");
        else
            btnNext = new JButton("Next");
        btnNext.addActionListener(e ->
        {
            btnBack.setEnabled(true);
            sim.window++;
            sim.startWindow();
            this.dispose();
        });
        btnBack = new JButton("Back");
        btnBack.addActionListener(e ->
        {
            if(sim.window == 0)
                btnBack.setEnabled(false);
            sim.window--;
            sim.startWindow();
            this.dispose();
        });

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

        if(lookAndFeel.equals("Dark"))
        {
            this.setBackground(Color.BLACK);
            buttonPanel.setBackground(Color.BLACK);
            btnBack.setBackground(Color.YELLOW);
            btnNext.setBackground(Color.YELLOW);
            btnCancel.setBackground(Color.YELLOW);
            downPanel.setBackground(Color.BLACK);
        }

        if(sim.window == 0)
            btnBack.setEnabled(false);
        downPanel.add(buttonPanel, BorderLayout.CENTER);
        this.add(panel, BorderLayout.CENTER);
        this.add(downPanel, BorderLayout.SOUTH);
        setIcon(logoUrl);
        setModalityType(ModalityType.APPLICATION_MODAL);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setIcon(String url)
    {
        Image img = new ImageIcon(url).getImage();
        this.setIconImage(img);
    }
}