/*
 * Copyright (C) 2015 Julio Vilmar Gesser and Mike DeHaan
 *
 * This file is part of antlr-java-parser.
 *
 * antlr-java-parser is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * antlr-java-parser is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with antlr-java-parser.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.github.antlrjavaparser.adapter;

import com.github.antlrjavaparser.Java7Parser;
import com.github.antlrjavaparser.api.expr.BinaryExpr;
import com.github.antlrjavaparser.api.expr.Expression;

public class ExclusiveOrExpressionContextAdapter implements Adapter<Expression, Java7Parser.ExclusiveOrExpressionContext> {
    public Expression adapt(Java7Parser.ExclusiveOrExpressionContext context, AdapterParameters adapterParameters) {
        return AdapterUtil.handleExpression(Adapters.getAndExpressionContextAdapter(), context.andExpression(), BinaryExpr.Operator.xor, adapterParameters);
    }
}
