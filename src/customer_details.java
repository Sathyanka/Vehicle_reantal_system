/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author USER
 */

import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import controls.Database;
import controls.ListItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class customer_details extends javax.swing.JFrame {
  
    public int ve_id = 1;
    public int v_id = 0;
    public int customer_regno;
    public int phone;
    int reg;

    
    Connection con;
    PreparedStatement pst;
    private Object user_type;
    /**
     * Creates new form customer_details
     */
    public customer_details() {
         initComponents();
         
         con=SQLCON.connect();
         load_cmbcsst_regno();
         
        //customer_details.setVisible(false);
        pncustomerr_details.setVisible(false);
        pnlvehicle_details.setVisible(false);
        
        pnltable.setVisible(true);
        btnupdate.setVisible(false);
        btndelete.setVisible(false);
        btnExit.setVisible(false);
        btnback2.setVisible(false);
        txtname.setEditable(false);
        txtaddress.setEditable(true);
        txtreleas_date.setEditable(true);
        btnback2.setVisible(false);

       load_customer_table();
        
        
         try
        {
            Statement st =con.createStatement();
            
            String sql = "select * from customer_details";
            ResultSet rs=st.executeQuery(sql);
            
            while(rs.next())
            {
                txtcustomer_regno.getText();
            }
            
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
     private ArrayList<ListItem> combo(String query, String col_ID, String col_Name) throws Exception {
        ArrayList<ListItem> names = new ArrayList<>();
        Statement stmt = Database.getCon().createStatement();
        ResultSet rset = stmt.executeQuery(query);
        while (rset.next()) {
            ListItem item = new ListItem();
            item.setId(rset.getInt(col_ID));
            item.setName(rset.getString(col_Name));
            names.add(item);
        }
        return names;
    }
    
     private void load_customer_table() {
     try {
            
            Statement st=con.createStatement();
            int stes=0;
            DefaultTableModel table_model= (DefaultTableModel)tblcustomer_details.getModel();
         
            String sql="SELECT customer_details.customer_regno,customer_details.name,customer_details.nic,customer_details.address,customer_details.phone,customer_details.rented_date,customer_details.releas_date,customer_details.vehi_reg_no FROM customer_details WHERE customer_details.states='"+stes+"'  ORDER BY customer_details.customer_regno DESC";
           ResultSet rs=st.executeQuery(sql);
            
            table_model.setRowCount(0);
            while (rs.next()) {
                ArrayList arrList = new ArrayList();
                arrList.add(rs.getString("customer_regno"));
                arrList.add(rs.getString("name"));
                arrList.add(rs.getString("nic"));
                arrList.add(rs.getString("address"));
                arrList.add(rs.getString("phone"));
                arrList.add(rs.getString("rented_date"));
                arrList.add(rs.getString("releas_date"));
                arrList.add(rs.getString("vehi_reg_no"));
                
                table_model.addRow(arrList.toArray());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
     
     
    private void clear() {
       
        txtcustomer_regno.requestFocus();
        txtcustomer_regno.setText("");
        txtname.setText("");
        txtnic.setText("");
        txtaddress.setText("");
        txtphone.setText("");
        txtrented_date.setText("");
        txtreleas_date.setText("");
        txtvehireg_no.setText("");
        txtvehicle_name.setText("");
        txtmodel.setText("");
        txtnumber.setText("");
        txtyear.setText("");
        txtseats.setText("");
        txttype.setText("");
    }
     private void  load_cmbcsst_regno(){
    try {
            

            String query = "SELECT customer_details.customer_regno,customer_details.name FROM customer_details ORDER BY customer_details.customer_regno DESC";
            ArrayList<controls.ListItem> itemsList = combo(query, "customer_regno", "name");
            DefaultComboBoxModel def = new DefaultComboBoxModel(itemsList.toArray());
           cmbcust_regno.setModel(def);
            //check_user_type();
        } catch(Exception e)
                {
                            JOptionPane.showMessageDialog(null,e);
                        }
    
}
     
     private void selectcmb(){
        
         try {
            ListItem user_type = (ListItem) cmbcust_regno.getSelectedItem();
            reg = user_type.getId();
           // load_customer_table(reg);
          //  load_pat_details(reg);
        } catch (Exception ex) {
            ex.printStackTrace();
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

        lbldisplay = new javax.swing.JLabel();
        customer_details = new javax.swing.JPanel();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        pncustomerr_details = new javax.swing.JPanel();
        lblcustomer_details = new javax.swing.JLabel();
        lblname = new javax.swing.JLabel();
        txtname = new javax.swing.JTextField();
        lblnic = new javax.swing.JLabel();
        lbladress = new javax.swing.JLabel();
        txtaddress = new javax.swing.JTextField();
        lblphone = new javax.swing.JLabel();
        txtphone = new javax.swing.JTextField();
        txtrented_date = new javax.swing.JTextField();
        txtreleas_date = new javax.swing.JTextField();
        txtnic = new javax.swing.JTextField();
        lblcustomer_regno = new javax.swing.JLabel();
        txtcustomer_regno = new javax.swing.JTextField();
        lblreted_date = new javax.swing.JLabel();
        lblreleas_date1 = new javax.swing.JLabel();
        cmbcust_regno = new javax.swing.JComboBox();
        lbltot_display = new javax.swing.JLabel();
        lbladvance = new javax.swing.JLabel();
        lbldeposit2 = new javax.swing.JLabel();
        lblcost = new javax.swing.JLabel();
        lbltotdays = new javax.swing.JLabel();
        lblpayment = new javax.swing.JLabel();
        lblcos_display = new javax.swing.JLabel();
        txtpackege = new javax.swing.JTextField();
        lbltot = new javax.swing.JLabel();
        txtbalance = new javax.swing.JTextField();
        btnpay = new javax.swing.JButton();
        pnlvehicle_details = new javax.swing.JPanel();
        lblmodel = new javax.swing.JLabel();
        lblyear = new javax.swing.JLabel();
        lblno = new javax.swing.JLabel();
        lblveviclename = new javax.swing.JLabel();
        txtvehicle_name = new javax.swing.JTextField();
        txtmodel = new javax.swing.JTextField();
        txtyear = new javax.swing.JTextField();
        txtnumber = new javax.swing.JTextField();
        lblregno = new javax.swing.JLabel();
        txtvehireg_no = new javax.swing.JTextField();
        txtdriven = new javax.swing.JTextField();
        lblseats = new javax.swing.JLabel();
        txtseats = new javax.swing.JTextField();
        lbltype = new javax.swing.JLabel();
        btnvehi_details = new javax.swing.JButton();
        lblvehicle_detils = new javax.swing.JLabel();
        txttype = new javax.swing.JTextField();
        btnback2 = new javax.swing.JButton();
        pnltable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblcustomer_details = new javax.swing.JTable();
        btnback1 = new javax.swing.JButton();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer Details");
        setPreferredSize(new java.awt.Dimension(950, 625));
        setResizable(false);
        getContentPane().setLayout(null);

        lbldisplay.setFont(new java.awt.Font("Stencil", 2, 36)); // NOI18N
        lbldisplay.setForeground(new java.awt.Color(102, 255, 255));
        lbldisplay.setText("VEhicle Rental System");
        getContentPane().add(lbldisplay);
        lbldisplay.setBounds(300, 20, 450, 50);

        customer_details.setMinimumSize(new java.awt.Dimension(700, 600));
        customer_details.setOpaque(false);
        customer_details.setLayout(null);

        btnupdate.setBackground(new java.awt.Color(153, 0, 0));
        btnupdate.setForeground(new java.awt.Color(153, 255, 0));
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        customer_details.add(btnupdate);
        btnupdate.setBounds(580, 550, 90, 23);

        btndelete.setBackground(new java.awt.Color(153, 0, 0));
        btndelete.setForeground(new java.awt.Color(153, 255, 0));
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        customer_details.add(btndelete);
        btndelete.setBounds(690, 550, 80, 23);

        btnExit.setBackground(new java.awt.Color(153, 0, 0));
        btnExit.setForeground(new java.awt.Color(153, 255, 0));
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        customer_details.add(btnExit);
        btnExit.setBounds(800, 550, 61, 23);

        pncustomerr_details.setBackground(new java.awt.Color(104, 94, 137));
        pncustomerr_details.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        pncustomerr_details.setOpaque(false);

        lblcustomer_details.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblcustomer_details.setForeground(new java.awt.Color(204, 204, 255));
        lblcustomer_details.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcustomer_details.setText("Coustomer details");
        lblcustomer_details.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblname.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblname.setForeground(new java.awt.Color(255, 255, 255));
        lblname.setText("Name :");

        txtname.setEditable(false);
        txtname.setBackground(new java.awt.Color(204, 204, 255));

        lblnic.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblnic.setForeground(new java.awt.Color(255, 255, 255));
        lblnic.setText("NIC :");

        lbladress.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladress.setForeground(new java.awt.Color(255, 255, 255));
        lbladress.setText("Adress :");

        txtaddress.setEditable(false);
        txtaddress.setBackground(new java.awt.Color(204, 204, 255));
        txtaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtaddressActionPerformed(evt);
            }
        });

        lblphone.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblphone.setForeground(new java.awt.Color(255, 255, 255));
        lblphone.setText("Phone NO. :");

        txtphone.setEditable(false);
        txtphone.setBackground(new java.awt.Color(204, 204, 255));
        txtphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtphoneActionPerformed(evt);
            }
        });

        txtrented_date.setEditable(false);
        txtrented_date.setBackground(new java.awt.Color(204, 204, 255));

        txtreleas_date.setEditable(false);
        txtreleas_date.setBackground(new java.awt.Color(204, 204, 255));

        txtnic.setEditable(false);
        txtnic.setBackground(new java.awt.Color(204, 204, 255));
        txtnic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnicActionPerformed(evt);
            }
        });

        lblcustomer_regno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblcustomer_regno.setForeground(new java.awt.Color(255, 255, 255));
        lblcustomer_regno.setText("Customer Reg No :");

        txtcustomer_regno.setEditable(false);
        txtcustomer_regno.setBackground(new java.awt.Color(204, 204, 255));

        lblreted_date.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblreted_date.setForeground(new java.awt.Color(255, 255, 255));
        lblreted_date.setText("Rented date :");

        lblreleas_date1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblreleas_date1.setForeground(new java.awt.Color(255, 255, 255));
        lblreleas_date1.setText("Releas date :");

        cmbcust_regno.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbcust_regnoItemStateChanged(evt);
            }
        });
        cmbcust_regno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbcust_regnoActionPerformed(evt);
            }
        });

        lbltot_display.setForeground(new java.awt.Color(255, 255, 255));
        lbltot_display.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lbladvance.setForeground(new java.awt.Color(255, 255, 255));
        lbladvance.setText("Advance :");

        lbldeposit2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbldeposit2.setForeground(new java.awt.Color(153, 0, 0));
        lbldeposit2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldeposit2.setText("Rs. 6000 for 24");

        lblcost.setForeground(new java.awt.Color(255, 255, 255));
        lblcost.setText("Cost :");

        lbltotdays.setForeground(new java.awt.Color(255, 255, 255));
        lbltotdays.setText("Total days :");

        lblpayment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblpayment.setForeground(new java.awt.Color(0, 255, 51));
        lblpayment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblpayment.setText("Payment Details");
        lblpayment.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblcos_display.setForeground(new java.awt.Color(255, 255, 255));
        lblcos_display.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtpackege.setBackground(new java.awt.Color(204, 204, 255));

        lbltot.setForeground(new java.awt.Color(255, 255, 255));
        lbltot.setText("Balance : ");

        btnpay.setBackground(new java.awt.Color(102, 0, 0));
        btnpay.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnpay.setForeground(new java.awt.Color(204, 255, 0));
        btnpay.setText("Pay");
        btnpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pncustomerr_detailsLayout = new javax.swing.GroupLayout(pncustomerr_details);
        pncustomerr_details.setLayout(pncustomerr_detailsLayout);
        pncustomerr_detailsLayout.setHorizontalGroup(
            pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pncustomerr_detailsLayout.createSequentialGroup()
                .addGroup(pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pncustomerr_detailsLayout.createSequentialGroup()
                        .addGroup(pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pncustomerr_detailsLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblname, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblnic, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbladress, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblphone, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblreted_date)
                                    .addComponent(lblreleas_date1))
                                .addGap(42, 42, 42))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pncustomerr_detailsLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbltotdays, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblcost, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbladvance, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbltot, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pncustomerr_detailsLayout.createSequentialGroup()
                                .addGroup(pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblcos_display, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtpackege)
                                    .addComponent(txtbalance, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnpay, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pncustomerr_detailsLayout.createSequentialGroup()
                                .addComponent(lbltot_display, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbldeposit2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pncustomerr_detailsLayout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(lblcustomer_details, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pncustomerr_detailsLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblcustomer_regno)
                        .addGap(18, 18, 18)
                        .addGroup(pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtname, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(pncustomerr_detailsLayout.createSequentialGroup()
                                        .addComponent(txtcustomer_regno, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(cmbcust_regno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(txtnic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtrented_date, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtreleas_date, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pncustomerr_detailsLayout.setVerticalGroup(
            pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pncustomerr_detailsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblcustomer_details)
                .addGroup(pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pncustomerr_detailsLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblcustomer_regno, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtcustomer_regno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pncustomerr_detailsLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(cmbcust_regno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblname)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblnic)
                    .addComponent(txtnic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbladress)
                    .addComponent(txtaddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblphone))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtrented_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblreted_date, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblreleas_date1)
                    .addComponent(txtreleas_date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(lblpayment, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pncustomerr_detailsLayout.createSequentialGroup()
                        .addGroup(pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pncustomerr_detailsLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(lbltot_display, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbldeposit2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pncustomerr_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pncustomerr_detailsLayout.createSequentialGroup()
                                .addComponent(lblcos_display, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtpackege, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtbalance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnpay)))
                    .addGroup(pncustomerr_detailsLayout.createSequentialGroup()
                        .addComponent(lbltotdays)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblcost)
                        .addGap(18, 18, 18)
                        .addComponent(lbladvance)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbltot)))
                .addGap(20, 72, Short.MAX_VALUE))
        );

        customer_details.add(pncustomerr_details);
        pncustomerr_details.setBounds(39, 67, 422, 499);

        pnlvehicle_details.setBackground(new java.awt.Color(104, 94, 137));
        pnlvehicle_details.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        pnlvehicle_details.setOpaque(false);

        lblmodel.setBackground(new java.awt.Color(255, 255, 255));
        lblmodel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblmodel.setForeground(new java.awt.Color(255, 255, 255));
        lblmodel.setText("Model :");

        lblyear.setBackground(new java.awt.Color(255, 255, 255));
        lblyear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblyear.setForeground(new java.awt.Color(255, 255, 255));
        lblyear.setText("Year :");

        lblno.setBackground(new java.awt.Color(255, 255, 255));
        lblno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblno.setForeground(new java.awt.Color(255, 255, 255));
        lblno.setText("Number :");

        lblveviclename.setBackground(new java.awt.Color(255, 255, 255));
        lblveviclename.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblveviclename.setForeground(new java.awt.Color(255, 255, 255));
        lblveviclename.setText("Name :");

        txtvehicle_name.setEditable(false);
        txtvehicle_name.setBackground(new java.awt.Color(204, 204, 255));
        txtvehicle_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvehicle_nameActionPerformed(evt);
            }
        });

        txtmodel.setEditable(false);
        txtmodel.setBackground(new java.awt.Color(204, 204, 255));

        txtyear.setEditable(false);
        txtyear.setBackground(new java.awt.Color(204, 204, 255));

        txtnumber.setEditable(false);
        txtnumber.setBackground(new java.awt.Color(204, 204, 255));
        txtnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumberActionPerformed(evt);
            }
        });

        lblregno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblregno.setForeground(new java.awt.Color(255, 255, 255));
        lblregno.setText("Vehicle Reg. NO :");

        txtvehireg_no.setEditable(false);
        txtvehireg_no.setBackground(new java.awt.Color(204, 204, 255));
        txtvehireg_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvehireg_noActionPerformed(evt);
            }
        });

        txtdriven.setBackground(new java.awt.Color(204, 204, 255));

        lblseats.setBackground(new java.awt.Color(255, 255, 255));
        lblseats.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblseats.setForeground(new java.awt.Color(255, 255, 255));
        lblseats.setText("Seats :");

        txtseats.setEditable(false);
        txtseats.setBackground(new java.awt.Color(204, 204, 255));

        lbltype.setBackground(new java.awt.Color(255, 255, 255));
        lbltype.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbltype.setForeground(new java.awt.Color(255, 255, 255));
        lbltype.setText("Type :");

        btnvehi_details.setText("jButton1");
        btnvehi_details.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvehi_detailsActionPerformed(evt);
            }
        });

        lblvehicle_detils.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblvehicle_detils.setForeground(new java.awt.Color(255, 255, 255));
        lblvehicle_detils.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblvehicle_detils.setText("Vehicle Details");

        txttype.setEditable(false);
        txttype.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout pnlvehicle_detailsLayout = new javax.swing.GroupLayout(pnlvehicle_details);
        pnlvehicle_details.setLayout(pnlvehicle_detailsLayout);
        pnlvehicle_detailsLayout.setHorizontalGroup(
            pnlvehicle_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlvehicle_detailsLayout.createSequentialGroup()
                .addGroup(pnlvehicle_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlvehicle_detailsLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(pnlvehicle_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlvehicle_detailsLayout.createSequentialGroup()
                                .addGroup(pnlvehicle_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblveviclename, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblno, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlvehicle_detailsLayout.createSequentialGroup()
                                        .addGroup(pnlvehicle_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblyear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblseats, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbltype, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(13, 13, 13)))
                                .addGroup(pnlvehicle_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlvehicle_detailsLayout.createSequentialGroup()
                                        .addGap(731, 731, 731)
                                        .addComponent(txtdriven, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlvehicle_detailsLayout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(pnlvehicle_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtmodel, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtvehicle_name, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtseats, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txttype, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(pnlvehicle_detailsLayout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(lblvehicle_detils, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(157, 157, 157)
                                .addComponent(btnvehi_details))
                            .addComponent(lblmodel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlvehicle_detailsLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblregno, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtvehireg_no, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlvehicle_detailsLayout.setVerticalGroup(
            pnlvehicle_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlvehicle_detailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlvehicle_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnvehi_details)
                    .addComponent(lblvehicle_detils))
                .addGap(18, 18, 18)
                .addGroup(pnlvehicle_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblregno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtvehireg_no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(pnlvehicle_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtvehicle_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblveviclename))
                .addGap(27, 27, 27)
                .addGroup(pnlvehicle_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmodel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblmodel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(pnlvehicle_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblno)
                    .addComponent(txtnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(pnlvehicle_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblyear)
                    .addComponent(txtyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(pnlvehicle_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlvehicle_detailsLayout.createSequentialGroup()
                        .addComponent(txtdriven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlvehicle_detailsLayout.createSequentialGroup()
                        .addGroup(pnlvehicle_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtseats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblseats))
                        .addGap(40, 40, 40)
                        .addGroup(pnlvehicle_detailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbltype))
                        .addGap(99, 99, 99))))
        );

        customer_details.add(pnlvehicle_details);
        pnlvehicle_details.setBounds(489, 67, 391, 470);

        btnback2.setBackground(new java.awt.Color(153, 0, 0));
        btnback2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnback2.setForeground(new java.awt.Color(153, 255, 0));
        btnback2.setText("back");
        btnback2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnback2ActionPerformed(evt);
            }
        });
        customer_details.add(btnback2);
        btnback2.setBounds(490, 550, 70, 22);

        getContentPane().add(customer_details);
        customer_details.setBounds(10, 10, 960, 600);

        pnltable.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204)));
        pnltable.setOpaque(false);
        pnltable.setLayout(null);

        tblcustomer_details.setBackground(new java.awt.Color(153, 153, 255));
        tblcustomer_details.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "customer_regno", "name", "nic", "address", "phone", "rented_date", "releas_date", "vehi_reg_no"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblcustomer_details.setOpaque(false);
        tblcustomer_details.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblcustomer_detailsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblcustomer_details);
        if (tblcustomer_details.getColumnModel().getColumnCount() > 0) {
            tblcustomer_details.getColumnModel().getColumn(0).setResizable(false);
            tblcustomer_details.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblcustomer_details.getColumnModel().getColumn(1).setResizable(false);
            tblcustomer_details.getColumnModel().getColumn(2).setResizable(false);
            tblcustomer_details.getColumnModel().getColumn(3).setResizable(false);
            tblcustomer_details.getColumnModel().getColumn(4).setResizable(false);
            tblcustomer_details.getColumnModel().getColumn(5).setResizable(false);
            tblcustomer_details.getColumnModel().getColumn(6).setResizable(false);
            tblcustomer_details.getColumnModel().getColumn(7).setResizable(false);
        }

        pnltable.add(jScrollPane1);
        jScrollPane1.setBounds(80, 150, 680, 130);

        btnback1.setBackground(new java.awt.Color(0, 102, 102));
        btnback1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnback1.setForeground(new java.awt.Color(255, 255, 255));
        btnback1.setText("back");
        btnback1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnback1ActionPerformed(evt);
            }
        });
        pnltable.add(btnback1);
        btnback1.setBounds(80, 40, 80, 30);

        getContentPane().add(pnltable);
        pnltable.setBounds(63, 86, 820, 400);

        lblbackground.setBackground(new java.awt.Color(99, 3, 46));
        lblbackground.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblbackground.setForeground(new java.awt.Color(204, 204, 255));
        lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.jpg"))); // NOI18N
        lblbackground.setPreferredSize(new java.awt.Dimension(1000, 600));
        getContentPane().add(lblbackground);
        lblbackground.setBounds(0, 0, 1020, 630);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblcustomer_detailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblcustomer_detailsMouseClicked
        // TODO add your handling code here:
       
        if (evt.getClickCount() == 2) {
            
       customer_details.setVisible(true);
        pncustomerr_details.setVisible(true);
        pnlvehicle_details.setVisible(true);
        pnltable.setVisible(false);
        pncustomerr_details.setVisible(true);
       btnupdate.setVisible(true);
         btndelete.setVisible(true);
          btnExit.setVisible(true);
        customer_details.setVisible(true);
        btnback2.setVisible(true);
        //cust_regno = Integer.valueOf(tblcustomer_details.getValueAt(tblcustomer_details.getSelectedRow(), 0).toString());
       customer_regno = Integer.valueOf(tblcustomer_details.getValueAt(tblcustomer_details.getSelectedRow(), 0).toString());
       txtcustomer_regno.setText(String.valueOf(customer_regno ));
       txtname.requestFocus();
        
       try
        {
            Statement st=con.createStatement();
            String no=txtcustomer_regno.getText();

            String sql="SELECT * FROM customer_details WHERE customer_regno='"+no+"'";
            ResultSet rs=st.executeQuery(sql);

            if(rs.next()==false)
            {
                JOptionPane.showMessageDialog(null, "Invalid rgister number");
            }
            String name=rs.getString("name");
            txtname.setText(name);

            String address=rs.getString("address");
            txtaddress.setText(address);
            
             String nic=rs.getString("nic");
            txtnic.setText(nic);
            
            int phone =rs.getInt("phone");
            txtphone.setText(String.valueOf(phone));

            String rented=rs.getString("rented_date");
            txtrented_date.setText(rented);
            
             String releas=rs.getString("releas_date");
            txtreleas_date.setText(releas);
            
            int vehi_regno =rs.getInt("vehi_reg_no");
            txtvehireg_no.setText(String.valueOf(vehi_regno));
            
            
            try
        {
            Statement st1=con.createStatement();
            String vehi_regno1=txtvehireg_no.getText();

            String sql2="SELECT * FROM vehicle_details WHERE vehi_reg_no='"+vehi_regno1+"'";
            ResultSet res=st1.executeQuery(sql2);

            if(res.next()==false)
            {
                JOptionPane.showMessageDialog(null, "Inavalid  vehicle registr number");
            }
            String name1=res.getString("name");
            txtvehicle_name.setText(name1);

            String model=res.getString("model");
            txtmodel.setText(model);
            
             int year =res.getInt("year");
            txtyear.setText(String.valueOf(year));
            
            
            String number=res.getString("number");
            txtnumber.setText(number);
            
            String seats=res.getString("seats");
            txtseats.setText(seats);
            
            String type=res.getString("type");
            txttype.setText(type);
            
            
           
            
            
       } 
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
            
            
         
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
       
        }
        
        
          
            
            
            
    }//GEN-LAST:event_tblcustomer_detailsMouseClicked

    private void btnback1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnback1ActionPerformed
        // TODO add your handling code here:
        new dashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnback1ActionPerformed

    private void btnvehi_detailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvehi_detailsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnvehi_detailsActionPerformed

    private void txtvehireg_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvehireg_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvehireg_noActionPerformed

    private void txtnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumberActionPerformed

    private void txtvehicle_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvehicle_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvehicle_nameActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
         this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
              txtcustomer_regno.setEditable(true);
              txtname.setEditable(true);
              txtaddress.setEditable(true);
              txtreleas_date.setEditable(true);
              String reg=txtcustomer_regno.getText();
              String name=txtname.getText();
              String address=txtaddress.getText();
              String releas_date=txtreleas_date.getText();
                   String sql="UPDATE customer_details SET customer_regno=?,name=?,address=?,releas_date=? WHERE rg_no='"+reg+"'";
                   
                    try{
                  pst=con.prepareStatement(sql);
                  pst.setString(1,txtcustomer_regno.getText());
                  pst.setString(2,txtname.getText());
                  pst.setString(3,txtaddress.getText());
                  pst.setString(4,txtreleas_date.getText());
                            
                            
                           
                            }
                
            

        catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,e);
       }
         
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
             String vehireg=txtvehireg_no.getText();
             String sql2="UPDATE vehicle_details SET states=? WHERE vehi_reg_no='"+vehireg+"'";
                   
                    try{
                  pst=con.prepareStatement(sql2);
                  pst.setInt(1, v_id);
                   pst.execute();
              JOptionPane.showMessageDialog(null,"Succsessfull");
                    }
                     catch (Exception e) {
            
            JOptionPane.showMessageDialog(null,e);
       }
        
        
        
        String reg=txtcustomer_regno.getText();
        String sql="DELETE FROM customer_details WHERE customer_regno='"+reg+"'";
        try
        {
            pst=con.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Successfully Delete");
            
          
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
            
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnback2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnback2ActionPerformed
        // TODO add your handling code here:
        
         pncustomerr_details.setVisible(false);
        pnlvehicle_details.setVisible(false);
        pnltable.setVisible(true);
        btnupdate.setVisible(false);
         btndelete.setVisible(false);
          btnExit.setVisible(false);
          btnback2.setVisible(false);
          
       load_customer_table();
    }//GEN-LAST:event_btnback2ActionPerformed

    private void btnpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpayActionPerformed
        // TODO add your handling code here:
        String reg=txtcustomer_regno.getText();
        String sql2="UPDATE customer_details SET states=? WHERE customer_regno='"+reg+"'";

        try{
            pst=con.prepareStatement(sql2);
            pst.setInt(1, ve_id);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Succsessfull");
            
            String vehi_reg=txtvehireg_no.getText();
            String sql3="UPDATE vehicle_details SET states=? WHERE vehi_reg_no='"+vehi_reg+"'";

        try{
            pst=con.prepareStatement(sql3);
            pst.setInt(1, v_id);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Succsessfull");
        }
        catch (Exception e) {

            JOptionPane.showMessageDialog(null,e);
        }
        }
        catch (Exception e) {

            JOptionPane.showMessageDialog(null,e);
        }

    }//GEN-LAST:event_btnpayActionPerformed

    private void cmbcust_regnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbcust_regnoActionPerformed
        // TODO add your handling code here:
        try{

            Statement st=con.createStatement();
            String name1=cmbcust_regno.getSelectedItem().toString();

            String sql="SELECT * FROM customer_details WHERE name='"+name1+"' ORDER BY customer_details.customer_regno DESC ";
            ResultSet rs=st.executeQuery(sql);

            if(rs.next()==false)
            {
                JOptionPane.showMessageDialog(null, "Invalid rgister number");
            }
            String name=rs.getString("name");
            txtname.setText(name);

            String address=rs.getString("address");
            txtaddress.setText(address);

            String nic=rs.getString("nic");
            txtnic.setText(nic);

            int phone =rs.getInt("phone");
            txtphone.setText(String.valueOf(phone));

            String rented=rs.getString("rented_date");
            txtrented_date.setText(rented);

            String releas=rs.getString("releas_date");
            txtreleas_date.setText(releas);

            int vehi_regno =rs.getInt("vehi_reg_no");
            txtvehireg_no.setText(String.valueOf(vehi_regno));

            try
            {
                Statement st1=con.createStatement();
                String vehi_regno1=txtvehireg_no.getText();

                String sql2="SELECT * FROM vehicle_details WHERE vehi_reg_no='"+vehi_regno1+"'";
                ResultSet res=st1.executeQuery(sql2);

                if(res.next()==false)
                {
                    JOptionPane.showMessageDialog(null, "Inavalid  vehicle registr number");
                }
                String name2=res.getString("name");
                txtvehicle_name.setText(name2);

                String model=res.getString("model");
                txtmodel.setText(model);

                int year =res.getInt("year");
                txtyear.setText(String.valueOf(year));

                String number=res.getString("number");
                txtnumber.setText(number);

                String seats=res.getString("seats");
                txtseats.setText(seats);

                String type=res.getString("type");
                txttype.setText(type);

            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }

        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }

    }//GEN-LAST:event_cmbcust_regnoActionPerformed

    private void cmbcust_regnoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbcust_regnoItemStateChanged
        // TODO add your handling code here:
        selectcmb();
        //load_cmbcsst_regno();
    }//GEN-LAST:event_cmbcust_regnoItemStateChanged

    private void txtnicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnicActionPerformed

    private void txtphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtphoneActionPerformed

    private void txtaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtaddressActionPerformed

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
            java.util.logging.Logger.getLogger(customer_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customer_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customer_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customer_details.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new customer_details().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnback1;
    private javax.swing.JButton btnback2;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnpay;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton btnvehi_details;
    private javax.swing.JComboBox cmbcust_regno;
    private javax.swing.JPanel customer_details;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbladress;
    private javax.swing.JLabel lbladvance;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JLabel lblcos_display;
    private javax.swing.JLabel lblcost;
    private javax.swing.JLabel lblcustomer_details;
    private javax.swing.JLabel lblcustomer_regno;
    private javax.swing.JLabel lbldeposit2;
    private javax.swing.JLabel lbldisplay;
    private javax.swing.JLabel lblmodel;
    private javax.swing.JLabel lblname;
    private javax.swing.JLabel lblnic;
    private javax.swing.JLabel lblno;
    private javax.swing.JLabel lblpayment;
    private javax.swing.JLabel lblphone;
    private javax.swing.JLabel lblregno;
    private javax.swing.JLabel lblreleas_date1;
    private javax.swing.JLabel lblreted_date;
    private javax.swing.JLabel lblseats;
    private javax.swing.JLabel lbltot;
    private javax.swing.JLabel lbltot_display;
    private javax.swing.JLabel lbltotdays;
    private javax.swing.JLabel lbltype;
    private javax.swing.JLabel lblvehicle_detils;
    private javax.swing.JLabel lblveviclename;
    private javax.swing.JLabel lblyear;
    private javax.swing.JPanel pncustomerr_details;
    private javax.swing.JPanel pnltable;
    private javax.swing.JPanel pnlvehicle_details;
    private javax.swing.JTable tblcustomer_details;
    private javax.swing.JTextField txtaddress;
    private javax.swing.JTextField txtbalance;
    private javax.swing.JTextField txtcustomer_regno;
    private javax.swing.JTextField txtdriven;
    private javax.swing.JTextField txtmodel;
    private javax.swing.JTextField txtname;
    private javax.swing.JTextField txtnic;
    private javax.swing.JTextField txtnumber;
    private javax.swing.JTextField txtpackege;
    private javax.swing.JTextField txtphone;
    private javax.swing.JTextField txtreleas_date;
    private javax.swing.JTextField txtrented_date;
    private javax.swing.JTextField txtseats;
    private javax.swing.JTextField txttype;
    private javax.swing.JTextField txtvehicle_name;
    private javax.swing.JTextField txtvehireg_no;
    private javax.swing.JTextField txtyear;
    // End of variables declaration//GEN-END:variables


   // private ArrayList<ListItem> combo(String query, String reg_no, String owner_name) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}

    private void load_customer_table(String regno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void load_customer_table(int reg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
