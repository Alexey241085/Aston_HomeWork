package org.example.stage1;

import org.example.stage1.enemy.Enemy;
import org.example.stage1.enemy.Zombie;
import org.example.stage1.hero.Archer;
import org.example.stage1.hero.Hero;
import org.example.stage1.hero.Mage;
import org.example.stage1.hero.Warrior;

import java.util.ArrayList;
import java.util.List;


public class BattleGround {
    public static void main(String[] args) {

        // Создаются очастники битвы

        System.out.println("**** участники игры***\n");
        Archer archer1 = new Archer("Archer");
        System.out.println(archer1);

        Warrior warrior = new Warrior("Warrior");
        System.out.println(warrior);

        Mage mage1 = new Mage("Mage");
        System.out.println(mage1);

        Zombie zombie1 = new Zombie("Zombie");
        System.out.println(zombie1);

        Enemy enemy1 = new Enemy("Enemy");
        System.out.println(enemy1);

        System.out.println("\n**************\n Маг атакует Зомби супер ударом Зомби воскрешает 1 раз\n");

        mage1.superAttackEnemy(zombie1);

        System.out.println("\n**************\n Маг добавляет всем союзникам жизни\n");


        List<Hero>list = new ArrayList<>();
        list.add(archer1);
        list.add(mage1);
        list.add(warrior);

        System.out.println(list);
//
        mage1.heroChangeHeals(list);
        System.out.println("Добавил жизни  (+30)");
        System.out.println(list);
//
       System.out.println("\n**************\n Герой атакует несколько врагов\n");
//
//
//
//
        List<Enemy> enemyList = new ArrayList<>();
        enemyList.add(zombie1);
        enemyList.add(enemy1);


        archer1.attackManyEnemy(enemyList);






//// Маг атакует
//        mage1.attackEnemy(zombie);
//
//        System.out.println("\n\n");
//
//// Enemy  атакует Лучника
//        zombie.attackHero(mage1);
//
//        mage1.attackEnemy(zombie);


    }
}
