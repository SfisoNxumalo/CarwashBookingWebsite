/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carwashbookingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sfiso
 */
public class frmMakeBooking extends javax.swing.JFrame {

    /**
     * Creates new form frmMakeBooking
     */
    public frmMakeBooking() {
        initComponents();
    }

    public String strloggedInEmail;
    String strName;
    String strEmail;
    String strWashType;
    String strCarRegistration;
    String strCarType;
    String strDate;
    String strTime;
    
    private void mGetValuesFromGUI()
    {
        
        strName = txtName.getText();
        strEmail = txtEmail.getText();
        strCarType = cboVehicleType.getSelectedItem().toString();
        strCarRegistration = txtNumberPlate.getText();
        strTime = lblHour.getText() + ":" + lblMinute.getText();
        strDate = null;
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
            dccDate.setDateFormat(sdf);
            strDate = dccDate.getText();
            if(dccDate.getText().length() < 10)
            {
                strDate = null;
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        
        if(rbQuickwash.isSelected())
        {
            strWashType = rbQuickwash.getText();
        }
        else if(rbFullwash.isSelected())
        {
            strWashType = rbFullwash.getText();
        }
        else
        {
            strWashType = null;
        }
    }
    
    private void mSetValuesToUpperCase()
    {
         strCarType = strCarType.toUpperCase();
        strWashType = strWashType.toUpperCase();   
        strCarRegistration = strCarRegistration.toUpperCase();   
        
    }
    
    private void mGetDetails() //gets the login that that matches
    {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/carwash_db";
        String strDBUser = "root";
        String strDBPassword = "password";
        
        Connection conMySQLConnectionString;
        Statement stStatement = null;
        ResultSet rsUsers = null;
        
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
            stStatement = conMySQLConnectionString.createStatement();
            String strQuery = "SELECT email, name FROM users_info "
                            + "WHERE email = " + "'" + strloggedInEmail + "'";
            stStatement.execute(strQuery);
            rsUsers = stStatement.getResultSet(); 
            
            while(rsUsers.next())
            {
                strEmail =  rsUsers.getString(1);
                strName = rsUsers.getString(2);
               
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        finally
        {
            try
            {
                stStatement.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(rootPane, "Connection string not closed " + e);
            }
        }
    }
    
    private void mMakeBooking() //creates and saved new accout data to the database.
    {
        String URL = "jdbc:mysql://localhost:3306/carwash_db";
        String User = "root";
        String Password = "password";
              
        try
        {
            Connection conMySQLConnectionString = DriverManager.getConnection(URL, User, Password);
            Statement myStatement = conMySQLConnectionString.createStatement();
            String strInsert = "INSERT INTO tblbookings(name, email, car_reg, vehicle_type, wash_type, date, time, booking_outcome)"
                             + " VALUES(" 
                                + "'" + strName + "'" + ", " 
                                + "'" + strEmail + "'" + ", " 
                                + "'" + strCarRegistration + "'" + ", " 
                                + "'" + strCarType + "'" + ", " 
                                + "'" + strWashType + "'" + ", " 
                                + "'" + strDate + "'" + ", " 
                                + "'" + strTime + "'" + ", " 
                                + "'PENDING'"   
                                + ")";
            myStatement.execute(strInsert);
            
            myStatement.close();
            JOptionPane.showMessageDialog(rootPane, "Booking has been placed");
            
            mClearText();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    private void mClearText()
    {
        txtNumberPlate.setText("");
        txtName.setText("");
        txtEmail.setText("");
        cboVehicleType.setSelectedIndex(0);
        jslHourTime.setValue(0);
        jslMinuteTime.setValue(0);
        lblHour.setText("--"); 
        lblMinute.setText("--"); 
        rbQuickwash.setSelected(false);
        rbFullwash.setSelected(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        btnBook = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        lblName = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        pnlName3 = new javax.swing.JPanel();
        lblDate = new javax.swing.JLabel();
        dccDate = new datechooser.beans.DateChooserCombo();
        jPanel4 = new javax.swing.JPanel();
        jslMinuteTime = new javax.swing.JSlider();
        jslHourTime = new javax.swing.JSlider();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        lblMinute = new javax.swing.JLabel();
        lblHour = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        pnlWashType = new javax.swing.JPanel();
        rbQuickwash = new javax.swing.JRadioButton();
        rbFullwash = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        lblNumberPlate = new javax.swing.JLabel();
        txtNumberPlate = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        cboVehicleType = new javax.swing.JComboBox<>();
        lblVehicleType = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));

        btnBook.setBackground(new java.awt.Color(102, 153, 255));
        btnBook.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        btnBook.setForeground(new java.awt.Color(255, 255, 255));
        btnBook.setText("Book");
        btnBook.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnBook.setOpaque(false);
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        btnLogout.setBackground(new java.awt.Color(102, 153, 255));
        btnLogout.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnLogout.setText("Logout");
        btnLogout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        btnLogout.setOpaque(false);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        lblName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Name:");

        lblLogin.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/g3338.png"))); // NOI18N

        pnlName3.setBackground(new java.awt.Color(51, 102, 255));

        lblDate.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDate.setForeground(new java.awt.Color(255, 255, 255));
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDate.setText("Date:");

        try {
            dccDate.setDefaultPeriods(new datechooser.model.multiple.PeriodSet(new datechooser.model.multiple.Period(new java.util.GregorianCalendar(2022, 4, 28),
                new java.util.GregorianCalendar(2022, 4, 28))));
    } catch (datechooser.model.exeptions.IncompatibleDataExeption e1) {
        e1.printStackTrace();
    }
    dccDate.setFieldFont(new java.awt.Font("Yu Gothic UI Semibold", java.awt.Font.PLAIN, 14));
    dccDate.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
        public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
            dccDateOnSelectionChange(evt);
        }
    });

    javax.swing.GroupLayout pnlName3Layout = new javax.swing.GroupLayout(pnlName3);
    pnlName3.setLayout(pnlName3Layout);
    pnlName3Layout.setHorizontalGroup(
        pnlName3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlName3Layout.createSequentialGroup()
            .addGap(0, 0, Short.MAX_VALUE)
            .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(dccDate, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
    );
    pnlName3Layout.setVerticalGroup(
        pnlName3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlName3Layout.createSequentialGroup()
            .addGap(0, 0, 0)
            .addGroup(pnlName3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(dccDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlName3Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(0, 0, 0))
    );

    jPanel4.setBackground(new java.awt.Color(255, 255, 255));
    jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Time:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
    jPanel4.setOpaque(false);

    jslMinuteTime.setMaximum(59);
    jslMinuteTime.setMinimum(-1);
    jslMinuteTime.setValue(-1);
    jslMinuteTime.setOpaque(false);
    jslMinuteTime.addChangeListener(new javax.swing.event.ChangeListener() {
        public void stateChanged(javax.swing.event.ChangeEvent evt) {
            jslMinuteTimeStateChanged(evt);
        }
    });

    jslHourTime.setMaximum(23);
    jslHourTime.setMinimum(-1);
    jslHourTime.setValue(-1);
    jslHourTime.setOpaque(false);
    jslHourTime.addChangeListener(new javax.swing.event.ChangeListener() {
        public void stateChanged(javax.swing.event.ChangeEvent evt) {
            jslHourTimeStateChanged(evt);
        }
    });

    jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabel6.setForeground(new java.awt.Color(255, 255, 255));
    jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel6.setText("Hour");

    jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabel7.setForeground(new java.awt.Color(255, 255, 255));
    jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel7.setText("Minute");

    jPanel2.setOpaque(false);
    jPanel2.setLayout(new java.awt.GridBagLayout());

    jDesktopPane1.setOpaque(false);

    lblMinute.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
    lblMinute.setForeground(new java.awt.Color(255, 255, 255));
    lblMinute.setText("--");

    lblHour.setFont(new java.awt.Font("Verdana", 0, 20)); // NOI18N
    lblHour.setForeground(new java.awt.Color(255, 255, 255));
    lblHour.setText("--");

    jLabel8.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
    jLabel8.setForeground(new java.awt.Color(255, 255, 255));
    jLabel8.setText(":");

    jDesktopPane1.setLayer(lblMinute, javax.swing.JLayeredPane.DEFAULT_LAYER);
    jDesktopPane1.setLayer(lblHour, javax.swing.JLayeredPane.DEFAULT_LAYER);
    jDesktopPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

    javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
    jDesktopPane1.setLayout(jDesktopPane1Layout);
    jDesktopPane1Layout.setHorizontalGroup(
        jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
            .addGap(0, 0, 0)
            .addComponent(lblHour)
            .addGap(3, 3, 3)
            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(3, 3, 3)
            .addComponent(lblMinute)
            .addGap(0, 0, 0))
    );
    jDesktopPane1Layout.setVerticalGroup(
        jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jDesktopPane1Layout.createSequentialGroup()
            .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblHour)
                .addComponent(jLabel8)
                .addComponent(lblMinute))
            .addGap(0, 0, 0))
    );

    jPanel2.add(jDesktopPane1, new java.awt.GridBagConstraints());

    javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
    jPanel4.setLayout(jPanel4Layout);
    jPanel4Layout.setHorizontalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addComponent(jslHourTime, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
            .addGap(81, 81, 81)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jslMinuteTime, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
            .addContainerGap())
        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    jPanel4Layout.setVerticalGroup(
        jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel4Layout.createSequentialGroup()
            .addGap(5, 5, 5)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(0, 0, 0)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jslMinuteTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jslHourTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(0, 0, 0)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6)
                .addComponent(jLabel7))
            .addGap(3, 3, 3))
    );

    txtName.setEditable(false);
    txtName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
    txtName.setForeground(new java.awt.Color(255, 255, 255));
    txtName.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    txtName.setOpaque(false);

    pnlWashType.setBackground(new java.awt.Color(255, 255, 255));
    pnlWashType.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Wash Type:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255))); // NOI18N
    pnlWashType.setOpaque(false);

    rbQuickwash.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    rbQuickwash.setText("Quick Wash");
    rbQuickwash.setOpaque(false);
    rbQuickwash.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            rbQuickwashActionPerformed(evt);
        }
    });

    rbFullwash.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    rbFullwash.setText("Full Wash");
    rbFullwash.setOpaque(false);
    rbFullwash.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            rbFullwashActionPerformed(evt);
        }
    });

    jScrollPane2.setBorder(null);
    jScrollPane2.setOpaque(false);

    jTextPane1.setEditable(false);
    jTextPane1.setBackground(new java.awt.Color(102, 153, 255));
    jTextPane1.setBorder(null);
    jTextPane1.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
    jTextPane1.setForeground(new java.awt.Color(255, 255, 255));
    jTextPane1.setText("Takes approximately 30min");
    jTextPane1.setToolTipText("");
    jScrollPane2.setViewportView(jTextPane1);

    jScrollPane4.setBorder(null);
    jScrollPane4.setOpaque(false);

    jTextPane3.setEditable(false);
    jTextPane3.setBackground(new java.awt.Color(102, 153, 255));
    jTextPane3.setBorder(null);
    jTextPane3.setFont(new java.awt.Font("Yu Gothic", 0, 12)); // NOI18N
    jTextPane3.setForeground(new java.awt.Color(255, 255, 255));
    jTextPane3.setText("Takes approximately 60min");
    jTextPane3.setToolTipText("");
    jScrollPane4.setViewportView(jTextPane3);

    javax.swing.GroupLayout pnlWashTypeLayout = new javax.swing.GroupLayout(pnlWashType);
    pnlWashType.setLayout(pnlWashTypeLayout);
    pnlWashTypeLayout.setHorizontalGroup(
        pnlWashTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlWashTypeLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(pnlWashTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(rbQuickwash, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(59, 59, 59)
            .addGroup(pnlWashTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlWashTypeLayout.createSequentialGroup()
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 8, Short.MAX_VALUE))
                .addComponent(rbFullwash, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addContainerGap())
    );
    pnlWashTypeLayout.setVerticalGroup(
        pnlWashTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(pnlWashTypeLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(pnlWashTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(rbQuickwash)
                .addComponent(rbFullwash))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(pnlWashTypeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(3, 3, 3))
    );

    lblNumberPlate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
    lblNumberPlate.setForeground(new java.awt.Color(255, 255, 255));
    lblNumberPlate.setText("Number Plate:");

    txtNumberPlate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
    txtNumberPlate.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txtNumberPlate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    txtNumberPlate.setOpaque(false);
    txtNumberPlate.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyTyped(java.awt.event.KeyEvent evt) {
            txtNumberPlateKeyTyped(evt);
        }
    });

    btnBack.setBackground(new java.awt.Color(102, 153, 255));
    btnBack.setFont(new java.awt.Font("Segoe UI", 0, 25)); // NOI18N
    btnBack.setForeground(new java.awt.Color(255, 255, 255));
    btnBack.setText("<Back");
    btnBack.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    btnBack.setOpaque(false);
    btnBack.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            btnBackActionPerformed(evt);
        }
    });

    cboVehicleType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
    cboVehicleType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "SEDAN", "COUPE", "SPORTS CAR", "STATION WAGON", "HATCHBACK", "CONVERTIBLE", "SUV", "MINIVAN" }));
    cboVehicleType.addItemListener(new java.awt.event.ItemListener() {
        public void itemStateChanged(java.awt.event.ItemEvent evt) {
            cboVehicleTypeItemStateChanged(evt);
        }
    });
    cboVehicleType.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent evt) {
            cboVehicleTypeMousePressed(evt);
        }
    });

    lblVehicleType.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
    lblVehicleType.setForeground(new java.awt.Color(255, 255, 255));
    lblVehicleType.setText("Vehicle Type:");

    txtEmail.setEditable(false);
    txtEmail.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
    txtEmail.setForeground(new java.awt.Color(255, 255, 255));
    txtEmail.setHorizontalAlignment(javax.swing.JTextField.CENTER);
    txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
    txtEmail.setOpaque(false);

    lblEmail.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
    lblEmail.setForeground(new java.awt.Color(255, 255, 255));
    lblEmail.setText("Email:");

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(32, 32, 32)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addComponent(pnlName3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(lblVehicleType)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(cboVehicleType, 0, 133, Short.MAX_VALUE))
                .addComponent(pnlWashType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtName))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEmail))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(lblNumberPlate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumberPlate, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(65, 65, 65))
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(80, 80, 80)
            .addComponent(btnBook, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(121, 121, 121)
            .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(111, 111, 111))
    );
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(jPanel3Layout.createSequentialGroup()
            .addGap(26, 26, 26)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(10, 10, 10)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNumberPlate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNumberPlate, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(pnlName3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboVehicleType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblVehicleType, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(pnlWashType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(65, 65, 65)
                            .addComponent(lblLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(144, Short.MAX_VALUE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBack)
                        .addComponent(btnLogout)
                        .addComponent(btnBook))
                    .addGap(24, 24, 24))))
    );

    jLabel1.setBackground(new java.awt.Color(255, 255, 255));
    jLabel1.setFont(new java.awt.Font("Montserrat", 0, 36)); // NOI18N
    jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
    jLabel1.setText("Make A Booking");
    jLabel1.setOpaque(true);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(jLabel1)
            .addGap(0, 0, 0)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
