package com.company;

import com.company.heroes.Fighter;
import com.company.heroes.FighterFactory;
import com.company.heroes.Fighters;

public class Main {


    private static boolean isFirstRound = true;
    private static int rounds = 1;

    public static void main(String[] args)  {

        try {
            fight( FighterFactory.getFigher( Fighters.THE_KNIGHT ), FighterFactory.getFigher( Fighters.THE_LONG_CLAWS ) );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void fight(Fighter f1, Fighter f2) throws InterruptedException{

        if (rounds <= 20 && f1.getHealth() > 0 && f2.getHealth() > 0) {
            if (isFirstRound) {
                System.out.println(f1 + " has encountered " + f2 + ". They prepare to fight!");

                Thread.sleep( 2000 );
                introduction( f1 );
                Thread.sleep( 5000 );
                introduction( f2 );
                Thread.sleep( 5000 );
                System.out.println("Place your bets! ");
                Thread.sleep(3000);
                System.out.println("3");
                Thread.sleep(1000);
                System.out.println("2");
                Thread.sleep(1000);
                System.out.println("1");
                Thread.sleep(1000);

                System.out.println();
                System.out.println(rounds + " turn is starting!");

                Thread.sleep( 3000 );

                isFirstRound = false;
                rounds++;
                if (attacksFirst( f1, f2 )) {
                    System.out.println(f1 + " takes the initiative!");
                    Thread.sleep( 3000 );
                    f1.attack( f2 );
                    fight( f2, f1 );
                } else {
                    System.out.println(f2 + " takes the initiative!");
                    Thread.sleep( 3000 );
                    f2.attack( f1 );
                    fight( f1, f2 );
                }
            } else {
                Thread.sleep( 2000 );
                System.out.println();
                System.out.println(rounds + " turn is starting!");

                f1.attack( f2 );
                rounds++;
                fight( f2, f1 );
            }

        } else {
            if (f1.getHealth() > 0) {
                System.out.println(f1 + " won! ");
            } else {
                System.out.println(f2 + " won!");
            }
        }


    }

    private static boolean attacksFirst(Fighter f1, Fighter f2) {
        if (f1.getSpeed() > f2.getSpeed()) {
            return true;
        }

        if (f2.getSpeed() > f1.getSpeed()) {
            return false;
        }

        if (f1 == f2) {
            if (f1.getLuck() > f2.getLuck()) {
                return true;
            } else {
               return false;
            }
        }
        return false;
    }

    private static void introduction(Fighter f1) {

        int f1MaxAttributesValue = f1.getHealthRange().getMax() + f1.getStrengthRange().getMax() + f1.getDefenceRange().getMax()
                + f1.getLuckRange().getMax() + f1.getSpeedRange().getMax();
        int f1MinAttributesValue = f1.getHealthRange().getMin() + f1.getStrengthRange().getMin() + f1.getDefenceRange().getMin()
                + f1.getLuckRange().getMin() + f1.getSpeedRange().getMin();
        int f1CurrentAttributesValue = f1.getDefence() + f1.getSpeed() + f1.getLuck() + f1.getStrength() + f1.getHealth();

        if (fightCapacity( f1CurrentAttributesValue, f1MaxAttributesValue, f1MinAttributesValue ) <= 0.5 &&
                fightCapacity( f1CurrentAttributesValue, f1MaxAttributesValue, f1MinAttributesValue ) > 0.3) {
            System.out.println(f1 + " is a below average fighter. It has " + f1.getHealth() + " health, " + f1.getStrength() + " strength, " +
                    f1.getLuck() + " luck and " + f1.getDefence() + " defence");
        }

        if (fightCapacity( f1CurrentAttributesValue, f1MaxAttributesValue, f1MinAttributesValue ) <= 0.3 ) {
            System.out.println(f1 + " is a pretty bad fighter. It has " + f1.getHealth() + " health, " + f1.getStrength() + " strength, " +
                    f1.getLuck() + " luck and " + f1.getDefence() + " defence");
        }

        if (fightCapacity( f1CurrentAttributesValue, f1MaxAttributesValue, f1MinAttributesValue ) > 0.5 &&
                fightCapacity( f1CurrentAttributesValue, f1MaxAttributesValue, f1MinAttributesValue ) <= 0.7) {
            System.out.println(f1 + " is a above average fighter. It has " + f1.getHealth() + " health, " + f1.getStrength() + " strength, " +
                    f1.getLuck() + " luck and " + f1.getDefence() + " defence");
        }

        if (fightCapacity( f1CurrentAttributesValue, f1MaxAttributesValue, f1MinAttributesValue ) > 0.7 ) {
            System.out.println(f1 + " is a really good fighter. It has " + f1.getHealth() + " health, " + f1.getStrength() + " strength, " +
                    f1.getLuck() + " luck and " + f1.getDefence() + " defence");
        }


    }

    private static double fightCapacity(double currentAttributes, double maxAttributes, double minAttributes) {
        return (currentAttributes-minAttributes)/(maxAttributes - minAttributes);
    }
}

