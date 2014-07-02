package com.simplexk;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

import static android.view.MotionEvent.ACTION_DOWN;
import static android.view.MotionEvent.ACTION_UP;

public class MainActivity extends Activity {

    private static HashMap<Integer, Command> commandMap;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        setListener();
    }

    private void setListener() {

        setListener(R.id.button_right);
        setListener(R.id.button_left);
        setListener(R.id.button_forward);
        setListener(R.id.button_back);
    }

    private void setListener(int button_id) {
        Button button = (Button) findViewById(button_id);
        button.setOnTouchListener(newListener());
    }

    private View.OnTouchListener newListener() {
        return new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return MainActivity.this.onTouch(view, motionEvent);
            }
        };
    }


    private boolean onTouch(View view, MotionEvent motionEvent) {
        if (commandMap == null) {
            commandMap = new HashMap<Integer, Command>();
            commandMap.put(R.id.button_left, new Command("left"));
            commandMap.put(R.id.button_right, new Command("right"));
            commandMap.put(R.id.button_forward, new Command("forward"));
            commandMap.put(R.id.button_back, new Command("back"));
        }

        if (ACTION_DOWN == motionEvent.getAction())
        {
            sendCommand(commandMap.get(view.getId()));
        }

        if (ACTION_UP == motionEvent.getAction())
        {
            sendCommand(new Command("stop"));
        }
        return false;
    }

    private void sendCommand(Command command) {
        CommandTask commandTask = new CommandTask(command);
        commandTask.execute();
    }
}
