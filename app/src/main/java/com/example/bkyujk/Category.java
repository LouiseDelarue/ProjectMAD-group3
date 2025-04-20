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
        addMapping("blackcurrant", "Fruits");
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
        addMapping("pomegranate", "Fruits");
        addMapping("fig", "Fruits");
        addMapping("passion fruit", "Fruits");
        addMapping("coconut", "Fruits");
        addMapping("avocado", "Fruits");

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
        addMapping("asparagus", "Vegetables");
        addMapping("artichoke", "Vegetables");
        addMapping("brussels sprouts", "Vegetables");
        addMapping("kale", "Vegetables");
        addMapping("arugula", "Vegetables");

        // Meats
        addMapping("chicken", "Meats");
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
        addMapping("chicken breast", "Meats");
        addMapping("chicken thigh", "Meats");
        addMapping("chicken wings", "Meats");
        addMapping("veal", "Meats");
        addMapping("goat", "Meats");
        addMapping("ground beef", "Meats");
        addMapping("roast beef", "Meats");
        addMapping("oxtail", "Meats");
        addMapping("liver", "Meats");
        addMapping("lardons", "Meats");
        addMapping("fish", "Meats");
        addMapping("salmon", "Meats");
        addMapping("tuna", "Meats");
        addMapping("sardine", "Meats");
        addMapping("Shrimp", "Meats");
        addMapping("crab", "Meats");
        addMapping("lobster", "Meats");


        // Maintenance
        addMapping("dish soap", "maintenance");
        addMapping("laundry detergent", "maintenance");
        addMapping("bleach", "maintenance");
        addMapping("multi-surface cleaner", "maintenance");
        addMapping("glass cleaner", "maintenance");
        addMapping("floor cleaner", "maintenance");
        addMapping("bathroom cleaner", "maintenance");
        addMapping("toilet bowl cleaner", "maintenance");
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
        addMapping("descaler", "maintenance");
        addMapping("insecticide", "maintenance");
        addMapping("fabric refresher", "maintenance");

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
        addMapping("baby shampoo", "Personal Care");
        addMapping("baby wipes", "Personal Care");
        addMapping("menstrual cup", "Personal Care");
        addMapping("beard oil", "Personal Care");

        // Dairy  (fresh products)
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
        addMapping("pizza", "Dairy");
        addMapping("feta", "Dairy");
        addMapping("ricotta", "Dairy");
        addMapping("cream cheese", "Dairy");
        addMapping("blue cheese", "Dairy");
        addMapping("liquid cream", "Dairy");
        addMapping("yogurt drink", "Dairy");
        addMapping("kefir", "Dairy");
        addMapping("egg", "Dairy");
        addMapping("eggs", "Dairy");

        // Grocery (dry products)
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
        addMapping("chocolate", "Grocery");
        addMapping("candy", "Grocery");
        addMapping("snack", "Grocery");
        addMapping("chips", "Grocery");
        addMapping("nuts", "Grocery");
        addMapping("dried fruit", "Grocery");
        addMapping("popcorn", "Grocery");
        addMapping("honey", "Grocery");
        addMapping("peanut butter", "Grocery");
        addMapping("jam", "Grocery");
        addMapping("oil", "Grocery");
        addMapping("vine", "Grocery");
        addMapping("olive oil", "Grocery");
        addMapping("vinegar", "Grocery");
        addMapping("tea", "Grocery");
        addMapping("coffee", "Grocery");
        addMapping("canned food", "Grocery");
        addMapping("canned tuna", "Grocery");
        addMapping("tomato sauce", "Grocery");
        addMapping("mustard", "Grocery");
        addMapping("ketchup", "Grocery");
        addMapping("mayonnaise", "Grocery");
        addMapping("spices", "Grocery");
        addMapping("herbs", "Grocery");
        addMapping("syrup", "Grocery");
        addMapping("baking powder", "Grocery");
        addMapping("baking soda", "Grocery");
        addMapping("bagel", "Grocery");
        addMapping("tortilla chips", "Grocery");
        addMapping("pita bread", "Grocery");
        addMapping("crackers", "Grocery");
        addMapping("couscous", "Grocery");
        addMapping("quinoa", "Grocery");
        addMapping("croissant", "Grocery");
        addMapping("chocolatine", "Grocery");
        addMapping("donut", "Grocery");
        addMapping("cookies", "Grocery");

        // Frozen
        addMapping("ice cream", "Frozen");
        addMapping("frozen vegetables", "Frozen");
        addMapping("frozen fruits", "Frozen");
        addMapping("frozen pizza", "Frozen");
        addMapping("frozen fish", "Frozen");
        addMapping("frozen fries", "Frozen");
        addMapping("frozen desserts", "Frozen");
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