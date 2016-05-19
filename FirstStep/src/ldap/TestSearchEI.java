package ldap;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import com.novell.ldap.*;

public class TestSearchEI {
	
	public  static LDAPConnection lc = null;
	public static void test()
	{
//		try 
//		{
//		 lc = new LDAPConnection();
//		lc.connect("10.108.102.253",389);
//		lc.bind(null,null);
//		Random r = new Random();
//		int n = r.nextInt(20000);
//		System.out.println(n);
//		String t = String.valueOf(n);
//		//String s = "|(InsideNumber=" + t + ")"+"(hostname=6264825690)";
//		String s="(|(|(hostname=6264825690)(insidenumber=999))(insidenumber=1000))";
//		LDAPSearchResults res = lc.search("dc=com", LDAPConnection.SCOPE_SUB, s, null, false);
//		
//		while(res.hasMore())
//		{
//			LDAPEntry le = res.next();
//			System.out.println(le.getDN());
//			
//		//获取条目信息
//			LDAPAttributeSet attr = le.getAttributeSet();
//			Set sortedAttributes = new TreeSet(attr);
//			Iterator allAttributes = sortedAttributes.iterator();
//			while(allAttributes.hasNext())
//			{
//				LDAPAttribute attribute =(LDAPAttribute)allAttributes.next();
//				String attributeName = attribute.getName();
//				System.out.print(attributeName + ":");
//				Enumeration allValues = attribute.getStringValues();
//				if(allValues != null)
//				{
//					while(allValues.hasMoreElements())
//					{
//						String value = (String)allValues.nextElement();
//						System.out.println(value);
//					}
//				}
//			}
//		}
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//		} finally
//		{
//			try {
//				lc.disconnect();
//				lc = null;
//			} catch (LDAPEception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
		try
		{
			lc = new LDAPConnection();
			lc.connect("10.108.102.142",389);
			lc.bind(null,null);
			Random r = new Random();
			int n = r.nextInt(10000)+1;
			System.out.println(n);
			String t = String.valueOf(n);
			String s = "(InsideNumber=" + t + ")";
			
			
			LDAPSearchResults res = lc.search("dc=1,dc=3", LDAPConnection.SCOPE_SUB,s, null,false);
			
			while(res.hasMore())
			{
				LDAPEntry le = res.next();
				System.out.println(le.getDN());
				
			//获取条目信息
				LDAPAttributeSet attr = le.getAttributeSet();
				Set sortedAttributes = new TreeSet(attr);
				Iterator allAttributes = sortedAttributes.iterator();
				while(allAttributes.hasNext())
				{
					LDAPAttribute attribute =(LDAPAttribute)allAttributes.next();
					String attributeName = attribute.getName();
					System.out.print(attributeName + ":");
					Enumeration allValues = attribute.getStringValues();
					if(allValues != null)
					{
						while(allValues.hasMoreElements())
						{
							String value = (String)allValues.nextElement();
							System.out.println(value);
						}
					}
				}
			}

			
		} catch(LDAPException e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				lc.disconnect();
				lc = null;
			} catch(LDAPException e)
			{
				e.printStackTrace();
			}
		}
				
	}
	public static void main(String[] args)
	{
		double cost;
		int count = 2000;
		long start = System.currentTimeMillis();
		
		for(int i=0;i<count;i++)
		{
			test();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("avarage time :" +(end-start)/count );
		
	}
}
