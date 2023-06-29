/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carwashbookingsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sfiso
 */
public class frmPendingBookings extends javax.swing.JFrame {

    /**
     * Creates new form frmBookings
     */
    public frmPendingBookings() {
        initComponents();
        
    }
    
    public void mViewBookings()
    {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/carwash_db";
        String strDBUser = "root";
        String strDBPassword = "password";
        
        Connection conMySQLConnectionString = null;
        Statement stStatement = null;
        ResultSet rsBookings = null;
        
        DefaultTableModel model = (DefaultTableModel)tblBookings.getModel();
              
        try
        {
            conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
            
            stStatement = conMySQLConnectionString.createStatement();
            
            String strSQLQuery = "SELECT * FROM tblBookings where booking_outcome = 'PENDING'";
            
            rsBookings = stStatement.executeQuery(strSQLQuery);
            
            ResultSetMetaData rmst = rsBookings.getMetaData();
            
            int intColumnCount = rmst.getColumnCount();

            Vector vRow;
            
            while(rsBookings.next())
            {
                vRow = new Vector(intColumnCount);
                for(int i = 1; i <= intColumnCount; i++)
                {
                    vRow.add(rsBookings.getString(i));   
                }
                
                model.addRow(vRow);
            }
             //Gets the beneficiaries data
            
            if(model.getRowCount() == 0) // checks if the searched record was found
            {
                JOptionPane.showMessageDialog(rootPane, "No data is currently saved on the database");  
            }    
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        finally
        {
            try
            {
                stStatement.close();
                rsBookings.close();
                conMySQLConnectionString.close();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }
    
    private void mUpdateBookingOutcome() // updates the data in the databse
    {
        //Connection conMySQLConnectionString = null;
        String strDBConnectionString = "jdbc:mysql://localhost:3306/carwash_db";
        String strDBUser = "root";
        String strDBPassword = "password";
          
        String strPmEmail = null;   
        DefaultTableModel model = (DefaultTableModel)tblBookings.getModel();
        try
        {
            Connection conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
            Statement myStatement = conMySQLConnectionString.createStatement();
            
            try
            {
                
                String strBookingID = tblBookings.getValueAt(tblBookings.getSelectedRow(), 0).toString().toUpperCase();
                   
                    
                    String strQuery = "UPDATE tblBookings "
                                    + "SET booking_outcome = " + "'APPROVED'"
                                    + "WHERE id = " + "'" + strBookingID + "'" ;
                    
                   
                    myStatement.executeUpdate(strQuery);

                
                myStatement.close();
                
                JOptionPane.showMessageDialog(rootPane, "Bookings has been appreoved");
                model.removeRow(tblBookings.getSelectedRow());
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(rootPane, e);
            }    
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    
    private void mDeleteBooking()    //Deletes data from the database
    {
        String strDBConnectionString = "jdbc:mysql://localhost:3306/carwash_db";
        String strDBUser = "root";
        String strDBPassword = "password";

        try
        {
            Connection conMySQLConnectionString = DriverManager.getConnection(strDBConnectionString, strDBUser, strDBPassword);
            Statement myStatement = conMySQLConnectionString.createStatement();
            
            try
            {
                String strBookingID = tblBookings.getValueAt(tblBookings.getSelectedRow(), 0).toString().toUpperCase();
                

                String  strQuery = "DELETE FROM tblBookings "
                                 + "WHERE ID = " + "'" + strBookingID + "'" ;  
                
                myStatement.execute(strQuery);
                myStatement.close();
                
                DefaultTableModel model = (DefaultTableModel)tblBookings.getModel();
                model.removeRow(tblBookings.getSelectedRow());
                
                JOptionPane.showMessageDialog(rootPane, "Booking has rejected and removed from the booking list.");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(rootPane, e);
            }    
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBookings = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnlControlPanel = new javax.swing.JPanel();
        pnlView = new javax.swing.JPanel();
        lblViewIcon = new javax.swing.JLabel();
        lblView = new javax.swing.JLabel();
        pnlReject = new javax.swing.JPanel();
        lblRejectIcon = new javax.swing.JLabel();
        lblReject = new javax.swing.JLabel();
        pnlApprove = new javax.swing.JPanel();
        lblApproveIcon = new javax.swing.JLabel();
        lblApprove = new javax.swing.JLabel();
        pnlApprovedBookings = new javax.swing.JPanel();
        lblApprovedBookingsIcon = new javax.swing.JLabel();
        lblApproved = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Montserrat", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pending Bookings");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(102, 153, 255));

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

        tblBookings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Email", "Car Registration", "Vehicle Type", "Wash Type", "Date", "Time", "Booking outcome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblBookings.setRowHeight(25);
        tblBookings.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblBookings);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
        );

        jPanel12.setOpaque(false);
        jPanel12.setLayout(new javax.swing.BoxLayout(jPanel12, javax.swing.BoxLayout.LINE_AXIS));

        jPanel5.setOpaque(false);

        jPanel6.setBackground(new java.awt.Color(102, 102, 102));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Control Panel");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        pnlControlPanel.setOpaque(false);
        pnlControlPanel.setLayout(new java.awt.GridLayout(1, 0));

        pnlView.setOpaque(false);

        lblViewIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblViewIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/g3937.png"))); // NOI18N
        lblViewIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblViewIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblViewIconMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblViewIconMousePressed(evt);
            }
        });

