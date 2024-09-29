package dev.simonverhoeven.java23demo.preview.scopedvalues;

// JEP 481 - Scoped Values (Third preview)

public class Scoper {
    public final static ScopedValue<String> NAME = ScopedValue.newInstance();

    public static void main() {
        ScopedValue.where(NAME, "Continuum Consulting NV").run(() -> Greeter.greet());
        ScopedValue.where(NAME, "BEJUG").run(() -> Greeter.greet());
    }

}
