$(document).ready(function () {

    function login() {
        var username = $("#userName").val();
        var contra = $("#contra").val();

        const userAction = async () => {
            const response = await fetch('http://localhost:8080/JerseyRestWs/rest/usuarios', {
                method: 'GET',
                body: {
                    "userName": username,
                    "contra": contra
                },
                headers: {
                  'Content-Type': 'application/json'
                }
            });

            if (response.json() != null) {
                window.location.href="home.html";
            }

        }
    }

});