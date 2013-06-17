/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fcse.domcolorclassifier.gui;

import edu.fcse.domcolorclassifier.Classificator;
import edu.fcse.domcolorclassifier.MethodToApply;
import edu.fcse.domcolorclassifier.algorithms.AlgorithmToApply;
import edu.fcse.domcolorclassifier.colorutils.CustColor;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Blagoj Atanasovski
 */
public class ClassificationFrame extends javax.swing.JFrame {

    private Classificator classificator;
    private List<String> filesToBeClassified;
    public ClassificationFrame(File initFolder, CustColor.ColorSpace space, List<CustColor> centers, AlgorithmToApply algo, MethodToApply meth) throws IOException {
        initComponents();
        classificator = new Classificator(initFolder, space, centers, algo, meth);
        filesToBeClassified=classificator.getFilesForClassification();
         DefaultListModel listModel = new DefaultListModel();
         for(String fileName:filesToBeClassified){
             listModel.addElement(fileName.substring(fileName.lastIndexOf(File.separatorChar)+1));
         }
         this.datasetList.setModel(listModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        datasetScrollPane = new javax.swing.JScrollPane();
        datasetList = new javax.swing.JList();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        textRezPanel = new javax.swing.JPanel();
        showAllButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        rezTextArea = new javax.swing.JTextArea();
        visualRezPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DomColorClassification - Classification");

        jLabel1.setLabelFor(datasetScrollPane);
        jLabel1.setText("Data set");

        datasetList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        datasetScrollPane.setViewportView(datasetList);

        showAllButton.setText("Show all");

        rezTextArea.setEditable(false);
        rezTextArea.setColumns(20);
        rezTextArea.setLineWrap(true);
        rezTextArea.setRows(5);
        jScrollPane1.setViewportView(rezTextArea);

        javax.swing.GroupLayout textRezPanelLayout = new javax.swing.GroupLayout(textRezPanel);
        textRezPanel.setLayout(textRezPanelLayout);
        textRezPanelLayout.setHorizontalGroup(
            textRezPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textRezPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(textRezPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                    .addGroup(textRezPanelLayout.createSequentialGroup()
                        .addComponent(showAllButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        textRezPanelLayout.setVerticalGroup(
            textRezPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textRezPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(showAllButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Textual results", textRezPanel);

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Delix\\Desktop\\data1\\green\\00e120eb-2314-4ff0-9035-a7f7bb5a609d.jpg")); // NOI18N
        jLabel2.setDoubleBuffered(true);

        javax.swing.GroupLayout visualRezPanelLayout = new javax.swing.GroupLayout(visualRezPanel);
        visualRezPanel.setLayout(visualRezPanelLayout);
        visualRezPanelLayout.setHorizontalGroup(
            visualRezPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(visualRezPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 476, Short.MAX_VALUE)
                .addContainerGap())
        );
        visualRezPanelLayout.setVerticalGroup(
            visualRezPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, visualRezPanelLayout.createSequentialGroup()
                .addContainerGap(164, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Visualization", visualRezPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(datasetScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(datasetScrollPane)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList datasetList;
    private javax.swing.JScrollPane datasetScrollPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea rezTextArea;
    private javax.swing.JButton showAllButton;
    private javax.swing.JPanel textRezPanel;
    private javax.swing.JPanel visualRezPanel;
    // End of variables declaration//GEN-END:variables
}