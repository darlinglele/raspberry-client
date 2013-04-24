package com.simplexk;

/**
 * Created with IntelliJ IDEA.
 * User: zhixiong
 * Date: 3/17/13
 * Time: 9:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class Command {

    private final String command;

    public Command(String command) {
        this.command =command;
    }

    @Override
    public String toString(){
        return this.command;
  }
}