        lblView.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        lblView.setForeground(new java.awt.Color(255, 255, 255));
        lblView.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblView.setText("View Users");
        lblView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblViewMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblViewMouseExited(evt);
            }
        });

        javax.swing.GroupLayout pnlViewLayout = new javax.swing.GroupLayout(pnlView);
        pnlView.setLayout(pnlViewLayout);
        pnlViewLayout.setHorizontalGroup(
            pnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblViewIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
            .addComponent(lblView, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
        );
        pnlViewLayout.setVerticalGroup(
            pnlViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlViewLayout.createSequentialGroup()
                .addComponent(lblViewIcon)
                .addGap(2, 2, 2)
                .addComponent(lblView)
                .addGap(0, 0, 0))
        );

        pnlControlPanel.add(pnlView);

        pnlReject.setOpaque(false);
        pnlReject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlRejectMousePressed(evt);
            }
        });

        lblRejectIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRejectIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/path1829.png"))); // NOI18N
        lblRejectIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRejectIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRejectIconMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRejectIconMousePressed(evt);
            }
        });

        lblReject.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        lblReject.setForeground(new java.awt.Color(255, 255, 255));
        lblReject.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblReject.setText("Delete/Reject");
        lblReject.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblRejectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblRejectMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRejectMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlRejectLayout = new javax.swing.GroupLayout(pnlReject);
        pnlReject.setLayout(pnlRejectLayout);
        pnlRejectLayout.setHorizontalGroup(
            pnlRejectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRejectIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
            .addComponent(lblReject, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
        );
        pnlRejectLayout.setVerticalGroup(
            pnlRejectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRejectLayout.createSequentialGroup()
                .addComponent(lblRejectIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblReject)
                .addGap(0, 0, 0))
        );

        pnlControlPanel.add(pnlReject);

        pnlApprove.setOpaque(false);
        pnlApprove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlApproveMousePressed(evt);
            }
        });

        lblApproveIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApproveIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/g2055.png"))); // NOI18N
        lblApproveIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblApproveIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblApproveIconMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblApproveIconMousePressed(evt);
            }
        });

        lblApprove.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        lblApprove.setForeground(new java.awt.Color(255, 255, 255));
        lblApprove.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApprove.setText("Approve");
        lblApprove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblApproveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblApproveMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblApproveMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlApproveLayout = new javax.swing.GroupLayout(pnlApprove);
        pnlApprove.setLayout(pnlApproveLayout);
        pnlApproveLayout.setHorizontalGroup(
            pnlApproveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblApproveIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
            .addComponent(lblApprove, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
        );
        pnlApproveLayout.setVerticalGroup(
            pnlApproveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlApproveLayout.createSequentialGroup()
                .addComponent(lblApproveIcon)
                .addGap(2, 2, 2)
                .addComponent(lblApprove)
                .addGap(0, 0, 0))
        );

        pnlControlPanel.add(pnlApprove);

        pnlApprovedBookings.setOpaque(false);
        pnlApprovedBookings.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pnlApprovedBookingsMousePressed(evt);
            }
        });

        lblApprovedBookingsIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApprovedBookingsIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/g2389.png"))); // NOI18N
        lblApprovedBookingsIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblApprovedBookingsIconMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblApprovedBookingsIconMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblApprovedBookingsIconMousePressed(evt);
            }
        });

        lblApproved.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        lblApproved.setForeground(new java.awt.Color(255, 255, 255));
        lblApproved.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblApproved.setText("Approved Bookings");
        lblApproved.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblApprovedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblApprovedMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblApprovedMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlApprovedBookingsLayout = new javax.swing.GroupLayout(pnlApprovedBookings);
        pnlApprovedBookings.setLayout(pnlApprovedBookingsLayout);
        pnlApprovedBookingsLayout.setHorizontalGroup(
            pnlApprovedBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblApprovedBookingsIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblApproved, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlApprovedBookingsLayout.setVerticalGroup(
            pnlApprovedBookingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlApprovedBookingsLayout.createSequentialGroup()
                .addComponent(lblApprovedBookingsIcon)
                .addGap(2, 2, 2)
                .addComponent(lblApproved)
                .addGap(0, 0, 0))
        );

        pnlControlPanel.add(pnlApprovedBookings);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlControlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(pnlControlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jPanel12.add(jPanel5);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(196, 196, 196)
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(62, 62, 62)
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogout)
                        .addGap(42, 42, 42))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblViewIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewIconMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblViewIconMouseEntered

    private void lblViewIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewIconMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblViewIconMouseExited

    private void lblRejectIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRejectIconMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblRejectIconMouseEntered

    private void lblRejectIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRejectIconMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblRejectIconMouseExited

    private void lblApproveIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblApproveIconMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblApproveIconMouseEntered

    private void lblApproveIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblApproveIconMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblApproveIconMouseExited

    private void lblApprovedBookingsIconMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblApprovedBookingsIconMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblApprovedBookingsIconMouseEntered

    private void lblApprovedBookingsIconMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblApprovedBookingsIconMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblApprovedBookingsIconMouseExited

    private void lblApprovedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblApprovedMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblApprovedMouseEntered

    private void lblApprovedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblApprovedMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblApprovedMouseExited

    private void lblApproveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblApproveMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblApproveMouseEntered

    private void lblApproveMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblApproveMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblApproveMouseExited

    private void lblRejectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRejectMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblRejectMouseEntered

    private void lblRejectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRejectMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblRejectMouseExited

    private void lblViewMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblViewMouseEntered

    private void lblViewMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_lblViewMouseExited

    private void pnlApprovedBookingsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlApprovedBookingsMousePressed
