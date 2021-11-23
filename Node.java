public class Node<V> {

	private V name;
	private Node<V> next;


	// create a header
	public Node() {
		name = null;
		next = null;
	}

	public boolean odd() {
		if (getNext() == null) 
			return false;
		else 
			return getNext().oddHeaderless();
	}

	public boolean oddHeaderless() {
		if (getNext() == null)
			return true;
		else return !getNext().oddHeaderless();
	}


	public Node<V> ith(int i)
	{
		if(i > this.length() || i <= 0)
		{
			return null;
		}
		else
		{
			return getNext().ithHeaderless(i);
		}
	}

	private Node<V> ithHeaderless(int i)
	{
		if(i == 1)
		{
			return this;
		}
		else
		{
			return getNext().ithHeaderless(i-1);
		}
	}

	public Node<V> deleteIth(int i)
	{
		if(i > this.length() || i <= 0)
		{
			return null;
		}

		if(i == 1)
		{
			Node<V> temp = this.getNext();
			this.next = this.getNext().getNext();
			return temp;
		}
		else
		{
			return this.getNext().deleteIth(i-1);
		}
	}

	public void add(V d) {
		if (getNext()==null) {
			next = new Node<V>();
			getNext().name = d;
		}
		else getNext().add(d);
	}

	public boolean isEmpty() {
		return getNext()==null;
	}

	public int length() {
		if (isEmpty()) return 0;
		else return getNext().lengthHeaderless();
	}

	private int lengthHeaderless() {
		if (getNext() == null) return 1;
		else return 1+getNext().lengthHeaderless();
	}




	public void print() {
		System.out.println(name);
		if (getNext() != null)
			getNext().print();
	}


	public boolean sameList(Node<V> st) {
		if (st.getNext() == null && getNext() == null)
			return true;
		if (st.getNext() == null || getNext() == null)
			return false;
		else return getNext().sameListHeaderless(st.getNext());

	}

	private boolean sameListHeaderless(Node<V> st) {

		if (!name.equals(st.name))
			return false;
		if (getNext() == null && st.getNext() == null)
			return true;
		if (getNext() == null || st.getNext() == null)
			return false;
		return getNext().sameListHeaderless(st.getNext());
	}

	public Node<V> getNext() {
		return next;
	}

	public String toString() {
		return super.toString()+"  "+name;
	}

}
