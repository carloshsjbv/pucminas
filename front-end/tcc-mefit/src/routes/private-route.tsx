import React from 'react';
import { Redirect, Route } from 'react-router';

const PrivateRoute: React.FC<any> = ({ component: Component, ...props }) => {
  const appEndpoint: string = 'mefit';
  const isLogged: boolean = false;
  return isLogged ? (
    <Route
      {...props}
      render={matchProps =>
        isLogged ? <div>loading</div> : <Component {...matchProps} />
      }
    />
  ) : (
    <Redirect to={`/${appEndpoint}/login`} />
  );
};

export default PrivateRoute;
