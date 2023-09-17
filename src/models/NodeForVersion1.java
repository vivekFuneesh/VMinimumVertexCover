
/**
 *	VMinimumVertexCover : Finds a minimum vertex cover for a given graph with exact algorithm in minimal time complexity.
 *	Copyright (C) 2023  Vivek Mangla
 *
 *	This program is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *
 *	This program is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *
 *	You should have received a copy of the GNU General Public License
 *	along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 *	Contact me at vivek.funeesh@gmail.com for queries.
 * 
 * */

package models;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class NodeForVersion1 extends CommonNode {

	public Set<NodeForVersion1> connected = new HashSet<>();

	public NodeForVersion1(int val) {
		this.value = val;
	}

	@Override
	public boolean equals(Object o) {

		// System.out.println("checking for"+ this.value +" == "+
		// ((NodeForVersion1)o).value);

		return this.value == ((NodeForVersion1) o).value;
	}

	@Override
	public String toString() {
		return value + "={" + connected.stream().map(x -> x.value).collect(Collectors.toList()) + "}";
	}

}
