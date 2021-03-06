package edu.fcse.domcolorclassifier.gui;

import edu.fcse.domcolorclassifier.MethodToApply;
import edu.fcse.domcolorclassifier.algorithms.AddToMultipleCentersAlgorithm;
import edu.fcse.domcolorclassifier.algorithms.AddToMultipleCentersMaxDistAlgorithm;
import edu.fcse.domcolorclassifier.algorithms.AlgorithmToApply;
import edu.fcse.domcolorclassifier.algorithms.BasicAlgorithm;
import edu.fcse.domcolorclassifier.algorithms.BasicWithDiscardDistanceAlgorithm;
import edu.fcse.domcolorclassifier.algorithms.EqDistCountDoubleAlgorithm;
import edu.fcse.domcolorclassifier.colorutils.CustColor;
import edu.fcse.domcolorclassifier.functions.distance.DistanceFunction;
import edu.fcse.domcolorclassifier.functions.distance.EuclideanDistanceFunction;
import edu.fcse.domcolorclassifier.functions.smooting.AVGSmoothingFunction;
import edu.fcse.domcolorclassifier.functions.smooting.EnhanceGreenSmoothingFunction;
import edu.fcse.domcolorclassifier.functions.smooting.MINSmoothingFunction;
import edu.fcse.domcolorclassifier.functions.smooting.SmoothingFunction;
import edu.fcse.domcolorclassifier.functions.weight.ExpWeightFunction;
import edu.fcse.domcolorclassifier.functions.weight.ReciWeightFunction;
import edu.fcse.domcolorclassifier.functions.weight.WeightFunction;
import edu.fcse.domcolorclassifier.gui.custcomponents.GravCenterTableModel;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Form the sets up the parameters for the classifier and the input data set
 * location.
 *
 * @author Blagoj Atanasovski
 */
public class InitFrame extends javax.swing.JFrame {

    Map<String, float[]> createdCenters;

