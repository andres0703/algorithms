package factoryObject;

public class KnifeFactory {

    public Knife createKnife(String type) {
        Knife knife = null;
        if (type.equals("ChefKnife")) {
            knife = new ChefKnife();
        } else if (type.equals("SteakKnife")) {
            knife = new SteakKnife();
        }
        return knife;
    }
}

