package actions.newAction;

import gui.parameters.parametar.model.ParametarModel;
import gui.tree.treeModel.Node;
import gui.tree.treeModel.Parametar;
import main.MainSplitPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class CustomDialog extends JDialog
{
    private JTextField txName;
    private JTextField txLabel;

    private JComboBox<String> GUI;
    private String[] GUITypes = {"Text field", "Text area", "Combo box", "Check box"};

    private JTextField txContent;

    private JButton okButton;
    private JButton cancelButton;

    private Node component;

    public CustomDialog(Node component)
    {
        JPanel mainPanel = new JPanel();

        this.component = component;

        txName = new JTextField();
        txName.setMinimumSize(new Dimension(350, 35));
        txName.setPreferredSize(new Dimension(350, 35));
        txName.setMaximumSize(new Dimension(350, 35));
        txLabel = new JTextField();
        txLabel.setMinimumSize(new Dimension(350, 35));
        txLabel.setPreferredSize(new Dimension(350, 35));
        txLabel.setMaximumSize(new Dimension(350, 35));

        GUI = new JComboBox<>(GUITypes);
        GUI.setMinimumSize(new Dimension(350, 35));
        GUI.setPreferredSize(new Dimension(350, 35));
        GUI.setMaximumSize(new Dimension(350, 35));
        GUI.setSelectedIndex(0);

        txContent = new JTextField();
        txContent.setMinimumSize(new Dimension(350, 35));
        txContent.setPreferredSize(new Dimension(350, 35));
        txContent.setMaximumSize(new Dimension(350, 35));

        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        panel.add(new JLabel("Ukucajte ime"));
        panel.add(txName);
        panel.add(new JLabel("Ukucajte labelu"));
        panel.add(txLabel);
        panel.add(new JLabel("Izaberite tip parametra"));
        panel.add(GUI);
        panel.add(new JLabel("Ukucajte sadrzaj"));
        panel.add(txContent);
        JLabel napomena = new JLabel("*ComboBox razdvjoiti sadrzaj sa \";\"");

        panel.add(napomena);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.LINE_AXIS));
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        panel.add(buttonPanel);

        panel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(panel);


        add(mainPanel);


        okButton.addActionListener(e ->
        {
            ParametarModel pm = new ParametarModel(txName.getText(), txLabel.getText(), (String)GUI.getSelectedItem(), txContent.getText());
            component.addChild(new Parametar(pm.getName(), pm));
            SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });

        cancelButton.addActionListener(e ->
        {
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            new NewChooser(component, true);
        });

        setSize(420, 400);
        setLocationRelativeTo(null);
        setTitle("Custom");
        setModalityType(ModalityType.APPLICATION_MODAL);
        setVisible(true);
    }


}
