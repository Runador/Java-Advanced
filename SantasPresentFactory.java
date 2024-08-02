import java.util.*;

public class SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        ArrayDeque<Integer> magicLevelQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(materialsStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .forEach(magicLevelQueue::offer);


        Map<String, Integer> presentsMap = new TreeMap<>();
        presentsMap.put("Doll", 0);
        presentsMap.put("Wooden train", 0);
        presentsMap.put("Teddy bear", 0);
        presentsMap.put("Bicycle", 0);

        while (!materialsStack.isEmpty() && !magicLevelQueue.isEmpty()) {

            int lastBoxWithMaterials = materialsStack.peek();
            int firstMagicLevelValue = magicLevelQueue.peek();
            int result = lastBoxWithMaterials * firstMagicLevelValue;

            switch (result) {
                case 150 -> {
                    if (presentsMap.containsKey("Doll")) {
                        presentsMap.put("Doll", presentsMap.get("Doll") + 1);
                    } else {
                        presentsMap.put("Doll", 1);
                    }
                    materialsStack.pop();
                    magicLevelQueue.poll();
                }
                case 250 -> {
                    if (presentsMap.containsKey("Wooden train")) {
                        presentsMap.put("Wooden train", presentsMap.get("Wooden train") + 1);
                    } else {
                        presentsMap.put("Wooden train", 1);
                    }
                    materialsStack.pop();
                    magicLevelQueue.poll();
                }
                case 300 -> {
                    if (presentsMap.containsKey("Teddy bear")) {
                        presentsMap.put("Teddy bear", presentsMap.get("Teddy bear") + 1);
                    } else {
                        presentsMap.put("Teddy bear", 1);
                    }
                    materialsStack.pop();
                    magicLevelQueue.poll();
                }
                case 400 -> {
                    if (presentsMap.containsKey("Bicycle")) {
                        presentsMap.put("Bicycle", presentsMap.get("Bicycle") + 1);
                    } else {
                        presentsMap.put("Bicycle", 1);
                    }
                    materialsStack.pop();
                    magicLevelQueue.poll();
                }
                default -> {
                    if (result < 0) {
                        lastBoxWithMaterials += firstMagicLevelValue;
                        materialsStack.pop();
                        magicLevelQueue.poll();
                        materialsStack.push(lastBoxWithMaterials);
                    } else if (result > 0) {
                        magicLevelQueue.poll();
                        materialsStack.push(materialsStack.pop() + 15);
                    }
                    if (firstMagicLevelValue == 0 && lastBoxWithMaterials == 0) {
                        materialsStack.pop();
                        magicLevelQueue.poll();
                    } else if (firstMagicLevelValue == 0) {
                        magicLevelQueue.poll();
                    } else if (lastBoxWithMaterials == 0) {
                        materialsStack.pop();
                    }
                }
            }
        }

        // doll and a train
        // teddy bear and a bicycle

        int dollsAndTrainsCounter = 0;
        int teddyBearsAndBicyclesCounter = 0;

        for (var entry : presentsMap.entrySet()) {
            String present = entry.getKey();
            int value = entry.getValue();
            if (present.equals("Doll") && value > 0) {
                dollsAndTrainsCounter++;
            } else if (present.equals("Wooden train") && value > 0) {
                dollsAndTrainsCounter++;
            } else if (present.equals("Teddy bear") && value > 0) {
                teddyBearsAndBicyclesCounter++;
            } else if (present.equals("Bicycle") && value > 0) {
                teddyBearsAndBicyclesCounter++;
            }
        }

        if (dollsAndTrainsCounter >= 2 || teddyBearsAndBicyclesCounter >= 2) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materialsStack.isEmpty()) {
            System.out.print("Materials left: ");
            System.out.print(String.join(", ", materialsStack.toString().replaceAll("[\\[\\]]", "")));
        }
        if (!magicLevelQueue.isEmpty()) {
            System.out.print("Magic left: ");
            System.out.print(String.join(", ", magicLevelQueue.toString().replaceAll("[\\[\\]]", "")));
        }
        System.out.println();
        for (var entry : presentsMap.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
            }
        }
    }
}
