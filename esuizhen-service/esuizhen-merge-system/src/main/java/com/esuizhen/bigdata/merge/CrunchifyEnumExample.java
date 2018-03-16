package com.esuizhen.bigdata.merge;

public class CrunchifyEnumExample {
 
	public enum Company {
        EBAY, PAYPAL, GOOGLE, YAHOO, ATT
	}
 
	Company cName;
 
	public CrunchifyEnumExample(Company cName) {
		this.cName = cName;
	}
 
	public void companyDetails() {
		switch (cName) {
		case EBAY:
			System.out.println("Biggest Market Place in the World.");
			break;
 
		case PAYPAL:
			System.out.println("Simplest way to manage Money.");
			break;
 
		case GOOGLE:
		case YAHOO:
			System.out.println("1st Web 2.0 Company.");
			break;
 
		default:
			System.out.println("Google - biggest search giant.. ATT - my carrier provider..");
			break;
		}
	}
 
	public static void main(String[] args) {
		CrunchifyEnumExample ebay = new CrunchifyEnumExample(Company.EBAY);
		ebay.companyDetails();
		CrunchifyEnumExample paypal = new CrunchifyEnumExample(Company.PAYPAL);
		paypal.companyDetails();
		CrunchifyEnumExample google = new CrunchifyEnumExample(Company.GOOGLE);
		google.companyDetails();
		CrunchifyEnumExample yahoo = new CrunchifyEnumExample(Company.YAHOO);
		yahoo.companyDetails();
		CrunchifyEnumExample att = new CrunchifyEnumExample(Company.ATT);
		att.companyDetails();
	}
}