
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

public class HeapNode {
	public CommonNode data;
	public int index;
	
	public HeapNode(CommonNode data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
}
