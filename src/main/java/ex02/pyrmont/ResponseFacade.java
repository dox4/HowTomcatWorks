package ex02.pyrmont;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

public class ResponseFacade implements HttpServletResponse {

    private final ServletResponse response;

    public ResponseFacade(Response response) {
        this.response = response;
    }

    public void flushBuffer() throws IOException {
        response.flushBuffer();
    }

    public int getBufferSize() {
        return response.getBufferSize();
    }

    public void setBufferSize(int size) {
        response.setBufferSize(size);
    }

    public String getCharacterEncoding() {
        return response.getCharacterEncoding();
    }

    @Override
    public void setCharacterEncoding(String s) {

    }

    @Override
    public String getContentType() {
        return null;
    }

    public void setContentType(String type) {
        response.setContentType(type);
    }

    public Locale getLocale() {
        return response.getLocale();
    }

    public void setLocale(Locale locale) {
        response.setLocale(locale);
    }

    public ServletOutputStream getOutputStream() throws IOException {
        return response.getOutputStream();
    }

    public PrintWriter getWriter() throws IOException {
        return response.getWriter();
    }

    public boolean isCommitted() {
        return response.isCommitted();
    }

    public void reset() {
        response.reset();
    }

    public void resetBuffer() {
        response.resetBuffer();
    }

    public void setContentLength(int length) {
        response.setContentLength(length);
    }

    @Override
    public void setContentLengthLong(long len) {

    }

    @Override
    public void addCookie(Cookie cookie) {

    }

    @Override
    public boolean containsHeader(String s) {
        return false;
    }

    @Override
    public String encodeURL(String s) {
        return null;
    }

    @Override
    public String encodeRedirectURL(String s) {
        return null;
    }

    @Override
    public String encodeUrl(String s) {
        return null;
    }

    @Override
    public String encodeRedirectUrl(String s) {
        return null;
    }

    @Override
    public void sendError(int i, String s) throws IOException {

    }

    @Override
    public void sendError(int i) throws IOException {

    }

    @Override
    public void sendRedirect(String s) throws IOException {

    }

    @Override
    public void setDateHeader(String s, long l) {

    }

    @Override
    public void addDateHeader(String s, long l) {

    }

    @Override
    public void setHeader(String s, String s1) {

    }

    @Override
    public void addHeader(String s, String s1) {

    }

    @Override
    public void setIntHeader(String s, int i) {

    }

    @Override
    public void addIntHeader(String s, int i) {

    }

    @Override
    public void setStatus(int i, String s) {

    }

    @Override
    public int getStatus() {
        return 0;
    }

    @Override
    public void setStatus(int i) {

    }

    @Override
    public String getHeader(String s) {
        return null;
    }

    @Override
    public Collection<String> getHeaders(String s) {
        return null;
    }

    @Override
    public Collection<String> getHeaderNames() {
        return null;
    }
}