package planner;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.NoSuchFileException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PlannerFrame extends javax.swing.JFrame {
    Notes note;
    public List<String> oldEvents;
    public List<String> newEvents;
    List<String> newNotes = new ArrayList<>();
    public List<JPanel> eventPanels = new ArrayList<>();
    public List<String> notesToDel = new ArrayList<>();
    public static String user = LoginSystem.user;
    public int tmpIndex;
    private int calYear, calMonth, calDay, currentYear, currentMonth;
    
    public PlannerFrame() {
        initComponents();
        addDefaultC();
        
        lblMonth = new JLabel ("January");
        labelText =new JLabel ("ERROR");
        lblYear = new JLabel ("Change year:");
        cmbYear = new JComboBox();
        btnPrev = new JButton ("Previous");
        btnNext = new JButton ("Next");
        mtblCalendar = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tblCalendar = new JTable(mtblCalendar);
        stblCalendar = new JScrollPane(tblCalendar);
        pnlCalendar = new JPanel(null);
        outputLabel = new javax.swing.JFrame();
        pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));
        calendarPane.setLayout (null);
        calendarPane.add(lblMonth, BorderLayout.PAGE_START);
        setResizable(false);

        btnPrev.addActionListener(new btnPrev_Action());
        btnNext.addActionListener(new btnNext_Action());
        cmbYear.addActionListener(new cmbYear_Action());
        
        //Add controls to pane
        calendarPane.add(lblMonth);
        calendarPane.add(lblYear);
        calendarPane.add(cmbYear);
        calendarPane.add(btnPrev);
        calendarPane.add(btnNext);
        calendarPane.add(stblCalendar);
        calendarPane.setBackground(new Color(255, 229, 153));

        calendarPane.setBounds(0, 0, calendarPane.getWidth(), calendarPane.getHeight());
        lblMonth.setBounds(160-lblMonth.getPreferredSize().width/2, 25, 100, 25);
        lblYear.setBounds(575, 450, 80, 20);
        cmbYear.setBounds(650, 450, 80, 20);
        btnPrev.setBounds(100, 25, 100, 25);
        btnNext.setBounds(600, 25, 100, 25);
        stblCalendar.setBounds(0, 50, calendarPane.getWidth(), calendarPane.getHeight());


        GregorianCalendar cal = new GregorianCalendar(); //Create calendar
        calDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
        calMonth = cal.get(GregorianCalendar.MONTH); //Get month
        calYear = cal.get(GregorianCalendar.YEAR); //Get year
        currentMonth = calMonth; //Match month and year
        currentYear = calYear;
        
        String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
        for (int i=0; i<7; i++){
            mtblCalendar.addColumn(headers[i]);
        }
        
        tblCalendar.setBackground(new Color(255, 229, 153));
        setBackground(new Color(255, 229, 153));

        
        //No resize/reorder
        tblCalendar.getTableHeader().setResizingAllowed(false);
        tblCalendar.getTableHeader().setReorderingAllowed(false);
        
        //Single cell selection
        tblCalendar.setColumnSelectionAllowed(true);
        tblCalendar.setRowSelectionAllowed(true);
        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Set row/column count
        tblCalendar.setRowHeight(60);
        mtblCalendar.setColumnCount(7);
        mtblCalendar.setRowCount(6);
        
        //Populate table
        for (int i=calYear; i<=calYear+1; i++){
            cmbYear.addItem(String.valueOf(i));
        }
        
        newColorChooser.setPreviewPanel(new JPanel());
        AbstractColorChooserPanel[] oldPanels = newColorChooser.getChooserPanels();
        newColorChooser.removeChooserPanel(oldPanels[1]);
        newColorChooser.removeChooserPanel(oldPanels[2]);
        newColorChooser.removeChooserPanel(oldPanels[4]);
        
        newMonth.removeAllItems();
        newDay.removeAllItems();
        newYear.removeAllItems();
        for (int i=1;i<=12;i++) {
            newMonth.addItem(String.valueOf(i));
        }
        
        for (int i=1;i<=31;i++) {
            newDay.addItem(String.valueOf(i));
        }
        
        for (int i=calYear;i<=calYear+1;i++) {
            newYear.addItem(String.valueOf(i));
        }
        
        newEventFrame.pack();
        
        editColorChooser.setPreviewPanel(new JPanel());
        AbstractColorChooserPanel[] oldPanels2 = editColorChooser.getChooserPanels();
        editColorChooser.removeChooserPanel(oldPanels2[1]);
        editColorChooser.removeChooserPanel(oldPanels2[2]);
        editColorChooser.removeChooserPanel(oldPanels2[4]);
        editEventFrame.pack();
        
        refreshCalendar(calMonth, calYear);
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
        newColorChooser = new javax.swing.JColorChooser();
        newColorLabel = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        newMonth = new javax.swing.JComboBox<>();
        newDay = new javax.swing.JComboBox<>();
        newYear = new javax.swing.JComboBox<>();
        newDDLabel1 = new javax.swing.JLabel();
        newDDLabel2 = new javax.swing.JLabel();
        newDDLabel3 = new javax.swing.JLabel();
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
        newNoteFrame = new javax.swing.JFrame();
        noteNameLabel = new javax.swing.JLabel();
        noteNameField = new javax.swing.JTextField();
        noteCreateButton = new javax.swing.JButton();
        noteCancelButton = new javax.swing.JButton();
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

        newMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        newMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMonthActionPerformed(evt);
            }
        });

        newDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        newYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        newDDLabel1.setText("Month");

        newDDLabel2.setText("Day");

        newDDLabel3.setText("Year");

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
                                .addGroup(newEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(newColorLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, newEventFrameLayout.createSequentialGroup()
                                        .addComponent(newDDLabel)
                                        .addGap(29, 29, 29)
                                        .addComponent(newDDLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(newMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(newDDLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(newDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(newDDLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(newYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
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

        newEventFrameLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {newDDLabel1, newDDLabel2, newDDLabel3});

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
                .addGap(18, 18, 18)
                .addGroup(newEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(newEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newDDLabel2)
                        .addComponent(newDDLabel1)
                        .addComponent(newDDLabel3)
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

        newNoteFrame.setMinimumSize(new java.awt.Dimension(280, 120));
        newNoteFrame.setPreferredSize(new java.awt.Dimension(280, 120));
        newNoteFrame.setResizable(false);

        noteNameLabel.setText("Note Name:");

        noteCreateButton.setText("Create");
        noteCreateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteCreateButtonActionPerformed(evt);
            }
        });

        noteCancelButton.setText("Cancel");
        noteCancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noteCancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout newNoteFrameLayout = new javax.swing.GroupLayout(newNoteFrame.getContentPane());
        newNoteFrame.getContentPane().setLayout(newNoteFrameLayout);
        newNoteFrameLayout.setHorizontalGroup(
            newNoteFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newNoteFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(noteNameLabel)
                .addGap(18, 18, 18)
                .addComponent(noteNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(newNoteFrameLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(noteCreateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(noteCancelButton)
                .addGap(28, 28, 28))
        );

        newNoteFrameLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {noteCancelButton, noteCreateButton});

        newNoteFrameLayout.setVerticalGroup(
            newNoteFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newNoteFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(newNoteFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noteNameLabel)
                    .addComponent(noteNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(newNoteFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(noteCreateButton)
                    .addComponent(noteCancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        newNoteFrameLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {noteCancelButton, noteCreateButton});

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

    public void refreshCalendar(int month, int year){
        //Variables
        String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int nod, som; //Number Of Days, Start Of Month
        
        //Allow/disallow buttons
        if (currentYear==calYear && currentMonth==0){
            btnPrev.setEnabled(false);
        }
        else{
        btnPrev.setEnabled(true);
        }
        if (currentYear==2020 && currentMonth==11){
            btnNext.setEnabled(false);
        }
        else{
        btnNext.setEnabled(true);
        }
        if (month == 0 && year <= calYear-10){
            btnPrev.setEnabled(false);
        } //Too early
        else if (month == 11 && year >= calYear+100){
            btnNext.setEnabled(false);
        } //Too late
        lblMonth.setText(months[month]); //Refresh the month label (at the top)
        lblMonth.setBounds(400, 25, 180, 25); //Re-align label with calendar
        cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box
        
        //Clear table
        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++){
                mtblCalendar.setValueAt(null, i, j);
            }
        }
        
        //Get first day of month and number of days
        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = cal.get(GregorianCalendar.DAY_OF_WEEK);
        
        //Draw calendar
        for (int i=1; i<=nod; i++){
            int row = (i+som-2)/7;
            int column  =  (i+som-2)%7;
            mtblCalendar.setValueAt(i, row, column);
        }
        
        
        //Apply renderers
        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
    }
    
    class tblCalendarRenderer extends DefaultTableCellRenderer{
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            int[] datesInt= new int [3];
            List<String> totalVal = new ArrayList<String>();
            List<String> eveName = new ArrayList<String>();
            int f;
            int r=0;
            List<Integer> arrayTimes = new ArrayList<Integer>();
            for (String line : newEvents) {
                String[] words = line.split(";");
                totalVal.add(words[2]);
                eveName.add(words[0]);
            }
            f=totalVal.size()*2;
                super.getTableCellRendererComponent(table, value, selected, focused, row, column);
                if (column == 0 || column == 6){ //Week-end
                    setBackground(new Color(255, 220, 220));
                }              

                else{ //Week
                    setBackground(new Color(255, 229, 153));
                }
                if (value != null){
                    if (Integer.parseInt(value.toString()) == calDay && currentMonth == calMonth && currentYear == calYear){ //Today
                        setBackground(new Color(220, 220, 255));
                    }
                    while (totalVal.size()<f){
                        String[] splitDates= totalVal.get(r).split("/");
                        for (int i=0; i<3; i++){
                            datesInt[i]= Integer.parseInt(splitDates[i]);
                        }
                        if (Integer.parseInt(value.toString()) == datesInt[1] && currentMonth == (datesInt[0]-1) && currentYear == datesInt[2]){ //Today
                            setText(Integer.parseInt(value.toString())+" "+eveName.get(r));
                        }
                        f--;
                        r++;
                    }
                }
            refreshCalendar(currentMonth, currentYear);    
            setBorder(null);
            setForeground(Color.black);
            return this;
        }
    }
    
    class btnPrev_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (currentMonth == 0){ //Back one year
                currentMonth = 11;
                currentYear -= 1;
            }
            else{ //Back one month
                currentMonth -= 1;
            }
            refreshCalendar(currentMonth, currentYear);
        }
    }
    
    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {                                         
            if (currentMonth == 0){ //Back one year
                currentMonth = 11;
                currentYear -= 1;
            }
            else{ //Back one month
                currentMonth -= 1;
            }
            refreshCalendar(currentMonth, currentYear);    
    }
    
    class btnNext_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (currentMonth == 11){ //Foward one year
                currentMonth = 0;
                currentYear += 1;
            }
            else{ //Foward one month
                currentMonth += 1;
            }
            refreshCalendar(currentMonth, currentYear);
        }
    }
    class cmbYear_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (cmbYear.getSelectedItem() != null){
                String b = cmbYear.getSelectedItem().toString();
                currentYear = Integer.parseInt(b);
                refreshCalendar(currentMonth, currentYear);
            }
        }
    }
    
    private void addEventButtonActionPerformed(java.awt.event.ActionEvent evt) {
        newTitleField.setText("");
        newDescField.setText("");
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
        line = newTitleField.getText()+";"+newDescField.getText()+";"+newMonth.getSelectedItem()+"/"+newDay.getSelectedItem()+"/"+newYear.getSelectedItem()+";"+color.getRed()+";"+color.getGreen()+";"+color.getBlue();
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
            Files.write(Paths.get(user+"_events"+".txt"), newEvents, StandardCharsets.UTF_8);
            Files.write(Paths.get(user+"_notes"+".txt"), newNotes, StandardCharsets.UTF_8);
            for (String fileName : notesToDel) {
                System.out.println("DELETING: "+fileName);
                Path path = Paths.get(fileName+".txt");
                try {
                    Files.delete(path);
                } catch (NoSuchFileException x) {
                    System.err.format("%s: no such" + " file or directory%n", path);
                } catch (DirectoryNotEmptyException x) {
                    System.err.format("%s not empty%n", path);
                } catch (IOException x) {
                    System.err.println(x);
                }
                
            }
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

    private void newMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMonthActionPerformed
        System.out.println(newMonth.getSelectedItem());
        if ((String)newMonth.getSelectedItem() == newMonth.getItemAt(3) || (String)newMonth.getSelectedItem() == newMonth.getItemAt(5) || (String)newMonth.getSelectedItem() == newMonth.getItemAt(8) || newMonth.getSelectedItem() == newMonth.getItemAt(10)) {
            newDay.removeAllItems();
            for (int i=1;i<=30;i++) {
                newDay.addItem(String.valueOf(i));
            }
        } else if (newMonth.getSelectedItem() == newMonth.getItemAt(1)) {
            newDay.removeAllItems();
            for (int i=1;i<=28;i++) {
                newDay.addItem(String.valueOf(i));
            }
        }
    }//GEN-LAST:event_newMonthActionPerformed

    private void noteCancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteCancelButtonActionPerformed
        newNoteFrame.dispose();
    }//GEN-LAST:event_noteCancelButtonActionPerformed

    private void noteCreateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noteCreateButtonActionPerformed
        PrintWriter file;
        try {
            file = new PrintWriter(noteNameField.getText()+".txt", "UTF-8");
            file.close();
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(PlannerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        newNotes.add(noteNameField.getText());
        try {
            Files.write(Paths.get(user+"_notes"+".txt"), newNotes, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            Logger.getLogger(PlannerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        notesPane.removeAll();
        note.addDefaultN();
        note.displayNotes();
        newNoteFrame.dispose();
    }//GEN-LAST:event_noteCreateButtonActionPerformed
  
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
            File file = new File(user+"_events"+".txt");
            Path path = Paths.get(user+"_events"+".txt");
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
    
    public class Notes {
        File file;
        public List<JPanel> notePanels = new ArrayList<>();
        
        Notes() throws IOException {
            file = new File(user+"_notes"+".txt");
            addDefaultN();
        }
        
        private void addNoteButtonActionPerformed(java.awt.event.ActionEvent evt) {
            newNoteFrame.setLocationRelativeTo(null);
            newNoteFrame.setVisible(true);
        }
        
        private void addDefaultN() {
            notesPane.setLayout(null);
            addNoteButton = new JButton("Add Note");
            addNoteButton.addActionListener(Notes.this::addNoteButtonActionPerformed);
            addNoteButton.setBounds(675, 10, 100, 40);
            notesPane.add(addNoteButton);

            LocalDateTime myDateObj = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E. MMM dd, yyyy");
            String formattedDate = myDateObj.format(myFormatObj);
            dateLabel = new JLabel(formattedDate);
            dateLabel.setBounds(10, 10, 130, 20);
            notesPane.setLayout(null);
            notesPane.add(dateLabel);
        }
        
        private void readNotes() {
            Scanner in = null;
            try {
                File file = new File(user+"_notes"+".txt");
                Path path = Paths.get(user+"_notes"+".txt");
                newNotes = Files.readAllLines(path, StandardCharsets.UTF_8);
                in = new Scanner(file);
            } catch (IOException ex) {
                Logger.getLogger(LoginSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        private void editBNButtonActionPerformed(ActionEvent evt, JButton editB) throws IOException {
            System.out.println("editing notes...");
            for (int i=0;i<notePanels.size();i++) {
                if (notePanels.get(i).isAncestorOf(editB)) {
                    System.out.println(newNotes.get(i));
                    String name = newNotes.get(i);
                    File noteFile = new File(name+".txt");
                    Desktop.getDesktop().edit(noteFile);
                    tmpIndex = i;
                    break;
                }
            }
        }

        private void delBNButtonActionPerformed(ActionEvent evt, JButton delB) {
            System.out.println("deleting notes...");
            System.out.println(notePanels.size()+" "+notePanels);
            for (int i=0;i<notePanels.size();i++) {
                if (notePanels.get(i).isAncestorOf(delB)) {
                    notesToDel.add(newNotes.get(i));
                    newNotes.remove(i);
                    notesPane.removeAll();
                    addDefaultN();
                    displayNotes();
                    break;
                }
            }
            System.out.println("done deleting");
        }
        
        private void displayNotes() {
            notesPane.repaint();
            notesPane.revalidate();
            repaint();
            revalidate();
            notePanels.clear();
            System.out.println(newNotes);
            int y = 40;
            for (String line : newNotes) {
                System.out.println("displaying note...");
                JPanel panel = new JPanel(new GridBagLayout());
                GridBagConstraints c = new GridBagConstraints();
                panel.setBackground(new Color(192,192,192));

                c.weighty = 1.0;
                c.weightx = 1.0;
                c.anchor = GridBagConstraints.LINE_START;
                c.gridx = 0;
                c.gridy = 0;
                panel.add(new JLabel(" "+line), c);
                c.gridheight = 1;
                c.gridx = 2;
                c.gridy = 0;
                c.anchor = GridBagConstraints.LINE_END;
                JButton editB = new JButton("Edit");
                editB.addActionListener((ActionEvent evt) -> {
                    try {
                        Notes.this.editBNButtonActionPerformed(evt, editB);
                    } catch (IOException ex) {
                        Logger.getLogger(PlannerFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                panel.add(editB, c);
                c.gridy = 4;
                JButton delB = new JButton("Delete");
                delB.addActionListener((ActionEvent evt) -> {
                    Notes.this.delBNButtonActionPerformed(evt, delB);
                });
                panel.add(delB, c);

                notesPane.setLayout(null);
                panel.setBounds(10, y, 600, 60);
                notesPane.add(panel);

                notePanels.add(panel);
                y += panel.getHeight()+10;
                notesPane.repaint();
                notesPane.revalidate();
                repaint();
                revalidate();
            }
        }
    }
    
    private void showNotes() {
        try {
            notesPane.removeAll();
            note = new Notes();
            note.readNotes();
            note.displayNotes();
        } catch (IOException ex) {
            Logger.getLogger(PlannerFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void main(String args[]) throws IOException {
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
        Notes notes = new Notes();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame.readFile();
                frame.displayEvents();
                frame.showNotes();
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
    private javax.swing.JLabel newDDLabel;
    private javax.swing.JLabel newDDLabel1;
    private javax.swing.JLabel newDDLabel2;
    private javax.swing.JLabel newDDLabel3;
    private javax.swing.JComboBox<String> newDay;
    private javax.swing.JTextField newDescField;
    private javax.swing.JLabel newDescLabel;
    private javax.swing.JFrame newEventFrame;
    private javax.swing.JComboBox<String> newMonth;
    private javax.swing.JFrame newNoteFrame;
    private javax.swing.JTextField newTitleField;
    private javax.swing.JLabel newTitleLabel;
    private javax.swing.JComboBox<String> newYear;
    private javax.swing.JButton noteCancelButton;
    private javax.swing.JButton noteCreateButton;
    private javax.swing.JTextField noteNameField;
    private javax.swing.JLabel noteNameLabel;
    private javax.swing.JPanel notesPane;
    private javax.swing.JTabbedPane tabbedPane;
    // End of variables declaration//GEN-END:variables
    private JButton addNoteButton;
    private JLabel dateLabel;
    private JButton addEventButton;
    private JLabel lblMonth, lblYear, labelText;
    private JButton btnPrev, btnNext;
    private JTable tblCalendar;
    private JComboBox cmbYear;
    private JFrame frmMain;
    private Container pane;
    private DefaultTableModel mtblCalendar; //Table model
    private JScrollPane stblCalendar; //The scrollpane
    private JPanel pnlCalendar;
    private JFrame outputLabel;
}
