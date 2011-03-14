/*
 * Copyright (C) 2011 The NullVM Open Source Project
 *
 * TODO: Insert proper license header.
 */
package org.nullvm.compiler.llvm;

import java.util.Arrays;


/**
 *
 * @version $Id$
 */
public class FunctionType extends UserType {
    private final Type returnType;
    private final Type[] parameterTypes;
    private final boolean varargs;
    
    public FunctionType(Type returnType, Type ... parameterTypes) {
        this(returnType, false, parameterTypes);
    }
    
    public FunctionType(Type returnType, boolean varargs, Type ... parameterTypes) {
        this.returnType = returnType;
        this.varargs = varargs;
        this.parameterTypes = parameterTypes.clone();
    }
    
    public FunctionType(String alias, Type returnType, Type ... parameterTypes) {
        this(alias, returnType, false, parameterTypes);
    }
    
    public FunctionType(String alias, Type returnType, boolean varargs, Type ... parameterTypes) {
        super(alias);
        this.returnType = returnType;
        this.varargs = varargs;
        this.parameterTypes = parameterTypes.clone();
    }

    public Type getReturnType() {
        return returnType;
    }
    
    public boolean isVarargs() {
        return varargs;
    }

    public Type[] getParameterTypes() {
        return parameterTypes;
    }
    
    @Override
    public String getDefinition() {
        StringBuilder sb = new StringBuilder();
        sb.append(returnType.toString());
        sb.append(" (");
        for (int i = 0; i < parameterTypes.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(parameterTypes[i].toString());
        }
        if (varargs) {
            if (parameterTypes.length > 0) {
                sb.append(", ");
            }
            sb.append("...");            
        }
        sb.append(")*");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + Arrays.hashCode(parameterTypes);
        result = prime * result
                + ((returnType == null) ? 0 : returnType.hashCode());
        result = prime * result + (varargs ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        FunctionType other = (FunctionType) obj;
        if (!Arrays.equals(parameterTypes, other.parameterTypes)) {
            return false;
        }
        if (returnType == null) {
            if (other.returnType != null) {
                return false;
            }
        } else if (!returnType.equals(other.returnType)) {
            return false;
        }
        if (varargs != other.varargs) {
            return false;
        }
        return true;
    }
}
