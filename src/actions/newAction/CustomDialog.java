package actions.newAction;

import gui.parameters.parametar.model.ParametarModel;
import gui.tree.treeModel.Node;
import gui.tree.treeModel.Parametar;
import main.MainSplitPane;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class CustomDialog extends JDialog
{
    private JTextField txName;
    private JTextField txLabel;

    private JComboBox<String> GUI;
    private String[] GUITypes = {"Text field", "Text area", "Combo box", "Check box"};

    private JTextField txContent;

    private JButton okButton;

    private Node component;

    public CustomDialog(Node component)
    {
        this.component = component;

        txName = new JTextField();
        txLabel = new JTextField();

        GUI = new JComboBox<>(GUITypes);
        GUI.setSelectedIndex(0);

        txContent = new JTextField();

        okButton = new JButton("OK");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        panel.add(new JLabel("Ukucajte ime"));
        panel.add(txName);
        panel.add(new JLabel("Ukucajte labelu"));
        panel.add(txLabel);
        panel.add(new JLabel("Izaberite tip parametra"));
        panel.add(GUI);
        panel.add(new JLabel("Ukucajte sadrzaj\n*NAPOMENA, ako je tip Combo box, razdvjoiti sadrzaj sa \";\""));
        panel.add(txContent);
        panel.add(okButton);

        add(panel);


        okButton.addActionListener(e ->
        {
            ParametarModel pm = new ParametarModel(txName.getText(), txLabel.getText(), (String)GUI.getSelectedItem(), txContent.getText());
            component.addChild(new Parametar(pm.getName(), pm));
            SwingUtilities.updateComponentTreeUI(MainSplitPane.getInstance().getTree());
            dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });

        setSize(400, 400);
        setLocationRelativeTo(null);
        setTitle("Custom");
        setModalityType(ModalityType.APPLICATION_MODAL);
        setVisible(true);
    }


}
