package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private String isFull;

    Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isFull = "остался голодным";
    }

    @Override
    public String toString() {
        return name + " ест с аппетитом: " + appetite + " и поэтому он " + isFull;
    }

    void eat(Plate plate) {
        if (plate.getAmountOfFood() > appetite) {
            isFull = "наелся";
            plate.decreaseFood(appetite);
        } else plate.decreaseFood(plate.getAmountOfFood());

    }
}