package org.example.stage1.hero;

import org.example.stage1.enemy.Enemy;
import org.example.stage1.Mortal;

import java.util.List;
import java.util.Random;

public abstract class Hero implements Mortal {

    private String name;
    private int health;


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


    public void attackManyEnemy(List<Enemy> enemyList) {
        Random random = new Random();
        while (isAlive()) {
            if (isAlive()) {
                int selectEnemy = random.nextInt(0, enemyList.size());
                attackEnemy(enemyList.get(selectEnemy));
                if (enemyList.get(selectEnemy).getHealth() <= 0) {
                    enemyList.remove(enemyList.get(selectEnemy));
                }
                if (enemyList.isEmpty()) {
                    System.out.println("герой всех победил");
                    break;
                }
            }
        }
    }






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
