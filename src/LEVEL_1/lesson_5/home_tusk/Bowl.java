package LEVEL_1.lesson_5.home_tusk;

import java.util.Scanner;

public class Bowl implements Eating {
    private static Scanner userInput = new Scanner(System.in);

    protected String name;
    protected int volume;
    protected int food;
    protected boolean Empty_Bowl;


    public Bowl(){
        this.name = setName_of_Owner();
        this.volume = setVolume_of_Bowl();
        this.food = 0;
    }
    public Bowl(String name, int volume, int food) {
        this.name = name;
        this.volume = volume;
        this.food = food;
    }


    protected String setName_of_Owner() {
        System.out.print("Who is the owner of the bowl? ");
        String answer = userInput.nextLine();
        return answer;

    }

    @Override
    public int setVolume_of_Bowl() {
        System.out.print("What is the volume of bowl? ");
        int answer = userInput.nextInt();
        return answer;
    }

    @Override
    public void putFood_in_Bowl() {
        while (true) {
            System.out.print("How many food you want to put in bowl? ");
            int answer = userInput.nextInt();
            if(answer >=0 && answer <= volume) {
                this.food = this.food + answer;
                break;
            }
            else System.out.println("You set incorrect volume of food. Try again.");
        }
    }

    @Override
    public void Info_about_Bowl() {
        System.out.println("In " + name + "'s bowl " + food + " grams of food.");
    }
}