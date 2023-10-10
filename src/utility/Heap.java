
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

package utility;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import models.CommonNode;
import models.HeapNode;

public class Heap {

	private List<HeapNode> Heap; // having 1 more element at 0th index
	private int size; // actual size
	private boolean isMax = false;

	private Comparator<CommonNode> compare;

	// to track
	public Map<CommonNode, Integer> trackIndex;

	public Heap(CommonNode node) {
		isMax = false;
		this.size = 0;
		Heap = new ArrayList<>();
		Heap.add(new HeapNode(node));
		trackIndex = new HashMap<>();

		compare = (a, b) -> a.degree - b.degree;
	}

	public Heap(CommonNode node, Comparator<CommonNode> compare) {
		isMax = false;
		this.size = 0;
		Heap = new ArrayList<>();
		Heap.add(new HeapNode(node));
		trackIndex = new HashMap<>();

		Objects.requireNonNull(compare);

		this.compare = compare;
	}

	public Heap(CommonNode node, boolean isMax) {
		this.isMax = isMax;
		this.size = 0;
		Heap = new ArrayList<>();
		Heap.add(new HeapNode(node));
		trackIndex = new HashMap<>();

		if (isMax) {
			compare = (a, b) -> b.degree - a.degree;
		} else {
			compare = (a, b) -> a.degree - b.degree;
		}
	}

	public int getSize() {
		return size;
	}

	private int parent(int pos) {
		return pos / 2;
	}

	private int leftChild(int pos) {
		return (2 * pos);
	}

	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	private void swap(int fpos, int spos) {
		HeapNode tmp;
		tmp = Heap.get(fpos);
		Heap.set(fpos, Heap.get(spos));
		Heap.get(fpos).index = fpos;
		Heap.set(spos, tmp);
		tmp.index = spos;
		trackIndex.put(Heap.get(fpos).data, Heap.get(fpos).index);
		trackIndex.put(Heap.get(spos).data, Heap.get(spos).index);
	}

	private boolean compareWithChild(HeapNode posNode, HeapNode childNode) {

		int result = compare.compare(posNode.data, childNode.data);

		return result > 0;

//		int posValue = posNode.data.degree, childValue = childNode.data.degree;
//		
//		if (isMax) {
//			return posValue < childValue;
//		}
//		return posValue > childValue;
	}

	private boolean compareWithParent(HeapNode posNode, HeapNode parentNode) {

		int result = compare.compare(posNode.data, parentNode.data);

		return result < 0;

//		int posValue = posNode.data.degree, parentValue = parentNode.data.degree;
//		
//		if (isMax) {
//			return posValue > parentValue;
//		}
//		return posValue < parentValue;
	}

	public void downHeapify(int pos) {
		if (pos * 2 > (size))
			return;

		if (compareWithChild(Heap.get(pos), Heap.get(leftChild(pos)))
				|| (pos * 2 + 1 <= size && compareWithChild(Heap.get(pos), Heap.get(rightChild(pos))))) {

			if (pos * 2 + 1 <= size && compareWithChild(Heap.get(leftChild(pos)), Heap.get(rightChild(pos)))) {
				swap(pos, rightChild(pos));
				downHeapify(rightChild(pos));
			} else {
				swap(pos, leftChild(pos));
				downHeapify(leftChild(pos));
			}
		}
	}

	public void downHeapify(CommonNode node) {
		int pos = trackIndex.get(node);
		if (pos * 2 > (size))
			return;

		if (compareWithChild(Heap.get(pos), Heap.get(leftChild(pos)))
				|| (pos * 2 + 1 <= size && compareWithChild(Heap.get(pos), Heap.get(rightChild(pos))))) {

			if (pos * 2 + 1 <= size && compareWithChild(Heap.get(leftChild(pos)), Heap.get(rightChild(pos)))) {
				swap(pos, rightChild(pos));
				downHeapify(rightChild(pos));
			} else {
				swap(pos, leftChild(pos));
				downHeapify(leftChild(pos));
			}
		}
	}

