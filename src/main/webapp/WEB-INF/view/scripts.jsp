
  <script src="static/js/jquery.min.js"></script>
  <script src="static/js/jquery.easing.min.js"></script>
  <script src="static/js/bootstrap.min.js"></script>
  <script src="static/js/custom.js"></script>
  <!-- <script src="static/contactform/contactform.js"></script> -->
  <script>
  function validateNum(num) 
  {
      var maintainplus = '';
      var numval = num.value
      if ( numval.charAt(0)=='+' )
      {
          var maintainplus = '';
      }
      curphonevar = numval.replace(/[\\A-Za-z!"£$%^&\,*+_={};:'@#~,.Š\/<>?|`¬\]\[]/g,'');
      num.value = maintainplus + curphonevar;
      var maintainplus = '';
      num.focus;
  }
  function email_validate(email)
  {
  var regMail = /^([_a-zA-Z0-9-]+)(\.[_a-zA-Z0-9-]+)*@([a-zA-Z0-9-]+\.)+([a-zA-Z]{2,3})$/;

      if(regMail.test(email) == false)
      {
      document.getElementById("status").innerHTML    = "<span class='warning'>Email address is not valid yet.</span>";
      }
      else
      {
      document.getElementById("status").innerHTML	= "<span class='valid'>Thanks, you have entered a valid Email address!</span>";	
      }
  }
  </script>