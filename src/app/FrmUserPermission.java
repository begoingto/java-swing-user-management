/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/OkCancelDialog.java to edit this template
 */
package app;

import app.data.MenuData;
import app.models.Menu;
import app.models.User;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import raven.toast.Notifications;

/**
 *
 * @author begoingto
 */
public class FrmUserPermission extends javax.swing.JDialog {

    private User user;
    private DefaultTableModel tblPermissionModel;
    private List<Integer> userPermission;
    private MenuData.UpdatingPermission updatingPermission;
    /**
     * A return status code - returned if Cancel button has been pressed
     */
    public static final int RET_CANCEL = 0;
    /**
     * A return status code - returned if OK button has been pressed
     */
    public static final int RET_OK = 1;

    /**
     * Creates new form FrmUserPermission
     *
     * @param u
     */
    public FrmUserPermission(java.awt.Frame parent, boolean modal, User u, MenuData.UpdatingPermission p) {
        super(parent, modal);
        user = u;
        updatingPermission = p;

        DefaultMutableTreeNode root = new DefaultMutableTreeNode(u.getUsername());
        DefaultMutableTreeNode child1 = new DefaultMutableTreeNode("File");
        DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Edit");
        DefaultMutableTreeNode child3 = new DefaultMutableTreeNode("Report");
        root.add(child1);
        root.add(child2);
        root.add(child3);
        initComponents();

        initMenuData();

        TableColumn column = tblPermission.getColumnModel().getColumn(0);
        column.setPreferredWidth(10); // Set width to 10 pixels

        TreeModel treeModel = new DefaultTreeModel(root);
        treeItems.setModel(treeModel);
        TreePath path = new TreePath(child1.getPath());
        treeItems.setSelectionPath(path);
        pEdit.setVisible(false);

        // Close the dialog when Esc is pressed
        String cancelName = "cancel";
        InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), cancelName);
        ActionMap actionMap = getRootPane().getActionMap();
        actionMap.put(cancelName, new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                doClose(RET_CANCEL);
            }
        });
    }

    void initMenuData() {
        String[] columnNames = {"Id", "Tick", "Menu", "Name item"};
        tblPermissionModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                // Set the class for the checkbox column
                if (columnIndex == 1) {
                    return Boolean.class; // Checkbox column
                }
                if (columnIndex == 0) {
                    tblPermission.getColumnModel().getColumn(0).setMinWidth(0);
                    tblPermission.getColumnModel().getColumn(0).setMaxWidth(0);
                    return Integer.class;
                }
                return super.getColumnClass(columnIndex);
            }
        };
        
        
        tblPermissionModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == TableModelEvent.UPDATE) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    if (column == 1) { // Check if the edited column is the Boolean column
                        Boolean newValue = (Boolean) tblPermissionModel.getValueAt(row, column);
                        Integer mId = Integer.parseInt(tblPermissionModel.getValueAt(row, 0).toString());
                        updatingPermission.onUpdatePermission(user,mId,newValue);
                    }
                }
            }
        });

        try {
            List<Menu> menus = MenuData.list();
            List<Integer> permissions = MenuData.userPermissions(user.getId());
            menus.forEach(m -> tblPermissionModel.addRow(new Object[]{m.getId(), permissions.contains(m.getId()), m.getName(), m.getDescription()}));
        } catch (SQLException ex) {
            Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, ex.getMessage());
            Logger.getLogger(FrmUserPermission.class.getName()).log(Level.SEVERE, null, ex);
        }

        tblPermission.setModel(tblPermissionModel);
    }

    /**
     * @return the return status of this dialog - one of RET_OK or RET_CANCEL
     */
    public int getReturnStatus() {
        return returnStatus;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        treeScroll = new javax.swing.JScrollPane();
        treeItems = new javax.swing.JTree();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        pFile = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPermission = new javax.swing.JTable();
        pEdit = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        pReport = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Root");
        treeItems.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        treeItems.setFocusable(false);
        treeItems.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                treeItemsMousePressed(evt);
            }
        });
        treeScroll.setViewportView(treeItems);

        jLayeredPane1.setLayout(new javax.swing.OverlayLayout(jLayeredPane1));

        tblPermission.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tblPermission.setFocusable(false);
        tblPermission.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblPermission);

        javax.swing.GroupLayout pFileLayout = new javax.swing.GroupLayout(pFile);
        pFile.setLayout(pFileLayout);
        pFileLayout.setHorizontalGroup(
            pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 498, Short.MAX_VALUE)
            .addGroup(pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pFileLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        pFileLayout.setVerticalGroup(
            pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 484, Short.MAX_VALUE)
            .addGroup(pFileLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pFileLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jLayeredPane1.setLayer(pFile, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(pFile);

        jLabel3.setFont(new java.awt.Font("Kantumruy Pro", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Edit Panel");
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout pEditLayout = new javax.swing.GroupLayout(pEdit);
        pEdit.setLayout(pEditLayout);
        pEditLayout.setHorizontalGroup(
            pEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
        );
        pEditLayout.setVerticalGroup(
            pEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pEditLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(433, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(pEdit, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(pEdit);

        pReport.setForeground(new java.awt.Color(0, 255, 204));

        jLabel2.setFont(new java.awt.Font("Kantumruy Pro", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Report Panel");
        jLabel2.setToolTipText("");

        javax.swing.GroupLayout pReportLayout = new javax.swing.GroupLayout(pReport);
        pReport.setLayout(pReportLayout);
        pReportLayout.setHorizontalGroup(
            pReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                .addContainerGap())
        );
        pReportLayout.setVerticalGroup(
            pReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pReportLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(433, Short.MAX_VALUE))
        );

        jLayeredPane1.setLayer(pReport, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.add(pReport);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(treeScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(treeScroll)
                    .addComponent(jLayeredPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap())
        );

        getRootPane().setDefaultButton(okButton);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        doClose(RET_OK);
    }//GEN-LAST:event_okButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        doClose(RET_CANCEL);
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        doClose(RET_CANCEL);
    }//GEN-LAST:event_closeDialog

    private void treeItemsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_treeItemsMousePressed
        // TODO add your handling code here:
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeItems.getLastSelectedPathComponent();
        switch (selectedNode.toString()) {
            case "File":
                pEdit.setVisible(false);
                pReport.setVisible(false);
                pFile.setVisible(true);
                break;
            case "Edit":
                pFile.setVisible(false);
                pReport.setVisible(false);
                pEdit.setVisible(true);
                break;
            case "Report":
                pFile.setVisible(false);
                pEdit.setVisible(false);
                pReport.setVisible(true);
                break;
            default:
                System.out.println("default: " + selectedNode);
        }
    }//GEN-LAST:event_treeItemsMousePressed

    private void doClose(int retStatus) {
        returnStatus = retStatus;
        setVisible(false);
        dispose();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel pEdit;
    private javax.swing.JPanel pFile;
    private javax.swing.JPanel pReport;
    private javax.swing.JTable tblPermission;
    public javax.swing.JTree treeItems;
    private javax.swing.JScrollPane treeScroll;
    // End of variables declaration//GEN-END:variables

    private int returnStatus = RET_CANCEL;
}
