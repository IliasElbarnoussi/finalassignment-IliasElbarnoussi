export default class SnakeService {
    async getSnake() {
        return Promise.resolve(fetch("http://localhost:8080/restservices/snake", {
            headers: {
                'Authorization': 'Bearer ' + sessionStorage.JWT
            }
        }).then((response) => {
            if (!response.ok) {
                throw new Error('Network response was not OK')
            }
            return response.json()
        }));
    }

    async updateSnake(updatedSnake) {
        console.log(updatedSnake);
        //TODO: update je slang aan de server-kant met de nieuwe gegevens
        return Promise.resolve(fetch("http://localhost:8080/restservices/snake/update", {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json',
                'Authorization': 'Bearer ' + sessionStorage.JWT
            },
            body: JSON.stringify(updatedSnake)
        }).then((response) => {
            if (!response.ok) {
                throw new Error('Network response was not OK')
            }
            return response.json()
        }));
    }
}