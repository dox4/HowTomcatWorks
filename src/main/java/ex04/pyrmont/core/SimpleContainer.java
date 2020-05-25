package ex04.pyrmont.core;

import java.beans.PropertyChangeListener;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;
import java.io.File;
import java.io.IOException;
import javax.naming.directory.DirContext;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ex03.pyrmont.connector.http.Constants;
import org.apache.catalina.Cluster;
import org.apache.catalina.Container;
import org.apache.catalina.ContainerListener;
import org.apache.catalina.Loader;
import org.apache.catalina.Logger;
import org.apache.catalina.Manager;
import org.apache.catalina.Mapper;
import org.apache.catalina.Realm;
import org.apache.catalina.Request;
import org.apache.catalina.Response;

public class SimpleContainer implements Container {

//    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";
    public static final String WEB_ROOT = Constants.WEB_ROOT;

    public SimpleContainer() {
    }

    public String getInfo() {
        return null;
    }

    @Override
    public Loader getLoader() {
        return null;
    }

    @Override
    public void setLoader(Loader loader) {
    }

    @Override
    public Logger getLogger() {
        return null;
    }

    @Override
    public void setLogger(Logger logger) {
    }

    @Override
    public Manager getManager() {
        return null;
    }

    @Override
    public void setManager(Manager manager) {
    }

    @Override
    public Cluster getCluster() {
        return null;
    }

    @Override
    public void setCluster(Cluster cluster) {
    }

    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {
    }

    @Override
    public Container getParent() {
        return null;
    }

    @Override
    public void setParent(Container container) {
    }

    @Override
    public ClassLoader getParentClassLoader() {
        return null;
    }

    @Override
    public void setParentClassLoader(ClassLoader parent) {
    }

    @Override
    public Realm getRealm() {
        return null;
    }

    @Override
    public void setRealm(Realm realm) {
    }

    @Override
    public DirContext getResources() {
        return null;
    }

    @Override
    public void setResources(DirContext resources) {
    }

    @Override
    public void addChild(Container child) {
    }

    @Override
    public void addContainerListener(ContainerListener listener) {
    }

    @Override
    public void addMapper(Mapper mapper) {
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
    }

    @Override
    public Container findChild(String name) {
        return null;
    }

    @Override
    public Container[] findChildren() {
        return null;
    }

    @Override
    public ContainerListener[] findContainerListeners() {
        return null;
    }

    @Override
    public Mapper findMapper(String protocol) {
        return null;
    }

    @Override
    public Mapper[] findMappers() {
        return null;
    }

    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {

        String servletName = ((HttpServletRequest) request).getRequestURI();
        servletName = servletName.substring(servletName.lastIndexOf("/") + 1);
        servletName = "webroot." + servletName;
        URLClassLoader loader = null;
        try {
            URL[] urls = new URL[1];
            URLStreamHandler streamHandler = null;
            File classPath = new File(WEB_ROOT);
            String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString();
            urls[0] = new URL(null, repository, streamHandler);
            loader = new URLClassLoader(urls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Class<?> myClass = null;
        try {
            assert loader != null;
            myClass = loader.loadClass(servletName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Servlet servlet;

        try {
            assert myClass != null;
            servlet = (Servlet) myClass.newInstance();
            servlet.service((HttpServletRequest) request, (HttpServletResponse) response);
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }

    @Override
    public Container map(Request request, boolean update) {
        return null;
    }

    @Override
    public void removeChild(Container child) {
    }

    @Override
    public void removeContainerListener(ContainerListener listener) {
    }

    @Override
    public void removeMapper(Mapper mapper) {
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
    }

}