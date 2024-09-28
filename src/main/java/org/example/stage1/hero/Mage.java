package org.example.stage1.hero;

import org.example.stage1.enemy.Enemy;

import java.util.List;
import java.util.Random;


public class Mage extends Hero {

    Random random = new Random();
    int damage = random.nextInt(5, 31);

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    private int health = 100;

    @Override
    public int getHealth() {
        return health;
    }

    public Mage(String name) {
        super(name);
    }

    public Mage(String name, int health) {
        super(name);
        this.setHealth(health);
    }

    @Override
    public void attackEnemyInfo() {
        System.out.println(getName() + " применил магию");
    }

    /**
     * метод атаки врага включет обычный урон и супер урон
     * (выбор через random)
     *
     * @param enemy объект врага
     */
    @Override
    public void attackEnemy(Enemy enemy) {
        int damageSelection = random.nextInt(0, 3);
        if (isAlive()) {
            if (damageSelection == 0 || damageSelection == 1) {
                mageAttack(enemy);
            }
            if (damageSelection == 2) {
                superAttackEnemy(enemy);
            }
        } else System.out.printf("%s убит! не может атаковать!", getName());
    }

    /**
     * метод в котором герой атакует несколько врагов
     * @param enemyList список врагов
     */
//    @Override
//    public void attackManyEnemy(List<Enemy> enemyList) {
//        Random random = new Random();
//        while (isAlive()) {
//            if (isAlive()) {
//                int selectEnemy = random.nextInt(0, enemyList.size());
//                attackEnemy(enemyList.get(selectEnemy));
//                if (enemyList.get(selectEnemy).getHealth() <= 0) {
//                    enemyList.remove(enemyList.get(selectEnemy));
//                }
//                if (enemyList.isEmpty()) {
//                    System.out.println("герой всех победил");
//                    break;
//                }
//            }
//        }
//    }

    /**
     * метод Супер атаки мага (урон увеличен)
     *
     * @param enemy объкт врага
     */
    public void superAttackEnemy(Enemy enemy) {
        damage = damage + 20;
        if (enemy.getHealth() > 0) {
            System.out.printf("%s применил SUPER магию %s урон %d\n",
                    getName(), enemy.getName(), damage);
            enemy.takeDamage(damage);
            enemy.attackHero(this);
        } else System.out.println(getName() + " не может атаковать убитого врага");

    }

    /**
     * метод увеличивает всем героям жизни
     *
     * @param list
     */
    public void heroChangeHeals(List<Hero> list) {
        list.stream().forEach(h -> h.setHealth(h.getHealth() + 30));
        System.out.println(getName() + " добавил жизней союзникам");
    }

    /**
     * метод стандартной атаки маага
     *
     * @param enemy объкт врага
     */

    private void mageAttack(Enemy enemy) {
        if (enemy.getHealth() > 0) {
            System.out.printf("%s применил магию %s урон %d\n",
                    getName(), enemy.getName(), damage);
            enemy.takeDamage(damage);
            enemy.attackHero(this);
        } else System.out.println(getName() + " не может атаковать убитого врага");
    }

    /**
     * метод према урона
     *
     * @param damage уровень урона
     */
    @Override
    public void takeDamage(int damage) {
        if (isAlive()) {
            health = health - damage;
            if (health > 0) {
                System.out.printf("У %s осталось %d здоровья\n", getName(), getHealth());
            } else {
                System.out.printf("%s УБИТ!\n", getName());
            }
        } else
            System.out.println("Ошибка! что-то пошло не так");
    }

    /**
     * метод показывает живой или нет
     *
     * @return true если герой жив
     */
    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
