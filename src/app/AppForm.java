/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package app;

import app.data.MenuData;
import app.data.UserData;
import app.models.User;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import app.repositories.UserRepoitory;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;
import raven.toast.Notifications;

/**
 *
 * @author begoingto
 */
public class AppForm extends javax.swing.JFrame {

    private UserRepoitory userRepo;
    private DefaultTableModel tblUserModel;
    private Integer totalUser = 0;
    User user;
    private Integer userIndex;
    private Boolean isDarkTheme = true;
    public String userHome = System.getProperty("user.home");
    String[] columnNames = {"ID", "Username", "Full Name", "Gender", "Password", "Role", "Is Active"};
    Map< String, Object[]> exportData;

    /**
     * Creates new form AppForm
     */
    public AppForm() {
        initComponents();
        this.user = new User();
        this.setLocationRelativeTo(null);
//        this.setResizable(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // set full screen
        cbRole.setSelectedIndex(1);
        exportData = new TreeMap< String, Object[]>();
        exportData.put("1", columnNames);
        tblUserModel = new DefaultTableModel(columnNames, 0);
        initTableData();
        this.tblUser.setModel(tblUserModel);
        txtId.setText("" + (totalUser + 1));
        mUpdate.setEnabled(false);
        mDelete.setEnabled(false);
        mUserPermission.setEnabled(false);
        mSearch.setEnabled(false);
        mExport.setEnabled(true);
        mImport.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas1 = new java.awt.Canvas();
        jPanel1 = new javax.swing.JPanel();
        chStatus = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblUser = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        checkShowPassword = new javax.swing.JCheckBox();
        jLabel7 = new javax.swing.JLabel();
        cbRole = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cbGender = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JTextField();
        txtConfirmPassword = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mReset = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        mAdd = new javax.swing.JMenu();
        mUpdate = new javax.swing.JMenu();
        mDelete = new javax.swing.JMenu();
        mSearch = new javax.swing.JMenu();
        mExport = new javax.swing.JMenu();
        mImport = new javax.swing.JMenu();
        mPrint = new javax.swing.JMenu();
        mUserPermission = new javax.swing.JMenu();
        mTheme = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        chStatus.setSelected(true);
        chStatus.setText("Active");

        jLabel12.setText("ID");

        txtId.setEditable(false);
        txtId.setAutoscrolls(false);
        txtId.setFocusable(false);

        jLabel13.setText("Username");

        jLabel14.setText("Full Name");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(chStatus)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtFullName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .addComponent(txtId)
                    .addComponent(txtUsername))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(chStatus)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        tblUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "Full Name", "Gender", "Password", "Role", "Is Active"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUser.setFocusable(false);
        tblUser.getTableHeader().setReorderingAllowed(false);
        tblUser.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tblUserMouseMoved(evt);
            }
        });
        tblUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblUserMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblUser);

        checkShowPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkShowPasswordActionPerformed(evt);
            }
        });

        jLabel7.setText("Role");
        jLabel7.setPreferredSize(new java.awt.Dimension(24, 30));

        cbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "STUDENT" }));

        jLabel11.setText("Gender");

        cbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel6.setText("Password");

        jLabel15.setText("Confirm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel11)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel15))
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtConfirmPassword)
                    .addComponent(txtPassword)
                    .addComponent(cbGender, 0, 271, Short.MAX_VALUE)
                    .addComponent(cbRole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkShowPassword))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGender, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(checkShowPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtConfirmPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jMenu1.setText("File");

        mReset.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        mReset.setText("Reset");
        mReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mResetMousePressed(evt);
            }
        });
        jMenu1.add(mReset);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, 0));
        jMenuItem1.setText("Quit");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        mAdd.setText("Add New");
        mAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mAddMouseClicked(evt);
            }
        });
        jMenuBar1.add(mAdd);

        mUpdate.setText("Update");
        mUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mUpdateMousePressed(evt);
            }
        });
        jMenuBar1.add(mUpdate);

        mDelete.setText("Delete");
        mDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mDeleteMousePressed(evt);
            }
        });
        jMenuBar1.add(mDelete);

        mSearch.setText("Search");
        jMenuBar1.add(mSearch);

        mExport.setText("Export Excel");
        mExport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mExportMousePressed(evt);
            }
        });
        jMenuBar1.add(mExport);

        mImport.setText("Import Excel");
        mImport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mImportMousePressed(evt);
            }
        });
        mImport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mImportActionPerformed(evt);
            }
        });
        jMenuBar1.add(mImport);

        mPrint.setText(" Print");
        jMenuBar1.add(mPrint);

        mUserPermission.setText("User Permission");
        mUserPermission.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mUserPermissionMouseClicked(evt);
            }
        });
        jMenuBar1.add(mUserPermission);

        mTheme.setText("Theme");
        mTheme.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                mThemeMenuSelected(evt);
            }
        });
        mTheme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mThemeMouseClicked(evt);
            }
        });
        jMenuBar1.add(mTheme);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 908, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void checkShowPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkShowPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkShowPasswordActionPerformed

    private void mAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mAddMouseClicked
        // TODO add your handling code here:
        if (mAdd.isEnabled()) {

            user.setId(Integer.parseInt(this.txtId.getText()));
            user.setUsername(this.txtUsername.getText().trim());
            user.setFullName(this.txtFullName.getText().trim());
            user.setGender(this.cbGender.getSelectedItem().toString());
            user.setPassword(this.txtPassword.getText().trim());
            user.setRole(this.cbRole.getSelectedItem().toString());
            user.setStatus(this.chStatus.isSelected());
            try {
                user = UserData.addUser(user);
                tblUserModel.addRow(new Object[]{
                    user.getId(),
                    user.getUsername(),
                    user.getFullName(),
                    "f".equals(user.getGender()) ? "Female" : "Male",
                    user.getPassword(),
                    user.getRole().toLowerCase(),
                    user.getStatus() ? "True" : "Fale"
                });
                //            JOptionPane.showMessageDialog(rootPane, "You have been add user successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "You have been add user successfully");
                this.clearForm();
            } catch (SQLException ex) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, ex.getMessage());