    /**
     * Creates new form InitFrame
     */
    public InitFrame() {
        initComponents();
        createdCenters = new HashMap<>();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        colorSpaceButtonGroup = new javax.swing.ButtonGroup();
        weightFunctionButtonGroup = new javax.swing.ButtonGroup();
        smoothingFunctionbuttonGroup = new javax.swing.ButtonGroup();
        chosenInitFolderTextField = new javax.swing.JTextField();
        cChooseInitFolderButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        csRGBRadioButton = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        csLabRadioButton = new javax.swing.JRadioButton();
        csLuvRadioButton = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        wfNoneRadioButton = new javax.swing.JRadioButton();
        wfReciRadioButton = new javax.swing.JRadioButton();
        wfExpRadioButton = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        sfNoneRadioButton = new javax.swing.JRadioButton();
        sfAVGRadioButton = new javax.swing.JRadioButton();
        sfMINRadioButton = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        algorithmComboBox = new javax.swing.JComboBox();
        useDiscardDistanceCheckBox = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        discardDistanceTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        maxDiscardDistanceLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        useFixedValCheckBox = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        autoStartCheckBox = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        redTextField = new javax.swing.JTextField();
        greenTextField = new javax.swing.JTextField();
        blueTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        colorNameTextField = new javax.swing.JTextField();
        addColorButton = new javax.swing.JButton();
        predefinedButtonRed = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        predefinedButtonGreen = new javax.swing.JButton();
        predefinedButtonBlue = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DomColorClassification - Init");

        cChooseInitFolderButton.setText("Browse");
        cChooseInitFolderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cChooseInitFolderButtonActionPerformed(evt);
            }
        });

        jLabel1.setLabelFor(cChooseInitFolderButton);
        jLabel1.setText("Choose the folder with the images:");

        colorSpaceButtonGroup.add(csRGBRadioButton);
        csRGBRadioButton.setSelected(true);
        csRGBRadioButton.setText("RGB");

        jLabel2.setLabelFor(csRGBRadioButton);
        jLabel2.setText("Color Space:");

        colorSpaceButtonGroup.add(csLabRadioButton);
        csLabRadioButton.setText("Lab");
        csLabRadioButton.setEnabled(false);

        colorSpaceButtonGroup.add(csLuvRadioButton);
        csLuvRadioButton.setText("Luv");
        csLuvRadioButton.setEnabled(false);

        jLabel3.setText("Weight Function:");

        weightFunctionButtonGroup.add(wfNoneRadioButton);
        wfNoneRadioButton.setText("None");

        weightFunctionButtonGroup.add(wfReciRadioButton);
        wfReciRadioButton.setSelected(true);
        wfReciRadioButton.setText("Reciprocal");

        weightFunctionButtonGroup.add(wfExpRadioButton);
        wfExpRadioButton.setText("Exponential");

        jLabel4.setText("Smoothing Function");

        smoothingFunctionbuttonGroup.add(sfNoneRadioButton);
        sfNoneRadioButton.setSelected(true);
        sfNoneRadioButton.setText("None");

        smoothingFunctionbuttonGroup.add(sfAVGRadioButton);
        sfAVGRadioButton.setText("AVG");

        smoothingFunctionbuttonGroup.add(sfMINRadioButton);
        sfMINRadioButton.setText("MIN");

        jLabel5.setLabelFor(algorithmComboBox);
        jLabel5.setText("Algorithm");

        algorithmComboBox.setMaximumRowCount(5);
        algorithmComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Basic Algorithm", "Equal Distance Count Double", "Add To Multiple Centers" }));
        algorithmComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                algorithmComboBoxActionPerformed(evt);
            }
        });

        useDiscardDistanceCheckBox.setText("Use discard distance");
        useDiscardDistanceCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useDiscardDistanceCheckBoxActionPerformed(evt);
            }
        });

        jLabel6.setText("Distance:");
        jLabel6.setEnabled(false);

        discardDistanceTextField.setEnabled(false);

        jLabel7.setText("from maximum");
        jLabel7.setEnabled(false);

        maxDiscardDistanceLabel.setText("440");
        maxDiscardDistanceLabel.setEnabled(false);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        useFixedValCheckBox.setText("Use fixed value addition");
        useFixedValCheckBox.setFocusable(false);
        useFixedValCheckBox.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                useFixedValCheckBoxStateChanged(evt);
            }
        });

        jButton2.setText("Classify");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        autoStartCheckBox.setText("Start automaticly");

        jLabel8.setText("Create gravity centers");

        jLabel9.setText("Red:");

        jLabel10.setText("Green:");

        jLabel11.setText("Blue:");

        redTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redTextFieldActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Color name", "Red", "Green", "Blue"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setColumnSelectionAllowed(true);
        jTable1.setFocusable(false);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(2).setPreferredWidth(50);
        jTable1.getColumnModel().getColumn(3).setPreferredWidth(50);

        jLabel12.setText("Name:");

        addColorButton.setText("Add");
        addColorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addColorButtonActionPerformed(evt);
            }
        });

        predefinedButtonRed.setText("#FF0000");
        predefinedButtonRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                predefinedButtonRedActionPerformed(evt);
            }
        });

        jLabel13.setText("Predefined:");

        predefinedButtonGreen.setText("#00FF00");
        predefinedButtonGreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                predefinedButtonGreenActionPerformed(evt);
            }
        });

        predefinedButtonBlue.setText("#0000FF");
        predefinedButtonBlue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                predefinedButtonBlueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cChooseInitFolderButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chosenInitFolderTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(sfNoneRadioButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(sfAVGRadioButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(sfMINRadioButton))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(csRGBRadioButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(csLabRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(csLuvRadioButton))
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(greenTextField)
                                        .addComponent(blueTextField, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(redTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(0, 0, Short.MAX_VALUE))))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(colorNameTextField))
                                        .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addGap(10, 10, 10)
                                    .addComponent(addColorButton)))
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(wfNoneRadioButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(wfReciRadioButton)
                                        .addGap(18, 18, 18)
                                        .addComponent(wfExpRadioButton))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(algorithmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(useDiscardDistanceCheckBox)
                                    .addComponent(useFixedValCheckBox)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(discardDistanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(maxDiscardDistanceLabel))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(predefinedButtonRed)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(predefinedButtonGreen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(predefinedButtonBlue)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(autoStartCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cChooseInitFolderButton)
                    .addComponent(chosenInitFolderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(wfNoneRadioButton)
                                .addComponent(wfReciRadioButton)
                                .addComponent(wfExpRadioButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(csRGBRadioButton)
                                .addComponent(csLabRadioButton)
                                .addComponent(csLuvRadioButton)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(algorithmComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(sfNoneRadioButton)
                                .addComponent(sfAVGRadioButton)
                                .addComponent(sfMINRadioButton))
                            .addComponent(useDiscardDistanceCheckBox, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(discardDistanceTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)
                                        .addComponent(maxDiscardDistanceLabel))
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(useFixedValCheckBox)
                                .addGap(7, 7, 7)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(redTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(greenTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(blueTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(colorNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addColorButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13))))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(predefinedButtonRed)
                    .addComponent(predefinedButtonGreen)
                    .addComponent(predefinedButtonBlue)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                    .addComponent(autoStartCheckBox))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cChooseInitFolderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cChooseInitFolderButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            chosenInitFolderTextField.setText(fileChooser.getSelectedFile().getAbsolutePath());

        }
    }//GEN-LAST:event_cChooseInitFolderButtonActionPerformed

    private void algorithmComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_algorithmComboBoxActionPerformed
        String selection = (String) algorithmComboBox.getSelectedItem();
        //Basic Algorithm, Equal Distance Count Double, Add To Multiple Centers
        switch (selection) {
            case "Basic Algorithm":
                useFixedValCheckBox.setEnabled(true);
                break;
            case "Equal Distance Count Double":
                useFixedValCheckBox.setEnabled(true);
                break;
            default:
                useFixedValCheckBox.setEnabled(false);
                break;
        }
    }//GEN-LAST:event_algorithmComboBoxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (chosenInitFolderTextField.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Choose location of data!\n", "DomColorClassification: Start classification", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if (createdCenters.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Create classification centers!\n", "DomColorClassification: Start classification", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        File initFolder = new File(chosenInitFolderTextField.getText());
        CustColor.ColorSpace space = CustColor.ColorSpace.RGB;
        SmoothingFunction sf = getSmoothingFunction();

        WeightFunction wf = getWeightFunction();
        AlgorithmToApply algo = getAlgorithm();
        DistanceFunction dist = new EuclideanDistanceFunction();
        double discardDist = Double.MAX_VALUE;
        if (useDiscardDistanceCheckBox.isSelected()) {
            discardDist = Double.parseDouble(discardDistanceTextField.getText());
        }
        MethodToApply meth = new MethodToApply(sf, space, wf, dist, discardDist, useFixedValCheckBox.isSelected());
        List<CustColor> centers = new ArrayList<>(createdCenters.size());
        for (String name : createdCenters.keySet()) {
            centers.add(new CustColor(name, createdCenters.get(name)));
        }
        try {
            ClassificationFrame cf = new ClassificationFrame(initFolder, space, centers, algo, meth, autoStartCheckBox.isSelected());
            cf.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(InitFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    private SmoothingFunction getSmoothingFunction() {
        if (sfNoneRadioButton.isSelected()) {
            return new SmoothingFunction();
        } else if (sfMINRadioButton.isSelected()) {
            return new MINSmoothingFunction();
        }
        return new AVGSmoothingFunction(2);
    }

    private AlgorithmToApply getAlgorithm() {
        switch ((String) algorithmComboBox.getSelectedItem()) {
            //Basic Algorithm, Equal Distance Count Double, Add To Multiple Centers
            case "Basic Algorithm":
                if (useDiscardDistanceCheckBox.isSelected()) {
                    return new BasicWithDiscardDistanceAlgorithm();
                }
                return new BasicAlgorithm();
            case "Equal Distance Count Double":
                return new EqDistCountDoubleAlgorithm();
            default:
                if (useDiscardDistanceCheckBox.isSelected()) {
                    return new AddToMultipleCentersMaxDistAlgorithm();
                }
                return new AddToMultipleCentersAlgorithm();
        }
    }

    private WeightFunction getWeightFunction() {
        if (wfNoneRadioButton.isSelected()) {
            return new WeightFunction();
        } else if (wfExpRadioButton.isSelected()) {
            return new ExpWeightFunction();
        }
        return new ReciWeightFunction();

    }
    private void redTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_redTextFieldActionPerformed

    private void addColorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addColorButtonActionPerformed
        try {
            float[] values = new float[]{Float.parseFloat(redTextField.getText()),
                Float.parseFloat(greenTextField.getText()), Float.parseFloat(blueTextField.getText())};
            createdCenters.put(colorNameTextField.getText(), values);
            jTable1.setModel(new GravCenterTableModel(createdCenters));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Error reading some of the input values!\n", "DomColorClassification: Create gravity center", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_addColorButtonActionPerformed

    private void useFixedValCheckBoxStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_useFixedValCheckBoxStateChanged
    }//GEN-LAST:event_useFixedValCheckBoxStateChanged

    private void useDiscardDistanceCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useDiscardDistanceCheckBoxActionPerformed
        JComponent c[] = new JComponent[]{jLabel6, jLabel7, discardDistanceTextField, maxDiscardDistanceLabel};
        boolean flag = false;
        if (useDiscardDistanceCheckBox.isSelected()) {
            flag = true;
        }
        for (JComponent cc : c) {
            cc.setEnabled(flag);
        }
    }//GEN-LAST:event_useDiscardDistanceCheckBoxActionPerformed

    private void predefinedButtonRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_predefinedButtonRedActionPerformed
        createdCenters.put("Red", new float[]{255, 0, 0});
        jTable1.setModel(new GravCenterTableModel(createdCenters));
    }//GEN-LAST:event_predefinedButtonRedActionPerformed

    private void predefinedButtonGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_predefinedButtonGreenActionPerformed
        createdCenters.put("Green", new float[]{0, 255, 0});
        jTable1.setModel(new GravCenterTableModel(createdCenters));
    }//GEN-LAST:event_predefinedButtonGreenActionPerformed

    private void predefinedButtonBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_predefinedButtonBlueActionPerformed
        createdCenters.put("Blue", new float[]{0, 0, 255});
        jTable1.setModel(new GravCenterTableModel(createdCenters));
    }//GEN-LAST:event_predefinedButtonBlueActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InitFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InitFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addColorButton;
    private javax.swing.JComboBox algorithmComboBox;
    private javax.swing.JCheckBox autoStartCheckBox;
    private javax.swing.JTextField blueTextField;
    private javax.swing.JButton cChooseInitFolderButton;
    private javax.swing.JTextField chosenInitFolderTextField;
    private javax.swing.JTextField colorNameTextField;
    private javax.swing.ButtonGroup colorSpaceButtonGroup;
    private javax.swing.JRadioButton csLabRadioButton;
    private javax.swing.JRadioButton csLuvRadioButton;
    private javax.swing.JRadioButton csRGBRadioButton;
    private javax.swing.JTextField discardDistanceTextField;
    private javax.swing.JTextField greenTextField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel maxDiscardDistanceLabel;
    private javax.swing.JButton predefinedButtonBlue;
    private javax.swing.JButton predefinedButtonGreen;
    private javax.swing.JButton predefinedButtonRed;
    private javax.swing.JTextField redTextField;
    private javax.swing.JRadioButton sfAVGRadioButton;
    private javax.swing.JRadioButton sfMINRadioButton;
    private javax.swing.JRadioButton sfNoneRadioButton;
    private javax.swing.ButtonGroup smoothingFunctionbuttonGroup;
    private javax.swing.JCheckBox useDiscardDistanceCheckBox;
    private javax.swing.JCheckBox useFixedValCheckBox;
    private javax.swing.ButtonGroup weightFunctionButtonGroup;
    private javax.swing.JRadioButton wfExpRadioButton;
    private javax.swing.JRadioButton wfNoneRadioButton;
    private javax.swing.JRadioButton wfReciRadioButton;
    // End of variables declaration//GEN-END:variables
}
