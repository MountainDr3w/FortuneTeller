import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class FortuneTellerFrame extends JFrame{
    //Add random
    Random rand = new Random();

    //Array of Fortunes
    ArrayList<String> fortuneList = new ArrayList<>(Arrays.asList(
            "You will find a penny on the ground",
            "A stray dog will ask you for a hamburger",
            "6 mice will perform a sacrifice for you",
            "Your car will break down",
            "You will trip on a rock",
            "An emu will use you as bait to catch a fish",
            "Someone close to you will receive a great fortune",
            "Your arch enemy will stub their toe",
            "Tom Brady will win another ring",
            "You will find a gift with your name on it in a Walgreens",
            "A troll will block your passage to work",
            "The love of your life will marry someone else"));


    //Top Panel
    JPanel topPanel;


    //Middle Panel
    JPanel midPanel;
    JTextArea displayFortunes;
    int pastFort = -1;

    //Bottom Panel
    JPanel botPanel;


    public FortuneTellerFrame(){
        setTitle("Fortune Teller");

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // center frame in screen
        setSize((screenWidth)/ 2, screenHeight / 2);
        setLocation(screenWidth / 4, screenHeight / 4);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        createTopPanel();
        createMidPanel();
        createBotPanel();


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());


        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(midPanel, BorderLayout.CENTER);
        mainPanel.add(botPanel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private void createTopPanel() {
        //Top Panel
        /*
        A label with "Fortune Teller"
        An image icon "magic orb"
        Large font size 36-48
        add image file to directory
         */
        topPanel = new JPanel();
        topPanel.setBackground(new Color(99,18,214));
        ImageIcon ball = new ImageIcon("src/ball.png");
        JLabel titleLabel = new JLabel("Fortune Teller", ball, JLabel.CENTER);

        //Sets the text above the png
        titleLabel.setVerticalTextPosition(JLabel.TOP);
        titleLabel.setHorizontalTextPosition(JLabel.CENTER);

        titleLabel.setFont(new Font("Algerian", Font.BOLD, 48));
        titleLabel.setForeground(new Color(255, 255, 255));
        topPanel.add(titleLabel);
    }

    private void createMidPanel() {
        //Middle Panel
        /*
        JScroll panel{
        JText area
        "Fortunes displayed here"
        }
         */
        midPanel = new JPanel();
        midPanel.setBackground(new Color(99,18,214));
        displayFortunes = new JTextArea(10,35);
        displayFortunes.setBackground(new Color(134, 90, 212));
        displayFortunes.setFont(new Font("Serif", Font.ITALIC, 24));
        displayFortunes.setForeground(new Color(255,255,255));
        displayFortunes.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayFortunes);
        midPanel.add(scrollPane);
    }

    private void createBotPanel() {
        //Bottom Panel
        /*
        Button "Read my Fortune"
        Button "Quit"
         */
        botPanel = new JPanel();
        botPanel.setBackground(new Color(99,18,214));
        botPanel.setLayout(new GridLayout(1,2));

        JButton readBtn = new JButton("Read Fortune!");
        readBtn.setBackground(new Color(239, 168, 37));

        JButton qBtn = new JButton("Quit");
        qBtn.setBackground(new Color(239, 168, 37));



        readBtn.addActionListener((ActionEvent ae) -> addFortune());
        qBtn.addActionListener((ActionEvent ae) -> System.exit(0));

        botPanel.add(readBtn);
        botPanel.add(qBtn);

    }

    private void addFortune() {
        int fortune = rand.nextInt(12);

        do{
           fortune = rand.nextInt(12);
        } while((fortune == pastFort));

        pastFort = fortune;
        displayFortunes.append(fortuneList.get(fortune) + "!\n");
    }

}