package util;

public class Post extends Topic
{
	int seqNo;
	Object content;
	
	public Post(String title, Object content) 
	{
		super(title);
		this.content=content;
	
	}
	
	public int getSeqNo() {
		return seqNo;
	}
	public void setSeqNo(int seqNo) {
		this.seqNo = seqNo;
	}
	public Object getContent() {
		return content;
	}
	public void setContent(Object content) {
		this.content = content;
	}

	
	
	
}
