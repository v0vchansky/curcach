import * as React from 'react';
import { Link } from "react-router-dom";

import { uri as clientUri } from '../../pages/client/index';
import { uri as staffUri } from '../../pages/staff/index';
import { uri as serviceUri } from '../../pages/service/index';
import { uri as aboutUri } from '../../pages/about/index';

export class Header extends React.Component {
    render() {
        return (

            <div className="header">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="container">
                        <a class="navbar-brand" href="#">Массажный салон</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                            data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false"
                            aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                            <div class="navbar-nav">
                                <Link className="nav-link" to="/">Записи</Link>
                                <Link className="nav-link" to={`/${staffUri}`}>Сотрудники</Link>
                                <Link className="nav-link" to={`/${serviceUri}`}>Услуги</Link>
                                <Link className="nav-link" to={`/${clientUri}`}>Клиенты</Link>
                                <Link className="nav-link" to={`/${aboutUri}`}>Об авторе</Link>
                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        )
    }
}
