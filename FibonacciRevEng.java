package fibonacci;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class FibonacciRevEng extends JFrame {
  private JPanel Button;
  
  private JLabel CautionLabel;
  
  private JLabel GameDescription1;
  
  private JLabel GameDescription2;
  
  private JLabel GameDescription3;
  
  private JButton GenerateButton;
  
  private JPanel IntroPanel;
  
  private JPanel Labels;
  
  private JTextArea Results;
  
  private JScrollPane ResultsPanel;
  
  private JPanel Slider;
  
  private JPanel jPanel;
  
  private JSlider jSlider1;
  
  private JCheckBox recursively;
  
  public FibonacciRevEng() {
    initComponents();
    setTitle("The Fibonacci Sequence");
  }
  
  private void initComponents() {
    this.jPanel = new JPanel();
    this.IntroPanel = new JPanel();
    this.Labels = new JPanel();
    this.GameDescription1 = new JLabel();
    this.GameDescription2 = new JLabel();
    this.GameDescription3 = new JLabel();
    this.Slider = new JPanel();
    this.jSlider1 = new JSlider();
    this.CautionLabel = new JLabel();
    this.Button = new JPanel();
    this.GenerateButton = new JButton();
    this.recursively = new JCheckBox();
    this.ResultsPanel = new JScrollPane();
    this.Results = new JTextArea();
    setDefaultCloseOperation(3);
    setSize(new Dimension(300, 200));
    this.jPanel.setMinimumSize(new Dimension(300, 200));
    this.jPanel.setSize(new Dimension(300, 200));
    this.jPanel.setLayout(new BorderLayout());
    this.IntroPanel.setMaximumSize(new Dimension(400, 2147483647));
    this.IntroPanel.setMinimumSize(new Dimension(510, 150));
    this.IntroPanel.setPreferredSize(new Dimension(674, 150));
    this.IntroPanel.setLayout(new BorderLayout());
    this.GameDescription1.setFont(new Font("Garamond", 0, 18));
    this.GameDescription1.setHorizontalAlignment(0);
    this.GameDescription1.setText("How many rabbits are there after ");
    this.Labels.add(this.GameDescription1);
    this.GameDescription2.setFont(new Font("Garamond", 0, 18));
    this.GameDescription2.setHorizontalAlignment(0);
    this.GameDescription2.setText("10");
    this.Labels.add(this.GameDescription2);
    this.GameDescription3.setFont(new Font("Garamond", 0, 18));
    this.GameDescription3.setHorizontalAlignment(0);
    this.GameDescription3.setText("generations?");
    this.Labels.add(this.GameDescription3);
    this.IntroPanel.add(this.Labels, "North");
    this.Slider.setBounds(new Rectangle(0, 0, 0, 0));
    this.Slider.setMinimumSize(new Dimension(46, 20));
    this.Slider.setPreferredSize(new Dimension(140, 20));
    this.jSlider1.setMaximum(93);
    this.jSlider1.setMinimum(1);
    this.jSlider1.setPaintLabels(true);
    this.jSlider1.setPaintTicks(true);
    this.jSlider1.setSnapToTicks(true);
    this.jSlider1.setValue(11);
    this.jSlider1.addChangeListener(new ChangeListener() {
          public void stateChanged(ChangeEvent evt) {
            FibonacciRevEng.this.changeGeneration(evt);
          }
        });
    this.CautionLabel.setFont(new Font("Garamond", 0, 14));
    this.CautionLabel.setText("Caution, after generation 40 your computer might get busy calculating...");
    GroupLayout SliderLayout = new GroupLayout(this.Slider);
    this.Slider.setLayout(SliderLayout);
    SliderLayout.setHorizontalGroup(SliderLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(SliderLayout.createSequentialGroup()
          .addGroup(SliderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(SliderLayout.createSequentialGroup()
              .addGap(116, 116, 116)
              .addComponent(this.jSlider1, -2, -1, -2))
            .addGroup(SliderLayout.createSequentialGroup()
              .addGap(20, 20, 20)
              .addComponent(this.CautionLabel)))
          .addGap(19, 19, 19)));
    SliderLayout.setVerticalGroup(SliderLayout
        .createParallelGroup(GroupLayout.Alignment.LEADING)
        .addGroup(SliderLayout.createSequentialGroup()
          .addGap(5, 5, 5)
          .addComponent(this.jSlider1, -2, -1, -2)
          .addGap(18, 18, 18)
          .addComponent(this.CautionLabel)
          .addContainerGap()));
    this.IntroPanel.add(this.Slider, "Center");
    this.GenerateButton.setFont(new Font("Garamond", 1, 18));
    this.GenerateButton.setText("Generate!");
    this.GenerateButton.setAlignmentY(0.0F);
    this.GenerateButton.setHorizontalTextPosition(0);
    this.GenerateButton.setMaximumSize(new Dimension(200, 30));
    this.GenerateButton.setMinimumSize(new Dimension(120, 30));
    this.GenerateButton.setPreferredSize(new Dimension(120, 30));
    this.GenerateButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            FibonacciRevEng.this.buttonPressed(evt);
          }
        });
    this.Button.add(this.GenerateButton);
    this.recursively.setFont(new Font("Garamond", 0, 14));
    this.recursively.setText("recursively");
    this.Button.add(this.recursively);
    this.IntroPanel.add(this.Button, "South");
    this.jPanel.add(this.IntroPanel, "North");
    this.ResultsPanel.setBorder(BorderFactory.createEtchedBorder());
    this.ResultsPanel.setAutoscrolls(true);
    this.ResultsPanel.setFont(new Font("Garamond", 0, 14));
    this.ResultsPanel.setPreferredSize(new Dimension(20, 20));
    this.Results.setEditable(false);
    this.Results.setColumns(20);
    this.Results.setLineWrap(true);
    this.Results.setRows(5);
    this.Results.setAlignmentY(0.0F);
    this.Results.setSize(new Dimension(230, 120));
    this.ResultsPanel.setViewportView(this.Results);
    this.jPanel.add(this.ResultsPanel, "Center");
    getContentPane().add(this.jPanel, "Center");
    setSize(new Dimension(433, 462));
    setLocationRelativeTo(null);
  }
  
  private void buttonPressed(ActionEvent evt) {
    calculateSequence();
  }
  
  private void changeGeneration(ChangeEvent evt) {
    this.GameDescription2.setText(Integer.toString(this.jSlider1.getModel().getValue() - 1));
  }
  
  public static void main(String[] args) {
    try {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        } 
      } 
    } catch (ClassNotFoundException|InstantiationException|IllegalAccessException|javax.swing.UnsupportedLookAndFeelException ex) {
      Logger.getLogger(JFramingFibonacci.class.getName()).log(Level.SEVERE, (String)null, ex);
    } 
    EventQueue.invokeLater(() -> (new JFramingFibonacci()).setVisible(true));
  }
  
  private void calculateSequence() {
    setCursor(Cursor.getPredefinedCursor(3));
    clearResults();
    for (int i = 1; i < this.jSlider1.getModel().getValue(); i++) {
      if (this.recursively.isSelected()) {
        this.Results.append("In generation " + i + " there are " + fibo(i) + " rabbits.\n");
      } else {
        this.Results.append("In generation " + i + " there are " + fiboWithoutRecursion(i) + " rabbits.\n");
      } 
    } 
    setCursor(Cursor.getDefaultCursor());
  }
  
  private long fibo(int n) {
    if (n <= 1)
      return n; 
    return fibo(n - 1) + fibo(n - 2);
  }
  
  private void clearResults() {
    this.Results.selectAll();
    this.Results.replaceRange("", 0, this.Results.getSelectionEnd());
  }
  
  private long fiboWithoutRecursion(int number) {
    long j = 0;
    for (int i = 0; i <= number; i++)
      j = addFibonacciS(i); 
    return j;
  }
  
  public static long addFibonacciS(long n) {
    if (n == 0L)
      return 0L; 
    if (n == 1L)
      return 1L; 
    long first = 0L;
    long second = 1L;
    long nth = 1L;
    long i;
    for (i = 2L; i <= n; i++) {
      nth = first + second;
      first = second;
      second = nth;
    } 
    return nth;
  }
}
