package actions.newAction;

import command.AddNodeCommand;
import gui.MainSplitPane;
import main.MainFrame;
import parameters.logo.LogoView;
import tree.treeModel.Parametar;
import tree.treeModel.Product;
import tree.treeModel.SoftwareCompany;

import javax.swing.*;

public class NewProductDialog extends JDialog
{

    private JButton btnBrowse;

    public NewProductDialog(SoftwareCompany component)
    {
        btnBrowse = new JButton("Proizvod");
        btnBrowse.addActionListener(e->{
            JFileChooser fileChooser = new JFileChooser();
            int res = fileChooser.showOpenDialog(MainFrame.getInstance());


            if(res == JFileChooser.APPROVE_OPTION)
            {
                Product product = new Product(fileChooser.getSelectedFile().getName());
                product.setInstalationUrl(fileChooser.getSelectedFile().getAbsolutePath());
                MainFrame.getInstance().getCommandManager().addCommand(new AddNodeCommand(component, product));
                this.dispose();
            }
            if(res == JFileChooser.CANCEL_OPTION)
            {
                this.dispose();
            }
        });


        JPanel panel = new JPanel();
        panel.add(new JLabel("Izaberite: "));
        panel.add(btnBrowse);
        add(panel);
        setSize(200, 200);
        setLocationRelativeTo(null);
        setTitle("Novi proizvod");
        setModalityType(ModalityType.APPLICATION_MODAL);
        setVisible(true);
    }
}
