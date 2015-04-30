package xor.newvecmat.vec.d;

import xor.newvecmat.vec.b.BVecN;

public abstract class DVecN extends DVec<DVecN, BVecN> {

	@Override
	public DVecN clone() {
		final int size = dim();
		double[] data = new double[size];
		for (int i = 0; i < size; i++) {
			data[i] = get(i);
		}
		return new DRVecN(data);
	}

	@Override
	protected DVecN _new() {
		return new DRVecN(dim());
	}

}
