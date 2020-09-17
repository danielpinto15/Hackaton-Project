
$(document).ready(function () {


    $.ajax({
        url: 'http://localhost:8080/elixir/api/product',
        async: true,
        success: successCallback,
        error: errorCallback
    });
    $('.carousel').carousel({
        interval: 0
      })
});


function populateCarousel(productData) {

    console.log(productData);

    productData.forEach(function (elem) {

        var element = "<div id = style='max-width: 100%' class='carousel-item'>"

            + "<img src=" + "'" + elem.photoUrl + "'"

            + " class='d-block w-100' alt='...'>"

            + "<div class='carousel-caption d-none d-md-block'>"

            + "<h2  id = " + "'" + elem.id + "'" + ">" + elem.name + "</h2>"

            + "<p>" + elem.smallDescription + "</p>"

            + "<button class='btn btn-light'><a href='" + elem.id + "detailPage.html'>Product Details</a></button>"

            + "</div>"

            + "</div>";

        console.log(element);

        $(element).appendTo('#ourCarousel');

    }
    )
}



function successCallback(response) {
    populateCarousel(response);
}

function errorCallback(request, status, error) {
    // do something with the error
    //populateTable(JSON.parse(response));
}

