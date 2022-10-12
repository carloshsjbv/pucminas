import React, { useCallback, useContext } from 'react';
import { Route, Router, Switch, Redirect } from 'react-router-dom';
import { createBrowserHistory } from 'history';
import { Templates } from '../ts/enum/page-templates';
import getAppPages from '../config/pages';
import PrivateRoute from './private-route';
import { IPage } from '../ts/interfaces/IPage';
import { IModuleContext } from '../ts/interfaces/IModulesContext';
import { ModulesContext } from '../contexts/ModuleContext';

export const RouteContext: React.Context<{}> = React.createContext({});
const RouteProvider: React.FC = () => {
  const { pages, appName }: IModuleContext = useContext(ModulesContext);
  const appPages: IPage[] = getAppPages();
  const history = createBrowserHistory();

  const changeRoute = useCallback(
    (pageAlias: string, pageComplement: string) => {
      const page: IPage[] = appPages.filter(page => page.alias === pageAlias);
      if (page.length === 1) {
        const path: string | undefined = page.pop()?.path;
        pageComplement
          ? history.push(`${path}/${pageComplement}` || '')
          : history.push(path || '');
      }
    },
    [],
  );

  return (
    <RouteContext.Provider value={{ changeRoute }}>
      <Router history={history}>
        <Switch>
          {pages.map((page: IPage, index: number) => {
            return page.template === Templates.PRIVATE ? (
              <PrivateRoute
                key={`route-${index}`}
                path={page.path}
                component={page.pageComponent}
              />
            ) : (
              <Route
                key={`route-${index}`}
                path={page.path}
                component={page.pageComponent}
              />
            );
          })}
          <Redirect from="*" to={`/${appName}/login`} />
        </Switch>
      </Router>
    </RouteContext.Provider>
  );
};

export default RouteProvider;
