import * as React from 'react';
import { PageTitle } from '../../components/pageTitle/pageTitle';
import { simpleServer } from './../../server/simple';
import { FormControl } from 'react-bootstrap';

/* PROPS
pageTitle
formScheme
redirectUrl
uri
*/

export class PageCreate extends React.Component {
    state = {
        fields: null
    };

    componentDidMount() {
        const fields = {};

        this.props.formScheme.forEach(item => {
            fields[item.name] = ''
        });
        this.setState({ fields });
    }

    onSubmit = async () => {
        try {
            await simpleServer[this.props.uri].create(Object.assign(this.state.fields));
        } catch (e) {
            console.log(e)
        }
        finally {
            window.location.pathname = `/${this.props.uri}`;
        }
    }

    componentWillUnmount() {
        // fix Warning: Can't perform a React state update on an unmounted component
        this.setState = (state,callback)=>{
            return;
        };
    }

    render() {
        let isDisabled = false;

        this.props.formScheme.forEach((item) => {
            if (this.state.fields && !this.state.fields[item.name]) {
                isDisabled = true;
            }
        });

        return (
            <div className="container">
                <PageTitle title={this.props.pageTitle} />
                <div className="row">
                    <form className="col s12">
                        {
                            this.state.fields && this.props.formScheme.map((item, key) => (
                                <div key={key} className="row">
                                    <div class="mb-3 col-md-5">
                                        <FormControl
                                            placeholder={item.label}
                                            value={this.state.fields[item.name]}
                                            name={key}
                                            onChange={(e) => {
                                                this.setState(state => {
                                                    return {
                                                        ...state,
                                                        fields: {
                                                            ...state.fields,
                                                            [item.name]: e.target.value
                                                        }
                                                    }
                                                });
                                            }}
                                            s={12}
                                        />
                                    </div>
                                </div>
                            ))
                        }
                        <button disabled={isDisabled} onClick={this.onSubmit} className="btn btn-primary" type="button" name="action">Добавить</button>
                    </form>
                </div>
            </div>
        );
    }
}
