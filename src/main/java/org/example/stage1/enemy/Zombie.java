package org.example.stage1.enemy;

public class Zombie extends Enemy {

    private int health = 100;
    int count = 1;

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    boolean secondLife = true;

    public Zombie(String name) {
        super(name);
    }

    public Zombie(String name, int health) {
        super(name, health);
    }

    /**
     * метод приема урона но воскрешает один раз
     * @param damage уровень урона
     */
    @Override
    public void takeDamage(int damage) {
        if (isAlive()) {
            health = getHealth() - damage;
            if (health > 0) {
                System.out.printf("У %s осталось %d здоровья\n", getName(), getHealth());
            } else {
                if (count < 2) {
                    System.out.printf("%s УБИТ!, нов ВОСКРЕСС\n", getName());
                    System.out.println(isAlive());
                    setHealth(100);
                    System.out.printf("У %s осталось %d здоровья\n", getName(), getHealth());
                    count++;
                    System.out.println(isAlive());
                } else {
                    System.out.printf("%s УБИТ!,\n", getName());
                    secondLife = false;
                }
            }

        } else
            System.out.println("Ошибка! что-то пошло не так");
    }

    @Override
    public boolean isAlive() {
        if (getHealth() > 0) {
            return true;
        }
        return false;
    }
}
