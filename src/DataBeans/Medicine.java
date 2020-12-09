package DataBeans;

public class Medicine {
    private String 	medicineName;
    private String 	image;
    private int 	price;
    private long 	vendorCode;
    private long 	barcode;
    private int 	availability;

    public String 	getMedicineName()        	{ return medicineName; 	}
    public String 	getImage()        			{ return image; 		}
    public int 		getPrice()        			{ return price; 		}
    public long 	getVendorCode()        		{ return vendorCode; 	}
    public long 	getBarcode()        		{ return barcode; 		}
    public int 		getAvailability()			{ return availability;	}

    public void 	setMedicineName(String s)  	{ medicineName = s;    	}
    public void 	setImage(String s)  		{ image = s;    		}
    public void 	setPrice(int s)  			{ price = s;    		}
    public void 	setVendorCode(long s)  		{ vendorCode = s;    	}
    public void 	setBarcode(long s)  		{ barcode = s;    		}
    public void 	setAvailability(int s)		{ availability = s;		}
}