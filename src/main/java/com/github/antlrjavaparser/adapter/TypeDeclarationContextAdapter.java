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
import com.github.antlrjavaparser.api.body.EmptyTypeDeclaration;
import com.github.antlrjavaparser.api.body.TypeDeclaration;

public class TypeDeclarationContextAdapter implements Adapter<TypeDeclaration, Java7Parser.TypeDeclarationContext> {
    public TypeDeclaration adapt(Java7Parser.TypeDeclarationContext context, AdapterParameters adapterParameters) {

        // Determine which Type we're dealing with
        if (context.classOrInterfaceDeclaration() != null) {
            return Adapters.getClassOrInterfaceDeclarationContextAdapter().adapt(context.classOrInterfaceDeclaration(), adapterParameters);
        } else if (context.SEMI() != null) {
            TypeDeclaration typeDeclaration = new EmptyTypeDeclaration();
            AdapterUtil.setComments(typeDeclaration, context, adapterParameters);
            AdapterUtil.setPosition(typeDeclaration, context);
            return typeDeclaration;
        }

        return null;
    }
}
