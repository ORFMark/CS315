package InClass.Mutltitype;

public class DblLinkBase {
	private DblLinkBase next;
	private DblLinkBase previous;
	
	DblLinkBase() {
		next = null;
		previous = null;
	}
	protected void setNext(DblLinkBase nextLink) {
		next = nextLink;
	}
	
	protected void setPrevious(DblLinkBase prevLink) {
		previous = prevLink;
	}
	protected DblLinkBase getNext() {
		return next;
	}
	
	protected DblLinkBase getPrevious() {
		return previous;
	}
	
}
