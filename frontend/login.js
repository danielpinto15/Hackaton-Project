

window.onload = function() {
const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});}


$(document).ready(function(){
$("#loginButton").click(function(){
login();
})
});


function login() {
    $.ajax({
        url: "http://localhost:8080/elixir/api/user/login",
        crossDomain: true,
        type: "POST",
        data: JSON.stringify({
            username: $("#loginUsername").val(),
            password: $("#loginPassword").val()
        }),
        async: true,
        contentType: "application/json",
        success: successLoginCallback,
        error: errorLoginCallback
    });
}
function successLoginCallback(response){
    window.location.replace("mainPage.html");
}
function errorLoginCallback(){
    console.log("cenaserror");
}








$(document).ready(function(){
    $('#createAccountButton').click(function(){
       createCustomer();
        });
    });


function createCustomer(){

$.ajax({
    url: 'http://localhost:8080/elixir/api/user',
    type: 'POST',
    data: JSON.stringify({
        username: $("#username").val(),
        password: $("#password").val(),
        firstName: $("#firstName").val(),
        lastName: $("#lastName").val(),
        email: $("#email").val(),
        phone: $("#phone").val(),
        age: $("#age").val()

    }),

    async: true,
    contentType: 'application/json',
    success: successCreateCallback,
    error: errorCreateCallback

});

}

function successCreateCallback(){

	console.log("cenas");
    container.classList.add("right-panel-active");

}

function errorCreateCallback(){

    console.log("cenaserror");
    
}