frmApprovedBookings frmAB = new frmApprovedBookings();
frmAB.show();
this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_pnlApprovedBookingsMousePressed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
frmLogin frmL = new frmLogin();
frmL.show();
this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
mViewBookings();
// TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void lblApproveIconMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblApproveIconMousePressed
     
    if(tblBookings.getSelectedRowCount() != 1)
        {
            JOptionPane.showMessageDialog(null, "Please select a row to perform this action");
        }
        else
        {
            mUpdateBookingOutcome();
        }// TODO add your handling code here:
    }//GEN-LAST:event_lblApproveIconMousePressed

    private void lblApproveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblApproveMousePressed
     
     if(tblBookings.getSelectedRowCount() != 1)
        {
            JOptionPane.showMessageDialog(null, "Please select a row to perform this action");
        }
        else
        {
            mUpdateBookingOutcome();
        }// TODO add your handling code here:
    }//GEN-LAST:event_lblApproveMousePressed

    private void pnlApproveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlApproveMousePressed

if(tblBookings.getSelectedRowCount() != 1)
        {
            JOptionPane.showMessageDialog(null, "Please select a row to perform this action");
        }
        else
        {
            mUpdateBookingOutcome();
        }// TODO add your handling code here:
    }//GEN-LAST:event_pnlApproveMousePressed

    private void lblRejectIconMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRejectIconMousePressed

