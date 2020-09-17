$(document).ready(function () {


    $.ajax({
        url: 'http://localhost:8080/elixir/api/user/current',
        async: true,
        success: successCallback,
        error: errorCallback
    });

});


function successCallback(response) {
    populateUserTable(response);
}

function errorCallback(request, status, error) {
    // do something with the error
    //populateTable(JSON.parse(response));
}

function populateUserTable(customer) {

    

        var element = "<tr><td>" + customer.username + "</td> <td>" + customer.firstName + "</td> <td>" + customer.lastName + "</td> <td>" + customer.age + "</td> <td>" + customer.email + "</td><td>" + customer.phone + "</td></tr>";
        $(element).appendTo('#userTable');

    }
    



