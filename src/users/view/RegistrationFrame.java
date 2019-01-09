package users.view;

import actions.ActionManager;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegistrationFrame extends JDialog {

    private static RegistrationFrame instance = null;

    private JTextField tfName;
    private JTextField tfUsername;
    private JPasswordField tfPassword;
    private JComboBox<String> cmbRole;

    private RegistrationFrame() {
        setModalityType(ModalityType.APPLICATION_MODAL);
        setSize(400, 500);
        setTitle("Registracija");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        setUpViewComponents();

    }

    private void setUpViewComponents() {

        tfName = new JTextField();
        tfUsername = new JTextField();
        tfPassword = new JPasswordField();
        cmbRole = new JComboBox<>();
        cmbRole.addItem("Admin");
        cmbRole.addItem("Operativni korisnik");
        tfName.setPreferredSize(new Dimension(150, 22));
        tfUsername.setPreferredSize(new Dimension(150, 22));
        tfPassword.setPreferredSize(new Dimension(150, 22));
        cmbRole.setPreferredSize(new Dimension(120, 22));
        cmbRole.setSelectedIndex(0);

        JPanel mainPanel = new JPanel();

        JPanel labelAndFieldPanel1 = new JPanel();
        labelAndFieldPanel1.setLayout(new GridLayout(0, 2));

        JPanel labelAndFieldPanel2 = new JPanel();
        labelAndFieldPanel2.setLayout(new GridLayout(0, 2));

        JPanel labelAndFieldPanel3 = new JPanel();
        labelAndFieldPanel3.setLayout(new GridLayout(0, 2));

        JPanel groupPanel = new JPanel();
        groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.Y_AXIS));


        JPanel actionsPanel = new JPanel();
        actionsPanel.add(new JButton(ActionManager.getInstace().getRegistrationAction()));
        actionsPanel.add(new JLabel("  "));
        JButton btnBack = new JButton("Nazad");
        actionsPanel.add(btnBack);
        btnBack.addActionListener(e -> {
            this.dispose();
        });

        labelAndFieldPanel1.add(new JLabel("Ime i prezime: "));
        labelAndFieldPanel1.add(tfName);
        labelAndFieldPanel1.add(new JLabel(" "));
        labelAndFieldPanel1.add(new JLabel(" "));

        labelAndFieldPanel3.add(new JLabel("Korisničko ime: "));
        labelAndFieldPanel3.add(tfUsername);
        labelAndFieldPanel3.add(new JLabel(" "));
        labelAndFieldPanel3.add(new JLabel(" "));
        labelAndFieldPanel3.add(new JLabel("Lozinka: "));
        labelAndFieldPanel3.add(tfPassword);

        labelAndFieldPanel3.add(new JLabel(" "));
        labelAndFieldPanel3.add(new JLabel(" "));
        labelAndFieldPanel3.add(new JLabel("Uloga: "));

        labelAndFieldPanel3.add(cmbRole);
        labelAndFieldPanel3.add(new JLabel(" "));
        labelAndFieldPanel3.add(new JLabel(" "));

        groupPanel.add(new JLabel(" "));
        groupPanel.add(new JLabel(" "));
        groupPanel.add(new JLabel(" "));
        groupPanel.add(labelAndFieldPanel1);
        groupPanel.add(new JLabel(" "));
        groupPanel.add(labelAndFieldPanel2);
        groupPanel.add(labelAndFieldPanel3);
        groupPanel.add(new JLabel(" "));
        groupPanel.add(actionsPanel);

        mainPanel.add(groupPanel);
        this.add(mainPanel, BorderLayout.CENTER);

    }

    public static RegistrationFrame getInstance() {
        if(instance == null) instance = new RegistrationFrame();
        return instance;
    }

    public JTextField getTfName() {
        return tfName;
    }

    public JTextField getTfUsername() {
        return tfUsername;
    }

    public JPasswordField getTfPassword() {
        return tfPassword;
    }

    public JComboBox<String> getCmbRole() {
        return cmbRole;
    }

}