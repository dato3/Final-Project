package DataBeans;

public class News {
    private String 	header;
    private String 	content;
    private String 	postDate;
    private String 	image;
    
    public String 	getHeader()		        	{ return header; 		}
    public String 	getContent()        		{ return content; 		}
    public String	getPostDate()				{ return postDate;		}
    public String 	getImage()					{ return image;			}
    
    public void 	setHeader(String s)  		{ header = s;    		}
    public void 	setContent(String s)  		{ content = s;    		}
    public void 	setPostDate(String s)  		{ postDate = s;    		}
    public void 	setImage(String s)			{ image = s;			}
}