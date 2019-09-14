package factoryObject;

public class SteakKnife implements Knife {

    @Override
    public void sharpen() {
        System.out.println("Sharpen steak knife.");
    }

    @Override
    public void polish() {
        System.out.println("Polish steak knife.");
    }

    @Override
    public void pack() {
        System.out.println("Pack steak knife.");
    }
}
