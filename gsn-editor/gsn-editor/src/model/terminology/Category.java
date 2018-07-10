/*******************************************************************************
 * Copyright (C) 2018 Timothy G Rowe
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package model.terminology;

/**
 * The Category class describes categories of ExpressionElements (Terms and Expressions) and can be used 
 * to group these elements within TerminologyPackages.
 * <h1>Semantics</h1>
 * Terms and ExpressionElements can be said to belong to Categories. Categories can group Terms, 
 * Expressions, or a mixture of both. For example, a Category could be used to describe the terminology 
 * associated with a specific assurance standard, project, or system.
 */
public abstract class Category extends TerminologyAsset {

}
