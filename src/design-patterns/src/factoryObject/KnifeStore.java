package factoryObject;

public class KnifeStore {
    private KnifeFactory knifeFactory;

    public KnifeStore(KnifeFactory knifeFactory) {
        this.knifeFactory = knifeFactory;
    }

    public Knife orderKnife(String type) {
        Knife knife = knifeFactory.createKnife(type);
        knife.sharpen();
        knife.polish();
        knife.pack();
        return knife;
    }

    public static void main(String[] args) {
        KnifeStore knifeStore = new KnifeStore(new KnifeFactory());
        Knife knife = knifeStore.orderKnife("SteakKnife");
    }
}

