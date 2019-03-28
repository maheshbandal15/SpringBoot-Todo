<!DOCTYPE html >
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Contact Us</title>
  <meta name="description" content="Free Bootstrap Theme by BootstrapMade.com">
<jsp:include page="stylesheet.jsp"></jsp:include>
</head>
<body>

  <jsp:include page="navbar.jsp"></jsp:include>
  <jsp:include page="LoginModal.jsp"></jsp:include>
  <!--Contact-->
<!--   <section id="contact" class="section-padding"> -->
    <div class="container">
      <div class="row">
        <div class="header-section text-center">
          <h2>Contact Us</h2>
          <p>We believes communication between customer and company is the key success factor for any business relationship.
          	If you want to make any inquiry or you want any clarification regarding our services, products and any other issue.
           	Please get in touch with us.</p>
          <hr class="bottom-line">
        </div>
        <!-- <div id="sendmessage">Your message has been sent. Thank you!</div>
        <div id="errormessage"></div> -->
        <form action="mail/sendTemplate" method="POST" role="form" class="contactForm" modelAttribute="mailObject">
          <div class="col-md-6 col-sm-6 col-xs-12 left">
            <div class="form-group">
              <input type="text" name="name" class="form-control form" id="name"  placeholder="Your Name" data-rule="minlen:4" data-msg="Please enter at least 4 chars" />
              <div class="validation"></div>
            </div>
            <div class="form-group">
              <input type="email" class="form-control" name="to" id="email" path="to" placeholder="eg. maheshbandal15@gmail.com" data-rule="email" data-msg="Please enter a valid email" required/>
              <%-- <form:input path="to" id="input_to" type="email"/> --%>
              <div class="validation"><form:errors path="to" cssStyle="color:red;font-size:small"/></div>
            </div>
            <div class="form-group">
              <input type="text" class="form-control" name="subject" path="subject" id="subject" placeholder="Subject" data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" required/>
              <div class="validation"></div>
            </div>
          </div>

          <div class="col-md-6 col-sm-6 col-xs-12 right">
            <div class="form-group">
              <textarea class="form-control" name="text" path="text" rows="5" data-rule="required" data-msg="Please write something for us" placeholder="Message" required></textarea>
              <div class="validation"></div>
            </div>
          </div>

          <div class="col-xs-12">
            <!-- Button -->
            <button type="submit" id="submit" name="submit" class="form contact-form-button light-form-button oswald light">SEND EMAIL</button>
          </div>
        </form>

      </div>
    </div>
  <!-- </section> -->
  <!--/ Contact-->
	<div class="container">
		<div class="row">
			<div class="header-section text-center">
			<h4> To allow Less Secure Apps <a href="https://myaccount.google.com/lesssecureapps?utm_source=google-account&utm_medium=web"> click here</a></h4>
			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
<jsp:include page="scripts.jsp"></jsp:include>

</body>
</html>