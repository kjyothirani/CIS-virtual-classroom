function popup() {
    $.get({
        url : 'userservice',
        success : function(res) {

	           console.log(res);
              //Set response
          console.log(res.username);
             $('#username').text(res.username+'    ||  '+ 'Logout');
             $('#username').css("color","white");

         
        }
     });
}