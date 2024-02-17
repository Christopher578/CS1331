class Frog {
    //instance variables
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species = "Rare Pepe";
    //static constants variables
    public static final int DEFULT_age = 5;
    public static final double DEFULT_tongueSpeed = 5.0;
    //Constructors 2 conpls **
    public Frog(String name) {
        this(name, DEFULT_age, DEFULT_tongueSpeed);
    }
    public Frog(String name, double ageInYears) {
        this(name, (int)(ageInYears * 12), DEFULT_tongueSpeed);
    }
    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
        this.isFroglet = (age > 1) && (age < 7);
    }
    public void grow() {
        this.grow(1);
    }
    public void grow(int numberofmonths) {
        for (int n = 0 ; n < numberofmonths ; n++) {
            age+=1;
         if (age <= 12)
            tongueSpeed +=1;
            else if ( age > 30 && tongueSpeed > 5.0)
            tongueSpeed -=1;
            else
            continue;
        }
        if (age < 7)
        isFroglet = true;
        else 
        isFroglet = false;
    }
    public void eat( Fly fly ) { //not sure how to write class object as parameter
        if (!fly.isDead()) {
        if (tongueSpeed > fly.getSpeed()) { //if Fly is caught condition
        if ( fly.getMass() > 0.5*age ) //if Fly is caught ***
        grow();
        fly.setMass(0);
        }
        else //if Fly is not caught ***
        fly.grow(1);
        }
    }
    public String toString() {
        if (isFroglet)
        return "My name is "+name+" and I\'m a rare froglet! I\'m "+age+" months old and my tongue has a speed of "+String.format("%.2f", tongueSpeed)+".";
        else
        return "My name is "+name+" and I\'m a rare frog. I\'m "+age+" months old and my tongue has a speed of "+String.format("%.2f", tongueSpeed)+".";
    }
    public static String getSpecies () {
        return species;
    }
    public static void setSpecies (String newSpecies) {
        species = newSpecies;
    }
}
