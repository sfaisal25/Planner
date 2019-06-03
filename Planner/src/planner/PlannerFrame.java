package planner;

/*
HEADER
*/
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PlannerFrame extends javax.swing.JFrame {
    public PlannerFrame() {
        initComponents();
        lblMonth = new JLabel ("January");
        labelText =new JLabel ("ERROR");
        lblYear = new JLabel ("Change year:");
        cmbYear = new JComboBox();
        btnPrev = new JButton ("Previous");
        btnNext = new JButton ("Next");
        mtblCalendar = new DefaultTableModel(){
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
                
        
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("E. MMM dd, yyyy");
        String formattedDate = myDateObj.format(myFormatObj);
        dateLabel = new JLabel(formattedDate);
        dateLabel.setBounds(10, 10, 100, 20);
        dashPane.setLayout(null);
        dashPane.add(dateLabel);
        
        newColorChooser.setPreviewPanel(new JPanel());
        AbstractColorChooserPanel[] oldPanels = newColorChooser.getChooserPanels();
        newColorChooser.removeChooserPanel(oldPanels[1]);
        newColorChooser.removeChooserPanel(oldPanels[2]);
        newColorChooser.removeChooserPanel(oldPanels[4]);
        newEventFrame.pack();
        
                refreshCalendar (calMonth, calYear);

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
        calendarPane = new javax.swing.JPanel();
        notesPane = new javax.swing.JPanel();

        newEventFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        newEventFrame.setMinimumSize(new java.awt.Dimension(660, 550));

        newTitleLabel.setText("Title:");

        newDescLabel.setText("Description:");

        newDDLabel.setText("Due Date:");

        newColorLabel.setText("Event Color:");

        addButton.setText("Create Event");

        cancelButton.setText("Cancel");

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
                .addGroup(newEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newDescLabel)
                    .addComponent(newDescField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(newEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newDDLabel)
                    .addComponent(newDDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(newColorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newColorChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(newEventFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(36, 36, 36))
        );

        newEventFrameLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {addButton, cancelButton});

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Worklet Planner");
        setBackground(new java.awt.Color(255, 229, 153));

        tabbedPane.setBackground(new java.awt.Color(250, 250, 250));
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
        );
        dashPaneLayout.setVerticalGroup(
            dashPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addEventButton)
                .addContainerGap(491, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Dashboard", dashPane);

        calendarPane.setBackground(new java.awt.Color(255, 229, 153));

        javax.swing.GroupLayout calendarPaneLayout = new javax.swing.GroupLayout(calendarPane);
        calendarPane.setLayout(calendarPaneLayout);
        calendarPaneLayout.setHorizontalGroup(
            calendarPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        calendarPaneLayout.setVerticalGroup(
            calendarPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
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
    static JLabel lblMonth, lblYear, labelText;
    static JButton btnPrev, btnNext;
    boolean confirmed=false;
    static JTable tblCalendar;
    static JComboBox cmbYear;
    static JFrame frmMain;
    static Container pane;
    static DefaultTableModel mtblCalendar; //Table model
    static JScrollPane stblCalendar; //The scrollpane
    static JPanel pnlCalendar;
    static JFrame outputLabel;
    static int calYear, calMonth, calDay, currentYear, currentMonth;

    private void addEventButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEventButtonActionPerformed
        newEventFrame.setVisible(true);
    }//GEN-LAST:event_addEventButtonActionPerformed

        public static void refreshCalendar(int month, int year){
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
    
    static class tblCalendarRenderer extends DefaultTableCellRenderer{
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
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
            }
            refreshCalendar(currentMonth, currentYear);    
            setBorder(null);
            setForeground(Color.black);
            return this;
        }
    }
        static class btnPrev_Action implements ActionListener{
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
            static class btnNext_Action implements ActionListener{
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
    static class cmbYear_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (cmbYear.getSelectedItem() != null){
                String b = cmbYear.getSelectedItem().toString();
                currentYear = Integer.parseInt(b);
                refreshCalendar(currentMonth, currentYear);
            }
        }
    }

    
    
    public static void main(String args[]) {


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlannerFrame().setVisible(true);

                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JButton addEventButton;
    private javax.swing.JPanel calendarPane;
    private javax.swing.JButton cancelButton;
    private javax.swing.JPanel dashPane;
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
