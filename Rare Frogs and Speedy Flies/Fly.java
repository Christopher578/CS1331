class Fly {
    //instance variables
    private double mass;
    private double speed;
    //static constants variables
    public static final double DEFULT_mass = 5.0;
    public static final double DEFULT_speed = 10.0;
    //Constructors
    public Fly () {
        this(DEFULT_mass,DEFULT_speed);
    }
    public Fly (double mass) {
        this(mass, DEFULT_speed);
    }
    public Fly (double mass, double speed) { 
    this.mass=mass;
    this.speed=speed;
    }
    public double getMass() {
        return mass;
    }
    public void setMass(double newMass) {
            mass = newMass;
    }

    public double getSpeed() {
        return speed;
    }
    public void setSpeed(double newSpeed) {
            speed = newSpeed;
    }
    public String toString() {
        if (isDead()) {
        return "I\'m dead, but I used to be a fly with a speed of "+String.format("%.2f",speed)+".";
        }
        else
        return "I\'m a speedy fly with "+String.format("%.2f",speed)+" speed and "+String.format("%.2f",mass)+" mass.";
    }
    public void grow (int addedmass) {
        if (mass + addedmass < 20) {
        speed += addedmass;
        }
        else if (mass >= 20)
         speed -= 0.5*addedmass;
        else {
        int temp = 20 - (int)mass;
        int temp2 = (int)mass + addedmass - 20;
        speed += temp - 0.5*temp2;
        }
        mass += addedmass;
    }
    public boolean isDead () {
        if (mass == 0)
        return true;
        else
        return false;
    }
}

