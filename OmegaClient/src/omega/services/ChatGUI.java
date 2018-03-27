/*
 * GLP-3.0 License.
 */
package omega.services;

import java.awt.CardLayout;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import omega.contracts.GUI;
import omega.contracts.ServerInterface;
import omega.domain.Client;
import omega.domain.Language;
import omega.domain.Message;

/**
 *
 * @author Breno Viana
 * @author Murilo Bento
 */
public class ChatGUI extends javax.swing.JFrame implements GUI {

    // 
    private final static String MAIN_SCREEN = "MAIN_SCREEN";
    private final static String CHAT_SCREEN = "CHAT_SCREEN";
    private final static String LOGIN_SCREEN = "LOGIN_SCREEN";
    private final static String SIGNUP_SCREEN = "SIGNUP_SCREEN";

    // Card layout
    private final CardLayout card;
    private final CardLayout chatCard;

    //
    private Client client;
    private ServerInterface server;
    private String conversation;

    /**
     * Creates new form ChatGUI
     */
    public ChatGUI() {
        initComponents();
        // Center window
        setLocationRelativeTo(this);
        // Chat layout
        this.chatCard = new CardLayout();
        this.jBackground.setLayout(this.chatCard);
        this.jBackground.add(this.jMainPanel, MAIN_SCREEN);
        this.jBackground.add(this.jUserPanel, CHAT_SCREEN);
        //
        this.card = new CardLayout();
        this.jConfigPanel.setLayout(card);
        // this.jConfigPanel.add(this.jLoginChatPanel, LOGIN_SCREEN);
        this.jConfigPanel.add(this.jRegisterPanel, SIGNUP_SCREEN);
        // Add items
        for (Language l : Language.values()) {
            if (l != Language.UNKNOW) {
                jLanguage.addItem(l.getName());
            }
        }
        //
        this.jChat.setContentType("text/html");
        this.setTitle("Omega Chat");
        this.conversation = "";
    }

    public void run() {
        try {
            for (UIManager.LookAndFeelInfo info
                    : UIManager.getInstalledLookAndFeels()) {
                if ("GTK+".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(ChatGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ChatGUI().setVisible(true);
        });
    }

    private void doConnect(String host, int port) {
        try {
            //System.setProperty("java.rmi.server.hostname", host);
            
            Registry registry = LocateRegistry.getRegistry(host, port);
            
            String address = "rmi://" + host + ":" + port + "/server";

            /*this.server = (ServerInterface) Naming.lookup("rmi://"
                    + host + ":" + port + "/server");*/
            
            this.server = (ServerInterface) registry.lookup(address);

            Language sl = Language.UNKNOW;
            for (Language l : Language.values()) {
                if (l.getName().equals(this.jLanguage.getSelectedItem())) {
                    sl = l;
                    break;
                }
            }

            this.client = new Client(this.jUsername.getText(),
                    this.jUsername.getText(), sl, this);

            System.out.println("Connected: " + server.login(client));
        } catch (RemoteException | NotBoundException e) {
            System.err.println("Client exception: " + e.toString());
        }
    }

    private void sendText(String text) {
        try {
            Message m = new Message(this.client, text);
            this.server.sendMessageToServer(m);
        } catch (RemoteException ex) {
            Logger.getLogger(ClientTestGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void showMessage(Message message) {
        try {
            this.conversation = this.conversation.concat("<b>"
                    + message.getSender().getCredentials().getUsername() + ":</b> "
                    + message.getContent() + "<br>");
            System.out.println(this.conversation);
            this.jChat.setText("<html>" + this.conversation + "</html>");
        } catch (RemoteException ex) {
            Logger.getLogger(ChatGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void showMessage(String message) {
        this.jChat.setText(this.jChat.getText() + "<html><b>"
                + message + "<br></b></html>");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRegisterPanel = new javax.swing.JPanel();
        jRegisterButton = new javax.swing.JButton();
        jUsername = new javax.swing.JTextField();
        jUsernameLabelLogin1 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jPasswordLabelLogin1 = new javax.swing.JLabel();
        jBackButton = new javax.swing.JButton();
        jLanguage = new javax.swing.JComboBox<>();
        jPasswordLabelLogin2 = new javax.swing.JLabel();
        jNickname = new javax.swing.JTextField();
        jNicknameLabelLogin = new javax.swing.JLabel();
        jAddress = new javax.swing.JTextField();
        jServerLabel = new javax.swing.JLabel();
        jLoginChatPanel = new javax.swing.JPanel();
        jLoginButton = new javax.swing.JButton();
        jCRNameLogin = new javax.swing.JTextField();
        jUsernameLabelLogin = new javax.swing.JLabel();
        jPasswordFieldLogin = new javax.swing.JPasswordField();
        jPasswordLabelLogin = new javax.swing.JLabel();
        jSignUpButton = new javax.swing.JButton();
        jMainPanel = new javax.swing.JPanel();
        jLogo = new javax.swing.JLabel();
        jConfigPanel = new javax.swing.JPanel();
        jUserPanel = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jMessageTextField = new javax.swing.JTextField();
        jSendButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jChat = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jLogOff = new javax.swing.JButton();
        jBackground = new javax.swing.JPanel();

        jRegisterPanel.setBackground(new java.awt.Color(255, 255, 255));
        jRegisterPanel.setPreferredSize(new java.awt.Dimension(500, 275));

        jRegisterButton.setText("Confirm");
        jRegisterButton.setRequestFocusEnabled(false);
        jRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegisterButtonActionPerformed(evt);
            }
        });

        jUsername.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUsernameActionPerformed(evt);
            }
        });

        jUsernameLabelLogin1.setText("Username:");

        jPassword.setEnabled(false);
        jPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordActionPerformed(evt);
            }
        });

