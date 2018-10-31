package Homework.HW_8;

/**
 * @author Mark Burrell burrelm1 @ my.erau.edu
 * @version 1.3 Homework assignment 8
 */
public class IterableDblLinkList extends DblLinkList {

	private class IteratorX extends GoFIterator {
		private DblLink cursor;
		// ptr to data structure needed if Iterator is separate class
		// As a "nested class" you can access head and tail directly
		private DblLinkList ourList;

		protected IteratorX(DblLinkList ourList) {
			// TODO
			this.ourList = ourList;
			cursor = ourList.head;
		}

		@Override
		public boolean isDone() {
			return cursor == null;
		}

		@Override
		public void first() {
			// TODO
			cursor = ourList.head;
		}

		@Override
		public void next() {
			if (!isDone()) {
				cursor = cursor.getNext();
			}
		}

		@Override
		public int currentItem() {
			if (!isDone()) {
				return cursor.getData();
			} else {
				return 0;
			}
		}

	}

	public GoFIterator getGoFIterator() {
		return new IteratorX(this);
	}

	private class IteratorY extends JavaIterator {
		private DblLink cursor;
		// ptr to data structure needed if Iterator is separate class
		// As a nested class you can access head and tail directly
		private DblLinkList ourList;

		protected IteratorY(DblLinkList ourList) {
			// TODO
			this.ourList = ourList;
			cursor = ourList.head;
		}

		@Override
		public boolean hasNext() {
			return cursor != null;
		}

		@Override
		public int next() {
			int temp = 0;
			if (hasNext()) {
				temp = cursor.getData();
				cursor = cursor.getNext();
			}

			return temp;
		}

		private DblLink next(boolean returnLink) {
			DblLink temp = null;
			if (returnLink == true) {
				temp = cursor;
			}
			return temp;
		}

		@Override
		public void remove() {
			DblLink temp = null;
			if (cursor != null) {
				if (cursor.getPrevious() != null) {
					temp = cursor.getPrevious();
					if (temp.getNext() != null && temp.getPrevious() != null) {
						temp.getPrevious().setNext(temp.getNext());
						temp.getNext().setPrevious(temp.getPrevious());
					}
					else {
						if (temp.getPrevious() != null) {
							temp.getPrevious().setNext(null);
							ourList.tail = temp.getPrevious();
						}
						if (temp.getNext() != null) {
							temp.getNext().setPrevious(null);
							ourList.head = temp.getNext();
						}
					}
				}
			} 
			else if (ourList.head == ourList.tail) {
				ourList.head = null;
				ourList.tail = null;
			}
			else {
				ourList.tail = ourList.tail.getPrevious();
				ourList.tail.setNext(null);
			}
		}
	}

	public JavaIterator getJavaIterator() {
		return new IteratorY(this);
	}

}
