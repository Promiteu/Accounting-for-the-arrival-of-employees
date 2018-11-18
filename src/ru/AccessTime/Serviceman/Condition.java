package ru.AccessTime.Serviceman;

public enum Condition {
    DUTY("Du", "Наряд"),  DISEASED("Di", "Больничный"),  MISSION ("Mi", "Командировка"), VACATION ("Mi", "Отпуск"), ONNFASE ("On", "");

    private String code;
    private String text;

    Condition(String code, String text) {
        this.code = code;
        this.text = text;
    }

    public String getCode() {
        return code;
    }

    public String getText() {
        return text;
    }

    public static Condition getByCode(String conditionCode) {
        for (Condition g : Condition.values()) {
            if (g.code.equals(conditionCode)) {
                return g;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
