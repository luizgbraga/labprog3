import { API } from '../utils/model';

const API_URL = proccess.env.API_URL;

export class LoginAPI extends API {
    constructor() {
        super(`${API_URL}/user`);
    }

    async register(username, password) {
        const body = JSON.stringify({ username, password });
        return this.request('POST', 'register', null, body, null);
    }

    async login(username, password) {
        const body = JSON.stringify({ username, password });
        return this.request('POST', 'login', null, body, null);
    }
}

const api = new LoginAPI();

export class LoginModel {
    static async register(username, password) {
        const res = await api.register(username, password);
        if (res.type === 'ERROR') throw new Error(res.cause);
        return res.result;
    }

    static async login(username, password) {
        const res = await api.login(username, password);
        if (res.type === 'ERROR') throw new Error(res.cause);
        return res.result;
    }
}