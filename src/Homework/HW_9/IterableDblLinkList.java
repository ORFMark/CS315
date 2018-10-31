package Homework.HW_9;

public class IterableDblLinkList extends DblLinkList {
    
    private class IteratorX extends GoFIterator {
        private DblLinkList ourList;
        private DblLink cursor;

        protected IteratorX(DblLinkList ourList) {
            this.ourList = ourList;
            cursor = ourList.head;
        }

        @Override
        public boolean isDone() {
            return cursor == null;
        }

        @Override
        public void first() {
            cursor = ourList.head;
        }

        @Override
        public void next() {
            if (!isEmpty())
                cursor = cursor.getNext();
        }

        @Override
        public Tree.Node currentItem() {
            if (isEmpty())
                return null;
            else
                return cursor.getNode();
        }
        
    }
    
    public GoFIterator getGoFIterator() {
        return new IteratorX(this);
    }
    
}
