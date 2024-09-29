package dev.simonverhoeven.java23demo.finalized;

// JEP 467: Markdown Documentation Comments
public class MarkdownComments {

    /// Returns a [java.lang.Integer] which is the sum of 2 numbers
    ///
    /// Considerations:
    /// - the sum must fit
    /// - this is a sample
    ///
    /// @param number1 the first number
    /// @param number2 the second number
    /// We can use simple tables for example
    /// | number1 | number2 | result |
    /// |---------|---------|--------|
    /// | 1       | 2       | 3      |
    /// | 5       | 6       | 11     |
    public Integer sampleMethod(Integer number1, Integer number2) {
        return number1 + number2;
    }
}
