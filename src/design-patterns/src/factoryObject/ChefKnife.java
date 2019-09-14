package factoryObject;

public class ChefKnife implements Knife {

    @Override
    public void sharpen() {
        System.out.println("Sharpen chef knife.");
    }

    @Override
    public void polish() {
        System.out.println("Polish chef knife.");
    }

    @Override
    public void pack() {
        System.out.println("Pack chef knife.");
    }
}
