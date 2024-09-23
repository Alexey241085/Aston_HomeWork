package org.example.stage1.enemy;

public class Zombie extends Enemy{

    private int health = 100;
    private int count = 1;

    public Zombie(String name) {
        super(name);
    }

    public Zombie(String name, int health) {
        super(name, health);
    }

//    @Override
//    public void takeDamage(int damage) {
//
//        if (isAlive()) {
//            health = health - damage;
//            if (health > 0) {
//                System.out.printf("У %s осталось %d здоровья\n", getName(), getHealth());
//            } else {
//                if (count == 1){
//                    System.out.println("%s умер, но воскрес!");
//                    health = 100;
//                    count = count - 1;
//                } else System.out.printf("%s УБИТ\n", getName());
//            }
//        } else
//            System.out.println("Ошибка! что-то пошло не так");
//    }
}
