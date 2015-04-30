package xor.newvecmat.vec.f;

import xor.newvecmat.vec.b.BVecN;



public abstract class VecN extends Vec<VecN, BVecN> {

	@Override
	public VecN clone() {
		final int size = dim();
		float[] data = new float[size];
		for (int i = 0; i < size; i++) {
			data[i] = get(i);
		}
		return new RVecN(data);
	}

	@Override
	protected VecN _new() {
		return new RVecN(dim());
	}

}
