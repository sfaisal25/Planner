package planner;

import java.awt.event.WindowEvent;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginSystem extends javax.swing.JFrame { 
    static boolean success = false;
    static String user;
    
    public LoginSystem() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        welcomeFrame = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        resetFrame = new javax.swing.JFrame();
        outputLabelR = new javax.swing.JLabel();
        userFieldR = new javax.swing.JTextField();
        resetButton = new javax.swing.JButton();
        passFieldR = new javax.swing.JPasswordField();
        userLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
        userField = new javax.swing.JTextField();
        outputLabel = new javax.swing.JLabel();
        passField = new javax.swing.JPasswordField();
        resetPassButton = new javax.swing.JButton();
        exitButton = new javax.swing.JButton();

        welcomeFrame.setTitle("welcomeFrame");

        jLabel1.setForeground(new java.awt.Color(34, 139, 34));
        jLabel1.setText("Login Successful");

        jLabel2.setForeground(new java.awt.Color(34, 139, 34));
        jLabel2.setText("Welcome!");

        javax.swing.GroupLayout welcomeFrameLayout = new javax.swing.GroupLayout(welcomeFrame.getContentPane());
        welcomeFrame.getContentPane().setLayout(welcomeFrameLayout);
        welcomeFrameLayout.setHorizontalGroup(
            welcomeFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, welcomeFrameLayout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(63, 63, 63))
            .addGroup(welcomeFrameLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        welcomeFrameLayout.setVerticalGroup(
            welcomeFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(welcomeFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        userFieldR.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        userFieldR.setText("Username");

        resetButton.setText("Submit");
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });

        passFieldR.setText("00000000");

        javax.swing.GroupLayout resetFrameLayout = new javax.swing.GroupLayout(resetFrame.getContentPane());
        resetFrame.getContentPane().setLayout(resetFrameLayout);
        resetFrameLayout.setHorizontalGroup(
            resetFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resetFrameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(resetFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resetFrameLayout.createSequentialGroup()
                        .addComponent(outputLabelR, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resetFrameLayout.createSequentialGroup()
                        .addGroup(resetFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(userFieldR)
                            .addGroup(resetFrameLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(resetButton))
                            .addComponent(passFieldR, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                        .addGap(48, 48, 48))))
        );
        resetFrameLayout.setVerticalGroup(
            resetFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resetFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(outputLabelR, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userFieldR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passFieldR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(resetButton))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LoginSystem");

        userLabel.setText("Username");

        passLabel.setText("Password");

        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        outputLabel.setForeground(new java.awt.Color(255, 0, 0));

        resetPassButton.setText("Forgot  Password");
        resetPassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetPassButtonActionPerformed(evt);
            }
        });

        exitButton.setBackground(new java.awt.Color(255, 0, 0));
        exitButton.setForeground(new java.awt.Color(255, 0, 0));
        exitButton.setText("X");
        exitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outputLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(userLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(passLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(loginButton)
                                .addGap(18, 18, 18)
                                .addComponent(registerButton)
                                .addGap(19, 19, 19)
                                .addComponent(resetPassButton)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(exitButton))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {passLabel, userLabel});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {loginButton, registerButton});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {passField, userField});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(exitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel)
                    .addComponent(userField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLabel)
                    .addComponent(passField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerButton)
                    .addComponent(loginButton)
                    .addComponent(resetPassButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void welcomeUser() throws IOException {
        user = userField.getText();
        PlannerFrame frame = new PlannerFrame();
        frame.main(new String[0]);
        this.setVisible(false);
        this.dispose();
        success = true;
    }
    
    private void createFile() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter file = new PrintWriter("users.txt", "UTF-8");
        file.close();
    }
    
    private int checkPass(String user, String password) {
        Pattern banned = Pattern.compile("[()_|{}\\[\\]~]");
        Pattern symbols = Pattern.compile("[!@#$%^&*=+<>?-]");
        Pattern numbers = Pattern.compile("[0-9]");
        Pattern lLetters = Pattern.compile("[a-z]");
        Pattern uLetters = Pattern.compile("[A-Z]");
        
        Matcher userBanned = banned.matcher(user);
        Matcher passBanned = banned.matcher(password);
        Matcher hasSymbols = symbols.matcher(password);
        Matcher hasNumbers = numbers.matcher(password);
        Matcher haslLetters = lLetters.matcher(password);
        Matcher hasuLetters = uLetters.matcher(password);
        
        if (userBanned.find() || passBanned.find()) {
            return 2;
        } else if (password.length() < 8) {
            return 0;
        } else if (hasSymbols.find() && hasNumbers.find() && hasuLetters.find() && haslLetters.find()) {
            return 1;
        } else {
            return 3;
        }
    }
    
    private int loginUser(String user, String password) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        Scanner in = null;
        List<String> lines;
        try {
            File file = new File("users.txt");
            in = new Scanner(file);
            Path path = Paths.get("users.txt");
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(LoginSystem.class.getName()).log(Level.SEVERE, null, ex);
            createFile();
            File file = new File("users.txt");
            in = new Scanner(file);
            lines = null;
        }
        
        int lineNumber = 0;
        while (in.hasNextLine()) {
            String[] words = (in.nextLine()).split(";");
            
            if (Integer.parseInt(words[2]) == 3 && words[0].equals(user)) {
                in.close();
                return 3;
            } else if (words[0].equals(user) && words[1].equals(password)) {
                String line = words[0]+";"+words[1]+";"+Integer.toString(0);
                lines.set(lineNumber, line);
                Files.write(Paths.get("users.txt"), lines, StandardCharsets.UTF_8);
                in.close();
                return 1;
            } else if (words[0].equals(user) && !(words[1].equals(password))) {
                String line = words[0]+";"+words[1]+";"+Integer.toString(Integer.parseInt(words[2])+1);
                lines.set(lineNumber, line);
                Files.write(Paths.get("users.txt"), lines, StandardCharsets.UTF_8);
                in.close();
                return 2;
            } 
            lineNumber++;
        }
        in.close();
        return 0;
    }
    
    private int registerUser(String user, String password) throws IOException {
        Scanner in = null;
        try {
            File file = new File("users.txt");
            in = new Scanner(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoginSystem.class.getName()).log(Level.SEVERE, null, ex);
            createFile();
            File file = new File("users.txt");
            in = new Scanner(file);
        }
        
        while (in.hasNextLine()) {
            String[] words = (in.nextLine()).split(";");
            System.out.println("Entry: "+words[0]+" User: "+user);
            if (words[0].equals("")) {break;}
            if (words[0].equals(user)) {
                in.close();
                return 0;
            }
        }
        in.close();
        
        int pCheck = checkPass(user, password);
        if (pCheck == 0) {
            return 4;
        } else if (pCheck == 2) {
            in.close();
            return 2;
        } else if (pCheck == 3) {
            in.close();
            return 3;
        }
        
        FileWriter out = null;
        out = new FileWriter("users.txt", true);
       
        out.write(user+";"+password+";"+"0"+"\n");
        out.close();
        return 1;
    }
    
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        int result;
        try {
            result = loginUser(userField.getText(), passField.getText());
            if (result == 1) {
                outputLabel.setForeground(new java.awt.Color(34, 139, 34));
                outputLabel.setText("Logging in...");
                welcomeUser();
            } else if (result == 2) {
                outputLabel.setForeground(new java.awt.Color(255, 0, 0));
                outputLabel.setText("The password is incorrect.");
            } else if (result == 3) {
                outputLabel.setForeground(new java.awt.Color(255, 0, 0));
                outputLabel.setText("Your account has been locked.");
            } else {
                outputLabel.setForeground(new java.awt.Color(255, 0, 0));
                outputLabel.setText("User not found, please register.");
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        int result;
        try {
            result = registerUser(userField.getText(), passField.getText());
            if (result == 0) {
                outputLabel.setForeground(new java.awt.Color(255, 0, 0));
                outputLabel.setText("User already exists! Please login.");
            } else if (result == 2) {
                outputLabel.setForeground(new java.awt.Color(255, 0, 0));
                outputLabel.setText("Invalid username or password.");
            } else if (result == 3) {
                outputLabel.setForeground(new java.awt.Color(255, 0, 0));
                outputLabel.setText("Pass needs symbols, #, and uppercase letters.");
            } else if (result == 4) {
                outputLabel.setForeground(new java.awt.Color(255, 0, 0));
                outputLabel.setText("Minimum password length: 8 characters");
            } else {
                PrintWriter file1 = new PrintWriter(userField.getText()+"_events"+".txt", "UTF-8");
                PrintWriter file2 = new PrintWriter(userField.getText()+"_notes"+".txt", "UTF-8");
                file1.close();
                file2.close();
                outputLabel.setForeground(new java.awt.Color(34, 139, 34));
                outputLabel.setText("Registered.");
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_registerButtonActionPerformed

    private int resetPass(String user, String npass) throws IOException {
        List<String> lines;
        Scanner in;
        try {
            File file = new File("users.txt");
            Path path = Paths.get("users.txt");
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            in = new Scanner(file);
        } catch (IOException ex) {
            Logger.getLogger(LoginSystem.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
        int lineNumber = 0;
        while (in.hasNextLine()) {
            String[] words = (in.nextLine()).split(";"); 
            if (words[0].equals(user)) {
                String line = words[0]+";"+npass+";"+words[2];
                lines.set(lineNumber, line);
                Files.write(Paths.get("users.txt"), lines, StandardCharsets.UTF_8);
                in.close();
                return 1;
            } 
            lineNumber++;
        }
        in.close();
        return 0;
    }
    
    private void exitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitButtonActionPerformed
        dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }//GEN-LAST:event_exitButtonActionPerformed

    private void resetPassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetPassButtonActionPerformed
        resetFrame.pack();
        resetFrame.setVisible(true);
    }//GEN-LAST:event_resetPassButtonActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        int result;
        try {
            result = resetPass(userFieldR.getText(), passFieldR.getText());
            if (result == 0) {
                outputLabelR.setForeground(new java.awt.Color(255, 0, 0));
                outputLabelR.setText("Username not found.");
            } else {
                outputLabelR.setForeground(new java.awt.Color(34,139,34));
                outputLabelR.setText("Password reset.");
            }
        } catch (IOException ex) {
            Logger.getLogger(LoginSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_resetButtonActionPerformed
    
    /**
     * @param args the command words arguments
     */
    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginSystem loginwindow = new LoginSystem();
                loginwindow.setLocationRelativeTo(null);
                loginwindow.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton exitButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel outputLabel;
    private javax.swing.JLabel outputLabelR;
    private javax.swing.JPasswordField passField;
    private javax.swing.JPasswordField passFieldR;
    private javax.swing.JLabel passLabel;
    private javax.swing.JButton registerButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JFrame resetFrame;
    private javax.swing.JButton resetPassButton;
    private javax.swing.JTextField userField;
    private javax.swing.JTextField userFieldR;
    private javax.swing.JLabel userLabel;
    private javax.swing.JFrame welcomeFrame;
    // End of variables declaration//GEN-END:variables
}
