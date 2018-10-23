package Homework.HW_8;
public class IterableLinkList extends LinkList {
	
	private class IteratorX extends GoFIterator {
        private Link cursor;
		private LinkList ourList;

		protected IteratorX(LinkList ourList) {
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
