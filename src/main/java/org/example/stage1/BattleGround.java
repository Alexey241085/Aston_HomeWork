package org.example.stage1;

import org.example.stage1.enemy.Enemy;
import org.example.stage1.enemy.Zombie;
import org.example.stage1.hero.Archer;
import org.example.stage1.hero.Mage;


public class BattleGround {
    public static void main(String[] args) {

        Archer archer1 = new Archer("Archer");

        Mage mage1 = new Mage("Mage");

        Enemy enemy1 = new Enemy("Enemy");

        Zombie zombie = new Zombie("Zombie");

// Маг атакует
        mage1.attackEnemy(zombie);

        System.out.println("\n\n");

// Enemy  атакует Лучника
        enemy1.attackHero(archer1);


    }
}
