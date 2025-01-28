package com.taewon.practice.design_pattern.abstract_factory;

public class MacThemeFactory implements ThemeFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Alarm createAlarm() {
        return new MacAlarm();
    }
}
