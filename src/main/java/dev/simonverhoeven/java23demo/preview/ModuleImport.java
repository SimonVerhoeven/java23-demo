package dev.simonverhoeven.java23demo.preview;

import module java.base;

import static java.lang.System.out;

// JEP 476: Module Import Declarations (Preview)

public class ModuleImport {

    public static void main(String[] args) {
        Stream.of(args).map(input -> input.toUpperCase()).forEach(out::println);
    }
}
