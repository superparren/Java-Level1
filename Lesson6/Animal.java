package Sabirov.Lesson6;

import org.w3c.dom.ls.LSOutput;

public abstract class Animal {
    protected String name;
    protected String nick;
    int distance = 5;

    public Animal(String name, String nick) {
        this.name = name;
        this.nick = nick;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void run(){
        System.out.println(name +" "+ nick +" "+ "run"+ " " + this.distance + "m");
    }
    public void swim() {
        System.out.println(name + " " + nick + " " + "swim" + " " + this.distance + "m");
    }
}