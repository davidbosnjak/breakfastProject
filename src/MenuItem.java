public class MenuItem {


    private boolean largeServing;
    private int eggs;
    private int largeButter;
    private double cost;
    private int cupsOfMilk;
    private int largeMilk;
    private int tbspButter;
    private String name;

    MenuItem(String name){
        this.name = name;
        this.eggs = 1;
        this.cupsOfMilk = 1;
        this.tbspButter =1;
        cost = 5;
        largeMilk = cupsOfMilk +2;
        largeButter = tbspButter+2;
    }
        MenuItem(String name, boolean largeServing){
        this.name = name;
        this.largeServing = largeServing;
    }

    MenuItem(String name, int eggs, double cost, int cupsOfMilk, int tbspButter){
        this.name = name;
        this.eggs = eggs;
        this.cost = cost;
        this.cupsOfMilk = cupsOfMilk;
        this.tbspButter = tbspButter;
    }



    public boolean isLargeServing() {
        return largeServing;
    }

    public void setLargeServing(boolean largeServing) {
        this.largeServing = largeServing;
    }

    public int getEggs() {
        return eggs;
    }

    public void setEggs(int eggs) {
        this.eggs = eggs;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getCupsOfMilk() {
        return cupsOfMilk;
    }

    public void setCupsOfMilk(int cupsOfMilk) {
        this.cupsOfMilk = cupsOfMilk;
    }

    public int getTbspButter() {
        return tbspButter;
    }

    public void setTbspButter(int tbspButter) {
        this.tbspButter = tbspButter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString(){

        String htmlString = "<html><span style=\"font-family:Arial;font-size:13px;\">Item: "+name+"&nbsp;&nbsp;&nbsp; Eggs: "+eggs+"/"+eggs+2+" &nbsp;&nbsp;&nbsp;" +
                "&nbsp; Butter: "+tbspButter+"/"+largeButter+" <br> Milk: "+cupsOfMilk+"/"+largeMilk+" &nbsp;&nbsp;&nbsp; Cost: "+cost+"</span></html>";

        return htmlString;
    }


}