//        SimpleDateFormat sdtDate = new SimpleDateFormat("yyyy-MM-dd");
//        LocalDate todayDate = LocalDate.now();
//
//        Date Startd = sdtDate.parse(dccDate.getText().substring(0, 10));
//        Date endD = sdtDate.parse((todayDate).toString());
//
//        if(Startd.after(endD))
//        {
//            JOptionPane.showMessageDialog(null, "This data can only be added after the " + todayDate);
//        }
//        else
//        {
//            Date dtnow = new Date();
//
//            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
//
//            Date TimeIin = sdf.parse(strOpeningTime);
//            Date TimeOout = sdf.parse(strClosingTime);
//
//            if(TimeIin.after(dtnow))
//            {
//                JOptionPane.showMessageDialog(null, "This data can only be entered after " + TimeIin + " has passed");
//            }
//            else if(TimeOout.before(TimeIin))
//            {
//                JOptionPane.showMessageDialog(null, "Clockout time cannot be before clockin time");
//            }
//            else
//            {
//                ClockIn();
//                dialog.dispose();
//            }

//     sfiso   }
mGetValuesFromGUI();
mSetValuesToUpperCase();
    if(txtNumberPlate.getText().isBlank())
    {
        txtNumberPlate.requestFocusInWindow();
        txtNumberPlate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
    }
    else if(strDate == (null))
    {
        lblDate.setForeground(new java.awt.Color(255, 0, 0));
    }
    else if(cboVehicleType.getSelectedIndex() == 0)
    {
        cboVehicleType.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
    }
    else if(strWashType == null)
    {
        pnlWashType.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Wash Type:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 0, 0)));
    }
    else if(lblHour.getText().equals("--"))
    {
        jslHourTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
    }
    else if(lblMinute.getText().equals("--"))
    {
        jslMinuteTime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
    }
    else
    {
        
         mMakeBooking();
    }
