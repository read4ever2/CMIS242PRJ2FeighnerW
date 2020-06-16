package cmis242prj2feighnerw;

/*
 * Filename: CMIS242PRJ2FeighnerW.java
 * Author: Will Feighner
 * Date: 2020 06 13
 * Purpose: Create a Program to that computes the sales tax
 * for a collection of automobiles of different types and
 * the total cost for each of those automobiles.
 */
// import statements

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CMIS242PRJ2FeighnerW {

  public static void main(String[] args) {
//Declare an array for automobile data
    Automobile[] automobileArray = new Automobile[0];

    // Create an object of JFrame class
    JFrame displayFrame = new JFrame("Automobile Sales Tax Calculator");
    displayFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    displayFrame.setLocationRelativeTo(null);
    displayFrame.setSize(400, 365);
    // Function to set the Default Close Operation of JFrame

    // Initialize buttons, labels, & text fields.
    JPanel displayPanel = new JPanel();

    ButtonGroup buttonGroup1 = new ButtonGroup();
    JPanel inputPanel = new JPanel();
    JLabel salesPriceLabel = new JLabel();
    JTextField salesPriceInput = new JTextField();
    JLabel makeModelLabel = new JLabel();
    JTextField makeModelInput = new JTextField();
    JPanel typePanel = new JPanel();
    JLabel milesPerGallonLabel = new JLabel();
    JTextField milesPerGallonInput = new JTextField();
    JRadioButton hybridRadioButton = new JRadioButton();
    JLabel weightInPoundsLabel = new JLabel();
    JTextField weightInPoundsInput = new JTextField();
    JRadioButton electricRadioButton = new JRadioButton();
    JRadioButton otherRadioButton = new JRadioButton();
    JPanel computationPanel = new JPanel();
    JButton exitButton = new JButton();
    JButton clearFieldsButton = new JButton();
    JTextField salesTaxOutput = new JTextField();
    JButton displayReportButton = new JButton();
    JButton computeSalesTaxButton = new JButton();

    // Modify top panel components
    salesPriceLabel.setText("Sales Price");

    makeModelLabel.setText("Make and Model");
    salesPriceInput.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent evt) {
        try {
          if (!salesPriceInput.getText().equals("")) {
            Integer.parseInt(salesPriceInput.getText());
          } // end if null test
        } catch (NumberFormatException nfe) {
          JOptionPane.showMessageDialog(displayFrame, "Please enter only whole dollars", "Error", JOptionPane.ERROR_MESSAGE);
          salesPriceInput.setText("");
        } // end try/catch block
      } // end keyReleased(KeyEvent evt)
    } // end anonymous inner class
    );

    // Create layout, add objects, add to panel
    GroupLayout inputPanelLayout = new GroupLayout(inputPanel);
    inputPanel.setLayout(inputPanelLayout);
    inputPanelLayout.setHorizontalGroup(
        inputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(makeModelLabel)
                    .addComponent(salesPriceLabel))
                .addGap(18, 18, 18)
                .addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(makeModelInput)
                    .addComponent(salesPriceInput, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
    );
    inputPanelLayout.setVerticalGroup(
        inputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(inputPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(makeModelLabel)
                    .addComponent(makeModelInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(salesPriceLabel)
                    .addComponent(salesPriceInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
    );

    // Create 
    typePanel.setBorder(BorderFactory.createTitledBorder("Automobile Type"));
    typePanel.setName("Automobile Type");
    typePanel.setPreferredSize(new Dimension(380, 125));

    milesPerGallonLabel.setText("Miles per Gallon");
    milesPerGallonLabel.setVisible(false);
    milesPerGallonInput.setVisible(false);
    milesPerGallonInput.setEditable(false);
    milesPerGallonInput.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent evt) {
        try {
          if (milesPerGallonInput.getText().equals("")) {
          } else {
            Integer.parseInt(milesPerGallonInput.getText());
          }
        } catch (NumberFormatException nfe) {
          JOptionPane.showMessageDialog(displayFrame, "Please enter only whole MPG", "Error", JOptionPane.ERROR_MESSAGE);
          milesPerGallonInput.setText("");
        }
      }
    });

    // Add radio buttons in a Button Group so only one radio button can be selected at a time.
    buttonGroup1.add(hybridRadioButton);

    hybridRadioButton.setText("Hybrid");
    hybridRadioButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt
      ) {
        weightInPoundsLabel.setVisible(false);
        weightInPoundsInput.setVisible(false);
        weightInPoundsInput.setEditable(false);
        weightInPoundsInput.setText("");
        milesPerGallonLabel.setVisible(true);
        milesPerGallonInput.setVisible(true);
        milesPerGallonInput.setEditable(true);
      }
    });

    weightInPoundsLabel.setText("Weight in Pounds");
    weightInPoundsLabel.setVisible(false);
    weightInPoundsInput.setVisible(false);
    weightInPoundsInput.setEditable(false);
    weightInPoundsInput.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent evt) {
        try {
          if (weightInPoundsInput.getText().equals("")) {
          } else {
            Integer.parseInt(weightInPoundsInput.getText());
          }
        } catch (NumberFormatException nfe) {
          JOptionPane.showMessageDialog(displayFrame, "Please enter only whole pounds", "Error", JOptionPane.ERROR_MESSAGE);
          weightInPoundsInput.setText("");
        }
      }
    });

    buttonGroup1.add(electricRadioButton);

    electricRadioButton.setText("Electric");
    electricRadioButton.addActionListener(new ActionListener() {
                                            public void actionPerformed(ActionEvent evt) {
                                              weightInPoundsLabel.setVisible(true);
                                              weightInPoundsInput.setVisible(true);
                                              weightInPoundsInput.setEditable(true);
                                              milesPerGallonLabel.setVisible(false);
                                              milesPerGallonInput.setVisible(false);
                                              milesPerGallonInput.setEditable(false);
                                              milesPerGallonInput.setText("");
                                            }
                                          }
    );

    buttonGroup1.add(otherRadioButton);
    otherRadioButton.setSelected(true);
    otherRadioButton.setText("Other");
    otherRadioButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        milesPerGallonLabel.setVisible(false);
        milesPerGallonInput.setVisible(false);
        milesPerGallonInput.setEditable(false);
        milesPerGallonInput.setText("");
        weightInPoundsLabel.setVisible(false);
        weightInPoundsInput.setVisible(false);
        weightInPoundsInput.setEditable(false);
        weightInPoundsInput.setText("");
      }
    });

    GroupLayout typePanelLayout = new GroupLayout(typePanel);
    typePanel.setLayout(typePanelLayout);
    typePanelLayout.setHorizontalGroup(
        typePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(typePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(typePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(otherRadioButton)
                    .addGroup(typePanelLayout.createSequentialGroup()
                        .addGroup(typePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(hybridRadioButton)
                            .addComponent(electricRadioButton))
                        .addGap(40, 40, 40)
                        .addGroup(typePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(milesPerGallonLabel)
                            .addComponent(weightInPoundsLabel))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(typePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(milesPerGallonInput, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                            .addComponent(weightInPoundsInput, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
    );
    typePanelLayout.setVerticalGroup(
        typePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(typePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(typePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(hybridRadioButton)
                    .addComponent(milesPerGallonLabel)
                    .addComponent(milesPerGallonInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(typePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(electricRadioButton)
                    .addComponent(weightInPoundsLabel)
                    .addComponent(weightInPoundsInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(otherRadioButton)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    exitButton.setText("Exit");
    exitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent evt) {
        System.exit(0);
      }
    });

    salesTaxOutput.setEditable(false);

    displayReportButton.setText("Display Report");
    displayReportButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        for (int i = 0; i < automobileArray.length; i++) {
          System.out.println(automobileArray[i].toString());
        }
      }
    });

    clearFieldsButton.setText("Clear Fields");
    clearFieldsButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        salesTaxOutput.setText("");
        salesPriceInput.setText("");
        makeModelInput.setText("");
        milesPerGallonInput.setText("");
        weightInPoundsInput.setText("");
        otherRadioButton.setSelected(true);
        makeModelInput.requestFocus();
      }
    });

    computeSalesTaxButton.setText("Compute Sales Tax");
    computeSalesTaxButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent evt) {
        if (hybridRadioButton.isSelected()) {
          String makeModel = makeModelInput.getText();
          int salesPrice = Integer.parseInt(salesPriceInput.getText());
          int weight = Integer.parseInt(milesPerGallonInput.getText());
          Hybrid tempAuto = new Hybrid(makeModel, salesPrice, weight);
          //automobileArray = Arrays.copyOf(automobileArray, automobileArray.length + 1);
          //automobileArray[automobileArray.length - 1] = tempAuto;
          salesTaxOutput.setText(String.valueOf(tempAuto.salesTax()));
        } else if (electricRadioButton.isSelected()) {
          String makeModel = makeModelInput.getText();
          int salesPrice = Integer.parseInt(salesPriceInput.getText());
          int weight = Integer.parseInt(weightInPoundsInput.getText());
          Electric tempAuto = new Electric(makeModel, salesPrice, weight);
          //automobileArray = Arrays.copyOf(automobileArray, automobileArray.length + 1);
          //automobileArray[automobileArray.length - 1] = tempAuto;
          salesTaxOutput.setText(String.valueOf(tempAuto.salesTax()));
        } else {
          String makeModel = makeModelInput.getText();
          int salesPrice = Integer.parseInt(salesPriceInput.getText());
          Automobile tempAuto = new Automobile(makeModel, salesPrice);
          //automobileArray = Arrays.copyOf(automobileArray, automobileArray.length + 1);
          //automobileArray[automobileArray.length - 1] = tempAuto;
          salesTaxOutput.setText(String.valueOf(tempAuto.salesTax()));
        }
      }
    });

    GroupLayout computationPanelLayout = new GroupLayout(computationPanel);
    computationPanel.setLayout(computationPanelLayout);
    computationPanelLayout.setHorizontalGroup(computationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(computationPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(computationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(displayReportButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(exitButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(computeSalesTaxButton, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(computationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                .addComponent(clearFieldsButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(salesTaxOutput))
            .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    computationPanelLayout.setVerticalGroup(computationPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(computationPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(computationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(computeSalesTaxButton)
                .addComponent(salesTaxOutput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(computationPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(displayReportButton)
                .addComponent(clearFieldsButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(exitButton)
            .addContainerGap())
    );

    GroupLayout layout = new GroupLayout(displayPanel);
    displayPanel.setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(inputPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(typePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(computationPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(typePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(computationPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    displayFrame.add(displayPanel);
    displayFrame.setVisible(true);

    // Default Layout Options

    /* Add Key Listeners to make sure input is an integer. */
    /* Add Action Listeners for all buttons. */

    /* Various elements of the GUI structure */
  } // End main method

  static class Automobile {

    // Base sales tax of 5% applies to all automobiles declaration
    protected static final int SALESTAXDIVISOR = 20;
    // Automobiles Make and Model declaration
    protected final String makeAndModel;
    // Specified in whole US dollars declaration
    protected final int salesPrice;

    // Times "Compute Sales Tax" button was clicked declaration

    /* Constructor. */
    public Automobile(String makeAndModel, int salesPrice) {
      this.makeAndModel = makeAndModel;
      this.salesPrice = salesPrice;
    } // End of constructor. (Automobile class)

    // salesTax method returns the base sales tax computed as 5% of the sales price
    public int salesTax() {
      return this.salesPrice / SALESTAXDIVISOR;
    } // End salesTax()

    // toString() method returns a string containing appropriate data labeled.
    @Override
    public String toString() {
      return "\nMake and Model: " + this.makeAndModel
          + "\nSales Price: $ " + this.salesPrice
          + "\nSales Tax: $ " + this.salesTax()
          + "\nVehicle Type: Other"
          + "\nVehicle Unique (None): 0"
          + "\nTotalCost: $ " + (this.salesPrice + this.salesTax());
    } // end toString()
  } // end Static   static class Automobile (superclass)

  static class Electric extends Automobile {

    private final int weight; // Vehicle weight in pounds.

    // Constructor for Electric class.
    public Electric(String makeAndModel, int salesPrice, int weight) {
      super(makeAndModel, salesPrice);
      this.weight = weight;
    } // End of Constructor. (Electric subclass)

    // salesTax method sales tax for Electric Automobile
    @Override
    public int salesTax() {
      if (this.weight <= 3000) {
        return (this.salesPrice / SALESTAXDIVISOR) - 200;
      } else {
        return (this.salesPrice / SALESTAXDIVISOR) - 150;
      } // End if/else block
    } // end electric salesTax

    // toString() method returns a string containing appropriate data labeled for Electric automobile.
    @Override
    public String toString() {
      return "\nMake and Model: " + this.makeAndModel
          + "\nSales Price: $ " + this.salesPrice
          + "\nSales Tax: $ " + this.salesTax()
          + "\nVehicle Type: Electric"
          + "\nVehicle Unique (Weight): " + this.weight
          + "\nTotalCost: $ " + (this.salesPrice + this.salesTax());
    } // End Electric toString

  } // End of Electric class (subclass)

  static class Hybrid extends Automobile {

    private final int milesPerGallon;

    // Constructor for Hybrid subclass.
    public Hybrid(String makeAndModel, int salesPrice, int milesPerGallon) {
      super(makeAndModel, salesPrice);
      this.milesPerGallon = milesPerGallon;
    } // End of Hybrid constructor. (Hybrid subclass)

    // salesTax method sales tax for Hybrid Automobile
    @Override
    public int salesTax() {
      if (this.milesPerGallon > 40) {
        return ((this.salesPrice / SALESTAXDIVISOR) - 100)
            - ((this.milesPerGallon - 40) * 2);
      } else {
        return (this.salesPrice / SALESTAXDIVISOR) - 100;
      } // end if/else block
    } // end salesTax

    // toString() method returns a string containing appropriate data labeled for Hybrid automobile.
    @Override
    public String toString() {
      return "\nMake and Model: " + this.makeAndModel
          + "\nSales Price: $ " + this.salesPrice
          + "\nSales Tax: $ " + this.salesTax()
          + "\nVehicle Type: Hybrid"
          + "\nVehicle Unique (MPG): " + this.milesPerGallon
          + "\nTotalCost: $ " + (this.salesPrice + this.salesTax());
    } // End Electric toString
  } // End of Hybrid class (subclass)

} // End public class CMIS242PRJ2FeighnerW
