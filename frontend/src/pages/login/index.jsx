import * as React from 'react';
import {
    Route,
    Switch,
} from "react-router-dom";
import { FormControl } from 'react-bootstrap';
import { PageTitle } from '../../components/pageTitle/pageTitle';

export const uri = 'signin'

export class LoginIndex extends React.Component {
    onClick = async () => {
        const response = await fetch('http://localhost:8080/users/signin', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                username: this.state.login,
                password: this.state.password
            })
        });
        const res = await response.json();
        if (res.accessToken) {
            const accessToken = localStorage.setItem('accessToken', res.accessToken);
            window.location.pathname = '/';
        }
    }

    state = {
        login: '',
        password: '',
    }

    render() {
        return (
            <Switch>
                <Route exact path={`/${uri}`}>
                    <div className="container">
                        <PageTitle title="Авторизация" />
                        <div class="mb-3 col-md-5">
                            <FormControl
                                placeholder='Имя клиента'
                                value={this.state.login}
                                onChange={(e) => this.setState({ login: e.target.value })}
                                s={12}
                            />
                        </div>
                        <div class="mb-3 col-md-5">
                            <FormControl
                                placeholder='Телефон клиента'
                                value={this.state.password}
                                onChange={(e) => this.setState({ password: e.target.value })}
                                s={12}
                            />
                        </div>

                        <button onClick={this.onClick} className="btn btn-primary" type="button" name="action">Войти</button>
                    </div>
                </Route>
            </Switch>
        );
    }
}
