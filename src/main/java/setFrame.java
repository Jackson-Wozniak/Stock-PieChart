import javax.swing.*;
import java.util.ArrayList;

public class setFrame extends JFrame{
    public setFrame(){
        this.setLayout(null);

        ArrayList<String> names = new ArrayList<>(); //keep list of names to set pie chart
        ArrayList<Double> values = new ArrayList<>(); //keep list of values for each name

        JLabel nameLabel = new JLabel("Enter Name: ");
        nameLabel.setBounds(60,10,100,30);
        this.add(nameLabel);

        JLabel valueLabel = new JLabel("Enter Value: ");
        valueLabel.setBounds(60,60,100,30);
        this.add(valueLabel);


        JTextField nameTxt = new JTextField();
        nameTxt.setBounds(180,10,150,30);
        this.add(nameTxt);

        JTextField valueTxt = new JTextField();
        valueTxt.setBounds(180,60,150,30);
        this.add(valueTxt);

        //label to let user know what stocks are being counted currently
        /*JLabel currentStocks = new JLabel("Current Stocks: ");
        currentStocks.setBounds(20,100,500,30);
        this.add(currentStocks);*/

        JButton addStock = new JButton("Add");
        addStock.setFocusable(false);
        addStock.setBounds(350,10,100,30);
        this.add(addStock);
        addStock.addActionListener(e -> {
            try{
                if(Double.parseDouble(valueTxt.getText()) >= 0){
                    names.add(nameTxt.getText());
                    values.add(Double.parseDouble(valueTxt.getText()));
                }else{
                  negativeNumberError();
                }
            }catch (Exception ex){
                emptyInputError();
            }
            //currentStocks.setText("Current Stocks: " + names);
            nameTxt.setText("");
            valueTxt.setText("");
            nameTxt.requestFocus();
        });

        JButton setChart = new JButton("Make Chart");
        setChart.setBounds(350,60,100,30);
        setChart.setFocusable(false);
        this.add(setChart);
        setChart.addActionListener(e -> {
            JPanel panel = new setPieChart(values, names);
            panel.setBounds(20,120,510,320);
            this.add(panel);
            this.setVisible(true);
        });

        this.setResizable(false);
        this.setSize(570,490);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void emptyInputError(){
        JOptionPane.showMessageDialog(new JFrame(), "Invalid or empty input",
                "Invalid Attempt", JOptionPane.ERROR_MESSAGE);
    }

    public void negativeNumberError(){
        JOptionPane.showMessageDialog(new JFrame(), "Stock Price must be positive",
                "Invalid Attempt", JOptionPane.ERROR_MESSAGE);
    }
}
