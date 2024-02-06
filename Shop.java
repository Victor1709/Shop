// Создаем класс Toy, который будет представлять игрушку
class Toy {
    private int id;
    private String name;
    private int quantity;
    private double weight;

    // Конструктор класса Toy
    public Toy(int id, String name, int quantity, double weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    // Метод для изменения веса (частоты выпадения) игрушки
    public void setWeight(double weight) {
        this.weight = weight;
    }

    // Метод для получения веса (частоты выпадения) игрушки
    public double getWeight() {
        return weight;
    }
}

// Создаем класс ToyStore, который будет представлять магазин детских товаров
class ToyStore {

    // Массив игрушек
    private Toy[] toys;
    private int totalWeight;

    // Конструктор класса ToyStore
    public ToyStore(int numToys) {
        toys = new Toy[numToys];
        totalWeight = 0;
    }

    // Метод для добавления новой игрушки в магазин
    public void addToy(Toy toy) {
        toys[toys.length - 1] = toy;
        totalWeight += toy.getWeight();
    }

    // Метод для изменения веса (частоты выпадения) игрушки
    public void changeWeight(int toyId, double weight) {
        toys[toyId].setWeight(weight);
        calculateTotalWeight();
    }

    // Метод для организации розыгрыша игрушек
    public Toy play() {
        // Случайное число, которое будет определять выпавшую игрушку
        double randomNumber = Math.random() * totalWeight;
        double currentWeight = 0;

        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (randomNumber <= currentWeight) {
                return toy;
            }
        }

        return null;
    }

    // Метод для пересчета общего веса (частоты выпадения) игрушек
    private void calculateTotalWeight() {
        totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }
    }
}

// Пример использования программы
public class Main {
    public static void main(String[] args) {
        // Создаем магазин с 3 игрушками
        ToyStore toyStore = new ToyStore(3);
        
        // Создаем 3 игрушки
        Toy toy1 = new Toy(1, "Кукла", 10, 20);
        Toy toy2 = new Toy(2, "Мяч", 15, 30);
        Toy toy3 = new Toy(3, "Пазл", 20, 50);
        
        // Добавляем игрушки в магазин
        toyStore.addToy(toy1);
        toyStore.addToy(toy2);
        toyStore.addToy(toy3);

        // Изменяем вес (частоту выпадения) игрушки
        toyStore.changeWeight(1, 25);

        // Организуем розыгрыш
        Toy winnerToy = toyStore.play();

        // Печатаем информацию о выигравшей игрушке
        if (winnerToy != null) {
            System.out.println("Выиграла игрушка: " + winnerToy.getName());
        } else {
            System.out.println("Игрушки не выбраны");
        }
    }
}