//                JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Validation", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_mAddMouseClicked

    private void tblUserMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMousePressed
        // TODO add your handling code here:
        int row = tblUser.getSelectedRow();
        this.userIndex = row;
        var id = tblUserModel.getValueAt(row, 0);
        var username = tblUserModel.getValueAt(row, 1);
        var fullName = tblUserModel.getValueAt(row, 2);
        var gender = tblUserModel.getValueAt(row, 3);
        var pwd = tblUserModel.getValueAt(row, 4);
        var role = tblUserModel.getValueAt(row, 5);
        var status = tblUserModel.getValueAt(row, 6);

        txtId.setText(id.toString());
        txtUsername.setText(username.toString());
        txtFullName.setText(fullName.toString());
        txtPassword.setText(pwd.toString());
        txtConfirmPassword.setText(pwd.toString());
        cbGender.setSelectedIndex(gender.equals("Male") ? 0 : 1);
        cbRole.setSelectedIndex(role.equals("student") ? 1 : 0);
        chStatus.setSelected(status.equals("True"));

        user.setId(Integer.parseInt(id.toString()));
        user.setUsername(username.toString());
        user.setFullName(fullName.toString());
        user.setGender(gender.toString());
        user.setPassword(pwd.toString());
        user.setRole(role.toString());
        user.setStatus(status.toString().equals("True"));

        mAdd.setEnabled(false);
        mUpdate.setEnabled(true);
        mDelete.setEnabled(true);
        mUserPermission.setEnabled(true);
    }//GEN-LAST:event_tblUserMousePressed

    private void tblUserMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUserMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_tblUserMouseMoved

    private void mDeleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mDeleteMousePressed
        // TODO add your handling code here:
        if (mDelete.isEnabled()) {
            int choice = JOptionPane.showConfirmDialog(
                    null, // Parent component (null means center on screen)
                    "Do you want to save changes?", // Message to display
                    "Confirmation", // Dialog title
                    JOptionPane.YES_NO_OPTION // Option type (Yes, No, Cancel)
            );
            switch (choice) {
                case 0 -> {

                    try {
                        if (UserData.deleteUser(this.user)) {
                            tblUserModel.removeRow(userIndex);
                            Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "You have been deleted success");
                            this.clearForm();
                        }
                    } catch (SQLException ex) {
                        Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, ex.getMessage());
                    }
                }
                default -> {
                    Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "No, Delete");
                }
            }

        }
    }//GEN-LAST:event_mDeleteMousePressed

    private void mResetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mResetMousePressed
        // TODO add your handling code here:
        this.clearForm();
    }//GEN-LAST:event_mResetMousePressed

    private void mUpdateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mUpdateMousePressed
        // TODO add your handling code here:
        if (mUpdate.isEnabled()) {
            String gender = cbGender.getSelectedItem().equals("Female") ? "f" : "m";
            String role = cbRole.getSelectedItem().toString().toLowerCase();
            String status = this.chStatus.isSelected() ? "True" : "Fale";
            String username = txtUsername.getText().trim();
            String fullName = txtFullName.getText().trim();
            String pwd = txtPassword.getText().trim();

            tblUserModel.setValueAt(username.toLowerCase(), userIndex, 1);
            tblUserModel.setValueAt(fullName, userIndex, 2);
            tblUserModel.setValueAt("f".equals(gender) ? "Female" : "Male", userIndex, 3);
            tblUserModel.setValueAt(pwd, userIndex, 4);
            tblUserModel.setValueAt(role, userIndex, 5);
            tblUserModel.setValueAt(status, userIndex, 6);

            user.setUsername(username);
            user.setFullName(fullName);
            user.setGender(gender.toString());
            user.setPassword(pwd);
            user.setRole(role.toString());
            user.setStatus(status.toString().equals("True"));

            try {
                if (UserData.updateUser(user)) {
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "You have been updated success");
                    this.clearForm();
                }
            } catch (SQLException ex) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, ex.getMessage());
            }
        }
    }//GEN-LAST:event_mUpdateMousePressed

    private void mUserPermissionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mUserPermissionMouseClicked
        // TODO add your handling code here:
        if (mUserPermission.isEnabled()) {
            MenuData.UpdatingPermission p = new MenuData().new UpdatingPermission();
            FrmUserPermission frm = new FrmUserPermission(null, true, user, p);
            frm.setVisible(true);
            int returnVal = frm.getReturnStatus();
            try {
                if (returnVal == 1) {
                    p.commitData();
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Okay Save data");
                } else {
                    p.rollbackData();
                    Notifications.getInstance().show(Notifications.Type.WARNING, Notifications.Location.TOP_CENTER, "Cancelled");
                }
            } catch (SQLException ex) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, ex.getMessage());
                Logger.getLogger(AppForm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                p.setAutCommitTrue();
                p.closeConnection();
            }
        }
    }//GEN-LAST:event_mUserPermissionMouseClicked

    private void mThemeMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_mThemeMenuSelected
        // TODO add your handling code here:

    }//GEN-LAST:event_mThemeMenuSelected

    private void mThemeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mThemeMouseClicked
        // TODO add your handling code here:
        isDarkTheme = !isDarkTheme;
        System.out.println("Theme mThemeMouseClicked: " + isDarkTheme);
        if (isDarkTheme) {
            EventQueue.invokeLater(() -> {
                FlatAnimatedLafChange.showSnapshot();
                FlatMacDarkLaf.setup();
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
            });
        } else {
            EventQueue.invokeLater(() -> {
                FlatAnimatedLafChange.showSnapshot();
                FlatMacLightLaf.setup();
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
            });
        }

    }//GEN-LAST:event_mThemeMouseClicked

    private void mExportMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mExportMousePressed
        // TODO add your handling code here:
        //make a choice for user to select a location to save
        String documentsFile = userHome + System.getProperty("file.separator") + "Documents" + System.getProperty("file.separator") + "users.xlsx";
        JFileChooser sPath = new JFileChooser();
        sPath.setDialogTitle("Save Excel File");
        sPath.setSelectedFile(new File(documentsFile));
