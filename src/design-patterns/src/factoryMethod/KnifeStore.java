package factoryMethod;

public abstract class KnifeStore {

    public Knife orderKnife(String type) {
        Knife knife = createKnife(type);
        knife.sharpen();
        knife.polish();
        knife.pack();
        return knife;
    }

    abstract Knife createKnife(String type);
}
