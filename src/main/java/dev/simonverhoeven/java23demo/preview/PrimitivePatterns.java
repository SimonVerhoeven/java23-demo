package dev.simonverhoeven.java23demo.preview;

// JEP 455 - Primitive Types in Patterns, instanceof, and switch (Preview)

public class PrimitivePatterns {
    record ExamResults(int score){}

    public String determineGrade(ExamResults examResults) {
        return switch (examResults.score) {
            case int i when i >= 90 -> "A";
            case int i when i >= 80 -> "B";
            case int i when i >= 70 -> "C";
            case int i when i >= 60 -> "D";
            case int i when i >= 50 -> "E";
            case int i -> "Failed with a score of " + examResults.score;
        };
    }
}
