package javaSandy;

public class TreeNodeNum extends TreeNode {

	private char item;

	TreeNodeNum(char item) {
		super(item);
		this.item = item;
		// TODO Auto-generated constructor stub
	}

	TreeNodeNum() {
		super();
		// this.item = item;
		// TODO Auto-generated constructor stub
	}

	// getters and setters
	public char getItem() {
		return item;
	}

	public void setItem(char item) {
		this.item = item;
	}
}
