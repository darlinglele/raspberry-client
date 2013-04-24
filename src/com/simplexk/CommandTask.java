package com.simplexk;

import android.os.AsyncTask;

/**
 * Created with IntelliJ IDEA.
 * User: zhixiong
 * Date: 3/17/13
 * Time: 9:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommandTask extends AsyncTask {
    private Command command;

    public CommandTask(Command command) {
        this.command = command;
    }

    @Override
    protected Object doInBackground(Object... objects) {
        try {
            Commander.send(command);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return new Object();
    }
}
