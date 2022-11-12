import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UserInterface implements ActionListener, FocusListener {
    static JFrame frame  = new JFrame();
    static JPanel mainPanel = new JPanel();
    static final int LOGIN_HEIGHT = 350;
    static final int LOGIN_WIDTH = 600;
    static CoolComponents.RoundJTextField usernameField = new CoolComponents.RoundJTextField(30);
    static CoolComponents.RoundJTextField userNameSignUpField = new CoolComponents.RoundJTextField(30);

    static JPasswordField passWordField = new CoolComponents.RoundPasswordField(30);
    static JPasswordField passWordSignUpField = new CoolComponents.RoundPasswordField(30);

    static JButton enterImageButton = new JButton();
    static JButton loginButton  = new JButton();
    static JButton signupButton = new JButton("Sign up");
    static JFrame loginFrame = new JFrame();
    static JFrame mainFrame = new JFrame();
    static JPanel mainFramePanel = new JPanel();

    static JFrame signUpFrame = new JFrame();
    static JButton makeAccountButton = new JButton();






    public static void startInterface(){
        makeAccountButton.addActionListener(new UserInterface());
        enterImageButton.addActionListener(new UserInterface());
        signupButton.addActionListener(new UserInterface());

        try {
            login();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       /*frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(500,500);
       mainPanel.setLayout(null);
       JLabel testLabel = new JLabel("test");
       testLabel.setBounds(10,20,300,30);
       mainPanel.add(testLabel);
       mainPanel.setBounds(0,0,500,500);
       frame.add(mainPanel);
       frame.setVisible(true);
       */




    }
    public static void login() throws IOException {
        usernameField.setText("");
        passWordField.setText("");
        JPanel loginPanel = new JPanel();
        loginFrame.setTitle("Reservation Pro Login");
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginFrame.setSize(LOGIN_WIDTH, LOGIN_HEIGHT);
        loginPanel.setLayout(null);
        loginPanel.setBounds(0, 0, LOGIN_WIDTH, LOGIN_HEIGHT);
        loginPanel.setBackground(Color.decode("#3498db"));
        JLabel loginLabel = new JLabel("Login or Sign up");
        loginLabel.setFont(new Font("Helvetica", Font.BOLD, 25));
        loginLabel.setBounds(190, 40, 300, 30);
        loginLabel.setForeground(Color.WHITE);
        loginPanel.add(loginLabel);
        usernameField.setBounds(80, 80, 350, 40);
        usernameField.setFont(new Font("Serif", Font.PLAIN, 20));
        loginPanel.add(usernameField);
        passWordField.addFocusListener(new UserInterface());
        passWordField.setBounds(80, 140, 350, 40);
        passWordField.setFont(new Font("Serif", Font.PLAIN, 25));
        loginPanel.add(passWordField);
        BufferedImage bufferedImage;


        enterImageButton.setIcon(resizeImage("assets/next.png",40,40));

        enterImageButton.setBackground(Color.decode("#3498db"));
        enterImageButton.setBounds(470, 140, 40, 40);
        JLabel userNameLabelImage = new JLabel();

        userNameLabelImage.setIcon(resizeImage("assets/user.png",40,40));

        userNameLabelImage.setBounds(30,80,40,40);
        loginPanel.add(userNameLabelImage);
        JLabel passwordLabelImage = new JLabel();
        passwordLabelImage.setIcon(resizeImage("assets/padlock.png",40,40));
        passwordLabelImage.setBounds(30,140,40,40);
        loginPanel.add(passwordLabelImage);
        loginPanel.add(enterImageButton);
        JLabel loadingLabel = new JLabel();
        loadingLabel.setIcon(resizeImage("assets/FadingLines.gif",40,40));
        //ImageIcon loadingGif = new ImageIcon("assets/FadingLines.gif").getImage();
        //https://stackoverflow.com/questions/22240328/how-to-draw-a-gif-animation-in-java/22240487#22240487
        loadingLabel.setBounds(100,100,40,40);
        JLabel signupLabel = new JLabel("Don't have an account? Sign up for one");
        signupLabel.setBounds(60,190,250,30);
        loginPanel.add(signupLabel);
        signupButton.setBounds(60,220,100,30);
        loginButton.setBounds(400,220,100,30);
        loginButton.setText("Login");
        loginPanel.add(loginButton);
        loginPanel.add(signupButton);

        loginFrame.add(loginPanel);
        loginFrame.setVisible(true);


    }
    public static void mainProgram(){

        System.out.println("main program called");
        JLayeredPane mainPane = new JLayeredPane();

        mainFrame.setSize(800,400);
        mainFramePanel.setBounds(0,0,800,400);
        mainFramePanel.setBackground(Color.BLACK);
        mainFrame.add(mainFramePanel);
        mainFrame.add(mainFramePanel);
        mainFrame.setVisible(true);
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(null);
        sidePanel.setBounds(0,0,300,400);
        mainFrame.add(sidePanel);

    }
    public static void displayItems(){



    }
    public static void signupWindow() throws IOException {
        userNameSignUpField.setText("");
        passWordSignUpField.setText("");
        JPanel signinPanel = new JPanel();
        signUpFrame.setTitle("Reservation Pro sign up");
        signUpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        signUpFrame.setSize(LOGIN_WIDTH, LOGIN_HEIGHT);
        signinPanel.setLayout(null);
        signinPanel.setBounds(0, 0, LOGIN_WIDTH, LOGIN_HEIGHT);
        signinPanel.setBackground(Color.decode("#3498db"));
        JLabel loginLabel = new JLabel("Sign up");
        loginLabel.setFont(new Font("Helvetica", Font.BOLD, 25));
        loginLabel.setBounds(190, 40, 300, 30);
        loginLabel.setForeground(Color.WHITE);
        signinPanel.add(loginLabel);
        userNameSignUpField.setBounds(80, 80, 350, 40);
        userNameSignUpField.setFont(new Font("Serif", Font.PLAIN, 20));
        signinPanel.add(usernameField);
        passWordSignUpField.addFocusListener(new UserInterface());
        passWordSignUpField.setBounds(80, 140, 350, 40);
        passWordSignUpField.setFont(new Font("Serif", Font.PLAIN, 25));
        signinPanel.add(passWordSignUpField);


        enterImageButton.setIcon(resizeImage("assets/next.png",40,40));

        enterImageButton.setBackground(Color.decode("#3498db"));
        enterImageButton.setBounds(470, 140, 40, 40);
        JLabel userNameLabelImage = new JLabel();

        userNameLabelImage.setIcon(resizeImage("assets/user.png",40,40));

        userNameLabelImage.setBounds(30,80,40,40);
        signinPanel.add(userNameLabelImage);
        JLabel passwordLabelImage = new JLabel();
        passwordLabelImage.setIcon(resizeImage("assets/padlock.png",40,40));
        passwordLabelImage.setBounds(30,140,40,40);
        signinPanel.add(passwordLabelImage);
        signinPanel.add(enterImageButton);
        JLabel loadingLabel = new JLabel();
        loadingLabel.setIcon(resizeImage("assets/FadingLines.gif",40,40));
        //ImageIcon loadingGif = new ImageIcon("assets/FadingLines.gif").getImage();
        //https://stackoverflow.com/questions/22240328/how-to-draw-a-gif-animation-in-java/22240487#22240487
        loadingLabel.setBounds(100,100,40,40);
        makeAccountButton.setBounds(200,220,100,30);
        makeAccountButton.setText("Sign up ");



        signinPanel.add(makeAccountButton);

        signUpFrame.add(signinPanel);
        signUpFrame.setVisible(true);
    }

    public static Icon resizeImage(String fileURL, int width, int height) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(fileURL));
        Image scaledImage = bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        return new ImageIcon(scaledImage);
    }


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == enterImageButton || e.getSource() == loginButton){
            System.out.println("logging in");
            if(Authenticator.Authenticate(usernameField.getText(), String.valueOf(passWordField.getPassword()))){
                System.out.println("Successful login");
            }
            else{
                System.out.println("Wrong login");
            }
        }
        if(e.getSource() == makeAccountButton){
            signUpFrame.dispose();
            try {
                login();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            Authenticator.makeAccount(usernameField.getText(), String.valueOf(passWordField.getPassword()));
        }

        if(e.getSource() == signupButton){
            System.out.println("Signup button pressed");
            loginFrame.dispose();
            try {
                signupWindow();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void focusGained(FocusEvent e){

    }

    @Override
    public void focusLost(FocusEvent e){

    }
}
