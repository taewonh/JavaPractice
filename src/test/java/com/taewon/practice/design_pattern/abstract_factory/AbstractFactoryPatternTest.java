package com.taewon.practice.design_pattern.abstract_factory;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AbstractFactoryPatternTest {

    ThemeFactory windowsFactory;
    ThemeFactory macFactory;

    @BeforeEach
    public void init() {
        windowsFactory = new WindowsThemeFactory();
        macFactory = new MacThemeFactory();
    }

    @Test
    public void testCreateWindowsAlarm() {
        Alarm alarm = windowsFactory.createAlarm();
        Assertions.assertEquals(WindowsAlarm.class, alarm.getClass());
    }

    @Test
    public void testCreateWindowsButton() {
        Button button = windowsFactory.createButton();
        Assertions.assertEquals(WindowsButton.class, button.getClass());
    }

    @Test
    public void testCreateMacAlarm() {
        Alarm alarm = macFactory.createAlarm();
        Assertions.assertEquals(MacAlarm.class, alarm.getClass());
    }

    @Test
    public void testCreateMacButton() {
        Button button = macFactory.createButton();
        Assertions.assertEquals(MacButton.class, button.getClass());
    }
}
