package users.view;


import java.awt.*;

import javax.swing.*;

public class Login extends JFrame {

    private static Login instance = null;

    private JPasswordField tfPassword;
    private JTextField tfUser;

    private Login() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        setSize(380, 250);
        setTitle("Login");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setUpViewComponents();

        setVisible(true);
    }



    private void setUpViewComponents() {
        JPanel mainPanel = new JPanel();

        JPanel labelAndFieldPanel = new JPanel();
        labelAndFieldPanel.setLayout(new BoxLayout(labelAndFieldPanel, BoxLayout.X_AXIS));

        JPanel groupPanel = new JPanel();
        groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.Y_AXIS));

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.add(new JLabel("Korisnicko ime: "));
        leftPanel.add(new JLabel(" "));
        leftPanel.add(new JLabel("Lozinka: "));

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
        tfPassword = new JPasswordField();
        tfPassword.setPreferredSize(new Dimension(150, 22));
        tfUser = new JTextField();
        tfUser.setPreferredSize(new Dimension(150, 22));
        rightPanel.add(tfUser);
        rightPanel.add(new JLabel(" "));
        rightPanel.add(tfPassword);

        JPanel actionsPanel = new JPanel();
        JButton btnRegistration = new JButton("Registracija");
        JButton btnLogin = new JButton("Uloguj se");
        this.getRootPane().setDefaultButton(btnLogin);
        actionsPanel.add(btnLogin);
        actionsPanel.add(new JLabel("  "));
        actionsPanel.add(btnRegistration);
        btnRegistration.addActionListener(e -> {
            Registration.getInstance().show();
        });

        labelAndFieldPanel.add(leftPanel);
        labelAndFieldPanel.add(new JLabel("   "));
        labelAndFieldPanel.add(rightPanel);
        groupPanel.add(new JLabel(" "));
        groupPanel.add(new JLabel(" "));
        groupPanel.add(new JLabel(" "));
        groupPanel.add(labelAndFieldPanel);
        groupPanel.add(new JLabel(" "));
        groupPanel.add(actionsPanel);
        mainPanel.add(groupPanel);

        this.add(mainPanel, BorderLayout.CENTER);
    }

    public JTextField getTfUser()
    {
        return tfUser;
    }

    public JPasswordField getTfPassword()
    {
        return tfPassword;
    }

    public static Login getInstance() {
        if(instance == null) instance = new Login();
        return instance;
    }

}