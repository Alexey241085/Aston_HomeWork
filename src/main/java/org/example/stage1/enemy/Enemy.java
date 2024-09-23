package org.example.stage1.enemy;

import org.example.stage1.Mortal;
import org.example.stage1.hero.Hero;

import java.util.Random;

public class Enemy implements Mortal {

    private String name;
    private int health = 100;

    public Enemy(String name) {
        this.name = name;
    }

    public Enemy(String name, int health) {
        this(name);
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public void attackHero(Hero hero) {
        Random random = new Random();
        if (isAlive()){
            if (hero.isAlive()) {
                int damage = random.nextInt(15, 30);
                System.out.printf("%s атаковал героя %s урон %d\n",
                        getName(), hero.getName(), damage);
                hero.takeDamage(damage);
                hero.attackEnemy(this);
            } else System.out.println(getName() + " не может атаковать убитого врага");
        }else System.out.printf("%s убит! не может атаковать\n", getName());
    }


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
    public String toString() {
        return String.format("%s, состояние здоровья %d", getName(), getHealth());
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }
}
