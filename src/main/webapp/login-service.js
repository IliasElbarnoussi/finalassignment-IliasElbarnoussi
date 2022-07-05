export default class LoginService {
    isLoggedIn() {
        //TODO: hoe ga je bepalen of iemand ingelogd is (geweest)?
        if (sessionStorage.JWT !== undefined) {
            return true
        }
        return false;
    }

    login(user, password) {
        return Promise.resolve(fetch("http://localhost:8080/restservices/auth", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({"username":user, "password":password})
        })).then((response) => {
            if (!response.ok) {
                throw new Error('Network response was not OK')
            }
            return response.json()
        });
    }

    getUser() {
        //TODO: deze GET method test je token op server-side problemen. Je kunt client-side op zich wel 'ingelogd' zijn
        //maar het zou altijd zomaar kunnen dat je token verlopen is, of dat er server-side iets anders aan de hand is.
        //Dus het is handig om te checken met een -echte fetch- of je login-token wel echt bruikbaar is.

        return Promise.resolve(fetch("http://localhost:8080/restservices/user", {
            method: "GET",
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + sessionStorage.JWT
            }
        })).then((response) => {
            if (!response.ok) {
                throw new Error('Network response was not OK')
            }
            return response.json()
        });
    }

    logout() {
        //TODO: hoe ga je eigenlijk iemand 'uitloggen'?
        return Promise.resolve(sessionStorage.removeItem("JWT"));
    }
}
