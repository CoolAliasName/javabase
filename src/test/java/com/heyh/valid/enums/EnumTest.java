package com.heyh.valid.enums;

import org.junit.Test;

public class EnumTest {

    @Test
    public void processStatusCode() {
        ProcessStatusCode processStatusCode = ProcessStatusCode.CHECK_APPOINTMENT;
        System.out.println(processStatusCode);
    }

    @Test
    public void switchEnum() {
        Signal signal = Signal.RED;

        switch (signal) {
            case RED:
                System.out.println("this is red...");
                break;
            case GREEN:
                System.out.println("this is green...");
                break;
            case YELLOW:
                System.out.println("this is yellow...");
                break;
        }
    }

    @Test
    public void color() {
        Color color = Color.RED;
        color.getColor();
    }

}
