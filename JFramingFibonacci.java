/*
This program generates the famous Fibonacci sequence. However, it also provides some historical 
background to the origin of the sequence and explains the algorithm to readers not familiar with 
its core idea which is recursion.

© markus.krajewski.ch, 2021-11-29, version 0.1.2
    developed with Apache NetBeans 12.4

 */

package fibonacci;

import java.awt.Cursor;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mkr
 */
public class JFramingFibonacci extends javax.swing.JFrame {

  /**
     * This is the entry point of this program. We start with the main() method which will be explained in more detail soon.
     * For understanding the relevant functions of the program you can directly examine the next method named calculateSequence()...
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramingFibonacci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        // syntax follows the lambda expression
        java.awt.EventQueue.invokeLater(() -> {
            new JFramingFibonacci().setVisible(true);
        });
    }

    private void calculateSequence() {
        /* What seems so interesting about calculating this series of numbers?
        There are two reasons, one is the history of this algorithm, the other is
        the style, how this algorithm can be implemented.
        
        1. In 1202, Fibonacci published the Liber Abaci, introducing not only the arabic
             numerals, but also algorithms to occidental mathematics. It contains a famous series of 
             numbers, baptised after him. He developed his example by a famous scenario:
 
            "How Many Pairs of Rabbits Are Created by One Pair in One Year.
        A certain man had one pair of rabbits together in a certain enclosed place, and one wishes to know 
        how many are created from the pair in one year when it is the nature of them in a single month to bear 
        another pair, and in the second month those born to bear also.. Because the abovewritten pair in the first 
        month bore, you will double it; there will be two pairs in one month. One of these, namely the first, bears 
        in the second month, and thus there are in the second month 3 pairs; of these in one month two are 
        pregnant, and in the third month 2 pairs of rabbits are born, and thus there are 5 pairs in the month; in this 
        month 3 pairs are pregnant, and in the fourth month there are 8 pairs, of which 5 pairs bear another 
        5 pairs; these are added to the 8 pairs making 13 pairs in the fifth month; these 5 pairs that are born in 
        this month do not mate in this month, but another 8 pairs are pregnant, and thus there are in the 
        sixth month 21 pairs; to these are added the 13 pairs that are born in the seventh month; there will 
        be 34 pairs in this month; to this are added the 21 pairs that are born in the eighth month; there will be 
        55 pairs in this month; to these are added the 34 pairs that are born in the ninth month; there will be 
        89 pairs in this month; to these are added again the 55 pairs that are born in the tenth month; there will 
        be 144 pairs in this month; to these are added again the 89 pairs that are born in the eleventh month; 
        there will be 233 pairs in this month. To these are still added the 144 pairs that are born in the last month; 
        there will be 377 pairs, and this many pairs are produced from the abovewritten pair in the mentioned 
        place at the end of the one year.
            You can indeed see in the margin how we operated, namely that we added the first number to the second, 
        namely the 1 to the 2, and the second to the third, and the third to the fourth, and the fourth to the fifth, 
        and thus one after another until we added the tenth to the eleventh, namely the 144 to the 233, and we 
        had the abovewritten sum of rabbits, namely 377, and thus you can in order find it for an unending 
        number of months."
        
        2. The sequence of numbers can be calculated in two different ways, on the one hand most elegantly
            by a recursive method which starts with the last generation and goes back to the first, while it
            calls itself as a method while it calls itself as a method while it calls itself as ... 
            until the initial value n=1 is reached. Only then all the numbers are available and can be added to the final
            sum.
            On the other hand, the value can be calculated just by remembering the last and the last but one value.
            This is rather easy concerning calculating power and ressources, however it takes more code to 
            produce the non-recursive algorithm.
        
        In the following, both ways are implemented, so the user can compare the differences by walking through the 
        code line by line...
        */
        
        
        // Change the cursor to a wait state...
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        // Clear the textfield...
        clearResults();
        // Begin calculating...
        for (int i = 1; i < jSlider1.getModel().getValue(); i++) {
            // Determine whether the number shall be generated elegantly or bluntly...
            if (recursively.isSelected()) {
                // "To iterate is human, to recurse divine" (L Peter Deutsch)
                Results.append("In generation " + i + " there are " + fibo(i) + " rabbits.\n");
            } else {
                // This method goes rather by simple additions...
                Results.append("In generation " + i + " there are " + fiboWithoutRecursion(i) + " rabbits.\n");
            }
        }
        // Change the cursor back to a normal state...
        this.setCursor(Cursor.getDefaultCursor());
    }

    private long fibo(int n) {
        /* This code fragment is rather short, because it makes use of a specific trick:
            The method fibo(n) calls itself within its definition: a classical recursion.
            This is most elegant, because the calculation needs only one line to be noted.
            However, this elegance comes with a huge consumption of calculation cycles.
        */
        if (n <= 1) {
            return n;
        } else {
        /* Here comes the crucial line: The return value of the function is a
            double call of the function itself. Before returning number n it has
            to calculate the sum of number n-1 plus number n-2, where n denotes
            the generation of rabbits.
        */        
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    private void clearResults() {
        Results.selectAll();
        Results.replaceRange("", 0, Results.getSelectionEnd());
    }

    public static long fiboWithoutRecursion(int number) {
        /* This code fragment is also short, however it calls another function
            in order to get the concrete number. So to compare the efficiency of
            the two algorithms, one has to put fibo(n) next to addFibonacciS(n).
        */        
        long j = 0;
        for (int i = 0; i <= number; i++) {
            j = addFibonacciS(i);
        }
        return j;
    }

    public static long addFibonacciS(long n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        long first = 0;
        long second = 1;
        long nth = 1;
        for (long i = 2; i <= n; i++) {
            nth = first + second;
            first = second;
            second = nth;
        }
        return nth;
    }
    
    /**
     * Creates new form JFramingFibonacci
     */
    public JFramingFibonacci() {
        initComponents();
        this.setTitle("The Fibonacci Sequence");
    }

      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        IntroPanel = new javax.swing.JPanel();
        Labels = new javax.swing.JPanel();
        GameDescription1 = new javax.swing.JLabel();
        GameDescription2 = new javax.swing.JLabel();
        GameDescription3 = new javax.swing.JLabel();
        Slider = new javax.swing.JPanel();
        jSlider1 = new javax.swing.JSlider();
        CautionLabel = new javax.swing.JLabel();
        Button = new javax.swing.JPanel();
        GenerateButton = new javax.swing.JButton();
        recursively = new javax.swing.JCheckBox();
        ResultsPanel = new javax.swing.JScrollPane();
        Results = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(300, 200));

        jPanel.setMinimumSize(new java.awt.Dimension(300, 200));
        jPanel.setSize(new java.awt.Dimension(300, 200));
        jPanel.setLayout(new java.awt.BorderLayout());

        IntroPanel.setMaximumSize(new java.awt.Dimension(400, 2147483647));
        IntroPanel.setMinimumSize(new java.awt.Dimension(510, 150));
        IntroPanel.setPreferredSize(new java.awt.Dimension(674, 150));
        IntroPanel.setLayout(new java.awt.BorderLayout());

        GameDescription1.setFont(new java.awt.Font("Garamond", 0, 18)); // NOI18N
        GameDescription1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GameDescription1.setText("How many rabbits are there after ");
        Labels.add(GameDescription1);

        GameDescription2.setFont(new java.awt.Font("Garamond", 0, 18)); // NOI18N
        GameDescription2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GameDescription2.setText("10");
        Labels.add(GameDescription2);

        GameDescription3.setFont(new java.awt.Font("Garamond", 0, 18)); // NOI18N
        GameDescription3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GameDescription3.setText("generations?");
        Labels.add(GameDescription3);

        IntroPanel.add(Labels, java.awt.BorderLayout.NORTH);

        Slider.setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        Slider.setMinimumSize(new java.awt.Dimension(46, 20));
        Slider.setPreferredSize(new java.awt.Dimension(140, 20));

        jSlider1.setMaximum(93);
        jSlider1.setMinimum(1);
        jSlider1.setPaintLabels(true);
        jSlider1.setPaintTicks(true);
        jSlider1.setSnapToTicks(true);
        jSlider1.setValue(11);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                changeGeneration(evt);
            }
        });

        CautionLabel.setFont(new java.awt.Font("Garamond", 0, 14)); // NOI18N
        CautionLabel.setText("Caution, after generation 40 your computer might get busy calculating...");

        javax.swing.GroupLayout SliderLayout = new javax.swing.GroupLayout(Slider);
        Slider.setLayout(SliderLayout);
        SliderLayout.setHorizontalGroup(
            SliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SliderLayout.createSequentialGroup()
                .addGroup(SliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SliderLayout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SliderLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(CautionLabel)))
                .addGap(19, 19, 19))
        );
        SliderLayout.setVerticalGroup(
            SliderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SliderLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CautionLabel)
                .addContainerGap())
        );

        IntroPanel.add(Slider, java.awt.BorderLayout.CENTER);

        GenerateButton.setFont(new java.awt.Font("Garamond", 1, 18)); // NOI18N
        GenerateButton.setText("Generate!");
        GenerateButton.setAlignmentY(0.0F);
        GenerateButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        GenerateButton.setMaximumSize(new java.awt.Dimension(200, 30));
        GenerateButton.setMinimumSize(new java.awt.Dimension(120, 30));
        GenerateButton.setPreferredSize(new java.awt.Dimension(120, 30));
        GenerateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPressed(evt);
            }
        });
        Button.add(GenerateButton);

        recursively.setFont(new java.awt.Font("Garamond", 0, 14)); // NOI18N
        recursively.setText("recursively");
        Button.add(recursively);

        IntroPanel.add(Button, java.awt.BorderLayout.SOUTH);

        jPanel.add(IntroPanel, java.awt.BorderLayout.NORTH);

        ResultsPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ResultsPanel.setAutoscrolls(true);
        ResultsPanel.setFont(new java.awt.Font("Garamond", 0, 14)); // NOI18N
        ResultsPanel.setPreferredSize(new java.awt.Dimension(20, 20));

        Results.setEditable(false);
        Results.setColumns(20);
        Results.setLineWrap(true);
        Results.setRows(5);
        Results.setAlignmentY(0.0F);
        Results.setSize(new java.awt.Dimension(230, 120));
        ResultsPanel.setViewportView(Results);

        jPanel.add(ResultsPanel, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(433, 462));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonPressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPressed
        calculateSequence();
    }//GEN-LAST:event_buttonPressed

    private void changeGeneration(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_changeGeneration
        GameDescription2.setText(Integer.toString(jSlider1.getModel().getValue() - 1));        // TODO add your handling code here:
    }//GEN-LAST:event_changeGeneration

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Button;
    private javax.swing.JLabel CautionLabel;
    private javax.swing.JLabel GameDescription1;
    private javax.swing.JLabel GameDescription2;
    private javax.swing.JLabel GameDescription3;
    private javax.swing.JButton GenerateButton;
    private javax.swing.JPanel IntroPanel;
    private javax.swing.JPanel Labels;
    private javax.swing.JTextArea Results;
    private javax.swing.JScrollPane ResultsPanel;
    private javax.swing.JPanel Slider;
    private javax.swing.JPanel jPanel;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JCheckBox recursively;
    // End of variables declaration//GEN-END:variables


}
