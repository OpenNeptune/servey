<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.util.regex.*" %>
<%@ page import="java.lang.reflect.*" %>
<%!
    String getRequestFileRealPath(HttpServletRequest request){
        String webRoot = request.getSession().getServletContext().getRealPath("/").replaceAll("\\\\", "/"),
               context = request.getContextPath(),
               uri = request.getRequestURI();
        if(context!=null&&webRoot.endsWith(context+"/")){
            return webRoot.substring(0,webRoot.indexOf(context))+uri;
        }
        return webRoot+uri;
    }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>IsWaf Info</title>
<style>
    body {background-color: #ffffff;color: #000000;}
    body,td,th,h1,h2 {font-family: sans-serif;}
    pre{margin: 0px;font-family: monospace;}
    a:link {color: #000099;text-decoration: none;background-color: #ffffff;}
    a:hover {text-decoration: underline;}
    table {border-collapse: collapse;margin-bottom: 15px;width:800px;}
    .center {text-align: center;}
    .center table {margin-left: auto;margin-right: auto;text-align: left;}
    .center th {text-align: center !important;}
    td,th {border: 1px solid #000000;font-size: 75%;vertical-align: baseline;}
    h1 {font-size: 150%;}
    h2 {font-size: 125%;}
    .p {text-align: left;}
    .e {background-color: #ccccff;font-weight: bold;color: #000000;}
    .h {background-color: #9999cc;font-weight: bold;color: #000000;}
    .v {background-color: #cccccc;color: #000000;}
    .vr {background-color: #cccccc;text-align: right;color: #000000;}
    img {float: right;border: 0px;}
    hr {width: 600px;background-color: #cccccc;border: 0px;height: 1px;color: #000000;}
</style>
</head>
<body>
    <div class="center">
        <table border="0" cellpadding="3">
            <tbody>
                <tr class="h">
                    <td>
                        <h1 class="p"><%=System.getProperty("java.runtime.name")+":"+System.getProperty("java.runtime.version")%></h1>
                    </td>
                </tr>
            </tbody>
        </table>
        <br/>
     
        <h2>System Environment Variables</h2>
        <table border="0">
                <%
                    Map<String,String> map = System.getenv();
                    for(String s:map.keySet()){
                %>
                <tr>
                    <td class="e"><%=s%></td>
                    <td class="v"><%=map.get(s)%></td>
                </tr>
                <%
                    }
                %>
        </table>
 
        <h2><%=application.getServerInfo() %> Environment</h2>
        <table>
                <tr>
                    <td class="e">SERVER_NAME</td>
                    <td class="v"><%=request.getServerName() %></td>
                </tr>
                <tr>
                    <td class="e">SERVER_ADDR</td>
                    <td class="v"><%=request.getLocalAddr() %></td>
                </tr>
                <tr>
                    <td class="e">SERVER_PORT</td>
                    <td class="v"><%=request.getLocalPort() %></td>
                </tr>
                <tr>
                    <td class="e">DOCUMENT_ROOT</td>
                    <td class="v"><%=application.getRealPath("/").replaceAll("\\\\","/") %></td>
                </tr>
                <tr>
                    <td class="e">SCRIPT_FILENAME</td>
                    <td class="v"><%=getRequestFileRealPath(request)%></td>
                </tr>
                <%
                    Enumeration<String> e = request.getHeaderNames();
                    while(e.hasMoreElements()){
                        String k = (String)e.nextElement();
                     
                %>
                <tr>
                    <td class="e"><%=k%></td>
                    <td class="v"><%=request.getHeader(k) %></td>
                </tr>
                <%}%>
        </table>
         
         
        <h2>System Properties</h2>
        <table border="0">
                <%
                    for(Object s:System.getProperties().keySet()){
                %>
                <tr>
                    <td class="e"><%=s%></td>
                    <td class="v"><%=System.getProperty((String)s)%></td>
                </tr>
                <%}%>
        </table>
        <br/>
         
        <h2>Java License</h2>
        <table border="0" cellpadding="3">
            <tbody>
                <tr class="v">
                    <td>
                        <p>javaweb.org&p2j.cn</p>
                    </td>
                </tr>
            </tbody>
        </table>
        <br/>
    </div>
</body>
</html>