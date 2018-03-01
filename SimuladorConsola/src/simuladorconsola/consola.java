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
import javax.swing.text.Position;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author angel
 */
public class consola extends javax.swing.JFrame {

    DefaultTreeModel model;
    TreePath path = null;
    String pathTemporal = "root/";
    String pathGlobal = "root/";

    public consola() {
        initComponents();
        model = (DefaultTreeModel) filesTree.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        consoleTextArea = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        resultadosTextArea = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        filesTree = new javax.swing.JTree();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Terminal");

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

        resultadosTextArea.setColumns(20);
        resultadosTextArea.setRows(5);
        jScrollPane3.setViewportView(resultadosTextArea);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("home");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("dir");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("src");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("imagenes");
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("dibujos");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("jlex.png");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        filesTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane4.setViewportView(filesTree);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    DefaultMutableTreeNode nod = null;
    private void consoleTextAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_consoleTextAreaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            AnalizadorLexico miLexer = new AnalizadorLexico(new StringReader(obtenerUltimaLinea(consoleTextArea.getText())));
            parser miParser = new parser(miLexer);
            try {
                miParser.parse();
            } catch (Exception ex) {
                System.out.println("Error: " + ex);
            }
        }
    }//GEN-LAST:event_consoleTextAreaKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea consoleTextArea;
    private javax.swing.JTree filesTree;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea resultadosTextArea;
    // End of variables declaration//GEN-END:variables

    private String obtenerUltimaLinea(String textoEntrada) {
        int catENTER = 1;
        String textoSelect = "";
        String textoSalida = "";
        for (int i = (textoEntrada.length() - 1); i > -1; i--) {
            char letra = textoEntrada.charAt(i);
            if (catENTER > 0) {
                switch (letra) {
                    case '\r':
                    case '\n':
                        catENTER--;
                        break;
                    default:
                        textoSelect += letra;
                }
            }

        }

//        System.out.println(textoSelect);
        for (int i = (textoSelect.length() - 1); i > -1; i--) {
            char letra = textoSelect.charAt(i);
            textoSalida += letra;

        }
//        System.err.println(textoSalida);
        return textoSalida;
    }

    public boolean findText(String nodes) {
        String[] parts = nodes.split("/");
        for (String part : parts) {
            int row = (path == null ? 0 : filesTree.getRowForPath(path));
            path = filesTree.getNextMatch(part, row, Position.Bias.Forward);
            if (path == null) {
                return false;
            }
        }
        filesTree.scrollPathToVisible(path);
        filesTree.setSelectionPath(path);
        return path != null;
    }

    public String obtenerNuevoPathConRoot(String textoEntrada) {
        String texAux = "";

        for (int i = 0; i < textoEntrada.length(); i++) {
            char letra = textoEntrada.charAt(i);
            if (textoEntrada.charAt(0) == '/' && i == 0) {
                texAux = "root/";
            } else {
                texAux += letra;
            }
        }
        System.out.println("Path modificado: " + texAux);
        return texAux;
    }

    public String nameFileoDir(String textoEntrada) {
        int catENTER = 1;
        String textoSelect = "";
        String textoSalida = "";
        for (int i = (textoEntrada.length() - 1); i > -1; i--) {
            char letra = textoEntrada.charAt(i);
            if (catENTER > 0) {
                switch (letra) {
                    case '/':
                        catENTER--;
                        break;
                    default:
                        textoSelect += letra;
                }
            }
        }
        for (int i = (textoSelect.length() - 1); i > -1; i--) {
            char letra = textoSelect.charAt(i);
            textoSalida += letra;
        }
        return textoSalida;
    }

    public String eliminarNameDirFile(String textoEntrada) {
        int catENTER = 1;
        String textoSelect = "";
        String textoSalida = "";
        for (int i = (textoEntrada.length() - 1); i > -1; i--) {
            char letra = textoEntrada.charAt(i);
            if (catENTER > 0) {
                switch (letra) {
                    case '/':
                        catENTER--;
                        break;
                }
            } else {
                textoSelect += letra;
            }
        }
        for (int i = (textoSelect.length() - 1); i > -1; i--) {
            char letra = textoSelect.charAt(i);
            textoSalida += letra;
        }
        return textoSalida;
    }

    public void addFile(String pathToAdd) {
        pathTemporal = eliminarNameDirFile(obtenerNuevoPathConRoot(pathToAdd));
        String nameFile = nameFileoDir(pathToAdd);

        if (findText(pathTemporal)) {
            nod = (DefaultMutableTreeNode) filesTree.getLastSelectedPathComponent();
            System.out.println("Last path: " + filesTree.getLastSelectedPathComponent().toString());

            if (nod != null) {
                if (!nod.isLeaf()) {
                    nod.insert(new DefaultMutableTreeNode(nameFile), nod.getIndex(nod.getLastChild()));
                } else {
                    nod.insert(new DefaultMutableTreeNode(nameFile), 0);
                }
                model.reload(nod);
                pathGlobal = pathTemporal;
            }
        }
    }

    public void deleteFile(String pathToDelete) {
        pathTemporal = obtenerNuevoPathConRoot(pathToDelete);

        if (findText(pathTemporal)) {
            nod = (DefaultMutableTreeNode) filesTree.getLastSelectedPathComponent();
            if (nod.isLeaf()) {
                if (nod != null) {
                    DefaultMutableTreeNode parent = (DefaultMutableTreeNode) nod.getParent();
                    parent.remove(nod);
                    model.reload(parent);
                    pathGlobal = eliminarNameDirFile(pathTemporal);
                }
            } else {
                for (int i = 0; i < nod.getChildCount(); i++) {
                    TreePath aux = (TreePath) nod.getChildAt(i);
                    deleteFile(aux.getPath().toString().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll(",", "/"));
                }
            }

        }
    }

    public void getNowPath(String textoResultado) {
        String textOut = "";
        textOut += (textoResultado + "\n");
        resultadosTextArea.setText(textOut);
    }
}
