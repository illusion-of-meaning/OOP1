package com.asherbakov;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FlowersBouquet {
    private Flower[] bouquest;

    // Не смог придумать, как в рамках пройденного материала адекватно посчитать количество цветов разного типа.
    Map<String, Integer> flowerType = new HashMap<>();

    public FlowersBouquet(Flower... flowers) {
        bouquest = flowers;
        for (Flower f : flowers) {
            if (flowerType.containsKey(f.getName())) {
                Integer temp = flowerType.get(f.getName());
                flowerType.put(f.getName(), ++temp);
            } else {
                flowerType.put(f.getName(), 1);
            }
        }
    }

    public Flower[] getBouquest() {
        return bouquest;
    }

    public int getMinLifeSpan() {
        int minLifeSpan = Integer.MAX_VALUE;
        for (Flower f : bouquest) {
            if (f.getLifeSpan() < minLifeSpan) {
                minLifeSpan = f.getLifeSpan();
            }
        }
        return minLifeSpan;
    }

    public double getCost() {
        double cost = 0;
        for (Flower f : bouquest) {
            cost += f.getCost();
        }
        cost += cost * 0.1;
        return  cost;
    }

    @Override
    public String toString() {
        String result = "В букете находятся: \n";
        for (Map.Entry<String, Integer> entry : flowerType.entrySet()) {
            result += "\t" + entry.getKey() + " - " + entry.getValue() + "\n";
        }
        result += String.format("будет стоить %.2f рублей и простоит %s суток.", getCost(), getMinLifeSpan());
        return result;
    }
}
