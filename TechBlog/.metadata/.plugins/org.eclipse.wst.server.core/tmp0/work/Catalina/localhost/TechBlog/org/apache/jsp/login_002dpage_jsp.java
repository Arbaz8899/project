/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.58
 * Generated at: 2023-05-04 06:12:41 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.entities.Message;

public final class login_002dpage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/navbar.jsp", Long.valueOf(1677822818374L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.entities.Message");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Login Page</title>\r\n");
      out.write("\r\n");
      out.write("<!-- css -->\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\"\r\n");
      out.write("	integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\"\r\n");
      out.write("	crossorigin=\"anonymous\">\r\n");
      out.write("<link href=\"mystyle.css\" rel=\"stylesheet\" type=\"text/css\" />\r\n");
      out.write("<link rel=\"stylesheet\"\r\n");
      out.write("	href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".banner-background {\r\n");
      out.write("	clip-path: polygon(30% 0%, 100% 0, 100% 30%, 100% 93%, 66% 100%, 34% 92%, 0 100%, 0\r\n");
      out.write("		0);\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	<!-- navbar -->\r\n");
      out.write("\r\n");
      out.write("	");
      out.write("<nav class=\"navbar navbar-expand-lg navbar-dark primary-background\">\r\n");
      out.write("	<a class=\"navbar-brand\" href=\"#\"><span class=\"fa fa-asterisk\"></span>\r\n");
      out.write("		Tech Blog</a>\r\n");
      out.write("	<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\"\r\n");
      out.write("		data-target=\"#navbarSupportedContent\"\r\n");
      out.write("		aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\"\r\n");
      out.write("		aria-label=\"Toggle navigation\">\r\n");
      out.write("		<span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("	</button>\r\n");
      out.write("\r\n");
      out.write("	<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("		<ul class=\"navbar-nav mr-auto\">\r\n");
      out.write("			<li class=\"nav-item active\"><a class=\"nav-link\" href=\"index.jsp\"><span\r\n");
      out.write("					class=\"fa fa-home\"></span> Home</a></li>\r\n");
      out.write("			<li class=\"nav-item dropdown\"><a\r\n");
      out.write("				class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\"\r\n");
      out.write("				role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\"\r\n");
      out.write("				aria-expanded=\"false\"><span class=\"fa fa-navicon\"></span>\r\n");
      out.write("					Categories </a>\r\n");
      out.write("				<div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\r\n");
      out.write("					<a class=\"dropdown-item\" href=\"#\">Programming Language</a> <a\r\n");
      out.write("						class=\"dropdown-item\" href=\"#\">Project Implementation</a>\r\n");
      out.write("					<div class=\"dropdown-divider\"></div>\r\n");
      out.write("					<a class=\"dropdown-item\" href=\"#\">Data Structure</a>\r\n");
      out.write("				</div></li>\r\n");
      out.write("			<li class=\"nav-item\"><a class=\"nav-link\" href=\"#\"><span\r\n");
      out.write("					class=\"fa fa-phone-square\"></span> Contacts</a></li>\r\n");
      out.write("			<li class=\"nav-item\"><a class=\"nav-link\" href=\"login-page.jsp\"><span\r\n");
      out.write("					class=\"fa fa-user-circle\"></span> Login</a></li>\r\n");
      out.write("			<li class=\"nav-item\"><a class=\"nav-link\" href=\"register-page.jsp\"><span\r\n");
      out.write("					class=\"fa fa-user-plus \"></span> Sign up</a></li>\r\n");
      out.write("		</ul>\r\n");
      out.write("		<form class=\"form-inline my-2 my-lg-0\">\r\n");
      out.write("			<input class=\"form-control mr-sm-2\" type=\"search\"\r\n");
      out.write("				placeholder=\"Search\" aria-label=\"Search\">\r\n");
      out.write("			<button class=\"btn btn-outline-light my-2 my-sm-0\" type=\"submit\">Search</button>\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("</nav>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<main\r\n");
      out.write("		class=\"d-flex align-items-center primary-background banner-background\"\r\n");
      out.write("		style=\"height: 90vh\">\r\n");
      out.write("		<div class=\"container\">\r\n");
      out.write("			<div class=\"row\">\r\n");
      out.write("				<div class=\"col-md-4 offset-md-4\">\r\n");
      out.write("					<div class=\"card\">\r\n");
      out.write("						<div class=\"card-header primary-background text-white text-center\">\r\n");
      out.write("							<span class=\"fa fa-user fa-2x\"></span> <br>\r\n");
      out.write("							<p>Login here</p>\r\n");
      out.write("						</div>\r\n");
      out.write("						");

						Message m = (Message) session.getAttribute("msg");
						if (m != null) {
						
      out.write("\r\n");
      out.write("						<div class=\"alert ");
      out.print(m.getCssClass());
      out.write("\" role=\"alert\">\r\n");
      out.write("							");
      out.print(m.getContent());
      out.write("\r\n");
      out.write("						</div>\r\n");
      out.write("\r\n");
      out.write("						");

						session.removeAttribute("msg");
						}
						
      out.write("\r\n");
      out.write("						<div class=\"card-body\">\r\n");
      out.write("							<form action=\"LoginServlet\" method=\"post\">\r\n");
      out.write("								<div class=\"form-group\">\r\n");
      out.write("									<label for=\"exampleInputEmail1\">Email address</label> <input\r\n");
      out.write("										type=\"email\" name=\"email\" required=\"required\"\r\n");
      out.write("										class=\"form-control\" id=\"exampleInputEmail1\"\r\n");
      out.write("										aria-describedby=\"emailHelp\" placeholder=\"Enter email\">\r\n");
      out.write("									<small id=\"emailHelp\" class=\"form-text text-muted\">We'll\r\n");
      out.write("										never share your email with anyone else.</small>\r\n");
      out.write("								</div>\r\n");
      out.write("								<div class=\"form-group\">\r\n");
      out.write("									<label for=\"exampleInputPassword1\">Password</label> <input\r\n");
      out.write("										type=\"password\" name=\"password\" required=\"required\"\r\n");
      out.write("										class=\"form-control\" id=\"exampleInputPassword1\"\r\n");
      out.write("										placeholder=\"Password\">\r\n");
      out.write("								</div>\r\n");
      out.write("								<div class=\"container text-center\">\r\n");
      out.write("									<button type=\"submit\" class=\"btn btn-primary\">Submit</button>\r\n");
      out.write("								</div>\r\n");
      out.write("							</form>\r\n");
      out.write("\r\n");
      out.write("						</div>\r\n");
      out.write("\r\n");
      out.write("					</div>\r\n");
      out.write("\r\n");
      out.write("				</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("		</div>\r\n");
      out.write("\r\n");
      out.write("	</main>\r\n");
      out.write("\r\n");
      out.write("	<!-- Javascripts -->\r\n");
      out.write("\r\n");
      out.write("	<script src=\"https://code.jquery.com/jquery-3.6.3.min.js\"\r\n");
      out.write("		integrity=\"sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=\"\r\n");
      out.write("		crossorigin=\"anonymous\"></script>\r\n");
      out.write("	<script\r\n");
      out.write("		src=\"https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js\"\r\n");
      out.write("		integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\"\r\n");
      out.write("		crossorigin=\"anonymous\"></script>\r\n");
      out.write("	<script\r\n");
      out.write("		src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js\"\r\n");
      out.write("		integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\"\r\n");
      out.write("		crossorigin=\"anonymous\"></script>\r\n");
      out.write("	</script>\r\n");
      out.write("	<script\r\n");
      out.write("		src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-ajaxy/1.6.1/scripts/jquery.ajaxy.min.js\"\r\n");
      out.write("		integrity=\"sha512-bztGAvCE/3+a1Oh0gUro7BHukf6v7zpzrAb3ReWAVrt+bVNNphcl2tDTKCBr5zk7iEDmQ2Bv401fX3jeVXGIcA==\"\r\n");
      out.write("		crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"></script>\r\n");
      out.write("	<script src=\"my.js\" type=\"text/javascript\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