//
        if (sPath.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            XSSFWorkbook wb = new XSSFWorkbook();
//            //Create file system using specific name
            try {
                System.out.println(sPath.getSelectedFile());
                XSSFSheet spreadsheet = wb.createSheet("Users");

                //Create row object
                XSSFRow row;

                //This data needs to be written (Object[])
                /**
                 * Testing initialize Map< String, Object[]> empinfo = new
                 * TreeMap< String, Object[]>(); empinfo.put("1", new
                 * Object[]{"EMP ID", "EMP NAME", "DESIGNATION"});
                 * empinfo.put("2", new Object[]{"tp01", "Gopal", "Technical
                 * Manager"}); empinfo.put("3", new Object[]{"tp02", "Manisha",
                 * "Proof Reader"});
                 */
                //Iterate over data and write to sheet
                Set< String> keyid = exportData.keySet();
                int rowid = 0;

                for (String key : keyid) {
                    row = spreadsheet.createRow(rowid++);
                    Object[] objectArr = exportData.get(key);

                    int cellid = 0;

                    for (Object obj : objectArr) {
                        Cell cell = row.createCell(cellid++);
                        cell.setCellValue((String) obj);
                    }
                }

                FileOutputStream out = new FileOutputStream(sPath.getSelectedFile());
                wb.write(out);
                out.close();

                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, 5000, "You have been exported data to Path: " + sPath.getSelectedFile());

                this.openExport(sPath.getSelectedFile());

            } catch (IOException ex) {
                Logger.getLogger(AppForm.class.getName()).log(Level.SEVERE, null, ex);
                Notifications.getInstance().show(
                        Notifications.Type.ERROR,
                        Notifications.Location.TOP_RIGHT,
                        5000,
                        ex.getMessage()
                );
            }
        }
    }//GEN-LAST:event_mExportMousePressed

    private void mImportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mImportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mImportActionPerformed

    private void mImportMousePressed(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        UserImportDailog frm = new UserImportDailog(null, true);
        frm.setTitle("Import Data");
        ImageIcon img = new ImageIcon(getClass().getResource("/app/icons/upload.png"));
        frm.setIconImage(img.getImage());
        frm.setVisible(true);
    }

    void openExport(File file) {

        int choice = JOptionPane.showConfirmDialog(
                null, // Parent component (null means center on screen)
                "Do you want to open file export?", // Message to display
                "Confirmation", // Dialog title
                JOptionPane.YES_NO_OPTION // Option type (Yes, No, Cancel)
        );

        if (choice == 0) {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                Notifications.getInstance().show(
                        Notifications.Type.ERROR,
                        Notifications.Location.TOP_RIGHT,
                        5000,
                        ex.getMessage()
                );
            }
        }
    }

    private boolean usernameValid() {
        String regex = "^[A-Za-z][A-Za-z0-9_]{5,29}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(txtUsername.getText().trim());
        if (!matcher.matches()) {
            JOptionPane.showMessageDialog(rootPane, "Username is invalid. It should start with a letter and contain only alphanumeric characters and underscores.", "Validation", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private void clearForm() {
        this.txtId.setText(totalUser.toString());
        this.txtUsername.setText("");
        this.txtFullName.setText("");
        this.txtPassword.setText("");
        this.txtConfirmPassword.setText(null);
        mAdd.setEnabled(true);
        mUpdate.setEnabled(false);
        mDelete.setEnabled(false);
        mUserPermission.setEnabled(false);
    }

    private void initTableData() {
        // Simulate fetching data from somewhere, e.g., a database
        try {
            List<User> users = UserData.list(); // Assuming UserData.list() returns a List of UserData objects
            totalUser = users.size();
            // Populate the table model with user data
            for (int i = 0; i < users.size(); i++) {
                user = users.get(i);
                var obj = new Object[]{
                    user.getId().toString(),
                    user.getUsername(),
                    user.getFullName(),
                    "f".equals(user.getGender()) ? "Female" : "Male",
                    user.getPassword(),
                    user.getRole().toLowerCase(),
                    user.getStatus() ? "True" : "Fale"
                };
//                System.out.println("Index" + (i + 2));
                exportData.put(String.valueOf(2 + i), obj);
                tblUserModel.addRow(obj);
            }

//            users.forEach(user -> {
//                Object[] obj = new Object[]{
//                    user.getId(),
//                    user.getUsername(),
//                    user.getFullName(),
//                    "f".equals(user.getGender()) ? "Female" : "Male",
//                    user.getPassword(),
//                    user.getRole().toLowerCase(),
//                    user.getStatus() ? "True" : "Fale"
//                };
//                exportData.put("1", obj);
//                tblUserModel.addRow(obj);
//            });
        } catch (SQLException e) {
            Notifications.getInstance().show(
                    Notifications.Type.ERROR,
                    Notifications.Location.TOP_RIGHT,
                    5000,
                    "Error connecting to the database: " + e.getMessage()
            );
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
            UIManager.put("Button.arc", 8);
            UIManager.put("Component.arc", 8);
            UIManager.put("ProgressBar.arc", 8);
            UIManager.put("TextComponent.arc", 8);
        } catch (UnsupportedLookAndFeelException e) {
            throw new IllegalAccessError(e.getMessage());
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AppForm().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Canvas canvas1;
    private javax.swing.JComboBox<String> cbGender;
    private javax.swing.JComboBox<String> cbRole;
    private javax.swing.JCheckBox chStatus;
    private javax.swing.JCheckBox checkShowPassword;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenu mAdd;
    private javax.swing.JMenu mDelete;
    private javax.swing.JMenu mExport;
    private javax.swing.JMenu mImport;
    private javax.swing.JMenu mPrint;
    private javax.swing.JMenuItem mReset;
    private javax.swing.JMenu mSearch;
    private javax.swing.JMenu mTheme;
    private javax.swing.JMenu mUpdate;
    private javax.swing.JMenu mUserPermission;
    private javax.swing.JTable tblUser;
    private javax.swing.JTextField txtConfirmPassword;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
