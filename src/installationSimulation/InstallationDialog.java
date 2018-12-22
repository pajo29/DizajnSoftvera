package installationSimulation;

import parameters.desktopShortcut.DesktopShortcutView;
import parameters.path.PathView;
import parameters.startAfterInstall.StartAfterInstallView;

import javax.swing.*;
import java.awt.*;

public class InstallationDialog extends JDialog
{

    private JButton btnCancel;
    private JButton btnNext;
    private JButton btnBack;

    private JPanel buttonPanel;


    public InstallationDialog(JPanel panel, String lookAndFeel, String logoUrl, Simulation sim)
    {
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
            if(panel instanceof DesktopShortcutView)
            {
                DesktopShortcutView par = (DesktopShortcutView)panel;
                sim.desktopShortcut = par.getCheckBox().isSelected();
            }
            if(panel instanceof StartAfterInstallView)
            {
                StartAfterInstallView par = (StartAfterInstallView)panel;
                sim.startAfterUse = par.getCheckBox().isSelected();
            }
            if(panel instanceof PathView)
            {
                PathView pathView = (PathView)panel;
                sim.installPath = pathView.getBrowsePath().getText();
            }
            if(sim.window == sim.getProductParametars().size()-1)
            {
                sim.install();
                this.dispose();
                return;
            }
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