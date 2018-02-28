/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simuladorconsola;

import java.awt.event.KeyEvent;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author angel
 */
public class consola extends javax.swing.JFrame {

    /**
     * Creates new form consola
     */
    public consola() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        filesTree = new javax.swing.JTree();
        jScrollPane2 = new javax.swing.JScrollPane();
        consoleTextArea = new javax.swing.JTextArea();
        myComands = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Console");

        filesTree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filesTreeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(filesTree);

        consoleTextArea.setBackground(new java.awt.Color(4, 2, 2));
        consoleTextArea.setColumns(20);
        consoleTextArea.setForeground(new java.awt.Color(0, 240, 255));
        consoleTextArea.setRows(5);
        consoleTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                consoleTextAreaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(consoleTextArea);

        myComands.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                myComandsFocusLost(evt);
            }
        });
        myComands.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                myComandsKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                    .addComponent(myComands))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)
                        .addComponent(myComands, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filesTreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filesTreeMouseClicked

        TreeSelectionModel smd = filesTree.getSelectionModel();
        if (smd.getSelectionCount() > 0) {
            TreePath selectedNode = filesTree.getSelectionPath();
            consoleTextArea.setText(selectedNode.toString().replaceAll("\\[", "/").replaceAll("\\]", "").replaceAll(",", "/").replaceAll(" ", ""));
        }

    }//GEN-LAST:event_filesTreeMouseClicked

    private void myComandsFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_myComandsFocusLost

    }//GEN-LAST:event_myComandsFocusLost

    private void myComandsKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_myComandsKeyPressed
//        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
//            AnalizadorLexico miLexer = new AnalizadorLexico(new StringReader(myComands.getText()));
//            parser miParser = new parser(miLexer);
//            try {
//                miParser.parse();
//            } catch (Exception ex) {
//                Logger.getLogger(SimuladorConsola.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_myComandsKeyPressed

    private void consoleTextAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_consoleTextAreaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            AnalizadorLexico miLexer = new AnalizadorLexico(new StringReader(myComands.getText()));
            parser miParser = new parser(miLexer);
            try {
                miParser.parse();
            } catch (Exception ex) {
                Logger.getLogger(SimuladorConsola.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_consoleTextAreaKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea consoleTextArea;
    private javax.swing.JTree filesTree;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField myComands;
    // End of variables declaration//GEN-END:variables
}
