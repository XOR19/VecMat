package xor.newvecmat.vec.l;

import xor.newvecmat.vec.b.BVecN;



public abstract class LVecN extends LVec<LVecN, BVecN> {

	@Override
	public LVecN clone() {
		final int size = dim();
		long[] data = new long[size];
		for (int i = 0; i < size; i++) {
			data[i] = get(i);
		}
		return new LRVecN(data);
	}

	@Override
	protected LVecN _new() {
		return new LRVecN(dim());
	}

}
