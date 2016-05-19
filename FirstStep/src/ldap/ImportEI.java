package ldap;

import java.util.ArrayList;
import java.util.Random;

import com.novell.ldap.*;

public class ImportEI {
	public static void userImport()
	{
		String[] suffix = { "ou=163,dc=com",
							"ou=126,dc=com",
							"ou=qq,dc=com",
							"ou=139,dc=com",
							"ou=188,dc=com"
			};
		
		LDAPConnection lc = LDAPConnect();
		int InsideNumber =10001;
		for( int i = 0; i < 5; i++ ) {
			int count = 0;
			while(count < 8000) {
				if ( adduser(lc,suffix[i],InsideNumber)) {
					count++;
					InsideNumber++;
				}
			}
		}
	}
	
	public static boolean adduser(LDAPConnection lc, String suffix,int InsideNumber)
	{	
		String[] type ={"hostname","Ei","Li","Ma","InsideNumber"};
		String[] value = new String[5];
		ArrayList<LDAPAttribute> list = new ArrayList<LDAPAttribute>();
		LDAPAttribute[] attr = new LDAPAttribute[5];
		value[0] = getRandomNumber(10);
		  
		attr[0] = new LDAPAttribute(type[0],value[0]);
		value[1] = getRandomNumber(10);
		attr[1] = new LDAPAttribute(type[1],value[1]);
		value[2] = getRandomNumber(10);
		attr[2] = new LDAPAttribute(type[2],value[2]);
		value[3] = getRandomNumber(10);
		attr[3] = new LDAPAttribute(type[3],value[3]);
		value[4] = Integer.toString(InsideNumber);
		attr[4] = new LDAPAttribute(type[4],value[4]);
		
		for(int i=0;i<5;i++)
		{
			list.add(attr[i]);
		}
		
		LDAPAttributeSet attrset;
		String objectclass[] ={"User"};
		LDAPAttribute obj = new LDAPAttribute("objectclass",objectclass);
		attrset = new LDAPAttributeSet();
		
		attrset.add(obj);
		int len = list.size();
		for(int i=0;i<len;i++)
		{
			attrset.add(list.get(i));
		}
		
		String dn = "hostname="+value[0]+"," +suffix;
		LDAPEntry entry = new LDAPEntry(dn,attrset);
		try{
			lc.add(entry);
			return true;
		} catch (LDAPException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public static LDAPConnection LDAPConnect()
	{
		LDAPConnection lc = new LDAPConnection();
		String rootdn = "cn=manager,dc=com";
		String password = "secret";
		try{
			lc.connect("10.108.102.253", 389);
			lc.bind(rootdn, password);
			return lc;
		} catch (LDAPException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static String getRandomMixString(int length) {
		StringBuffer buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		StringBuffer sb = new StringBuffer();
		
		Random r = new Random();
		int range = buffer.length();
		for(int i = 0;i<length;i++) 
		{
			sb.append(buffer.charAt(r.nextInt(range)));
			
		}
		return sb.toString();
	}
	
	public static  String getRandomNumber(int length)
	{
		StringBuffer buffer = new StringBuffer("0123456789");
		StringBuffer sb = new StringBuffer();
		Random r = new Random();
		int range = buffer.length();
		for(int i=0;i<length;i++)
		{
			sb.append(buffer.charAt(r.nextInt(range)));
		}
		
		return sb.toString();
	}
	public static void main(String[] args)
	{
		System.out.println("begin");
		ImportEI.userImport();
		System.out.println("end");
	}
}
