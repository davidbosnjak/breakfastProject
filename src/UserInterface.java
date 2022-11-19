//imports
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class UserInterface {

    //constant variables
    static final int LOGIN_HEIGHT = 350;
    static final int LOGIN_WIDTH = 600;
    static final int WINDOW_WIDTH = 1280;
    static final int WINDOW_HEIGHT  = 720;


    //global variables because it was impossible for me to pass them around as parameters
    static String currentUser;
    static JScrollBar scrollBar = new JScrollBar();
    static ArrayList<Breakfast> breakfastList = new ArrayList<>();
    static ArrayList<MenuItem> menuItems = new ArrayList<>();




    //main method
    public static void main(String[] args) {
        //making frame and panel and calling login
        JFrame loginFrame = new JFrame();

        JPanel loginPanel = new JPanel();

        try {
            login(loginFrame,loginPanel);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    //login method
    public static void login(JFrame loginFrame, JPanel loginPanel) throws IOException {
        //rounded text field with 30 rounding
        CoolComponents.RoundJTextField usernameField = new CoolComponents.RoundJTextField(30);
        JPasswordField passWordField = new CoolComponents.RoundPasswordField(30);

        //buttons
        JButton enterImageButton = new JButton();
        JButton loginButton = new JButton("Log in");
        JButton signupButton = new JButton("Sign up");

        JLabel wrongInputLabel = new JLabel("Wrong input");
        wrongInputLabel.setForeground(Color.RED);
        wrongInputLabel.setVisible(false);
        wrongInputLabel.setBounds(300,200,200,30);
        loginPanel.add(wrongInputLabel);


        //event listeners. Note that this time I didn't use a million global variables and didn't have all my event listeners in massive if statement blocks
        enterImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //Check the login details and open the main window if they are good
                System.out.println("logging in");
                if (Authenticator.Authenticate(usernameField.getText(), String.valueOf(passWordField.getPassword()))) {
                    System.out.println("Successful login");
                    currentUser = usernameField.getText();

                    mainProgram(loginFrame,loginPanel);
                    loginFrame.dispose();
                    wrongInputLabel.setVisible(false);


                } else {
                    wrongInputLabel.setVisible(true);
                }

            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //same thing
                System.out.println("logging in");
                if (Authenticator.Authenticate(usernameField.getText(), String.valueOf(passWordField.getPassword()))) {
                    System.out.println("Successful login");
                    currentUser = usernameField.getText();

                    mainProgram(loginFrame,loginPanel);
                    loginFrame.dispose();
                    wrongInputLabel.setVisible(false);

                } else {
                    System.out.println("Wrong login");
                    wrongInputLabel.setVisible(true);

                }
            }
        });

        signupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //opening the signup window
                System.out.println("Signup button pressed");
                loginPanel.removeAll();
                try {
                    signupWindow(loginFrame,loginPanel);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
       //Setting frame and panel details
        loginFrame.setTitle("Reservation Pro Login");
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginFrame.setSize(LOGIN_WIDTH, LOGIN_HEIGHT);
        loginPanel.setLayout(null);
        loginPanel.setBounds(0, 0, LOGIN_WIDTH, LOGIN_HEIGHT);
        loginPanel.setBackground(Color.decode("#3498db"));
        //setting up labels and fonts
        JLabel loginLabel = new JLabel("Login or Sign up");
        loginLabel.setFont(new Font("Helvetica", Font.BOLD, 25));
        loginLabel.setBounds(190, 40, 300, 30);
        loginLabel.setForeground(Color.WHITE);
        loginPanel.add(loginLabel);
        usernameField.setBounds(80, 80, 350, 40);
        usernameField.setFont(new Font("Serif", Font.PLAIN, 20));
        loginPanel.add(usernameField);
        passWordField.setBounds(80, 140, 350, 40);
        passWordField.setFont(new Font("Serif", Font.PLAIN, 25));
        loginPanel.add(passWordField);

        //using my very own resizeImage method to get a resized version of an image
        enterImageButton.setIcon(resizeImage("assets/next.png", 40, 40));

        //more labels, buttons, and fonts. generally setting up components for the login window
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

        JLabel signupLabel = new JLabel("Don't have an account? Sign up for one");
        signupLabel.setBounds(60, 190, 250, 30);
        loginPanel.add(signupLabel);
        signupButton.setBounds(60, 220, 100, 30);
        loginButton.setBounds(400, 220, 100, 30);
        loginPanel.add(loginButton);
        loginPanel.add(signupButton);

        loginFrame.add(loginPanel);
        loginFrame.setVisible(true);


    }

    //main program method. this is for the main window of the program and all the main functionality
    public static void mainProgram(JFrame loginFrame, JPanel loginPanel) {
        //making frame and panel
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("Reservation Pro ");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLayeredPane mainPane = new JLayeredPane();
        mainPane.setBounds(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);

        //making a panel for top of screen
        JPanel topPanel = new JPanel(null);
        topPanel.setBounds(250, 0, 1030, 150);
        topPanel.setBackground(Color.decode("#7f8c8d"));
        mainFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        JPanel mainFramePanel = new JPanel(null);
        mainFramePanel.setBounds(0, 150, WINDOW_WIDTH, WINDOW_HEIGHT);
        mainFramePanel.setBackground(Color.decode("#2c3e50"));

        mainFrame.setVisible(true);
        //sidebar panel
        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(Color.decode("#dfe6e9"));
        sidePanel.setLayout(null);
        sidePanel.setBounds(0, 0, 250, 720);

        //username and image to be displayed in the window
        JLabel userNameLabel = new JLabel(currentUser);
        userNameLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        JLabel userNameImageLabel = new JLabel();

        userNameImageLabel.setIcon(resizeImage("assets/user.png", 20, 20));
        userNameImageLabel.setBounds(750, 30, 20, 20);
        topPanel.add(userNameImageLabel);

        userNameLabel.setForeground(Color.BLACK);
        userNameLabel.setBounds(780, 25, 150, 30);
        topPanel.add(userNameLabel);
        //adding search bar
        CoolComponents.RoundJTextField searchInput = new CoolComponents.RoundJTextField(20);
        searchInput.setFont(new Font("Serif",Font.PLAIN, 20));
        searchInput.setText("   Search...");

        searchInput.setBounds(450, 180, 500, 50);
        //adding focus listener for search bar so when its clicked, the "search" goes away and when focus is lost, it comes back
        searchInput.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent focusEvent) {
                searchInput.setText("");
            }

            @Override
            public void focusLost(FocusEvent focusEvent) {
                searchInput.setText("   Search...");
            }
        });
        //adding labels and stuff
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

        //adding buttons to sidebar
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

        JButton logoutButton = new JButton("Log out");
        logoutButton.setBorderPainted(false);
        logoutButton.setContentAreaFilled(false);
        logoutButton.setOpaque(true);
        logoutButton.setBackground(Color.decode("#95a5a6"));
        sidePanel.add(logoutButton);

        JButton exportButton = new JButton("Export Information");
        exportButton.setBorderPainted(false);
        exportButton.setContentAreaFilled(false);
        exportButton.setOpaque(true);
        exportButton.setBackground(Color.decode("#95a5a6"));
        sidePanel.add(exportButton);

        JButton importButton = new JButton("Import Information");
        importButton.setBorderPainted(false);
        importButton.setContentAreaFilled(false);
        importButton.setOpaque(true);
        importButton.setBackground(Color.decode("#95a5a6"));
        sidePanel.add(importButton);



        //adding actions listener to logout button. when pressed, close the window and open the login
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //clear the lists
                breakfastList.removeAll(breakfastList);
                menuItems.removeAll(menuItems);
                mainFrame.dispose();
                try {
                    login(loginFrame,loginPanel);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        //setting up more buttons
        sidePanel.add(reservations);
        JButton addMenuItemButton = new JButton("Add Menu Item");
        addMenuItemButton.setBorderPainted(false);
        addMenuItemButton.setContentAreaFilled(false);
        addMenuItemButton.setOpaque(true);
        addMenuItemButton.setBackground(Color.decode("#95a5a6"));
        sidePanel.add(addMenuItemButton);
        JButton displayMenu = new JButton("Menu");

        JButton addItem  = new JButton(resizeImage("assets/add.png",50,50));
        addItem.setBounds(1100,180,40,40);
        addItem.setBorderPainted(false);
        addItem.setFocusPainted(true);
        addItem.setOpaque(true);
        addItem.setContentAreaFilled(false);
        mainPane.add(addItem);


        displayMenu.setBorderPainted(false);
        displayMenu.setFocusPainted(false);
        displayMenu.setContentAreaFilled(true);
        displayMenu.setBackground(Color.decode("#95a5a6"));
        sidePanel.add(makeReservationButton);



        //setting bounds of buttons
        makeReservationButton.setBounds(20,240 , 200, 50);
        addMenuItemButton.setBounds(20,320,200,50);
        logoutButton.setBounds(20,560,200,50);
        reservations.setBounds(20,80,200,50);
        displayMenu.setBounds(20, 160, 200, 50);
        exportButton.setBounds(20,480,200,50);
        importButton.setBounds(20,400,200,50);


        //example orders

        Breakfast breakfast2 = new Breakfast("David", true, 10,  new MenuItem("Pancakes"));
        Breakfast breakfast3 = new Breakfast("Max", false, 2,  new MenuItem("Eggs"));
        Breakfast breakfast5 = new Breakfast("Mehmet", false, 4, new MenuItem("Pancakes"));
        breakfastList.add(breakfast2);
        breakfastList.add(breakfast3);
        breakfastList.add(breakfast5);

        //example items
        MenuItem menuItem = new MenuItem("Eggs");
        MenuItem menuItem2 = new MenuItem("Pancakes");
        menuItems.add(menuItem2);
        menuItems.add(menuItem);
        //adding action listener to the searchbar. when enter is pressed, send a call to the search method and check what kind of search is required
        searchInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(mainLabel.getText().equals("Reservations")) {
                    ArrayList<Breakfast> list = Search.SearchBreakfast(searchInput.getText(), breakfastList);
                    displayOrders(breakfastList, list, mainFramePanel, mainPane, mainLabel);
                }
                else{
                    ArrayList<MenuItem> list = Search.SearchMenu(searchInput.getText(), menuItems);
                    displayMenu(menuItems,list, mainFramePanel, mainPane, mainLabel);
                }

            }
        });

        //adding action listener for the addItem button, when its pressed, open the menu that has the ability to add a new reservation or menuitem depending on which one is wanted
        addItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(mainLabel.getText().equals("Reservations")) {
                    addNewReservation(breakfastList, menuItems, mainFramePanel, mainPane, mainLabel);
                }
                else{
                    addNewMenuItem(menuItems,mainFramePanel,mainPane, mainLabel );
                }

            }
        });

        //action listener for the export button
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
                chooser.setDialogTitle("Save export file");
                chooser.setMultiSelectionEnabled(false);
                System.out.println("here");
                int result = chooser.showOpenDialog(null);

                File file = new File(chooser.getSelectedFile().getAbsolutePath());
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("here");

                Parser.addInfoToFile(file, breakfastList, menuItems);
            }
        });
        importButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
                chooser.setDialogTitle("Choose import file");
                chooser.setMultiSelectionEnabled(false);
                int result = chooser.showOpenDialog(null);

                File file = new File(chooser.getSelectedFile().getAbsolutePath());


                MenuAndReservations menuAndReservations=Parser.parseFileIntoLists(file);
                breakfastList = menuAndReservations.breakfasts;
                menuItems = menuAndReservations.menuItems;
                displayOrders(breakfastList,breakfastList, mainFramePanel, mainPane,mainLabel);
            }
        });


        //displaying orders
        displayOrders(breakfastList,breakfastList, mainFramePanel, mainPane, mainLabel);

        //action listener for button that adds new food to the menu
        addMenuItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                addNewMenuItem(menuItems,mainFramePanel,mainPane, mainLabel );
            }
        });
        //action listener for button that displays reservations
        reservations.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                displayOrders(breakfastList, breakfastList,mainFramePanel,mainPane, mainLabel);
            }
        });
        //action listener for button that adds new reservation
        makeReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addNewReservation(breakfastList, menuItems, mainFramePanel, mainPane, mainLabel);

            }
        });
        //action listener for button that displays the menu
        displayMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                displayMenu(menuItems,menuItems, mainFramePanel, mainPane, mainLabel);
            }
        });
        //setting up the scrollbar
        scrollBar.setBounds(1250,0,30,720);
        scrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent adjustmentEvent) {
                mainFramePanel.setBounds(0,scrollBar.getValue()*-10+150,WINDOW_WIDTH,10000);
            }
        });
        mainPane.add(scrollBar,Integer.valueOf(5));
        //setting initial values for scrollbar and seeing if it being visible is necessary
        scrollBar.setMaximum(breakfastList.size()*8);
        scrollBar.setVisible(breakfastList.size()>4);
        sidePanel.add(displayMenu);
        mainFrame.add(mainPane);


    }
    public static void displayMenu(ArrayList<MenuItem> total,ArrayList<MenuItem> items, JPanel mainPanel, JLayeredPane pane,JLabel mainLabel){
        mainLabel.setText("Menu");
        pane.remove(mainPanel);
        mainPanel.removeAll();
        pane.remove(mainPanel);
        mainPanel.removeAll();
        scrollBar.setMaximum(items.size()*8);
        scrollBar.setVisible(items.size()>4);
        if(!scrollBar.isVisible()){scrollBar.setValue(0);}

        int i=1;
        //loop through all menus in the list and display them by adding them to one panel
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
        scrollBar.setMaximum(breakfasts.size()*8);
        scrollBar.setVisible(breakfasts.size()>4);
        if(!scrollBar.isVisible()){scrollBar.setValue(0);}
        //same idea as displayMenu
        for (Breakfast breakfast : breakfasts) {
            mainPanel.add(displayItem(breakfast, i, breakfasts, total,mainPanel, pane, mainLabel));
            i++;
        }
        pane.add(mainPanel, Integer.valueOf(0));


    }
    public static CoolComponents.RoundedPanel displayMenuItem(MenuItem menuItem, int num,ArrayList<MenuItem> items, ArrayList<MenuItem> total,JPanel mainPanel, JLayeredPane pane, JLabel mainLabel){
       //random color generation will only work if a color has not yet been generated
        if(!menuItem.isSetColor()) {
            Random random = new Random();
            float r = random.nextFloat();
            float g = random.nextFloat();
            float b = random.nextFloat();
            Color color = new Color(r,g,b);
            menuItem.setColor(color);
        }
        //setup components
        CoolComponents.RoundedPanel displayPanel = new CoolComponents.RoundedPanel(20);
        displayPanel.setOpaque(false);
        displayPanel.setLayout(null);
        displayPanel.setBackground(Color.decode("#dfe6e9"));
        displayPanel.setBounds(300, num * 100, 900, 80);
        JLabel itemNameLabel = new JLabel(menuItem.getName());
        JPanel tagPanel = new JPanel(null);
        tagPanel.setBounds(1,1,20,60);
        tagPanel.setBackground(menuItem.getColor());
        displayPanel.add(tagPanel);
        Font goodFont = new Font("Serif", Font.BOLD, 20);
        itemNameLabel.setFont(goodFont);
        itemNameLabel.setBounds(80, 0, 500, 50);

        JLabel ingredientLabel = new JLabel("Ingredients: Milk cups: "+menuItem.getCupsOfMilk()+"|"+menuItem.getLargeMilk()+" Cost: $"+ menuItem.getCost()+"   Butter: " +menuItem.getTbspButter()+"|"+menuItem.getLargeButter()+"     Eggs: "+menuItem.getEggs()+"|"+menuItem.getLargeEggs());
        ingredientLabel.setFont(new Font("Serif", Font.BOLD,15));
        ingredientLabel.setBounds(200,0,500,50);
        JButton deleteImageLabel = new JButton();
        deleteImageLabel.setBorderPainted(false);
        deleteImageLabel.setFocusPainted(false);
        deleteImageLabel.setContentAreaFilled(false);
        deleteImageLabel.setBackground(Color.decode("#95a5a6"));

        deleteImageLabel.setIcon(resizeImage("assets/delete.png", 30, 30));
        deleteImageLabel.setBounds(850, 15, 30, 30);
        displayPanel.add(deleteImageLabel);

        //action listener for deleting item
        deleteImageLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("deleting " + menuItem.getName());
                //remove it from both lists, the currently displayed ones and the total list
                items.remove(menuItem);
                total.remove(menuItem);

                //display the new menu
                displayMenu(total,items, mainPanel, pane, mainLabel);
                System.out.println(items.size());


            }
        });

        displayPanel.add(ingredientLabel);
        displayPanel.add(itemNameLabel);
        return displayPanel;
    }

    //method that creates a new frame for making new reservations
    public static void addNewReservation(ArrayList<Breakfast> breakfasts, ArrayList<MenuItem> menuItems, JPanel panel, JLayeredPane mainPane, JLabel mainLabel) {
        //setting up the new frame
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
        //add all food options to an array so it can be used with a dropdown menu
        String[] menuList = new String[menuItems.size()];
        int i = 0;
        for (MenuItem item : menuItems) {
            menuList[i] = item.getName();
            i++;
        }
        JComboBox<String> foodSelector = new JComboBox<>(menuList);
        //setting up labels and inputs
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
        //label letting user know they did something wrong
        JLabel wrongInput = new JLabel("Wrong input!");
        wrongInput.setForeground(Color.RED);
        wrongInput.setBounds(40, 330, 200, 30);
        newBreakfastPanel.add(wrongInput);
        wrongInput.setVisible(false);

        //submit button listener
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    //try parsing stuff and if it doesn't work, the user did something wrong
                    int numOfPeople = Integer.parseInt(numberSelectorField.getText());
                    if (nameLabel.getText().equals("")) {
                        wrongInput.setVisible(true);
                    } else {
                        //if the user inputted correctly, close the frame and make a new breakfast object and add it to the list
                        addNewBreakfastFrame.dispose();
                        boolean bigEaters = servingSizeSelector.getSelectedItem().equals("Large");
                        int index = foodSelector.getSelectedIndex();
                        Breakfast breakfast = new Breakfast(nameField.getText(), bigEaters, numOfPeople, menuItems.get(index));
                        breakfasts.add(breakfast);

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
    public static void addNewMenuItem(ArrayList<MenuItem> items, JPanel panel, JLayeredPane mainPane, JLabel mainLabel){
        //similar idea to the new reservation window method
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
                    //see if the user messed anything up
                    int eggs = Integer.parseInt(eggsField.getText());
                    int milk = Integer.parseInt(milkField.getText());
                    int butter = Integer.parseInt(butterField.getText());
                    double cost = Double.parseDouble(costField.getText());
                    if (nameLabel.getText().equals("")) {
                        wrongInput.setVisible(true);
                    } else {
                        //close window and add to list
                        addNewBreakfastFrame.dispose();

                        MenuItem menuItem = new MenuItem(nameField.getText(),eggs,cost,milk,butter);


                        items.add(menuItem);

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
        //make a new random color only if there isnt one already
        if(!breakfast.isSetColor()) {
            Random random = new Random();
            float r = random.nextFloat();
            float g = random.nextFloat();
            float b = random.nextFloat();
            Color color  = new Color(r,g,b);
            breakfast.setColor(color);
        }
        //setup the components
        CoolComponents.RoundedPanel displayPanel = new CoolComponents.RoundedPanel(20);
        displayPanel.setOpaque(false);
        displayPanel.setLayout(null);
        displayPanel.setBackground(Color.decode("#dfe6e9"));
        displayPanel.setBounds(300, num * 100, 900, 80);
        JPanel tagPanel  = new JPanel(null);
        tagPanel.setBackground(breakfast.getColor());
        tagPanel.setBounds(1,1,20,60);

        displayPanel.add(tagPanel);
        Font regularFont = new Font("Serif", Font.BOLD, 15);
        JPanel borderPanel = new JPanel(null);
        borderPanel.setBounds(430,0,3,75);
        borderPanel.setBackground(Color.LIGHT_GRAY);
        JPanel secondBorder = new JPanel(null);
        secondBorder.setBounds(635,0,3,75);
        secondBorder.setBackground(Color.LIGHT_GRAY);
        displayPanel.add(secondBorder);
        displayPanel.add(borderPanel);
        //display large if they are big eaters
        String large = breakfast.isBigEaters() ? "Large" : "Regular";
        //create labels that display this information
        JLabel mealLabel = new JLabel ("Meal: "+large+" portion of "+breakfast.getMenuItem().getName());
        JLabel numLabel  = new JLabel("Number of diners: "+breakfast.getNumOfPeople());
        JLabel costLabel = new JLabel("Cost of order: $"+breakfast.calcCost());
        mealLabel.setBounds(180,20,400,30);
        numLabel.setBounds(450,20,200,30);
        costLabel.setBounds(650,20,200,30);
        mealLabel.setFont(regularFont); numLabel.setFont(regularFont); costLabel.setFont(regularFont);
        displayPanel.add(mealLabel); displayPanel.add(numLabel); displayPanel.add(costLabel);
        JLabel breakfastLabel = new JLabel(breakfast.getPartyName());
        breakfastLabel.setFont(new Font("Serif", Font.BOLD, 20));
        JButton deleteImageLabel = new JButton();
        deleteImageLabel.setBorderPainted(false);
        deleteImageLabel.setFocusPainted(false);
        deleteImageLabel.setContentAreaFilled(false);
        deleteImageLabel.setBackground(Color.decode("#95a5a6"));

        deleteImageLabel.setIcon(resizeImage("assets/delete.png", 30, 30));
        deleteImageLabel.setBounds(850, 5, 30, 30);
        displayPanel.add(deleteImageLabel);
        JButton infoButton = new JButton();
        infoButton.setBorderPainted(false);
        infoButton.setFocusPainted(false);
        infoButton.setContentAreaFilled(false);
        infoButton.setBackground(Color.decode("#95a5a6"));
        //action listener for the delete item feature
        deleteImageLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //remove from both lists and redraw
                System.out.println("deleting " + breakfast.getPartyName());
                breakfasts.remove(breakfast);
                total.remove(breakfast);
                displayOrders(breakfasts,breakfasts, mainPanel, pane, mainLabel);
            }
        });
        //action listener for the info button
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //open up the info frame
                System.out.println("edit of " + breakfast.getPartyName() + " requested");
                mealInfo(breakfast);
            }
        });


        infoButton.setIcon(resizeImage("assets/information-button.png", 30, 30));
        infoButton.setBounds(850, 40, 30, 30);
        displayPanel.add(infoButton);
        breakfastLabel.setBounds(40, 0, 150, 50);
        displayPanel.add(breakfastLabel);
        return displayPanel;


    }

    public static void signupWindow(JFrame loginFrame, JPanel loginPanel) throws IOException {
        //making rounded text field and other components
        CoolComponents.RoundJTextField userNameSignUpField = new CoolComponents.RoundJTextField(30);
        JPasswordField passWordSignUpField = new CoolComponents.RoundPasswordField(30);
        JButton enterImageButton = new JButton();
        JButton makeAccountButton = new JButton();
        JPasswordField newPassField = passWordSignUpField;
        JTextField newUserField = userNameSignUpField;
        newPassField.setText("");
        JLabel wrongInputLabel = new JLabel("Wrong input");
        wrongInputLabel.setForeground(Color.RED);
        wrongInputLabel.setVisible(false);
        wrongInputLabel.setBounds(300,200,200,30);
        loginPanel.add(wrongInputLabel);
        //if make account button is pressed
        makeAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //add a new account to the file
                if (userNameSignUpField.getText().isEmpty() || passWordSignUpField.getPassword().length ==0) {
                    System.out.println("wrong input");
                    wrongInputLabel.setVisible(true);
                } else {
                    Authenticator.makeAccount(userNameSignUpField.getText(), String.valueOf(passWordSignUpField.getPassword()));

                    wrongInputLabel.setVisible(false);


                    try {
                        //open up the login window
                        loginPanel.removeAll();

                        login(loginFrame, loginPanel);

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        //do the same thing as the make account button
        enterImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Authenticator.makeAccount(userNameSignUpField.getText(), String.valueOf(passWordSignUpField.getPassword()));

                if (userNameSignUpField.getText().isEmpty() || passWordSignUpField.getPassword().length ==0) {
                    System.out.println("wrong input");
                    wrongInputLabel.setVisible(true);
                } else {
                    Authenticator.makeAccount(userNameSignUpField.getText(), String.valueOf(passWordSignUpField.getPassword()));

                    wrongInputLabel.setVisible(false);


                    try {
                        //open up the login window
                        loginPanel.removeAll();

                        login(loginFrame, loginPanel);

                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }}
        });
        //setup compoments
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

        makeAccountButton.setBounds(200, 220, 100, 30);
        makeAccountButton.setText("Sign up ");


        loginPanel.add(makeAccountButton);

        loginFrame.add(loginPanel);
        loginFrame.setVisible(true);
    }

    //resize image method which reads in a file path and uses a couple methods to resize it and then returns it as an Icon
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

    //method that displays the info for a meal
    public static void mealInfo(Breakfast breakfast){
        //setting up the frame
        JFrame mealInfoFrame = new JFrame(breakfast.getPartyName()+" Info");
        JPanel mealInfoPanel = new JPanel(null);
        mealInfoFrame.setSize(400,400);
        JLabel infoLabel = new JLabel(breakfast.getPartyName()+ " Info");
        infoLabel.setFont(new Font("Serif",Font.BOLD,20));
        infoLabel.setBounds(20,10,300,50);
        mealInfoFrame.add(mealInfoPanel);
        //displaying the appropriate information
        JLabel totalEggsLabel  = new JLabel("Total Eggs for order: "+breakfast.calcEggs());
        JLabel totalButterLabel = new JLabel("Total butter for order: "+breakfast.calcButter());
        JLabel totalMilkLabel = new JLabel("Total milk for order: "+breakfast.calcMilk());
        JLabel totalCost = new JLabel("Total cost for order $"+breakfast.calcCost());
        JLabel indCost = new JLabel("Cost for one order: $"+breakfast.calcCost()/breakfast.getNumOfPeople());
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





}
