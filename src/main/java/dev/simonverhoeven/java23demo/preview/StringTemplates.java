package dev.simonverhoeven.java23demo.preview;

// JEP 459 - String Templates - second preview

import java.util.FormatProcessor;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringTemplates {
    public static void main() {
        simpleInterpolation();
        formattedProcessor();
        customMethodProcessor();
    }

    private static void simpleInterpolation() {
        final var country = "Be";
        final var event = "JUG";
        final var year = 2023;
        final var interpolatedString = STR."Hello \{ // Line breaks are allowed in expressions
                String.join("", country, event)} = \{year + 1} \{
                "Let's see some non-escaped quotes.".toLowerCase()}";
        System.out.println(interpolatedString);
    }

    private static void formattedProcessor() {
        final var formattedOutput = FormatProcessor.FMT."""
            Version      Codename   Release year
            %-10s\{JAVA_VERSIONS_WITH_CODENAMES[0].version()}  %9s\{JAVA_VERSIONS_WITH_CODENAMES[0].codeName()} %14d\{JAVA_VERSIONS_WITH_CODENAMES[0].releaseYear()}
            %-10s\{JAVA_VERSIONS_WITH_CODENAMES[1].version()}  %9s\{JAVA_VERSIONS_WITH_CODENAMES[1].codeName()} %14d\{JAVA_VERSIONS_WITH_CODENAMES[1].releaseYear()}
            """;
        System.out.println(formattedOutput);
    }

    private static void customMethodProcessor() {
        var SIMON_SAYS_PREPENDER = StringTemplate.Processor.of(
                (StringTemplate stringTemplate) -> stringTemplate.values().stream().flatMap(it -> {
                    if (it instanceof List<?> item) {
                        return item.stream();
                    } else return Stream.empty();
                }).map(value -> "Simon said: " + value + "\n").collect(Collectors.joining())
        );

        System.out.println(SIMON_SAYS_PREPENDER."\{List.of("Pralines", "French fries", "Beer")}");
    }

    public record JavaVersion(String version, String codeName, int releaseYear) {}

    private static final JavaVersion[] JAVA_VERSIONS_WITH_CODENAMES ={
        new JavaVersion("JDK 1.0", "Oak", 1996),
                new JavaVersion("JDK 1.1.4", "Sparkler", 1997),
                new JavaVersion("J2SE 1.1.5", "Pumpkin", 1997),
                new JavaVersion("J2SE 1.1.6", "Abigail", 1998),
                new JavaVersion("J2SE 1.1.7", "Brutus", 1998),
                new JavaVersion("J2SE 1.1.8", "Chelsea", 1998),
                new JavaVersion("J2SE 1.2", "Playground", 1998),
                new JavaVersion("J2SE 1.2.2", "Cricket", 1999),
                new JavaVersion("J2SE 1.3", "Kestrel", 2000),
                new JavaVersion("J2SE 1.3.1", "Ladybird", 2001),
                new JavaVersion("J2SE 1.4", "Merlin", 2002),
                new JavaVersion("J2SE 1.4.1", "Hopper", 2002),
                new JavaVersion("J2SE 1.4.2", "Mantis", 2003),
                new JavaVersion("J2SE 5.0", "Tiger", 2004),
                new JavaVersion("Java SE 6", "Mustang", 2006),
                new JavaVersion("Java SE 7", "Dolphin", 2011),
                new JavaVersion("Java SE 8", "Spider", 2014)
    };
}
