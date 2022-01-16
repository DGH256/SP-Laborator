
var base_url="http://localhost:8080"

$( document ).ready(function() {
    onWindowLoad();
});

function onWindowLoad()
{
get_teachers_list();
get_courses_list();
get_students_list();
init_event_hooks();
//init_sse_emitter();
init_sse_emitter_2();
//init_sse_emitter_3();
}

function init_sse_emitter_2()
{
  var chat_container = $(".emitterContainer2");
  var template='<b>Sender:{0} </b> | <b>Message:{1} </b> <br/>';
  var default_sender="anonymous", sender="";
  var emitterUrl = base_url+"/chat/sse_getAll";

  const eventSource = new EventSource(emitterUrl); 

  eventSource.onmessage = event => {
    const msg = JSON.parse(event.data);

    //console.log("Event: "+event.data);
    //console.log(event.data);
    var chatMessages = $.parseJSON(event.data);

    if(Array.isArray(chatMessages))
    {
    $.each(chatMessages, function(n,elem){

      sender = elem.sender;
      //Checking if sender is null or empty string
      if(sender==null || !sender.trim()) { sender=default_sender};

      chat_container.append(template.format(sender, elem.content));

      });
    }
    else
    {
      sender = chatMessages.sender;
      //Checking if sender is null or empty string
      if(sender==null || !sender.trim()) { sender=default_sender};

      chat_container.append(template.format(sender, chatMessages.content));
    }
  };

}

function init_sse_emitter_3()
{
 var chat_container = $(".emitterContainer2");
 const Http = new XMLHttpRequest();
 const emitterUrl = base_url+"/chat/sse_getAll";

  Http.open("GET", emitterUrl);
  Http.send();

   Http.onreadystatechange = (e) => {
       var response_text = Http.response;
       response_text=response_text.replace("data:","").trim();

       console.log(response_text);
       var response = $.parseJSON(response_text);
       chat_container.append(response);
    }
}


function init_sse_emitter()
{
  var chat_container = $(".emitterContainer");
  var emitterUrl = base_url+"/chat/sse_getAll";

  var sse = $.SSE(emitterUrl, {
      onMessage: function(message) {

        var template='<b>Sender:{0} </b> | <b>Message:{1} </b> <br/>';
  
        var default_sender="anonymous", sender="";

        var chatMessages = $.parseJSON(message.data);

          $.each(chatMessages, function(n,elem){

            sender = elem.sender;
            //Checking if sender is null or empty string
            if(sender==null || !sender.trim()) { sender=default_sender};

            chat_container.append(template.format(sender, elem.content));

            });
      }
  });

  sse.start();
}

function get_teachers_list()
{
$.get( base_url+"/teacher/getAll", function( data ) {

  var template='<tr> <td>{3}</td><td>{0}</td> <td>{1}</td> <td>{2}</td> <td> <button element_id="{3}" class="btn-delete btn-teacher"> Delete </button>  <button element_id="{3}" class="btn-info btn-info-personal btn-teacher"> View info </button> <button element_id="{3}" class="btn-info btn-info-courses btn-teacher"> Enrolled courses </button> </td>  </tr>';
  $.each(data, function(n,elem){
  $(".container_teachers").append(template.format(elem.firstName, elem.lastName, elem.post, elem.id));
  });

}, "json" );

setTimeout(add_event_hooks,500);
}


function get_courses_list()
{
$.get( base_url+"/course/getAll", function( data ) {

  var template='<tr> <td>{3}</td><td>{0}</td> <td>{1}</td> <td>{2}</td> <td> <button element_id="{3}" class="btn-delete btn-course"> Delete </button>  <button element_id="{3}" class="btn-info btn-info-enrolledStudents btn-course"> Enrolled students </button> <button element_id="{3}" class="btn-info btn-info-enrolledTeachers btn-course"> Enrolled teachers </button> </td>  </tr>';
  $.each(data, function(n,elem){
  $(".container_courses").append(template.format(elem.name, elem.credits, elem.year, elem.id));
  });

}, "json" );

setTimeout(add_event_hooks,300);
}

