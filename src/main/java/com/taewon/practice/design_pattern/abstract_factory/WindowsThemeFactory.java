package com.taewon.practice.design_pattern.abstract_factory;

public class WindowsThemeFactory implements ThemeFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Alarm createAlarm() {
        return new WindowsAlarm();
    }
}
