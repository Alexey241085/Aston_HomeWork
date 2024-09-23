package org.example.stage1.hero;

import org.example.stage1.enemy.Enemy;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class Mage extends Hero {

    private int health = 100;

    @Override
    public int getHealth() {
        return health;
    }

    public Mage(String name) {
        super(name);
    }

    @Override
    public void attackEnemyInfo() {
        System.out.println(getName() + " применил магию");
    }


    @Override
    public void attackEnemy(Enemy enemy) {
        Random random = new Random();
        if(isAlive()){
            int damageSelection = random.nextInt(0, 4);
            if (damageSelection == 0 || damageSelection == 1|| damageSelection == 2) {
                if (enemy.getHealth() > 0) {
                    int damage = random.nextInt(5, 91);
                    System.out.printf("%s применил магию %s урон %d\n",
                            getName(), enemy.getName(), damage);
                    enemy.takeDamage(damage);
                    enemy.attackHero(this);
                } else System.out.println(getName() + " не может атаковать убитого врага");

            }else {
                if (enemy.getHealth() > 0) {
                    int damage = random.nextInt(30, 71);
                    System.out.printf("%s применил СУПЕР МАГИЮ %s урон %d\n",
                            getName(), enemy.getName(), damage);
                    enemy.takeDamage(damage);
                    enemy.attackHero(this);
                } else System.out.println(getName() + " не может атаковать убитого врага");
            }

        }else System.out.printf("%s убит! не может атаковать\n", getName());

    }

    /**
     * метод према урона
     * @param damage уровень урона
     */
    @Override
    public void takeDamage(int damage) {
        if (isAlive()) {
            health = health - damage;
            if (health > 0) {
                System.out.printf("У %s осталось %d здоровья\n", getName(), getHealth());
            } else {
                System.out.printf("%s УБИТ\n", getName());
            }
        } else
            System.out.println("Ошибка! что-то пошло не так");
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }
}
