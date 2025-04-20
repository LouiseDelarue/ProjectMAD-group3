package com.example.bkyujk;

import java.util.HashMap;
import java.util.Map;

public class Category {
    private static final Map<String, String> categoryMap = new HashMap<>();

    static {
        // Fruits
        addMapping("pineapple", "Fruits");
        addMapping("apple", "Fruits");
        addMapping("banana", "Fruits");
        addMapping("pear", "Fruits");
        addMapping("peach", "Fruits");
        addMapping("plum", "Fruits");
        addMapping("grape", "Fruits");
        addMapping("watermelon", "Fruits");
        addMapping("cantaloupe", "Fruits");
        addMapping("apricot", "Fruits");
        addMapping("nectarine", "Fruits");
        addMapping("kiwi", "Fruits");
        addMapping("raspberry", "Fruits");
        addMapping("red berries", "Fruits");
        addMapping("cherry", "Fruits");
        addMapping("strawberry", "Fruits");
        addMapping("currant", "Fruits");
        addMapping("cranberry", "Fruits");
        addMapping("redcurrant", "Fruits");
        addMapping("blackcurrent", "Fruits");
        addMapping("blueberry", "Fruits");
        addMapping("blackberry", "Fruits");
        addMapping("citruses", "Fruits");
        addMapping("orange", "Fruits");
        addMapping("lemon", "Fruits");
        addMapping("lime", "Fruits");
        addMapping("grapefruit", "Fruits");
        addMapping("tangerine", "Fruits");
        addMapping("kumquat", "Fruits");
        addMapping("blood orange", "Fruits");
        addMapping("yuzu", "Fruits");
        addMapping("mango", "Fruits");
        addMapping("lychee", "Fruits");

        // Vegetables
        addMapping("carrot", "Vegetables");
        addMapping("tomato", "Vegetables");
        addMapping("zucchini", "Vegetables");
        addMapping("cucumber", "Vegetables");
        addMapping("bell pepper", "Vegetables");
        addMapping("eggplant", "Vegetables");
        addMapping("broccoli", "Vegetables");
        addMapping("cauliflower", "Vegetables");
        addMapping("spinach", "Vegetables");
        addMapping("lettuce", "Vegetables");
        addMapping("green beans", "Vegetables");
        addMapping("peas", "Vegetables");
        addMapping("turnip", "Vegetables");
        addMapping("potato", "Vegetables");
        addMapping("onion", "Vegetables");
        addMapping("garlic", "Vegetables");
        addMapping("radish", "Vegetables");
        addMapping("beetroot", "Vegetables");
        addMapping("celery", "Vegetables");
        addMapping("mushroom", "Vegetables");
        addMapping("corn", "Vegetables");
        addMapping("pumpkin", "Vegetables");
        addMapping("sweet potato", "Vegetables");
        addMapping("leek", "Vegetables");

        // Meats
        addMapping("chiken", "Meats");
        addMapping("beef", "Meats");
        addMapping("pork", "Meats");
        addMapping("turkey", "Meats");
        addMapping("duck", "Meats");
        addMapping("lamb", "Meats");
        addMapping("rabbit", "Meats");
        addMapping("ham", "Meats");
        addMapping("bacon", "Meats");
        addMapping("sausage", "Meats");
        addMapping("salami", "Meats");
        addMapping("meatball", "Meats");
        addMapping("chiken breast", "Meats");
        addMapping("chiken thigh", "Meats");
        addMapping("chiken wings", "Meats");

        // Maintenance
        addMapping("dish soap", "maintenance");
        addMapping("laundry detergent", "maintenance");
        addMapping("bleach", "maintenance");
        addMapping("multi-surface cleaner", "maintenance");
        addMapping("glass cleaner", "maintenance");
        addMapping("floor cleaner", "maintenance");
        addMapping("bathroom claener", "maintenance");
        addMapping("toilet bowl cleander", "maintenance");
        addMapping("degreaser", "maintenance");
        addMapping("disinfectant", "maintenance");
        addMapping("oven cleaner", "maintenance");
        addMapping("air freshener", "maintenance");
        addMapping("lime scale remover", "maintenance");
        addMapping("hand soap", "maintenance");
        addMapping("sponge", "maintenance");
        addMapping("broom", "maintenance");
        addMapping("mop", "maintenance");
        addMapping("vacuum cleaner", "maintenance");
        addMapping("bucket", "maintenance");
        addMapping("rubber gloves", "maintenance");
        addMapping("garbage bag", "maintenance");
        addMapping("dishwasher detergent", "maintenance");
        addMapping("dishwashing gloves", "maintenance");
        addMapping("scouring pad", "maintenance");
        addMapping("cleaning cloth", "maintenance");
        addMapping("toilet brush", "maintenance");
        addMapping("toilet paper", "maintenance");
        addMapping("paper towel", "maintenance");

        // Personal Care
        addMapping("shower gel", "Personal Care");
        addMapping("shampoo", "Personal Care");
        addMapping("conditioner", "Personal Care");
        addMapping("body lotion", "Personal Care");
        addMapping("face cream", "Personal Care");
        addMapping("toothpaste", "Personal Care");
        addMapping("toothbrush", "Personal Care");
        addMapping("mouthwash", "Personal Care");
        addMapping("deodorant", "Personal Care");
        addMapping("soap", "Personal Care");
        addMapping("cotton pads", "Personal Care");
        addMapping("cotton swabs", "Personal Care");
        addMapping("razor", "Personal Care");
        addMapping("shaving cream", "Personal Care");
        addMapping("nail polish", "Personal Care");
        addMapping("nail polish remover", "Personal Care");
        addMapping("makeup remover", "Personal Care");
        addMapping("sunscreen", "Personal Care");
        addMapping("lip balm", "Personal Care");
        addMapping("perfume", "Personal Care");
        addMapping("feminine pads", "Personal Care");
        addMapping("tampons", "Personal Care");
        addMapping("hairbrush", "Personal Care");
        addMapping("hair dryer", "Personal Care");
        addMapping("comb", "Personal Care");
        addMapping("body scrub", "Personal Care");
        addMapping("face mask", "Personal Care");
        addMapping("hair mask", "Personal Care");

        // Dairy
        addMapping("milk", "Dairy");
        addMapping("butter", "Dairy");
        addMapping("cream", "Dairy");
        addMapping("cheese", "Dairy");
        addMapping("yogurt", "Dairy");
        addMapping("cottage cheese", "Dairy");
        addMapping("sour cream", "Dairy");
        addMapping("whipped cream", "Dairy");
        addMapping("mozzarella", "Dairy");
        addMapping("brie", "Dairy");
        addMapping("camembert", "Dairy");
        addMapping("emmental", "Dairy");
        addMapping("parmesan", "Dairy");

        // Grocery
        addMapping("rice", "Grocery");
        addMapping("pasta", "Grocery");
        addMapping("spaghetti", "Grocery");
        addMapping("penne", "Grocery");
        addMapping("tortilla", "Grocery");
        addMapping("flour", "Grocery");
        addMapping("sugar", "Grocery");
        addMapping("salt", "Grocery");
        addMapping("pepper", "Grocery");
        addMapping("bread", "Grocery");
        addMapping("baguette", "Grocery");
        addMapping("brioche", "Grocery");
        addMapping("cereal", "Grocery");
        addMapping("oats", "Grocery");
        addMapping("granola", "Grocery");

        // Frozen
        addMapping("ice cream", "Frozen");
    }

    private static void addMapping(String itemName, String category) {
        categoryMap.put(itemName.toLowerCase(), category);
    }

    public static String getCategoryForItem(String itemName) {
        if (itemName == null) return "Autres";
        String category = categoryMap.get(itemName.toLowerCase());
        return category != null ? category : "Autres";
    }
}
