package com.github.akarazhev.tutorial.designpatterns.interpreter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

/**
 * Provides basic methods for an expression interpreter.
 */
final class Interpreter {
    /**
     * Provides interpretation of expressions.
     */
    @FunctionalInterface
    public interface Expression {
        /**
         * Interprets a map of operands.
         *
         * @param context a map of operands.
         * @return a result value.
         */
        int interpret(final Map<String, Integer> context);

        /**
         * Returns a number expression.
         *
         * @param value a value.
         * @return an expression.
         */
        static Expression number(final int value) {
            return context -> value;
        }

        /**
         * Returns a result of plus expression.
         *
         * @param left a left expression.
         * @param right a right expression.
         * @return an expression.
         */
        static Expression plus(final Expression left, final Expression right) {
            return context -> left.interpret(context) + right.interpret(context);
        }

        /**
         * Returns a result of minus expression.
         *
         * @param left a left expression.
         * @param right a right expression.
         * @return an expression.
         */
        static Expression minus(final Expression left, final Expression right) {
            return context -> left.interpret(context) - right.interpret(context);
        }

        /**
         * Returns a variable expression.
         *
         * @param value a value.
         * @return an expression.
         */
        static Expression variable(final String value) {
            return context -> context.getOrDefault(value, 0);
        }
    }

    /**
     * Parses an expression.
     *
     * @param expression an expression.
     * @return an expression.
     */
    static Expression parse(final String expression) {
        final var expressions = new ArrayDeque<Expression>();
        for (final var token : expression.split(" ")) {
            expressions.push(parse(token, expressions));
        }

        return expressions.pop();
    }

    private static Expression parse(final String operator, final Deque<Expression> expressions) {
        Expression left, right;
        switch (operator) {
            case "+":
                // It's necessary to remove first the right operand from the stack
                right = expressions.pop();
                // ...and then the left one
                left = expressions.pop();
                return Expression.plus(left, right);
            case "-":
                right = expressions.pop();
                left = expressions.pop();
                return Expression.minus(left, right);
            default:
                return Expression.variable(operator);
        }
    }
}
