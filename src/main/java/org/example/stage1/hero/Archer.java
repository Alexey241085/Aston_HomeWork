package org.example.stage1.hero;

import org.example.stage1.enemy.Enemy;

import java.util.Random;

public class Archer extends Hero {

    private int health = 100;

    @Override
    public int getHealth() {
        return health;
    }

    public Archer(String name) {
        super(name);
    }

    public Archer(String name, int health) {
        super(name);
        this.setHealth(health);
    }

    @Override
    public void attackEnemyInfo() {
        System.out.println(getName() + " выпустил стрелу по пратвнику");
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
            System.out.println("Урон не может быть отрицательным");
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        Random random = new Random();
        if(isAlive()){
            if (enemy.getHealth() > 0) {
                int damage = random.nextInt(10, 25);
                System.out.printf("%s выпустил стрелу по пратвнику %s урон %d\n",
                        getName(), enemy.getName(), damage);
                enemy.takeDamage(damage);
                enemy.attackHero(this);
            } else System.out.println(getName() + " не может атаковать убитого врага");
        }else System.out.printf("%s убит! не может атаковать", getName());

    }


    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }
}
