export default class GamesService {
    async getGameIds() {
        //TODO: fetch alle games van de de service, idealiter zonder alle details
        return Promise.resolve(fetch("http://localhost:8080/restservices/games", {
            headers: {
                'Authorization': 'Bearer ' + sessionStorage.JWT
            }
        })
            .then((response) => {
            if (!response.ok) {
                throw new Error('Network response was not OK')
            }
            return response.json()
        }));
    }

    async getReplay(gameId) {
        //TODO: fetch de details van een enkele game. Let wel, het staat vrij wat voor informatie je precies toont
        //zolang je maar laat zien dat je data kunt opslaan over meerdere zetten heen. Dus deze dummy-data is puur
        //ter illustratie.
        return Promise.resolve(fetch(`http://localhost:8080/restservices/games/${gameId}`, {
            headers: {
                'Authorization': 'Bearer ' + sessionStorage.JWT
            }
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error('Network response was not OK')
                }
                return response.json()
            }));
    }

    async removeReplay(gameId) {
        //TODO: gebruik fetch om een enkele game (bij de server) te deleten
        return Promise.resolve(fetch(`http://localhost:8080/restservices/games/${gameId}`, {
            method:"DELETE",
            headers: {
                'Authorization': 'Bearer ' + sessionStorage.JWT
            }
        }).then((response) => {
                if (!response.ok) {
                    throw new Error('Network response was not OK')
                }
            }));
    }
}
