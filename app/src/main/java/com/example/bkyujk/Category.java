package com.example.bkyujk;

import java.util.HashMap;
import java.util.Map;

public class Category {
    private static final Map<String, String> categoryMap = new HashMap<>();

    static {
        // Fruits
        categoryMap.put("pineapple", "Fruits");
        categoryMap.put("apple", "Fruits");
        categoryMap.put("banana", "Fruits");
        categoryMap.put("pear", "Fruits");
        categoryMap.put("peach", "Fruits");
        categoryMap.put("plum", "Fruits");
        categoryMap.put("grape", "Fruits");
        categoryMap.put("watermelon", "Fruits");
        categoryMap.put("cantaloupe", "Fruits");
        categoryMap.put("apricot", "Fruits");
        categoryMap.put("nectarine", "Fruits");
        categoryMap.put("kiwi", "Fruits");
        categoryMap.put("raspberry", "Fruits");
        categoryMap.put("red berries", "Fruits");
        categoryMap.put("cherry", "Fruits");
        categoryMap.put("strawberry", "Fruits");
        categoryMap.put("currant", "Fruits");
        categoryMap.put("cranberry", "Fruits");
        categoryMap.put("redcurrant", "Fruits");
        categoryMap.put("blackcurrent", "Fruits");
        categoryMap.put("blueberry", "Fruits");
        categoryMap.put("blackberry", "Fruits");
        categoryMap.put("citruses", "Fruits");
        categoryMap.put("orange", "Fruits");
        categoryMap.put("lemon", "Fruits");
        categoryMap.put("lime", "Fruits");
        categoryMap.put("grapefruit", "Fruits");
        categoryMap.put("tangerine", "Fruits");
        categoryMap.put("kumquat", "Fruits");
        categoryMap.put("blood orange", "Fruits");
        categoryMap.put("yuzu", "Fruits");
        categoryMap.put("mango", "Fruits");
        categoryMap.put("lychee", "Fruits");

        // Légumes
        categoryMap.put("carrot", "Vegetables");
        categoryMap.put("tomato", "Vegetables");
        categoryMap.put("zucchini", "Vegetables");
        categoryMap.put("cucumber", "Vegetables");
        categoryMap.put("bell pepper", "Vegetables");
        categoryMap.put("eggplant", "Vegetables");
        categoryMap.put("broccoli", "Vegetables");
        categoryMap.put("cauliflower", "Vegetables");
        categoryMap.put("spinach", "Vegetables");
        categoryMap.put("lettuce", "Vegetables");
        categoryMap.put("green beans", "Vegetables");
        categoryMap.put("peas", "Vegetables");
        categoryMap.put("turnip", "Vegetables");
        categoryMap.put("potato", "Vegetables");
        categoryMap.put("onion", "Vegetables");
        categoryMap.put("garlic", "Vegetables");
        categoryMap.put("radish", "Vegetables");
        categoryMap.put("beetroot", "Vegetables");
        categoryMap.put("celery", "Vegetables");
        categoryMap.put("mushroom", "Vegetables");
        categoryMap.put("corn", "Vegetables");
        categoryMap.put("pumpkin", "Vegetables");
        categoryMap.put("sweet potato", "Vegetables");
        categoryMap.put("leek", "Vegetables");

        // Viandes
        categoryMap.put("chiken", "Meats");
        categoryMap.put("beef", "Meats");
        categoryMap.put("pork", "Meats");
        categoryMap.put("turkey", "Meats");
        categoryMap.put("duck", "Meats");
        categoryMap.put("lamb", "Meats");
        categoryMap.put("rabbit", "Meats");
        categoryMap.put("ham", "Meats");
        categoryMap.put("bacon", "Meats");
        categoryMap.put("sausage", "Meats");
        categoryMap.put("salami", "Meats");
        categoryMap.put("meatball", "Meats");
        categoryMap.put("chiken breast", "Meats");
        categoryMap.put("chiken thigh", "Meats");
        categoryMap.put("chiken wings", "Meats");


        // Entretien
        categoryMap.put("dish soap", "maintenance");
        categoryMap.put("laundry detergent", "maintenance");
        categoryMap.put("bleach", "maintenance");
        categoryMap.put("multi-surface cleaner", "maintenance");
        categoryMap.put("glass cleaner", "maintenance");
        categoryMap.put("floor cleaner", "maintenance");
        categoryMap.put("bathroom claener", "maintenance");
        categoryMap.put("toilet bowl cleander", "maintenance");
        categoryMap.put("degreaser", "maintenance");
        categoryMap.put("disinfectant", "maintenance");
        categoryMap.put("oven cleaner", "maintenance");
        categoryMap.put("air freshener", "maintenance");
        categoryMap.put("lime scale remover", "maintenance");
        categoryMap.put("hand soap", "maintenance");
        categoryMap.put("sponge", "maintenance");
        categoryMap.put("broom", "maintenance");
        categoryMap.put("mop", "maintenance");
        categoryMap.put("vacuum cleaner", "maintenance");
        categoryMap.put("bucket", "maintenance");
        categoryMap.put("rubber gloves", "maintenance");
        categoryMap.put("garbage bag", "maintenance");
        categoryMap.put("dishwasher detergent", "maintenance");
        categoryMap.put("dishwashing gloves", "maintenance");
        categoryMap.put("scouring pad", "maintenance");
        categoryMap.put("cleaning cloth", "maintenance");
        categoryMap.put("toilet brush", "maintenance");
        categoryMap.put("toilet paper", "maintenance");
        categoryMap.put("paper towel", "maintenance");

        // Personal Care
        categoryMap.put("shower gel", "Personal Care");
        categoryMap.put("shampoo", "Personal Care");
        categoryMap.put("conditioner", "Personal Care");
        categoryMap.put("body lotion", "Personal Care");
        categoryMap.put("face cream", "Personal Care");
        categoryMap.put("toothpaste", "Personal Care");
        categoryMap.put("toothbrush", "Personal Care");
        categoryMap.put("mouthwash", "Personal Care");
        categoryMap.put("deodorant", "Personal Care");
        categoryMap.put("soap", "Personal Care");
        categoryMap.put("cotton pads", "Personal Care");
        categoryMap.put("cotton swabs", "Personal Care");
        categoryMap.put("razor", "Personal Care");
        categoryMap.put("shaving cream", "Personal Care");
        categoryMap.put("nail polish", "Personal Care");
        categoryMap.put("nail polish remover", "Personal Care");
        categoryMap.put("makeup remover", "Personal Care");
        categoryMap.put("sunscreen", "Personal Care");
        categoryMap.put("lip balm", "Personal Care");
        categoryMap.put("perfume", "Personal Care");
        categoryMap.put("feminine pads", "Personal Care");
        categoryMap.put("tampons", "Personal Care");
        categoryMap.put("hairbrush", "Personal Care");
        categoryMap.put("hair dryer", "Personal Care");
        categoryMap.put("comb", "Personal Care");
        categoryMap.put("body scrub", "Personal Care");
        categoryMap.put("face mask", "Personal Care");
        categoryMap.put("hair mask", "Personal Care");

        // Dairy / Laitier (fresh [products])
        categoryMap.put("milk", "Dairy");
        categoryMap.put("butter", "Dairy");
        categoryMap.put("cream", "Dairy");
        categoryMap.put("cheese", "Dairy");
        categoryMap.put("yogurt", "Dairy");
        categoryMap.put("cottage cheese", "Dairy");
        categoryMap.put("sour cream", "Dairy");
        categoryMap.put("whipped cream", "Dairy");
        categoryMap.put("mozzarella", "Dairy");
        categoryMap.put("brie", "Dairy");
        categoryMap.put("camembert", "Dairy");
        categoryMap.put("emmental", "Dairy");
        categoryMap.put("parmesan", "Dairy");

        // Grocery / Dry Goods
        categoryMap.put("rice", "Grocery");
        categoryMap.put("pasta", "Grocery");
        categoryMap.put("spaghetti", "Grocery");
        categoryMap.put("penne", "Grocery");
        categoryMap.put("tortilla", "Grocery");
        categoryMap.put("flour", "Grocery");
        categoryMap.put("sugar", "Grocery");
        categoryMap.put("salt", "Grocery");
        categoryMap.put("pepper", "Grocery");
        categoryMap.put("bread", "Grocery");
        categoryMap.put("baguette", "Grocery");
        categoryMap.put("brioche", "Grocery");
        categoryMap.put("cereal", "Grocery");
        categoryMap.put("oats", "Grocery");
        categoryMap.put("granola", "Grocery");


    }

    public static String getCategoryForItem(String itemName) {
        // Chercher en minuscules pour éviter les problèmes de majuscules
        String category = categoryMap.get(itemName.toLowerCase());
        return category != null ? category : "Autres"; // Si inconnu, mettre "Autres"
    }
}
