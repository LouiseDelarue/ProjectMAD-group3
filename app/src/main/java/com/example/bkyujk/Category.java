package com.example.bkyujk;

import java.util.HashMap;
import java.util.Map;

public class Category {
    private static final Map<String, String> categoryMap = new HashMap<>();
    private static final Map<String, Double> priceMap = new HashMap<>();

    static {
        // Fruits
        addMapping("pineapple", "Fruits", 1.0f);
        addMapping("apple", "Fruits", 0.5f);
        addMapping("banana", "Fruits", 0.3f);
        addMapping("pear", "Fruits", 0.7f);
        addMapping("peach", "Fruits", 0.6f);
        addMapping("plum", "Fruits", 0.8f);
        addMapping("grape", "Fruits", 1.2f);
        addMapping("watermelon", "Fruits", 1.5f);
        addMapping("cantaloupe", "Fruits", 1.3f);
        addMapping("apricot", "Fruits", 0.9f);
        addMapping("nectarine", "Fruits", 0.8f);
        addMapping("kiwi", "Fruits", 1.0f);
        addMapping("raspberry", "Fruits", 1.1f);
        addMapping("red berries", "Fruits", 1.1f);
        addMapping("cherry", "Fruits", 1.2f);
        addMapping("strawberry", "Fruits", 0.9f);
        addMapping("currant", "Fruits", 1.0f);
        addMapping("cranberry", "Fruits", 1.0f);
        addMapping("redcurrant", "Fruits", 1.0f);
        addMapping("blackcurrant", "Fruits", 1.0f);
        addMapping("blueberry", "Fruits", 1.0f);
        addMapping("blackberry", "Fruits", 1.0f);
        addMapping("citruses", "Fruits", 1.5f);
        addMapping("orange", "Fruits", 0.6f);
        addMapping("lemon", "Fruits", 0.4f);
        addMapping("lime", "Fruits", 0.5f);
        addMapping("grapefruit", "Fruits", 1.2f);
        addMapping("tangerine", "Fruits", 0.8f);
        addMapping("kumquat", "Fruits", 0.7f);
        addMapping("blood orange", "Fruits", 1.1f);
        addMapping("yuzu", "Fruits", 2.0f);
        addMapping("mango", "Fruits", 1.5f);
        addMapping("lychee", "Fruits", 1.7f);
        addMapping("pomegranate", "Fruits", 1.3f);
        addMapping("fig", "Fruits", 1.2f);
        addMapping("passion fruit", "Fruits", 1.5f);
        addMapping("coconut", "Fruits", 2.0f);
        addMapping("avocado", "Fruits", 1.5f);

        // Vegetables
        addMapping("carrot", "Vegetables", 0.4f);
        addMapping("tomato", "Vegetables", 0.5f);
        addMapping("zucchini", "Vegetables", 0.6f);
        addMapping("cucumber", "Vegetables", 0.4f);
        addMapping("bell pepper", "Vegetables", 0.8f);
        addMapping("eggplant", "Vegetables", 1.0f);
        addMapping("broccoli", "Vegetables", 1.0f);
        addMapping("cauliflower", "Vegetables", 0.8f);
        addMapping("spinach", "Vegetables", 0.9f);
        addMapping("lettuce", "Vegetables", 0.5f);
        addMapping("green beans", "Vegetables", 0.6f);
        addMapping("peas", "Vegetables", 0.5f);
        addMapping("turnip", "Vegetables", 0.7f);
        addMapping("potato", "Vegetables", 0.3f);
        addMapping("onion", "Vegetables", 0.4f);
        addMapping("garlic", "Vegetables", 0.6f);
        addMapping("radish", "Vegetables", 0.5f);
        addMapping("beetroot", "Vegetables", 0.8f);
        addMapping("celery", "Vegetables", 0.7f);
        addMapping("mushroom", "Vegetables", 1.2f);
        addMapping("corn", "Vegetables", 0.9f);
        addMapping("pumpkin", "Vegetables", 1.3f);
        addMapping("sweet potato", "Vegetables", 0.9f);
        addMapping("leek", "Vegetables", 0.6f);
        addMapping("asparagus", "Vegetables", 1.2f);
        addMapping("artichoke", "Vegetables", 1.4f);
        addMapping("brussels sprouts", "Vegetables", 1.1f);
        addMapping("kale", "Vegetables", 0.8f);
        addMapping("arugula", "Vegetables", 1.0f);

        // Meats
        addMapping("chicken", "Meats", 5.0f);
        addMapping("beef", "Meats", 7.0f);
        addMapping("pork", "Meats", 6.0f);
        addMapping("turkey", "Meats", 6.5f);
        addMapping("duck", "Meats", 8.0f);
        addMapping("lamb", "Meats", 9.0f);
        addMapping("rabbit", "Meats", 6.0f);
        addMapping("ham", "Meats", 5.5f);
        addMapping("bacon", "Meats", 4.5f);
        addMapping("sausage", "Meats", 3.5f);
        addMapping("salami", "Meats", 4.0f);
        addMapping("meatball", "Meats", 4.5f);
        addMapping("chicken breast", "Meats", 6.0f);
        addMapping("chicken thigh", "Meats", 5.5f);
        addMapping("chicken wings", "Meats", 5.0f);
        addMapping("veal", "Meats", 7.5f);
        addMapping("goat", "Meats", 7.0f);
        addMapping("ground beef", "Meats", 6.0f);
        addMapping("roast beef", "Meats", 8.5f);
        addMapping("oxtail", "Meats", 9.0f);
        addMapping("liver", "Meats", 4.0f);
        addMapping("lardons", "Meats", 4.2f);
        addMapping("fish", "Meats", 6.0f);
        addMapping("salmon", "Meats", 9.0f);
        addMapping("tuna", "Meats", 7.0f);
        addMapping("sardine", "Meats", 3.5f);
        addMapping("Shrimp", "Meats", 8.0f);
        addMapping("crab", "Meats", 9.0f);
        addMapping("lobster", "Meats", 12.0f);


        // Maintenance
        addMapping("dish soap", "Maintenance", 3.0f);
        addMapping("laundry detergent", "Maintenance", 5.0f);
        addMapping("bleach", "Maintenance", 2.5f);
        addMapping("multi-surface cleaner", "Maintenance", 4.0f);
        addMapping("glass cleaner", "Maintenance", 3.5f);
        addMapping("floor cleaner", "Maintenance", 4.5f);
        addMapping("bathroom cleaner", "Maintenance", 3.5f);
        addMapping("toilet bowl cleaner", "Maintenance", 2.0f);
        addMapping("degreaser", "Maintenance", 4.0f);
        addMapping("disinfectant", "Maintenance", 3.0f);
        addMapping("oven cleaner", "Maintenance", 5.5f);
        addMapping("air freshener", "Maintenance", 2.5f);
        addMapping("lime scale remover", "Maintenance", 4.5f);
        addMapping("hand soap", "Maintenance", 1.0f);
        addMapping("sponge", "Maintenance", 1.2f);
        addMapping("broom", "Maintenance", 5.0f);
        addMapping("mop", "Maintenance", 6.0f);
        addMapping("vacuum cleaner", "Maintenance", 150.0f);
        addMapping("bucket", "Maintenance", 3.0f);
        addMapping("rubber gloves", "Maintenance", 2.0f);
        addMapping("garbage bag", "Maintenance", 1.5f);
        addMapping("dishwasher detergent", "Maintenance", 4.0f);
        addMapping("dishwashing gloves", "Maintenance", 3.0f);
        addMapping("scouring pad", "Maintenance", 1.0f);
        addMapping("cleaning cloth", "Maintenance", 1.5f);
        addMapping("toilet brush", "Maintenance", 2.5f);
        addMapping("toilet paper", "Maintenance", 6.0f);
        addMapping("paper towel", "Maintenance", 4.0f);
        addMapping("descaler", "Maintenance", 5.0f);
        addMapping("insecticide", "Maintenance", 6.0f);
        addMapping("fabric refresher", "Maintenance", 5.0f);

        // Personal Care
        addMapping("shower gel", "Personal Care", 4.0f);
        addMapping("shampoo", "Personal Care", 5.0f);
        addMapping("conditioner", "Personal Care", 5.0f);
        addMapping("body lotion", "Personal Care", 6.0f);
        addMapping("face cream", "Personal Care", 8.0f);
        addMapping("toothpaste", "Personal Care", 2.0f);
        addMapping("toothbrush", "Personal Care", 3.0f);
        addMapping("mouthwash", "Personal Care", 3.5f);
        addMapping("deodorant", "Personal Care", 3.0f);
        addMapping("soap", "Personal Care", 1.0f);
        addMapping("cotton pads", "Personal Care", 2.0f);
        addMapping("cotton swabs", "Personal Care", 1.5f);
        addMapping("razor", "Personal Care", 4.5f);
        addMapping("shaving cream", "Personal Care", 3.5f);
        addMapping("nail polish", "Personal Care", 5.0f);
        addMapping("nail polish remover", "Personal Care", 2.0f);
        addMapping("makeup remover", "Personal Care", 5.0f);
        addMapping("sunscreen", "Personal Care", 6.0f);
        addMapping("lip balm", "Personal Care", 2.5f);
        addMapping("perfume", "Personal Care", 30.0f);
        addMapping("feminine pads", "Personal Care", 2.5f);
        addMapping("tampons", "Personal Care", 3.0f);
        addMapping("hairbrush", "Personal Care", 4.0f);
        addMapping("hair dryer", "Personal Care", 25.0f);
        addMapping("comb", "Personal Care", 2.0f);
        addMapping("body scrub", "Personal Care", 5.0f);
        addMapping("face mask", "Personal Care", 4.0f);
        addMapping("hair mask", "Personal Care", 6.0f);
        addMapping("baby shampoo", "Personal Care", 4.5f);
        addMapping("baby wipes", "Personal Care", 3.0f);
        addMapping("menstrual cup", "Personal Care", 10.0f);
        addMapping("beard oil", "Personal Care", 15.0f);

        // Dairy
        addMapping("milk", "Dairy", 1.2f);
        addMapping("butter", "Dairy", 3.0f);
        addMapping("cream", "Dairy", 2.5f);
        addMapping("cheese", "Dairy", 5.0f);
        addMapping("yogurt", "Dairy", 2.0f);
        addMapping("cottage cheese", "Dairy", 3.5f);
        addMapping("sour cream", "Dairy", 3.0f);
        addMapping("whipped cream", "Dairy", 2.0f);
        addMapping("mozzarella", "Dairy", 4.5f);
        addMapping("brie", "Dairy", 6.0f);
        addMapping("camembert", "Dairy", 6.0f);
        addMapping("emmental", "Dairy", 4.0f);
        addMapping("parmesan", "Dairy", 5.5f);
        addMapping("pizza", "Dairy", 8.0f);
        addMapping("feta", "Dairy", 5.0f);
        addMapping("ricotta", "Dairy", 6.0f);
        addMapping("cream cheese", "Dairy", 4.0f);
        addMapping("blue cheese", "Dairy", 6.5f);
        addMapping("liquid cream", "Dairy", 3.0f);
        addMapping("yogurt drink", "Dairy", 2.5f);
        addMapping("kefir", "Dairy", 3.5f);
        addMapping("egg", "Dairy", 2.0f);
        addMapping("eggs", "Dairy", 3.0f);


        // Grocery (dry products)
        addMapping("rice", "Grocery", 2.0f);
        addMapping("pasta", "Grocery", 1.5f);
        addMapping("spaghetti", "Grocery", 1.7f);
        addMapping("penne", "Grocery", 1.5f);
        addMapping("tortilla", "Grocery", 2.0f);
        addMapping("flour", "Grocery", 1.2f);
        addMapping("sugar", "Grocery", 1.0f);
        addMapping("salt", "Grocery", 0.5f);
        addMapping("pepper", "Grocery", 1.0f);
        addMapping("bread", "Grocery", 2.0f);
        addMapping("baguette", "Grocery", 1.5f);
        addMapping("brioche", "Grocery", 2.5f);
        addMapping("cereal", "Grocery", 3.0f);
        addMapping("oats", "Grocery", 2.0f);
        addMapping("granola", "Grocery", 3.5f);
        addMapping("chocolate", "Grocery", 2.5f);
        addMapping("candy", "Grocery", 1.5f);
        addMapping("snack", "Grocery", 2.0f);
        addMapping("chips", "Grocery", 2.5f);
        addMapping("nuts", "Grocery", 3.0f);
        addMapping("dried fruit", "Grocery", 4.0f);
        addMapping("popcorn", "Grocery", 1.5f);
        addMapping("honey", "Grocery", 3.5f);
        addMapping("peanut butter", "Grocery", 2.0f);
        addMapping("jam", "Grocery", 2.0f);
        addMapping("oil", "Grocery", 3.0f);
        addMapping("vine", "Grocery", 1.5f);
        addMapping("olive oil", "Grocery", 5.0f);
        addMapping("vinegar", "Grocery", 1.5f);
        addMapping("tea", "Grocery", 2.0f);
        addMapping("coffee", "Grocery", 4.0f);
        addMapping("canned food", "Grocery", 1.5f);
        addMapping("canned tuna", "Grocery", 2.5f);
        addMapping("tomato sauce", "Grocery", 1.0f);
        addMapping("mustard", "Grocery", 1.0f);
        addMapping("ketchup", "Grocery", 2.0f);
        addMapping("mayonnaise", "Grocery", 2.0f);
        addMapping("spices", "Grocery", 3.0f);
        addMapping("herbs", "Grocery", 3.0f);
        addMapping("syrup", "Grocery", 3.5f);
        addMapping("baking powder", "Grocery", 1.0f);
        addMapping("baking soda", "Grocery", 1.0f);
        addMapping("bagel", "Grocery", 1.5f);
        addMapping("tortilla chips", "Grocery", 2.5f);
        addMapping("pita bread", "Grocery", 2.0f);
        addMapping("crackers", "Grocery", 2.5f);
        addMapping("couscous", "Grocery", 3.0f);
        addMapping("quinoa", "Grocery", 4.0f);
        addMapping("croissant", "Grocery", 1.5f);
        addMapping("chocolatine", "Grocery", 1.5f);
        addMapping("donut", "Grocery", 1.0f);
        addMapping("cookies", "Grocery", 2.0f);

        // Frozen
        addMapping("ice cream", "Frozen", 5.0f);
        addMapping("frozen vegetables", "Frozen", 3.0f);
        addMapping("frozen fruits", "Frozen", 4.0f);
        addMapping("frozen pizza", "Frozen", 6.0f);
        addMapping("frozen fish", "Frozen", 8.0f);
        addMapping("frozen fries", "Frozen", 2.5f);
        addMapping("frozen desserts", "Frozen", 4.5f);
    }

    private static void addMapping(String itemName, String category, double price) {
        String key = itemName.toLowerCase();
        categoryMap.put(key, category);
        priceMap.put(key, price);
    }

    public static String getCategoryForItem(String itemName) {
        if (itemName == null) return "Autres";
        String category = categoryMap.get(itemName.toLowerCase());
        return category != null ? category : "Autres";
    }

    public static double getPriceForItem(String itemName) {
        if (itemName == null) return 0.0;
        Double price = priceMap.get(itemName.toLowerCase());
        return price != null ? price : 0.0;
    }

    public static void OQTF(String etranger, double price) {
        String key = etranger.toLowerCase();
        categoryMap.put(key, "Autres");
        priceMap.put(key, price);
    }
}