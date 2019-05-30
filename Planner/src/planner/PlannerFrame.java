package planner;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class PlannerFrame extends javax.swing.JFrame {
    public List<String> oldEvents;
    public List<String> newEvents;
    public List<JPanel> eventPanels = new ArrayList<>();
    public String user = LoginSystem.user;
    
    public PlannerFrame() {
        initComponents();
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E. MMM dd, yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        dateLabel = new JLabel(formattedDate);
        dateLabel.setBounds(10, 10, 130, 20);
        dashPane.setLayout(null);
        dashPane.add(dateLabel);
        
        newColorChooser.setPreviewPanel(new JPanel());
        AbstractColorChooserPanel[] oldPanels = newColorChooser.getChooserPanels();
        newColorChooser.removeChooserPanel(oldPanels[1]);
        newColorChooser.removeChooserPanel(oldPanels[2]);
        newColorChooser.removeChooserPanel(oldPanels[4]);
        newEventFrame.pack();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        newEventFrame = new javax.swing.JFrame();
        newTitleLabel = new javax.swing.JLabel();
        newTitleField = new javax.swing.JTextField();
        newDescLabel = new javax.swing.JLabel();
        newDescField = new javax.swing.JTextField();
        newDDLabel = new javax.swing.JLabel();
        newDDField = new javax.swing.JTextField();
        newColorChooser = new javax.swing.JColorChooser();
        newColorLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        tabbedPane = new javax.swing.JTabbedPane();
        dashPane = new javax.swing.JPanel();
        addEventButton = new javax.swing.JButton();
        jScrollBar1 = new javax.swing.JScrollBar();
        calendarPane = new javax.swing.JPanel();
        notesPane = new javax.swing.JPanel();

        newEventFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        newEventFrame.setMinimumSize(new java.awt.Dimension(660, 550));

        newTitleLabel.setText("Title:");

        newDescLabel.setText("Description:");

        newDDLabel.setText("Due Date:");

        newColorLabel.setText("Event Color:");

        addButton.setText("Create Event");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout newEventFrameLayout = new javax.swing.GroupLayout(newEventFrame.getContentPane());
        newEventFrame.getContentPane().setLayout(newEventFrameLayout);
        newEventFrameLayout.setHorizontalGroup(
            newEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newEventFrameLayout.createSequentialGroup()
                .addGroup(newEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newEventFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(newEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newEventFrameLayout.createSequentialGroup()
                                .addComponent(newTitleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(newTitleField))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newEventFrameLayout.createSequentialGroup()
                                .addComponent(newDescLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(newDescField))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newEventFrameLayout.createSequentialGroup()
                                .addComponent(newColorLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newEventFrameLayout.createSequentialGroup()
                                .addComponent(newDDLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(newDDField))))
                    .addGroup(newEventFrameLayout.createSequentialGroup()
                        .addGroup(newEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(newEventFrameLayout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(newEventFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(newColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );
        newEventFrameLayout.setVerticalGroup(
            newEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newEventFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newTitleLabel)
                    .addComponent(newTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(newEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newDescLabel)
                    .addComponent(newDescField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(newEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newDDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newDDLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newColorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(newEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(36, 36, 36))
        );

        newEventFrameLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addButton, cancelButton});

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Worklet Planner");

        tabbedPane.setPreferredSize(new java.awt.Dimension(800, 600));

        addEventButton.setText("ADD NEW EVENT");
        addEventButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEventButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dashPaneLayout = new javax.swing.GroupLayout(dashPane);
        dashPane.setLayout(dashPaneLayout);
        dashPaneLayout.setHorizontalGroup(
            dashPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashPaneLayout.createSequentialGroup()
                .addContainerGap(652, Short.MAX_VALUE)
                .addComponent(addEventButton)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashPaneLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        dashPaneLayout.setVerticalGroup(
            dashPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addEventButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabbedPane.addTab("Dashboard", dashPane);

        javax.swing.GroupLayout calendarPaneLayout = new javax.swing.GroupLayout(calendarPane);
        calendarPane.setLayout(calendarPaneLayout);
        calendarPaneLayout.setHorizontalGroup(
            calendarPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        calendarPaneLayout.setVerticalGroup(
            calendarPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Calendar", calendarPane);

        javax.swing.GroupLayout notesPaneLayout = new javax.swing.GroupLayout(notesPane);
        notesPane.setLayout(notesPaneLayout);
        notesPaneLayout.setHorizontalGroup(
            notesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        notesPaneLayout.setVerticalGroup(
            notesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Notes", notesPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        newEventFrame.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        System.out.println(newColorChooser.getColor());
    }//GEN-LAST:event_addButtonActionPerformed

    private void addEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEventButtonActionPerformed
        newEventFrame.setVisible(true);
    }//GEN-LAST:event_addEventButtonActionPerformed
  
    private void readFile() {
        System.out.println(user);
        Scanner in = null;
        try {
            File file = new File(user+".txt");
            Path path = Paths.get(user+".txt");
            oldEvents = Files.readAllLines(path, StandardCharsets.UTF_8);
            newEvents = new ArrayList<String>(oldEvents);
            in = new Scanner(file);
        } catch (IOException ex) {
            Logger.getLogger(LoginSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void displayEvents() {
        int y = 40;
        for (String line : newEvents) {
            String[] words = line.split(";");
            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            panel.setBackground(new Color(192,192,192));
            
            c.weighty = 0.1;
            c.weightx = 0.1;
            c.anchor = GridBagConstraints.LINE_START;
            c.gridx = 0;
            c.gridy = 0;
            panel.add(new JLabel(" "+words[0]), c);
            c.gridx = 0;
            c.gridy = 1;
            panel.add(new JLabel(" "+words[1]), c);
            c.gridx = 0;
            c.gridy = 2;
            panel.add(new JLabel(" "+words[2]), c);
            c.gridx = 2;
            c.gridy = 1;
            c.anchor = GridBagConstraints.LINE_END;
            JButton editB = new JButton("Edit");
            //editB.setSize(100, 30);
            panel.add(editB, c);
            
            dashPane.setLayout(null);
            panel.setBounds(0, y, 600, 60);
            dashPane.add(panel);
            eventPanels.add(panel);
            y += panel.getY()+30;
        }
    }
    
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
            java.util.logging.Logger.getLogger(PlannerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlannerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlannerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlannerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        PlannerFrame frame = new PlannerFrame();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame.readFile();
                frame.displayEvents();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton addEventButton;
    private javax.swing.JPanel calendarPane;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel dashPane;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JColorChooser newColorChooser;
    private javax.swing.JLabel newColorLabel;
    private javax.swing.JTextField newDDField;
    private javax.swing.JLabel newDDLabel;
    private javax.swing.JTextField newDescField;
    private javax.swing.JLabel newDescLabel;
    private javax.swing.JFrame newEventFrame;
    private javax.swing.JTextField newTitleField;
    private javax.swing.JLabel newTitleLabel;
    private javax.swing.JPanel notesPane;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
    private JLabel dateLabel;
}
