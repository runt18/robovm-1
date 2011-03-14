/*
 * Copyright (C) 2011 The NullVM Open Source Project
 *
 * TODO: Insert proper license header.
 */
package org.nullvm.compiler.llvm;

/**
 *
 * @version $Id$
 */
public class Fptrunc extends ConversionInstruction {
    public Fptrunc(Variable result, Value op, Type type) {
        super("fptrunc", result, op, type);
    }
}
