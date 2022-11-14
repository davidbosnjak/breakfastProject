import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class UserInterface implements ActionListener, FocusListener {

    static final int LOGIN_HEIGHT = 350;
    static final int LOGIN_WIDTH = 600;
    static CoolComponents.RoundJTextField usernameField = new CoolComponents.RoundJTextField(30);
    static CoolComponents.RoundJTextField userNameSignUpField = new CoolComponents.RoundJTextField(30);

    static JPasswordField passWordField = new CoolComponents.RoundPasswordField(30);
    static JPasswordField passWordSignUpField = new CoolComponents.RoundPasswordField(30);

    static JButton enterImageButton = new JButton();
    static JButton loginButton = new JButton();
    static JButton signupButton = new JButton("Sign up");
    static JFrame loginFrame = new JFrame();
    static JFrame mainFrame = new JFrame();

    static JButton makeAccountButton = new JButton();
    static JPanel loginPanel = new JPanel();
    static String currentUser;
    static JScrollBar scrollBar = new JScrollBar();



    public static void main(String[] args) {
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


        enterImageButton.setIcon(resizeImage("assets/next.png", 40, 40));

        enterImageButton.setBackground(Color.decode("#3498db"));
        enterImageButton.setBounds(470, 140, 40, 40);
        JLabel userNameLabelImage = new JLabel();

        userNameLabelImage.setIcon(resizeImage("assets/user.png", 40, 40));

        userNameLabelImage.setBounds(30, 80, 40, 40);
        loginPanel.add(userNameLabelImage);
        JLabel passwordLabelImage = new JLabel();
        passwordLabelImage.setIcon(resizeImage("assets/padlock.png", 40, 40));
        passwordLabelImage.setBounds(30, 140, 40, 40);
        loginPanel.add(passwordLabelImage);
        loginPanel.add(enterImageButton);
        JLabel loadingLabel = new JLabel();
        loadingLabel.setIcon(resizeImage("assets/FadingLines.gif", 40, 40));
        //ImageIcon loadingGif = new ImageIcon("assets/FadingLines.gif").getImage();
        //https://stackoverflow.com/questions/22240328/how-to-draw-a-gif-animation-in-java/22240487#22240487
        loadingLabel.setBounds(100, 100, 40, 40);
        JLabel signupLabel = new JLabel("Don't have an account? Sign up for one");
        signupLabel.setBounds(60, 190, 250, 30);
        loginPanel.add(signupLabel);
        signupButton.setBounds(60, 220, 100, 30);
        loginButton.setBounds(400, 220, 100, 30);
        loginButton.setText("Login");
        loginPanel.add(loginButton);
        loginPanel.add(signupButton);

        loginFrame.add(loginPanel);
        loginFrame.setVisible(true);


    }

    public static void mainProgram() {

        System.out.println("main program called");
        JLayeredPane mainPane = new JLayeredPane();
        mainPane.setBounds(0, 0, 1280, 720);

        JPanel topPanel = new JPanel(null);
        topPanel.setBounds(250, 0, 1030, 150);
        topPanel.setBackground(Color.decode("#7f8c8d"));
        mainFrame.setSize(1280, 720);
        JPanel mainFramePanel = new JPanel(null);
        mainFramePanel.setBounds(0, 150, 1280, 570);
        mainFramePanel.setBackground(Color.decode("#2c3e50"));

        mainFrame.setVisible(true);
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(null);
        sidePanel.setBounds(0, 0, 250, 720);
        JLabel userNameLabel = new JLabel(currentUser);
        userNameLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        JLabel userNameImageLabel = new JLabel();

        userNameImageLabel.setIcon(resizeImage("assets/user.png", 20, 20));
        userNameImageLabel.setBounds(750, 30, 20, 20);
        topPanel.add(userNameImageLabel);

        userNameLabel.setForeground(Color.BLACK);
        userNameLabel.setBounds(800, 25, 150, 30);
        topPanel.add(userNameLabel);
        CoolComponents.RoundJTextField searchInput = new CoolComponents.RoundJTextField(20);
        searchInput.setFont(new Font("Serif",Font.PLAIN, 20));
        searchInput.setText("Search...");

        searchInput.setBounds(450, 180, 500, 50);
        searchInput.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                searchInput.setText("");
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                searchInput.setText("Search...");
            }
        });

        mainPane.add(searchInput,Integer.valueOf(5));
        JLabel mainLabel = new JLabel("Reservations");
        mainLabel.setFont(new Font("serif", Font.BOLD, 45));
        mainLabel.setBounds(200, 30, 400, 80);
        topPanel.add(mainLabel);
        JLabel reservationsLabel = new JLabel("Options");
        reservationsLabel.setFont(new Font("Serif", Font.BOLD, 25));
        reservationsLabel.setBounds(10, 20, 150, 30);
        sidePanel.add(reservationsLabel);
        mainPane.add(topPanel, Integer.valueOf(1));
        mainPane.add(sidePanel, Integer.valueOf(1));
        JButton makeReservationButton = new JButton("Add Reservation");
        makeReservationButton.setBorderPainted(false);
        makeReservationButton.setFocusPainted(false);
        makeReservationButton.setContentAreaFilled(true);
        makeReservationButton.setOpaque(true);
        makeReservationButton.setBackground(Color.decode("#95a5a6"));
        JButton reservations = new JButton("Reservations");
        reservations.setBorderPainted(false);
        reservations.setFocusPainted(false);
        reservations.setContentAreaFilled(true);
        reservations.setOpaque(true);
        reservations.setBackground(Color.decode("#95a5a6"));
        reservations.setBounds(20,160,150,30);

        sidePanel.add(reservations);
        JButton addMenuItemButton = new JButton("Add Menu Item");
        addMenuItemButton.setBorderPainted(false);
        addMenuItemButton.setContentAreaFilled(false);
        addMenuItemButton.setOpaque(true);
        addMenuItemButton.setBackground(Color.decode("#95a5a6"));
        addMenuItemButton.setBounds(20,200,150,30);
        sidePanel.add(addMenuItemButton);
        JButton editMenu = new JButton("Menu");

        editMenu.setBorderPainted(false);
        editMenu.setFocusPainted(false);
        editMenu.setContentAreaFilled(true);
        editMenu.setBackground(Color.decode("#95a5a6"));
        makeReservationButton.setBounds(20, 80, 150, 30);
        sidePanel.add(makeReservationButton);
        editMenu.setBounds(20, 120, 150, 30);
        Breakfast breakfast = new Breakfast("joe");
        Breakfast breakfast2 = new Breakfast("David", true, 10, 2, new MenuItem("Pancakes"));
        Breakfast breakfast3 = new Breakfast("Max", false, 2, 2, new MenuItem("Eggs"));
        Breakfast breakfast4 = new Breakfast("Met", true, 10, 2, new MenuItem("Pancakes"));
        Breakfast breakfast5 = new Breakfast("Mehmet", false, 4, 2, new MenuItem("Pancakes"));
        ArrayList<Breakfast> breakfastList = new ArrayList<>();
        breakfastList.add(breakfast2);
        breakfastList.add(breakfast);
        breakfastList.add(breakfast4);
        breakfastList.add(breakfast3);
        breakfastList.add(breakfast5);
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        MenuItem menuItem = new MenuItem("Eggs");
        MenuItem menuItem2 = new MenuItem("Pancakes");
        menuItems.add(menuItem2);
        menuItems.add(menuItem);
        searchInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(mainLabel.getText().equals("Reservations")) {
                    ArrayList<Breakfast> map = Search.SearchBreakfast(searchInput.getText(), breakfastList);
                    displayOrders(breakfastList, map, mainFramePanel, mainPane, mainLabel);
                }
                else{
                    ArrayList<MenuItem> map = Search.SearchMenu(searchInput.getText(), menuItems);
                    displayMenu(menuItems,map, mainFramePanel, mainPane, mainLabel);
                }

            }
        });
        JPanel itemDisplayPanel = new JPanel(null);

        itemDisplayPanel.setBounds(0, 0, 1280, 720);

        displayOrders(breakfastList,breakfastList, mainFramePanel, mainPane, mainLabel);
        addMenuItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayList<String> ingredientList = new ArrayList<>(Arrays.asList("test","two"));
                addNewMenuItem(menuItems,ingredientList,mainFramePanel,mainPane, mainLabel );
            }
        });
        reservations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                displayOrders(breakfastList, breakfastList,mainFramePanel,mainPane, mainLabel);
            }
        });
        makeReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addNewReservation(breakfastList, menuItems, mainFramePanel, mainPane, mainLabel);

            }
        });
        editMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                displayMenu(menuItems,menuItems, mainFramePanel, mainPane, mainLabel);
            }
        });
        scrollBar.setBounds(1250,0,30,720);
        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
                mainFramePanel.setBounds(0,scrollBar.getValue()*-10+150,1280,5000);
            }
        });
        mainPane.add(scrollBar,Integer.valueOf(5));

        sidePanel.add(editMenu);
        mainFrame.add(mainPane);


    }
    public static void displayMenu(ArrayList<MenuItem> total,ArrayList<MenuItem> items, JPanel mainPanel, JLayeredPane pane,JLabel mainLabel){
        mainLabel.setText("Menu");
        pane.remove(mainPanel);
        mainPanel.removeAll();
        pane.remove(mainPanel);
        mainPanel.removeAll();
        int i=1;
        for(MenuItem menuitem : items){
            mainPanel.add(displayMenuItem(menuitem, i, items, total,mainPanel, pane, mainLabel));
            i++;
        }
        pane.add(mainPanel, Integer.valueOf(0));


    }

    public static void displayOrders(ArrayList<Breakfast> total,ArrayList<Breakfast> breakfasts, JPanel mainPanel, JLayeredPane pane, JLabel mainLabel) {
        mainLabel.setText("Reservations");
        int i = 1;
        pane.remove(mainPanel);
        mainPanel.removeAll();
        for (Breakfast breakfast : breakfasts) {
            mainPanel.add(displayItem(breakfast, i, breakfasts, total,mainPanel, pane, mainLabel));
            i++;
        }
        pane.add(mainPanel, Integer.valueOf(0));


    }
    public static CoolComponents.RoundedPanel displayMenuItem(MenuItem menuItem, int num,ArrayList<MenuItem> items, ArrayList<MenuItem> total,JPanel mainPanel, JLayeredPane pane, JLabel mainLabel){
        CoolComponents.RoundedPanel displayPanel = new CoolComponents.RoundedPanel(20);
        displayPanel.setOpaque(false);
        displayPanel.setLayout(null);
        displayPanel.setBackground(Color.WHITE);
        displayPanel.setBounds(300, num * 100, 900, 80);
        JLabel breakfastLabel = new JLabel(menuItem.toString());
        JButton deleteImageLabel = new JButton();
        deleteImageLabel.setBorderPainted(false);
        deleteImageLabel.setFocusPainted(false);
        deleteImageLabel.setContentAreaFilled(false);
        deleteImageLabel.setBackground(Color.decode("#95a5a6"));

        deleteImageLabel.setIcon(resizeImage("assets/delete.png", 30, 30));
        deleteImageLabel.setBounds(850, 5, 30, 30);
        displayPanel.add(deleteImageLabel);
        JButton editImageLabel = new JButton();
        editImageLabel.setBorderPainted(false);
        editImageLabel.setFocusPainted(false);
        editImageLabel.setContentAreaFilled(false);
        editImageLabel.setBackground(Color.decode("#95a5a6"));
        deleteImageLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("deleting " + menuItem.getName());
                items.remove(menuItem);
                total.remove(menuItem);
                displayMenu(total,items, mainPanel, pane, mainLabel);
                System.out.println(items.size());
                if(items.size()<5){
                    scrollBar.setValue(0);
                    scrollBar.setVisible(false);
                }
                else{
                    scrollBar.setVisible(true);
                    scrollBar.setMaximum(items.size()*8);
                }

            }
        });
        editImageLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("edit of " + menuItem.getName() + " requested");
            }
        });


        editImageLabel.setIcon(resizeImage("assets/edit.png", 30, 30));
        editImageLabel.setBounds(850, 40, 30, 30);
        displayPanel.add(editImageLabel);
        breakfastLabel.setBounds(20, 0, 500, 50);
        displayPanel.add(breakfastLabel);
        return displayPanel;
    }

    public static void addNewReservation(ArrayList<Breakfast> breakfasts, ArrayList<MenuItem> menuItems, JPanel panel, JLayeredPane mainPane, JLabel mainLabel) {
        JFrame addNewBreakfastFrame = new JFrame();
        addNewBreakfastFrame.setTitle("Add Reservation");
        addNewBreakfastFrame.setSize(300, 500);
        JPanel newBreakfastPanel = new JPanel(null);
        newBreakfastPanel.setBounds(0, 0, 300, 400);
        JLabel titleMessage = new JLabel("Add Reservation");
        titleMessage.setBounds(20, 20, 200, 30);
        titleMessage.setFont(new Font("Serif", Font.BOLD, 15));
        newBreakfastPanel.add(titleMessage);
        JLabel nameLabel = new JLabel("Enter party name");
        nameLabel.setBounds(20, 70, 200, 30);
        JTextField nameField = new JTextField();
        nameField.setBounds(20, 100, 200, 30);
        String[] menuList = new String[menuItems.size()];
        int i = 0;
        for (MenuItem item : menuItems) {
            menuList[i] = item.getName();
            i++;
        }
        JComboBox<String> foodSelector = new JComboBox<>(menuList);
        JLabel foodSelectorLabel = new JLabel("Select Meal");
        foodSelectorLabel.setBounds(20, 130, 200, 30);
        foodSelector.setBounds(20, 160, 200, 30);
        JLabel numberSelectorLabel = new JLabel("Select Guest Number");
        JTextField numberSelectorField = new JTextField();
        numberSelectorLabel.setBounds(20, 190, 200, 30);
        numberSelectorField.setBounds(20, 220, 50, 30);
        JLabel servingSizeLabel = new JLabel("Select Serving Size");
        servingSizeLabel.setBounds(20, 250, 200, 30);
        JComboBox<String> servingSizeSelector = new JComboBox<>(new String[]{"Large", "Regular"});
        servingSizeSelector.setBounds(20, 280, 200, 30);
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(40, 350, 100, 30);
        JLabel wrongInput = new JLabel("Wrong input!");
        wrongInput.setForeground(Color.RED);
        wrongInput.setBounds(40, 330, 200, 30);
        newBreakfastPanel.add(wrongInput);
        wrongInput.setVisible(false);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int numOfPeople = Integer.parseInt(numberSelectorField.getText());
                    if (nameLabel.getText().equals("")) {
                        wrongInput.setVisible(true);
                    } else {
                        addNewBreakfastFrame.dispose();
                        boolean bigEaters = servingSizeSelector.getSelectedItem().equals("Large");
                        int index = foodSelector.getSelectedIndex();
                        Breakfast breakfast = new Breakfast(nameField.getText(), bigEaters, numOfPeople, 0, menuItems.get(index));
                        breakfasts.add(breakfast);
                        scrollBar.setMaximum(breakfasts.size()*8);
                        scrollBar.setVisible(breakfasts.size()>4);

                        displayOrders(breakfasts,breakfasts, panel, mainPane, mainLabel);
                    }

                } catch (NumberFormatException e) {
                    wrongInput.setVisible(true);
                }
            }
        });
        newBreakfastPanel.add(submitButton);
        newBreakfastPanel.add(servingSizeLabel);
        newBreakfastPanel.add(servingSizeSelector);
        newBreakfastPanel.add(numberSelectorField);
        newBreakfastPanel.add(numberSelectorLabel);
        newBreakfastPanel.add(foodSelector);
        newBreakfastPanel.add(nameField);
        newBreakfastPanel.add(nameLabel);
        newBreakfastPanel.add(foodSelectorLabel);
        addNewBreakfastFrame.add(newBreakfastPanel);
        addNewBreakfastFrame.setVisible(true);


    }
    public static void addNewMenuItem(ArrayList<MenuItem> items, ArrayList<String> ingredients, JPanel panel, JLayeredPane mainPane, JLabel mainLabel){
        JFrame addNewBreakfastFrame = new JFrame();
        addNewBreakfastFrame.setTitle("Add Menu Item");
        addNewBreakfastFrame.setSize(300, 500);
        JPanel newBreakfastPanel = new JPanel(null);
        newBreakfastPanel.setBounds(0, 0, 300, 400);
        JLabel titleMessage = new JLabel("Add Item");
        titleMessage.setBounds(20, 20, 200, 30);
        titleMessage.setFont(new Font("Serif", Font.BOLD, 15));
        newBreakfastPanel.add(titleMessage);
        JLabel nameLabel = new JLabel("Enter item name");
        nameLabel.setBounds(20, 70, 200, 30);
        JTextField nameField = new JTextField();
        nameField.setBounds(20, 100, 200, 30);
        String[] ingredientString = ingredients.toArray(new String[0]);
        JTextField eggsField = new JTextField();
        JLabel foodSelectorLabel = new JLabel("Enter number of eggs");
        foodSelectorLabel.setBounds(20, 130, 200, 30);
        eggsField.setBounds(20, 160, 50, 30);
        JLabel numberSelectorLabel = new JLabel("Select amount of butter");
        JTextField butterField = new JTextField();
        numberSelectorLabel.setBounds(20, 190, 200, 30);
        butterField.setBounds(20, 220, 50, 30);
        JLabel servingSizeLabel = new JLabel("Select cups of milk");
        servingSizeLabel.setBounds(20, 250, 200, 30);
        JTextField milkField = new JTextField();
        milkField.setBounds(20, 280, 50, 30);
        JLabel costLabel = new JLabel("Select cost");
        costLabel.setBounds(20,310,200,30);
        JTextField costField = new JTextField();
        costField.setBounds(20,340,80,30);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(40, 380, 100, 30);
        JLabel wrongInput = new JLabel("Wrong input!");
        wrongInput.setForeground(Color.RED);
        wrongInput.setBounds(40, 330, 200, 30);
        newBreakfastPanel.add(wrongInput);
        wrongInput.setVisible(false);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int eggs = Integer.parseInt(eggsField.getText());
                    int milk = Integer.parseInt(milkField.getText());
                    int butter = Integer.parseInt(butterField.getText());
                    double cost = Double.parseDouble(costField.getText());
                    if (nameLabel.getText().equals("")) {
                        wrongInput.setVisible(true);
                    } else {
                        addNewBreakfastFrame.dispose();

                        MenuItem menuItem = new MenuItem(nameField.getText(),eggs,cost,milk,butter);


                        items.add(menuItem);
                        scrollBar.setMaximum(items.size()*8);
                        scrollBar.setVisible(items.size()>4);
                        displayMenu(items,items, panel, mainPane, mainLabel);
                    }

                } catch (NumberFormatException e) {
                    wrongInput.setVisible(true);
                }
            }
        });
        newBreakfastPanel.add(costLabel);
        newBreakfastPanel.add(costField);
        newBreakfastPanel.add(submitButton);
        newBreakfastPanel.add(servingSizeLabel);
        newBreakfastPanel.add(milkField);
        newBreakfastPanel.add(butterField);
        newBreakfastPanel.add(numberSelectorLabel);
        newBreakfastPanel.add(eggsField);
        newBreakfastPanel.add(nameField);
        newBreakfastPanel.add(nameLabel);
        newBreakfastPanel.add(foodSelectorLabel);
        addNewBreakfastFrame.add(newBreakfastPanel);
        addNewBreakfastFrame.setVisible(true);


    }


    public static CoolComponents.RoundedPanel displayItem(Breakfast breakfast, int num, ArrayList<Breakfast> breakfasts, ArrayList<Breakfast> total, JPanel mainPanel, JLayeredPane pane, JLabel mainLabel) {

        CoolComponents.RoundedPanel displayPanel = new CoolComponents.RoundedPanel(20);
        displayPanel.setOpaque(false);
        displayPanel.setLayout(null);
        displayPanel.setBackground(Color.WHITE);
        displayPanel.setBounds(300, num * 100, 900, 80);
        JLabel breakfastLabel = new JLabel(breakfast.toString());
        JButton deleteImageLabel = new JButton();
        deleteImageLabel.setBorderPainted(false);
        deleteImageLabel.setFocusPainted(false);
        deleteImageLabel.setContentAreaFilled(false);
        deleteImageLabel.setBackground(Color.decode("#95a5a6"));

        deleteImageLabel.setIcon(resizeImage("assets/delete.png", 30, 30));
        deleteImageLabel.setBounds(850, 5, 30, 30);
        displayPanel.add(deleteImageLabel);
        JButton editImageLabel = new JButton();
        editImageLabel.setBorderPainted(false);
        editImageLabel.setFocusPainted(false);
        editImageLabel.setContentAreaFilled(false);
        editImageLabel.setBackground(Color.decode("#95a5a6"));
        deleteImageLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("deleting " + breakfast.getPartyName());
                breakfasts.remove(breakfast);
                total.remove(breakfast);
                displayOrders(breakfasts,breakfasts, mainPanel, pane, mainLabel);
                if(breakfasts.size()<5){
                    scrollBar.setValue(0);
                    scrollBar.setVisible(false);
                }
                else{
                    scrollBar.setVisible(true);
                    scrollBar.setMaximum(breakfasts.size()*8);
                }

            }
        });
        editImageLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("edit of " + breakfast.getPartyName() + " requested");
                mealInfo(breakfast);
            }
        });


        editImageLabel.setIcon(resizeImage("assets/information-button.png", 30, 30));
        editImageLabel.setBounds(850, 40, 30, 30);
        displayPanel.add(editImageLabel);
        breakfastLabel.setBounds(20, 0, 500, 50);
        displayPanel.add(breakfastLabel);
        return displayPanel;


    }

    public static void signupWindow() throws IOException {
        JPasswordField newPassField = passWordSignUpField;
        JTextField newUserField = userNameSignUpField;
        newPassField.setText("");


        loginPanel.setBounds(0, 0, LOGIN_WIDTH, LOGIN_HEIGHT);
        loginPanel.setBackground(Color.decode("#3498db"));
        JLabel loginLabel = new JLabel("Sign up");
        loginLabel.setFont(new Font("Helvetica", Font.BOLD, 25));
        loginLabel.setBounds(190, 40, 300, 30);
        loginLabel.setForeground(Color.WHITE);
        loginPanel.add(loginLabel);
        newUserField.setBounds(80, 80, 350, 40);
        newUserField.setFont(new Font("Serif", Font.PLAIN, 20));
        loginPanel.add(newUserField);
        newPassField.addFocusListener(new UserInterface());
        newPassField.setBounds(80, 140, 350, 40);
        newPassField.setFont(new Font("Serif", Font.PLAIN, 25));
        loginPanel.add(newPassField);


        enterImageButton.setIcon(resizeImage("assets/next.png", 40, 40));

        enterImageButton.setBackground(Color.decode("#3498db"));
        enterImageButton.setBounds(470, 140, 40, 40);
        JLabel userNameLabelImage = new JLabel();

        userNameLabelImage.setIcon(resizeImage("assets/user.png", 40, 40));

        userNameLabelImage.setBounds(30, 80, 40, 40);
        loginPanel.add(userNameLabelImage);
        JLabel passwordLabelImage = new JLabel();
        passwordLabelImage.setIcon(resizeImage("assets/padlock.png", 40, 40));
        passwordLabelImage.setBounds(30, 140, 40, 40);
        loginPanel.add(passwordLabelImage);
        loginPanel.add(enterImageButton);
        JLabel loadingLabel = new JLabel();
        loadingLabel.setIcon(resizeImage("assets/FadingLines.gif", 40, 40));
        //ImageIcon loadingGif = new ImageIcon("assets/FadingLines.gif").getImage();
        //https://stackoverflow.com/questions/22240328/how-to-draw-a-gif-animation-in-java/22240487#22240487
        loadingLabel.setBounds(100, 100, 40, 40);
        makeAccountButton.setBounds(200, 220, 100, 30);
        makeAccountButton.setText("Sign up ");


        loginPanel.add(makeAccountButton);

        loginFrame.add(loginPanel);
        loginFrame.setVisible(true);
    }

    public static Icon resizeImage(String fileURL, int width, int height) {

        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File(fileURL));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image scaledImage = bufferedImage.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        return new ImageIcon(scaledImage);
    }
    public static void mealInfo(Breakfast breakfast){
        JFrame mealInfoFrame = new JFrame(breakfast.getPartyName()+" Info");
        JPanel mealInfoPanel = new JPanel(null);
        mealInfoFrame.setSize(400,400);
        JLabel infoLabel = new JLabel(breakfast.getPartyName()+ " Info");
        infoLabel.setFont(new Font("Serif",Font.BOLD,20));
        infoLabel.setBounds(20,10,300,50);
        mealInfoFrame.add(mealInfoPanel);
        JLabel totalEggsLabel  = new JLabel("Total Eggs for order: "+breakfast.calcEggs());
        JLabel totalButterLabel = new JLabel("Total butter for order: "+breakfast.calcButter());
        JLabel totalMilkLabel = new JLabel("Total milk for order: "+breakfast.calcMilk());
        JLabel totalCost = new JLabel("Total cost for order "+breakfast.calcCost());
        JLabel indCost = new JLabel("Cost for one order: "+breakfast.calcCost()/breakfast.getNumOfPeople());
        totalEggsLabel.setBounds(20,50,200,30);
        totalButterLabel.setBounds(20,80,200,30);
        totalMilkLabel.setBounds(20,110,200,30);
        totalCost.setBounds(20,140,200,30);
        indCost.setBounds(20,170,200,30);
        mealInfoPanel.add(totalEggsLabel);
        mealInfoPanel.add(totalCost);
        mealInfoPanel.add(totalButterLabel);
        mealInfoPanel.add(totalMilkLabel);
        mealInfoPanel.add(indCost);

        mealInfoPanel.add(infoLabel);

        mealInfoFrame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterImageButton || e.getSource() == loginButton) {
            System.out.println("logging in");
            if (Authenticator.Authenticate(usernameField.getText(), String.valueOf(passWordField.getPassword()))) {
                System.out.println("Successful login");
                currentUser = usernameField.getText();

                mainProgram();
                loginFrame.dispose();
            } else {
                System.out.println("Wrong login");
            }
        }
        if (e.getSource() == makeAccountButton) {
            Authenticator.makeAccount(userNameSignUpField.getText(), String.valueOf(passWordSignUpField.getPassword()));

            try {
                loginPanel.removeAll();

                login();

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        if (e.getSource() == signupButton) {
            System.out.println("Signup button pressed");
            loginPanel.removeAll();
            try {
                signupWindow();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void focusGained(FocusEvent focusEvent) {

    }

    @Override
    public void focusLost(FocusEvent focusEvent) {

    }
}
