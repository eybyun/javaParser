/*
 * This file is part of antlr-java-parser.
 *
 *     antlr-java-parser is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     antlr-java-parser is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with antlr-java-parser.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.github.antlrjavaparser.adapter;

import com.github.antlrjavaparser.Java7Parser;
import com.github.antlrjavaparser.api.body.VariableDeclarator;
import com.github.antlrjavaparser.api.body.VariableDeclaratorId;

public class VariableDeclaratorContextAdapter implements Adapter<VariableDeclarator, Java7Parser.VariableDeclaratorContext> {
    public VariableDeclarator adapt(Java7Parser.VariableDeclaratorContext context, AdapterParameters adapterParameters) {

        VariableDeclarator variableDeclarator = new VariableDeclarator();

        VariableDeclaratorId variableDeclaratorId = new VariableDeclaratorId();
        variableDeclaratorId.setName(context.Identifier().getText());

        if (context.LBRACKET() != null && context.LBRACKET().size() > 0) {
            variableDeclaratorId.setArrayCount(context.LBRACKET().size());
        }

        variableDeclarator.setId(variableDeclaratorId);

        if (context.variableInitializer() != null) {
            variableDeclarator.setInit(Adapters.getVariableInitializerContextAdapter().adapt(context.variableInitializer(), adapterParameters));
        }

        return variableDeclarator;
    }
}
