package dev.simonverhoeven.java23demo.preview;

import module java.lang;
import module java.base;


public class ModuleImport {

    public static void main(String[] args) {
        Stream.of(args).map(input -> input.toUpperCase()).forEach(out::println);
    }
}
