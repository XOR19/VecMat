package xor.newvecmat.vec;

import xor.newvecmat.vec.b.BVec;

public interface Vec_cross<V extends Vec_cross<V, B, N>, B extends BVec<B>, N extends Number> extends Vec_numeric<V, B, N> {

	public V cross(V other);

}
