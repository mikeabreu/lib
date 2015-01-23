package data;

import java.io.Serializable;

public class LLNode<T> implements Serializable {

	// Generated Serial Code (used for saving objects to file)
	private static final long serialVersionUID = 8915535695817970947L;
	
	private LLNode<T> link;
	private T info;

	protected LLNode(T info) {
		this.info = info;
		link = null;
	}

	protected void setInfo(T info)
	// Sets info of this LLNode.
	{
		this.info = info;
	}

	protected T getInfo()
	// Returns info of this LLONode.
	{
		return info;
	}

	protected void setLink(LLNode<T> link)
	// Sets link of this LLNode.
	{
		this.link = link;
	}

	protected LLNode<T> getLink()
	// Returns link of this LLNode.
	{
		return link;
	}
}