	public void heapifyUp(int pos) {
		HeapNode temp = Heap.get(pos);

		while (pos > 0 && parent(pos) > 0 && compareWithParent(temp, Heap.get(parent(pos)))) {
			Heap.set(pos, Heap.get(parent(pos)));
			Heap.get(pos).index = pos;
			trackIndex.put(Heap.get(pos).data, pos);
			pos = parent(pos);
		}
		Heap.set(pos, temp);
		temp.index = pos;
		trackIndex.put(temp.data, pos);
	}

	public void heapifyUp(CommonNode element) {
		int pos = trackIndex.get(element);
		HeapNode temp = Heap.get(pos);

		while (pos > 0 && parent(pos) > 0 && compareWithParent(temp, Heap.get(parent(pos)))) {
			Heap.set(pos, Heap.get(parent(pos)));
			Heap.get(pos).index = pos;
			trackIndex.put(Heap.get(pos).data, pos);
			pos = parent(pos);
		}
		Heap.set(pos, temp);
		temp.index = pos;
		trackIndex.put(temp.data, pos);
	}

	public void add(CommonNode element) {
		// System.out.println("before pus, heap= "+Heap);
		HeapNode tmp = new HeapNode(element);
		if (size == Heap.size() - 1) {
			Heap.add(tmp);
			tmp.index = ++size;
		} else {
			Heap.set(++size, tmp);
			tmp.index = size;
		}

		trackIndex.put(element, tmp.index);
		int current = size;
		heapifyUp(current);
		// System.out.println("after push, heap= "+Heap);

	}

	public void remove(CommonNode element) {

		if (size == 0)
			throw new RuntimeException("Empty queue");

		int ind = trackIndex.get(element);
		swap(ind, size);
		Heap.remove(size);
		trackIndex.remove(element);
		size--;
		downHeapify(ind);
	}

	public CommonNode poll() {
		if (size == 0)
			throw new RuntimeException("Empty queue");
		CommonNode min = Heap.get(1).data;
		swap(1, size);

//		Heap.set(1, Heap.get(size--));
//		Heap.get(1).index=1;
		Heap.remove(size--);
		trackIndex.remove(min);
		downHeapify(1);
		return min;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public CommonNode peek() {
		if (size == 0)
			throw new RuntimeException("Empty queue");
		return Heap.get(1).data;
	}

	public void heapify() {
		for (int i = 1 + size / 2; i >= 1; i--) {
			downHeapify(i);
		}
	}

	@Override
	public String toString() {
		return Heap.toString();
	}

	public Iterator<HeapNode> iterator() {
		// TODO Auto-generated method stub
		Iterator<HeapNode> itr = Heap.iterator();
		itr.next();// skipping -1 node
		return itr;
	}

	public List<HeapNode> getInternalHeap() {
		return this.Heap;
	}

	public void clear() {
		size = 0;
		HeapNode tmp = Heap.get(0);
		Heap.clear();
		Heap.add(tmp);
		trackIndex.clear();
	}

	// -------------------------
	// -------------------------

	public void addWithoutHeapify(CommonNode element) {
		// System.out.println("before pus, heap= "+Heap);
		HeapNode tmp = new HeapNode(element);
		if (size == Heap.size() - 1) {
			Heap.add(tmp);
			tmp.index = ++size;
		} else {
			Heap.set(++size, tmp);
			tmp.index = size;
		}

		trackIndex.put(element, tmp.index);

	}

	public void removeWithoutHeapify(CommonNode element) {

		if (size == 0)
			throw new RuntimeException("Empty queue");

		int ind = trackIndex.get(element);
		swap(ind, size);
		Heap.remove(size);
		trackIndex.remove(element);
		size--;

	}

	public CommonNode pollWithoutHeapify() {
		if (size == 0)
			throw new RuntimeException("Empty queue");
		CommonNode min = Heap.get(1).data;
		swap(1, size);

		Heap.remove(size--);
		trackIndex.remove(min);

		return min;
	}

}
