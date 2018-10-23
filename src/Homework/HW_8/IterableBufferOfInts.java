package Homework.HW_8;
/**
 * @author      <you>
 * @version     1.0 Homework assignment 8
 */
public class IterableBufferOfInts extends BufferOfInts {

	public IterableBufferOfInts(int size) {
		super(size);
	}

	private class IteratorX extends GoFIterator {
		private int cursor;
		private BufferOfInts ourList;

		protected IteratorX(BufferOfInts ourList) {
			this.ourList = ourList;
			int cursor = 0;
		}

		@Override
		public boolean isDone() {
			return cursor >= ourList.numberOfValues;
		}

		@Override
		public void first() {
			// TODO
			cursor = 0;
		}

		@Override
		public void next() {
			// TODO
			if (!isDone()) {
				cursor++;
			}
		}

		@Override
		public int currentItem() {
			if(!isDone()) {
				return ourList.buffer[cursor];
			}
			else {
				return 0;
			}
		}

	}

	public GoFIterator getGoFIterator() {
		return new IteratorX(this);
	}

}
