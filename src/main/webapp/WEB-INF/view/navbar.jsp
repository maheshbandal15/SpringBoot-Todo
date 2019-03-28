<%@page import="com.todotask.model.User" %>
<!--Navigation bar-->
  <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/">ToDo<span><small> webapp</small>	</span></a>
      </div>
      <div class="collapse navbar-collapse" id="myNavbar">
        <ul class="nav navbar-nav navbar-right">
          <li><a href="#feature">Features</a></li>
          <li><a href="#organisations">Organisations</a></li>
          <li><a href="#faculity-member">Members</a></li>
          <li><a href="/mail/send">Contact Us</a></li>
          
          <%User user =(User) session.getAttribute("user");
          	if(user!=null) {
          %>
          <li><a href="logout">Logout</a></li>
          <li><a href="books">Add Books</a></li>
          <li><a href="allbooks">Library</a></li>
          <%} else {
          %>
          <li><a href="#" data-target="#login" data-toggle="modal">Sign in</a></li>
          <li><a href="signup">SignUp</a></li>
          <%} %>
          <% if(user!=null) {
          %>
          <li class="btn-trial"><a href="allusers">${user.firstName}</a></li>
          <% } %>
        </ul>
      </div>
    </div>
  </nav>
  <!--/ Navigation bar-->