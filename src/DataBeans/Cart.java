package DataBeans;

public class Cart {
	private String	userName;
    private String 	medicineName;
    private String 	image;
    private int 	price;
    private long 	vendorCode;
    private long 	barcode;
    private int 	availability;
    private int 	quantity;
    private int 	totalPrice;

    public String 	getUserName()        		{ return userName; 		}
    public String 	getMedicineName()        	{ return medicineName; 	}
    public String 	getImage()        			{ return image; 		}
    public int 		getPrice()        			{ return price; 		}
    public long 	getVendorCode()        		{ return vendorCode; 	}
    public long 	getBarcode()        		{ return barcode; 		}
    public int 		getAvailability()			{ return availability;	}
    public int 		getQuantity()				{ return quantity;		}
    public int 		getTotalPrice()				{ return totalPrice;	}

    public void		setUserName(String s)		{ userName = s;			}
    public void 	setMedicineName(String s)  	{ medicineName = s;    	}
    public void 	setImage(String s)  		{ image = s;    		}
    public void 	setPrice(int s)  			{ price = s;    		}
    public void 	setVendorCode(long s)  		{ vendorCode = s;    	}
    public void 	setBarcode(long s)  		{ barcode = s;    		}
    public void 	setAvailability(int s)		{ availability = s;		}
    public void 	setQuantity(int s)			{ quantity = s;			}
    public void 	setTotalPrice(int s)		{ totalPrice = s;		}
}