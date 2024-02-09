/*!
* Start Bootstrap - Agency v7.0.12 (https://startbootstrap.com/theme/agency)
* Copyright 2013-2023 Start Bootstrap
* Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-agency/blob/master/LICENSE)
*/
//
// Scripts
// 

window.addEventListener('DOMContentLoaded', event => {

    // Navbar shrink function
    var navbarShrink = function () {
        const navbarCollapsible = document.body.querySelector('#mainNav');
        if (!navbarCollapsible) {
            return;
        }
        if (window.scrollY === 0) {
            navbarCollapsible.classList.remove('navbar-shrink')
        } else {
            navbarCollapsible.classList.add('navbar-shrink')
        }

    };

    // Shrink the navbar 
    navbarShrink();

    // Shrink the navbar when page is scrolled
    document.addEventListener('scroll', navbarShrink);

    //  Activate Bootstrap scrollspy on the main nav element
    const mainNav = document.body.querySelector('#mainNav');
    if (mainNav) {
        new bootstrap.ScrollSpy(document.body, {
            target: '#mainNav',
            rootMargin: '0px 0px -40%',
        });
    };

    // Collapse responsive navbar when toggler is visible
    const navbarToggler = document.body.querySelector('.navbar-toggler');
    const responsiveNavItems = [].slice.call(
        document.querySelectorAll('#navbarResponsive .nav-link')
    );
    responsiveNavItems.map(function (responsiveNavItem) {
        responsiveNavItem.addEventListener('click', () => {
            if (window.getComputedStyle(navbarToggler).display !== 'none') {
                navbarToggler.click();
            }
        });
    });

});

/*$( "#contactForm" ).submit(function( event ) {
	var formJqObj = $("#contact-form");
    var formDataObj = {};
    (function(){
        formJqObj.find(":input").not("[type='submit']").not("[type='reset']").each(function(){
            var thisInput = $(this);
            formDataObj[thisInput.attr("name")] = thisInput.val();
        });
    })();
	var request = $.ajax({
		type: "POST",
		url: "user/sendmail",
		data: JSON.stringify(formDataObj),
		contentType:"application/json",
		dataType: "json",
		success: function(data) {
			console.log("The request is successfull "+data);
		}
	})
	request.done(function( msg ) {
//		$("#response_id").text(msg.message);
		$('#contactForm').trigger("reset");
	  });
	request.fail(function( jqXHR, textStatus ) {
	alert( "Request failed: " + textStatus );
	});
    event.preventDefault();

	return true;
  });*/
