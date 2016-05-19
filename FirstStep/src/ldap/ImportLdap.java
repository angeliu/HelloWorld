package ldap;
import java.util.ArrayList;
import java.util.Random;

import com.novell.ldap.LDAPAttribute;
import com.novell.ldap.LDAPAttributeSet;
import com.novell.ldap.LDAPConnection;
import com.novell.ldap.LDAPEntry;
import com.novell.ldap.LDAPException;


public class ImportLdap {

	/**
	 * @param args
	 */

	public static void UserImport()
	{
//		String[] suffix = {"ou=xinan,ou=jisuanji,ou=bupt,dc=1,dc=1",
//							"ou=tixi,ou=jisuanji,ou=bupt,dc=1,dc=1",
//							"ou=zhineng,ou=wangyan,ou=bupt,dc=1,dc=1",
//							"ou=kuandai,ou=wangyan,ou=bupt,dc=1,dc=1",
//							"ou=dianzhi,ou=xinxixue,ou=tsinghua,dc=1,dc=1",
//							"ou=jisuanji,ou=xinxixue,ou=tsinghua,dc=1,dc=1",
//							"ou=shuxue,ou=lixue,ou=tsinghua,dc=1,dc=1",
//							"ou=wuli,ou=lixue,ou=tsinghua,dc=1,dc=1",
//							"ou=cailiao,ou=tsinghua,dc=1,dc=1",
//							"ou=shengmingkexue,ou=tsinghua,dc=1,dc=1"};
		String[] suffix = {"ou=1,dc=cn","ou=2,dc=cn","ou=3,dc=cn","ou=4,dc=cn","ou=5,dc=cn",
				"ou=6,dc=cn","ou=7,dc=cn","ou=8,dc=cn","ou=9,dc=cn","ou=10,dc=cn"
				};
		LDAPConnection lc = LdapConnect();
		int InsideNumber = 1;
		long beginTime = System.currentTimeMillis();
		System.out.println("开始程序");
		for( int i = 0; i < 10; i++ ) {
			int count = 0;
			while(count < 10000) {
				if ( adduser(lc,suffix[i],InsideNumber)) {
					count++;
					InsideNumber++;
				}
			}
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("结束程序");
		System.out.println(endTime - beginTime);

	}
	public static boolean adduser(LDAPConnection lc, String suffix,int InsideNumber) {
		
		String[] type = {"uid","name","userPassword","MobilePhone",
			"SatellitePhone","ShortwavePhone","MobileState","SatelliteState","ShortwaveState","InsideNumber"};
	String[] state = {"on","off"};
	String[] value = new String[10];
	ArrayList<LDAPAttribute> list = new ArrayList<LDAPAttribute>();
	LDAPAttribute[] attr = new LDAPAttribute[10];
		
		value[0] = getRandomNumberString(18);
		attr[0] = new LDAPAttribute(type[0], value[0]);
		value[1] = getRandomMixString(10);
		attr[1] = new LDAPAttribute(type[1], value[1]);
		value[2] = getRandomNumberString(10);
		attr[2] = new LDAPAttribute(type[2], value[2]);
		value[3] = getRandomNumberString(11);
		attr[3] = new LDAPAttribute(type[3], value[3]);
		value[4] = getRandomNumberString(11);
		attr[4] = new LDAPAttribute(type[4], value[4]);
		value[5] = getRandomNumberString(11);
		attr[5] = new LDAPAttribute(type[5], value[5]);
	
		Random r = new Random();
		int index = r.nextInt(2);
		value[6] = state[index];
		attr[6] = new LDAPAttribute(type[6], value[6]);
		index = r.nextInt(2);
		value[7] = state[index];
		attr[7] = new LDAPAttribute(type[7], value[7]);
		index = r.nextInt(2);
		value[8] = state[index];
		attr[8] = new LDAPAttribute(type[8], value[8]);	
		
		value[9] = Integer.toString(InsideNumber);
		attr[9] = new LDAPAttribute(type[9], value[9]);
		
		for ( int i = 0; i < 10; i++ ) {
			list.add(attr[i]);
		}
		LDAPAttributeSet attrset;
		String objectclass[] = {"User"};
		LDAPAttribute obj = new LDAPAttribute("objectclass", objectclass);
		attrset = new LDAPAttributeSet();
		
		attrset.add(obj);
		int len = list.size();
		for ( int i = 0; i < len; i++ ) {
			attrset.add(list.get(i));
		}
		String dn = "uid="+value[0]+","+suffix;
		LDAPEntry entry = new LDAPEntry(dn, attrset);
		try {
			lc.add(entry);
		//	System.out.println("add an entry: " + dn);
			return true;
		} catch (LDAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static LDAPConnection LdapConnect() {
		
		LDAPConnection lc = new LDAPConnection();
		String rootdn = "cn=Manager,dc=1,dc=1";
		String password = "000000";
		try {
			lc.connect("10.108.96.165", 389);
			lc.bind(rootdn, password);
			return lc;
		} catch (LDAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getRandomMixString(int length) {   
		
	    StringBuffer buffer = new StringBuffer("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");    
	    StringBuffer sb = new StringBuffer();    
	    Random r = new Random();    
	    int range = buffer.length();    
	    for (int i = 0; i < length; i ++) {    
	        sb.append(buffer.charAt(r.nextInt(range)));    
	    }    
	    return sb.toString();    
	}
	
	public static String getRandomNumberString(int length) {    
	    StringBuffer buffer = new StringBuffer("0123456789");    
	    StringBuffer sb = new StringBuffer();    
	    Random r = new Random();    
	    int range = buffer.length();    
	    for (int i = 0; i < length; i ++) {    
	        sb.append(buffer.charAt(r.nextInt(range)));    
	    }    
	    return sb.toString();    
	}    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImportLdap.UserImport();
	}

}
