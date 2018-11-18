package ru.AccessTime.GUI;

public enum SignalBG {
    POVISHINNAY("Постоянная"), VOENNAY_OPASNOST("Военная опасность"), POLNAIY("Полная");

    private String name;
    SignalBG(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

