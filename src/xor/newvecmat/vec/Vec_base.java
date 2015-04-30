package xor.newvecmat.vec;

import java.nio.ByteBuffer;
import java.util.ListIterator;

public interface Vec_base<T extends Vec_base<T, V>, V> extends Cloneable, Iterable<V> {

	public abstract int dim();

	public abstract V getW(int index);

	public abstract void set(int index, V value);

	public abstract V getW(char c);

	public abstract void set(char c, V value);

	public abstract Vec_base<?, V> getS(CharSequence t);

	public abstract void set(CharSequence t, Vec_base<?, V> value);

	public abstract Vec_base<?, V> getI(int... indices);

	public abstract void set(Vec_base<?, V> value, int... indices);

	public abstract void set(int[] indices, Vec_base<?, V> value);

	public abstract void setTo(T value);

	public abstract T clone();

	@Override
	public abstract ListIterator<V> iterator();

	@Override
	public abstract int hashCode();
	
	@Override
	public abstract boolean equals(Object obj);
	
	public abstract void writeTo(ByteBuffer byteBuffer);

}