// TODO add your handling code here:
    }//GEN-LAST:event_btnBookActionPerformed

    private void jslMinuteTimeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jslMinuteTimeStateChanged
        if(jslMinuteTime.getValue() >= 0 && jslMinuteTime.getValue() < 10)
        {
            lblMinute.setText("0" + String.valueOf(jslMinuteTime.getValue()));
        }
        else if(jslMinuteTime.getValue() == -1)
        {
            lblMinute.setText("--");
        }
        else
        {
            lblMinute.setText(String.valueOf(jslMinuteTime.getValue()));
        }
        jslMinuteTime.setBorder(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_jslMinuteTimeStateChanged

    private void jslHourTimeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jslHourTimeStateChanged
        if(jslHourTime.getValue() >= 0 && jslHourTime.getValue() < 10)
        {
            lblHour.setText("0" + String.valueOf(jslHourTime.getValue()));
        }
        else if(jslHourTime.getValue() == -1)
        {
            lblHour.setText("--");
        }
        else
        {
            lblHour.setText(String.valueOf(jslHourTime.getValue()));
        }
        jslHourTime.setBorder(null);
        // TODO add your handling code here:
    }//GEN-LAST:event_jslHourTimeStateChanged

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
     frmLogin frmH = new frmLogin();
        frmH.show();
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBackActionPerformed

    private void cboVehicleTypeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboVehicleTypeMousePressed
cboVehicleType.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));        // TODO add your handling code here:
    }//GEN-LAST:event_cboVehicleTypeMousePressed

    private void rbQuickwashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbQuickwashActionPerformed
    if(rbQuickwash.isSelected())
    {
        rbFullwash.setSelected(false);
        pnlWashType.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Wash Type:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255)));
    }
// TODO add your handling code here:
    }//GEN-LAST:event_rbQuickwashActionPerformed

    private void rbFullwashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbFullwashActionPerformed
    if(rbFullwash.isSelected())
    {
        rbQuickwash.setSelected(false);
        pnlWashType.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Wash Type:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(255, 255, 255)));
    }    // TODO add your handling code here:
    }//GEN-LAST:event_rbFullwashActionPerformed

    private void dccDateOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dccDateOnSelectionChange

            lblDate.setForeground(new java.awt.Color(255, 255, 255));
        
            // TODO add your handling code here:
    }//GEN-LAST:event_dccDateOnSelectionChange

    private void txtNumberPlateKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumberPlateKeyTyped
txtNumberPlate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));         // TODO add your handling code here:
    }//GEN-LAST:event_txtNumberPlateKeyTyped

    private void cboVehicleTypeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboVehicleTypeItemStateChanged
cboVehicleType.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));         // TODO add your handling code here:
    }//GEN-LAST:event_cboVehicleTypeItemStateChanged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    mGetDetails();
    txtName.setText(strName);    // TODO add your handling code here:
    txtEmail.setText(strEmail);    // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(frmMakeBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMakeBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMakeBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMakeBooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMakeBooking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnLogout;
    private javax.swing.JComboBox<String> cboVehicleType;
    private datechooser.beans.DateChooserCombo dccDate;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JSlider jslHourTime;
    private javax.swing.JSlider jslMinuteTime;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblEmail;
    public javax.swing.JLabel lblHour;
    private javax.swing.JLabel lblLogin;
    public javax.swing.JLabel lblMinute;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNumberPlate;
    private javax.swing.JLabel lblVehicleType;
    private javax.swing.JPanel pnlName3;
    private javax.swing.JPanel pnlWashType;
    private javax.swing.JRadioButton rbFullwash;
    private javax.swing.JRadioButton rbQuickwash;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtNumberPlate;
    // End of variables declaration//GEN-END:variables
}