if(tblBookings.getSelectedRowCount() != 1)
        {
            JOptionPane.showMessageDialog(null, "Please select a row to perform this action");
        }
        else
        {
            mDeleteBooking();
        }// TODO add your handling code here:
    }//GEN-LAST:event_lblRejectIconMousePressed

    private void lblRejectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRejectMousePressed

if(tblBookings.getSelectedRowCount() != 1)
        {
            JOptionPane.showMessageDialog(null, "Please select a row to perform this action");
        }
        else
        {
            mDeleteBooking(); 
        }// TODO add your handling code here:
    }//GEN-LAST:event_lblRejectMousePressed

    private void pnlRejectMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlRejectMousePressed

if(tblBookings.getSelectedRowCount() != 1)
        {
            JOptionPane.showMessageDialog(null, "Please select a row to perform this action");
        }
        else
        {
            mDeleteBooking(); 
        }// TODO add your handling code here:
    }//GEN-LAST:event_pnlRejectMousePressed

    private void lblViewIconMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblViewIconMousePressed

if(tblBookings.getSelectedRowCount() != 1)
        {
            JOptionPane.showMessageDialog(null, "Please select a row to perform this action");
        }
        else
        {
            frmUsers frmU = new frmUsers();
frmU.show();
this.dispose();
        }// TODO add your handling code here:
    }//GEN-LAST:event_lblViewIconMousePressed

    private void lblApprovedBookingsIconMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblApprovedBookingsIconMousePressed

if(tblBookings.getSelectedRowCount() != 1)
        {
            JOptionPane.showMessageDialog(null, "Please select a row to perform this action");
        }
        else
        {
            frmApprovedBookings frmAB = new frmApprovedBookings();
frmAB.show();
this.dispose();
        }// TODO add your handling code here:
    }//GEN-LAST:event_lblApprovedBookingsIconMousePressed

    private void lblApprovedMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblApprovedMousePressed

if(tblBookings.getSelectedRowCount() != 1)
        {
            JOptionPane.showMessageDialog(null, "Please select a row to perform this action");
        }
        else
        {
            frmApprovedBookings frmAB = new frmApprovedBookings();
frmAB.show();
this.dispose();
        }// TODO add your handling code here:
    }//GEN-LAST:event_lblApprovedMousePressed

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
            java.util.logging.Logger.getLogger(frmPendingBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPendingBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPendingBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPendingBookings.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPendingBookings().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApprove;
    private javax.swing.JLabel lblApproveIcon;
    private javax.swing.JLabel lblApproved;
    private javax.swing.JLabel lblApprovedBookingsIcon;
    private javax.swing.JLabel lblReject;
    private javax.swing.JLabel lblRejectIcon;
    private javax.swing.JLabel lblView;
    private javax.swing.JLabel lblViewIcon;
    private javax.swing.JPanel pnlApprove;
    private javax.swing.JPanel pnlApprovedBookings;
    private javax.swing.JPanel pnlControlPanel;
    private javax.swing.JPanel pnlReject;
    private javax.swing.JPanel pnlView;
    private javax.swing.JTable tblBookings;
    // End of variables declaration//GEN-END:variables
}
