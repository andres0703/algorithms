package factoryMethod;

public class CookingKnifeStore extends KnifeStore {

    @Override
    Knife createKnife(String type) {
        if (type.equals("SteakKnife")) {
            return new SteakKnife();
        }
        return null;
    }

    public static void main(String[] args) {
        CookingKnifeStore cookingKnifeStore = new CookingKnifeStore();
        cookingKnifeStore.orderKnife("SteakKnife");
    }
}

