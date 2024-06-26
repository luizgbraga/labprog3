const usernameInput = document.getElementById('username-input');
const passwordInput = document.getElementById('password-input');
const registerButton = document.getElementById('register-button');
const spinner = document.getElementById('spinner');

if (localStorage.getItem('id')) {
    window.location.href = 'http://localhost:8080/server_war_exploded/feed'
}

let username = '';
let password = '';

const handleUsernameChange = (e) => {
    username = e.target.value;
}

const handlePasswordChange = (e) => {
    password = e.target.value;
}

const handleSubmit = () => {
    document.body.style.filter = "brightness(50%)";
    spinner.style.display = 'flex'
    RegisterModel.register(username, password)
        .then((res) => {
            document.body.style.filter = "brightness(100%)";
            spinner.style.display = 'none'
            const user = JSON.parse(res.message)
            console.log(user)
            localStorage.setItem("id", user.id)
            localStorage.setItem("username", user.username)
           // window.location.replace('http://localhost:8080/server_war_exploded/feed')
        })
        .catch((err) => {
            document.body.style.filter = "brightness(100%)";
            spinner.style.display = 'none'
            console.log(err);
        });
}

usernameInput.addEventListener('input', handleUsernameChange);
passwordInput.addEventListener('input', handlePasswordChange);
registerButton.addEventListener('click', handleSubmit);

class API {
    _route;
    constructor(route) {
        this._route = route;
    }

    async request(
        method,
        path,
        token,
        body,
        query
    ) {
        const qp = query ? `?${query}` : '';
        const headers = {
            'Content-Type': 'application/json',
            ...(token && { Authorization: token }),
        };
        const res = await fetch(`${this._route}/${path}${qp}`, {
            method,
            headers,
            body,
        });
        if (!res.ok && res.status !== 500) {
            throw new Error('Unexpected error occurred.');
        }
        return res.json();
    }
}

const API_URL = 'api';

class RegisterAPI extends API {
    constructor() {
        super(`${API_URL}/user`);
    }

    async register(username, password) {
        const body = JSON.stringify({username, password});
        return this.request('POST', '/register', null, body, null);
    }
}

const api = new RegisterAPI();

class RegisterModel {
    static async register(username, password) {
        const res = await api.register(username, password);
        if (res.type === 'ERROR') throw new Error(res.cause);
        return res.result;
    }
}