        jPasswordLabelLogin1.setText("Password:");
        jPasswordLabelLogin1.setEnabled(false);

        jBackButton.setText("Quit");
        jBackButton.setRequestFocusEnabled(false);
        jBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackButtonActionPerformed(evt);
            }
        });

        jLanguage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Language" }));

        jPasswordLabelLogin2.setText("Language:");

        jNickname.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jNickname.setEnabled(false);
        jNickname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNicknameActionPerformed(evt);
            }
        });

        jNicknameLabelLogin.setText("Nickname:");
        jNicknameLabelLogin.setEnabled(false);

        jAddress.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jAddressActionPerformed(evt);
            }
        });

        jServerLabel.setText("Server Address:");

        javax.swing.GroupLayout jRegisterPanelLayout = new javax.swing.GroupLayout(jRegisterPanel);
        jRegisterPanel.setLayout(jRegisterPanelLayout);
        jRegisterPanelLayout.setHorizontalGroup(
            jRegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jRegisterPanelLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jRegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jRegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jUsernameLabelLogin1)
                        .addGroup(jRegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jRegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jRegisterPanelLayout.createSequentialGroup()
                                    .addGap(85, 85, 85)
                                    .addComponent(jNickname, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jNicknameLabelLogin))
                            .addGroup(jRegisterPanelLayout.createSequentialGroup()
                                .addGroup(jRegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPasswordLabelLogin2)
                                    .addComponent(jPasswordLabelLogin1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jRegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jRegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jRegisterPanelLayout.createSequentialGroup()
                        .addComponent(jServerLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jRegisterPanelLayout.setVerticalGroup(
            jRegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jRegisterPanelLayout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(jRegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jServerLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jRegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNickname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNicknameLabelLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jRegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUsernameLabelLogin1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jRegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordLabelLogin1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jRegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordLabelLogin2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRegisterButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBackButton)
                .addContainerGap())
        );

        jLoginChatPanel.setBackground(new java.awt.Color(255, 255, 255));
        jLoginChatPanel.setPreferredSize(new java.awt.Dimension(500, 275));

        jLoginButton.setText("Log In");
        jLoginButton.setFocusPainted(false);
        jLoginButton.setRequestFocusEnabled(false);
        jLoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLoginButtonActionPerformed(evt);
            }
        });

        jCRNameLogin.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jCRNameLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCRNameLoginActionPerformed(evt);
            }
        });

        jUsernameLabelLogin.setText("Username:");

        jPasswordFieldLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldLoginActionPerformed(evt);
            }
        });

        jPasswordLabelLogin.setText("Password:");

        jSignUpButton.setText("Sign Up");
        jSignUpButton.setFocusPainted(false);
        jSignUpButton.setRequestFocusEnabled(false);
        jSignUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSignUpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jLoginChatPanelLayout = new javax.swing.GroupLayout(jLoginChatPanel);
        jLoginChatPanel.setLayout(jLoginChatPanelLayout);
        jLoginChatPanelLayout.setHorizontalGroup(
            jLoginChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLoginChatPanelLayout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addGroup(jLoginChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordLabelLogin)
                    .addComponent(jUsernameLabelLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLoginChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSignUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jLoginChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPasswordFieldLogin)
                        .addComponent(jCRNameLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(107, 107, 107))
        );
        jLoginChatPanelLayout.setVerticalGroup(
            jLoginChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLoginChatPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jLoginChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCRNameLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUsernameLabelLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jLoginChatPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordLabelLogin))
                .addGap(18, 18, 18)
                .addComponent(jLoginButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSignUpButton)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jMainPanel.setBackground(new java.awt.Color(255, 255, 255));
        jMainPanel.setPreferredSize(new java.awt.Dimension(500, 500));

        jLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/omega/assets/omega.png"))); // NOI18N

        jConfigPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jConfigPanelLayout = new javax.swing.GroupLayout(jConfigPanel);
        jConfigPanel.setLayout(jConfigPanelLayout);
        jConfigPanelLayout.setHorizontalGroup(
            jConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jConfigPanelLayout.setVerticalGroup(
            jConfigPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jMainPanelLayout = new javax.swing.GroupLayout(jMainPanel);
        jMainPanel.setLayout(jMainPanelLayout);
        jMainPanelLayout.setHorizontalGroup(
            jMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jConfigPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jMainPanelLayout.setVerticalGroup(
            jMainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jMainPanelLayout.createSequentialGroup()
                .addComponent(jLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jConfigPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jUserPanel.setBackground(new java.awt.Color(255, 255, 255));
        jUserPanel.setPreferredSize(new java.awt.Dimension(500, 500));

        jMessageTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMessageTextFieldActionPerformed(evt);
            }
        });

        jSendButton.setText("Send");
        jSendButton.setRequestFocusEnabled(false);
        jSendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSendButtonActionPerformed(evt);
            }
        });

        jChat.setEditable(false);
        jChat.setFocusable(false);
        jChat.setRequestFocusEnabled(false);
        jScrollPane3.setViewportView(jChat);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jMessageTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jSendButton))
            .addComponent(jScrollPane3)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jMessageTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSendButton)))
        );

        jTabbedPane1.addTab("Chat", jPanel3);

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Friend List", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLogOff.setText("Log Off");
        jLogOff.setRequestFocusEnabled(false);
        jLogOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogOffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLogOff))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLogOff, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jUserPanelLayout = new javax.swing.GroupLayout(jUserPanel);
        jUserPanel.setLayout(jUserPanelLayout);
        jUserPanelLayout.setHorizontalGroup(
            jUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jUserPanelLayout.setVerticalGroup(
            jUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jUserPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jBackground.setBackground(new java.awt.Color(255, 255, 255));
        jBackground.setPreferredSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout jBackgroundLayout = new javax.swing.GroupLayout(jBackground);
        jBackground.setLayout(jBackgroundLayout);
        jBackgroundLayout.setHorizontalGroup(
            jBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        jBackgroundLayout.setVerticalGroup(
            jBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLoginButtonActionPerformed
        // TODO add your handling code here:
        this.chatCard.show(jBackground, CHAT_SCREEN);
    }//GEN-LAST:event_jLoginButtonActionPerformed

    private void jCRNameLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCRNameLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCRNameLoginActionPerformed

    private void jPasswordFieldLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldLoginActionPerformed

    private void jSignUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSignUpButtonActionPerformed
        // TODO add your handling code here:
        this.card.show(jConfigPanel, SIGNUP_SCREEN);
        try {
            this.setTitle("Omega Chat - " + this.client.getCredentials().getUsername());
        } catch (RemoteException ex) {
            Logger.getLogger(ChatGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jSignUpButtonActionPerformed

    private void jLogOffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogOffActionPerformed
        try {
            this.server.disconnect(client);
        } catch (RemoteException ex) {
            Logger.getLogger(ChatGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.chatCard.show(jBackground, MAIN_SCREEN);
        this.card.show(jConfigPanel, SIGNUP_SCREEN);
        this.setTitle("Omega Chat");
    }//GEN-LAST:event_jLogOffActionPerformed

    private void jRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegisterButtonActionPerformed
        // TODO add your handling code here:
        this.chatCard.show(jBackground, CHAT_SCREEN);
        // Connect
        doConnect(jAddress.getText(), 1099);
    }//GEN-LAST:event_jRegisterButtonActionPerformed

    private void jUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jUsernameActionPerformed

    private void jPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordActionPerformed

    private void jBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackButtonActionPerformed
        // TODO add your handling code here:
        // this.card.show(jConfigPanel, LOGIN_SCREEN);
        System.exit(0);
    }//GEN-LAST:event_jBackButtonActionPerformed

    private void jNicknameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNicknameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNicknameActionPerformed

    private void jSendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSendButtonActionPerformed
        sendText(jMessageTextField.getText());
        jMessageTextField.setText("");
    }//GEN-LAST:event_jSendButtonActionPerformed

    private void jMessageTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMessageTextFieldActionPerformed
        sendText(jMessageTextField.getText());
        jMessageTextField.setText("");
    }//GEN-LAST:event_jMessageTextFieldActionPerformed

    private void jAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jAddressActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField jAddress;
    private javax.swing.JButton jBackButton;
    private javax.swing.JPanel jBackground;
    private javax.swing.JTextField jCRNameLogin;
    private javax.swing.JTextPane jChat;
    private javax.swing.JPanel jConfigPanel;
    private javax.swing.JComboBox<String> jLanguage;
    private javax.swing.JList<String> jList1;
    private javax.swing.JButton jLogOff;
    private javax.swing.JButton jLoginButton;
    private javax.swing.JPanel jLoginChatPanel;
    private javax.swing.JLabel jLogo;
    private javax.swing.JPanel jMainPanel;
    private javax.swing.JTextField jMessageTextField;
    private javax.swing.JTextField jNickname;
    private javax.swing.JLabel jNicknameLabelLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JPasswordField jPasswordFieldLogin;
    private javax.swing.JLabel jPasswordLabelLogin;
    private javax.swing.JLabel jPasswordLabelLogin1;
    private javax.swing.JLabel jPasswordLabelLogin2;
    private javax.swing.JButton jRegisterButton;
    private javax.swing.JPanel jRegisterPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jSendButton;
    private javax.swing.JLabel jServerLabel;
    private javax.swing.JButton jSignUpButton;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jUserPanel;
    private javax.swing.JTextField jUsername;
    private javax.swing.JLabel jUsernameLabelLogin;
    private javax.swing.JLabel jUsernameLabelLogin1;
    // End of variables declaration//GEN-END:variables

}
