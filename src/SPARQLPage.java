import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class SPARQLPage implements ActionListener {

    JFrame frame = new JFrame();
    JComboBox<String> comboBox;
    JComboBox<String> secondComboBox;
    JButton executeQuery = new JButton("Execute Query");
    JPanel responsePanel = new JPanel();
    JLabel responseLabel = new JLabel();

    SPARQLPage(){

        String[] SPRAQL_Questions = {
            "What is the GPs to Pharmacies ratio in an Area?",
            "What is the ratio of GPs in Ireland to Population?",
            "What is the ratio of GPs to Population in a County?",
            "What is the ratio of Pharmacies in Ireland to Population?",
            "What is the ratio of Pharmacies to Population in a County?",
            "How long is a Departments waiting lists across in and out patients?",
            "What is the average wait time (for a Department) across in and out patients?",
            "What is the longest wait time(for a Department) across in and out patients?",
            "What Hospital has the longest waiting list across in and out patients?",
            "What percentage of patients are waiting over a certain amount of time?"
        };

        // Combo boxes

        comboBox = new JComboBox<>(SPRAQL_Questions);
        comboBox.addActionListener(this);
        comboBox.setBounds(70, 20, 480, 50);
        comboBox.setFont(new Font("SANS_SERIF", Font.BOLD, 15));

        secondComboBox = new JComboBox<>();
        secondComboBox.addActionListener(this);
        secondComboBox.setBounds(190, 100, 200, 40);
        secondComboBox.setFont(new Font("SANS_SERIF", Font.BOLD, 15));

        // Query button

        executeQuery.setBounds(190, 190, 200, 40);
        executeQuery.setFont(new Font("SANS_SERIF", Font.BOLD, 19));
        executeQuery.setFocusable(false);
        executeQuery.addActionListener(this);

        // Response panel

        responsePanel.setBackground(Color.DARK_GRAY);
        responsePanel.setBounds(50, 250, 500, 400);

        // Main frame

        frame.add(comboBox);
        frame.add(secondComboBox);
        frame.add(executeQuery);
        frame.add(responsePanel);

        frame.setTitle("Group M SPARQL Queries");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 700);
        frame.setLayout(null);
        frame.setVisible(true);

        // Set the icon to a red health cross instead of the Java log

        ImageIcon cross = new ImageIcon("HealthcareSupplyDemand\\Images\\healthIcon.png");
        frame.setIconImage(cross.getImage());

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == comboBox){
            if(comboBox.getSelectedIndex() == 1){
                // Integer test = comboBox.getSelectedIndex();
                // secondComboBox.setSelectedItem(test);
                secondComboBox.addItem("Pharmacy");
                secondComboBox.addItem("GP");
                secondComboBox.addItem("Hopistal");
            }
            else {

                secondComboBox.removeAllItems();

            }
        }

        if (e.getSource() == executeQuery){
            comboBox.getSelectedIndex();
            secondComboBox.getSelectedIndex();
            System.out.println(comboBox.getSelectedIndex());
            String queryNumber = "The query number is " + String.valueOf(comboBox.getSelectedIndex()
            + " with secondary query " + String.valueOf(secondComboBox.getSelectedIndex()));
            responseLabel.setText(queryNumber);
            responseLabel.setForeground(Color.WHITE);
            responsePanel.add(responseLabel);
            // This is where we need to hook up the front and back end as far as I get it. This will return the index of the selected question which we can then
            // use to get the associated query and then return the response in the responsePanel - the panel can be used as a container for other components (demonstrated
            // by the Jabel being added to it displaying the query number selected when you press the execute button) so I'm not sure what kind of component the SPRAQL 
            // response is going to return so when that's figured out we can work on that together.
        }
        
        
    }
    

}
