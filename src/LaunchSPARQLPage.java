import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class LaunchSPARQLPage extends JFrame implements ActionListener {

    JFrame frame = new JFrame();
    JButton goToSPARQLbutton = new JButton("Launch SPRAQL Page");
    JLabel owlIcon = new JLabel();
    JLabel rdfIcon = new JLabel();
    JLabel welcomeTitle = new JLabel();
    JLabel targetList = new JLabel("<html><ul>" 
    + "<li>Are there enough pharmacies, hospitals and GPs\n for the population of a county?</li>" 
    + "<li>Hospital waiting list times.</li>" 
    + "<li>The overall demand on the healthcare system in the country.</li>"
    + "</ul><html>");
    JLabel description = new JLabel();

    LaunchSPARQLPage(){

        // Image icons 

        owlIcon.setBounds(-15, 35, 400, 400);
        rdfIcon.setBounds(440, 30, 400, 400);
        
        ImageIcon owlImage = new ImageIcon("Images/OWLogo.png");
        owlIcon.setIcon(owlImage);

        ImageIcon rdfImage = new ImageIcon("images/RDFLogo.png");
        rdfIcon.setIcon(rdfImage);

        // Launch next page button

        goToSPARQLbutton.setBounds(176, 320, 200, 40);
        goToSPARQLbutton.setBackground(Color.GRAY);
        goToSPARQLbutton.setFont(new Font("SANS_SERIF", Font.PLAIN, 16));
        goToSPARQLbutton.setForeground(Color.WHITE);
        goToSPARQLbutton.setBorder(new LineBorder(Color.DARK_GRAY));
        goToSPARQLbutton.setFocusable(false);

        goToSPARQLbutton.addActionListener(this);

        // Welcome text at the top of the page

        welcomeTitle.setBounds(100, 40,400, 40);
        welcomeTitle.setText("Healthcare Supply and Demand Project");
        welcomeTitle.setFont(new Font("SANS_SERIF", Font.BOLD, 20));

        // Bulleted list of what we aim to achieve from our queries

        targetList.setBounds(80, 120, 365, 200);
        targetList.setFont(new Font("SANS_SERIF", Font.BOLD, 14));

        description.setText("Our project invesitgates topical queries such as...");
        description.setBounds(70, 35, 450, 200);
        description.setFont(new Font("SANS_SERIF", Font.BOLD, 15));

        // Main frame

        frame.add(goToSPARQLbutton);
        frame.add(welcomeTitle);
        frame.add(description);
        frame.add(targetList);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);
        frame.setLayout(null);
        frame.add(owlIcon);
        frame.add(rdfIcon);
        frame.setTitle("Group M Knowledge and Data Engineering Project");
        frame.setVisible(true);

        // Set the icon to a red health cross instead of the Java log

        ImageIcon cross = new ImageIcon("Images/healthIcon.png");
        frame.setIconImage(cross.getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if(e.getSource() == goToSPARQLbutton){
            frame.dispose();
            SPARQLPage sparqlPage = new SPARQLPage(); 
        }
        
    }
    
}
