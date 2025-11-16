package GenricProblem;

import java.util.*;

// ---------- 1) MealPlan interface ----------
interface MealPlan {
    // short description for display
    String getDescription();

    // simple validation hook: each meal type can decide if it's valid (e.g., has required calories info)
    boolean isValid();
}

// ---------- 2) Concrete MealPlan types ----------
class VegetarianMeal implements MealPlan {
    private String name;
    private int calories;

    VegetarianMeal(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    @Override
    public String getDescription() {
        return "Vegetarian: " + name + " (" + calories + " kcal)";
    }

    @Override
    public boolean isValid() {
        // a simple rule: vegetarian meals must have > 0 calories
        return calories > 0;
    }

    @Override
    public String toString() {
        return getDescription();
    }
}

class VeganMeal implements MealPlan {
    private String name;
    private int calories;

    VeganMeal(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    @Override
    public String getDescription() {
        return "Vegan: " + name + " (" + calories + " kcal)";
    }

    @Override
    public boolean isValid() {
        return calories > 0;
    }

    @Override
    public String toString() {
        return getDescription();
    }
}

class KetoMeal implements MealPlan {
    private String name;
    private int calories;
    private double carbsGrams; // keto-sensitive

    KetoMeal(String name, int calories, double carbsGrams) {
        this.name = name;
        this.calories = calories;
        this.carbsGrams = carbsGrams;
    }

    @Override
    public String getDescription() {
        return "Keto: " + name + " (" + calories + " kcal, " + carbsGrams + "g carbs)";
    }

    @Override
    public boolean isValid() {
        // simple rule: keto meals must have carbs < 50g and calories > 0
        return calories > 0 && carbsGrams < 50.0;
    }

    @Override
    public String toString() {
        return getDescription();
    }
}

class HighProteinMeal implements MealPlan {
    private String name;
    private int calories;
    private int proteinGrams;

    HighProteinMeal(String name, int calories, int proteinGrams) {
        this.name = name;
        this.calories = calories;
        this.proteinGrams = proteinGrams;
    }

    @Override
    public String getDescription() {
        return "HighProtein: " + name + " (" + calories + " kcal, " + proteinGrams + "g protein)";
    }

    @Override
    public boolean isValid() {
        // must have at least 20g protein and calories > 0
        return calories > 0 && proteinGrams >= 20;
    }

    @Override
    public String toString() {
        return getDescription();
    }
}

// ---------- 3) Generic Meal class that holds a generated plan ----------
class Meal<T extends MealPlan> {
    private List<T> planItems = new ArrayList<>();
    private String ownerName;

    Meal(String ownerName) {
        this.ownerName = ownerName;
    }

    public void add(T item) {
        planItems.add(item);
    }

    public List<T> getItems() {
        return Collections.unmodifiableList(planItems);
    }

    public void displayPlan() {
        System.out.println("Meal plan for: " + ownerName);
        if (planItems.isEmpty()) {
            System.out.println("  (empty)");
            return;
        }
        int day = 1;
        for (T t : planItems) {
            System.out.println("  Day " + day++ + ": " + t);
        }
    }

    // basic validation over whole plan (all items valid)
    public boolean isValidPlan() {
        for (T t : planItems) {
            if (!t.isValid()) return false;
        }
        return true;
    }
}

// ---------- 4) Generic generator method ----------
class MealPlanner {
    /**
     * Generate a plan of length 'days' by selecting items from availableOptions.
     * Validates each chosen meal with isValid() before adding.
     *
     * @param ownerName name of person
     * @param availableOptions list of possible meal items (can't be empty)
     * @param days number of days to generate
     * @param <T> meal type (extends MealPlan)
     * @return Meal<T> containing the generated plan
     * @throws IllegalArgumentException if inputs invalid or not enough valid options
     */
    public static <T extends MealPlan> Meal<T> generateMealPlan(
            String ownerName,
            List<T> availableOptions,
            int days
    ) {
        if (availableOptions == null || availableOptions.isEmpty()) {
            throw new IllegalArgumentException("No available meal options provided.");
        }
        if (days <= 0) {
            throw new IllegalArgumentException("Days must be positive.");
        }

        // filter only valid options
        List<T> validOptions = new ArrayList<>();
        for (T opt : availableOptions) {
            if (opt != null && opt.isValid()) validOptions.add(opt);
        }

        if (validOptions.isEmpty()) {
            throw new IllegalArgumentException("No valid meal options available after validation.");
        }

        Meal<T> plan = new Meal<>(ownerName);

        // simple selection: round-robin through valid options
        for (int i = 0; i < days; i++) {
            T pick = validOptions.get(i % validOptions.size());
            plan.add(pick);
        }

        // final check (redundant because we used validOptions) but included to show validation usage
        if (!plan.isValidPlan()) {
            throw new IllegalStateException("Generated plan failed validation.");
        }

        return plan;
    }
}

// ---------- 5) Demo ----------
public class MealPlanDemo {
    public static void main(String[] args) {
        // Vegetarian demo
        List<VegetarianMeal> vegOptions = Arrays.asList(
                new VegetarianMeal("Paneer Curry with Rice", 600),
                new VegetarianMeal("Veg Pulao + Raita", 550),
                new VegetarianMeal("Mixed Veg + Chapati", 450)
        );

        Meal<VegetarianMeal> vegPlan = MealPlanner.generateMealPlan("Aadi", vegOptions, 5);
        vegPlan.displayPlan();

        System.out.println();

        // Keto demo (one invalid option included to test validation)
        List<KetoMeal> ketoOptions = Arrays.asList(
                new KetoMeal("Grilled Salmon + Salad", 700, 8.0),
                new KetoMeal("Cheese Omelette", 400, 3.5),
                new KetoMeal("Pasta (not keto)", 800, 120.0) // invalid: carbs too high
        );

        // generatePlan will ignore invalid options; if all invalid -> exception
        Meal<KetoMeal> ketoPlan = MealPlanner.generateMealPlan("Riya", ketoOptions, 4);
        ketoPlan.displayPlan();

        System.out.println();

        // HighProtein demo
        List<HighProteinMeal> hpOptions = Arrays.asList(
                new HighProteinMeal("Grilled Chicken + Quinoa", 650, 45),
                new HighProteinMeal("Greek Yogurt Bowl", 350, 22),
                new HighProteinMeal("Tofu Stir-fry", 500, 18) // invalid: protein < 20
        );

        Meal<HighProteinMeal> hpPlan = MealPlanner.generateMealPlan("Sam", hpOptions, 3);
        hpPlan.displayPlan();

        System.out.println();

        // Example: empty options -> will throw exception (uncomment to test)
        // Meal<VeganMeal> fail = MealPlanner.generateMealPlan("Test", new ArrayList<>(), 3);
    }
}
