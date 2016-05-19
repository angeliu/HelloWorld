package ldap;
import com.novell.ldap.*;

import java.util.*;
public class TestSearch  implements Runnable{
	 public  LDAPConnection lc = null;
	 public static int count = 0;
	 public long t;
	// static long[] a = new long[2000];
	 public void run()
	 {    
		 count++;
		 long startTime = System.currentTimeMillis();
			
			try 
			{
			 lc = new LDAPConnection();
			lc.connect("10.108.102.253",389);
			lc.bind(null,null);
			Random r = new Random();
			int n = r.nextInt(20000);
			System.out.println(n);
			String t = String.valueOf(n);
			String s = "|(InsideNumber=" + t + ")";
			//String s="(|(|(hostname=6264825690)(insidenumber=999))(insidenumber=1000))";
			LDAPSearchResults res = lc.search("dc=com", LDAPConnection.SCOPE_SUB, s, null, false);
			
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
			} catch (Exception e)
			{
				e.printStackTrace();
			} finally
			{
				try {
					lc.disconnect();
					lc = null;
				} catch (LDAPException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		 
			long endTime = System.currentTimeMillis();
			
			t = endTime - startTime;
			System.out.println("time is "+t);
	 } 
	 
	public static void main(String[] args)
	{
		
			new Thread(new TestSearch()).start();
	
		
	}
	
		
}
