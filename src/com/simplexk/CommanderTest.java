package com.simplexk;

import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: zhixiong
 * Date: 3/17/13
 * Time: 1:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class CommanderTest {
    @Test
    public void testSend() throws Exception {
        Commander.send(new Command("forward"));
    }
}
