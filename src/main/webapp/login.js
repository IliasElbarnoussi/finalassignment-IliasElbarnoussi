// Deze javascript file is puur een 'voorbeeld-frontend' en -hoeft- niet aangepast te worden. In principe hoef je alleen
// de ...-service.js files in te vullen met de juiste promise-logica en dan zou de UI moeten werken.
// Uiteraard -mag- je deze files wel aanpassen, want heel fraai is deze UI nou ook weer niet:)
import LoginService from "./login-service.js";

let service = new LoginService();


function refresh() {
    if (service.isLoggedIn()) {
        document.forms.login.style = "display:none";
        document.forms.logout.style = "display:block";
    } else {
        document.forms.logout.style = "display:none";
        document.forms.login.style = "display:block";
    }
}

document.forms.login.addEventListener('submit', e => {
    e.preventDefault();
    service.login(document.forms.login.username.value, document.forms.login.password.value).then((response) => {
        sessionStorage.setItem("JWT", response.JWT);
        sessionStorage.setItem("username", document.forms.login.username.value);
        window.location.reload();
        console.log("login gedrukt")
    })

    console.log(service.getUser())


});

document.forms.logout.addEventListener('submit', e => {
    e.preventDefault();
    service.logout().then(() => {
        window.location.reload();
    });
});

refresh();

service.getUser().then(user => {
    if (!user) {
        service.logout();
    }
    refresh();
})