function get_students_list()
{
$.get( base_url+"/student/getAll", function( data ) {

  var template='<tr> <td>{3}</td><td>{0}</td> <td>{1}</td> <td>{2}</td> <td>{4}</td> <td> <button element_id="{3}" class="btn-delete btn-student"> Delete </button>  <button element_id="{3}" class="btn-info btn-info-personal btn-student"> View info </button> <button element_id="{3}" class="btn-info btn-info-courses btn-student"> Enrolled courses </button> </td>  </tr>';
  $.each(data, function(n,elem){
  $(".container_students").append(template.format(elem.firstName, elem.lastName, elem.year , elem.id, elem.age));
  });

}, "json" );

setTimeout(add_event_hooks,500);
}


function init_event_hooks()
{
$(".btn-add-teacher").click(function(){

var firstName = $(".add-teacher-firstName").val();
var lastName = $(".add-teacher-lastName").val();
var title = $(".add-teacher-title").val();

 $.ajax({
        url: base_url+'/teacher/save',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            firstName:firstName,
            lastName:lastName,
            post:title
        }),
        dataType: 'json'
    });

setTimeout(function() {location.reload();}, 300);});


$(".btn-add-course").click(function(){

var name = $(".add-course-name").val();
var credits = $(".add-course-credits").val();
var year = $(".add-course-year").val();

 $.ajax({
        url: base_url+'/course/save',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            name:name,
            credits:credits,
            year:year
        }),
        dataType: 'json'
    });

setTimeout(function() {
    location.reload();
}, 300);

});


$(".btn-add-student").click(function(){

var firstName = $(".add-student-firstName").val();
var lastName = $(".add-student-lastName").val();
var age = $(".add-student-age").val();
var year = $(".add-student-year").val();

 $.ajax({
        url: base_url+'/student/save',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify({
            firstName:firstName,
            lastName:lastName,
            age:age,
            year:year
        }),
        dataType: 'json'
    });

setTimeout(function() {
    location.reload();
}, 300);

});

$(".btn-enrol-teacher").click(function(){

var id_teacher = $(".enrol-teacher-id").val();
var id_course = $(".enrol-teacher-courseId").val();

var url = base_url+"/teacher/"+id_teacher+"/addCourse/"+id_course;

$.get(url);

});

$(".btn-enrol-student").click(function(){

var id_student = $(".enrol-student-id").val();
var id_course = $(".enrol-student-courseId").val();

var url = base_url+"/student/"+id_student+"/addCourse/"+id_course;

$.get(url);

});

$(".btn-add-chatMsg").click(function(){

  var sender = $(".add-chatMsg-sender").val();
  var message = $(".add-chatMsg-message").val();

   $.ajax({
          url: base_url+'/chat/save',
          type: 'POST',
          contentType: 'application/json',
          data: JSON.stringify({
              sender:sender,
              content:message
          }),
          dataType: 'json'
      });
  
});


}



function add_event_hooks()
{

$(".btn-delete").unbind().click(function(){

var id = $(this).attr("element_id");

var url ="";

if($(this).hasClass("btn-teacher")){url=base_url+"/teacher/delete/"+id;}
if($(this).hasClass("btn-student")){url=base_url+"/student/delete/"+id;}
if($(this).hasClass("btn-course")){url=base_url+"/course/delete/"+id;}

$.ajax({url: url});

$(this).closest("tr").remove();

});

$(".btn-info-personal").unbind().click(function(){

var id = $(this).attr("element_id");

var url ="";
var info = "";
if($(this).hasClass("btn-teacher")){url=base_url+"/teacher/"+id;}
if($(this).hasClass("btn-student")){url=base_url+"/student/"+id;}

window.open(url);

});


$(".btn-info-courses").unbind().click(function(){

var id = $(this).attr("element_id");

var url ="";
if($(this).hasClass("btn-teacher")){url=base_url+"/teacher/"+id+"/getCourses/";}
if($(this).hasClass("btn-student")){url=base_url+"/student/"+id+"/getCourses/";}

window.open(url);

});

$(".btn-info-enrolledStudents").unbind().click(function(){

var id = $(this).attr("element_id");

var url ="";
url=base_url+"/course/"+id+"/getStudents/";

window.open(url);

});

$(".btn-info-enrolledTeachers").unbind().click(function(){

var id = $(this).attr("element_id");
var url ="";
url=base_url+"/course/"+id+"/getTeachers/";

window.open(url);

});

}



// First, checks if it isn't implemented yet.
if (!String.prototype.format) {
  String.prototype.format = function() {
    var args = arguments;
    return this.replace(/{(\d+)}/g, function(match, number) {
      return typeof args[number] != 'undefined'
        ? args[number]
        : match
      ;
    });
  };
}