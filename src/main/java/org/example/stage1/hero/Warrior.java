package org.example.stage1.hero;

import org.example.stage1.enemy.Enemy;

import java.util.List;
import java.util.Random;

public class Warrior extends Hero {

    private int health = 100;


    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    public Warrior(String name) {
        super(name);
    }
    public Warrior(String name, int health) {
        super(name);
        this.setHealth(health);
    }

    @Override
    public void attackEnemyInfo() {
        System.out.println(getName() + " нанес удар по пратвнику");
    }

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
    public void attackEnemy(Enemy enemy) {
        Random random = new Random();
        if(isAlive()){
            if (enemy.getHealth() > 0) {
                int damage = random.nextInt(10, 25);
                System.out.printf("%s нанес удар по пратвнику %s урон %d\n",
                        getName(), enemy.getName(), damage);
                enemy.takeDamage(damage);
                enemy.attackHero(this);
            } else System.out.println(getName() + " не может атаковать убитого врага");
        }else System.out.printf("%s убит! не может атаковать", getName());
    }

//    @Override
//    public void attackManyEnemy(List<Enemy> enemyList) {
//
//    }


//    @Override
//    public String toString() {
//        return super.toString();
//    }


    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }
}
