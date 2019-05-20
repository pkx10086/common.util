package common.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Hashtable;

public class PathClassLoader
  extends ClassLoader
{
  protected final ClassLoader parent;
  @SuppressWarnings({ "unchecked", "rawtypes" })
private final Hashtable<String, Class<?>> definedClasses = new Hashtable();
  
  public PathClassLoader()
  {
    this(PathClassLoader.class.getClassLoader());
  }
  
  public PathClassLoader(ClassLoader _parent)
  {
    this.parent = _parent;
  }
  
  @SuppressWarnings({ "unchecked", "rawtypes" })
protected synchronized Class loadClass(String name, boolean resolve)
    throws ClassNotFoundException
  {
    Class cls = findLoadedClass(name);
    if ((cls == null) && (this.parent != null)) {
      try
      {
        cls = this.parent.loadClass(name);
      }
      catch (ClassNotFoundException e) {}
    }
    if (cls == null) {
      cls = findClass(name);
    }
    if (resolve) {
      resolveClass(cls);
    }
    return cls;
  }
  
  @SuppressWarnings("rawtypes")
public Class loadClassByClassName(String className)
    throws ClassNotFoundException, IOException
  {
    URL url = PathUtils.getClassLocationURL(Class.forName(className));
    return loadClass(url.openConnection().getInputStream());
  }
  
  @SuppressWarnings("rawtypes")
public Class loadClass(File file)
    throws ClassNotFoundException, IOException
  {
    return loadClass(new FileInputStream(file));
  }
  
  @SuppressWarnings("rawtypes")
public Class loadClass(InputStream in)
    throws ClassNotFoundException, IOException
  {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    byte[] buf = new byte['?'];
    for (;;)
    {
      int l = in.read(buf);
      if (l <= 0) {
        break;
      }
      out.write(buf, 0, l);
    }
    in.close();
    return loadClass(out.toByteArray());
  }
  
  @SuppressWarnings("rawtypes")
public Class loadClass(byte[] b)
    throws ClassNotFoundException
  {
    return loadClass(b, 0, b.length);
  }
  
  @SuppressWarnings({ "rawtypes" })
public Class loadClass(byte[] b, int off, int len)
    throws ClassNotFoundException
  {
    Class cls = defineClass(null, b, off, len);
    this.definedClasses.put(cls.getName(), cls);
    return loadClass(cls.getName());
  }
  
  @SuppressWarnings({ "rawtypes", "unchecked" })
protected Class findClass(String name)
    throws ClassNotFoundException
  {
    Class cls = (Class)this.definedClasses.get(name);
    if (cls == null) {
      throw new ClassNotFoundException(name);
    }
    return cls;
  }
  
  public void loadDirectory(File dir)
    throws ClassNotFoundException, IOException
  {
    if (dir.isFile())
    {
      if (dir.getName().endsWith("class")) {
        loadClass(dir);
      }
      return;
    }
    for (File file : dir.listFiles()) {
      if (file.isDirectory()) {
        loadDirectory(file);
      } else if (file.getName().endsWith("class")) {
        loadClass(file);
      }
    }
  }
  
  public URL getResource(String name)
  {
    URL url = null;
    if (this.parent != null) {
      url = this.parent.getResource(name);
    } else {
      url = super.getResource(name);
    }
    if (url == null) {
      url = findResource(name);
    }
    return url;
  }
}
