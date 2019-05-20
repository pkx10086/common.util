package common.util;


import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public abstract class IPUtil
{
  public static boolean isWindowsOS()
  {
    boolean isWindowsOS = false;
    String osName = System.getProperty("os.name");
    if (osName.toLowerCase().indexOf("windows") > -1) {
      isWindowsOS = true;
    }
    return isWindowsOS;
  }
  
  public static String getLocalIP()
  {
    String sIP = "";
    InetAddress ip = null;
    try
    {
      if (isWindowsOS())
      {
        ip = InetAddress.getLocalHost();
      }
      else
      {
        boolean bFindIP = false;
        Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
        while ((netInterfaces.hasMoreElements()) && 
          (!bFindIP))
        {
          NetworkInterface ni = (NetworkInterface)netInterfaces.nextElement();
          
          Enumeration<InetAddress> ips = ni.getInetAddresses();
          while (ips.hasMoreElements())
          {
            ip = (InetAddress)ips.nextElement();
            if ((ip.isSiteLocalAddress()) && (!ip.isLoopbackAddress()) && (ip.getHostAddress().indexOf(":") == -1)) {
              bFindIP = true;
            }
          }
        }
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
    if (null != ip) {
      sIP = ip.getHostAddress();
    }
    return sIP == null ? "" : sIP;
  }
}