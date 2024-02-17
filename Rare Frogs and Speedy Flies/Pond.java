public class Pond {
    public static void main(String[] args) {
        Frog frog1 = new Frog("Peepo");
        Frog frog2 = new Frog("Pepe",10,15.0);
        Frog frog3 = new Frog("Peepaw",4.6);
        Frog frog4 = new Frog("Peep4",10,15.0);
        Fly fly1 = new Fly(1,3.0);
        Fly fly2 = new Fly(6);
        Fly fly3 = new Fly(4);
        Frog.setSpecies("1331 Frogs");
        System.out.println(frog1.toString());
        frog1.eat(fly2); // not sure 
        System.out.println(fly2.toString());
        frog1.grow(8);
        frog1.eat(fly2);
        System.out.println(fly2.toString());
        System.out.println(frog1.toString());
        System.out.println(frog4.toString());
        frog3.grow(4);
        System.out.println(frog3.toString());
        System.out.println(frog2.toString());
    }
}
