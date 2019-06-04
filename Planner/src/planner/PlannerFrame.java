package planner;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
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
import javax.swing.border.LineBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class PlannerFrame extends javax.swing.JFrame {
    public List<String> oldEvents;
    public List<String> newEvents;
    public List<JPanel> eventPanels = new ArrayList<>();
    public String user = LoginSystem.user;
    public int tmpIndex;
    
    public PlannerFrame() {
        initComponents();
        addDefaultC();
        
        newColorChooser.setPreviewPanel(new JPanel());
        AbstractColorChooserPanel[] oldPanels = newColorChooser.getChooserPanels();
        newColorChooser.removeChooserPanel(oldPanels[1]);
        newColorChooser.removeChooserPanel(oldPanels[2]);
        newColorChooser.removeChooserPanel(oldPanels[4]);
        newEventFrame.pack();
        
        editColorChooser.setPreviewPanel(new JPanel());
        AbstractColorChooserPanel[] oldPanels2 = editColorChooser.getChooserPanels();
        editColorChooser.removeChooserPanel(oldPanels2[1]);
        editColorChooser.removeChooserPanel(oldPanels2[2]);
        editColorChooser.removeChooserPanel(oldPanels2[4]);
        editEventFrame.pack();
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
        logoutFrame = new javax.swing.JFrame();
        logoutLabel = new javax.swing.JLabel();
        logYesButton = new javax.swing.JButton();
        logCancelButton = new javax.swing.JButton();
        logNoButton = new javax.swing.JButton();
        editEventFrame = new javax.swing.JFrame();
        editTitleLabel = new javax.swing.JLabel();
        editTitleField = new javax.swing.JTextField();
        editDescLabel = new javax.swing.JLabel();
        editDescField = new javax.swing.JTextField();
        editDDLabel = new javax.swing.JLabel();
        editDDField = new javax.swing.JTextField();
        editColorChooser = new javax.swing.JColorChooser();
        editColorLabel = new javax.swing.JLabel();
        editButton = new javax.swing.JButton();
        editCancelButton = new javax.swing.JButton();
        tabbedPane = new javax.swing.JTabbedPane();
        dashPane = new javax.swing.JPanel();
        calendarPane = new javax.swing.JPanel();
        notesPane = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();

        newEventFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        newEventFrame.setMinimumSize(new java.awt.Dimension(660, 550));

        newTitleLabel.setText("Title:");

        newDescLabel.setText("Description:");

        newDDLabel.setText("Due Date (mm/dd/yyyy):");

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
                                .addGap(179, 179, 179)
                                .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
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
                    .addComponent(newDescField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(newEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(newEventFrameLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(newDDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newEventFrameLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(newDDLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newColorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(newEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton))
                .addGap(27, 27, 27))
        );

        newEventFrameLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addButton, cancelButton});

        logoutFrame.setMinimumSize(new java.awt.Dimension(235, 100));
        logoutFrame.setResizable(false);

        logoutLabel.setText("Do you want to save your changes?");

        logYesButton.setText("Yes");
        logYesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logYesButtonActionPerformed(evt);
            }
        });

        logCancelButton.setText("Cancel");
        logCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logCancelButtonActionPerformed(evt);
            }
        });

        logNoButton.setText("No");
        logNoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logNoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout logoutFrameLayout = new javax.swing.GroupLayout(logoutFrame.getContentPane());
        logoutFrame.getContentPane().setLayout(logoutFrameLayout);
        logoutFrameLayout.setHorizontalGroup(
            logoutFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logYesButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logNoButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logCancelButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, logoutFrameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        logoutFrameLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {logCancelButton, logNoButton, logYesButton});

        logoutFrameLayout.setVerticalGroup(
            logoutFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(logoutFrameLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutLabel)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(logoutFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logYesButton)
                    .addComponent(logCancelButton)
                    .addComponent(logNoButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        logoutFrameLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {logCancelButton, logNoButton, logYesButton});

        editEventFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        editEventFrame.setMinimumSize(new java.awt.Dimension(660, 550));

        editTitleLabel.setText("Title:");

        editDescLabel.setText("Description:");

        editDDLabel.setText("Due Date (mm/dd/yyyy):");

        editColorLabel.setText("Event Color:");

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        editCancelButton.setText("Cancel");
        editCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout editEventFrameLayout = new javax.swing.GroupLayout(editEventFrame.getContentPane());
        editEventFrame.getContentPane().setLayout(editEventFrameLayout);
        editEventFrameLayout.setHorizontalGroup(
            editEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(editEventFrameLayout.createSequentialGroup()
                .addGroup(editEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editEventFrameLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(editEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editEventFrameLayout.createSequentialGroup()
                                .addComponent(editTitleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editTitleField))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editEventFrameLayout.createSequentialGroup()
                                .addComponent(editDescLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editDescField))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editEventFrameLayout.createSequentialGroup()
                                .addComponent(editColorLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, editEventFrameLayout.createSequentialGroup()
                                .addComponent(editDDLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(editDDField))))
                    .addGroup(editEventFrameLayout.createSequentialGroup()
                        .addGroup(editEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(editEventFrameLayout.createSequentialGroup()
                                .addGap(179, 179, 179)
                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(editCancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(editEventFrameLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(editColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 25, Short.MAX_VALUE)))
                .addContainerGap())
        );

        editEventFrameLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {editButton, editCancelButton});

        editEventFrameLayout.setVerticalGroup(
            editEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editEventFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(editEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editTitleLabel)
                    .addComponent(editTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(editEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editDescLabel)
                    .addComponent(editDescField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(editEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(editEventFrameLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(editDDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, editEventFrameLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editDDLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editColorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(editEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editCancelButton))
                .addGap(27, 27, 27))
        );

        editEventFrameLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {editButton, editCancelButton});

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Worklet Planner");

        tabbedPane.setPreferredSize(new java.awt.Dimension(800, 600));

        javax.swing.GroupLayout dashPaneLayout = new javax.swing.GroupLayout(dashPane);
        dashPane.setLayout(dashPaneLayout);
        dashPaneLayout.setHorizontalGroup(
            dashPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        dashPaneLayout.setVerticalGroup(
            dashPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Dashboard", dashPane);

        javax.swing.GroupLayout calendarPaneLayout = new javax.swing.GroupLayout(calendarPane);
        calendarPane.setLayout(calendarPaneLayout);
        calendarPaneLayout.setHorizontalGroup(
            calendarPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 795, Short.MAX_VALUE)
        );
        calendarPaneLayout.setVerticalGroup(
            calendarPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Calendar", calendarPane);

        javax.swing.GroupLayout notesPaneLayout = new javax.swing.GroupLayout(notesPane);
        notesPane.setLayout(notesPaneLayout);
        notesPaneLayout.setHorizontalGroup(
            notesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 795, Short.MAX_VALUE)
        );
        notesPaneLayout.setVerticalGroup(
            notesPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Notes", notesPane);

        logoutButton.setText("Log Out");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(logoutButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(logoutButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addEventButtonActionPerformed(java.awt.event.ActionEvent evt) {
        newTitleField.setText("");
        newDescField.setText("");
        newDDField.setText("");
        newColorChooser.setColor(new Color(255,255,255));
        newEventFrame.setVisible(true);
    }
    
    private void addDefaultC() {
        dashPane.setLayout(null);
        addEventButton = new JButton("Add Event");
        addEventButton.addActionListener(PlannerFrame.this::addEventButtonActionPerformed);
        addEventButton.setBounds(675, 10, 100, 40);
        dashPane.add(addEventButton);
        
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E. MMM dd, yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        dateLabel = new JLabel(formattedDate);
        dateLabel.setBounds(10, 10, 130, 20);
        dashPane.setLayout(null);
        dashPane.add(dateLabel);
    }
    
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        newEventFrame.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        String line = "";
        Color color = newColorChooser.getColor();
        line = newTitleField.getText()+";"+newDescField.getText()+";"+newDDField.getText()+";"+color.getRed()+";"+color.getGreen()+";"+color.getBlue();
        System.out.println(line);
        newEvents.add(line);
        dashPane.removeAll();
        addDefaultC();
        displayEvents();
        newEventFrame.dispose();
    }//GEN-LAST:event_addButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        logoutFrame.setLocationRelativeTo(null);
        logoutFrame.setVisible(true);
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void logYesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logYesButtonActionPerformed
        logoutFrame.dispose();
        System.out.println("logging out...");
        try {
            Files.write(Paths.get(user+".txt"), newEvents, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(PlannerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
        LoginSystem.main(new String[0]);
    }//GEN-LAST:event_logYesButtonActionPerformed

    private void logCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logCancelButtonActionPerformed
        logoutFrame.dispose();
    }//GEN-LAST:event_logCancelButtonActionPerformed

    private void logNoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logNoButtonActionPerformed
        logoutFrame.dispose();
        System.out.println("logging out...");
        dispose();
        LoginSystem.main(new String[0]);
    }//GEN-LAST:event_logNoButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        Color color = editColorChooser.getColor();
        String line = editTitleField.getText()+";"+editDescField.getText()+";"+editDDField.getText()+";"+color.getRed()+";"+color.getGreen()+";"+color.getBlue();
        newEvents.set(tmpIndex, line);
        dashPane.removeAll();
        addDefaultC();
        displayEvents();
        editEventFrame.dispose();
    }//GEN-LAST:event_editButtonActionPerformed

    private void editCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCancelButtonActionPerformed
        editEventFrame.dispose();
    }//GEN-LAST:event_editCancelButtonActionPerformed
  
    private void delBButtonActionPerformed(ActionEvent evt, JButton delB) {
        System.out.println("deleting...");
        System.out.println(eventPanels.size()+" "+eventPanels);
        for (int i=0;i<eventPanels.size();i++) {
            if (eventPanels.get(i).isAncestorOf(delB)) {
                newEvents.remove(i);
                dashPane.removeAll();
                addDefaultC();
                displayEvents();
                break;
            }
        }
        System.out.println("done deleting");
    }
    
    private void editBButtonActionPerformed(java.awt.event.ActionEvent evt, javax.swing.JButton editB) {
        System.out.println("editing...");
        for (int i=0;i<eventPanels.size();i++) {
            if (eventPanels.get(i).isAncestorOf(editB)) {
                System.out.println(newEvents.get(i));
                String[] line = newEvents.get(i).split(";");
                editTitleField.setText(line[0]);
                editDescField.setText(line[1]);
                editDDField.setText(line[2]);
                editColorChooser.setColor(new Color(Integer.parseInt(line[3]),Integer.parseInt(line[4]),Integer.parseInt(line[5])));
                tmpIndex = i;
                break;
            }
        }
        editEventFrame.setVisible(true);
    }
    
    private void readFile() {
        Scanner in = null;
        try {
            File file = new File(user+".txt");
            Path path = Paths.get(user+".txt");
            oldEvents = Files.readAllLines(path, StandardCharsets.UTF_8);
            newEvents = new ArrayList<>(oldEvents);
            in = new Scanner(file);
        } catch (IOException ex) {
            Logger.getLogger(LoginSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void displayEvents() {
        dashPane.repaint();
        dashPane.revalidate();
        repaint();
        revalidate();
        eventPanels.clear();
        System.out.println(newEvents);
        int y = 40;
        for (String line : newEvents) {
            System.out.println("displaying...");
            String[] words = line.split(";");
            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints c = new GridBagConstraints();
            //LineBorder border = new LineBorder(new Color(192,192,192), 3, true);
            //panel.setBorder(border);
            panel.setBackground(new Color(192,192,192));
            
            c.weighty = 1.0;
            c.weightx = 1.0;
            c.anchor = GridBagConstraints.LINE_START;
            c.gridx = 0;
            c.gridy = 0;
            panel.add(new JLabel(" "+words[0]), c);
            c.gridx = 0;
            c.gridy = 2;
            panel.add(new JLabel(" "+words[1]), c);
            c.gridx = 0;
            c.gridy = 4;
            panel.add(new JLabel(" "+words[2]), c);
            c.gridheight = 1;
            c.gridx = 2;
            c.gridy = 0;
            c.anchor = GridBagConstraints.LINE_END;
            JButton editB = new JButton("Edit");
            editB.addActionListener((ActionEvent evt) -> {
                PlannerFrame.this.editBButtonActionPerformed(evt, editB);
            });
            panel.add(editB, c);
            c.gridy = 4;
            JButton delB = new JButton("Delete");
            delB.addActionListener((ActionEvent evt) -> {
                PlannerFrame.this.delBButtonActionPerformed(evt, delB);
            });
            panel.add(delB, c);
            
            dashPane.setLayout(null);
            panel.setBounds(28, y, 600, 60);
            dashPane.add(panel);
            
            JPanel panel2 = new JPanel();
            panel2.setBounds(10, y, 15, 60);
            LineBorder border2 = new LineBorder(new Color(Integer.parseInt(words[3]),Integer.parseInt(words[4]),Integer.parseInt(words[5])), 20, true);
            panel2.setBorder(border2);
            dashPane.add(panel2);
            
            eventPanels.add(panel);
            y += panel.getHeight()+10;
            dashPane.repaint();
            dashPane.revalidate();
            repaint();
            revalidate();
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
    private javax.swing.JPanel calendarPane;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel dashPane;
    private javax.swing.JButton editButton;
    private javax.swing.JButton editCancelButton;
    private javax.swing.JColorChooser editColorChooser;
    private javax.swing.JLabel editColorLabel;
    private javax.swing.JTextField editDDField;
    private javax.swing.JLabel editDDLabel;
    private javax.swing.JTextField editDescField;
    private javax.swing.JLabel editDescLabel;
    private javax.swing.JFrame editEventFrame;
    private javax.swing.JTextField editTitleField;
    private javax.swing.JLabel editTitleLabel;
    private javax.swing.JButton logCancelButton;
    private javax.swing.JButton logNoButton;
    private javax.swing.JButton logYesButton;
    private javax.swing.JButton logoutButton;
    private javax.swing.JFrame logoutFrame;
    private javax.swing.JLabel logoutLabel;
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
    private JButton addEventButton;
}
