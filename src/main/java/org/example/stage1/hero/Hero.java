package org.example.stage1.hero;

import org.example.stage1.enemy.Enemy;
import org.example.stage1.Mortal;

public abstract class Hero implements Mortal {

    private String name;
    private int health = 100;


    public Hero(String name) {
        this.name = name;
        this.health = getHealth();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }


    /**
     * абстрактный метод атаки
     * @param enemy объект врага
     */
    public abstract void attackEnemy(Enemy enemy);


    /**
     * метод сообщающий о том, что герой атакует
     */
    public void attackEnemyInfo() {
        System.out.printf("%s атаковал противника\n", getName());
    }
    public abstract void takeDamage(int damage);



    @Override
    public String toString() {
        return String.format("%s, состояние здоровья %d", getName(), getHealth());
    }
}
